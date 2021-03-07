package AirportManagement;

public class Passanger extends User implements Cost{
    private int PassengerId;
    private String PassengerName;
    private Tickets ticket;
    private String PassangerSurname;
    private String DateOfBirth;
    private boolean discount;
    private int baggageKg;
    public Passanger(int UserId, String UserName, String email,String password) {
        super(UserId, UserName, email,password);
    }
    public Passanger(String PassengerName,String PassangerSurname,boolean discount,String DateOfBirth,int baggageKg){
        this.PassengerName=PassengerName;
        this.PassangerSurname=PassangerSurname;
        this.discount=discount;
        this.DateOfBirth=DateOfBirth;
        this.baggageKg=baggageKg;
    }

    public int getPassengerId() {
        return PassengerId;
    }

    public String getPassengerName() {
        return PassengerName;
    }

    public String getPassangerSurname() {
        return PassangerSurname;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public boolean isDiscount() {
       return discount;
    }

    public int getBaggageKg() {
        return baggageKg;
    }


    @Override
    public void cost(){

    }
    @Override
    public String toString() {
        return "Passanger{" +
                "PassengerId=" + PassengerId +
                ", PassengerName='" + PassengerName + '\'' +
                ", ticket=" + ticket +
                ", discount=" + discount +
                ", baggageKg=" + baggageKg +
                '}';
    }
}
