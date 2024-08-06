package net.thesuperlab.unprint.indexers.bitwarden.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
	private Login login;
	private Integer type;

	public Item() {
	}
}
