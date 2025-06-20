package TenTen;

import java.util.*;

public class Outfit { 
    private ClothingItem top;
    private ClothingItem bottom;
    private List<Style> accessories;

    public Outfit(ClothingItem top, ClothingItem bottom, List<Style> accessories) {
        this.top = top;
        this.bottom = bottom;
        this.accessories = accessories; 
    }

    public String getStyleExplanation() {
        return top.getCategory() + "과 " + bottom.getCategory() + "의 기본 스타일 조합입니다.";
    }

    public void showOutfit() {
        System.out.println("Top: " + top.getColor() + ", Bottom: " + bottom.getColor());
    }
}
