package TenTen;

import java.util.*;

// 코디 구성 객체 (상의/하의/액세서리)
class Outfit {
    private ClothingItem top;
    private ClothingItem bottom;
    private List<Style> accessories;

    public Outfit(ClothingItem top, ClothingItem bottom, List<Style> accessories) {
        this.top = top;
        this.bottom = bottom;
        this.accessories = accessories;
    }

    // 코디 설명 제공
    public String getStyleExplanation() {
        return top.getCategory() + "과 " + bottom.getCategory() + "의 기본 스타일 조합입니다.";
    }

    // 코디 정보 출력
    public void showOutfit() {
        System.out.println("Top: " + top.getName() + ", Bottom: " + bottom.getName());
    }
}
