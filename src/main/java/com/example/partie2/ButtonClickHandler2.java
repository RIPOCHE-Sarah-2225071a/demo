package com.example.partie2;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class ButtonClickHandler2 implements EventHandler<Event> {

    private Label lHaut;
    private Button bouton;
    private Pane milieu;
    private static int nbVert = 0;
    private static int nbRouge = 0;
    private static int nbBleu = 0;


    public ButtonClickHandler2(Label lHaut, Button bouton, Pane milieu) {
        this.lHaut = lHaut;
        this.bouton = bouton;
        this.milieu = milieu;
    }

    @Override
    public void handle(Event event) {
        if (bouton.getText() == "Vert"){
            ++nbVert;
            lHaut.setText("Vert choisi " + nbVert + " fois");
            milieu.setStyle("-fx-background-color: green");
        } else if (bouton.getText() == "Rouge"){
            ++nbRouge;
            lHaut.setText("Rouge choisi " + nbRouge+ " fois");
            milieu.setStyle("-fx-background-color: red");
        } else if (bouton.getText() == "Bleu"){
            ++nbBleu;
            lHaut.setText("Bleu choisi " + nbBleu + " fois");
            milieu.setStyle("-fx-background-color: blue");
        }
    }
}
