package net.thesuperlab.unprint.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Site {
	private String domain;

	public Site() {
	}

	public Site(String domain) {
		this.domain = domain;
	}

	@JsonIgnore
	public List<Account> getAccounts() {
		return null;
	}
}
