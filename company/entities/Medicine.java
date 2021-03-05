package com.company.entities;

public class Medicine {
    private int id;
    private String name;
    private int price;
    private String expire_date;
    private String manufacturer;

    public Medicine(){

    }

    public Medicine(String name, int price, String expire_date, String manufacturer){
        setName(name);
        setPrice(price);
        setExpire_date(expire_date);
        setManufacturer(manufacturer);
    }

    public Medicine(int id, String name, int price, String expire_date, String manufacturer){
        setId(id);
        setName(name);
        setPrice(price);
        setExpire_date(expire_date);
        setManufacturer(manufacturer);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Medicine{ id=" + id + ", name='" + name + "', price=" + price + ", expire date: '" + expire_date
                + "', manufacturer='" + manufacturer + "'} ";
    }
}
