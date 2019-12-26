package gulaiymTest.HW_Pojo;

public class dataPojo {

    private dataPojo data;
    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

    public dataPojo getData() {
        return this.data;
    }

    public void setData(dataPojo data) {
        this.data = data;
    }

    public int getId() {
        return this.id;
    }

    public void setId( int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar( String avatar) {
        this.avatar = avatar;
    }
}
