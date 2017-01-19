package com.hib.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hib.bean.Employee;

public class ManageEmployee {


	private static SessionFactory factory; 
	public static void main(String[] args) {
	      try{
	         factory = new Configuration().configure().buildSessionFactory();
	         System.out.println("HI");
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	      
	      ManageEmployee ME = new ManageEmployee();

	      /* Add few employee records in database */
	      /*Integer empID1 = ME.addEmployee("Zara", "Ali", 1000);
	      Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
	      Integer empID3 = ME.addEmployee("John", "Paul", 10000);*/
	      
	      ME.listEmployees();
	      
	   }
	   
	   
	      
	      public Integer addEmployee(String fname, String lname, int salary){
	    	  System.out.println("Inside add employee method");
	          Session session = factory.openSession();
	          Transaction tx = null;
	          Integer employeeID = null;
	          try{
	             tx = session.beginTransaction();
	             Employee employee = new Employee(fname, lname, salary);
	             employeeID = (Integer) session.save(employee);
	             System.out.println("inseted");
	             tx.commit();
	          }catch (HibernateException e) {
	             if (tx!=null) tx.rollback();
	             e.printStackTrace(); 
	          }finally {
	             session.close(); 
	          }
	          return employeeID;
	       }
	      
	      public void listEmployees(){
	    	  
	    	  Session session= factory.openSession();
	    	  Transaction tx= null;
	    	  tx=session.beginTransaction();
	    	  List emplyees= session.createQuery("FROM Employee").list();
	    	  
	    	  for(Iterator itr=emplyees.iterator();itr.hasNext();){
	    		  Employee emp=(Employee) itr.next();
	    		  System.out.println(emp.getId());
	    		  System.out.println(emp.getFirstName());
	    		  System.out.println(emp.getLastName());
	    		  System.out.println(emp.getSalary());
	    	  }
	    	  tx.commit();
	    	  session.close();
	      }
}
