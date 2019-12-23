package gulaiymTest.HW_Pojo;

public class CatFactsPojo {

    private String id;
    private String text;
    private String type;
    private int upvotes;
    private int userUpvoted;
    private user user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText( String text) {
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

    public int getUserUpvoted() {
        return userUpvoted;
    }

    public void setUserUpvoted(int userUpvoted) {
        this.userUpvoted = userUpvoted;
    }

    public gulaiymTest.HW_Pojo.user getUser() {
        return user;
    }

    public void setUser(gulaiymTest.HW_Pojo.user user) {
        this.user = user;
    }
}
