package entity;

import java.util.Date;
import java.util.Objects;

public class Story {
    private Good good;
    private Customer customer;
    private Date sellDate;
    private Date arrivalDate;
    private int inStockQuantity;
    private int sellQuantity;

    public Story() {
    }

    public Story(Good good, Customer customer, Date sellDate, Date arrivalDate, int inStockQuantity, int sellQuantity) {
        this.good = good;
        this.customer = customer;
        this.sellDate = sellDate;
        this.arrivalDate = arrivalDate;
        this.inStockQuantity = inStockQuantity;
        this.sellQuantity = sellQuantity;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public int getInStockQuantity() {
        return inStockQuantity;
    }

    public void setInStockQuantity(int inStockQuantity) {
        this.inStockQuantity = inStockQuantity;
    }

    public int getSellQuantity() {
        return sellQuantity;
    }

    public void setSellQuantity(int sellQuantity) {
        this.sellQuantity = sellQuantity;
    }

    @Override
    public String toString() {
        return "Story{" + "good=" + good + ", customer=" + customer + ", sellDate=" + sellDate + ", arrivalDate=" + arrivalDate + ", inStockQuantity=" + inStockQuantity + ", sellQuantity=" + sellQuantity + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.good);
        hash = 17 * hash + Objects.hashCode(this.customer);
        hash = 17 * hash + Objects.hashCode(this.sellDate);
        hash = 17 * hash + Objects.hashCode(this.arrivalDate);
        hash = 17 * hash + this.inStockQuantity;
        hash = 17 * hash + this.sellQuantity;
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
        final Story other = (Story) obj;
        if (this.inStockQuantity != other.inStockQuantity) {
            return false;
        }
        if (this.sellQuantity != other.sellQuantity) {
            return false;
        }
        if (!Objects.equals(this.good, other.good)) {
            return false;
        }
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (!Objects.equals(this.sellDate, other.sellDate)) {
            return false;
        }
        if (!Objects.equals(this.arrivalDate, other.arrivalDate)) {
            return false;
        }
        return true;
    }
    
    
}
