package com.ticketapp.rest.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ticketapp.rest.domain.TicketRest;
import com.ticketapp.services.api.TicketService;
import com.ticketapp.services.api.objects.TicketDetails;

@Controller
@RequestMapping(value = "/api/v1/tickets")
public class TicketQueriesController {

	@Autowired
	private TicketService ticketService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<TicketRest> getAll() {
		List<TicketRest> tickets = new ArrayList<TicketRest>();
		for (TicketDetails ticket : ticketService.getAll()) {
			tickets.add(TicketRest.fromTicketDetails(ticket));
		}
		return tickets;
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	@ResponseBody
	public TicketRest getById(@PathVariable int code) {
		TicketDetails transfer = ticketService.getByCode(code);
		return TicketRest.fromTicketDetails(transfer);
	}

	@RequestMapping(method = RequestMethod.GET, value = "priority/{priority}")
	@ResponseBody
	public Collection<TicketRest> get(@PathVariable int priority) {
		List<TicketRest> tickets = new ArrayList<TicketRest>();
		for (TicketDetails ticket : ticketService.getAllByPriority(priority)) {
			tickets.add(TicketRest.fromTicketDetails(ticket));
		}
		return tickets;
	}

}
