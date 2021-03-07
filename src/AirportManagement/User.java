package AirportManagement;

public class User {
    private int UserId;
    private String UserName;
    private String email;
    private String password;

    public User(int UserId,String UserName,String email,String password){
        this.UserId=UserId;
        this.UserName=UserName;
        this.email=email;
        this.password=password;
    }

    public User() {
    }

    public int getUserId() {
        return UserId;
    }

    public String getUserName() {
        return UserName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", UserName='" + UserName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
