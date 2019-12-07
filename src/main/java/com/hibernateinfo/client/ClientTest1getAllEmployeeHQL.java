package com.hibernateinfo.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.hibernateinfo.entities.Employee;
import com.hibernateinfo.util.HibernateUtil;

/**
 * @author Pasha Sadi
 * Remember the golden rule: readable code is often faster code. 
 * Produce readable code first and only change it if it proves to be too slow.
 */
public class ClientTest1getAllEmployeeHQL {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		getAllEmployeesByHQL(sessionFactory);
	}
	
	private static void getAllEmployeesByHQL(SessionFactory sessionFactory) 
	{		
		//try and catch block with resources
		try(Session session = sessionFactory.openSession()) 
		{
			//From keyWord is NOT case sensitive
			//HQL works with class name instead of table name
			//Employee is a class name and case sensitive
			//HQL:From Employee = SQL:SELECT * FROM EMPLOYEE_TABLE;
			//String HQL = "From com.hibernateinfo.entities.Employee"; 
			String hql = "From Employee"; 
			
			
			//ALT+Shift+L in Eclipse "generate" the assignment to variable of return Type 
			Query<Employee> query = session.createQuery(hql, Employee.class);
			List <Employee> list = query.list();
			
			//iterate list using forEach method			
			list.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
/*
 <property name="hibernate.hbm2ddl.auto">update</property>
 Hibernate: 
    select
        employee0_.employee_id as employee_id1_0_,
        employee0_.bonus as bonus2_0_,
        employee0_.designation as designation3_0_,
        employee0_.date_of_joining as date_of_joining4_0_,
        employee0_.email as email5_0_,
        employee0_.employee_name as employee_name6_0_,
        employee0_.salary as salary7_0_ 
    from
        employee_table employee0_
Employee [employeeId=1, employeeName=Pasha Sadi, doj=2018-01-01 00:00:00.00, salary=48000.0, bonus=2000, designation=Coder, email=pasha.sn@gmail.com]
Employee [employeeId=2, employeeName=Saba Divanpour, doj=2018-01-01 00:00:00.00, salary=65000.0, bonus=1000, designation=DataAnalyst, email=saba@divan.pour]
*/