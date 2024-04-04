package src.Product;

public abstract class iProduct {

    protected int pid;
    protected String kind;
    protected int totalquantity;
    protected int price;
    protected String maker;
    protected String year;
    protected String itemname;


    public int getPid() {
        return pid;
    }

    public String getKind() {
        return kind;
    }

    public int getTotalquantity() {
        return totalquantity;
    }

    public int getPrice() {
        return price;
    }

    public String getMaker() {
        return maker;
    }

    public String getYear() {
        return year;
    }

    public String getItemname() {
        return itemname;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setTotalquantity(int totalquantity) {
        this.totalquantity = totalquantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public abstract void showitem();

}