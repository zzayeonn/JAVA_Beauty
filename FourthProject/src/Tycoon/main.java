package Tycoon;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

interface OpenDrink { //welcomedrink의 종류를 묶을 인터페이스 선언
	String drinkName();
}

interface OpenBase { //base의 종류를 묶을 인터페이스 선언
	String baseName();
}

interface OpenEye { //base의 종류를 묶을 인터페이스 선언
	String eyeName();
}

interface OpenEyebrow { //base의 종류를 묶을 인터페이스 선언
	String eyebrowName();
}

interface OpenLip { //base의 종류를 묶을 인터페이스 선언
	String lipName();
}

class Score {
	int fame; //명성
	int strength; //체력
	int money; //자금
	
	Score(){ //생성자를 사용해 명성, 체력, 자금을 초기화
		this.fame = 0;
		this.strength = 200;
		this.money = 200;
	}
	
	void fadd(int f){ //명성 추가
		this.fame += f;
	}
	
	void sadd(int s){ //체력 추가 
		this.strength += s;
	}
	
	void madd(int m){ //자금 추가
		this.money += m;
	}
	
	public int getFame() { //현재 명성값 리턴 
		return this.fame;
	}
	
	public int getStrength() { //현재 체력값 리턴 
		return this.strength;
	}
	
	public int getMoney() { //현재 자금값 리턴 
		return this.money;
	}
	
}

class Dinnertime {
	int crew; //홍보 직원 
	int newshop; //가맹점 
	int day; //영업일
	
	Dinnertime(){
		int crew = 0;
		int newshop = 0;
		int day = 0;
	}
	
	void cadd(int c){
		this.crew += c;
	}
	
	void nadd(int n){
		this.newshop += n;
	}
	
	void dadd(int d){
		this.day += d;
	}
	
	public int getCrew() {
		return this.crew;
	}
	
	public int getNewshop() {
		return this.newshop;
	}
	
	public int getDay() {
		return this.day;
	}
}

class DinnerThread extends Thread {
	public void run() {
		System.out.println("밤이 되어 취침에 들어갔습니다.\n");
		try {
			Thread.sleep(3000); //3s
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("아침이 되었습니다.");
	}
}

public class main {

