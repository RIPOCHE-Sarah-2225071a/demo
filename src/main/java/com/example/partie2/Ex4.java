package com.example.partie2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Ex4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Creation du label en haut
        Label lHaut = new Label();

        // Creation du pane du milieu
        Pane milieu = new Pane();

        // Creation de la hbox du bas
        HBox hBas = new HBox();
        hBas.setAlignment(Pos.CENTER);
        hBas.setSpacing(10);
        hBas.setMinHeight(40);

        // Creation des boutons de la hbox
        Button vert = new Button("Vert");
        Button rouge = new Button("Rouge");
        Button bleu = new Button("Bleu");

        hBas.getChildren().addAll(vert, rouge, bleu);

        // Creation du borderPane
        BorderPane bp = new BorderPane();
        bp.setTop(lHaut);
        BorderPane.setAlignment(lHaut, Pos.CENTER);
        bp.setCenter(milieu);
        bp.setBottom(hBas);

        // Changement du texte après un clic sur le bouton
        vert.addEventHandler(MouseEvent.MOUSE_CLICKED,  new ButtonClickHandler2(lHaut, vert, milieu) );
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED,  new ButtonClickHandler2(lHaut, rouge, milieu) );
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED,  new ButtonClickHandler2(lHaut, bleu, milieu) );

        // Création de la scene
        Scene scene = new Scene( bp );

        // Ajout de la scene à la fenêtre
        primaryStage.setScene( scene );

        primaryStage.setTitle("Hello application");
        primaryStage.setWidth(400);
        primaryStage.setHeight(200);
        primaryStage.show();
    }
}
