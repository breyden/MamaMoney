package com.mkyong;
import java.util.*;
import java.math.BigDecimal;

public class Menu {

	private Map<String, String> requests;

	private Map<String, String> messages;
	private Map<String, BigDecimal> amount; // amount in Rands
	private Map<String, String> country;
	private Map<String, String> currencyCode;

	public Menu()
	{
		requests = new HashMap<>();

		messages = new HashMap<String, String>();

		this.messages.put("0", Message.MENU_0);
		this.messages.put("1", Message.MENU_1);
		this.messages.put("2", Message.MENU_2);
		this.messages.put("3", Message.MENU_3);

		amount = new HashMap<String, BigDecimal>();
		country = new HashMap<String, String>(); // country to send money to.
		
		currencyCode = new HashMap<String, String>(); // country currencycode.
		this.currencyCode.put("Kenya", "KES");
		this.currencyCode.put("Malawi", "MWK");
	}

    public Response processRequest(Request req)
	{
		if (!requests.isEmpty())
		{
			if(requests.containsKey(req.getMsisdn()))
			{
				// user specified the country to transfer the money to
				if (requests.get(req.getMsisdn()).equals("0"))
				{
					
					if (req.getUserEntry().equals("1"))
					{
						country.put(req.getMsisdn(),"Kenya");
					}
					else if (req.getUserEntry().equals("2"))
					{
						country.put(req.getMsisdn(),"Malawi");
					}

					requests.put(req.getMsisdn(), "1");
					return new Response(req, messages.get("1")+" "+ country.get(req.getMsisdn()));
				}

				// user specified tthe amount to transfer.
				else if (requests.get(req.getMsisdn()).equals("1"))
				{

					if (country.get(req.getMsisdn()).equals("Kenya"))
					{
						amount.put(req.getMsisdn(), new BigDecimal(req.getUserEntry()).multiply(new BigDecimal("6.10")));
					}
					else if (country.get(req.getMsisdn()).equals("Malawi"))
					{
						amount.put(req.getMsisdn(), new BigDecimal(req.getUserEntry()).multiply(new BigDecimal("42.50")));
					}

					requests.put(req.getMsisdn(), "2");
					return new Response(req, messages.get("2")+" "+ amount.get(req.getMsisdn())+" "+ currencyCode.get(country.get(req.getMsisdn()))+"\n"+"1.OK");
				}
				else if (requests.get(req.getMsisdn()).equals("2"))
				{
					if (req.getUserEntry().equals("1"))
					{	//  restart the journey
						requests.remove(req.getMsisdn());
						amount.remove(req.getMsisdn());
						country.remove(req.getMsisdn());
						
						return new Response(req, messages.get("3"));
					}

				}

			}
			else
			{

			}
		}
		else
		{
			//Menu 1
			if ( (!requests.containsKey(req.getMsisdn())) && req.getUserEntry()==null)
			{
				requests.put(req.getMsisdn(), "0"); // keeps track of where the user is.
				return new Response(req, messages.get("0"));
			}

		}

		
		return new Response(req, messages.get("0"));
    }

	public static class Message
	{
		public static final String MENU_0				= "Welcome to Mama money! Where would you like to send money today?"+ 
		"\n"+ "1. Kenya" + "\n"+ "2. Malawi"+ "\n";
		public static final String MENU_1				= "How much money(in Rands) would you like to send to";
		public static final String MENU_2				= "Your person you are sending to will receive:";
		public static final String MENU_3				= "Thank you for using Mama Money!";
	}
}