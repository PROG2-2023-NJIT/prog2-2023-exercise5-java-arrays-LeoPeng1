package prog2.exercise5.flight.booking.system;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import java.util.Scanner;


public class FlightBooking {

    enum BookingClass {
        FIRST, BUSINESS, ECONOMY
    }

    enum TripType {
        ONE_WAY, RETURN

    }

    enum TripSource {
        BEIJING, SHANGHAI, OULU, NANJING, PARIS, HELSINKI
    }

    enum TripDestination {
        BEIJING, SHANGHAI, OULU, NANJING, PARIS, HELSINKI
    }

    enum SourceAirport {
        NANJING_LUKOU_INTERNATIONAL_AIRPORT, BEIJING_CAPITAL_INTERNATIONAL_AIRPORT,
        SHANGHAI_PUDONG_INTERNATIONAL_AIRPORT, OULU_AIRPORT, HELSINKI_AIRPORT,
        PARIS_CHARLES_DE_GAULLE_AIRPORT
    }

    enum Destinationairport {
        NANJING_LUKOU_INTERNATIONAL_AIRPORT, BEIJING_CAPITAL_INTERNATIONAL_AIRPORT,
        SHANGHAI_PUDONG_INTERNATIONAL_AIRPORT, OULU_AIRPORT, HELSINKI_AIRPORT,
        PARIS_CHARLES_DE_GAULLE_AIRPORT
    }

    private final String flightCompany = "Flights-of-Fancy";
    private String[] passengerFullName;
    private String[] passengerGender;
    private int[] passengerAge;
    private String flightID;
    private TripSource tripSource;
    private SourceAirport sourceAirport;
    private TripDestination tripDestination;
    private Destinationairport destinationAirport;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private int childPassengers;
    private int adultPassengers;
    private int totalPassengers;
    private double departingTicketPrice;
    private double returnTicketPrice;
    private double totalTicketPrice;
    private String[] ticketNumber;
    private BookingClass bookingClass;
    private TripType tripType;
    private String classification;
    boolean xy = false;


    public FlightBooking(LocalDate departureDate, LocalDate returnDate, int childPassengers, int adultPassengers) {
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.childPassengers = childPassengers;
        this.adultPassengers = adultPassengers;
        setTotalPassengers(childPassengers, adultPassengers);
    }

    public FlightBooking(int number) {
        this.passengerFullName = new String[number];
        this.passengerGender = new String[number];
        this.passengerAge = new int[number];
        this.ticketNumber = new String[number];
    }

    public void reserveTickets(int number) {
        Scanner sc = new Scanner(System.in);
        for (int m = 0; m < number; m++) {
            System.out.println("Please enter NO." + (m + 1) + " passenger's full name");
            this.passengerFullName[m] = sc.nextLine();
            System.out.println("Please enter NO." + (m + 1) + " passenger's gender");
            this.passengerGender[m] = sc.nextLine();
            System.out.println("Please enter NO." + (m + 1) + " passenger's age");
            this.passengerAge[m] = sc.nextInt();
        }
        System.out.println(" Please select the date you want to departure(like 2023-03-07)");
        String sdeparture = sc.next();
        LocalDate departure = LocalDate.parse(sdeparture);

        System.out.println("Please select the date you want to return(like 2023-03-07)");
        String return2 = sc.next();
        LocalDate return1 = LocalDate.parse(return2);

        System.out.println("Please enter the number of children");
        int child = sc.nextInt();
        System.out.println("Please enter the number of adults");
        int adults = sc.nextInt();
        FlightBooking fb = new FlightBooking(departure, return1, child, adults);
        System.out.println("Please select the class you would like to travel in (1.First, 2.Business, 3.Economy please enter the number):");
        String select = sc.next();
        setBookingClass(select);
        System.out.println("Please select the trip type(1. One way 2. Return, enter 1 or 2)");
        String type = sc.next();
        setTripType(type);
        System.out.println("Please chose one of the trip sources(1. Nanjing 2. Beijing 3. Oulu 4. Helsinki,please enter the number) ");
        String source = sc.next();
        setTripSource(source);
        System.out.println("Please chose one of the trip destination(1. Nanjing 2. Beijing 3. Oulu 4. Helsinki,please enter the number)");
        String destination = sc.next();
        setTripDestination(source, destination);
        setClassification(source, destination);
        for (int m = 0; m < number; m++) {
            setTicketNumber(m);
        }
        setDepartingTicketPrice(childPassengers, adultPassengers);
        setReturnTicketPrice();
        setTotalTicketPrice();
    }

