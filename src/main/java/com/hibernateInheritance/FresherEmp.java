//model
package com.hibernateInheritance;
//importing required packages
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Fresher")
public class FresherEmp extends Emp{
	
	private int contractPeriod;
	private int Salary ;
	private int increment ;
	/**
	 * @return the contractPeriod
	 */
	public int getContractPeriod() {
		return contractPeriod;
	}
	/**
	 * @param contractPeriod the contractPeriod to set
	 */
	public void setContractPeriod(int contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	/**
	 * @return the salary
	 */
	public int getSalary() {
		return Salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		Salary = salary;
	}
	/**
	 * @return the increment
	 */
	public int getIncrement() {
		return increment;
	}
	/**
	 * @param increment the increment to set
	 */
	public void setIncrement(int increment) {
		this.increment = increment;
	}
	@Override
	public String toString() {
		return "FresherEmp [contractPeriod=" + contractPeriod + ", Salary=" + Salary + ", increment=" + increment + "]";
	}
	
	
	

}
