package com.hibernateinfo.client;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;

import com.hibernateinfo.entities.Employee;
import com.hibernateinfo.util.HibernateUtil;

/**
 * @author Pasha Sadi
 * Remember the golden rule: readable code is often faster code. 
 * Produce readable code first and only change it if it proves to be too slow.
 */
public class SaveDataClientTest {

	public static void main(String[] args) 
	{
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) 
		{			
			session.beginTransaction();
			
			Employee employee1 = new Employee();
			
			employee1.setEmployeeName("Pasha Sadi");
			employee1.setDesignation("Coder");
			employee1.setDoj(new Date());
			employee1.setEmail("pasha.sn@gmail.com");
			employee1.setBonus(new BigDecimal(2000));
			employee1.setSalary(48000.00);
			
			Employee employee2 = new Employee();
			employee2.setEmployeeName("Saba Divanpour");
			employee2.setDesignation("DataAnalyst");
			employee2.setDoj(new Date());
			employee2.setEmail("saba@divan.pour");
			employee2.setBonus(new BigDecimal(1000));
			employee2.setSalary(65000.00);
			
			session.save(employee1);
			session.save(employee2);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
}
/*
<property name="hibernate.hbm2ddl.auto">create</property>
Hibernate: 
    
    drop table employee_table cascade constraints
Hibernate: 
    
    drop sequence hibernate_sequence
Hibernate: create sequence hibernate_sequence start with 1 increment by  1
Hibernate: 
    
    create table employee_table (
       employee_id number(10,0) not null,
        bonus number(19,2),
        designation varchar2(50 char),
        date_of_joining timestamp,
        email varchar2(50 char),
        employee_name varchar2(60 char) not null,
        salary double precision,
        primary key (employee_id)
    )
Hibernate: 
    
    alter table employee_table 
       add constraint UK_2casspobvavvi9s23312f9mhm unique (email)
Hibernate: 
    select
        hibernate_sequence.nextval 
    from
        dual
Hibernate: 
    select
        hibernate_sequence.nextval 
    from
        dual
Hibernate: 
    insert 
    into
        employee_table
        (bonus, designation, date_of_joining, email, employee_name, salary, employee_id) 
    values
        (?, ?, ?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        employee_table
        (bonus, designation, date_of_joining, email, employee_name, salary, employee_id) 
    values
        (?, ?, ?, ?, ?, ?, ?)
*/