package TenTen;

import java.util.*;
 
// 커뮤니티 댓글 객체
class Comment {
    private String commentID;
    private User author;
    private String content;
    private Date timestamp;

    // 댓글 생성자
    public Comment(String commentID, User author, String content) {
        this.commentID = commentID;
        this.author = author;
        this.content = content;
        this.timestamp = new Date(); // 현재 시간으로 초기화
    }

    // 댓글 내용 수정
    public void editComment(String content) {
        this.content = content;
    }

    // 댓글 출력
    public void showComment() {
        System.out.println("댓글: " + content);
    }
}