    public BookingClass getBookingClass() {
        return bookingClass;
    }

    public void setBookingClass(String bookingClass) {
        switch (bookingClass) {
            case "1":
                this.bookingClass = BookingClass.FIRST;
                break;
            case "2":
                this.bookingClass = BookingClass.BUSINESS;
                break;
            case "3":
                this.bookingClass = BookingClass.ECONOMY;
                break;
            default:
                System.out.println("Error");
                break;
        }

    }

    public void setTripType(String tripType) {
        switch (tripType) {
            case "1":
                this.tripType = TripType.ONE_WAY;
                break;
            case "2":
                this.tripType = TripType.RETURN;
                break;
            default:
                System.out.println("Error");
        }
    }

    public void setTripSource(String tripSource) {
        switch (tripSource) {
            case "1":
                this.tripSource = TripSource.NANJING;
                this.sourceAirport = SourceAirport.NANJING_LUKOU_INTERNATIONAL_AIRPORT;
                break;
            case "2":
                this.tripSource = TripSource.BEIJING;
                this.sourceAirport = SourceAirport.BEIJING_CAPITAL_INTERNATIONAL_AIRPORT;
                break;
            case "3":
                this.tripSource = TripSource.OULU;
                this.sourceAirport = SourceAirport.OULU_AIRPORT;
                return;
            case "4":
                this.tripSource = TripSource.HELSINKI;
                this.sourceAirport = SourceAirport.HELSINKI_AIRPORT;
                break;
            default:
                System.out.println("Please enter the correct number");
        }
    }

    public void setSourceAirport(String sourceAirport) {
        switch (sourceAirport) {
            case "1":
                this.tripSource = TripSource.NANJING;
                this.sourceAirport = SourceAirport.NANJING_LUKOU_INTERNATIONAL_AIRPORT;
                break;
            case "2":
                this.tripSource = TripSource.BEIJING;
                this.sourceAirport = SourceAirport.BEIJING_CAPITAL_INTERNATIONAL_AIRPORT;
                break;
            case "3":
                this.tripSource = TripSource.OULU;
                this.sourceAirport = SourceAirport.OULU_AIRPORT;
                return;
            case "4":
                this.tripSource = TripSource.HELSINKI;
                this.sourceAirport = SourceAirport.HELSINKI_AIRPORT;
                break;
            default:
                System.out.println("Please enter the correct number");
        }
    }

    public void setDestinationAirport(String sourceAirport, String destinationAirport) {
        switch (destinationAirport) {
            case "1":
                this.tripDestination = TripDestination.NANJING;
                this.destinationAirport = Destinationairport.NANJING_LUKOU_INTERNATIONAL_AIRPORT;
                break;
            case "2":
                this.tripDestination = TripDestination.BEIJING;
                this.destinationAirport = Destinationairport.BEIJING_CAPITAL_INTERNATIONAL_AIRPORT;
                break;
            case "3":
                this.tripDestination = TripDestination.OULU;
                this.destinationAirport = Destinationairport.OULU_AIRPORT;
                break;
            case "4":
                this.tripDestination = TripDestination.HELSINKI;
                this.destinationAirport = Destinationairport.HELSINKI_AIRPORT;
                break;
            default:
                System.out.println("Please enter the correct number");
        }
    }

