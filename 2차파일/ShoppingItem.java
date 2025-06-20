package TenTen;

import java.awt.Image;

// 쇼핑 아이템의 정보를 담는 클래스 (상품 이미지, 이름, 링크, 가격, 카테고리 포함)
class ShoppingItem {
    private Image itemPhoto;     // 상품 이미지
    private String name;         // 상품명
    private String link;         // 구매 링크
    private double price;        // 가격
    private String category;     // 카테고리(예: 상의, 하의 등)

    // 생성자: 상품명, 링크, 가격, 카테고리를 받아 객체 생성
    public ShoppingItem(String name, String link, double price, String category) {
        this.name = name;
        this.link = link;
        this.price = price;
        this.category = category;
    }

    // 상품 정보를 출력하는 메서드
    public void displayItemInfo() {
        System.out.println("상품명: " + name + ", 가격: " + price + "원");
    }

    // 상품 카테고리 반환
    public String getCategory() {
        return category;
    }

    // 상품명 반환
    public String getName() {
        return name;
    }

    // 상품 링크 반환
    public String getLink() {
        return link;
    }

    // 가격 반환
    public double getPrice() {
        return price;
    }

    // 이미지가 추후 필요하다면 getter도 구현 가능
    public Image getItemPhoto() {
        return itemPhoto;
    }

    // 이미지 설정 (외부에서 이미지 등록 시 사용)
    public void setItemPhoto(Image itemPhoto) {
        this.itemPhoto = itemPhoto;
    }
}
