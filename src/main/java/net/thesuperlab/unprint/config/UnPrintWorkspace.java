package net.thesuperlab.unprint.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.thesuperlab.unprint.models.Account;
import net.thesuperlab.unprint.models.Site;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class UnPrintWorkspace {
	private List<Site> sites;
	private List<Account> accounts;

	public UnPrintWorkspace() {
		this.sites = new ArrayList<>();
		this.accounts = new ArrayList<>();
	}
}
