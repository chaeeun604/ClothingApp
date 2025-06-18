package TenTen;

import java.util.*;

public class Closet {
    private List<ClothingItem> items = new ArrayList<>();

    public void addItem(ClothingItem item) {
        items.add(item); 
    }

    public void removeItem(String itemID) {
        items.removeIf(item -> item.getItemID().equals(itemID));
    }

    public List<ClothingItem> getItemsByCategory(String category) {
        List<ClothingItem> result = new ArrayList<>();
        for (ClothingItem item : items) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                result.add(item);
            }
        }
        return result;
    }

    public void updateItem(String itemID, String newColor) {
        for (ClothingItem item : items) {
            if (item.getItemID().equals(itemID)) {
                item.setColor(newColor);
            }
        }
    }

    public List<ClothingItem> findItemByTag(String tag) {
        List<ClothingItem> result = new ArrayList<>();
        for (ClothingItem item : items) {
            if (item.hasTag(tag)) {
                result.add(item);
            }
        }
        return result;
    }

    public List<ClothingItem> getAllItems() {
        return items;
    }
}