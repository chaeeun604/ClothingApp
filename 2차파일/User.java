package TenTen;
import java.awt.Image;
import java.util.*;

public class User { 
    private String userID;
    private String password;
    private String nickname;
    private Image profilePhoto;
    private double height;
    private double weight;
    private int footSize;
    
    private Closet closet = new Closet();
    private List<Schedule> schedules = new ArrayList<>();
 
    public User(String userID, String password, String nickname) { //생성자
        this.userID = userID;
        this.password = password;
        this.nickname = nickname;
    }

    public boolean login(String inputID, String inputPassword) { //로그인
        return userID.equals(inputID) && password.equals(inputPassword); // 보안상의 위험이 있으나 우선 간소화
    }

    public void logout() { //로그아웃
        System.out.println(nickname + " has logged out.");
    }

    public void updateProfile(double height, double weight, int footSize) { //프로필 변경 적용
        this.height = height;
        this.weight = weight;
        this.footSize = footSize;
        System.out.println("설정을 완료했습니다.");
        System.out.println("현재 키 : "+height+", 현재 몸무게 : "+weight+", 현재 발사이즈 : "+footSize);
    }

    public Closet getMyCloset() { //현 옷장 불러오기
        return closet;
    }

    public List<Schedule> getMySchedule() { //현 일정 불러오기
        return schedules;
    }

    public void addSchedule(Schedule schedule) { //일정 새로 추가
        schedules.add(schedule);
    }

    public void deleteAccount() { // 계정 삭제
        // 계정 class 없애는 거 추가 필요
        System.out.println("Account " + userID + " deleted.");
    }

    public void deleteCloset() { // 옷장 삭제 -> 초기화
        closet = new Closet();
    }

    public void clearSchedule() { // 일정 전부 삭제
        schedules.clear();
    }
    
    @Override
    public String toString() {
        return nickname;
    }
}
/*
package TenTen;
import java.awt.Image;
import java.util.*;

public class User { 
    private String userID;
    private String password;
    private String nickname;
    private Image profilePhoto;
    private double height;
    private double weight;
    private int footSize;
    
    private Closet closet = new Closet();
    private List<Schedule> schedules = new ArrayList<>();
 
    public User(String userID, String password, String nickname) { //생성자
        this.userID = userID;
        this.password = password;
        this.nickname = nickname;
    }

    public boolean login(String inputID, String inputPassword) { //로그인
        return userID.equals(inputID) && password.equals(inputPassword); // 보안상의 위험이 있으나 우선 간소화
    }

    public void logout() { //로그아웃
        System.out.println(nickname + " has logged out.");
    }

    public void updateProfile(double height, double weight, int footSize) { //프로필 변경 적용
        this.height = height;
        this.weight = weight;
        this.footSize = footSize;
        System.out.println("설정을 완료했습니다.");
        System.out.println("현재 키 : "+height+", 현재 몸무게 : "+weight+", 현재 발사이즈 : "+footSize);
    }

    public Closet getMyCloset() { //현 옷장 불러오기
        return closet;
    }

    public List<Schedule> getMySchedule() { //현 일정 불러오기
        return schedules;
    }

    public void addSchedule(Schedule schedule) { //일정 새로 추가
        schedules.add(schedule);
    }

    public void deleteAccount() { // 계정 삭제
    	// 계정 class 없애는 거 추가 필요
        System.out.println("Account " + userID + " deleted.");
    }

    public void deleteCloset() { // 옷장 삭제 -> 초기화
        closet = new Closet();
    }

    public void clearSchedule() { // 일정 전부 삭제
        schedules.clear();
    }

}*/