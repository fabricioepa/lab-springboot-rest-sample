package com.ticketapp.services.api;

import java.util.List;

import com.ticketapp.services.api.objects.TicketDetails;

/**
 * Ticket Service - Use Case API
 */
public interface TicketService {

	List<TicketDetails> getAll();

	List<TicketDetails> getAllByPriority(int priority);

	TicketDetails save(TicketDetails ticket);

	TicketDetails getByCode(int code);

}
