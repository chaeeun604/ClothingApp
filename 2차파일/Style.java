package TenTen;

import java.awt.Image;

public class Style { 
    private String styleID;
    private Image image;
    private String category;
    private double userRating; 

    public Style(String styleID, String category) {
        this.styleID = styleID;
        this.category = category;
        this.userRating = 0.0;
    }  

    public void likeStyle() {
        userRating++;
    }

    public String getCategory() {
        return category;
    }

    public double getUserRating() {
        return userRating;
    }
    
    public void registerPreferredStyles(User user) {
        // likedStyle[]의 내용 추가가 필요할 것 같습니다!
        System.out.println(user+"님의 선호 스타일을 등록합니다.");
    }
    
    @Override
    public String toString() {
        return "Style{" +
                "styleID='" + styleID + '\'' +
                ", category='" + category + '\'' +
                ", userRating=" + userRating +
                '}';
    }
}
/*package TenTen;

import java.awt.Image;

public class Style { 
    private String styleID;
    private Image image;
    private String category;
    private double userRating; 

    public Style(String styleID, String category) {
        this.styleID = styleID;
        this.category = category;
        this.userRating = 0.0;
    }  

    public void likeStyle() {
        userRating++;
    }

    public String getCategory() {
        return category;
    }

    public double getUserRating() {
        return userRating;
    }
    
    public void registerPreferredStyles(User user) {
    	// likedStyle[]의 내용 추가가 필요할 것 같습니다!
    	System.out.println(user+"님의 선호 스타일을 등록합니다.");
    }
}*/