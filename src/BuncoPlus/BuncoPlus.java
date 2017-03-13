package BuncoPlus;

import Framework.*;

/**
 * Created by Alexandre on 2017-03-12.
 */
public class BuncoPlus extends Jeu{

    /**
     * Constructeur de la classe BuncoPlus.
     */
    public BuncoPlus(CollectionDes des, CollectionJoueurs joueurs, IStrategie regles) {

        super(des, joueurs, regles);
        nbTours = 6;
    }

    /**
     * Méthode qui fait dérouler une partie
     */
    public void jouer(){

        Iterateur iterateur;
        boolean prochain;

        while(tour <= nbTours){

            iterateur = joueurs.createIterateur();

            System.out.println("\nTour: " + tour);

            do{

                joueur = (Joueur) iterateur.next();

                System.out.println("*****************");
                System.out.println(joueur.getNom());

                do {

                    roulerDes();
                    afficherDes();
                    prochain = calculerScoreTour();

                } while(!prochain);

                System.out.println("Score cumulé: " + joueur.getScore());
                System.out.println("*****************");
                System.out.println();

            }while(iterateur.hasNext());

            tour++;
        }

        calculerLeVainqueur();
        afficherJoueurs();
    }

    public void roulerDes(){

        Iterateur iterateur = des.createIterateur();

        while(iterateur.hasNext()){

            De de = (De)iterateur.next();
            de.rouler();
        }
    }

    public void afficherDes(){

        Iterateur iterateur = des.createIterateur();

        while(iterateur.hasNext()){

            De de = (De)iterateur.next();
            System.out.print(de.getFace() + " ");
        }

        System.out.println();
    }

    public void afficherJoueurs(){

        Iterateur iterateur = joueurs.createIterateur();

        while(iterateur.hasNext()){

            Joueur joueur = (Joueur) iterateur.next();
            System.out.println(joueur.getNom() + ": " + joueur.getScore());
        }
    }
}
