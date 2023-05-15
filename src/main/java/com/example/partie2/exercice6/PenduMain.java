package com.example.partie2.exercice6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static javafx.application.Application.launch;

public class PenduMain extends Application{
    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage primaryStage) {
        // Creation du mot a deviner
        Dico mot = new Dico();
        System.out.println(mot.getMot());
        //mot = mot.getMot();
        String etoiles = "*";
        System.out.println(mot.getMot().length());
        for (int i = 1; i<mot.getMot().length(); ++i){
            etoiles += "*";
        }
        Label motCache = new Label(etoiles);


        //ArrayList<Integer> test = mot.getPositions();


        // Creation du textfield pour remlir la lettre
        TextField input = new TextField("lettre");


        // Creation d un vbox ( avec le pendu, le nb de vie, le mot et le clavier(pour l'instant le textfield))
        VBox root = new VBox();
        root.getChildren().addAll(motCache, input);

        // Créer une scène
        //StackPane root = new StackPane();
        Scene scene = new Scene(root);

        // Définir la scène principale de l'application
        primaryStage.setScene(scene);
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        primaryStage.show();
    }

    public void jeu(){
        // Choix du mot


    }
}










