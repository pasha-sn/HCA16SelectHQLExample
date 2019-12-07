package com.hibernateinfo.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.hibernateinfo.util.HibernateUtil;

public class ClientTest4getAllEmployeeNamesHQL {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		getAllEmployeeNames(sessionFactory);
	}

	private static void getAllEmployeeNames(SessionFactory sessionFactory) {
		
		try(Session session = sessionFactory.openSession()) 
		{			
			String hql = "SELECT employeeName FROM Employee"; 
			Query<String> query = session.createQuery(hql, String.class);
			query.list().forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
/*
<property name="hibernate.hbm2ddl.auto">update</property>
Hibernate: 
    select
        employee0_.employee_name as col_0_0_ 
    from
        employee_table employee0_
Pasha Sadi
Saba Divanpour
*/