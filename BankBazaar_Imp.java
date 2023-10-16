package com.BankBazaar;

import java.util.Scanner;
public class BankBazaar_Imp implements BankBazaar{ //Inheritance
	static Scanner s=new Scanner(System.in);
	public static boolean flag=true;//Non-Static Variable
	public boolean signupdone=false;
	public static String eid;
    private static String pwd;//Encapsulation
	public static long pno;
	public static long pco;
	public BankBazaar_Imp(String eid,String pwd)//Constructor Overloading
	{
		this.eid=eid;
		this.pwd=pwd;
	}
	public BankBazaar_Imp(String eid,String pwd,long pno,long pco)
	{
		this(eid,pwd);//Constructor Chaining
		this.pno=pno;
		this.pco=pco;
	}

	@Override
	public void citizenship() throws Exception//Abstraction
	{
		System.out.println("Citizenship: \n1.Indian \n2.NRI");
		int c=s.nextInt();
	}
	@Override
	public void loanCategory() throws Exception {
		    
		do {
			citizenship();
			System.out.println("Loan Category: \n1.Personal Loan \n2.Home Loan \n3.Bike Loan \n4.Educational Loan");
			int lc=s.nextInt();
			if(lc==1 || lc==2 || lc==3 || lc==4)
			{
			System.out.print("\nOTP:");
		    int sys_otp=(int)(Math.random()*999+999);
		    System.out.println(sys_otp);
			System.out.print("Verify OTP:");
			int otp=s.nextInt();
			if (otp==sys_otp)
			{
			   System.out.println("OTP is verified successfully");
			   Thread.sleep(500);
			   System.out.println("Aadhar No: "+aadharno+" is validated");
			   Thread.sleep(500);
			   cardsCategory();
		    }
			else
			{
				System.err.println("Invalid OTP");
			}
			}
			else
			{
				System.err.println("Invalid Input");
			}
			}while(flag);
	}
	@Override
	public void cardsCategory() throws Exception{
		
		System.out.println("Cards Category:\n1.Debit Card \n2.Credit Card");
		int cc=s.nextInt();
		   switch(cc)
		   {
		   case 1:
		   {
			   System.out.println("Debit Card is selected");
			   System.out.println("Thank you for Banking");
			   flag=false;
			  
		   }
		   break;
		   case 2:
		   {
			   System.out.println("Credit Card is selected");
			   System.out.println("Thank you for Banking");
			   flag=false;
			  
		   }
		   break;
		   default:
		   {
			   System.err.println("Invalid Input");
		   }
		   }
	}
	public void visaCategory()throws Exception
	{
		
		do {
			citizenship();
			System.out.println("Visa Category \n1.Travel Visa \n2.Student Visa \n3.Business Visa");
			int vc=s.nextInt();
			if(vc==1 || vc==2 || vc==3)
			{
			System.out.print("\nOTP:");
		    int sys_otp=(int)(Math.random()*999+999);
		    System.out.println(sys_otp);
			System.out.print("Verify OTP:");
			int otp=s.nextInt();
			if (otp==sys_otp)
			{
			   System.out.println("OTP is verified successfully");
			   Thread.sleep(500);
			   System.out.println("Aadhar No: "+aadharno+" is validateds");
			   cardsCategory();
		    }
			else
			{
				System.err.println("Invalid OTP");
			}
			}
			else
			{
				System.err.println("Invalid Input");
			}
			}while(flag);
	}
	public void signup() throws Exception 
	{
		if (signupdone==false)
		{
		System.out.println("\t\tCreate an Account");
		System.out.println("\tSignUp");
		System.out.println("Customer Name: "+cname);
		System.out.println("Aadhar No: "+aadharno);
		System.out.print("Email Id:");
		eid=s.next();
		System.out.print("Phone no:");
		pno=s.nextLong();
		System.out.print("Pincode:");
		pco=s.nextLong();
		do
		{
		System.out.print("Password:");
		pwd=s.next();
		System.out.print("Confirm Password:");
		String cpwd=s.next();
		if (pwd.equals(cpwd))
		{
			do
			{
			System.out.print("\nOTP:");
		    int sys_otp=(int)(Math.random()*999+999);
		    System.out.println(sys_otp);
			System.out.print("Verify OTP:");
			int otp=s.nextInt();
			if (otp==sys_otp)
			{
			   System.out.println("OTP is verified successfully");
			   Thread.sleep(500);
			   System.out.println("\n*Details of the Customer*");
			   System.out.println("Name:"+cname);
			   System.out.println("Email Id:"+eid);
			   System.out.println("Aadhar No:"+aadharno);
			   System.out.println("Phone No:"+pno);
			   System.out.println("Pincode:"+pco);
			   System.out.println("*************************");
			   Thread.sleep(500);
			   System.out.println("Successfully Signedup");
			   flag=false;
			   signupdone=true;
		    }
			else
			{
				System.err.println("Wrong OTP");
				System.out.println("Resend OTP");
			}
			Thread.sleep(500);
			}while(flag);	
		}
		else
		{
			System.err.println("Password Mismatch");
		}
		Thread.sleep(500);
		}while(flag);
		}
		else
		{
			System.err.println("Signup is already done");
			System.err.println("Please Login");
			Thread.sleep(1000);
			login();
		}
	}
	public void login() throws Exception
	{
		if(signupdone==true) {
		do {
			System.out.println("\n\tLogin");
		System.out.print("\nEmail Id:");
		String ceid=s.next();
		if (eid.equals(ceid))
		{
			System.out.print("Password:");
			String cpwd=s.next();
			if(pwd.equals(cpwd))
			{
				System.out.println("\t\t\tLogin Successful");
				flag=true;
				do {
				System.out.println("\nChoose the Task:\n1.Loan Category \n2.Visa Category");
	            int t=s.nextInt();
				switch (t)
				{
				case 1:
				{
					loanCategory();
				}
				break;
				case 2:
				{
					
					visaCategory();
					flag=false;
				}
				break;
				default:
				{
					System.err.println("Invalid Input");
				}
				}
				
				}while(flag);
			}
			else
			{
				System.err.println("Wrong Password");
				System.err.println("Forget Password?");
				System.out.print("\nNew Password:");
				pwd=s.next();
				System.out.print("Confirm Password:");
				cpwd=s.next();
				System.out.println();
				flag=true;	
			}
		}
		else
		{
			System.err.println("Invalid Email Id");
			flag=true;
		}
		}while(flag);
		}
		else
		{
			System.err.println("Signup First");
			signup();
		}
	}
	public void logout() {
		System.out.println("Logout \nyes or no");
		String l=s.next();
		if(l.equals("yes"))
		{
		System.out.println("Logout Successful");
		}
		else
		{
			System.out.println("Back to Home Page");
		}
	}
	public static void main(String[] args) throws Exception {
		BankBazaar_Imp b=new BankBazaar_Imp(eid,pwd,pno,pco);
		System.out.println("\t\t\tWelcome to BankBazaar");
		do {
		System.out.println("\nChoose the option: \n1.SignUp \n2.Login \n3.Logout");
		int opt=s.nextInt();
		switch (opt)
		{
		case 1:
		{
			b.signup();
			flag=true;
		}
		break;
		case 2:
		{
			b.login();
			flag=true;
		}
		break;
		case 3:
		{
			b.logout();
			flag=false;
		}
		break;
		default:
		{
			System.err.println("Invalid Input");
		}
		}
		}while(flag);
	}
}
