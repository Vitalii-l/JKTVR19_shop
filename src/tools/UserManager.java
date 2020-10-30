package tools;

import entity.Customer;
import entity.User;
import java.util.List;
import java.util.Scanner;
import security.SecureManager;

/**
 *
 * @author Vitalii Luchinskii
 * @author JKTVR19
 */
public class UserManager {
    Scanner scanner = new Scanner(System.in);
    
    public User createUser(){
        CustomerManager customerManager = new CustomerManager();
        Customer customer = customerManager.createCustomer();
        User user = new User();
        System.out.println("=== Создание пользователя ===");
        System.out.println("Введите логин: ");
        user.setLogin(scanner.nextLine());
        System.out.println("Введите пароль: ");
        user.setPassword(scanner.nextLine());
        int numRole;
        do {
            System.out.println("Список ролей:");
            for (int i = 0; i < SecureManager.role.values().length; i++) {
                System.out.printf("%d. %s%n"
                    , i+1
                    , SecureManager.role.values()[i].toString());
            }
            System.out.println("Введите номер роли: ");
            String strNumRole = scanner.nextLine();
            try {
                numRole = Integer.parseInt(strNumRole);
                break;
            } catch (Exception e) {
                System.out.println("Введите число");
            }
        } while (true);
        
        user.setRole(SecureManager.role.values()[numRole-1].toString());
        user.setCustomer(customer);        
        return user;
    }
    
    public void addUserToArray(User user, List<User> listUsers){
        listUsers.add(user);
    }
    
    public void printListUsers(List<User> listUsers) {
        int y = 0;
        for (User r : listUsers) {
            if(r != null){
                System.out.println(y+1+". "+r.toString());
                y++;
            }
        }
    }
    
    public User getCheckInUser(List<User> users) {
        System.out.println("Вход в систему...");
        System.out.println("Введите login: ");
        String login = scanner.nextLine();
        System.out.println("Введите password: ");
        String password = scanner.nextLine();
        for (int i = 0; i < users.size(); i++){
            if (users.get(i) != null && users.get(i).getLogin().equals(login)){
                for (int j = 0; j < 2; j++) {
                    if (users.get(i).getPassword().equals(password)) {
                        System.out.println("Login successful.");
                        return users.get(i);
                    } else {
                        System.out.println("Wrong password. You still have "+(2-j)+" attempt.");
                        password = scanner.nextLine();
                    }
                }
                System.out.println("Get out of here!");
                return null;
            }
        }
        System.out.println("Login not found");
        return null;
    }
    
}
