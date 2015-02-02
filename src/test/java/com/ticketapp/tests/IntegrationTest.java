package com.ticketapp.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ticketapp.TicketappApplication;
import com.ticketapp.services.api.TicketService;
import com.ticketapp.services.api.objects.TicketDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TicketappApplication.class)
public class IntegrationTest {

	@Autowired
	private TicketService ticketService;

	@Test
	public void testCreateTicket() {

		TicketDetails ticket = new TicketDetails();
		ticket.setAccount("root");
		ticket.setPriority(5);

		TicketDetails output = ticketService.save(ticket);

		assertEquals(5, output.getPriority());
		assertTrue(output.getCode() > 0);
	}

}
