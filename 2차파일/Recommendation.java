package TenTen;

import java.util.*;

// 추천 시스템 결과 객체
class Recommendation {
    private Date date;
    private Weather weather;
    private Schedule schedule;
    private Outfit selectedOutfit;
    private String reason;
    private String feedback;

    // 사용자, 날씨, 일정 기반 코디 추천
    public Outfit generateOutfit(User user, Weather weather, Schedule schedule) {
        this.date = new Date(); // 추천 시점 저장
        Closet closet = user.getMyCloset();
        List<ClothingItem> tops = closet.getItemsByCategory("top");
        List<ClothingItem> bottoms = closet.getItemsByCategory("bottom");

        if (!tops.isEmpty() && !bottoms.isEmpty()) {
            ClothingItem top = tops.get(0);
            ClothingItem bottom = bottoms.get(0);
            selectedOutfit = new Outfit(top, bottom, new ArrayList<>());
            reason = "날씨 " + weather.getAverageTemp() + "도와 일정 " + schedule.getTitle() + "에 적합한 코디입니다.";
            return selectedOutfit;
        } else {
            reason = "적절한 옷이 없습니다.";
            return null;
        }
    }

    // 사용자 피드백 추가
    public void addFeedback(User user, String feedback) {
        this.feedback = feedback;
    }

    // 피드백 수정
    public void updateFeedback(String newFeedback) {
        this.feedback = newFeedback;
    }

    // 추천 사유 반환
    public String getRecommendationReason() {
        return reason;
    }
}

