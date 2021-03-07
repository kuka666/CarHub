package Airport;

public class User {  // class that creates user objects
    private int UserId;
    private String UserName;
    private String email;
    private String password;

    public User(int UserId,String UserName,String email,String password){  //user constructor
        this.UserId=UserId;
        this.UserName=UserName;
        this.email=email;
        this.password=password;
    }

    public User() {  // empty user constructor
    }

    public int getUserId() {  // getter for userId
        return UserId;
    }

    public String getUserName() { // getter for user name
        return UserName;
    }

    public String getEmail() {  // getter for email
        return email;
    }

    public String getPassword() {  // getter for password
        return password;
    }

    @Override
    public String toString() {  // toString for user
        return "User{" +
                "UserId=" + UserId +
                ", UserName='" + UserName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
