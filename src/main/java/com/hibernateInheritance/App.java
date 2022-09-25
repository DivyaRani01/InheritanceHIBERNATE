/*
 * A project called EMPLOYEE MANAGEMENT SYSTEM which having CRUD operations for  new employees , fresher employees and experienced employees to the database using inheritance and 
 * hibernate query language and printing the data from database using DAO(data access object)
 * @Divya
 *
 */
package com.hibernateInheritance;

import java.util.List;
import java.util.Scanner;

public class App 
{   
	//main method
    public static void main( String[] args )
    {
    	//creating Scanner object to take input from user
        Scanner obj = new Scanner(System.in);
        int salary,experience,id,contract,hike;
        int op=0;
        String name;
        
        //creating object of Emp class
    	Emp e1 = new Emp();
    	//creating object of fresherEmp class
    	FresherEmp freshEmp = new FresherEmp();
    	//creating object of experiencedEmp class
    	ExperiencedEmp ExpEmp = new ExperiencedEmp();	
    	//creating object of empdao class
    	empDao dao = new empDao();
    	
    	while(op<7) {
    		System.out.println("\t\t\t >>---------EMPLOYEE MANAGEMENT SYSTEM------------------<<");
			System.out.println("\nPress 1 -> ***To Register New Employee \nPress 2 -> ***To Register as Fresher Employee \nPress 3 -> ***To Register as Experienced Employee  \nPress 4 -> ***To Print All Employees \nPress 6 -> ***To  Remove Employee"
					+ " \nPress 7 -> ***To  Exit");
			System.out.print("\nEnter Your Choice:  ");
			op = obj.nextInt();
			
			
			switch(op) {
			
			// first Case -> to add employee to the database
			case 1->{
				System.out.print("Enter Your Name:");
				name = obj.next();
				e1.setEmpName(name);
				
				//calling connect method to begin the session
				dao.connect();
				dao.registerEmp(e1);
				System.out.println(e1);
				
				//calling disconnect method to end  the session
				dao.disconnect();
			}
			
			//second case to add fresher employee
			case 2->{
				System.out.print("Enter Your Name:");
				name = obj.next();
				freshEmp.setEmpName(name);
				System.out.print("Enter Salary:");
				salary = obj.nextInt();
				freshEmp.setSalary(salary);
				System.out.print("Enter Contract Period:");
				contract = obj.nextInt();
				freshEmp.setContractPeriod(contract);
				System.out.print("Enter Increment:");
				hike = obj.nextInt();
				freshEmp.setIncrement(hike);
				
				//calling connect method to begin the session
				dao.connect();
				dao.registerEmp(freshEmp);
				System.out.println(freshEmp);// ADDING FRESER IN DATABASE
				
				//calling disconnect method to end the session
				dao.disconnect();
			}
			
			// 3rd case to add experienced employee in the database
			case 3->{
				System.out.print("Enter Your Name:");
				name = obj.next();
				ExpEmp.setEmpName(name);
				System.out.print("Enter Salary:");
				salary = obj.nextInt();
				ExpEmp.setSalary(salary);
				System.out.print("Enter Experience:");
				experience = obj.nextInt();
				ExpEmp.setExperience(experience);
				System.out.print("Enter hike:");
				hike = obj.nextInt();
				ExpEmp.setHike(hike);
				
				//calling connect method to begin the session
				dao.connect();
				dao.registerEmp(ExpEmp);
				System.out.println(ExpEmp);
				
				//calling disconnect method to end the session
				dao.disconnect();
			}
			
			//4th case to fetch all the details of employess
			case 4 ->{
				
				// calling connect method to start session
				dao.connect();
				List<Emp> empl = dao.fetchAll();    
				
				//calling disconnect method to end the session
				dao.disconnect();
				for(Emp e : empl)
					System.out.println(e);
			}
			
			//5th case to delete employee from the databse
			case 5 ->{
				
				//calling connect method to begin the session
				dao.connect();
				System.out.print("Enter Id : ");
				 int Id = obj.nextInt();
				//deleting employee from the database
				int rst = dao.deltEmp(Id);
				
				//calling disconnect method to end the session
				dao.disconnect();
				if (rst==1)
					System.out.println("Employee removed Successfully....!");
				else
					System.out.println("Employee does not exist in the database..!");
			}
			}
    	}
    	
    	//closing the scanner object
    	obj.close();
        
    }
}
