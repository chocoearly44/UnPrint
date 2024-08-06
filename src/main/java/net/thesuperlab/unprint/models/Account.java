package net.thesuperlab.unprint.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Account {
	private List<Site> sites;
	private String username;

	public Account() {
		this.sites = new ArrayList<>();
	}

	public Account(List<Site> sites, String username) {
		this.sites = sites;
		this.username = username;
	}
}
