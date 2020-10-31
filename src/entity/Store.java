/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author 57547
 */
public class Store implements Serializable {
    private int goodCode;
    private Double price;
    private int inStockQuantity;
    private Good good;

    public Store() {
    }

    public Store(int goodCode, Double price, int inStockQuantity, Good good) {
        this.goodCode = goodCode;
        this.price = price;
        this.inStockQuantity = inStockQuantity;
        this.good = good;
    }
    
    public Store(int goodCode, String price, String inStockQuantity, Good good) {
        this.goodCode = goodCode;
        setPrice(price);
        setInStockQuantity(inStockQuantity);
        this.good = good;
    }

    public int getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(int goodCode) {
        int random_int = (int)(Math.random() * 2001);
        this.goodCode = random_int;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        
        this.price = price;
    }

    public void setPrice(String price){
        try {
            Double priceDouble = Double.parseDouble(price);
            this.price = priceDouble;
        } catch (Exception e){
            System.out.println("Введите число");
        }
    }
    
    public int getInStockQuantity() {
        return inStockQuantity;
    }

    public void setInStockQuantity(int inStockQuantity) {
        this.inStockQuantity = inStockQuantity;
    }
    
    public void setInStockQuantity(String inStockQuantity){
        try {
            int inStockQuantityInt = Integer.parseInt(inStockQuantity);
            this.inStockQuantity = inStockQuantityInt;
        } catch (Exception e) {
            System.out.println("Введите число");
        }
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    @Override
    public String toString() {
        return "Store{" + "goodCode=" + goodCode + ", price=" + price + ", inStockQuantity=" + inStockQuantity + ", good=" + good + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.goodCode;
        hash = 47 * hash + Objects.hashCode(this.price);
        hash = 47 * hash + this.inStockQuantity;
        hash = 47 * hash + Objects.hashCode(this.good);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Store other = (Store) obj;
        if (this.goodCode != other.goodCode) {
            return false;
        }
        if (this.inStockQuantity != other.inStockQuantity) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.good, other.good)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
