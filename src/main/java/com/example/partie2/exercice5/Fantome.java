package com.example.partie2.exercice5;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Fantome extends Personnage {

    private Rectangle basCorps;


    private Circle oeilGauche;
    private Circle retineGauche;

    private Circle oeilDroit;
    private Circle retineDroite;
    private String direction;


    public Fantome() {
        super("droite", Color.BLUE, Color.BLUE);
        basCorps = new Rectangle(0, 10, 20, 10);
        basCorps.setFill(Color.BLUE);

        oeilGauche = new Circle(6, 6, 2, Color.WHITE);
        //regarde vers la droite
        retineGauche = new Circle(oeilGauche.getCenterX() + 1, 6, 1, Color.BLACK);

        oeilDroit = new Circle(14, 6, 2, Color.WHITE);
        //regarde vers la droite
        retineDroite = new Circle(oeilDroit.getCenterX() + 1, 6, 1, Color.BLACK);


        super.getChildren().add(basCorps);
        super.getChildren().add(oeilGauche);
        super.getChildren().add(retineGauche);
        super.getChildren().add(oeilDroit);
        super.getChildren().add(retineDroite);
    }

    @Override
    public void deplacerAGauche(ArrayList<Obstacle> obstacles) {
        super.deplacerAGauche(obstacles);
        retineGauche.setCenterX(oeilGauche.getCenterX() - 1);
        retineDroite.setCenterX(oeilDroit.getCenterX() - 1);
        // Pour eviter de regarder en diagonale
        retineGauche.setCenterY(oeilGauche.getCenterY());
        retineDroite.setCenterY(oeilDroit.getCenterY());
    }

    @Override
    public void deplacerADroite(double largeurJeu, ArrayList<Obstacle> obstacles) {
        super.deplacerADroite(largeurJeu, obstacles);
        retineGauche.setCenterX(oeilGauche.getCenterX() + 1);
        retineDroite.setCenterX(oeilDroit.getCenterX() + 1);
        // Pour eviter de regarder en diagonale
        retineGauche.setCenterY(oeilGauche.getCenterY());
        retineDroite.setCenterY(oeilDroit.getCenterY());
    }

    @Override
    public void deplacerEnBas(double hauteurJeu, ArrayList<Obstacle> obstacles) {
        super.deplacerEnBas(hauteurJeu, obstacles);
        retineGauche.setCenterY(oeilGauche.getCenterY() + 1);
        retineDroite.setCenterY(oeilDroit.getCenterY() + 1);
        // Pour eviter de regarder en diagonale
        retineGauche.setCenterX(oeilGauche.getCenterX());
        retineDroite.setCenterX(oeilDroit.getCenterX());
    }

    @Override
    public void deplacerEnHaut(double hauteurJeu, ArrayList<Obstacle> obstacles) {
        super.deplacerEnHaut(hauteurJeu, obstacles);
        retineGauche.setCenterY(oeilGauche.getCenterY() - 1);
        retineDroite.setCenterY(oeilDroit.getCenterY() - 1);
        // Pour eviter de regarder en diagonale
        retineGauche.setCenterX(oeilGauche.getCenterX());
        retineDroite.setCenterX(oeilDroit.getCenterX());
    }


}
