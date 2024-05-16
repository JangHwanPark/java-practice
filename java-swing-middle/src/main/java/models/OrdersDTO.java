package models;

import java.sql.Date;

public class OrdersDTO {
    private int orderId;
    private AdminDTO admin;
    private CustomerDTO customer;
    private ProductDTO product;
    private Date purchase_date;
    private Date service_due_date;
    private boolean payment_status;

    /* *************** 생성자 *************** */
    public OrdersDTO(AdminDTO admin, CustomerDTO customer, ProductDTO product, Date purchase_date, Date service_due_date, boolean payment_status) {
        this.admin = admin;
        this.customer = customer;
        this.product = product;
        this.purchase_date = purchase_date;
        this.service_due_date = service_due_date;
        this.payment_status = payment_status;
    }

    // 필드를 개별적으로 설정할 수 있는 생성자
    public OrdersDTO() {}

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public CustomerDTO getCustomer() { return customer; }
    public ProductDTO getProduct() { return product; }
    public AdminDTO getAdmin() { return admin; }

    public Date getPurchaseDate() {return purchase_date;}

    public Date getServiceDueDate() {
        return service_due_date;
    }

    public boolean isPaymentStatus() {
        return payment_status;
    }

    // Setters
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setAdmin(AdminDTO admin) {
        this.admin = admin;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public void setPurchaseDate(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public void setServiceDueDate(Date service_due_date) {
        this.service_due_date = service_due_date;
    }

    public void setPaymentStatus(boolean payment_status) {
        this.payment_status = payment_status;
    }

    @Override
    public String toString() {
        return String.format("Order{customer=%s, product=%s, admin=%s, purchaseDate=%s,paymentStatus=%b}",
                customer.getName(), product.getModel(), admin.getName(), purchase_date, payment_status);
    }
}