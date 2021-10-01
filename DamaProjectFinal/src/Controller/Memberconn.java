package Controller;

import Model.MemberVO;
import java.util.Scanner;

import Model.MemberVO;

public class Memberconn {
	DamaDAO damadao = new DamaDAO();

	Scanner sc = new Scanner(System.in);
	Damaconn damaconn = new Damaconn();

	public void login() { // 로그인 기능
		System.out.print("ID 입력 : ");
		String id = sc.next();
		System.out.print("Password 입력 : ");
		String pw = sc.next();

		MemberVO membervo = new MemberVO(id, pw);
		MemberVO info = damadao.login(membervo);

		if (info != null) {
			System.out.println(info.getId() + "님 환영합니다~!");

		} else {
			System.out.println("로그인 실패.. 다시 로그인 해주세요!");
			System.out.print("ID 입력 : ");
			String id1 = sc.next();
			System.out.print("Password 입력 : ");
			String pw1 = sc.next();
			System.out.print("[1]로그인 [2]회원가입 [3]종료 >> ");
			int input = sc.nextInt();
			if (input == 1) {
				System.out.println("==========로그인==========");
				login();

			} else if (input == 2) {
				System.out.println("==========회원가입==========");
				join();

			} else if (input == 3) {
				damaconn.close();

			}
		}
	}

	public void join() { // 회원가입 기능
		System.out.print("ID 입력 : ");
		String id = sc.next();
		System.out.print("Password 입력 : ");
		String pw = sc.next();
		MemberVO membervo = new MemberVO(id, pw);
		int cnt = damadao.join(membervo);

		if (cnt > 0) {
			System.out.println("회원가입이 완료되었습니다~!");
			System.out.print("[1]로그인 [2]회원가입 [3]종료 >> ");
			int input = sc.nextInt();
			if (input == 1) {
				System.out.println("==========로그인==========");
				login();

			} else if (input == 2) {
				System.out.println("==========회원가입==========");
				join();

			} else if (input == 3) {
				damaconn.close();

			} else {
				System.out.println("회원가입 실패...");
				System.out.print("ID 입력 : ");
				String id1 = sc.next();
				System.out.print("Password 입력 : ");
				String pw2 = sc.next();
				System.out.print("[1]로그인 [2]회원가입 [3]종료 >> ");
				int input1 = sc.nextInt();
				if (input1 == 1) {
					System.out.println("==========로그인==========");
					login();

				} else if (input1 == 2) {
					System.out.println("==========회원가입==========");
					join();

				} else if (input1 == 3) {
					damaconn.close();

				}
			}
		}

	}

	public void close() {
		System.out.println("게임을 종료합니다.");
		System.exit(0);
	}

}
