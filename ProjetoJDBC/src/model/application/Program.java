package model.application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;


public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        Seller seller = sellerDao.findById(3);
        System.out.println("--- TEST 1: seller findById---");
        System.out.println(seller);
        System.out.println();

        System.out.println("--- TEST 2: seller findByDepartment---");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        list.forEach(System.out::println);
        System.out.println();

        System.out.println("--- TEST 3: seller findAll---");
        list = sellerDao.findAll();
        list.forEach(System.out::println);

        System.out.println("--- TEST 4: seller insert---");
        Seller newSller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSller);
        System.out.println("Inserted! New id = " + newSller.getId());
    }
}
