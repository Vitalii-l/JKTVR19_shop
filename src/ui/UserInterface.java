/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entity.Customer;
import entity.Good;
import entity.History;
import entity.Store;
import entity.User;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import shop.App;
import tools.CustomerManager;
import tools.GoodManager;
import tools.FileStorageManager;
import tools.GoodFlowManager;
import tools.StoreManager;
import tools.UserManager;

/**
 *
 * @author 57547
 */
public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private GoodManager goodManager = new GoodManager();
    private CustomerManager customerManager = new CustomerManager();
    private UserManager userManager = new UserManager();
    private FileStorageManager storMan = new FileStorageManager();
    private StoreManager storeManager = new StoreManager();
    private GoodFlowManager goodFlowManager = new GoodFlowManager();

    public void printSellerUI(List<User> listUsers, List<Customer> listCustomers, List<Good> listGoods, List<History> listStories, List<Store> listStore) {
        boolean repeat = true;
        do {
            System.out.println("=== Меню продавца ===");
            System.out.println("1. Список товаров");
            System.out.println("2. Список клиентов");
            System.out.println("3. Продажа");
            System.out.println("4. Добавить нового клиента");
            System.out.println("5. Возврат товара");
            System.out.println("0. Выход");
            String task = scanner.nextLine();
            switch (task){
                case "0":
                    System.out.println("--- The End ---");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("--- 1. Список товаров ---");
                    goodManager.printListGoods(listGoods);
                    break;                
                case "2":
                    System.out.println("--- 2. Список клиентов ---");
                    customerManager.printListCustomers(listCustomers);
                    break;
                case "3":
                    System.out.println("--- 3. Продажа ---");
                    break;
                case "4":
                    System.out.println("--- 4. Добавление нового клиента ---");
                    Customer customer = customerManager.createCustomer();
                    customerManager.addCustomerToArray(customer, listCustomers);
                    break;
            }
        } while (repeat);
    }

    public void printAdminUI(List<User> listUsers, List<Customer> listCustomers, List<Good> listGoods, List<History> listStories, List<Store> listStore) {
        boolean repeat = true;
        do {
            System.out.println("=== Меню администратора ===");
            System.out.println("1. Список пользователей системы");
            System.out.println("2. Список товаров");
            System.out.println("3. Список клиентов");
            System.out.println("4. Добавить нового клиента");
            System.out.println("5. Продажа");
            System.out.println("6. Приход товара на склад");
            System.out.println("7. Добавить новый товар");
            System.out.println("8. Отчет по продажам");
            System.out.println("9. Отчет - остатки товаров");
            System.out.println("0. Выход");
            String task = scanner.nextLine();
            switch (task){
                case "0":
                    System.out.println("--- The End ---");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("--- 1. Список пользователей системы ---");
                    userManager.printListUsers(listUsers);
                    break;
                case "2":
                    System.out.println("--- 2. Список товаров ---");
                    goodManager.printListGoods(listGoods);
                    break;
                case "3":
                    System.out.println("--- 3. Список клиентов ---");
                    customerManager.printListCustomers(listCustomers);
                    break;
                case "4":
                    System.out.println("--- 4. Добавление нового клиента ---");
                    Customer customer = customerManager.createCustomer();
                    customerManager.addCustomerToArray(customer, listCustomers);
                    break;
                case "5":
                    System.out.println("--- 5. Продажа ---");
                    
                    break;
                case "6":
                    System.out.println("--- 6. Приход товара на склад ---");
                    
                    break;
                case "7":
                    System.out.println("--- 7. Добавить новый товар ---");
                    Good good = goodManager.createGood();
                    goodManager.addGoodToArray(good, listGoods);
                    storMan.save(listGoods, App.storageFiles.GOODS.toString());
                    break;
                case "8":
                    System.out.println("--- 8. Отчет по продажам ---");
                    
                    break;
                case "9":
                    System.out.println("--- 9. Отчет - остатки товаров ---");
                    storeManager.printListStoredGoods(listStore);
                    break;
            }
        } while (repeat);
    }
}
