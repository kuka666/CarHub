package Airport;

public class Tickets implements Cost { //The Tickets class that creates individual tickets for flights
    private int TicketId;
    private Flight flight;
    private int PlaceNum;
    private boolean available;  // available to determine if there are free seats for certain flights
    private String TicketType;  //has 2 types, business and econom class
    String buss="businessclass";
    private int TicketCost;

    public Tickets(int TicketCost){  //the constructor has only the cost of the ticket to make it easier to create objects in the future
        this.TicketCost=TicketCost;
    }

    public int getTicketId() { //getter for ticketId
        return TicketId;
    }

    public int getPlaceNum() {  //getter for place number
        return PlaceNum;
    }

    public boolean isAvailable() { //available checking
        return available;
    }

    public void setAvailable(boolean available) { // setter for available
        this.available = available;
    }



    public String getTicketType() {  //getter for ticket type
        return TicketType;
    }

    public void setTicketType(String ticketType) {  //setter for ticket type
        TicketType = ticketType;
    }

    public int getTicketCost(int qwer) {   //getter for ticket cost
        if(getTicketType()==buss){   //price increase depending on the type of ticket
            qwer=qwer+60000;
            return qwer;
        }
        return qwer;
    }
    public void setTicketCost(int ticketCost) {  //setter for ticket cost
        TicketCost = ticketCost;
    }
    @Override
    public void cost() {
        int all = flight.getFlightCost() ;  //calculating the cost of the ticket
    }

    @Override
    public String toString() {   //toString for tickets
        return "Tickets{" +
                "TicketId=" + TicketId +
                ", flight=" + flight +
                ", PlaceNum=" + PlaceNum +
                ", available=" + available +
                ", TicketType='" + TicketType + '\'' +
                ", TicketCost=" + TicketCost +
                '}';
    }
}