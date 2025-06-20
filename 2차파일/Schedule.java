package TenTen;

import java.util.*;

// 일정 정보를 관리하는 Schedule 클래스
class Schedule {
    private Date date;        // 일정 날짜
    private String time;      // 일정 시간
    private String title;     // 일정 제목
    private String memo;      // 일정 메모

    public Schedule(Date date, String time, String title, String memo) {
        this.date = date;
        this.time = time;
        this.title = title;
        this.memo = memo;
    }

    // 일정 날짜 반환
    public Date getDate() { return date; }

    // 일정 시간 반환
    public String getTime() { return time; }

    // 일정 제목 반환
    public String getTitle() { return title; }

    // 일정 메모 반환
    public String getMemo() { return memo; }

    // 일정 제목 및 메모 수정
    public void updateSchedule(String newTitle, String newMemo) {
        this.title = newTitle;
        this.memo = newMemo;
    }

    // 특정 날짜와 일정이 일치하는지 확인
    public boolean matchesDate(Date queryDate) {
        return date.equals(queryDate);
    }

    // 일정 추가 메시지 출력
    public void addSchedule() {
        System.out.println("일정이 추가되었습니다: " + title);
    }

    // 일정 삭제 메시지 출력
    public void deleteSchedule() {
        System.out.println("일정이 삭제되었습니다: " + title);
    }
}
