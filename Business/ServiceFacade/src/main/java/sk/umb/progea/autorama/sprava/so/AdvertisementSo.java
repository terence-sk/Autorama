package sk.umb.progea.autorama.sprava.so;

import java.io.Serializable;

/**
 * Created by mvagac on 4/18/16.
 */
public class AdvertisementSo extends BaseSo implements Serializable{

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String title;
    private String contents;
    private String color;
    private String brand;
    private int kmDrivenMonthly;

    private CitySo city;

    public int getKmDrivenMonthly() {
        return kmDrivenMonthly;
    }

    public void setKmDrivenMonthly(int kmDrivenMonthly) {
        this.kmDrivenMonthly = kmDrivenMonthly;
    }

    public CitySo getCity() {
        return city;
    }

    public void setCity(CitySo city) {
        this.city = city;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
