package src.Product;

import java.util.Vector;

public class ProductList {
    static private int spid = 0;
    private ProductList itemlist;
    private final Vector<iProduct> productList = new Vector<iProduct>();


    public Vector<iProduct> getProductList() {
        return productList;
    }

    public void setitemtlist(ProductList itemlist) {
        this.itemlist = itemlist;
    }

    public void addProduct(iProduct p) {
        productList.add(p);
        p.pid = spid;
        spid = spid + 1;
    }

    public ProductList getItems(String kind) { //monitor, keyboard
        itemlist = new ProductList();
        for (iProduct p : productList) {
            if (kind.equals(p.getKind())) {
                itemlist.productList.add(p);
            }
        }
        return itemlist;
    }

    public iProduct selectItems(int id) {
        return productList.elementAt(id);
    }

    public void showProductlist() {
        for (iProduct p : productList) {
            p.showitem();
        }
    }
}