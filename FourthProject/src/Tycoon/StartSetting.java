package Tycoon;

import java.util.Scanner;

public class StartSetting {
	String bName; //main에서 사용하기 위한 뷰티살롱 이름 선언 
	
	String Setting(String bName) {
		System.out.println("뷰티살롱 키우기 게임을 시작하겠습니까?\n 1.예 2.아니오");
		Scanner startnum = new Scanner(System.in) ;
		int snum = startnum.nextInt();
		for(int i = 0; i <= 4; i++) {
			StartOutter : if(snum == 1) {
				System.out.println("안녕하세요. 플레이어의 이름을 입력해주세요.");
				StartSetting setting = new StartSetting();
				Scanner player = new Scanner(System.in) ;
				String pName = player.nextLine();
				System.out.println("<" + pName + ">님이 개업하려는 뷰티살롱의 이름을 입력해주세요.");
				Scanner beauty = new Scanner(System.in) ;
				bName = beauty.nextLine();
				for(int j = 0; j <= 4; j++) {
					System.out.println(pName + "님의 " + "<" +bName + ">뷰티살롱을 개업하시겠습니까?");
					System.out.println(" 1. 예 2. 아니요");
					Scanner truenum = new Scanner(System.in) ;
					int tnum = truenum.nextInt();
					if(tnum == 1) {
						System.out.println("축하합니다.\n" + pName + "원장님이 " + bName + " 뷰티살롱을 오픈했습니다!\n");
						break;
					} else if(tnum == 2) {
						System.out.println("처음부터 다시 입력해주세요.");
						break StartOutter; //StartOutter로 돌아감 
					} else {
						if(j == 4) {
							System.out.println("입력 횟수 제한(5) 초과로 프로그램을 종료합니다.");
							System.exit(0); //프로그램 종료
						}
						System.out.println("1, 2번 중에 다시 입력하세요.");
					}
					
				}
				break;
			} else {
				System.out.println("뷰티살롱 키우기 게임을 종료합니다.");
				System.exit(0);
			}
		}		
		return bName;
	}	

}