package com.internshala.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyMain extends Application {
		public static void main(String[] args){
			launch(args);
		}

	@Override
	public void init() throws Exception {
		System.out.println("init");
			super.init();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("start");
			FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
		MenuBar menuBar=createMenu();
		rootNode.getChildren().add(0,menuBar);
		Scene scene = new Scene(rootNode, 300, 275);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temparature Converter");
		primaryStage.show();
	}
	private MenuBar createMenu(){
			Menu fileMenu=new Menu("File");
			MenuItem newMenuItem=new MenuItem("New");
			newMenuItem.setOnAction(event -> System.out.println("new clicked")
			);

			SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
			MenuItem quitMenuItem=new MenuItem("Quit");
			quitMenuItem.setOnAction(event -> {
				Platform.exit();
				System.exit(0);
			});
		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);
			Menu helpMenu=new Menu("Help");
			MenuItem aboutAppMenuItem=new MenuItem("AboutApp");
			aboutAppMenuItem.setOnAction(event -> aboutApp());
					helpMenu.getItems().addAll(aboutAppMenuItem);
			MenuBar menuBar=new MenuBar();
			menuBar.getMenus().addAll(fileMenu,helpMenu);
			return menuBar;
	}

	public static void aboutApp() {
		Alert alertDialog=new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My First App");
		alertDialog.setHeaderText("Learning JavaFX");
		alertDialog.setContentText("this app is designed by surya from suryapet");
		alertDialog.show();
	}

	@Override
	public void stop() throws Exception {
		System.out.println("stop");
			super.stop();

	}
}
