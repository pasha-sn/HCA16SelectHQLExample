package com.hibernateinfo.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.hibernateinfo.entities.Employee;
import com.hibernateinfo.util.HibernateUtil;

public class ClientTest2getEmployeeByIdHQL {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		getEmployeeById(sessionFactory);
	}

	private static void getEmployeeById(SessionFactory sessionFactory) {

		int empId = 1;
		//try and catch block with resources
		try(Session session = sessionFactory.openSession()) 
		{
			//From keyWord is NOT case sensitive
			//HQL works with class name instead of table name
			//Employee is a class name and case sensitive
			
			//Legacy-style query parameters (`?`) are no longer supported in oracle; 
			//use JPA-style "ORDINAL" parameters (e.g., `?1`) instead : 			
			//employeeId is a property name not a column name
			String hql = "From Employee WHERE employeeId =?111"; 
			
			//String HQL = "From com.infotech.entities.Employee"; 
			//ALT+Shift+L in Eclipse "generate" the assignment to variable of return Type 
			Query<Employee> query = session.createQuery(hql, Employee.class);
			query.setParameter(111, empId);
			Employee employee = query.getSingleResult();			
			System.out.println(employee);
			
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
    where
        employee0_.employee_id=?
Employee [employeeId=1, employeeName=Pasha Sadi, doj=2018-01-01 00:00:00.00, salary=48000.0, bonus=2000, designation=Coder, email=pasha.sn@gmail.com]

*/
