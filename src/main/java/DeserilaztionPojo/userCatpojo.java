package DeserilaztionPojo;

import java.util.Map;

public class userCatpojo {
    private Map<String,Object>user;
    private int _id;

    public Map<String, Object> getUser() {
        return user;
    }

    public void setUser(Map<String, Object> user) {
        this.user = user;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
    @Override
    public  String toString(){
        return  "name from tags: " + getUser() + "\nid from tags: " + get_id();// to override default impletetion because out put hashcode
    }
}
