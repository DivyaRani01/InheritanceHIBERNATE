/*
 * A project called EMPLOYEE MANAGEMENT SYSTEM which having CRUD operations for  new employees , fresher employees and experienced employees to the database using inheritance and 
 * hibernate query language and printing the data from database using DAO(data access object)
 * @Divya
 *
 */

package com.hibernateInheritance;
//importing required packages
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Experienced")
public class ExperiencedEmp extends Emp {
	
	private int experience;
	private int salary;
	private int hike;
	/**
	 * @return the experience
	 */
	public int getExperience() {
		return experience;
	}
	/**
	 * @param experience the experience to set
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}
	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
	/**
	 * @return the hike
	 */
	public int getHike() {
		return hike;
	}
	/**
	 * @param hike the hike to set
	 */
	public void setHike(int hike) {
		this.hike = hike;
	}
	@Override
	public String toString() {
		return "ExperiencedEmp [experience=" + experience + ", salary=" + salary + ", hike=" + hike + "]";
	}
	
	
	

}
