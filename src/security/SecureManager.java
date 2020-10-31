package security;

import entity.Customer;
import entity.User;
import java.util.List;
import java.util.Scanner;
import shop.App;
import tools.CustomerManager;
import tools.FileStorageManager;
import tools.UserManager;

public class SecureManager {
    private Scanner scanner = new Scanner(System.in);
    private UserManager userManager = new UserManager();
    private CustomerManager customerManager = new CustomerManager();
    private FileStorageManager storMan = new FileStorageManager();
    
    public static enum role{Seller,Administrator}
    
    public User checkInLogin(List<User> listUsers, List<Customer> listCustomers) {
        do {
            System.out.println("0 - Завершить работу программы");
            System.out.println("1 - Войти в систему");
            System.out.println("2 - Список пользователей");
            System.out.println("3 - Регистрация нового пользователя");
            String task = scanner.nextLine();
            
            switch (task){
                case "0":
                    System.out.println("Bye bye!");
                    System.exit(0);
                    break;
                case "1":
                    System.out.println("1 - Войти в систему");
                    User checkInUser = userManager.getCheckInUser(listUsers);
                    if (checkInUser == null) break;
                    return checkInUser;
                case "2":
                    System.out.println("2 - Список пользователей");
                    userManager.printListUsers(listUsers);
                    break;
                case "3":
                    System.out.println("3 - Регистрация нового пользователя");
                    User user = userManager.createUser();
                    userManager.addUserToArray(user, listUsers);
                    customerManager.addCustomerToArray(user.getCustomer(), listCustomers);
                    storMan.save(listCustomers, App.storageFiles.CUSTOMERS.toString());
                    storMan.save(listUsers, App.storageFiles.USERS.toString());
                    break;
                default:
                System.out.println("Такого пункта меню не существует");
            }
            
        } while (true);
    
    }
}
