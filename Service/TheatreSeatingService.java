package com.service;
import java.util.List;
import com.command.TheaterLayout;
import com.command.TheaterRequest;

	public interface TheatreSeatingService {
	    
	    TheaterLayout getTheaterLayout(String rawLayout);
	    
	    List<TheaterRequest> getTicketRequests(String ticketRequests);
	    
	    void processTicketRequests(TheaterLayout layout, List<TheaterRequest> requests);

	}


