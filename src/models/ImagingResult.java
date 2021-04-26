package models;

public class ImagingResult {
    private int id;
    private String imageUrl;
    Radiographer radiographer;

    public ImagingResult(int id, Radiographer radiographer) {
        this.id = id;
        this.radiographer = radiographer;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
