import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.io.*;
import java.util.*;

public class TarotCardServer {
	public static void main(String[] args) {
		//list of tarot cards
		List<String> cards = new ArrayList<>(List.of("The Fool", "The Magician", "The High Priestess", "The Empress",
				"The Emperor", "The Hierophant", "The Lovers", "The Chariot",
				"Strength", "The Hermit", "Wheel of Fortune", "Justice", "The Hanged Man",
				"Death", "Temperance", "The Devil", "The Tower", "The Star",
				"The Moon", "The Sun", "Judgement", "The World"));
		
		//define default port and check for port given through args
    	int port = 21540;
    	if (args.length > 0) {
    		try { port = Integer.parseInt(args[0]); }
    		//use default port if parsing fails
    		catch (NumberFormatException e) {}
    	}
    	//create server socket, when client connects give 3 random cards and exit
	    try (ServerSocket s = new ServerSocket(port)) {
	    	System.out.println("Waiting for client");
	    	//accept client connections forever
	    	while(true) {
	    		//wait for client to connect and create output stream
	            try (Socket client = s.accept();
	                PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {
	            	System.out.println("Connected to client");
	            	//shuffle cards list and send
	        	    Collections.shuffle(cards);
	        	    out.print(cards.get(1) + ", " + cards.get(5) + ", " + cards.get(9) + "\n");
	            }
	    	}
	    } catch (IOException e) {
	    	//handle errors
	        e.printStackTrace();
	    }
	}

}
