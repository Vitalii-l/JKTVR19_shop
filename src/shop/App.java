package shop;

import ui.UserInterface;
import entity.Customer;
import entity.Good;
import entity.History;
import entity.Store;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import security.SecureManager;
import tools.FileStorageManager;

public class App {
    public static enum storageFiles{GOODS, CUSTOMERS, USERS, HISTORIES, STORE};
    
    private List<Good> listGoods = new ArrayList<>();
    private List<Customer> listCustomers = new ArrayList<>();
    private List<History> listStories = new ArrayList<>();
    private List<User> listUsers = new ArrayList<>();
    private List<Store> listStore = new ArrayList<>();
    
    private FileStorageManager storMan = new FileStorageManager();
    public static User loggedInUser;
    
    public App(){
        List<Customer> loadCustomers = storMan.load(App.storageFiles.CUSTOMERS.toString());
       if (loadCustomers !=null){
           listCustomers = loadCustomers;
       }
       
       List<Good> loadGoods = storMan.load(App.storageFiles.GOODS.toString());
       if (loadGoods !=null){
           listGoods = loadGoods;
       }

       List<History> loadStories = storMan.load(App.storageFiles.HISTORIES.toString());
       if (loadStories != null){
           listStories = loadStories;
       }
       
       List<User> loaderUsers = storMan.load(App.storageFiles.USERS.toString());
       if (loaderUsers != null){
           listUsers = loaderUsers;
       }
       
       List<Store> loadStore = storMan.load(App.storageFiles.STORE.toString());
        if (loadStore != null) {
            listStore = loadStore;
        }
    }

    public void run() {
        System.out.println("Магазин продуктов");
        System.out.println("=== Меню ===");
        SecureManager secureManager = new SecureManager();
        App.loggedInUser = secureManager.checkInLogin(listUsers,listCustomers);
        UserInterface userInterface = new UserInterface();
        
        if (SecureManager.role.Administrator.toString().toLowerCase().equals(App.loggedInUser.getRole().toLowerCase())) {
            // Manager interface
            System.out.println("Текущая роль: Админстратор");
            userInterface.printAdminUI(listUsers, listCustomers, listGoods, listStories, listStore);
        } else if (SecureManager.role.Seller.toString().toLowerCase().equals(App.loggedInUser.getRole().toLowerCase())) {
            // Reader interface
            System.out.println("Текущая роль: Продавец");
            userInterface.printSellerUI(listUsers, listCustomers, listGoods, listStories, listStore);
        }
    }
    
}
