/*******************************************************************************
Cours:   LOG121
Session: H2017
Groupe:  02
Projet: Laboratoire #3
�tudiant(e)s: Vanessa Baquero
			  Nam Vu
			  Alexandre Trepanier             
              
Professeur : Francis Cardinal 
Nom du fichier: (BuncoPlus) package-info.java
Date cr��: 2017-03-06
Date dern. modif. 2017-03-11
********************************************************************************
Historique des modifications
********************************************************************************
2017-03-06 Version initiale (Alexandre)
2017-03-11 CalculVainqueur (vanessa)
*******************************************************************************/
package BuncoPlus;

import Framework.*;


public class ReglesBunco implements IStrategie{

	public  CollectionJoueurs calculerLeVainqueur(Jeu jeu) {

		boolean check;
		CollectionJoueurs joueurs = jeu.getJoueurs();

		Joueur joueur;
		Joueur joueur2;
		Iterateur iterateur;
		Iterateur iterateur2;

		do{

			check = true;
			iterateur = joueurs.createIterateur();
			iterateur2 = joueurs.createIterateur();

			iterateur2.next();

			do{

				joueur = (Joueur)iterateur.next();
				joueur2 = (Joueur)iterateur2.next();

				if(joueur.compareTo(joueur2) == -1) {
					joueurs.swap(joueur, joueur2);
					check = false;
				}

			}while(iterateur2.hasNext());

		}while(!check);

		return joueurs;
    }

public void calculerScoreTour(Jeu jeu) {

    	int score=1;
    	boolean changer = true;
    	CollectionDes des = jeu.getDes();
    	int tour = jeu.getTour();
    	Joueur joueur = new Joueur("bitch");

		Iterateur iterateur = des.createIterateur();

		while(iterateur.hasNext()){

			De de = (De)iterateur.next();
			de.rouler();

			if(de.getFace() == tour)
				score++;
		}

		if(score == 3)
			score = 21;
		else if(score == 0){
			iterateur = des.createIterateur();

			De de1 = (De)iterateur.next();
			De de2 = (De)iterateur.next();
			De de3 = (De)iterateur.next();

			if((de1.compareTo(de2) == 0) && (de2.compareTo(de3) == 0))
				score = 5;
		}

		System.out.println("score: " + score);

		joueur.incrementerScore(score);

		System.out.println("score cumulatif: " + joueur.getScore());

		if(score == 21 || score == 0){
			changer = false;
		}

		changer= true;
    }
}
