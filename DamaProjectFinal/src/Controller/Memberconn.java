package Controller;

import Model.MemberVO;
import java.util.Scanner;

import Model.MemberVO;

public class Memberconn {
	DamaDAO damadao = new DamaDAO();

	Scanner sc = new Scanner(System.in);

	public String login() {       // �α��� ���
		System.out.print("ID �Է� : ");
		String id = sc.next();
		System.out.print("Password �Է� : ");
		String pw = sc.next();
		
		MemberVO membervo = new MemberVO(id, pw);
		MemberVO info = damadao.login(membervo);
		
		if (info != null) {
			System.out.println(info.getId() + "�� ȯ���մϴ�~!");
			return info.getId();
		} else {
			System.out.println("�α��� ����..");
			return null;
		}

	}
	
	// ȸ������ ���
	public void join() {
		System.out.print("ID �Է� : ");
		String id = sc.next();
		System.out.print("Password �Է� : ");
		String pw = sc.next();
		MemberVO membervo = new MemberVO(id, pw);
		int cnt = damadao.join(membervo);
		
		if (cnt > 0) {
			System.out.println("ȸ������ ����!");
		} else {
			System.out.println("ȸ������ ����...");
		}
		
	}

	public void close() {
		System.out.println("������ �����մϴ�.");
		System.exit(0);
	}

}
