package TenTen;

import java.awt.Image;
import java.util.*; 

class AIEngine {
    private Map<User, List<Style>> userStyleMap = new HashMap<>();

    public String analyzeImage(Image image) {
        return "표준 체형"; // 체형 분석 결과 반환
    }

    public void learnUserStyle(User user, List<Style> likedStyles) {
        userStyleMap.put(user, likedStyles); // 사용자와 선호 스타일을 저장
        System.out.println("사용자 " + user + "의 스타일 학습 완료.");
    }

    public Recommendation generateRecommendation(User user, Weather weather, Schedule schedule) {
        Recommendation rec = new Recommendation();
        Outfit outfit = rec.generateOutfit(user, weather, schedule); // 추천 코디 생성
        rec.addFeedback(user, "첫 추천 완료");
        return rec;
    }
}
