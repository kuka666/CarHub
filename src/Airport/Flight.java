package Airport;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Calendar;



public class Flight implements Cost {  // class that creates flight objects
    private int FlightId;
    private String StartPortName;
    private String FinishPortName;
    private String Flightdate;
    private int PlaceQuantity;  // to determine how many tickets there can be for a flight
    private int FlightCost;   //flights have their own price, which is added to the ticket price
    private String Flighthour;  // an attribute that shows the hour of departure, since we have several flights on the same day
    Calendar calNow=Calendar.getInstance();


    public Flight(String StartPortName,String FinishPortName,String Flightdate){  // flight constructor
        this.StartPortName=StartPortName;
        this.FinishPortName=FinishPortName;
        this.Flightdate=Flightdate;
    }

    public String getFlighthour() {  // getter for flight hour
        return Flighthour;
    }

    public int getFlightId() {  // getter for flightId
        return FlightId;
    }

    public String getStartPortName() {  // getter for start port name
        return StartPortName;
    }

    public String getFinishPortName() {  // getter for finish port name
        return FinishPortName;
    }

    public String getFlightdate() {  // getter for flight date
        return Flightdate;
    }

    public int getPlaceQuantity() {  // getter for place quantity
        return PlaceQuantity;
    }

    public int getFlightCost() {   // getter for flight cost
        return FlightCost;
    }

    public void setFlightCost(int FlightCost) {  // setter for flight cost
        this.FlightCost = FlightCost;
    }

    public void setFlighthour(String FlightHour) {  // setter for flight hour
        this.Flighthour = FlightHour;
    }



    @Override
    public void cost() {  // calculating the cost of the flight
        getFlightCost();
    }

    @Override
    public String toString() {  //toString for flights
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