package com.hib.bean;

public class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private int salary;
	
	public Employee(){}
	
	public Employee(String firstName, String lastName, int salary2){
		this.firstName=firstName;
		this.lastName=lastName;
		this.salary=salary2;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastname) {
		this.lastName = lastname;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getSalary() {
		return salary;
	}
	
	
}
