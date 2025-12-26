package model;

public class Specialist extends Clinician {

    public Specialist() {}

    // ID, Name, Contact, Qualifications, ExpertiseArea
    public Specialist(String id, String name, String contact, String qualifications, String expertiseArea) {
        super(id, name, contact, "Specialist", "Hospital", qualifications, expertiseArea);
    }

    public void provideSpecializedTreatment() {
        System.out.println(getName() + " providing specialized treatment in " + getSpecialty());
    }

    public void reviewReferral(Referral referral) {
        System.out.println(getName() + " reviewing referral.");
    }
}