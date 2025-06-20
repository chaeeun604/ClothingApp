package TenTen;

import java.util.*;
 
// 사용자 옷장: 옷 추가, 삭제, 카테고리 및 태그별 조회
class Closet {
    private List<ClothingItem> items = new ArrayList<>();

    // 옷을 옷장에 추가함
    public void addItem(ClothingItem item) {
        items.add(item);
        System.out.println("옷이 추가되었습니다: " + item.getName());
    }

    // 아이디로 옷을 삭제함
    public void removeItem(String itemId) {
        items.removeIf(i -> i.getItemID().equals(itemId));
        System.out.println("옷이 삭제되었습니다: " + itemId);
    }

    // 옷의 색상을 업데이트함
    public void updateItem(String itemId, String newColor) {
        for (ClothingItem item : items) {
            if (item.getItemID().equals(itemId)) {
                item.setColor(newColor);
                System.out.println("색상 변경 완료: " + newColor);
            }
        }
    }

    // 옷장에 있는 모든 옷 반환
    public List<ClothingItem> getAllItems() {
        return items;
    }

    // 태그로 옷을 검색함
    public List<ClothingItem> findItemByTag(String tag) {
        List<ClothingItem> result = new ArrayList<>();
        for (ClothingItem item : items) {
            if (item.getTags().contains(tag)) result.add(item);
        }
        return result;
    }

    // 카테고리로 옷을 검색함
    public List<ClothingItem> getItemsByCategory(String category) {
        List<ClothingItem> result = new ArrayList<>();
        for (ClothingItem item : items) {
            if (item.getCategory().equalsIgnoreCase(category)) result.add(item);
        }
        return result;
    }
}
