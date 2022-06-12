package Tycoon;

import java.util.Scanner;

public class WelcomeDrink extends Score {	
	int dnum; //main에서도 사용할 dnum 선언
	
	int drinkMenu(int dnum) {
		for(int x = 0; x <= 4; x++) {
			System.out.println("어떤 음료를 드릴까요?");
			System.out.println(" 1. 아메리카노(HOT)(체력 - 10, 명성 +1)\n 2. 아메리카노(ICE)(자금 - 10, 명성 +1)\n 3. 아이스티(LEMON)(체력 - 20, 명성 +2)\n 4. 보성녹차(HOT)(자금 - 20, 명성 +2)\n 5. 전 메뉴로 돌아가기");
			Scanner drinknum = new Scanner(System.in);
			dnum = drinknum.nextInt(); 
			Drinkkind dkind = new Drinkkind();
			if(dnum == 1) {
				HotCoffee done = new HotCoffee();
				dkind.drinkFinish(done); //인터페이스 구현을 통해 지정한 welcomedrink를 drinkFinish 메소드에 넣음
				System.out.println("음료를 제조하느라 당신의 체력이 -10 되었습니다.\n환영에 기쁜 고객에 의해 명성이 +1 되었습니다.\n");
				break;
			} else if(dnum == 2) {
				IceCoffee dtwo = new IceCoffee();
				dkind.drinkFinish(dtwo);
				System.out.println("음료를 제조하느라 당신의 자금이 -10 되었습니다.\n환영에 기쁜 고객에 의해 명성이 +1 되었습니다.\n");
				break;
			} else if(dnum == 3) {
				IceTea dthree = new IceTea();
				dkind.drinkFinish(dthree);
				System.out.println("음료를 뼈 빠지게 제조하느라 당신의 체력이 -20 되었습니다.\n정성스런 환대에 감동 받은 고객에 의해 명성이 +2 되었습니다.\n");
				break;
			} else if(dnum == 4) {
				GreenTea dfour = new GreenTea();
				dkind.drinkFinish(dfour);
				System.out.println("음료를 뼈 빠지게 제조하느라 당신의 자금이 -20 되었습니다.\n정성스런 환대에 감동 받은 고객에 의해 명성이 +2 되었습니다.\n");
				break;
			} else if(dnum == 5) {
				break; //main으로 돌아가 전 메뉴 소환
			} else {
				if(x == 4) {
					System.out.println("입력 횟수 제한(5) 초과로 프로그램을 종료합니다.");
					System.exit(0);
				}
				System.out.println("1, 2, 3, 4, 5번 중에 다시 입력하세요.");
			}
		}
		return dnum; //main에서 사용하기 위해 dnum을 리턴
	}
}

class HotCoffee implements OpenDrink{ //인터페이스 구현
	public String drinkName() {
		return "아메리카노(HOT)"; //welcomedrink의 종류 중 하나로 리턴값 설정
	}
}

class IceCoffee implements OpenDrink{
	public String drinkName() {
		return "아메리카노(ICE)";
	}
}

class IceTea implements OpenDrink{
	public String drinkName() {
		return "아이스티(LEMON)";
	}
}
class GreenTea implements OpenDrink{
	public String drinkName() {
		return "녹차(HOT)";
	}
}


class Drinkkind extends WelcomeDrink {
	void drinkFinish(OpenDrink odrink) {
		System.out.println("고객께 " + odrink.drinkName() + "를 드렸습니다.\n"); 
		//OpenDrink 인터페이스를 구현한 구현체(HotCoffee, IceCoffee...)들의 drinkFinish 메소도 호출 
	}
}

/*//생성자 이용
public class WelcomeDrink extends OpenMenu {
	String drinkname;
	
	void setName(String drinkname) {
		this.drinkname = drinkname;
	}
	
	void giveDrink(String drinkname) {
		System.out.println("고객께 " + drinkname + "를 드렸습니다.\n");
	}
	
	void drinkMenu() {
		for(int x = 0; x <= 4; x++) {
			System.out.println("어떤 음료를 드릴까요?");
			System.out.println(" 1. 아메리카노(HOT) 2. 아메리카노(ICE) 3. 녹차(HOT) 4. 아이스티(LEMON) 5. 전 메뉴로 돌아가기");
			Scanner drinknum = new Scanner(System.in);
			int dnum = drinknum.nextInt(); 
			if(dnum == 1) {
				Drinkkind hotcoffee = new Drinkkind(1);
				giveDrink(hotcoffee.drinkname);
				break;
			} else if(dnum == 2) {
				Drinkkind icecoffee = new Drinkkind(2);
				giveDrink(icecoffee.drinkname);
				break;
			} else if(dnum == 3) {
				Drinkkind greentea = new Drinkkind(3);
				giveDrink(greentea.drinkname);
				break;
			} else if(dnum == 4) {
				Drinkkind icetea = new Drinkkind(4);
				giveDrink(icetea.drinkname);
				break;
			} else if(dnum == 5) {
				StartOpen dfive = new StartOpen();
				dfive.Ostart();
				break;
			}
			else {
				if(x == 4) {
					System.out.println("입력 횟수 제한(5) 초과로 프로그램을 종료합니다.");
					System.exit(0);
				System.out.println("1, 2, 3, 4, 5번 중에 다시 입력하세요.");
				}
			}
		}
		fame += 1;
		strength -= 10;
		System.out.println("만족한 고객에 의해 명성이 +1 되었습니다.\n음료를 제조하느라 당신의 체력이 -10 되었습니다.\n");
		System.out.println("체력 : " + strength + "\n명성 : " + fame + "\n자금 : " + money + "\n");
		StartOpen ostart = new StartOpen();
		ostart.Ostart();
	}
}

class Drinkkind extends WelcomeDrink {
	Drinkkind(int type){
		if (type == 1) {
			this.setName("아메리카노(HOT)");
		} else if(type == 2) {
			this.setName("아메리카노(ICE)");
		} else if(type == 3) {
			this.setName("녹차(HOT)");
		} else if(type == 4) {
			this.setName("아이스티(LEMON)");
		} else if(type == 5) {
			this.setName("아메리카노(ICE)");
		}
	}


}*/
