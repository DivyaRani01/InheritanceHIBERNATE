/*
 * A project called EMPLOYEE MANAGEMENT SYSTEM which having CRUD operations for  new employees , fresher employees and experienced employees to the database using inheritance and 
 * hibernate query language and printing the data from database using DAO(data access object)
 * @Divya
 *
 */
//model
package com.hibernateInheritance;
//importing required packages
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Emp {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;
	
	//generating getters and setters
	private String empName;
	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}
	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}
	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + "]";
	}

	
	

}
