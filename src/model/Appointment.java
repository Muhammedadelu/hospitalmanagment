package model;

import java.util.Date;

public class Appointment {
    private String id;
    private String patientId;
    private String clinicianId;
    private Date date;
    private String time;
    private String status;
    private String reason;

    public Appointment() {}

    public Appointment(String id, String patientId, String clinicianId, Date date, String time,
                       String status, String reason) {
        this.id = id;
        this.patientId = patientId;
        this.clinicianId = clinicianId;
        this.date = date;
        this.time = time;
        this.status = status;
        this.reason = reason;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getClinicianId() { return clinicianId; }
    public void setClinicianId(String clinicianId) { this.clinicianId = clinicianId; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public void bookAppointment() { this.status = "Booked"; }
    public void rescheduleAppointment(Date newDate, String newTime) {
        this.date = newDate;
        this.time = newTime;
        this.status = "Rescheduled";
    }
    public void cancelAppointment() { this.status = "Cancelled"; }

    @Override
    public String toString() {
        return "Appointment{" +
                "id='" + id + '\'' +
                ", patientId='" + patientId + '\'' +
                ", date=" + date +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}