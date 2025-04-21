package PiercePokorny.airticket.tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cc.airline.passengers.Passenger;
import com.cc.airline.passengers.PassengerName;
import com.cc.airline.passengers.StaffPassenger;
import com.cc.airline.ticketing.Seat;
import com.cc.airline.ticketing.SeatingClass;
import com.cc.airline.ticketing.Ticket;

public class SellTicketTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Starting test of the SellTicket default constructor");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Ending test");
	}



	@Test
	public void sellTicket1() {
		SeatingClass sClass = SeatingClass.ECONOMY;
		Passenger passenger = new Passenger(new PassengerName("Pierce", "", "Pokorny"));
		Seat seat = new Seat();
		seat.setRow(3);
		seat.setLetter('D');
		double price = sClass.getPrice();
		Ticket ticket = new Ticket(passenger, seat, price);
		System.out.println("Ticket issued: " + ticket);
		assertEquals(ticket.getPrice(), 500.0, 0.005);
	}

	@Test
	public void sellTicket2() {
		SeatingClass sClass = SeatingClass.ECONOMY;
		StaffPassenger staffPassenger = new StaffPassenger(new PassengerName("Pierce", "", "Pokorny"), "EMP123");
		Seat seat = new Seat();
		seat.setRow(3);
		seat.setLetter('B');
		double price = sClass.getPrice();
		Ticket ticket = new Ticket(staffPassenger, seat, price);
		System.out.println("Ticket issued: " + ticket);
		assertEquals(ticket.getPrice(), 250.0, 0.005);
	}
	
	@Test
	public void sellTicket3() {
		SeatingClass sClass = SeatingClass.BUSINESS;
		StaffPassenger staffPassenger = new StaffPassenger(new PassengerName("Pierce", "", "Pokorny"), "EMP123");
		Seat seat = new Seat();
		seat.setRow(3);
		seat.setLetter('B');
		double price = sClass.getPrice();
		Ticket ticket = new Ticket(staffPassenger, seat, price);
		System.out.println("Ticket issued: " + ticket);
		assertEquals(ticket.getPrice(), 750, 0.005);
	}
}
