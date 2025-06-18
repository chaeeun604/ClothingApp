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
}