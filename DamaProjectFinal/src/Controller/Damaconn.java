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
		System.out.println("=== 닉네임을 설정해주세요 ===");
		System.out.print("별명 정하기 : ");
		String nick = sc.next();
		System.out.println(nick + "님 환영합니다! 슬기로운 취준생활을 시작해볼까요?");
		System.out.println("");
		System.out.println("=== 각각의 캐릭터에는 히든 보너스가 설정되어있습니다 ===");
		System.out.println("1.영웅 2.효주 3.명은 4.승신");
		System.out.print("종류 정하기 : ");
		int hidden = sc.nextInt();
		String type = null;
		if (hidden == 1) {
			type = "영웅";
		} else if (hidden == 2) {
			type = "효주";
		} else if (hidden == 3) {
			type = "명은";
		} else if (hidden == 4) {
			type = "승신";
		} else {
			System.out.println("다시 입력해주세요");
		}
		System.out.println("「"+type+"」"+"을 골라주셨어요!");
		int exp = 0;
		int energy = 0;
		int lv = 0;
		int day = 1;
		DamaVO damavo = new DamaVO(nick, type, exp, lv, energy, id, day);
		damadao.register(damavo);
	}
	

	public void goalsuc(DamaVO damavo) {
		if (damavo.getLv() == 10) {

			System.out.println("레벨이 10에 달성 하였습니다");
			System.out.println("모든 과정을 수료하고 취업에 성공했습니다!! 축하합니다!!!");
			System.exit(0);
		}
	}

	public void goalfail(int getEnergey) {
		if (damavo.getEnergy() <= 0) {
			System.out.println("-체력이 0이하로 떨어졌습니다-");
			System.out.println("취업도 좋지만 건강도 생각을 ㅠㅠ 다시시작하세요!");
			System.exit(0);
		}
	}

	public void sleep() {
		System.out.println("오늘도 수고했어요!!");
		System.out.println("-체력과 식사횟수가 충전됩니다.-");
	}
	
	public void music() {    // 음악재생
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

	// 보너스 에너지값 정의
	public void study(int num1) {

		if (damavo.getNick() == "영웅") {
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

		if (damavo.getNick() == "효주") {
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

		if (damavo.getNick() == "명은") {
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

		if (damavo.getNick() == "승신") {
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
		need.add("공부");
		need.add("운동");
		need.add("밥");
		System.out.println("====" + "!" + need.get(pick) + "!" + "이(가) 필요해요!" + "=====");

	}

	

	public void level(DamaVO damavo) {
		if (damavo.getExp() >= 100) {
			damavo.setLv(damavo.getLv() + 1);
			damavo.setExp(damavo.getExp() - 100);
			System.out.println("레벨 : " + damavo.getLv() + "달성!");
			System.out.println("축하합니다!! 레벨이 상승하였습니다.");
		}
	}
	
	public void close() {
		System.out.println("게임을 종료합니다.");
		System.exit(0);
	}

}
