package TenTen;

import java.util.*;

public class Schedule { 
    private Date date;
    private String time;
    private String title;
    private String memo;

    public Schedule(Date date, String time, String title, String memo) {
        this.date = date;
        this.time = time;
        this.title = title; 
        this.memo = memo;
    }

    public Date getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public String getMemo() {
        return memo;
    }

    public void updateSchedule(String newTitle, String newMemo) {
        this.title = newTitle;
        this.memo = newMemo;
    }

    public boolean matchesDate(Date queryDate) {
        return date.equals(queryDate);
    }
    
    public void addSchedule() {
        System.out.println("일정이 추가되었습니다: " + title);
    }

    public void deleteSchedule() {
        System.out.println("일정이 삭제되었습니다: " + title);
    }
}