import java.net.*;
import java.io.*;

import javax.swing.JOptionPane;

public class UDPClient{
    public static void main(String args[]){ 
		// args give message contents and destination hostname
		
    	JOptionPane.showMessageDialog(null, "Bem vindo(a) a calculadora remota Tavinho Powers");
    	
		String ip = JOptionPane.showInputDialog("Digite do IP do servidor");
		String port = JOptionPane.showInputDialog("Digite a porta do servidor");
    	
		String msg = JOptionPane.showInputDialog ("Digite dois números e o operador separador por espaços. Ex:(10 2 /)");
	
    	DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket();    
			byte [] m = msg.getBytes();
			InetAddress aHost = InetAddress.getByName(ip);
			
			int serverPort = Integer.parseInt(port);		                                                 
			
			DatagramPacket request =
			 	new DatagramPacket(m,  msg.length(), aHost, serverPort);
			aSocket.send(request);			                        
			
			byte[] buffer = new byte[1000];
			
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);	
			aSocket.receive(reply);
			
			String s = new String (reply.getData());
			
			
			//System.out.println("Resultado da operação: " + args[0] + " = " + s);
			JOptionPane.showMessageDialog(null, "Resultado da operação: " + msg + " = " + s);
		
		}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		}catch (IOException e){System.out.println("IO: " + e.getMessage());
		}finally {if(aSocket != null) aSocket.close();}
	}		      	
}