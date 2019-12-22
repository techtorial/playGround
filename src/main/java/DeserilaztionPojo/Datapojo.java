package DeserilaztionPojo;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Datapojo {



    private Map<String,Objects> Data;

   private int id;
   private String email;
    private String first_name;

    public Map<String, Objects> getData() {
        return Data;
    }
    public void setData(Map<String, Objects> data) {
        Data = data;
    }
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    private  String avatar;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    private String last_name;


}
