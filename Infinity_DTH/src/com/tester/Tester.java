package com.tester;

import java.sql.*;
import java.util.Scanner;
import java.time.*;

import com.bean.Operator;
import com.bean.PasswordManager;
import com.dao.OperatorDAO;
import com.dao.PasswordManagerDAO;

public class Tester
{
	public static void main(String[] args) throws Exception {
		String jdbcURL =  "jdbc:derby:testdb1;create=true";
		Connection connection = DriverManager.getConnection(jdbcURL);
		System.out.println("The connection is established successfully");
		
		PasswordManagerDAO pwdManagerDAO = new PasswordManagerDAO();
		PasswordManager pwdManager = new PasswordManager(1, "Infinadmin", "Admin@Infin123", 1);
		
		OperatorDAO operatorDAO = new OperatorDAO();
		
		Scanner sc = new Scanner(System.in);
		
		pwdManagerDAO.createTable(connection);
		operatorDAO.createTable(connection);
		pwdManagerDAO.addAdmin(connection, pwdManager);
		
		//while loop starts here
		while(true) {
			while(true) {
				System.out.println("<-------------------------------------------Welcome to Infinity DTH------------------------------------------->");
				System.out.print("User Name: ");
				String userName = sc.nextLine();
				System.out.print("\nPassword: ");
				String defaultPasswd = sc.nextLine();
				
				
				if(pwdManager.getUserName().equals(userName) && pwdManager.getPassword().equals(defaultPasswd)) {
					if(pwdManagerDAO.fetchLoginStatus(connection, pwdManager) == 1) {
						System.out.print("User Name: ");
						String usrName = sc.nextLine();
						System.out.print("\nOld Password: ");
						String oldPasswd = sc.nextLine();
						System.out.print("\nNew Password: ");
						String newPasswd = sc.nextLine();
						System.out.print("\nRetype Password: ");
						String retypePasswd = sc.nextLine();
						
						if(isPasswordValid(oldPasswd, newPasswd, retypePasswd)) {
							int result = pwdManagerDAO.updateAdminDetails(connection, pwdManager);
							if(result == 0) {
								System.out.println("Try Again");
							}
							else {
								System.out.println("Password Changed Successfully!!");
							}
							break;
						}
					}
					if(pwdManager.getId() == 1) //1-Admin
					{
						System.out.println("1.Operator Registration\n2.Operator Details\n3.Customer Registration\n4.Customer Details");
						int choice = Integer.parseInt(sc.nextLine());
						switch(choice) {
							case 1:
								Operator operator = operatorRegistration();
								operatorDAO.insertOperatorDetails(connection, operator);
								break;
						}
					}
				}
			}
		}
	}
	
	public static Operator operatorRegistration() {
		Scanner sc = new Scanner(System.in);
		System.out.println("<-------------------------------------------Infinity Operator Registration------------------------------------------->");
		System.out.print("First Name: ");
		String fName = sc.nextLine();
		System.out.print("\nLast Name: ");
		String lName = sc.nextLine();
		System.out.println("\nEmail ID: ");
		String email = sc.nextLine();
		System.out.println("\nPhone Number: ");
		String phoneNumber = sc.nextLine();
		System.out.print("\nShift Start Time: ");
		int startTime = Integer.parseInt(sc.nextLine());
		System.out.print("\nMax no. of Customers to be managed: ");
		int maxCustomer = Integer.parseInt(sc.nextLine());
		LocalDate date = LocalDate.now();
		String creationDate = date.getDayOfMonth()+"/"+date.getMonthValue()+"/"+date.getYear();
		int endTime = startTime + 8;
		
		Operator operator = new Operator(fName, lName, email, phoneNumber, startTime, endTime, maxCustomer, creationDate);
		return operator;
	}

	public static boolean isPasswordValid(String oldPasswd, String newPasswd, String retypePasswd) {
		if(!((newPasswd == retypePasswd) && (newPasswd != oldPasswd))) {
			return false;
		}
		
		if(!((newPasswd.length() >= 8) && (newPasswd.length() <= 15))) {
			return false;
		}
		
		if(newPasswd.contains(" ")) {
			return false;
		}
		
		if(true) {
			int count = 0;
			for(int i = 0; i <= 9; i++) {
				String str1 = Integer.toString(i);
				
				if(newPasswd.contains(str1)) {
					count = 1;
				}
			}
			if(count == 0) {
				return false;
			}
		}
		
        if(!(newPasswd.contains("@") || newPasswd.contains("#") || newPasswd.contains("!") || newPasswd.contains("~") || newPasswd.contains("$")
        		|| newPasswd.contains("%") || newPasswd.contains("^") || newPasswd.contains("&") || newPasswd.contains("*") || newPasswd.contains("(")
        		|| newPasswd.contains(")") || newPasswd.contains("-") || newPasswd.contains("+") || newPasswd.contains("/") || newPasswd.contains(":")
        		|| newPasswd.contains(".") || newPasswd.contains(", ") || newPasswd.contains("<") || newPasswd.contains(">") || newPasswd.contains("?")
        		|| newPasswd.contains("|"))) {
              return false;
        }
        
        if(true) {
            int count = 0;
            for (int i = 65; i <= 90; i++) {
                char c = (char)i;
                String str1 = Character.toString(c);
                if (newPasswd.contains(str1)) {
                    count = 1;
                }
            }
            if(count == 0) {
                return false;
            }
        }
        
        if(true) {
            int count = 0;
            for (int i = 97; i <= 122; i++) {
                char c = (char)i;
                String str1 = Character.toString(c);
                if (newPasswd.contains(str1)) {
                    count = 1;
                }
            }
            if(count == 0) {
            	return false;
            }
        }
        return true;
	}
}
