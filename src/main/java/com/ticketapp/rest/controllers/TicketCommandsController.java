package com.ticketapp.rest.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.ticketapp.rest.domain.TicketRest;
import com.ticketapp.services.api.TicketService;
import com.ticketapp.services.api.objects.TicketDetails;

@Controller
@RequestMapping(value = "/api/v1/tickets")
public class TicketCommandsController {

	@Autowired
	private TicketService ticketService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<TicketRest> create(@RequestBody @Valid TicketRest ticket, UriComponentsBuilder builder) {

		TicketDetails ticketCreated = ticketService.save(ticket.toTicketDetails());

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/api/v1/tickets/{code}")
				.buildAndExpand(String.valueOf(ticketCreated.getCode())).toUri());

		TicketRest output = TicketRest.fromTicketDetails(ticketCreated);
		return new ResponseEntity<TicketRest>(output, headers, HttpStatus.CREATED);
	}

}
