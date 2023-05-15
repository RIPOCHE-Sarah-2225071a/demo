package com.example.partie2.exercice5;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

class Personnage extends Group {
    protected final static double LARGEUR_MOITIE_PERSONNAGE = 10;
    protected final static double LARGEUR_PERSONNAGE = LARGEUR_MOITIE_PERSONNAGE * 2;
    private final Circle corps;
    private String direction;

    public Personnage(String direction, Color couleurContour, Color couleurRemplissage) {
        this.direction = direction;
        corps = new Circle(10, 10, LARGEUR_MOITIE_PERSONNAGE, couleurContour);
        corps.setFill(couleurRemplissage);
        getChildren().add(corps);
    }

    public boolean isObstacle(double x, double y, ArrayList<Obstacle> obstacles ){
        for(int i = 0; i<obstacles.size(); ++i){
            if (obstacles.get(i).getX() == x && obstacles.get(i).getY() == y){
                return true;
            }
        }
        return false;

    }

    public void deplacerAGauche(ArrayList<Obstacle> obstacles) {
        //    ****
        //   *    *
        //  *---   *
        //   *    *
        //    ****

        double tempX = getLayoutX();
        //déplacement <----
        if (getLayoutX() >= LARGEUR_PERSONNAGE) {
            setLayoutX(getLayoutX() - LARGEUR_PERSONNAGE);
        }
        if (isObstacle(getLayoutX(), getLayoutY(), obstacles)){
            setLayoutX(tempX);
        }
        if (!direction.equals("gauche")) {
            direction = "gauche";
        }
    }

    public void deplacerADroite(double largeurJeu, ArrayList<Obstacle> obstacles) {
        //    ****
        //   *    *
        //  *   ---*
        //   *    *
        //    ****
        //déplacement ---->
        double tempX = getLayoutX();
        if (getLayoutX() < largeurJeu - LARGEUR_PERSONNAGE) {
            setLayoutX(getLayoutX() + LARGEUR_PERSONNAGE);
        }
        if (isObstacle(getLayoutX(), getLayoutY(), obstacles)){
            setLayoutX(tempX);
        }
        if (!direction.equals("droite")) {
            direction = "droite";
        }
    }

    public void deplacerEnBas(double hauteurJeu, ArrayList<Obstacle> obstacles) {
        //    *****
        //   *     *
        //  *   |   *
        //   *  |  *
        //    *****
        double tempY = getLayoutY();
        if (getLayoutY() <= hauteurJeu - LARGEUR_PERSONNAGE) {
            setLayoutY(getLayoutY() + LARGEUR_PERSONNAGE);
        }
        if (isObstacle(getLayoutX(), getLayoutY(), obstacles)){
            setLayoutY(tempY);
        }
        if (!direction.equals("bas")) {
            direction = "bas";
        }
    }

    public void deplacerEnHaut(double hauteurJeu, ArrayList<Obstacle> obstacles) {
        //    *****
        //   *  |  *
        //  *   |   *
        //   *     *
        //    *****
        double tempY = getLayoutY();
        if (getLayoutY() < hauteurJeu - LARGEUR_PERSONNAGE) {
            setLayoutY(getLayoutY() - LARGEUR_PERSONNAGE);
        }
        if (isObstacle(getLayoutX(), getLayoutY(), obstacles)){
            setLayoutY(tempY);
        }
        if (!direction.equals("haut")) {
            direction = "haut";
        }
    }

    boolean estEnCollision(Personnage autrePersonnage) {
        return getBoundsInParent().contains(autrePersonnage.getBoundsInParent())
                || autrePersonnage.getBoundsInParent().contains(getBoundsInParent());
    }

}
