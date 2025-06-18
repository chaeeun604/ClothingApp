package TenTen;

import java.util.*;

public class Recommendation {
    private Date date;
    private Weather weather;
    private Schedule schedule;
    private Outfit selectedOutfit;
    private String reason;
    private String feedback;
    private Outfit feedbackOutfit;

    public Outfit generateOutfit(User user, Weather weather, Schedule schedule) {
        Closet closet = user.getMyCloset();
        List<ClothingItem> tops = closet.getItemsByCategory("top");
        List<ClothingItem> bottoms = closet.getItemsByCategory("bottom");

        if (!tops.isEmpty() && !bottoms.isEmpty()) {
            ClothingItem top = tops.get(0);  // 단순 선택
            ClothingItem bottom = bottoms.get(0);
            selectedOutfit = new Outfit(top, bottom, new ArrayList<>());
            reason = "날씨 " + weather.getAverageTemp() + "도와 일정 " + schedule.getTitle() + "에 적합한 코디입니다.";
            return selectedOutfit;
        } else {
            reason = "적절한 옷이 없습니다.";
            return null;
        }
    }

    public void addFeedback(User user, String feedback) {
        this.feedback = feedback;
    }

    public void updateFeedback(String newFeedback) {
        this.feedback = newFeedback;
    }

    public String getRecommendationReason() {
        return reason;
    }
}
