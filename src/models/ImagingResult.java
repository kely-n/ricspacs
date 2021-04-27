package models;

public class ImagingResult {
    private int id;
    private String imageUrl;
    Radiographer radiographer;
    Appointment appointment;

    public ImagingResult(int id, Radiographer radiographer) {
        this.id = id;
        this.radiographer = radiographer;
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

}
