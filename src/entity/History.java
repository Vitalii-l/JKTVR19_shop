package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class History implements Serializable {
    private Customer customer;
    private Store store;
    private Date date;
    private String transactionType;
    private Integer quantity;

    public History() {
    }

    public History(Customer customer, Store store, Date date, String transactionType, Integer quantity) {
        this.customer = customer;
        this.store = store;
        this.date = date;
        this.transactionType = transactionType;
        this.quantity = quantity;
    }
    
    public History(Customer customer, Store store, Date date, String transactionType, String quantity) {
        this.customer = customer;
        this.store = store;
        this.date = date;
        this.transactionType = transactionType;
        setQuantity(quantity);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public void setQuantity(String quantity) {
        try {
            int quantityInt = Integer.parseInt(quantity);
            this.quantity = quantityInt;
            
        } catch (Exception e) {
            System.out.println("Введите число");
        }
    }

    @Override
    public String toString() {
        return "History{" + "customer=" + customer + ", store=" + store + ", date=" + date + ", transactionType=" + transactionType + ", quantity=" + quantity + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.customer);
        hash = 97 * hash + Objects.hashCode(this.store);
        hash = 97 * hash + Objects.hashCode(this.date);
        hash = 97 * hash + Objects.hashCode(this.transactionType);
        hash = 97 * hash + this.quantity;
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
        final History other = (History) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.transactionType, other.transactionType)) {
            return false;
        }
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (!Objects.equals(this.store, other.store)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    
}
