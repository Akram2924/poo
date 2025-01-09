package test_cabinet_medical;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GestionHospitaliere {
    private List<RendezVous> rendezVousList;
    private List<Patient> patients;
    private List<Medecin> medecins;
    private List<Consultation> consultations;
    private List<CertificatMedical> certificats;
    public GestionHospitaliere() {
        this.rendezVousList = new ArrayList<>();
    }

    
    public void ajouterRendezVous(RendezVous rdv) {
        rendezVousList.add(rdv);
    }

    
    public boolean verifierDateRendezVous(LocalDate date, LocalTime heure) {
        for (RendezVous rdv : rendezVousList) {
            if (rdv.getDate().equals(date) && rdv.getHeure().equals(heure)) {
                return false;
            }
        }
        return true;
    }

    
    public void afficherRendezVous() {
        if (rendezVousList.isEmpty()) {
            System.out.println("Aucun rendez-vous enregistré.");
        } else {
            for (RendezVous rdv : rendezVousList) {
                System.out.println("Rendez-vous le " + rdv.getDate() + " à " + rdv.getHeure());
            }
        }
    
            this.certificats = new ArrayList<>();
            this.consultations = new ArrayList<>();
            this.medecins = new ArrayList<>();
            this.patients = new ArrayList<>();
        }

       
        public void ajouterPatient(Patient patient) {
            patients.add(patient);
            System.out.println("Patient ajouté avec succès !");
        }

      
        public void afficherPatients() {
            if (patients.isEmpty()) {
                System.out.println("Aucun patient à afficher.");
            } else {
                System.out.println("Liste des patients :");
                for (Patient patient : patients) {
                    System.out.println(patient);
                }
            }
        }

        
        public void supprimerPatient(String nom, String prenom) {
            Patient patientASupprimer = null;
            for (Patient patient : patients) {
                if (patient.getNom().equalsIgnoreCase(nom) && patient.getPrenom().equalsIgnoreCase(prenom)) {
                    patientASupprimer = patient;
                    break;
                }
            }

            if (patientASupprimer != null) {
                patients.remove(patientASupprimer);
                System.out.println("Patient supprimé avec succès !");
            } else {
                System.out.println("Patient non trouvé.");
            }
        }
        public void ajouterMedecin(Medecin medecin) {
            medecins.add(medecin);
            System.out.println("Médecin ajouté avec succès !");
        }

        public void afficherMedecins() {
            if (medecins.isEmpty()) {
                System.out.println("Aucun médecin à afficher.");
            } else {
                System.out.println("Liste des médecins :");
                for (Medecin medecin : medecins) {
                    System.out.println(medecin);
                }
            }
        }

        public void supprimerMedecin(String nom, String prenom) {
            Medecin medecinASupprimer = null;
            for (Medecin medecin : medecins) {
                if (medecin.getNom().equalsIgnoreCase(nom) && medecin.getPrenom().equalsIgnoreCase(prenom)) {
                    medecinASupprimer = medecin;
                    break;
                }
            }

            if (medecinASupprimer != null) {
                medecins.remove(medecinASupprimer);
                System.out.println("Médecin supprimé avec succès !");
            } else {
                System.out.println("Médecin non trouvé.");
            }
        }  
        public void ajouterConsultation(Patient patient, Medecin medecin,  String rapport) {
            Consultation consultation = new Consultation(medecin, patient , rapport);
            consultations.add(consultation);
            System.out.println("Consultation ajoutée avec succès !");
        }

        public void afficherConsultations() {
            if (consultations.isEmpty()) {
                System.out.println("Aucune consultation à afficher.");
            } else {
                System.out.println("Liste des consultations :");
                for (Consultation consultation : consultations) {
                    System.out.println(consultation);
                }
            }
        }
        public void ajouterCertificatMedical(Patient patient, String motif, String rapport) {
            Date dateEmission = new Date(0);  
            CertificatMedical certificat = new CertificatMedical(patient, dateEmission, motif, rapport);
            certificats.add(certificat);
            System.out.println("Certificat médical ajouté avec succès !");
        }

        public void afficherCertificatMedical(String nom, String prenom) {
            for (CertificatMedical certificat : certificats) {
                if (certificat.getPatient().getNom().equalsIgnoreCase(nom) && certificat.getPatient().getPrenom().equalsIgnoreCase(prenom)) {
                    System.out.println(certificat);
                    return;
                }
            }
            System.out.println("Aucun certificat médical trouvé pour ce patient.");
        }
	}
    

	


