package View;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Controller.DamaDAO;
import Controller.Damaconn;
import Controller.Memberconn;
import Model.DamaVO;
import Model.MemberVO;
import javazoom.jl.player.MP3Player;

public class DamaSystem {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		Damaconn damaconn = new Damaconn();
		DamaDAO damadao = new DamaDAO();
		DamaVO damavo = new DamaVO();
		Memberconn member = new Memberconn();

		int deforeday = 0;
		int count = 0;
		int day = 1;
		String userid = "";

		while (true) {
			System.out.print("[1]�α��� [2]ȸ������ [3]���� >> ");
			int input = sc.nextInt();

			if (input == 1) {
				System.out.println("==========�α���==========");
				userid =member.login();


			} else if (input == 2) {
				System.out.println("===========ȸ������==========");
				member.join();
				System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�~!");

			} else if (input == 3) {
				damaconn.close();

			} else {
				System.out.println("���ڸ� �ٽ� �Է����ּ���.");
			}

			while (true) {
				System.out.print("[1]�ٸ���ġ ��� [2]�ٸ���ġ Ű��� [3]�ٸ���ġ ����Ȯ�� [4]��ŷȮ�� [5]���� >> ");
				int select = sc.nextInt();

				if (select == 1) {
					damaconn.register(userid);

					
					break;
				} else if (select == 2) {

					System.out.println("=== �������� ��Ȱ�� �� ���ؿ� ��������! ===");
					System.out.println("=== �������� ������ �����? === ");
					break;
				} else if (select == 3) {

					System.out.println(); // �ٸ���ġ �� ������ ǥ��
					System.out.println("���� ���� �����Դϴ�. ");
					System.out.println("����ġ   ����   ������   ��¥ "); // ������ ������ �޾Ƽ� ���

				} else if (select == 4) {

					System.out.println("���� ���� �����Դϴ�."); // ��ŷ ������ ǥ��
					System.out.print("����    ����    ����"); // �а�, ��ŷ �� �޾ƿͼ� ��

				} else if (select == 5) {
					damaconn.close();
				} // ����
			}
			// �ٽ� �޴� ȭ������ ����

			while (true) {

				System.out.println("�Ϳ��� �ٸ���ġ Ű���!");
				while (true) {
					int ne = ran.nextInt(5);
					if (day != deforeday) {
						System.out.println(day + "��°!!");
						deforeday++;
					}
					if (ne == 3) {
						damaconn.needs();
					} else {
						System.out.println("�� �غ����??");
					}

					while (true) {

						System.out.print("[1] �����ϱ� [2] ��ϱ� [3] ��Ա� [4] ���ڱ� [5] �����ϱ� >> ");
						int num = sc.nextInt();

						if (num == 1) {
							System.out.println("���θ� �����غ��ô�!!");
							System.out.print("[1] ���ܰ� �Բ� �ϴ� JAVA! [2] �����ܰ� �Բ��ϴ� DB! [3] �̸� �����ϴ� WEB! >> ");
							int num2 = sc.nextInt();
							if (num2 == 1) {
								System.out.println("���ܰ� JAVA���θ� �߾��!");
							} else if (num2 == 2) {
								System.out.println("�����ܰ� DB���θ� �߾��!");
							} else if (num2 == 3) {
								System.out.println("�̸� WEB�� �����߾��!");
							}

//               damaconn.goalsuc(damavo.getLv());
//               damaconn.goalfail(damavo.getEnergy());

						} else if (num == 2) {
							System.out.println("������ ��� �սô�!");
							System.out.print("[1] ���߱� [2] �ｺ [3] ���� >> ");
							int num2 = sc.nextInt();
							if (num2 == 1) {
								System.out.println("������ �������~~~ ");
								damaconn.music();

//                        MP3Player mp3 = new MP3Player();
//                        String path = damaconn.getClass().getResource("").getPath();
//                        mp3.play(path + "Blossom.mp3");
//                        Thread th = new Thread();
//                        try {
//                           th.sleep(5000);
//                        } catch (InterruptedException e) {
//                           e.printStackTrace();
//                        }
//                        mp3.stop();
							} else if (num2 == 2) {
								System.out.println("�ｺ �� ����ƾ�� ������ ���ƿ�");
							} else if (num2 == 3) {
								System.out.println("������ ������ �߾��");
							}
//               damaconn.goalsuc(damavo.getLv());
//               damaconn.goalfail(damavo.getEnergy());
						} else if (num == 3) {
							System.out.println("������ �� ���� ���??");
							System.out.print("[1] �Ѽ� [2] ����ŷ [3] �ؼ��Ĵ� >> ");
							int num2 = sc.nextInt();

							if (count >= 3) {
								System.out.println("-�� �̻� ���� �� �����ϴ�.-");
								System.out.println("�� �԰�??...");
							} else {

								if (num2 == 1) {
									System.out.println("�Ѽ� ġŲ���䰡 ���� ");
								} else if (num2 == 2) {
									System.out.println("����ŷ�� ��Ʈ��ġ�� ������");
								} else if (num2 == 3) {
									System.out.println("�ؼ��Ĵ� ���������� ����");
								}
//                  damaconn.eating(num2);
//                  damadao.eatingUP(damavo);
//                  damaconn.goalsuc(damavo.getLv());
//               damaconn.goalfail(damavo.getEnergy());
								if (count == 0) {
									System.out.println("��ħ�Ļ� �ذ�!");
									count++;

								} else if (count == 1) {
									System.out.println("���� �ذ�!");
									count++;

								} else if (count == 2) {
									System.out.println("����Ļ� �ذ�!");
									count++;

								} else {
									System.out.println("��ȣ�� �߸� �Է��Ͽ����ϴ�.");
									break;
								}

							}
						} else if (num == 4) {
							damaconn.sleep();
							day++;
							count = 0;

							// damadao.sleepUP(damavo);

						} else if (num == 5) {
							System.out.print("������ �����Ͻ� �ǰ���? Y/N >> ");
							String pick = sc.next();
							if (pick.equals("Y")) {
								damaconn.close();

							} else if (pick.equals("N")) {
								System.out.println("�ٽ� ������ ����!!");
							}

						}
					}
				}
			}
		}

	}
}