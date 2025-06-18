package TenTen;

import java.util.*;

public class CommunityPost {
    private String postID;
    private User writer;
    private String content;
    private Date timestamp;
    private List<Comment> comments = new ArrayList<>();

    public CommunityPost(String postID, User writer, String content) {
        this.postID = postID;
        this.writer = writer; 
        this.content = content;
        this.timestamp = new Date();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void showPost() {
        System.out.println("작성자: " + writer + "\n내용: " + content);
    }
}