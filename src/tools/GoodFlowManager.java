/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Customer;
import entity.Good;
import entity.History;
import entity.Store;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import shop.App;

/**
 *
 * @author 57547
 */
public class GoodFlowManager {
    public static enum transactionType{SELL,ARRIVAL};
    private CustomerManager customerManager = new CustomerManager();
    private GoodManager goodManager = new GoodManager();
    private StoreManager storeManager = new StoreManager();
    private Scanner scanner = new Scanner(System.in);
    
    public History goodsArrival(List<Good> listGoods, List<Customer> listCustomer, List<Store> listStore){
        Store store = new Store();
        
        // Выбор товара
        int goodNumber = 0;
        do {
            goodManager.printListGoods(listGoods);
            System.out.println("--- Выберите товар ---");
            String goodNumberStr = scanner.nextLine();
            try {
                goodNumber = Integer.parseInt(goodNumberStr);
                if(goodNumber < 1 && goodNumber <= listGoods.size()){
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Введите номер товара из списка");
            }
        } while (true);
        
        String transaction = GoodFlowManager.transactionType.ARRIVAL.toString();
        Customer customer = null;
        customer = App.loggedInUser.getCustomer();
        Calendar calendar = new GregorianCalendar();
        Good good = listGoods.get(goodNumber-1);
        String quantityStr = scanner.nextLine();
        
        // Количество
        Integer numQuantity;
        do {
            System.out.println("Введите количество товара:");
            String strGoodQuantity = scanner.nextLine();
            try {
                numQuantity = Integer.parseInt(strGoodQuantity);
                break;
            } catch (Exception e) {
                System.out.println("Введите числовое значение");
            }
        } while (true);
        store.setInStockQuantity(numQuantity);
        
        // Цена
        Double numPrice;
        do {
            System.out.println("Введите цену товара:");
            String strGoodPrice = scanner.nextLine();
            try {
                numPrice = Double.parseDouble(strGoodPrice);
                break;
            } catch (Exception e) {
                System.out.println("Введите числовое значение");
            }
        } while (true);
        store.setPrice(numPrice);
        
        store.setGood(good);
        
        
        History history = new History(customer, store, calendar.getTime(), transaction, numQuantity);
        
        
        return null;
    }
    
    public void addHistoryToArray(History history, List<History> listStories) {
        listStories.add(history);
    }

}
