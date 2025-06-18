package TenTen;

import java.awt.Image;
import java.util.*;

public class ClothingItem {
    private String itemID;
    private Image photo;
    private String category;
    private String color; 
    private String season; 
    private String material;
    private List<String> tags = new ArrayList<>(); 

    public ClothingItem(String itemID, String category, String color, String season, String material) {
        this.itemID = itemID;
        this.category = category;
        this.color = color;
        this.season = season;
        this.material = material;
    }

    public String getItemID() { return itemID; }
    public String getCategory() { return category; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public boolean hasTag(String tag) { return tags.contains(tag); }

    public void editTag(String tag) {
        if (!tags.contains(tag)) {
            tags.add(tag);
        }
    }

    public List<String> getTags() { return tags; }
}