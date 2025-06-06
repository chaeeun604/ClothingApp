package Player;

import Weapon.Weapon;

public class Player {
    private String name;
    private int hp;
    private int power;
    private Weapon weapon;
    protected int damageReceivedCount = 0;

    public Player(String name, int hp, int power) {
        this.name = name;
        this.hp = hp;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void attack(Player target) {
        if (weapon != null) {
            // 전용 무기일 때 (attackPower * 2)
            if (weapon.getName().equals(this.getDefaultWeaponName())) {
                target.setHp(Math.max(0, target.getHp() - (this.power * 2)));
                System.out.println("전용 무기로 공격! 공격력 * 2");
            } else {
                target.setHp(Math.max(0, target.getHp() - (this.power + weapon.getPower())));
                weapon.use();  // 내구도 감소
                System.out.println("무기로 공격! " + weapon.getName() + " 공격력: " + (this.power + weapon.getPower()));
            }

            // 내구도 체크
            if (weapon.getDurability() == 0) {
                System.out.println(weapon.getName() + "의 내구도가 0이 되어 사용 불가");
            }
            weapon.attackMotion();  // 공격 모션 실행
        } else {
            target.setHp(Math.max(0, target.getHp() - this.power));
            System.out.println("일반 공격을 했다!");
        }

        target.receiveDamage();  // 피해를 받은 횟수 증가
    }

    public void receiveDamage() {
        damageReceivedCount++;
    }

    public void showStatus() {
        System.out.println(this.name + ": " + this.hp + " HP, " + this.power + " Power");
    }

    public String getDefaultWeaponName() {
        return "검";
    }
}