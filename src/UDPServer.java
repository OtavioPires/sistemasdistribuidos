import java.net.*;
import java.io.*;

import javax.swing.JOptionPane;

public class UDPServer{

	public static void main(String args[]){ 
    	DatagramSocket aSocket = null;
    	
    	try{
	    	aSocket = new DatagramSocket(6789);
					// create socket at agreed port
			byte[] buffer = new byte[1000];
 			
			while(true){
 				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
  				aSocket.receive(request);     
    			
    			String s = new String (request.getData());
    			String delimiter = "[ ]+"; 
    			String[] tokens = s.split(delimiter);
    			
    			//[[:digit:]]
    			if (tokens[1] == "0" && tokens[2] == "/") 
    				JOptionPane.showMessageDialog(null, "Impossivel realizar divisões por zero");
    			
    			//System.out.println(tokens[0]+tokens[1]+tokens[2]);
    			
    			char operator = tokens[2].charAt(0);
    			
    			Calculator c = new Calculator();
    			
    			
    			byte [] r = c.calcule(Float.parseFloat(tokens[0]),Float.parseFloat(tokens[1]),operator).getBytes();
  				
    			DatagramPacket reply = new DatagramPacket(r, r.length, request.getAddress(), request.getPort());
    			aSocket.send(reply);
    			
    			//System.out.println("IP do cliente: " + request.getAddress() + "\nPorta do cliente: " + request.getPort());
    			
    			
			}
		
    	}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
    	}catch (IOException e) {System.out.println("IO: " + e.getMessage());
    	}finally {if(aSocket != null) aSocket.close();}
    }

}