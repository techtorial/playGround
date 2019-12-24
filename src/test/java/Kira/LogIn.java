package Kira;

public class LogIn {

    private String email;
    private String  password;
    private String token;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LogIn(String email, String password) {
        this.email = email;
        this.password = password;

    }
    public LogIn(){


    }


}
