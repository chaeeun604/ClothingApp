package TenTen;

public class Settings {
    private boolean notificationEnabled = true;
    private boolean darkMode = false;

    public void toggleNotifications() {
        notificationEnabled = !notificationEnabled;
    }

    public void toggleDarkMode() {
        darkMode = !darkMode;
    }

    public void showSettings() {
        System.out.println("알림: " + (notificationEnabled ? "켜짐" : "꺼짐") + ", 다크모드: " + (darkMode ? "사용" : "미사용"));
    }
}
