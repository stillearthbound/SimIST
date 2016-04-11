/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

import java.io.*;
import java.net.*;

/**
 *
 * @author kjrya
 */
public class ClientNetworking
{
    
    public static void main(String args[]) throws Exception
    {
        String outgoingData;
        String modifiedOutgoing;
        BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
        Socket clientSocket = new Socket("104.39.43.169", 44221);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        outgoingData = inFromUser.readLine();
        outToServer.writeBytes(outgoingData+'\n');
        modifiedOutgoing = inFromServer.readLine();
        System.out.println("FROM SERVER: "+ modifiedOutgoing);
        clientSocket.close();
    }
    
}
