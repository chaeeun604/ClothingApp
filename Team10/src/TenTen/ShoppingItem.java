package TenTen;

import java.awt.Image;

public class ShoppingItem { 
    private Image itemPhoto;
    private String name;
    private String link;
    private double price;
    private String category;

    public ShoppingItem(String name, String link, double price, String category) {
        this.name = name;
        this.link = link;
        this.price = price;
        this.category = category;
    }
 
    public void displayItemInfo() {
        System.out.println("상품명: " + name + ", 가격: " + price + "원");
    }

    public String getCategory() {
        return category;
    }
}
