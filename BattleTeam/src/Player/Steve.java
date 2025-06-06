package Player;

public class Steve extends Player {
    private boolean usedSleep = false;
    private boolean usedAngelCard = false;

    public Steve() {
        super("Steve", 250, 20);  // HP 250, 공격력 20
    }  

    public void useSleep() {
        if (!usedSleep) {
            this.setHp(Math.min(this.getHp() + 100, 250));  // HP 100 회복 (최대 HP는 250)
            usedSleep = true;
            System.out.println("💤 스티브가 침대에서 숙면! HP 100 회복");
        } else {
            System.out.println("❌ 이미 숙면을 사용했습니다.");
        }
    }

    public void useAngelCard() {
        if (!usedAngelCard) {
            usedAngelCard = true;
            System.out.println("🛡️ 천사카드 발동! 다음 공격 무효화!");
        } else {
            System.out.println("❌ 이미 천사카드를 사용했습니다.");
        }
    }

    @Override
    public String getDefaultWeaponName() {
        return "검";  // 스티브의 전용 무기는 '검'
    }
}
