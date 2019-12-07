package com.hibernateinfo.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.hibernateinfo.util.HibernateUtil;

public class ClientTest5getAllEmployeeIdNameAndSalaryHQL {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		getAllEmployeeIdNameAndSalary(sessionFactory);

	}

	private static void getAllEmployeeIdNameAndSalary(SessionFactory sessionFactory) {
		
		try(Session session = sessionFactory.openSession()) 
		{			
			String hql = "SELECT employeeId, employeeName, salary FROM Employee";
			Query<Object[]> query = session.createQuery(hql, Object[].class);
			List<Object[]> list = query.list();			
			System.out.println("employeeId\temployeeName\tSalary");
			
			for (Object[] objects : list) {
				Integer employeeId = (Integer) objects[0];
				String employeeName = (String) objects[1];
				Double salary = (Double) objects[2];
				System.out.println(employeeId + "\t\t" + employeeName + "\t" + salary);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
/*
<property name="hibernate.hbm2ddl.auto">update</property>
Hibernate: 
    select
        employee0_.employee_id as col_0_0_,
        employee0_.employee_name as col_1_0_,
        employee0_.salary as col_2_0_ 
    from
        employee_table employee0_
employeeId	employeeName	Salary
1		Pasha Sadi	48000.0
2		Saba Divanpour	65000.0
*/