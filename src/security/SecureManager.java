package security;

import entity.Customer;
import entity.User;
import java.util.List;
import java.util.Scanner;

public class SecureManager {
    private Scanner scanner = new Scanner(System.in);
    public static enum role{Seller,Administrator}
    
    public User checkInLogin(List<User> listUsers, List<Customer> listCusromers) {
        do {            
            System.out.println("=== Выберите действие ===");
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
                    
                    break;
                case "2":
                    
                    break;
                case "3":
                    break;
            }
            
        } while (true);
    
    }
}
