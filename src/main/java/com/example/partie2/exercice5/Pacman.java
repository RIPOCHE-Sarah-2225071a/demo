package com.example.partie2.exercice5;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class Pacman extends Personnage {

    private Line bouche;


    public Pacman() {
        super("droite", Color.BLACK, Color.YELLOW);
        bouche = new Line(LARGEUR_MOITIE_PERSONNAGE, LARGEUR_MOITIE_PERSONNAGE, (LARGEUR_MOITIE_PERSONNAGE * 2) - .5, LARGEUR_MOITIE_PERSONNAGE);
        bouche.setFill(Color.BLACK);

        super.getChildren().add(bouche);
    }

    @Override
    public void deplacerAGauche(ArrayList<Obstacle> obstacles) {
        super.deplacerAGauche(obstacles);
        //sens de la bouche
        bouche.setEndX(bouche.getStartX() - LARGEUR_MOITIE_PERSONNAGE + .5);
        bouche.setEndY(bouche.getStartY());
    }

    @Override
    public void deplacerADroite(double largeurJeu, ArrayList<Obstacle> obstacles) {
        super.deplacerADroite(largeurJeu, obstacles);
        //sens de la bouche
        bouche.setEndX(bouche.getStartX() + LARGEUR_MOITIE_PERSONNAGE - .5);
        bouche.setEndY(bouche.getStartY());
    }

    @Override
    public void deplacerEnBas(double hauteurJeu, ArrayList<Obstacle> obstacles) {
        // à compléter
        super.deplacerEnBas(hauteurJeu, obstacles);
        //sens de la bouche
        bouche.setEndX(bouche.getStartX());
        bouche.setEndY(bouche.getStartY() + LARGEUR_MOITIE_PERSONNAGE - .5);
    }

    @Override
    public void deplacerEnHaut(double hauteurJeu, ArrayList<Obstacle> obstacles) {
        // à compléter
        super.deplacerEnHaut(hauteurJeu, obstacles);
        //sens de la bouche
        bouche.setEndX(bouche.getStartX());
        bouche.setEndY(bouche.getStartY() - LARGEUR_MOITIE_PERSONNAGE - .5);
    }

}
