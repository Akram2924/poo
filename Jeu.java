package jeu_test_MK;

import java.util.Scanner;

public class Jeu {

    public static void main(String[] args) {
      
        Personnage scorpion = new Personnage("Scorpion", 100, 20, "Spear Attack", 30);
        Personnage subZero = new Personnage("Sub-Zero", 100, 18, "Ice Blast", 28);
        Personnage raiden = new Personnage("Raiden", 120, 15, "Thunderstorm", 35);
        Personnage liuKang = new Personnage("Liu Kang", 110, 17, "Dragon Fire", 25);
        Personnage johnnyCage = new Personnage("Johnny Cage", 90, 22, "Nut Punch", 40);

       
        Soin potion = new Soin(30);

        Scanner scanner = new Scanner(System.in);

       
        System.out.println("Choisissez votre personnage: ");
        System.out.println("1. Scorpion");
        System.out.println("2. Sub-Zero");
        System.out.println("3. Raiden");
        System.out.println("4. Liu Kang");
        System.out.println("5. Johnny Cage");

        int choix = scanner.nextInt();
        Personnage joueur = null;
        switch (choix) {
            case 1: joueur = scorpion; break;
            case 2: joueur = subZero; break;
            case 3: joueur = raiden; break;
            case 4: joueur = liuKang; break;
            case 5: joueur = johnnyCage; break;
            default: System.out.println("Choix invalide, le jeu va se terminer."); return;
        }

       
        Personnage ennemi = null;
        if (joueur == scorpion) ennemi = subZero;
        else if (joueur == subZero) ennemi = scorpion;
        else if (joueur == raiden) ennemi = liuKang;
        else if (joueur == liuKang) ennemi = raiden;
        else if (joueur == johnnyCage) ennemi = scorpion;

       
        System.out.println("=====================================");
        System.out.println(" Début du Combat : ");
        joueur.afficherDébutCombat();  
        joueur.parlerAvantCombat();
        ennemi.parlerAvantCombat();

        
        while (joueur.getVie() > 0 && ennemi.getVie() > 0) {
            joueur.afficherDébutRound();  
            System.out.println("1. Attaquer");
            System.out.println("2. Attaque Spéciale");
            System.out.println("3. Utiliser soin");
            int action = scanner.nextInt();

            if (action == 1) {
                joueur.attaquer(ennemi);
            } else if (action == 2) {
                joueur.attaquerSpeciale(ennemi);
            } else if (action == 3) {
                potion.appliquerSoin(joueur);
            }

            if (ennemi.getVie() > 0) {
                ennemi.afficherDébutRound();  
                ennemi.attaquer(joueur);
            }
        }

       
        if (joueur.getVie() > 0) {
            joueur.parlerVictoire();
            System.out.println(joueur.getNom() + " wins!");
        } else {
            ennemi.parlerVictoire();
            System.out.println(ennemi.getNom() + " wins!");
        }

        scanner.close();
    }
}

