/*
 A DATA ACCESS OBJECT class to perform  encapsulating the details of the persistence layers and CRUD interface for single entity
 */
package com.hibernateInheritance;
import java.util.List;

import javax.persistence.Query;

//importing required packages
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class empDao {
	//creating global variable
		Configuration cfg;
		SessionFactory  sf;
		Session ss;
		Transaction tx ;
		
		
//First Method-> To make connection
		   public void connect() {
		    //activating Hibernate Framework
		  	  cfg = new Configuration().configure().addAnnotatedClass(Emp.class).addAnnotatedClass(FresherEmp.class).addAnnotatedClass(ExperiencedEmp.class);
		    //buildSessionFactory() method gathers the meta-data which is in the cfg Object.
			  sf = cfg.buildSessionFactory();
		   //opening the Connection/Session with Database software through Hibernate Framework.
			ss = sf.openSession();
					
			  tx =ss.beginTransaction();
		   }
//second method to add employee in the database 
 		   public Session registerEmp(Emp e1){
				ss.save(e1);
				return ss;
			}
			
//Third Method -> to add fresher employees in the database
			public Session registerEmp(FresherEmp fresh) {
				ss.save (fresh);
				return ss;
			}
//Fourth  method to add experienced employee in the database
	 		   public Session registerEmp(ExperiencedEmp expert){
					ss.save(expert);
					return ss;
				}
//Fifth method to delete employee via id
	 		  public int deltEmp(int id) {
	 				Query q = ss.createQuery("delete from emp e where e.empId=: Id").setParameter("Id", id);
	 				int count = q.executeUpdate();
	 				return count;
	 			}
//sixth method to fetch all the data from the database
	 		 public List fetchAll() {
	 			Query q =  ss.createQuery(" from emp");
	 			List<Emp> empl = q.getResultList();
	 			return empl;
	 		}
//Last Method-> to Disconnect the method to end
		   public void disconnect() {
				tx.commit();
				ss.close();
			}

}
