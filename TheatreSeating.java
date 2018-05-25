
package com.main;

import java.util.List;
import java.util.Scanner;
import com.command.TheaterLayout;
import com.command.TheaterRequest;
import com.service.TheatreSeatingService;
import com.service.TheatreSeatingServiceImpl;


public class TheatreSeating {
	    
	public static void main(String[] args) {
	        
	        String line;
	        StringBuilder layout = new StringBuilder();
	        StringBuilder ticketRequests = new StringBuilder();
	        boolean isLayoutFinished = false;
	        
	        System.out.println("Please enter Theater Layout and Ticket requests and then enter 'done'.\n");
	        
	        Scanner input = new Scanner(System.in);

	        while((line = input.nextLine()) != null && !line.equals("done")){
	            
	            if(line.length() == 0){
	                
	                isLayoutFinished = true;
	                continue;
	                
	            }
	            
	            if(!isLayoutFinished){
	                
	                layout.append(line + System.lineSeparator());
	                
	            }else{
	                
	                ticketRequests.append(line + System.lineSeparator());
	                
	            }
	            
	        }
	        
	        input.close();
	        
	        TheatreSeatingService service = new TheatreSeatingServiceImpl();
	        
	        try{
	        
	            TheaterLayout theaterLayout = service.getTheaterLayout(layout.toString());
	            
	            List<TheaterRequest> requests = service.getTicketRequests(ticketRequests.toString());
	            
	            service.processTicketRequests(theaterLayout, requests);
	            
	        }catch(NumberFormatException nfe){
	            
	            System.out.println(nfe.getMessage());
	            
	        }catch(Exception e){
	            
	            e.printStackTrace();
	            
	        }   
	    }

	}


