package model;

import java.util.ArrayList;
import java.util.List;

public class Patient extends User {
    private String medicalHistory;
    private String nhsNumber;
    private String gpSurgery;
    private List<Appointment> appointments;

    public Patient() {
        appointments = new ArrayList<>();
    }

    public Patient(String id, String name, String contact, String nhsNumber, String gpSurgery, String medicalHistory) {
        super(id, name, contact);
        this.nhsNumber = nhsNumber;
        this.gpSurgery = gpSurgery;
        this.medicalHistory = medicalHistory;
        this.appointments = new ArrayList<>();
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getNhsNumber() {
        return nhsNumber;
    }

    public void setNhsNumber(String nhsNumber) {
        this.nhsNumber = nhsNumber;
    }

    public String getGpSurgery() {
        return gpSurgery;
    }

    public void setGpSurgery(String gpSurgery) {
        this.gpSurgery = gpSurgery;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Appointment appointment) {
        if (appointment != null) {
            appointments.add(appointment);
        }
    }

    public void updateRecord(String newHistory) {
        this.medicalHistory = newHistory;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", nhsNumber='" + nhsNumber + '\'' +
                ", medicalHistory='" + medicalHistory + '\'' +
                '}';
    }
}
