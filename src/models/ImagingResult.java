package models;

public class ImagingResult {
    private int id;
    private String imageUrl;
    Radiographer radiographer;
    Appointment appointment;

    public ImagingResult(int id, String imageUrl, Radiographer radiographer, Appointment appointment) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.radiographer = radiographer;
        this.appointment = appointment;
    }

    public ImagingResult(String imageUrl, Radiographer radiographer, Appointment appointment) {
        this.imageUrl = imageUrl;
        this.radiographer = radiographer;
        this.appointment = appointment;
    }

    public Radiographer getRadiographer() {
        return radiographer;
    }

    public void setRadiographer(Radiographer radiographer) {
        this.radiographer = radiographer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", radiographer=" + radiographer.getName()+
                ", appointment=" + appointment.getTitle()
                ;
    }
}
