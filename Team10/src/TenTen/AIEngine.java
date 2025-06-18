package TenTen;

import java.awt.Image;
import java.util.*;

public class AIEngine {
    public String analyzeImage(Image image) {
        // 간단한 체형 분석 결과 예시
        return "표준 체형";
    } 

    public void learnUserStyle(User user, List<Style> likedStyles) {
        System.out.println("사용자 " + user + "의 스타일 학습 완료.");
    }

    public Recommendation generateRecommendation(User user, Weather weather, Schedule schedule) {
        Recommendation rec = new Recommendation();
        Outfit outfit = rec.generateOutfit(user, weather, schedule);
        rec.addFeedback(user, "첫 추천 완료");
        return rec;
    }
}