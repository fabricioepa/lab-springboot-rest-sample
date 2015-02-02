package com.ticketapp.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketapp.services.api.TicketService;
import com.ticketapp.services.api.objects.TicketDetails;
import com.ticketapp.services.domain.Account;
import com.ticketapp.services.domain.Ticket;
import com.ticketapp.services.repository.AccountRepository;
import com.ticketapp.services.repository.TicketRepository;

/**
 * Internal implementation of the {@link TicketService}. This class should
 * not be accessed directly.
 */
@Service
@Transactional
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<TicketDetails> getAll() {
		List<Ticket> entities = ticketRepository.findAll();
		List<TicketDetails> output = new ArrayList<TicketDetails>();
		for (Ticket entity : entities) {
			output.add(entity.toTicketDetails());
		}
		return output;
	}

	@Override
	public List<TicketDetails> getAllByPriority(int priority) {
		List<Ticket> entities = ticketRepository.findAll();
		List<TicketDetails> output = new ArrayList<TicketDetails>();
		for (Ticket entity : entities) {
			output.add(entity.toTicketDetails());
		}
		return output;
	}

	@Override
	public TicketDetails save(TicketDetails ticket) {
		Ticket entity = Ticket.fromTicketDetails(ticket);

		// Use case rules go here
		// Use service composition to call other services
		entity.setCreation(new Date());
		Account account = accountRepository.findOne(ticket.getAccount());
		entity.setAccount(account);
		entity = ticketRepository.save(entity);

		return entity.toTicketDetails();

	}

	@Override
	public TicketDetails getByCode(int code) {
		Ticket domain = ticketRepository.findOne(code);
		if (domain == null) {
			return null;// not found
		}
		return domain.toTicketDetails();
	}

}
