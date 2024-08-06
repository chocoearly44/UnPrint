package net.thesuperlab.unprint.services;

import net.thesuperlab.unprint.models.Site;

import static net.thesuperlab.unprint.Main.workspace;
import static net.thesuperlab.unprint.Main.workspaceConfigurator;

public class SiteService {
	private SiteService() {
	}

	public static Site getSite(String domain) {
		return workspace.getSites().stream()
				.filter(site -> site.getDomain().equals(domain))
				.findFirst()
				.orElse(null);
	}

	public static void addSite(Site site) {
		workspace.getSites().add(site);
		workspaceConfigurator.saveConfig("config.json", workspace);
	}
}
