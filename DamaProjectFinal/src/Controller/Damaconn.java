package Controller;

import java.util.ArrayList;
import java.util.Random;

import java.util.Random;
import java.util.Scanner;

import Model.DamaVO;
import Model.MemberVO;
import javazoom.jl.player.MP3Player;

public class Damaconn {

	DamaVO damavo = new DamaVO();
	DamaDAO damadao = new DamaDAO();
	MemberVO memvo = new MemberVO();
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();

<<<<<<< HEAD
	public DamaVO register(String id) {
=======
	public void register() {
>>>>>>> branch 'master' of https://github.com/2021-SMHRD-KDT-Bigdata-6/intj.git
		System.out.println("=== �г����� �������ּ��� ===");
		System.out.print("���� ���ϱ� : ");
		String nick = sc.next();
		System.out.println(nick + "�� ȯ���մϴ�! ����ο� ���ػ�Ȱ�� �����غ����?");
		System.out.println("");
		System.out.println("=== ������ ĳ���Ϳ��� ���� ���ʽ��� �����Ǿ��ֽ��ϴ� ===");
		System.out.println("1.���� 2.ȿ�� 3.���� 4.�½�");
		System.out.print("���� ���ϱ� : ");
		int hidden = sc.nextInt();
		String type = null;
		if (hidden == 1) {
			type = "����";
		} else if (hidden == 2) {
			type = "ȿ��";
		} else if (hidden == 3) {
			type = "����";
		} else if (hidden == 4) {
			type = "�½�";
		} else {
			System.out.println("�ٽ� �Է����ּ���");
		}
		System.out.println("��" + type + "��" + "�� ����ּ̾��!");
		int exp = 0;
		int energy = 0;
		int lv = 0;
		int day = 1;

		DamaVO damavo = new DamaVO(nick, type, exp, lv, energy, type, day);
		damadao.register(damavo);
		return damavo;
	}

	public void goalsuc(DamaVO damavo) {
		if (damavo.getLv() == 10) {

			System.out.println("������ 10�� �޼� �Ͽ����ϴ�");
			System.out.println("��� ������ �����ϰ� ����� �����߽��ϴ�!! �����մϴ�!!!");
			System.exit(0);
		}
	}

	public void goalfail(int getEnergey) {
		if (damavo.getEnergy() <= 0) {
			System.out.println("-ü���� 0���Ϸ� ���������ϴ�-");
			System.out.println("����� ������ �ǰ��� ������ �Ф� �ٽý����ϼ���!");
			System.exit(0);
		}
	}

	public void sleep() {
		System.out.println("���õ� �����߾��!!");
		System.out.println("-ü�°� �Ļ�Ƚ���� �����˴ϴ�.-");
	}

	public void music() { // �������
		MP3Player mp3 = new MP3Player();
		String path = getClass().getResource("").getPath();
		mp3.play(path + "Blossom.mp3");
		Thread th = new Thread();
		try {
			th.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mp3.stop();

	}

	// ���ʽ� �������� ����
	public void study(DamaVO damavo, int num2, String userid) {

		if (damavo.getType().equals("����")) {
			if (num2 == 1) {
				damavo.setEnergy(damavo.getEnergy() - 20);
<<<<<<< HEAD
				damavo.setExp((int) (damavo.getExp() + 15 * 1.5));
=======
				damavo.setEnergy((int) (damavo.getExp() + 15 * 1.5));
>>>>>>> branch 'master' of https://github.com/2021-SMHRD-KDT-Bigdata-6/intj.git

			} else {
				damavo.setEnergy(damavo.getEnergy() - 20);
<<<<<<< HEAD
				damavo.setExp(damavo.getExp() + 15);

=======
				damavo.setEnergy(damavo.getExp() + 15);
>>>>>>> branch 'master' of https://github.com/2021-SMHRD-KDT-Bigdata-6/intj.git
			}
			damadao.study(damavo, userid);

		}else {
			damavo.setEnergy(damavo.getEnergy() - 20);
			damavo.setExp(damavo.getExp() + 15);
			damadao.study(damavo, userid);
	}
		
	}
	public void workout(DamaVO damavo, int num2, String userid) {

		if (damavo.getType().equals("ȿ��")) {
			if (num2 == 1) {

				damavo.setEnergy(damavo.getEnergy() - 35);
				damavo.setEnergy((int) (damavo.getExp() + 30 * 1.5));

			} else {
				damavo.setEnergy(damavo.getEnergy() - 35);
				damavo.setEnergy(damavo.getExp() + 30);
			}
		} else if (damavo.getType().equals("����")) {
			if (num2 == 3) {
				damavo.setEnergy(damavo.getEnergy() - 35);
				damavo.setEnergy((int) (damavo.getExp() + 30 * 1.5));

			} else {
				damavo.setEnergy(damavo.getEnergy() - 35);
				damavo.setEnergy(damavo.getExp() + 30);
			}
			
		}else {
			damavo.setEnergy(damavo.getEnergy() - 35);
			damavo.setEnergy(damavo.getEnergy() + 30);
		}
		damadao.workout(damavo, userid);
	}

	public void eat(DamaVO damavo, int num3, String userid) {

		if (damavo.getNick() == "�½�") {
			if (num3 == 2) {

				damavo.setEnergy(damavo.getEnergy() + 25);
				damavo.setEnergy((int) (damavo.getExp() + 5 * 1.5));

			} else {
				damavo.setEnergy(damavo.getEnergy() - 25);
				damavo.setEnergy(damavo.getExp() + 5);
			}
		}else {
			damavo.setEnergy(damavo.getEnergy() - 25);
			damavo.setEnergy(damavo.getEnergy() + 5);
		}
		damadao.eatingUP(damavo, userid);
	}

	public void needs() {
		int pick = ran.nextInt(3);
		ArrayList<String> need = new ArrayList<String>();
		need.add("����");
		need.add("�");
		need.add("��");
		System.out.println("====" + "!" + need.get(pick) + "!" + "��(��) �ʿ��ؿ�!" + "=====");

	}

	public void level(DamaVO damavo) {
		if (damavo.getExp() >= 100) {
			damavo.setLv(damavo.getLv() + 1);
			damavo.setExp(damavo.getExp() - 100);
			System.out.println("���� : " + damavo.getLv() + "�޼�!");
			System.out.println("�����մϴ�!! ������ ����Ͽ����ϴ�.");
		}
	}

<<<<<<< HEAD
=======
	public void rankUp() {
		ArrayList<DamaVO> list = damadao.rankUp();
		for (int i = 0; i < 10; i++) {
			System.out.println(list.get(i));
		}

	}

>>>>>>> branch 'master' of https://github.com/2021-SMHRD-KDT-Bigdata-6/intj.git
	public void close() {
		System.out.println("������ �����մϴ�.");
		System.exit(0);
	}

}
