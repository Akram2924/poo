package test_cabinet_medical;

import java.sql.Date;

public class CertificatMedical {
    private Patient patient;
    private String certificat;
    private Date dateEmission;

    public CertificatMedical(Patient patient, Date dateEmission, String certificat, String rapport) {
        this.patient = patient;
        this.certificat = certificat;
        this.dateEmission = dateEmission;
    }

    
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getCertificat() {
        return certificat;
    }

    public void setCertificat(String certificat) {
        this.certificat = certificat;
    }

    @Override
    public String toString() {
        return "Certificat médical pour " + patient.getNom() + " " + patient.getPrenom() + " : " + certificat;
    }
}
