package com.jspiders.springmvc5.base.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;

import org.springframework.stereotype.Repository;

import com.jspiders.springmvc5.base.pojo.StudentPojo;

@Repository
public class StudentRepository {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static String jpql;
	private static Query query;

	
	private static void openConnection() {
		factory=Persistence.createEntityManagerFactory("springrest");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
	}

	private static void closeConnection() {
		if(factory!=null) {
			factory.close();
		}
		if (manager!=null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}
	public StudentPojo add(StudentPojo pojo) {
		
		openConnection();
		transaction.begin();
		
		manager.persist(pojo);
		
		transaction.commit();
		closeConnection();
		
		
		
		
		
		return pojo;
	}
	

}
