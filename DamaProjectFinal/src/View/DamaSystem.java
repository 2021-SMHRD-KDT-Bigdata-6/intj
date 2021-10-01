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
			System.out.print("[1]로그인 [2]회원가입 [3]종료 >> ");
			int input = sc.nextInt();

			if (input == 1) {
				System.out.println("==========로그인==========");
				userid =member.login();


			} else if (input == 2) {
				System.out.println("===========회원가입==========");
				member.join();
				System.out.println("회원가입이 완료되었습니다~!");

			} else if (input == 3) {
				damaconn.close();

			} else {
				System.out.println("숫자를 다시 입력해주세요.");
			}

			while (true) {
				System.out.print("[1]다마고치 등록 [2]다마고치 키우기 [3]다마고치 상태확인 [4]랭킹확인 [5]종료 >> ");
				int select = sc.nextInt();

				if (select == 1) {
					damaconn.register(userid);

					
					break;
				} else if (select == 2) {

					System.out.println("=== 부지런한 생활로 꼭 취준에 성공하자! ===");
					System.out.println("=== 무엇부터 시작해 볼까요? === ");
					break;
				} else if (select == 3) {

					System.out.println(); // 다마고치 상세 페이지 표시
					System.out.println("님의 현재 상태입니다. ");
					System.out.println("경험치   레벨   에너지   날짜 "); // 각각의 데이터 받아서 출력

				} else if (select == 4) {

					System.out.println("님의 현재 순위입니다."); // 랭킹 페이지 표시
					System.out.print("별명    점수    순위"); // 닉값, 랭킹 값 받아와서 출

				} else if (select == 5) {
					damaconn.close();
				} // 종료
			}
			// 다시 메뉴 화면으로 복귀

			while (true) {

				System.out.println("귀여운 다마고치 키우기!");
				while (true) {
					int ne = ran.nextInt(5);
					if (day != deforeday) {
						System.out.println(day + "일째!!");
						deforeday++;
					}
					if (ne == 3) {
						damaconn.needs();
					} else {
						System.out.println("뭘 해볼까요??");
					}

					while (true) {

						System.out.print("[1] 공부하기 [2] 운동하기 [3] 밥먹기 [4] 잠자기 [5] 종료하기 >> ");
						int num = sc.nextInt();

						if (num == 1) {
							System.out.println("공부를 시작해봅시다!!");
							System.out.print("[1] 운비쌤과 함께 하는 JAVA! [2] 동원쌤과 함께하는 DB! [3] 미리 공부하는 WEB! >> ");
							int num2 = sc.nextInt();
							if (num2 == 1) {
								System.out.println("운비쌤과 JAVA공부를 했어요!");
							} else if (num2 == 2) {
								System.out.println("동원쌤과 DB공부를 했어요!");
							} else if (num2 == 3) {
								System.out.println("미리 WEB을 예습했어요!");
							}

//               damaconn.goalsuc(damavo.getLv());
//               damaconn.goalfail(damavo.getEnergy());

						} else if (num == 2) {
							System.out.println("열심히 운동을 합시다!");
							System.out.print("[1] 춤추기 [2] 헬스 [3] 수영 >> ");
							int num2 = sc.nextInt();
							if (num2 == 1) {
								System.out.println("열심히 흔들었어요~~~ ");
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
								System.out.println("헬스 후 프로틴은 빼먹지 말아요");
							} else if (num2 == 3) {
								System.out.println("열심히 수영을 했어요");
							}
//               damaconn.goalsuc(damavo.getLv());
//               damaconn.goalfail(damavo.getEnergy());
						} else if (num == 3) {
							System.out.println("오늘은 뭘 먹을 까요??");
							System.out.print("[1] 한솥 [2] 버거킹 [3] 해성식당 >> ");
							int num2 = sc.nextInt();

							if (count >= 3) {
								System.out.println("-더 이상 먹을 수 없습니다.-");
								System.out.println("더 먹게??...");
							} else {

								if (num2 == 1) {
									System.out.println("한솥 치킨마요가 진리 ");
								} else if (num2 == 2) {
									System.out.println("버거킹은 콰트로치즈 와퍼죠");
								} else if (num2 == 3) {
									System.out.println("해성식당 제육볶음이 졸맛");
								}
//                  damaconn.eating(num2);
//                  damadao.eatingUP(damavo);
//                  damaconn.goalsuc(damavo.getLv());
//               damaconn.goalfail(damavo.getEnergy());
								if (count == 0) {
									System.out.println("아침식사 해결!");
									count++;

								} else if (count == 1) {
									System.out.println("점심 해결!");
									count++;

								} else if (count == 2) {
									System.out.println("저녁식사 해결!");
									count++;

								} else {
									System.out.println("번호를 잘못 입력하였습니다.");
									break;
								}

							}
						} else if (num == 4) {
							damaconn.sleep();
							day++;
							count = 0;

							// damadao.sleepUP(damavo);

						} else if (num == 5) {
							System.out.print("정말로 종료하실 건가요? Y/N >> ");
							String pick = sc.next();
							if (pick.equals("Y")) {
								damaconn.close();

							} else if (pick.equals("N")) {
								System.out.println("다시 시작해 봐요!!");
							}

						}
					}
				}
			}
		}

	}
}