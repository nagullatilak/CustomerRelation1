package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO {
   //need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		//get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create query and get Results
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by firstName",Customer.class);
		//execute query
		List<Customer> customers=theQuery.getResultList();
		//return results
		return customers;
	}
	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		// getting the current session
		Session currentSession = sessionFactory.getCurrentSession();
		//save OR UPDATE the customer object
		currentSession.saveOrUpdate(theCustomer);
		
	}
	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Customer theCustomer=currentSession.get(Customer.class,theId);
		return theCustomer;
	}
	@Transactional
	@Override
	public Customer deleteCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer theCustomer=currentSession.get(Customer.class,theId);
		currentSession.delete(theCustomer);
		return theCustomer;
		
	}

}