	public static void main(String[] args) throws InterruptedException {
		Score score = new Score(); //Score 객체 생성
		
		Date date = new Date();
		
		StartSetting setting = new StartSetting();
		String bName = ""; //뷰티살롱 이름 불러옴
		
		boolean check = true;
		
		WelcomeDrink drink = new WelcomeDrink(); 
		int dnum = 0; //WelcomeDrink 클래스에서 리턴할 dnum을 불러옴
		int dfinish = 0; // open 메뉴 선택을 위한 dfinish 초기화 (선택지 1,2,3 || 2,3)
		
		Makeup makeup = new Makeup();
		int mnum = 0;
		int snum = 0;
		
		Dinnertime dinner = new Dinnertime();
		int lfinish = 0;

		Random random = new Random();
		
		//StratSetting 시작
		bName = setting.Setting(bName); //StratSetting 클래스 시작과 함꼐 bName을 리턴
		dinner.dadd(1); //day 값이 0으로 초기화 되어있어 영업 1일차이기 때문에 ++

		Thread.sleep(1000);
		System.out.println("-----------------------------------------게임 설명-----------------------------------------");
		System.out.println("  1. 뷰티살롱 키우기는 체력과 명성과 자금을 잘 배분하여 나만의 뷰티살롱을 운영하는 게임입니다.");
		System.out.println("  2. 고객은 점심시간 전에 3명, 영업 종료 전에 3명으로 하루에 총 6명의 고객이 방문합니다.");
		System.out.println("  3. 고객에게 Welcome 드링크를 주면 종류에 따라 체력이나 자금을 소비해 명성을 얻을 수 있습니다.");
		System.out.println("  4. 화장할 땐 사용하는 화장품에 따라 자금이 빠져나가며 그만큼 체력도 소비합니다.");
		System.out.println("  5. 체력을 아끼기 위해 고객을 내쫓을 수 있으나 명성이 떨어집니다.");
		System.out.println("  6. 영업 시작부터 3명의 손님을 맞이하면 점심시간이 주어지는데 자금을 소비해 체력을 올릴 음식 구매가 가능합니다.");
		System.out.println("  7. 점심시간이 지나고 영업이 종료된 후에 자금을 사용해서 홍보직원 또는 가맹점을 구매할 수 있습니다.");
		System.out.println("  8. 다음 날이 오기 전에 랜덤으로 숙면시간이 정해지며 이에 따라 체력이 오릅니다.");
		System.out.println("  9. 체력이 0, 명성이 -1, 자금이 0 중 한 개의 조건이 해당되면 Game Over입니다.");
		System.out.println("  10. 명성이나 자금이 요구치에 도달하면 당신은 부자가 되고 Game을 Clear할 수 있습니다.");
		System.out.println("-----------------------------------------------------------------------------------------\n");
		Thread.sleep(5000);
		
		if(dinner.getDay() == 1) {
			System.out.println(bName + " 뷰티살롱 영업 첫 날입니다.\n");
			Thread.sleep(1000);
		}
		
		//영업 시작
		while(true) {
			SimpleDateFormat time = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a h시 mm분 ss초\n");
			System.out.println("현재 시각 : " + time.format(date));
			Thread.sleep(1000);
			
			for(int x = 1; x <= 3; x++) { //아침시간에 손님 3명이 옴, 점심시간이 끝난 후 저녁시간에 손님 3명이 옴 
				for(int y = 0; y <= 4; y++) {
					if(check == false) { //고객에게 1.welcome 드링크 드리기를 끝낸 후 
						System.out.println("고객이 Welcome 드링크를 마시며 기다리고 있습니다.");
						System.out.println(" 2. 화장하기\n 3. 고객 내쫓기");
						y--; //y = 1이므로 원상복구
					}
					else { //고객이 오신 후 처음 시작 
						System.out.println("새로운 고객이 오셨습니다.");
						System.out.println(" 1. Welcome 드링크 드리기\n 2. 화장하기\n 3. 고객 내쫓기");
						
					}
					
					//WelcomeDrink 시작
					Scanner openMenu = new Scanner(System.in);
					int onum = openMenu.nextInt(); //선택지 초기화
					
					if(onum == 1) {
						if(dfinish == 0) {
								dnum = drink.drinkMenu(dnum); //WelcomDrink 클래스 불러오기, dnum 리턴
								if(dnum == 1) {
									score.sadd(-10); //체력 -10
									score.fadd(1); //명성 +1
								} else if(dnum == 2) {
									score.fadd(1); //명성 +1
									score.madd(-10); //자금 -10
								} else if(dnum == 3) {
									score.sadd(-20); //체력 -20
									score.fadd(2); //명성 +2
								} else if(dnum == 4) {
									score.fadd(2); //명성 +2
									score.madd(-20); //자금 -20
								}
								else if(dnum == 5) {
									y--; //전메뉴로 돌아가야하나 횟수 제한은 피하기 위해
									continue;
								}
								check = false; //선택지 2, 3으로 가기 위해 바꿔줌
								System.out.println("체력 : " + score.getStrength() + "\n명성 : " + score.getFame() + "\n자금 : " + score.getMoney() + "\n");
								Thread.sleep(2000);
						} else {
							if(y == 4) { 
								System.out.println("입력 횟수 제한(5) 초과로 프로그램을 종료합니다.");
								System.exit(0);
							}
							System.out.println("2, 3번 중에 다시 입력하세요.");
						}
					} 
					
					//Makeup 시작
					else if(onum == 2) {
						mnum = makeup.makeupMenu(mnum); //Makeup 클래스 불러오기, mnum 리턴
						snum = makeup.spendMakeup(snum); //화장품을 소비함에 따라 감소된 snum 리턴
						if(mnum >= 40 && mnum < 60) { //받는 비용에 따라 체력 감소 
							score.sadd(-10); //체력 -10
							System.out.println("수고한 당신의 체력이 -10 되었습니다.");
						} else if(mnum >= 60 && mnum < 80) {
							score.sadd(-15); //체력 -15
							System.out.println("매우 수고한 당신의 체력이 -15 되었습니다.");
						} else if(mnum >= 80 && mnum < 100 ) {
							score.sadd(-20); //체력 -20
							System.out.println("고생한 당신의 체력이 -20 되었습니다.");
						} else if(mnum >= 100 && mnum < 120) {
							score.sadd(-25); //체력 -25
							System.out.println("매우 고생한 당신의 체력이 -25 되었습니다.");
						} else if(mnum >= 120) {
							score.sadd(-30); //체력 -30
							score.fadd(1); //명성 +1
							System.out.println("노고가 많았던 당신의 체력이 -30 되었습니다.\n잘 어울리는 화장에 만족한 고객에 의해 명성이 +1 되었습니다.");
						}
						score.madd(snum); //체력 + snum 
						score.madd(mnum); //체력 + mnum 
						System.out.println("고객이 행복한 얼굴로 " + mnum + "을 지불하고 나갔습니다.\n");
						System.out.println("체력 : " + score.getStrength() + "\n명성 : " + score.getFame() + "\n자금 : " + score.getMoney() + "\n");
						Thread.sleep(2000);
						check = true;
						break;
					} 
					
					//고객 쫓아내기 시작
					else if(onum == 3) {
						System.out.println("고객의 방문을 거절했습니다.");
						score.sadd(10); //체력 +10
						score.fadd(-1); //명성 -1
						System.out.println("휴식을 취한 당신의 체력이 +10 되었습니다.\n방문 거절로 화가 난 고객에 의해 명성이 -1 되었습니다.\n");
						System.out.println("체력 : " + score.getStrength() + "\n명성 : " + score.getFame() + "\n자금 : " + score.getMoney() + "\n");
						Thread.sleep(2000);
						check = true;
						break;
					} else {
						if(y == 4) { // y = 0부터 4까지 5번의 기회
							System.out.println("입력 횟수 제한(5) 초과로 프로그램을 종료합니다.");
							System.exit(0);
						}
						System.out.println("1, 2, 3번 중에 다시 입력하세요.");
					}
				}
				
				//게임 오버 문구
				if(score.fame <= -1) { //게임 종료 조건
					System.out.println("당신의 명성이 모두 잊혀져 " + bName + " 뷰티살롱을 운영할 수 없습니다.");
					System.out.println("Game Over");
					System.exit(0);
				} else if(score.strength <= 0) {
					System.out.println("당신의 체력이 모두 달아 없어져 " + bName + " 뷰티살롱을 운영할 수 없습니다.");
					System.out.println("Game Over");
					System.exit(0);
				} else if(score.money <= 0) {
					System.out.println("당신의 자금이 모두 바닥나버려 " + bName + " 뷰티살롱을 운영할 수 없습니다.");
					System.out.println("Game Over");
					System.exit(0);
				} else {
					continue; //게임 종료 조건에 해당하지 않을 시 게임 그대로 진행
				}
			}
			
			//점심시간 시작
			if(lfinish == 0) {
				for(int i = 0; i <= 4; i ++) {
					System.out.println("즐거운 점심시간입니다.\n무엇을 드시겠습니까?");
					System.out.println(" 1. 컵라면(체력 + 10, 자금 - 10)\n 2. 참치김밥(체력 + 20, 자금 - 20)\n 3. 김치찌개(체력 + 30, 자금 - 30)\n 4. 갈비찜(체력 + 40, 자금 - 40)\n 5. 먹지 않는다.(체력 & 자금 변화 없음)");
					Scanner lunchtime = new Scanner(System.in);
					int ltnum = lunchtime.nextInt();
					
					if(ltnum == 1) {
						score.sadd(+10); //체력 +10
						score.madd(-10); //자금 -10
						System.out.println("컵라면 덕분에 당신의 체력이 +10 되었습니다.\n음식 때문에 자금이 -10 되었습니다.\n");
						System.out.println("체력 : " + score.getStrength() + "\n명성 : " + score.getFame() + "\n자금 : " + score.getMoney() + "\n");
						Thread.sleep(2000);
						break;
					} else if(ltnum == 2) {
						score.sadd(+20); //체력 +20
						score.madd(-20); //자금 -20
						System.out.println("참치김밥 덕분에 당신의 체력이 +20 되었습니다.\n맛있는 음식 때문에 자금이 -20 되었습니다.\n");
						System.out.println("체력 : " + score.getStrength() + "\n명성 : " + score.getFame() + "\n자금 : " + score.getMoney() + "\n");
						Thread.sleep(2000);
						break;
					} else if(ltnum == 3) {
						score.sadd(+30); //체력 +30
						score.madd(-30); //자금 -30
						System.out.println("김치찌개 덕분에 당신의 체력이 +10 되었습니다.\n훌륭한 음식 때문에 자금이 -10 되었습니다.\n");
						System.out.println("체력 : " + score.getStrength() + "\n명성 : " + score.getFame() + "\n자금 : " + score.getMoney() + "\n");
						Thread.sleep(2000);
						break;
					} else if(ltnum == 4) {
						score.sadd(+40); //체력 +40
						score.madd(-40); //자금 -40
						System.out.println("갈비찜 덕분에 당신의 체력이 +40 되었습니다.\n완벽한 음식 때문에 자금이 -40 되었습니다.\n");
						System.out.println("체력 : " + score.getStrength() + "\n명성 : " + score.getFame() + "\n자금 : " + score.getMoney() + "\n");;
						Thread.sleep(2000);
						break;
					} else if(ltnum == 5) {
						System.out.println("체력 : " + score.getStrength() + "\n명성 : " + score.getFame() + "\n자금 : " + score.getMoney() + "\n");
						Thread.sleep(2000);
						break;
					} else {
						if(i == 4) { 
							System.out.println("입력 횟수 제한(5) 초과로 프로그램을 종료합니다.");
							System.exit(0);
						}
						System.out.println("1, 2, 3, 4 ,5번 중에 다시 입력하세요.");
					}
		
				}
			}
			
			//저녁시간 시작
			if(lfinish == 1) {
				System.out.println("오늘은 영업이 끝났습니다.");
				dinner.dadd(1);
				
				//게임 클리어 문구
				if(score.getFame() >= 100) {
					System.out.println("당신의 " + bName + " 뷰티살롱이 이름을 날려 부자가 된 당신은 건물주가 되었습니다.");
					System.out.println("Congratulation!");
					System.exit(0);
				} else if(score.getMoney() >= 10000) {
					System.out.println("당신의 " + bName + " 뷰티살롱이 돈을 쓸어담아 부자가 된 당신은 건물주가 되었습니다.");
					System.out.println("Congratulation!");
					System.exit(0);
				} 
				
				for(int j = 0; j <= 4; j ++) {
					System.out.println(" 1. 홍보 직원(명성(매일) +10 자금(1번)  -1000)\n 2. 가맹점(자금(매일) +1000 자금(1번)  -5000)\n 3. 구매하지 않는다.(체력 & 명성 & 자금 변화 없음)");
					Scanner dinnertime = new Scanner(System.in);
					int dtnum = dinnertime.nextInt();
					int crewnum = 0;
					int newshopnum = 0;
					
					if(dtnum == 1) {
						if(score.getMoney() >= 1000) {
							score.madd(-1000); //자금 -1000
							System.out.println("내일부터 열정 넘치는 홍보 직원이 가열차게 명성을 올립니다.\n 홍보 직원을 구해 자금이 -1000 되었습니다.");
							System.out.println("체력 : " + score.getStrength() + "\n명성 : " + score.getFame() + "\n자금 : " + score.getMoney() + "\n"); 
							crewnum++;
							dinner.cadd(1);
							lfinish--; //lfinish = 0
							lfinish--; //lfinish = -1 로 뒤의 lfinish를 ++해 0으로 만들기 위해
							Thread.sleep(2000);
							break;
						} else {
							j--; //for문이 종료되는 것을 막기 위해
							System.out.println("자금이 부족합니다.\n전 메뉴로 돌아갑니다.\n");
							continue;
						}
					} else if(dtnum == 2) {
						if(score.getMoney() >= 5000) {
							score.madd(-5000); //자금 -5000
							System.out.println("내일부터 부지런한 가맹점이 어마하게 자금을 법니다.\n 가맹점을 구해 자금이 -5000 되었습니다.");
							System.out.println("체력 : " + score.getStrength() + "\n명성 : " + score.getFame() + "\n자금 : " + score.getMoney() + "\n");
							newshopnum++;
							dinner.nadd(1);
							lfinish--;
							lfinish--;
							Thread.sleep(2000);
							break;
						} else {
							j--;
							System.out.println("자금이 부족합니다.\n전 메뉴로 돌아갑니다.\n");
							continue;
						}
					} else if(dtnum == 3) {
						System.out.println("체력 : " + score.getStrength() + "\n명성 : " + score.getFame() + "\n자금 : " + score.getMoney() + "\n");
						lfinish--;
						lfinish--;
						Thread.sleep(2000);
						break;
					} else {
						if(j == 4) { 
							System.out.println("입력 횟수 제한(5) 초과로 프로그램을 종료합니다.");
							System.exit(0);
						}
						System.out.println("1, 2, 3번 중에 다시 입력하세요.");
					}
				}
				
				if(dinner.getCrew() > 0) {
					int crewfame = 0;
					crewfame = dinner.getCrew() * 10;
					score.fadd(crewfame);
					System.out.println("현재 홍보 직원은 " + dinner.getCrew() + "명이며 덕분에 명성이 +" + crewfame + " 올랐습니다.");
					System.out.println("체력 : " + score.getStrength() + "\n명성 : " + score.getFame() + "\n자금 : " + score.getMoney() + "\n");
					Thread.sleep(2000);
				} else if(dinner.getNewshop() > 0) {
					int shopmoney = 0;
					shopmoney = dinner.getNewshop() * 1000;
					score.madd(shopmoney);
					System.out.println("현재 가맹점은 " + dinner.getNewshop() + "명이며 덕분에 자금이 +" + shopmoney + " 올랐습니다.");
					System.out.println("체력 : " + score.getStrength() + "\n명성 : " + score.getFame() + "\n자금 : " + score.getMoney() + "\n");
					Thread.sleep(2000);
				} 
				
				//취침 시간 시작
				int rand = random.nextInt(4); //0, 1, 2, 3
				int rand5 = rand + 5; //5, 6, 7, 8
				int rands = (rand + 1) * 10; // 10, 20, 30, 40
				
				DinnerThread thread = new DinnerThread();
				thread.start();
				thread.join(); //쓰레드가 실행된 뒤 다음을 실행하도록 대기
				
				score.sadd(rands);
				System.out.println("지난 밤 당신은 " + rand5 + "시간동안 취침하여 체력이 +" + rands + " 되었습니다.\n" );
				System.out.println("체력 : " + score.getStrength() + "\n명성 : " + score.getFame() + "\n자금 : " + score.getMoney() + "\n");
				Thread.sleep(2000);
				System.out.println(bName + " 뷰티살롱 영업 " + dinner.getDay() + "일차입니다.\n");
				Thread.sleep(1000);
			}
			lfinish++; //점심시간이 지나면 1로 저녁시간이 지나면 0으로 만뜰어 줌 
		}
	}
}
