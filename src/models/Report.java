package models;

public class Report {
    private int id;
    private String description;
    ImagingResult imagingResult;
    Radiologist radiologist;

    public Report(int id, String description, ImagingResult imagingResult, Radiologist radiologist) {
        this.id = id;
        this.imagingResult = imagingResult;
        this.description = description;
        this.radiologist = radiologist;
    }

    public Report(String description, ImagingResult imagingResult, Radiologist radiologist) {
        this.description = description;
        this.imagingResult = imagingResult;
        this.radiologist = radiologist;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ImagingResult getImagingResult() {
        return imagingResult;
    }

    public void setImagingResult(ImagingResult imagingResult) {
        this.imagingResult = imagingResult;
    }

    public Radiologist getRadiologist() {
        return radiologist;
    }

    public void setRadiologist(Radiologist radiologist) {
        this.radiologist = radiologist;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", description='" + description + '\'' +
                ", imagingResult=" + imagingResult.getId() +
                ", radiologist=" + radiologist.getStaff_no() ;
    }
}
