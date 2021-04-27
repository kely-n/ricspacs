package models;

public class Appointment {

    private int id;
    private String status;
    private String title;
    Patient patient;
    Clinician clinician;

    public Appointment(int id,String status, String title, Patient patient, Clinician clinician) {
        this.id = id;
        this.status = status;
        this.title = title;
        this.patient = patient;
        this.clinician = clinician;
    }

    public Appointment(String status, String title, Patient patient, Clinician clinician) {
        this.status = status;
        this.title = title;
        this.patient = patient;
        this.clinician = clinician;
    }

    public Clinician getClinician() {
        return clinician;
    }

    public void setClinician(Clinician clinician) {
        this.clinician = clinician;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return
                "id=" + id +
                ", status='" + status + '\'' +
                ", title='" + title + '\'' +
                ", patient=" + patient.getName() ;
    }
}
