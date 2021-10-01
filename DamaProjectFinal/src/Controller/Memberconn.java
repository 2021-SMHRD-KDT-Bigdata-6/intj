package Controller;

import Model.MemberVO;
import java.util.Scanner;

import Model.MemberVO;

public class Memberconn {
	DamaDAO damadao = new DamaDAO();

	Scanner sc = new Scanner(System.in);

	public void login() {       // �α��� ���
		System.out.println("==========�α���==========");
		System.out.print("ID �Է� : ");
		String id = sc.next();
		System.out.print("Password �Է� : ");
		String pw = sc.next();
		
		MemberVO membervo = new MemberVO(id, pw);
		MemberVO info = damadao.login(membervo);
		
		if (info != null) {
			System.out.println(info.getId() + "�� ȯ���մϴ�~!");
		} else {
			System.out.println("�α��� ����..");
		}

	}
	
	
	public void join() {    // ȸ������ ���
		System.out.println("===========ȸ������==========");
		System.out.print("ID �Է� : ");
		String id = sc.next();
		System.out.print("Password �Է� : ");
		String pw = sc.next();
		MemberVO membervo = new MemberVO(id, pw);
		int cnt = damadao.join(membervo);
		
		if (cnt > 0) {
			System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�~!");
		} else {
			System.out.println("ȸ������ ����...");
			System.out.print("ID �Է� : ");
			String id1 = sc.next();
			System.out.print("Password �Է� : ");
			String pw2 = sc.next();
		}
		
		
	}

	public void close() {
		System.out.println("������ �����մϴ�.");
		System.exit(0);
	}

}
