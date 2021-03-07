package Airport;

public class Passanger extends User implements Cost{  //class that creates passenger objects, and extends from user
    private int PassengerId;
    private String PassengerName;
    private Tickets ticket;  //a user can be a passadier only if he has bought a ticket
    private String PassangerSurname;
    private String DateOfBirth;
    private boolean discount;  //to reduce the price of a passenger with an advantage
    private int baggageKg;
    public Passanger(int UserId, String UserName, String email,String password) {  //passenger constructor with users attributes
        super(UserId, UserName, email,password);
    }
    public Passanger(String PassengerName,String PassangerSurname,boolean discount,String DateOfBirth,int baggageKg){ //passenger constructor
        this.PassengerName=PassengerName;
        this.PassangerSurname=PassangerSurname;
        this.discount=discount;
        this.DateOfBirth=DateOfBirth;
        this.baggageKg=baggageKg;
    }

    public int getPassengerId() {  //getter for PassengerId
        return PassengerId;
    }

    public String getPassengerName() { //getter for Passenger name
        return PassengerName;
    }

    public String getPassangerSurname() {  //getter for Passenger surname
        return PassangerSurname;
    }

    public String getDateOfBirth() {   //getter for Passengers DateOfBirth
        return DateOfBirth;
    }

    public boolean isDiscount() {  //checking the availability of a discount
        return discount;
    }

    public int getBaggageKg() {  //getter for Passengers BaggageKg
        return baggageKg;
    }


    @Override
    public void cost(){

    }
    @Override
    public String toString() {    //toString for Passenger
        return "Passanger{" +
                "PassengerId=" + PassengerId +
                ", PassengerName='" + PassengerName + '\'' +
                ", ticket=" + ticket +
                ", discount=" + discount +
                ", baggageKg=" + baggageKg +
                '}';
    }
}