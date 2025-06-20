package TenTen;

public class Settings { 
    private boolean notificationEnabled = true;
    private boolean darkMode = false;

    public void toggleNotifications() {
        notificationEnabled = !notificationEnabled;
        if(notificationEnabled)	System.out.println("알림설정을 ON으로 설정했습니다.");
        else	System.out.println("알림설정을 OFF으로 설정했습니다.");
    }

    public void toggleDarkMode() {
        darkMode = !darkMode;
        if(darkMode)	System.out.println("모드를 다크모드로 설정했습니다.");
        else	System.out.println("모드를 라이트모드로 설정했습니다.");
    }

    public void showSettings() {
        System.out.println("알림: " + (notificationEnabled ? "켜짐" : "꺼짐") + ", 다크모드: " + (darkMode ? "사용" : "미사용"));
    }
} 
