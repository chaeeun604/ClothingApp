package TenTen;

class Settings {
    private boolean notificationEnabled = true;
    private boolean darkMode = false;

    // 알림 ON으로 설정
    public void setNotificationsOn() {
        notificationEnabled = true;
        System.out.println("알림설정을 ON으로 설정했습니다.");
    }

    // 알림 OFF로 설정
    public void setNotificationsOff() {
        notificationEnabled = false;
        System.out.println("알림설정을 OFF으로 설정했습니다.");
    }

    // 다크모드 ON으로 설정
    public void setDarkModeOn() {
        darkMode = true;
        System.out.println("모드를 다크모드로 설정했습니다.");
    }

    // 다크모드 OFF로 설정
    public void setDarkModeOff() {
        darkMode = false;
        System.out.println("모드를 라이트모드로 설정했습니다.");
    }

    // 현재 설정 상태 출력
    public void showSettings() {
        System.out.println("알림: " + (notificationEnabled ? "켜짐" : "꺼짐") + ", 다크모드: " + (darkMode ? "사용" : "미사용"));
    }
