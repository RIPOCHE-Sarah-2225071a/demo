package com.example.partie1;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ex2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    	
    	// Création du GridPane
    	GridPane grid = new GridPane();
    	
    	// Creation des labels et regroupement dans un tableau
    	Label l00 = new Label();
    	Label l01 = new Label();
    	Label l02 = new Label();
    	Label l10 = new Label();
    	Label l11 = new Label();
    	Label l12 = new Label();
    	Label l20 = new Label();
    	Label l21 = new Label();
    	Label l22 = new Label();
    	Label[] listeLabels = {l00, l01, l02, l10 , l11, l12, l20, l21 ,l22};
    	
    	// Attribution des images et positionnement dans la grille
    	for (int i = 0; i<9; i= i+3) {
    		for (int j = 0; j<3; ++j) {
    			listeLabels[i+j] = choix(listeLabels[i+j]);
    			listeLabels[i+j].setStyle("-fx-border-color: lightgrey;");
    			GridPane.setConstraints(listeLabels[i+j], j, i/3); // column=j row=i
    		}	
    	}
    	grid.getChildren().addAll(listeLabels);
        
        // Définir la scène principale de l'application 
    	Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        //primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.show();
    }
    
    // Fonction qui permet de choisir aléatiorement le contenu d'une case
    private Label choix(Label l) {
    	Random random = new Random();
    	int nombre = random.nextInt(3);
    	switch(nombre) {
    		case 0:
				ImageView croix = new ImageView(Ex2.class.getResource("exercice2/Croix.png").toString() );
				l.setGraphic(croix);
    		break;
			case 1:
				ImageView rond = new ImageView(Ex2.class.getResource("exercice2/Rond.png").toString() );
				l.setGraphic(rond);
    		break;
    		case 2:
				ImageView vide = new ImageView(Ex2.class.getResource("exercice2/Vide.png").toString() );
				l.setGraphic(vide);
    		break;
    	}
    	return l;
    }
}

