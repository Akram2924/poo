package test_cabinet_medical;



public class Consultation {
    private Medecin medecin;
    private Patient patient;
    private String rapport;

    public Consultation(Medecin medecin, Patient patient,String rapport) {
        this.medecin = medecin;
        this.patient = patient;
        this.rapport = rapport;
      
    }

   
	// Getters et Setters
    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getRapport() {
        return rapport;
    }

    public void setRapport(String rapport) {
        this.rapport = rapport;
    }

    @Override
    public String toString() {
        return "Consultation avec Dr. " + medecin.getNom() + " " + medecin.getPrenom() + " pour " +
                patient.getNom() + " " + patient.getPrenom() + " : " + rapport;
    }
}
