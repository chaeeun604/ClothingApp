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
 
    public User(String userID, String password, String nickname) {
        this.userID = userID;
        this.password = password;
        this.nickname = nickname;
    }

    public boolean login(String inputID, String inputPassword) {
        return userID.equals(inputID) && password.equals(inputPassword);
    }

    public void logout() {
        System.out.println(nickname + " has logged out.");
    }

    public void updateProfile(double height, double weight, int footSize) {
        this.height = height;
        this.weight = weight;
        this.footSize = footSize;
    }

    public Closet getMyCloset() {
        return closet;
    }

    public List<Schedule> getMySchedule() {
        return schedules;
    }

    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }

    public void deleteAccount() {
        System.out.println("Account " + userID + " deleted.");
    }

    public void deleteCloset() {
        closet = new Closet();
    }

    public void clearSchedule() {
        schedules.clear();
    }
}