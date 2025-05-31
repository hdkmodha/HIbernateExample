package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.Array;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory();

        Employee employee = new Employee();
        employee.setId(103);
        employee.setName("John Smith");
        employee.setDepartment("Technology");

        Laptop laptop = new Laptop();
        laptop.setId(101);
        laptop.setBrand("Apple");
        laptop.setModel("MacBook Pro");
        laptop.setRam(16);
        laptop.setEmployee(employee);

        employee.setLaptops(Arrays.asList(laptop));

        Session session = sessionFactory.openSession();
        Employee employee2 = session.get(Employee.class, 103);
        System.out.println(employee2);
        session.close();
    }
}