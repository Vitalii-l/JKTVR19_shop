package shop;

import entity.Customer;
import entity.Good;
import entity.Story;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static enum storageFiles{GOODS, CUSTOMERS, USERS, STORIES};
    
    private List<Good> listGoods = new ArrayList<>();
    private List<Customer> listCustomers = new ArrayList<>();
    private List<Story> listStories = new ArrayList<>();
    
    public App(){
    }

    public void run() {
        System.out.println("Магазин продуктов");
        
    }
    
}
