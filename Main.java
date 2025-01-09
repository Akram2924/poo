package test_cabinet_medical;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionHospitaliere gestion = new GestionHospitaliere();

        while (true) {
            System.out.println("=== MENU ===");
            System.out.println("1. Gestion des patients");
            System.out.println("2. Gestion des médecins");
            System.out.println("3. Gestion des rendez-vous");
            System.out.println("4. Gestion des consultations");
            System.out.println("5. Gestion des certificats médicaux");
            System.out.println("6. Quitter");
            System.out.print("Choisissez une option: ");
            int choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    gestionPatients(scanner, gestion);
                    break;
                case 2:
                    gestionMedecins(scanner, gestion);
                    break;
                case 3:
                    gestionRendezVous(scanner, gestion);
                    break;
                case 4:
                    gestionConsultations(scanner, gestion);
                    break;
                case 5:
                    gestionCertificats(scanner, gestion);
                    break;
                case 6:
                    System.out.println("Au revoir!");
                    return;
                default:
                    System.out.println("Option invalide!");
                    break;
            }
        }
    }

    
    private static void gestionRendezVous(Scanner scanner, GestionHospitaliere gestion) {
        while (true) {
            System.out.println("\n=== Gestion des rendez-vous ===");
            System.out.println("1. Ajouter un rendez-vous");
            System.out.println("2. Afficher les rendez-vous");
            System.out.println("3. Supprimer un rendez-vous");
            System.out.println("4. Retour");
            System.out.print("Choisissez une option: ");
            int choixRdv = scanner.nextInt();
            scanner.nextLine(); 

            switch (choixRdv) {
                case 1:
                    System.out.print("Entrez la date du rendez-vous (format: JJ/MM/AAAA): ");
                    String dateStr = scanner.nextLine();
                    LocalDate date = validerDate(dateStr);
                    if (date == null) {
                        System.out.println("Date invalide.");
                        break;
                    }

                    System.out.print("Entrez l'heure du rendez-vous (format: HH:MM): ");
                    String heureStr = scanner.nextLine();
                    LocalTime heure = validerHeure(heureStr);
                    if (heure == null) {
                        System.out.println("Heure invalide.");
                        break;
                    }

                    
                    if (gestion.verifierDateRendezVous(date, heure)) {
                        System.out.println("Date et heure disponibles, rendez-vous ajouté.");
                       
                    } else {
                        System.out.println("Date et heure déjà occupées.");
                    }
                    break;
                case 2:
                    gestion.afficherRendezVous();
                    break;
                case 3:
                    System.out.print("Entrez la date du rendez-vous à supprimer: ");
                    dateStr = scanner.nextLine();
                    date = validerDate(dateStr);
                    if (date == null) {
                        System.out.println("Date invalide.");
                        break;
                    }
                   
                    break;
                case 4:
                    return; 
                default:
                    System.out.println("Option invalide!");
                    break;
            }
        }
    }

    
    private static LocalDate validerDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

   
    private static LocalTime validerHeure(String heureStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        try {
            return LocalTime.parse(heureStr, formatter); 
        } catch (DateTimeParseException e) {
            return null; 
        }
    }

    // Gestion des patients
    private static void gestionPatients(Scanner scanner, GestionHospitaliere gestion) {
        while (true) {
            System.out.println("\n=== Gestion des patients ===");
            System.out.println("1. Ajouter un patient");
            System.out.println("2. Afficher tous les patients");
            System.out.println("3. Supprimer un patient");
            System.out.println("4. Retour");
            System.out.print("Choisissez une option: ");
            int choixPatient = scanner.nextInt();
            scanner.nextLine(); 

            switch (choixPatient) {
                case 1:
                    System.out.print("Nom: ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom: ");
                    String prenom = scanner.nextLine();
                    System.out.print("Date de naissance (JJ/MM/AAAA): ");
                    String dateNaissance = scanner.nextLine();
                    System.out.print("Adresse: ");
                    String adresse = scanner.nextLine();
                    gestion.ajouterPatient(new Patient(nom, prenom, dateNaissance, adresse));
                    break;
                case 2:
                    gestion.afficherPatients();
                    break;
                case 3:
                    System.out.print("Nom du patient à supprimer: ");
                    nom = scanner.nextLine();
                    System.out.print("Prénom du patient à supprimer: ");
                    prenom = scanner.nextLine();
                    gestion.supprimerPatient(nom, prenom);
                    break;
                case 4:
                    return; 
                default:
                    System.out.println("Option invalide!");
                    break;
            }
        }
    }

    
    private static void gestionMedecins(Scanner scanner, GestionHospitaliere gestion) {
        while (true) {
            System.out.println("\n=== Gestion des médecins ===");
            System.out.println("1. Ajouter un médecin");
            System.out.println("2. Afficher tous les médecins");
            System.out.println("3. Supprimer un médecin");
            System.out.println("4. Retour");
            System.out.print("Choisissez une option: ");
            int choixMedecin = scanner.nextInt();
            scanner.nextLine(); 

            switch (choixMedecin) {
                case 1:
                    System.out.print("Nom: ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom: ");
                    String prenom = scanner.nextLine();
                    System.out.print("Spécialité: ");
                    String specialite = scanner.nextLine();
                    gestion.ajouterMedecin(new Medecin(nom, prenom, specialite));
                    break;
                case 2:
                    gestion.afficherMedecins();
                    break;
                case 3:
                    System.out.print("Nom du médecin à supprimer: ");
                    nom = scanner.nextLine();
                    System.out.print("Prénom du médecin à supprimer: ");
                    prenom = scanner.nextLine();
                    gestion.supprimerMedecin(nom, prenom);
                    break;
                case 4:
                    return; 
                default:
                    System.out.println("Option invalide!");
                    break;
            }
        }
    }

    
    private static void gestionConsultations(Scanner scanner, GestionHospitaliere gestion) {
        while (true) {
            System.out.println("\n=== Gestion des consultations ===");
            System.out.println("1. Ajouter une consultation");
            System.out.println("2. Afficher les consultations");
            System.out.println("3. Retour");
            System.out.print("Choisissez une option: ");
            int choixConsultation = scanner.nextInt();
            scanner.nextLine(); 
            switch (choixConsultation) {
                case 1:
                    System.out.print("Entrez le rapport de consultation: ");
                    String rapport = scanner.nextLine();
                    System.out.println("Consultation ajoutée.");
                    break;
                case 2:
                    gestion.afficherConsultations();
                    break;
                case 3:
                    return; 
                default:
                    System.out.println("Option invalide!");
                    break;
            }
        }
    }

  
    private static void gestionCertificats(Scanner scanner, GestionHospitaliere gestion) {
        while (true) {
            System.out.println("\n=== Gestion des certificats médicaux ===");
            System.out.println("1. Ajouter un certificat médical");
            System.out.println("2. Afficher un certificat médical");
            System.out.println("3. Retour");
            System.out.print("Choisissez une option: ");
            int choixCertificat = scanner.nextInt();
            scanner.nextLine(); 
            switch (choixCertificat) {
                case 1:
                    System.out.print("Entrez le certificat: ");
                    String certificat = scanner.nextLine();
                    System.out.println("Certificat ajouté.");
                    break;
                case 2:
                    System.out.print("Entrez le nom du patient: ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez le prénom du patient: ");
                    String prenom = scanner.nextLine();
                    gestion.afficherCertificatMedical(nom, prenom);
                    break;
                case 3:
                    return; 
                default:
                    System.out.println("Option invalide!");
                    break;
            }
        }
    }
}

