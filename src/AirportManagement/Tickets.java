package AirportManagement;

public class Tickets implements Cost {
    private int TicketId;
    private Flight flight;
    private int PlaceNum;
    private boolean available;
    private String TicketType;
    String buss="businessclass";
    private int TicketCost;

    public Tickets(int TicketCost){
        this.TicketCost=TicketCost;
    }

    public int getTicketId() {
        return TicketId;
    }

    public int getPlaceNum() {
        return PlaceNum;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }



    public String getTicketType() {
        return TicketType;
    }

    public void setTicketType(String ticketType) {
        TicketType = ticketType;
    }

    public int getTicketCost(int qwer) {
        if(getTicketType()==buss){
            qwer=qwer+60000;
            return qwer;
        }
        return qwer;
    }
    public void setTicketCost(int ticketCost) {
        TicketCost = ticketCost;
    }
    @Override
    public void cost() {
        int all = flight.getFlightCost() ;
    }

    @Override
    public String toString() {
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