    public void setTripDestination(String tripSource, String tripDestination) {
        switch (tripDestination) {
            case "1":
                this.tripDestination = TripDestination.NANJING;
                this.destinationAirport = Destinationairport.NANJING_LUKOU_INTERNATIONAL_AIRPORT;
                break;
            case "2":
                this.tripDestination = TripDestination.BEIJING;
                this.destinationAirport = Destinationairport.BEIJING_CAPITAL_INTERNATIONAL_AIRPORT;
                break;
            case "3":
                this.tripDestination = TripDestination.OULU;
                this.destinationAirport = Destinationairport.OULU_AIRPORT;
                break;
            case "4":
                this.tripDestination = TripDestination.HELSINKI;
                this.destinationAirport = Destinationairport.HELSINKI_AIRPORT;
                break;
            default:
                System.out.println("Please enter the correct number");
        }
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
        Period p = Period.between(departureDate, returnDate);
        if (p.getDays() < 2 && p.getMonths() <= 0 && p.getYears() <= 0) {
            this.returnDate = departureDate.plusDays(2);
            this.xy = true;
        } else
            this.returnDate = returnDate;

    }

    public void setClassification(String _source, String _destination) {
        String x = _source + _destination;
        if (x.equals("NANJINGBEIJING") || x.equals("BEIJINGNANJING") || x.equals("OULUHELSINKI") || x.equals("HELSINKIOULU")) {
            this.classification = "domestic";
        } else
            this.classification = "international";
    }


    public String getFlightCompany() {
        return flightCompany;
    }

    public TripSource getTripSource() {
        return tripSource;
    }

    public TripDestination getTripDestination() {
        return tripDestination;
    }

    public String getPassengerFullName(int index) {
        return passengerFullName[index];
    }

    public void setPassengerFullName(int index, String passengerFullName) {
        this.passengerFullName[index] = passengerFullName;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }


    public int getChildPassengers() {
        return childPassengers;
    }

    public int getAdultPassengers() {
        return adultPassengers;
    }

    public int getTotalPassengers() {
        return totalPassengers;
    }

    public void setTotalPassengers(int childPassengers, int adultPassengers) {
        this.totalPassengers = childPassengers + adultPassengers;
    }

    public double getDepartingTicketPrice() {
        return departingTicketPrice;
    }

    public void setDepartingTicketPrice(int childPassengers, int adultPassengers) {
        setClassification(tripSource.toString(), tripDestination.toString());
        switch (bookingClass) {
            case FIRST:
                if (classification.equals("domestic"))
                    this.departingTicketPrice = (childPassengers + adultPassengers) * (345 + 250);
                else
                    this.departingTicketPrice = (childPassengers + adultPassengers) * (375 + 250);
                break;
            case BUSINESS:
                if (classification.equals("domestic"))
                    this.departingTicketPrice = (childPassengers + adultPassengers) * (345 + 150);
                else
                    this.departingTicketPrice = (childPassengers + adultPassengers) * (375 + 150);
                break;
            case ECONOMY:
                if (classification.equals("domestic"))
                    this.departingTicketPrice = (childPassengers + adultPassengers) * (345 + 50);
                else
                    this.departingTicketPrice = (childPassengers + adultPassengers) * (375 + 50);
            default:
                break;
        }

    }

    public double getReturnTicketPrice() {
        return returnTicketPrice;
    }

    public void setReturnTicketPrice() {
        switch (tripType) {
            case ONE_WAY:
                this.returnTicketPrice = 0;
                break;
            case RETURN:
                this.returnTicketPrice = departingTicketPrice;
                break;
            default:
                break;
        }
    }

    public double getTotalTicketPrice() {
        return totalTicketPrice;
    }

    public void setTotalTicketPrice() {
        this.totalTicketPrice = departingTicketPrice + returnTicketPrice;
    }

