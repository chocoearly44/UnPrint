package net.thesuperlab.unprint.indexers.bitwarden.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Vault {
	private boolean encrypted;
	private List<Item> items;

	public Vault() {
	}
}
