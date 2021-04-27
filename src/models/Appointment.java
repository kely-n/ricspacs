package models;

public class Appointment {

    private int id;
    private String status;
    private String title;
    Patient patient;
    Clinician clinician;

    public Appointment(int id, String title, Patient patient, Clinician clinician) {
        this.id = id;
        this.title = title;
        this.patient = patient;
        this.clinician = clinician;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
