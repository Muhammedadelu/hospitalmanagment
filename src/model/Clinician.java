package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Clinician extends Staff {
    private String qualifications;
    private String specialty;

    public Clinician() {}

    public Clinician(String id, String name, String contact, String role, String workplace,
                     String qualifications, String specialty) {
        super(id, name, contact, role, workplace);
        this.qualifications = qualifications;
        this.specialty = specialty;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void performClinicalAssessment() {
        System.out.println(getName() + " is performing clinical assessment.");
    }

    public void accessPatientRecord(PatientRecord record) {
        System.out.println(getName() + " accessed patient record: " + record.getId());
    }

    public void createPrescription(Prescription prescription) {
        System.out.println(getName() + " created prescription for patient " + prescription.getPatientId());
    }

    public void createReferral(Referral referral) {
        System.out.println(getName() + " created referral for patient " + referral.getPatientId());
    }
}