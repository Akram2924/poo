package jeu_test_MK;

public class Personnage {
    private String nom;
    private int vie;
    private int attaque;
    private String attaqueSpecialeNom;
    private int attaqueSpecialeDegats;

    public Personnage(String nom, int vie, int attaque, String attaqueSpecialeNom, int attaqueSpecialeDegats) {
        this.nom = nom;
        this.vie = vie;
        this.attaque = attaque;
        this.attaqueSpecialeNom = attaqueSpecialeNom;
        this.attaqueSpecialeDegats = attaqueSpecialeDegats;
    }

    public String getNom() {
        return nom;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getAttaque() {
        return attaque;
    }

    
    public int calculerDegats() {
        double facteurDeVariation = Math.random() * 0.2 + 0.9; 
        return (int)(this.attaque * facteurDeVariation);
    }

    
    public void attaquer(Personnage ennemi) {
        int degats = this.calculerDegats();
        ennemi.setVie(ennemi.getVie() - degats);
        System.out.println(this.nom + " attaque " + ennemi.getNom() + " et inflige " + degats + " de dégâts !");
    }

    
    public void attaquerSpeciale(Personnage ennemi) {
       
        int degats = this.attaqueSpecialeDegats;
        int vieAvant = this.vie;
        this.vie -= (int)(this.vie * 0.2); 
        ennemi.setVie(ennemi.getVie() - degats);
        System.out.println(this.nom + " utilise " + this.attaqueSpecialeNom + " et inflige " + degats + " de dégâts, mais perd 20% de ses PV (" + vieAvant + " -> " + this.vie + ") !");
    }

    public void parlerAvantCombat() {
        switch (this.nom) {
            case "Scorpion":
                System.out.println("Scorpion: GET OVER HERE!");
                break;
            case "Sub-Zero":
                System.out.println("Sub-Zero: I will freeze you!");
                break;
            case "Raiden":
                System.out.println("Raiden: I am a god!");
                break;
            case "Liu Kang":
                System.out.println("Liu Kang: I will fight with honor!");
                break;
            case "Johnny Cage":
                System.out.println("Johnny Cage: You can’t handle my moves!");
                break;
        }
    }

    public void parlerVictoire() {
        switch (this.nom) {
            case "Scorpion":
                System.out.println("Scorpion: FATALITY!");
                break;
            case "Sub-Zero":
                System.out.println("Sub-Zero: FROSTBITE!");
                break;
            case "Raiden":
                System.out.println("Raiden: I AM THE LIGHTNING!");
                break;
            case "Liu Kang":
                System.out.println("Liu Kang: I AM THE DRAGON!");
                break;
            case "Johnny Cage":
                System.out.println("Johnny Cage: I’m the best!");
                break;
        }
    }

    
    public void afficherDébutCombat() {
        System.out.println("=====================================");
        System.out.println("           " + this.nom + "  VS  " + this.nom);
        System.out.println("=====================================");
    }

    public void afficherDébutRound() {
        System.out.println("=====================================");
        System.out.println(" Début du tour de " + this.nom);
        System.out.println("=====================================");
    }
}

