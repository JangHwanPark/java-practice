package models;

import java.sql.Date;

public class OrdersDTO {
    private int customer_id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String purchase_vehicle;
    private String vin;
    private String color;
    private Date purchase_date;
    private int price;
    private boolean payment_status;

    /* *************** 생성자 *************** */
    public OrdersDTO(int customer_id, String name, String email, String phone, String address,
                            String purchase_vehicle, String vin, String color, Date purchase_date,
                            int price, boolean payment_status) {
        this.customer_id = customer_id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.purchase_vehicle = purchase_vehicle;
        this.vin = vin;
        this.color = color;
        this.purchase_date = purchase_date;
        this.price = price;
        this.payment_status = payment_status;
    }

    // Getters
    public int getCustomerId() {
        return customer_id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getPurchaseVehicle() {
        return purchase_vehicle;
    }

    public String getVin() {
        return vin;
    }

    public String getColor() {
        return color;
    }

    public Date getPurchaseDate() {
        return purchase_date;
    }

    public int getPrice() {
        return price;
    }

    public boolean isPaymentStatus() {
        return payment_status;
    }

    // Setters
    public void setCustomerId(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPurchaseVehicle(String purchase_vehicle) {
        this.purchase_vehicle = purchase_vehicle;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPurchaseDate(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPaymentStatus(boolean payment_status) {
        this.payment_status = payment_status;
    }

    @Override
    public String toString() {
        return "CustomerOrderDTO{" +
                "customer_id=" + customer_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", purchase_vehicle='" + purchase_vehicle + '\'' +
                ", vin='" + vin + '\'' +
                ", color='" + color + '\'' +
                ", purchase_date=" + purchase_date +
                ", price=" + price +
                ", payment_status=" + payment_status +
                '}';
    }
}