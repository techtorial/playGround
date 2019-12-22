package DeserilaztionPojo;

import java.util.List;
import java.util.Map;

public class Allpojo {
    private List<Allpojo>all;
    private String _id;
    private String text;
    private  String type;
   private  int  upvotes;
    private Map<String,Object> user;

    public Map<String, Object> getUser() {
        return user;
    }

    public void setUser(Map<String, Object> user) {
        this.user = user;
    }

    public List<Allpojo> getAll() {
        return all;
    }

    public void setAll(List<Allpojo> all) {
        this.all = all;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public String getUserUpvoted() {
        return userUpvoted;
    }

    public void setUserUpvoted(String userUpvoted) {
        this.userUpvoted = userUpvoted;
    }

    private String userUpvoted;

}