    public String[] getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int number) {
        setClassification(tripSource.toString(), tripDestination.toString());
        Random rnd = new Random();
        int _number = rnd.nextInt(9000) + 1000;
        String m = String.valueOf(_number);
        String ticket = null;

        switch (bookingClass) {
            case FIRST:
                if (tripType.equals(TripType.ONE_WAY)) {
                    if (classification.equals("domestic"))
                        ticket = "11" + "F" + m + "DOM";
                    else
                        ticket = "11" + "F" + m + "INT";
                } else {
                    if (classification.equals("domestic"))
                        ticket = "22" + "F" + m + "DOM";
                    else
                        ticket = "22" + "F" + m + "INT";
                }
                break;
            case BUSINESS:
                if (tripType.equals(TripType.ONE_WAY)) {
                    if (classification.equals("international"))
                        ticket = "11" + "B" + m + "DOM";
                    else
                        ticket = "11" + "B" + m + "INT";
                } else {
                    if (classification.equals("domestic"))
                        ticket = "22" + "B" + m + "DOM";
                    else
                        ticket = "22" + "B" + m + "INT";
                }
                break;
            case ECONOMY:
                if (tripType.equals(TripType.ONE_WAY)) {
                    if (classification.equals("international"))
                        ticket = "11" + "E" + m + "DOM";
                    else
                        ticket = "11" + "E" + m + "INT";
                } else {
                    if (classification.equals("domestic"))
                        ticket = "22" + "E" + m + "DOM";
                    else
                        ticket = "22" + "E" + m + "INT";
                }
                break;
            default:
                break;
        }
        this.ticketNumber[number] = ticket;

    }

    public String getPassengerGender(int index) {
        return passengerGender[index];
    }

    public void setPassengerGender(int index, String passengerGender) {
        this.passengerGender[index] = passengerGender;
    }

    public int getPassengerAge(int index) {
        return passengerAge[index];
    }

    public void setPassengerAge(int index, int passengerAge) {
        this.passengerAge[index] = passengerAge;
    }


    public String toString() {
        setDepartingTicketPrice(childPassengers, adultPassengers);
        setReturnTicketPrice();
        setTotalTicketPrice();
        setDepartureDate(departureDate);
        setReturnDate(returnDate);
        String x = "Thank you for booking your flight with " + flightCompany + ". Following are the details \nof your booking and the trip: \n\nTicket Number:"
                + ticketNumber + "\nPassenger Name: " + passengerFullName + "\nFrom " + tripSource + " to " + tripDestination + "\nDate of departure: " + departureDate + "\nDate of return: " + returnDate + "(Changed from old returningDate to new returningDate)\nTotal passengers:" +
                totalPassengers + "\nTotal ticket price in Euros: " + totalTicketPrice;

        String y = "Dear " + passengerFullName + ". Thank you for booking your flight with " + flightCompany + ".\nFollowing are the details of your booking and the trip: \nTicket Number:"
                + ticketNumber + "\nFrom " + tripSource + " to " + tripDestination + "\nDate of departure: " + departureDate + "\nDate of return: " + returnDate + "(Changed from old returningDate to new returningDate)\nTotal passengers:" +
                totalPassengers + "\nTotal ticket price in Euros: " + totalTicketPrice + "\nIMPORTANT NOTICE: As per our policy, the return date was changed because it was \n" +
                "less than two days apart from your departure date.";
        if (xy) {
            return y;
        } else
            return x;

    }

    public void displayTripDetails(int number) {
        if (xy) {
            System.out.println("Thank you for booking your flights with FLIGHT_COMPANY.\n" +
                    "You reserved a total of " + number + " tickets.");
            for (int m = 0; m < number; m++) {
                System.out.println("Here are the trip details for Passenger No. " + m + "\nPassenger's Ticket Number: " +
                        ticketNumber[m] + "\nPassenger's Full Name: " + passengerFullName[m] + "\nPassenger's Age: " +
                        passengerAge[m] + "\nPassenger's Gender: " + passengerGender[m] + "\nFrom: " + tripSource + "(" + sourceAirport + ")\nTo: " + tripDestination +
                        "(" + destinationAirport + ")\nThe flight departs on: " + departureDate + "\nAnd the return flight is on: " + returnDate + " (Changed from old returningDate to new returningDate)");
            }
        } else
            System.out.println("Thank you for booking your flights with FLIGHT_COMPANY.\n" +
                    "You reserved a total of " + number + " tickets.");
        for (int m = 0; m < number; m++) {
            System.out.println("Here are the trip details for Passenger No. " + m + "\nPassenger's Ticket Number: " +
                    ticketNumber[m] + "\nPassenger's Full Name: " + passengerFullName[m] + "\nPassenger's Age: " +
                    passengerAge[m] + "\nPassenger's Gender: " + passengerGender[m] + "\nFrom: " + tripSource + "(" + sourceAirport + ")\nTo: " + tripDestination +
                    "(" + destinationAirport + ")\nThe flight departs on: " + departureDate + "\nAnd the return flight is on: " + returnDate);


        }


    }
}
