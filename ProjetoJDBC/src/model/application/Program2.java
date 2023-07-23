package model.application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao depDao = DaoFactory.createDepartmentDao();

        System.out.println("--- Test 1: department insert ---");
        Department newDepartment = new Department(null, "Toys");
        depDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("--- Test 2: department findById ---");
        Department department = depDao.findById(2);
        System.out.println(department);
        System.out.println();

        System.out.println("--- Test 3: department update ---");
        Department department2 = depDao.findById(1);
        department2.setName("Products");
        depDao.update(department2);
        System.out.println("Update completed!");

        System.out.println("--- Test 4: department deleteById ---");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        depDao.deleteById(id);
        System.out.println("Deleted completed!");

        System.out.println("--- Test 5: findAll ---");
        List<Department> list = depDao.findAll();
        list.forEach(System.out::println);

    }
}
