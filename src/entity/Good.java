package entity;

import java.io.Serializable;
import java.util.Objects;

public class Good implements Serializable{
    private String name;
    private Double weight;
    private String manufacturer;


    public Good() {
    }

    public Good(String name, Double weight, Double price, String manufacturer) {
        this.name = name;
        this.weight = weight;
        this.manufacturer = manufacturer;
    }

    public Good(String name, String weight, String manufacturer) {
        this.name = name;
        setWeight(weight);
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setWeight(String weight) {
        try {
            Double weightDouble = Double.parseDouble(weight);
            this.weight = weightDouble;
        } catch (Exception e) {
            System.out.println("Вы ввели не числовое значение. Значение не изменено.");
        }
    }
    
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Good{" + "name=" + name + ", weight=" + weight + ", manufacturer=" + manufacturer + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.weight);
        hash = 41 * hash + Objects.hashCode(this.manufacturer);
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
        final Good other = (Good) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.manufacturer, other.manufacturer)) {
            return false;
        }
        if (!Objects.equals(this.weight, other.weight)) {
            return false;
        }
        return true;
    }


    
}
