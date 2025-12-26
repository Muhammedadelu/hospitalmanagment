package model;

public class PatientRecord {
    private String id;
    private String patientId;
    private String details;

    public PatientRecord() {}

    public PatientRecord(String id, String patientId, String details) {
        this.id = id;
        this.patientId = patientId;
        this.details = details;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public void accessRecord() {
        System.out.println("Accessing patient record " + id);
    }

    public void updateRecord(String updates) {
        this.details += "\nUpdate: " + updates;
    }

    @Override
    public String toString() {
        return "PatientRecord{" +
                "id='" + id + '\'' +
                ", patientId='" + patientId + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}