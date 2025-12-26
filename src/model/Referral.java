package model;

import java.util.Date;

public class Referral {
    private String id;
    private String patientId;
    private String fromClinicianId;
    private String toFacilityId;
    private String summary;
    private String urgency;
    private Date date;

    public Referral() {}

    public Referral(String id, String patientId, String fromClinicianId, String toFacilityId,
                    String summary, String urgency, Date date) {
        this.id = id;
        this.patientId = patientId;
        this.fromClinicianId = fromClinicianId;
        this.toFacilityId = toFacilityId;
        this.summary = summary;
        this.urgency = urgency;
        this.date = date;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getFromClinicianId() { return fromClinicianId; }
    public void setFromClinicianId(String fromClinicianId) { this.fromClinicianId = fromClinicianId; }

    public String getToFacilityId() { return toFacilityId; }
    public void setToFacilityId(String toFacilityId) { this.toFacilityId = toFacilityId; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public String getUrgency() { return urgency; }
    public void setUrgency(String urgency) { this.urgency = urgency; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public void manageReferral() {
        System.out.println("Managing referral " + id);
    }

    public void viewReferral() {
        System.out.println("Viewing referral details: " + summary);
    }

    public void sendReferralViaEmail() {
        System.out.println("Referral " + id + " sent via email simulation.");
    }

    public void updateElectronicHealthRecord() {
        System.out.println("EHR updated with referral " + id);
    }

    @Override
    public String toString() {
        return "Referral{" +
                "id='" + id + '\'' +
                ", patientId='" + patientId + '\'' +
                ", urgency='" + urgency + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}