package com.ticketapp.rest.domain;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.BeanUtils;

import com.ticketapp.services.api.objects.TicketDetails;

@XmlRootElement
public class TicketRest {

	private int code;
	private Date creation;
	private String account;
	@Max(5)
	@Min(1)
	private int priority;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public static TicketRest fromTicketDetails(TicketDetails ticket) {
		TicketRest rest = new TicketRest();
		BeanUtils.copyProperties(ticket, rest);
		return rest;
	}

	public TicketDetails toTicketDetails() {
		TicketDetails transferObject = new TicketDetails();
		BeanUtils.copyProperties(this, transferObject);
		return transferObject;
	}

	@Override
	public String toString() {
		return "TicketRest [code=" + code + ", creation=" + creation + ", account=" + account + ", priority="
				+ priority + "]";
	}

	
}
