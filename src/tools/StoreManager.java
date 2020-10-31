/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Store;
import java.util.List;

/**
 *
 * @author 57547
 */
public class StoreManager {
    private FileStorageManager storageManager = new FileStorageManager();
    
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
    
    
    
}
