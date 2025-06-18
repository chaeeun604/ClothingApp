package TenTen;

import java.util.*;

public class Comment {
    private String commentID;
    private User author;
    private String content;
    private Date timestamp;
 
    public Comment(String commentID, User author, String content) {
        this.commentID = commentID;
        this.author = author;
        this.content = content;
        this.timestamp = new Date();
    }

    public void editComment(String content) {
        this.content = content;
    }

    public void showComment() {
        System.out.println("댓글: " + content);
    }
}