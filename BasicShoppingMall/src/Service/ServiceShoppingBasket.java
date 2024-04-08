package src.Service;

import src.Product.iProduct;
import src.Shopping.PickedProduct;
import src.Shopping.ShoppingBasket;

import java.util.ArrayList;
import java.util.List;

public class ServiceShoppingBasket {
    private final List<ShoppingBasket> shoppingBaskets = new ArrayList<>();
    private final ServiceProducts serviceProducts;

    public ServiceShoppingBasket(ServiceProducts serviceProducts) {
        this.serviceProducts = serviceProducts;
    }

    // 사용자 ID, 상품 정보를 기반으로 사용자의 쇼핑바구니를 생성, 기존의 쇼핑바구니에 상품을 추가
    public ShoppingBasket getOrCreateShoppingBasket(String uid) {
        for (ShoppingBasket basket : shoppingBaskets) {
            if (uid.equals(basket.getUserid())) {
                return basket;
            }
        }

        // 새 장바구니 생성
        ShoppingBasket newBasket = new ShoppingBasket(uid);
        shoppingBaskets.add(newBasket);
        return newBasket;
    }

    // 장바구니에 상품 추가
    public void addProductToBasket(ShoppingBasket basket, int[] productIds, int[] quantities) {
        for (int i = 0; i < productIds.length; i++) {
            iProduct product = serviceProducts.findProductById(productIds[i]); // 상품 서비스를 통해 상품 찾기
            if (product != null) {
                PickedProduct pickedProduct = new PickedProduct(product.getPid(), product.getMaker(), product.getPrice(), quantities[i]);
                basket.addProduct(pickedProduct);
            }
        }
    }

    public List<ShoppingBasket> findShoppingBasketByUserId(String uid) {
        List<ShoppingBasket> userBaskets = new ArrayList<>();
        for (ShoppingBasket basket : shoppingBaskets) {
            if (uid.equals(basket.getUserid())) {
                userBaskets.add(basket);
            }
        }
        return userBaskets;
    }
}