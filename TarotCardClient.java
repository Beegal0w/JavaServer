import java.net.InetAddress;
import java.net.Socket;
import java.io.*;
import java.util.*;

public class TarotCardClient {
	public static void main(String[] args) {
		//default ip and port
		String ip = "54.224.87.65";
		int port = 21540;
		
		//check ip and port from arguments
        if (args.length >= 1) ip = args[0];
        if (args.length >= 2) {
            try {
                port = Integer.parseInt(args[1]);
                //use default port if parsing fails
            } catch (NumberFormatException e) {
                System.out.println("Invalid port number, using default: " + port);
            }
        }
        System.out.println("Connecting to " + ip + ":" + port);
        //create socket and buffer reader, close when done
		try(Socket s = new Socket(ip, port); BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()))) {
		    //read what the server sends
		    String cards = in.readLine();
		    System.out.println("Cards received: " + cards);
	        System.out.println(InetAddress.getLocalHost().getHostAddress());
		    } catch (IOException e) {
		    	//handle errors
	            e.printStackTrace();
	    }
	}
}
