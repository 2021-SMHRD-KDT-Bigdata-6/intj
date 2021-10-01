package Controller;

import Model.MemberVO;
import java.util.Scanner;

import Model.MemberVO;

public class Memberconn {
	DamaDAO damadao = new DamaDAO();

	Scanner sc = new Scanner(System.in);
	Damaconn damaconn = new Damaconn();

	public void login() { // �α��� ���
		System.out.print("ID �Է� : ");
		String id = sc.next();
		System.out.print("Password �Է� : ");
		String pw = sc.next();

		MemberVO membervo = new MemberVO(id, pw);
		MemberVO info = damadao.login(membervo);

		if (info != null) {
			System.out.println(info.getId() + "�� ȯ���մϴ�~!");

		} else {
			System.out.println("�α��� ����.. �ٽ� �α��� ���ּ���!");
			System.out.print("ID �Է� : ");
			String id1 = sc.next();
			System.out.print("Password �Է� : ");
			String pw1 = sc.next();
			System.out.print("[1]�α��� [2]ȸ������ [3]���� >> ");
			int input = sc.nextInt();
			if (input == 1) {
				System.out.println("==========�α���==========");
				login();

			} else if (input == 2) {
				System.out.println("==========ȸ������==========");
				join();

			} else if (input == 3) {
				damaconn.close();

			}
		}
	}

	public void join() { // ȸ������ ���
		System.out.print("ID �Է� : ");
		String id = sc.next();
		System.out.print("Password �Է� : ");
		String pw = sc.next();
		MemberVO membervo = new MemberVO(id, pw);
		int cnt = damadao.join(membervo);

		if (cnt > 0) {
			System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�~!");
			System.out.print("[1]�α��� [2]ȸ������ [3]���� >> ");
			int input = sc.nextInt();
			if (input == 1) {
				System.out.println("==========�α���==========");
				login();

			} else if (input == 2) {
				System.out.println("==========ȸ������==========");
				join();

			} else if (input == 3) {
				damaconn.close();

			} else {
				System.out.println("ȸ������ ����...");
				System.out.print("ID �Է� : ");
				String id1 = sc.next();
				System.out.print("Password �Է� : ");
				String pw2 = sc.next();
				System.out.print("[1]�α��� [2]ȸ������ [3]���� >> ");
				int input1 = sc.nextInt();
				if (input1 == 1) {
					System.out.println("==========�α���==========");
					login();

				} else if (input1 == 2) {
					System.out.println("==========ȸ������==========");
					join();

				} else if (input1 == 3) {
					damaconn.close();

				}
			}
		}

	}

	public void close() {
		System.out.println("������ �����մϴ�.");
		System.exit(0);
	}

}
