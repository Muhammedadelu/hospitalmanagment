package model;

public class Prescription {
    private String id;
    private String patientId;
    private String clinicianId;
    private String medication;
    private String dosage;
    private String pharmacy;
    private String collectionStatus;

    public Prescription() {}

    public Prescription(String id, String patientId, String clinicianId, String medication,
                        String dosage, String pharmacy, String collectionStatus) {
        this.id = id;
        this.patientId = patientId;
        this.clinicianId = clinicianId;
        this.medication = medication;
        this.dosage = dosage;
        this.pharmacy = pharmacy;
        this.collectionStatus = collectionStatus;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getClinicianId() { return clinicianId; }
    public void setClinicianId(String clinicianId) { this.clinicianId = clinicianId; }

    public String getMedication() { return medication; }
    public void setMedication(String medication) { this.medication = medication; }

    public String getDosage() { return dosage; }
    public void setDosage(String dosage) { this.dosage = dosage; }

    public String getPharmacy() { return pharmacy; }
    public void setPharmacy(String pharmacy) { this.pharmacy = pharmacy; }

    public String getCollectionStatus() { return collectionStatus; }
    public void setCollectionStatus(String collectionStatus) { this.collectionStatus = collectionStatus; }

    public String getDrugDetails() {
        return medication + " - " + dosage;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id='" + id + '\'' +
                ", medication='" + medication + '\'' +
                ", dosage='" + dosage + '\'' +
                ", patientId='" + patientId + '\'' +
                '}';
    }
}