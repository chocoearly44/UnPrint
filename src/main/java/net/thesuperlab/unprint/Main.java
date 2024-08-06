package net.thesuperlab.unprint;

import atlantafx.base.theme.Dracula;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.thesuperlab.unprint.config.UnPrintWorkspace;
import tk.thesuperlab.nitron.config.AppDetails;
import tk.thesuperlab.nitron.config.GlobalConfigurator;
import tk.thesuperlab.nitron.config.WorkspaceConfig;
import tk.thesuperlab.nitron.config.WorkspaceConfigurator;

import java.io.IOException;

public class Main extends Application {
	public static GlobalConfigurator<WorkspaceConfig> globalConfigurator;
	public static WorkspaceConfig globalConfig;

	public static WorkspaceConfigurator workspaceConfigurator;
	public static UnPrintWorkspace workspace;

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws IOException {
		// Load config and workspace
		globalConfigurator = GlobalConfigurator.getInstance(new AppDetails("UnPrint", "unprint"), WorkspaceConfig.class);
		globalConfig = globalConfigurator.loadConfig();

		workspaceConfigurator = WorkspaceConfigurator.getInstance(globalConfig);
		workspace = workspaceConfigurator.getConfig("config.json", UnPrintWorkspace.class);

		Application.setUserAgentStylesheet(new Dracula().getUserAgentStylesheet());

		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("dashboard.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 320, 240);
		stage.setTitle("Hello!");
		stage.setScene(scene);
		stage.show();
	}
}