package model;

public class Nurse extends Clinician {

    public Nurse() {}

    // ID, Name, Contact, Qualifications
    public Nurse(String id, String name, String contact, String qualifications) {
        super(id, name, contact, "Nurse", "GP Surgery/Hospital", qualifications, "General Nursing");
    }

    public void deliverSupportServices() {
        System.out.println(getName() + " delivering clinical support.");
    }

    public void assistInAssessment() {
        System.out.println(getName() + " assisting in patient assessment.");
    }
}