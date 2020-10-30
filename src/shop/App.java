package shop;

import entity.Customer;
import entity.Good;
import entity.Story;
import entity.User;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static enum storageFiles{GOODS, CUSTOMERS, USERS, STORIES};
    
    private List<Good> listGoods = new ArrayList<>();
    private List<Customer> listCustomers = new ArrayList<>();
    private List<Story> listStories = new ArrayList<>();
    private List<User> listUsers = new ArrayList<>();
    
    public static User loggedInUser;
    
    public App(){
        
    }

    public void run() {
        System.out.println("Магазин продуктов");
        System.out.println("=== Меню ===");
        SecurityManager secureManager = new SecurityManager();
        this.loggedInUser = secureManager.checkInLogin(listUsers,listReaders);
        UserInterface userInterface = new UserInterface();
        
    }
    
}
