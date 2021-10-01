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

	public void register(String id) {
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
		System.out.println("��"+type+"��"+"�� ����ּ̾��!");
		int exp = 0;
		int energy = 0;
		int lv = 0;
		int day = 1;
		DamaVO damavo = new DamaVO(nick, type, exp, lv, energy, id, day);
		damadao.register(damavo);
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
	
	public void music() {    // �������
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
	public void study(int num1) {

		if (damavo.getNick() == "����") {
			if (num1 == 1) {
				damavo.setEnergy(damavo.getEnergy() - 20);
				damavo.setEnergy((int) (damavo.getEnergy() + 15 * 1.5));

			} else {
				damavo.setEnergy(damavo.getEnergy() - 20);
				damavo.setEnergy(damavo.getEnergy() + 15);
			}

		}
	}

	public void workout(int num2) {

		if (damavo.getNick() == "ȿ��") {
			if (num2 == 1) {

				damavo.setEnergy(damavo.getEnergy() - 35);
				damavo.setEnergy((int) (damavo.getEnergy() + 30 * 1.5));

			} else {
				damavo.setEnergy(damavo.getEnergy() - 35);
				damavo.setEnergy(damavo.getEnergy() + 30);
			}
		}

	}

	public void workout1(int num2) {

		if (damavo.getNick() == "����") {
			if (num2 == 3) {
				damavo.setEnergy(damavo.getEnergy() - 35);
				damavo.setEnergy((int) (damavo.getEnergy() + 30 * 1.5));

			} else {
				damavo.setEnergy(damavo.getEnergy() - 35);
				damavo.setEnergy(damavo.getEnergy() + 30);
			}
		}

	}

	public void eat(int num3) {

		if (damavo.getNick() == "�½�") {
			if (num3 == 2) {

				damavo.setEnergy(damavo.getEnergy() + 25);
				damavo.setEnergy((int) (damavo.getEnergy() + 5 * 1.5));

			} else {
				damavo.setEnergy(damavo.getEnergy() - 25);
				damavo.setEnergy(damavo.getEnergy() + 5);
			}
		}

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
	
	public void close() {
		System.out.println("������ �����մϴ�.");
		System.exit(0);
	}

}
