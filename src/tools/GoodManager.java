/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Good;
import java.util.List;
import java.util.Scanner;
import shop.App;

/**
 *
 * @author 57547
 */
public class GoodManager {
    private FileStorageManager storageManager = new FileStorageManager();
    
    public boolean printListGoods(List<Good> listGoods) {
        if(listGoods == null || listGoods.size() < 1){
            System.out.println("Товаров нет!");
            return false;
        }
        System.out.println("Список товаров");
        int i = 0;
        for (Good l : listGoods) {
            if(l != null){
                System.out.println(i+1+". "+l.toString());
                i++;}          
        }
        return true;
    }
    public void addGoodToArray(Good good, List<Good> listGoods){
        listGoods.add(good);
        storageManager.save(listGoods, App.storageFiles.GOODS.toString());
    }
    public Good createGood(){
        Good good = new Good();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Добавление нового товара ---");
        System.out.println("Введите название товара:");
        good.setName(scanner.nextLine());
        Double numWeight;
        do {
            System.out.println("Введите вес товара:");
            String strGoodWeight = scanner.nextLine();
            try {
                numWeight = Double.parseDouble(strGoodWeight);
                break;
            } catch (Exception e) {
                System.out.println("Введите числовое значение");
            }
        } while (true);
        good.setWeight(numWeight);
        
        System.out.println("Введите производителя товара:");
        good.setManufacturer(scanner.nextLine());
        return good;
    }
    
}
