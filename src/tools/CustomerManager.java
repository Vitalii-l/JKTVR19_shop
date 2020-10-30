package tools;

import entity.Customer;
import java.util.List;
import java.util.Scanner;

public class CustomerManager {
    public Customer createCustomer(){
        Customer customer = new Customer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Регистрация нового пользователя системы");
        System.out.println("Введите имя: ");
        customer.setFirstName(scanner.nextLine());
        System.out.println("Введите фамилию: ");
        customer.setLastName(scanner.nextLine());
        System.out.println("Введите телефон: ");
        customer.setPhone(scanner.nextLine());
        return customer;
    }
    
    public void addCustomerToArray(Customer customer, List<Customer> listCustomers){
        listCustomers.add(customer);
    }
    
    public void printListCustomers(List<Customer> customers){
        int i = 0;
        for (Customer c : customers) {
            if(c != null){
                System.out.println(i+1+". "+c.toString());
            }            
        }
    }
    
}
