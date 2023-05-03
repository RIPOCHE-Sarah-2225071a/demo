package com.example.partie1;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Ex1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Création du conteneur principal
        VBox vbox = new VBox();

        // Creer les sous-menus
        // Pour File :
        MenuItem newFile = new MenuItem("New");
        MenuItem open = new MenuItem("Open");
        MenuItem save = new MenuItem("Save");
        MenuItem close = new MenuItem("Close");

        // Pour Edit :
        MenuItem cut = new MenuItem("Cut");
        MenuItem copy = new MenuItem("Copy");
        MenuItem paste = new MenuItem("Paste");

        // Separateurs :
        SeparatorMenuItem separator = new SeparatorMenuItem();
        SeparatorMenuItem separator2 = new SeparatorMenuItem();
        SeparatorMenuItem separator3 = new SeparatorMenuItem();

        // Creer la barre de menu
        Menu file = new Menu("File");
        file.getItems().addAll(newFile, separator, open, separator2, save, separator3, close);
        Menu edit = new Menu("Edit");
        edit.getItems().addAll(cut, /*separator,*/ copy, /*separator2,*/ paste);
        Menu help = new Menu("Help");

        MenuBar menuBar = new MenuBar(file, edit, help);

        // Création du conteneur central (boutons + formulaire)
        HBox hbox = new HBox();

        // Creation du conteneur pour les boutons
        VBox boutons = new VBox();
        boutons.setVgrow(hbox, Priority.ALWAYS );
        boutons.setAlignment( Pos.CENTER );
        boutons.setSpacing(10);

        // Creation des boutons et du label
        Label bt = new Label("Boutons : ");
        Button b1 = new Button("Bouton 1");
        Button b2 = new Button("Bouton 2");
        Button b3 = new Button("Bouton 3");
        boutons.getChildren().addAll(bt, b1, b2, b3);

        // Creation du conteneur pour le formulaire
        VBox centre = new VBox();
        centre.setVgrow(hbox, Priority.ALWAYS);
        centre.setAlignment(Pos.CENTER);
        GridPane gridpane = new GridPane();
        gridpane.setAlignment(Pos.CENTER);

        // Creation du contenu du formulaire
        Label nameLabel = new Label("Name:");
        Label emailLabel = new Label("Email:");
        Label passwordLabel = new Label("Password:");

        TextField nameField = new TextField();
        TextField emailField = new TextField();
        TextField passwordField = new PasswordField();



        GridPane.setConstraints(nameLabel, 0, 0); // column=0 row=0
        GridPane.setConstraints(emailLabel, 0, 1);
        GridPane.setConstraints(passwordLabel, 0, 2);

        GridPane.setConstraints(nameField, 1, 0);
        GridPane.setConstraints(emailField, 1, 1);
        GridPane.setConstraints(passwordField, 1, 2);

        gridpane.setHgap(15);
        gridpane.setVgap(8);
        gridpane.getChildren().addAll(nameLabel, emailLabel, passwordLabel, nameField, emailField, passwordField);


        // Creation et ajout des boutons submits et cancel
        Button submit = new Button("Submit");
        Button cancel = new Button("Cancel");
        HBox subcan = new HBox(submit, cancel);
        subcan.setHgrow(centre, Priority.ALWAYS);
        subcan.setAlignment(Pos.CENTER);
        subcan.setSpacing(10);

        centre.getChildren().addAll(gridpane, subcan);

        // Creation du separateur
        Separator sep = new Separator(Orientation.VERTICAL);
        // Ajout des elements dans le conteneur
        hbox.getChildren().addAll(boutons, sep, centre);

        // Creation du label de bas de page

        Label labelBas = new Label("Ceci est un label de bas de page");
        Separator sep2 = new Separator(Orientation.HORIZONTAL);
        VBox basPage = new VBox(sep2, labelBas);
        basPage.setAlignment(Pos.CENTER);

        // Ajout du conteneur à la scene
        vbox.getChildren().addAll(
                menuBar, hbox, basPage
        );
        Scene scene = new Scene(vbox );

        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene( scene );
        primaryStage.setWidth( 800 );
        primaryStage.setHeight( 600 );
        primaryStage.setTitle("Premier exemple de manipulation du conteneur");

        // Affichage de la fenêtre
        primaryStage.show();
    }
}

