/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Good;
import entity.Store;
import java.util.List;
import java.util.Scanner;
import shop.App;

/**
 *
 * @author 57547
 */
public class StoreManager {
    private FileStorageManager storageManager = new FileStorageManager();
    private GoodManager goodManager = new GoodManager();
    private Scanner scanner = new Scanner(System.in);
    
    public void printListStoredGoods(List<Store> listStore){
        System.out.println("=== Товары на складе:");
        int i = 0;
        for (Store s : listStore) {
            if (s != null){
                System.out.println(i+1+". "+s.toString());
                i++;
            }
        }
    }
    
    public void addStoreToArray (Store store, List<Store> listStore){
        listStore.add(store);
        FileStorageManager fileStorageManager = new FileStorageManager();
        fileStorageManager.save(listStore,App.storageFiles.STORE.toString());
    }
    
    public Store createStore(List<Store> listStore){
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
        Good good = listGoods.get(goodNumber-1);
        
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
        
        return store;
    }
}
