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
    
    // 로그인 가능 아이디/비번/별명 정보 리스트
    private static List<String> registeredIDs = new ArrayList<>();
    private static List<String> registeredPasswords = new ArrayList<>();
    private static List<String> registeredNicknames = new ArrayList<>();
    
    // 예시 데이터
    static {
        registeredIDs.add("CinnaPie1234");
        registeredPasswords.add("12345678");
        registeredNicknames.add("은서장");
        
        registeredIDs.add("admin1");
        registeredPasswords.add("admin123");
        registeredNicknames.add("관리자아님");
        
        registeredIDs.add("user01");
        registeredPasswords.add("12345678910");
        registeredNicknames.add("누군가");
    }
 
    public User(String userID, String password, String nickname) { //생성자
        this.userID = userID;
        this.password = password;
        this.nickname = nickname;
    }
/*
    public boolean login(String inputID, String inputPassword) { //로그인
        return userID.equals(inputID) && password.equals(inputPassword); // 보안상의 위험이 있으나 우선 간소화
    }
*/    
    // 등록된 사용자 목록에서 로그인 정보 대조 + 확인
    public boolean login(String inputID, String inputPassword) {
        for (int i = 0; i < registeredIDs.size(); i++) {
            if (registeredIDs.get(i).equals(inputID) && registeredPasswords.get(i).equals(inputPassword)) {
                return true;
            }
        }
        return false; // 로그인 실패
    }
    
    // 회원가입 메소드
    public static boolean registerUser(String userID, String password, String nickname) {
        // 아이디 중복 확인
        if(registeredIDs.contains(userID)) {
            return false; // 중복된 아이디
        }
        
        // 회원가입 정보 추가
        registeredIDs.add(userID);
        registeredPasswords.add(password);
        registeredNicknames.add(nickname);
        
        return true; // 회원가입 성공
    }
    
 // 아이디 중복 확인 메소드
    public static boolean isIDExists(String userID) {
        return registeredIDs.contains(userID);
    }
    
    /*
    //등록된 사용자 목록
    public static void showRegisteredUsers() {
        System.out.println("=== 등록된 사용자 목록 ===");
        for(int i = 0; i < registeredIDs.size(); i++) {
            System.out.println((i+1) + ". ID: " + registeredIDs.get(i) +", 닉네임: " + registeredNicknames.get(i));
        }
    }*/

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