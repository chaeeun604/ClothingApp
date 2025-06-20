package TenTen;

import java.awt.Image;
import java.util.*; 

// 옷 객체: 분류, 색상, 계절, 재질 및 태그 포함
class ClothingItem {
    private String itemID;
    private String name;
    private String category;
    private String color;
    private String season;
    private String material;
    private List<String> tags = new ArrayList<>();

    // 옷 생성자
    public ClothingItem(String itemID, String category, String color, String season, String material) {
        this.itemID = itemID;
        this.name = category + "/" + color;
        this.category = category;
        this.color = color;
        this.season = season;
        this.material = material;
    }

    // 태그 추가
    public void editTag(String tag) {
        tags.add(tag);
    }

    // 색상 변경
    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getTags() { return tags; }
    public String getItemID() { return itemID; }
    public String getCategory() { return category; }
    public String getName() { return name; }
}
