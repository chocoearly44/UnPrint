package net.thesuperlab.unprint.indexers.bitwarden.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Login {
	private String username;
	private List<Uri> uris;

	public Login() {
	}
}
