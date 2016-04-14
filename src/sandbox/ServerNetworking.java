/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;


import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.io.*;
import java.net.*;
import java.util.*;


/**
 *
 * @author kjrya
 */
public class ServerNetworking 
{
    private static int connectionID;
    private ArrayList<ClientThread> connectionList;
    private static int port = 44221;
    private boolean running;
    
    
    public ServerNetworking(int port){
        this.port = port;
        connectionList = new ArrayList<ClientThread>();
    }
    
    public static void main(String[] args) 
    {
        switch(args.length)
        {
            case 1:
                try{
                    port = Integer.parseInt(args[0]);
                } 
                catch(Exception e)
                {
                    System.out.println("Invalid port number");
                    System.out.println("Usage is: > java Server [port]");
                }
            case 0:
                break;
            default:
                System.out.println("Usage is: > java Server [port]");
        }
        ServerNetworking server = new ServerNetworking(port);
        server.start();
    }
    
    public void start()
    {
        running = true;
        
        try
        {
            ServerSocket serverSocket = new ServerSocket(port);
            
            while(running)
            {
                System.out.println("Server waiting for connections...");
                
                Socket socket = serverSocket.accept();
                
                if(!running){
                    break;
                }
                
                ClientThread t = new ClientThread(socket);
            }
        } catch(IOException e){
        
        }    
        
    }
    
    
    private void display(String message)
    {
        System.out.println(message);
    }
    
    
    synchronized void remove(int id)
    {
        for(int i = 0; i < connectionList.size(); i++)
        {
            ClientThread ct = connectionList.get(i);
            if(ct.id == id)
            {
                connectionList.remove(id);
                return;
            }
            
        }
        
    }
    
    synchronized void broadcast(String message)
    {
        System.out.println(message);
        
        for(int i = connectionList.size(); i-- >= 0;)
        {
            ClientThread ct = connectionList.get(i);
            
            if(!ct.writeMsg(message)){
                connectionList.remove(i);
                display("Disconnected Client "+ct.id+" removed from list.");
            }
        }
    }
    
    
    class ClientThread extends Thread{
        
        Socket socket;
        ObjectInputStream incoming;
        ObjectOutputStream outgoing;
        
        int id;
        
        ChatMessage cm;
        
        ClientThread(Socket socket)
        {
            id = ++connectionID;
            this.socket = socket;
            
            System.out.println("Thread trying to create Object Input/Output streams");
            try
            {
                outgoing = new ObjectOutputStream(socket.getOutputStream());
                incoming = new ObjectInputStream(socket.getInputStream());
                
                display("ID: "+id+" has connected");
                
            } catch(IOException e)
            {
                display("Exception creating Input/output streams.");
            }
        }
        
        public void run()
        {
            boolean running = true;
            
            while(running){
                try
                {
                    cm = (ChatMessage) incoming.readObject();
                    
                } 
                catch(IOException e)
                {
                    display("ID: "+id+" exception reading streams");
                    break;
                } 
                catch(ClassNotFoundException e2)
                {
                    break;
                }
                
                String message = cm.getMessage();
                
                switch(cm.getType()){
                        
                    case ChatMessage.MESSAGE:
                        broadcast("ID: "+id+" "+message);
                        break;
                        
                    case ChatMessage.LOGOUT:
                        display("ID: "+id+" has disconnected");
                        break;
                        
                    case ChatMessage.WHOISIN:
                        writeMsg("All users connected:");
                        for(int i = 0; i < connectionList.size(); i++){
                            ClientThread ct = connectionList.get(i);
                            System.out.println(ct.id);
                        }
                        
                    break; 
                   
                }
                
            }
            
            remove(id);
            close();
            
        }
        
        private void close(){
            try
            {
                if(outgoing != null) outgoing.close();
            } catch (Exception e){}
            try
            {
                if(incoming != null) incoming.close();
            } catch (Exception e){}
            try
            {
                if(socket != null) socket.close();
            } catch (Exception e) {}
        }
        
        private boolean writeMsg(String msg){
            
            if(!socket.isConnected())
            {
                close();
                return false;
            }
            
            try
            {
                outgoing.writeObject(msg);
            } catch(IOException e){
                display("Error sending message to " +id);
                display(e.toString());
            }
            return true;
        }
        
    }
    
}
