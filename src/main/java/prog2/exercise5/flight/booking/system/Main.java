package prog2.exercise5.flight.booking.system;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String args[]) throws ParseException {

       /* Scanner sc = new Scanner(System.in);


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
        FlightBooking fb = new FlightBooking(name,departure,return1,child,adults);
        System.out.println("Please select the class you would like to travel in (1.First, 2.Business, 3.Economy please enter the number):");
        String select = sc.next();
        fb.setBookingClass(select);
        System.out.println("Please select the trip type(1. One way 2. Return, enter 1 or 2)");
        String type = sc.next();
        fb.setTripType(type);
        System.out.println("Please chose one of the trip sources(1. Nanjing 2. Beijing 3. Oulu 4. Helsinki,please enter the number) ");
        String source = sc.next();
        fb.setTripSource(source);
        System.out.println("Please chose one of the trip destination(1. Nanjing 2. Beijing 3. Oulu 4. Helsinki,please enter the number)");
        String destination = sc.next();
        fb.setTripDestination(source,destination);
        fb.setClassification(source,destination);
        fb.setPassengerFullName(reserve,name);

        System.out.println(fb);*/
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of the total number of tickets you want to reserve. ");
        int number = sc.nextInt();
        FlightBooking flightBooking =new FlightBooking(number);
        flightBooking.reserveTickets(number);
        flightBooking.displayTripDetails(number);
    }

}