package com.example.partie2.exercice5;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;

    private static ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>(5);

    // Creation des obstacles (ils doivent avoir des coos multiples de 20 pour etre alignes)
    private Obstacle o1 = new Obstacle(20, 20, 20, 20);

    private int timerCount = 10;

    private boolean winFantome = true;


    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();
        scene = new Scene(root);


        // Ajout des obstacles
        obstacles.add(o1);
        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        jeu.getChildren().addAll(obstacles);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels

        //Gestion du déplacement du personnage
        // Timer
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run()
            {

                Label lFinFan = new Label("Game over, le fantome a gagne");
                //root.getChildren().add(lFinFan);
                root.setCenter(lFinFan);
            }
        },10000l);

        deplacer(pacman, fantome);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();



    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche(obstacles);
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth(), obstacles);
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight(), obstacles);
                    break;
                case UP:
                    j1.deplacerEnHaut(scene.getHeight(), obstacles);
                    break;
                case Q:
                    j2.deplacerAGauche(obstacles);
                    break;
                case Z:
                    j2.deplacerEnHaut(scene.getHeight(), obstacles);
                    break;
                case S:
                    j2.deplacerEnBas(scene.getHeight(), obstacles);
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth(), obstacles);
                    break;
            }
            if (j1.estEnCollision(j2)) {
                System.out.println("Collision....");
                Label lFin = new Label("Game over, PacMan a gagne");
                root.setCenter(lFin);
            }
        });
    }


}
