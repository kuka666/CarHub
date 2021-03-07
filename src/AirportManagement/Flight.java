package AirportManagement;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Calendar;



public class Flight implements Cost {
    private int FlightId;
    private String StartPortName;
    private String FinishPortName;
    private String Flightdate;
    private int PlaceQuantity;
    private int FlightCost;
    private String Flighthour;
    Calendar calNow=Calendar.getInstance();


    public Flight(String StartPortName,String FinishPortName,String Flightdate){
        this.StartPortName=StartPortName;
        this.FinishPortName=FinishPortName;
        this.Flightdate=Flightdate;
    }

    public String getFlighthour() {
        return Flighthour;
    }

    public int getFlightId() {
        return FlightId;
    }

    public String getStartPortName() {
        return StartPortName;
    }

    public String getFinishPortName() {
        return FinishPortName;
    }

    public String getFlightdate() {
        return Flightdate;
    }

    public int getPlaceQuantity() {
        return PlaceQuantity;
    }

    public int getFlightCost() {
        return FlightCost;
    }

    public void setFlightCost(int FlightCost) {
        this.FlightCost = FlightCost;
    }

    public void setFlighthour(String FlightHour) {
        this.Flighthour = FlightHour;
    }



    @Override
    public void cost() {
        getFlightCost();
    }

    @Override
    public String toString() {
        return "Flight{" +
                "FlightId=" + FlightId +
                ", StartPortName='" + StartPortName + '\'' +
                ", FinishPortName='" + FinishPortName + '\'' +
                ", date=" + Flightdate +
                ", PlaceQuantity=" + PlaceQuantity +
                ", FlightCost=" + FlightCost +
                '}';
    }
}
