package models;

public class Report {
    private int id;
    private String description;
    ImagingResult imagingResult;
    Radiologist radiologist;

    public Report(int id, ImagingResult imagingResult, Radiologist radiologist) {
        this.id = id;
        this.imagingResult = imagingResult;
        this.radiologist = radiologist;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
