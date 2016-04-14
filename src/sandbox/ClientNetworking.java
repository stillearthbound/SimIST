/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author kjrya
 * 
 * Player movement variables!!!!!!!!!!
 *   private int oldX;      
    private int oldY;

 */

public class ClientNetworking {    
   //Input and Output
    private ObjectInputStream sInput;
    private ObjectOutputStream sOutput;
    private Socket socket;

    //Server, port
    private String server;
    private int port;
    
    
    
  ClientNetworking(String server, int port) {
      this.server = server;
      this.port = port;
      this(server, port);
    }
  
  public boolean start(){
      
      try{
          socket = new Socket (server, port);
      }
      catch(Exception ec){
          display("Error connection to server: " + ec);
          return false;
      }
      
      String msg = "Connection accepted " + socket.getInetAddress()+ ":" +
              socket.getPort();
                display(msg);
                
        try{
            sInput = new ObjectInputStream(socket.getInputStream());
            sOutput = new ObjectOutputStream(socket.getOutputStream());
        }        
        catch(IOException eIO){
            display("Exception creating new Input/ output Streams: " + eIO);
            return false;
        }
                
        //Creating thread that listens to the server
        new ListenFromServer().start();
        
        private void display(String msg){
            if(cg == null)
                System.out.println(msg);
            else
                cg.append(msg + "\n");
        }
        
        void sendMessage(ChatMessage msg){
            try{
                sOutput.writeObject(msg);
            }
            catch(IOException e){
                display("Exception writing to server: " + e);             
            }
        }
        
          private void disconnect() {
        try {
            if(sInput != null) sInput.close();
        }
        catch(Exception e) {} // not much else I can do
        try {
            if(sOutput != null) sOutput.close();
        }
        catch(Exception e) {} // not much else I can do
        try{
            if(socket != null) socket.close();
        }
        catch(Exception e) {} // not much else I can do
          }
          
          public static void main(String[] args){
              int portNumber =1300;
              String serverAddress = "localhost";
              
                   switch(args.length) {
           
              case 2:
                serverAddress = args[2];
            // > javac Client username portNumber
              case 1:
                try {
                    portNumber = Integer.parseInt(args[1]);
                }
                catch(Exception e) {
                    System.out.println("Invalid port number.");
                    System.out.println("Usage is: > java Client [username] [portNumber] [serverAddress]");
                    return;
                }
              case 0:
                  break;
                  
                  Client client = new Client (serverAddress, portNumber);
                  if(!client.start())
                      return;
                  //wait for message from the user
                  Scanner scan = new Scanner(System.in);
                  
                  while(true){
                      System.out.print(">");
                      //read message
                      String msg = scan.nextLine();   
                  }} 
                   
           class ListenFromServer extends Thread {
               public void run(){
                   while(true) {
                       try{
                           String msg = (String) sInput.readObject();
                       
                           if(cg == null{
                               System.out.println(msg);
                           }else {
                               cg.append(msg);
                           }
                       }
                       catch(IOException e){
                           display("Server has close the connection: " + e);
                           if(cg !=null)
                               cg.connectionFailed();
                           break;
                       }
                       catch (ClassNotFoundException e2){}                  
                   }                        
               }
           }
    
          }      
  }
  
