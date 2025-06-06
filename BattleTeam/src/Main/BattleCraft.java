package Main;

import java.awt.EventQueue;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import Player.*;
import Weapon.*;

public class BattleCraft extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField logArea;
    private Steve steve;
    private Player[] monsters;
    private Player currentMonster;
    private int monsterIndex = 0;  
    private Weapon[] weapons;
    private JLabel lblSteveHp;
    private JLabel lblMonsterHp;
    private JLabel lblMonsterName;
    private JLabel lblWeapon;

    private JProgressBar barSteveHp;
    private JProgressBar barMonsterHp;
    private JLabel lblSteveName;
    private JScrollPane scrollPane;

    private JButton btnSword;
    private JButton btnBow;
    private JButton btnBomb;
    private JButton btnPoison;
    private JButton btnSleep;
    private JButton btnAngelCard;
    private boolean isSteveTurn = true;  // 스티브의 턴을 체크하는 변수

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BattleCraft frame = new BattleCraft();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BattleCraft() {
        // 기본 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1094, 709);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // 컴포넌트 초기화 코드
        lblSteveName = new JLabel("스티브"); 
        lblSteveName.setBounds(105, 418, 50, 15);
        contentPane.add(lblSteveName);

        lblSteveHp = new JLabel("HP");
        lblSteveHp.setBounds(95, 110, 50, 15);
        contentPane.add(lblSteveHp);

        lblWeapon = new JLabel("무기 ");
        lblWeapon.setBounds(12, 497, 50, 15);
        contentPane.add(lblWeapon);

        lblMonsterName = new JLabel("몬스터");
        lblMonsterName.setBounds(708, 418, 50, 15);
        contentPane.add(lblMonsterName);

        lblMonsterHp = new JLabel("HP");
        lblMonsterHp.setBounds(708, 110, 50, 15);
        contentPane.add(lblMonsterHp);

        barSteveHp = new JProgressBar();
        barSteveHp.setBounds(133, 111, 146, 14);
        contentPane.add(barSteveHp);

        barMonsterHp = new JProgressBar();
        barMonsterHp.setBounds(746, 110, 146, 14);
        contentPane.add(barMonsterHp);

        JLabel lblNewLabel_2_1 = new JLabel("능력");
        lblNewLabel_2_1.setBounds(12, 591, 50, 15);
        contentPane.add(lblNewLabel_2_1);

        btnSword = new JButton("검");
        btnSword.addActionListener(e -> { steve.setWeapon(new Sword()); attackTurn(); });
        btnSword.setBounds(45, 514, 110, 23);
        contentPane.add(btnSword);

        btnBow = new JButton("활");
        btnBow.addActionListener(e -> { steve.setWeapon(new Bow()); attackTurn(); });
        btnBow.setBounds(169, 514, 110, 23);
        contentPane.add(btnBow);

        btnBomb = new JButton("폭탄");
        btnBomb.addActionListener(e -> { steve.setWeapon(new Bomb()); attackTurn(); });
        btnBomb.setBounds(45, 558, 110, 23);
        contentPane.add(btnBomb);

        btnPoison = new JButton("독");
        btnPoison.addActionListener(e -> { steve.setWeapon(new Poison()); attackTurn(); });
        btnPoison.setBounds(169, 558, 110, 23);
        contentPane.add(btnPoison);

        btnSleep = new JButton("침대에서 숙면");
        btnSleep.addActionListener(e -> {
            steve.useSleep();
            updateStatusLabels();
            logArea.setText(logArea.getText() + "💤 스티브가 숙면을 취해 HP 회복!\n");
            btnSleep.setEnabled(false); // 한 번만 사용 가능
        });
        btnSleep.setBounds(45, 603, 110, 23);
        contentPane.add(btnSleep);

        btnAngelCard = new JButton("천사카드");
        btnAngelCard.addActionListener(e -> {
            steve.useAngelCard();
            logArea.setText(logArea.getText() + "🛡️ 천사카드 사용! 다음 공격 무효화!\n");
            btnAngelCard.setEnabled(false); // 한 번만 사용 가능
        });
        btnAngelCard.setBounds(169, 603, 110, 23);
        contentPane.add(btnAngelCard);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(657, 110, 16, 323);
        contentPane.add(scrollPane);

        logArea = new JTextField();
        logArea.setBounds(486, 110, 187, 323);
        contentPane.add(logArea);
        logArea.setColumns(10);

        // 게임 로직 초기화
        steve = new Steve();
        monsters = new Player[] { new Zombie(), new Skeleton(), new Creeper() };
        Arrays.sort(monsters, (a, b) -> Integer.compare(a.getHp(), b.getHp()));  // HP 낮은 순으로 정렬
        weapons = new Weapon[] { new Sword(), new Bow(), new Bomb(), new Poison() };

        loadNextMonster();
        updateStatusLabels();
    }

    private void loadNextMonster() {
        if (monsterIndex < monsters.length) {
            currentMonster = monsters[monsterIndex++];
            lblMonsterName.setText(currentMonster.getName());
            lblMonsterHp.setText("HP: " + currentMonster.getHp());
            barMonsterHp.setMaximum(currentMonster.getHp());
            barMonsterHp.setValue(currentMonster.getHp());

            Weapon monsterWeapon = weapons[new Random().nextInt(weapons.length)];
            currentMonster.setWeapon(monsterWeapon);

            logArea.setText(logArea.getText() + "👾 " + currentMonster.getName() + " 등장! 무기: " + monsterWeapon.getName() + "\n");
        } else {
            logArea.setText(logArea.getText() + "🎉 모든 몬스터 처치 완료!\n");
            disableAllButtons();
        }
    }

    private void attackTurn() {
        if (isSteveTurn) {
            steve.attack(currentMonster);
            logArea.setText(logArea.getText() + "⚔ 스티브가 공격!\n");

            if (currentMonster.getHp() <= 0) {
                logArea.setText(logArea.getText() + currentMonster.getName() + " 격파!\n\n");
                loadNextMonster();
                updateStatusLabels();
                return;
            }
        } else {
            currentMonster.attack(steve);
            logArea.setText(logArea.getText() + currentMonster.getName() + "의 반격!\n");

            if (steve.getHp() <= 0) {
                logArea.setText(logArea.getText() + "💀 스티브 사망. 게임 오버\n");
                disableAllButtons();
            }
        }

        isSteveTurn = !isSteveTurn;  // 턴을 바꿈
        updateStatusLabels();
    }

    private void updateStatusLabels() {
        lblSteveHp.setText("HP: " + steve.getHp());
        lblMonsterHp.setText("HP: " + currentMonster.getHp());
        barSteveHp.setValue(steve.getHp());
        barMonsterHp.setValue(currentMonster.getHp());

        if (steve.getWeapon() != null)
            lblWeapon.setText("무기: " + steve.getWeapon().getName());
        else
            lblWeapon.setText("무기: 없음");
    }

    private void disableAllButtons() {
        btnSword.setEnabled(false);
        btnBow.setEnabled(false);
        btnBomb.setEnabled(false);
        btnPoison.setEnabled(false);
        btnSleep.setEnabled(false);
        btnAngelCard.setEnabled(false);
    }
}