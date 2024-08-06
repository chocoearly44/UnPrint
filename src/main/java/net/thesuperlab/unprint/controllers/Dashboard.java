package net.thesuperlab.unprint.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import net.thesuperlab.unprint.indexers.bitwarden.Bitwarden;
import net.thesuperlab.unprint.models.Account;

import static net.thesuperlab.unprint.Main.workspace;

public class Dashboard {
	@FXML
	private ListView<Account> listView;

	@FXML
	public void initialize() {
		reload();
	}

	@FXML
	public void onIndexClicked() {
		Bitwarden bitwarden = new Bitwarden();
		bitwarden.goGoGo();
		reload();
	}

	private void reload() {
		listView.getItems().clear();
		listView.getItems().addAll(workspace.getAccounts());
		listView.refresh();
	}
}