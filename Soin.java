package jeu_test_MK;

public class Soin {
    private int pointsDeSoin;

    public Soin(int pointsDeSoin) {
        this.pointsDeSoin = pointsDeSoin;
    }

    public int getPointsDeSoin() {
        return pointsDeSoin;
    }

    public void appliquerSoin(Personnage personnage) {
        personnage.setVie(personnage.getVie() + pointsDeSoin);
        System.out.println(personnage.getNom() + " utilise un soin et récupère " + pointsDeSoin + " points de vie !");
    }
}
