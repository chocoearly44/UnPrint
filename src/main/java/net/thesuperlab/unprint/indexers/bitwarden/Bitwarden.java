package net.thesuperlab.unprint.indexers.bitwarden;

import net.thesuperlab.unprint.indexers.bitwarden.models.Item;
import net.thesuperlab.unprint.indexers.bitwarden.models.Login;
import net.thesuperlab.unprint.indexers.bitwarden.models.Uri;
import net.thesuperlab.unprint.indexers.bitwarden.models.Vault;
import net.thesuperlab.unprint.models.Account;
import net.thesuperlab.unprint.models.Site;
import net.thesuperlab.unprint.services.SiteService;
import tk.thesuperlab.nitron.utils.JsonConfigUtils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static net.thesuperlab.unprint.Main.workspace;
import static net.thesuperlab.unprint.Main.workspaceConfigurator;

public class Bitwarden {
	public void goGoGo() {
		try {
			Vault vault = JsonConfigUtils.loadConfig(
					new File("/home/jurij/Documents/bitwarden_export_20240805165429.json"),
					Vault.class
			);

			for(Item item : vault.getItems()) {
				if(item.getType() != 1) {
					continue;
				}

				Login login = item.getLogin();
				if(login == null) {
					continue;
				}

				// Save sites
				ArrayList<Site> sites = new ArrayList<>();
				for(Uri uri : login.getUris()) {
					if(uri == null) {
						continue;
					}

					String domainName = getDomainName(uri.getUri());
					Site site = SiteService.getSite(domainName);

					if(site == null) {
						site = new Site(domainName);
						SiteService.addSite(site);
					}

					sites.add(site);
				}

				workspace.getAccounts().add(new Account(sites, login.getUsername()));
			}

			workspaceConfigurator.saveConfig("config.json", workspace);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	private static String getDomainName(String url) {
		// IPv4 check
		if(url.matches("\\d+\\.\\d+\\.\\d+\\.\\d+")) {
			return url;
		}

		// IPv6 check
		if(url.matches("\\[.*\\]")) {
			return url;
		}

		try {
			URI uri = new URI(url);
			String domain = uri.getHost();
			if(domain != null) {
				return domain.startsWith("www.") ? domain.substring(4) : domain;
			}
		} catch(URISyntaxException e) {
			e.printStackTrace();
		}

		return null;
	}
}
