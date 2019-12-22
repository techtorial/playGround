package DeserilaztionPojo;



import java.util.Map;


public class Data1pojo {

    private String name;
    private int year;
    private String color;
    private String pantone_value;

    private int id;


    private Map<String, Object>Data;
    public Map<String, Object> getData() {
        return Data;
    }

    public void setData(Map<String, Object> data) {
        Data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPantone_value() {
        return pantone_value;
    }

    public void setPantone_value(String pantone_value) {
        this.pantone_value = pantone_value;
    }


}
