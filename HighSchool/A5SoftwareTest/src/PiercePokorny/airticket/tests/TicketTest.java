package PiercePokorny.airticket.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cc.airline.passengers.Passenger;
import com.cc.airline.passengers.PassengerName;
import com.cc.airline.ticketing.Seat;
import com.cc.airline.ticketing.Ticket;


public class TicketTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTicket() {
		Passenger passenger = new Passenger(
				 new PassengerName("Pierce", "", "Pokorny"));
		
		Seat seat = new Seat();
		seat.setRow(2);
		seat.setLetter('C');
		Ticket ticket = new Ticket(passenger, seat, 500);
		assertTrue(ticket.getTicketNo() > 1000000 );
	}

	@Test
	public void testTicketBad() {
	 assertThrows(IllegalArgumentException.class, ()->{
	Ticket ticket = new Ticket(null, null, -100.0);} );
	}

}
