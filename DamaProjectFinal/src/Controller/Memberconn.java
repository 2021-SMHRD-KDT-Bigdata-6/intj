package Controller;

import Model.MemberVO;
import java.util.Scanner;

import Model.MemberVO;

public class Memberconn {
	DamaDAO damadao = new DamaDAO();

	Scanner sc = new Scanner(System.in);

	public void login() {       // 로그인 기능
		System.out.print("ID 입력 : ");
		String id = sc.next();
		System.out.print("Password 입력 : ");
		String pw = sc.next();
		
		MemberVO membervo = new MemberVO(id, pw);
		MemberVO info = damadao.login(membervo);
		
		if (info != null) {
			System.out.println(info.getId() + "님 환영합니다~!");
		} else {
			System.out.println("로그인 실패..");
		}

	}
	
	// 회원가입 기능
	public void join() {
		System.out.print("ID 입력 : ");
		String id = sc.next();
		System.out.print("Password 입력 : ");
		String pw = sc.next();
		MemberVO membervo = new MemberVO(id, pw);
		int cnt = damadao.join(membervo);
		
		if (cnt > 0) {
			System.out.println("회원가입 성공!");
		} else {
			System.out.println("회원가입 실패...");
		}
		
	}

	public void close() {
		System.out.println("게임을 종료합니다.");
		System.exit(0);
	}

}
