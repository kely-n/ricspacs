package models;

public class Patient {
    private int req_no;
    private String name;
    private String billing_status;
    private String diagnosis;

    public Patient(int req_no, String name, String billing_status) {
        this.req_no = req_no;
        this.name = name;
        this.billing_status = billing_status;
    }

    public int getReq_no() {
        return req_no;
    }

    public void setReq_no(int req_no) {
        this.req_no = req_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBilling_status() {
        return billing_status;
    }

    public void setBilling_status(String billing_status) {
        this.billing_status = billing_status;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
