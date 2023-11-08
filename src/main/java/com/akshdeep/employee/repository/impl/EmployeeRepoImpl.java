package com.akshdeep.employee.repository.impl;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.akshdeep.employee.entity.Employee;
//import com.akshdeep.employee.repository.EmployeeRepo;
import com.akshdeep.employee.repository.EmployeeJpaRepo;

@Service
public abstract class EmployeeRepoImpl implements EmployeeJpaRepo {

	@Autowired
	private SessionFactory sessionfactory;

	@Autowired
	public EmployeeRepoImpl(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.sessionfactory = factory.unwrap(SessionFactory.class);
	}

	public void setHibernateTemplate(SessionFactory hibernateFactory) {
		this.sessionfactory = hibernateFactory;
	}

	public List<Employee> getEmployeeByEmail(String emailID) {
		Session session = sessionfactory.openSession();
		String hql = "FROM Employee A WHERE A.email LIKE :search_value";
		System.out.println(hql);
		Query<Employee> query = session.createQuery(hql);
		query.setParameter("search_value", "%" + emailID + "%");
		List<Employee> actorList = query.list();
		session.close();
		return actorList;
	}
}
