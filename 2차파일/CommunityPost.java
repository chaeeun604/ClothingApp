package TenTen;

import java.util.*; 

// 커뮤니티 글 객체 (댓글 포함)
class CommunityPost {
    private String postID;
    private User writer;
    private String content;
    private Date timestamp;
    private List<Comment> comments = new ArrayList<>();

    // 게시글 생성자
    public CommunityPost(String postID, User writer, String content) {
        this.postID = postID;
        this.writer = writer;
        this.content = content;
        this.timestamp = new Date();
    }

    // 댓글 추가
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    // 댓글 목록 반환
    public List<Comment> getComments() {
        return comments;
    }

    // 게시글 출력
    public void showPost() {
        System.out.println("작성자: " + writer + "\n내용: " + content);
    }
}
