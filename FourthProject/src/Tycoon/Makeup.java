package Tycoon;

import java.util.Scanner;

public class Makeup extends Score {
	int mnum; //main에서 사용할 화장 받은 고객이 지불하고 간 비용 
	int snum; //main에서 사용할 화장품을 소비하는 데에 든 비용 
	int sum; //makeupMenu에 초기화하고 spendMakeup 메소드에서 사용할 화장품을 소비하는 데에 든 비용 
	
	int makeupMenu(int mnum) {
		int a= 0; //베이스의 종류에 따라 다른 비용 초기화
		int b= 0; //아이섀도우의 종류에 따라 다른 비용 초기화
		int c= 0; //아이브로우의 종류에 따라 다른 비용 초기화
		int d= 0; //립의 종류에 따라 다른 비용 초기화
		int base = 0; //베이스 선택지 초기화
		int eye = 0; //베이스 선택지 초기화
		int eyebrow = 0; //베이스 선택지 초기화
		int lip = 0; //베이스 선택지 초기화
		
		System.out.println("화장을 시작합니다.");
		System.out.println("화장 순서 1. 베이스(Base Makeup) 2. 눈(Eye Makeup) 3. 눈썹(Eyebrow Makeup) 4. 립(Lip Makeup)");
		
		for(int x = 0; x <= 4; x++) {
			System.out.println("첫번째로 베이스 메이크업을 시작합니다.\n원하는 파운데이션을 선택하세요.");
			System.out.println(" 1. 클리오 킬커버 파운데이션(자금 - 10)\n 2. 라네즈 네오 파운데이션(자금 - 15)\n 3. 헤라 블랙 파운데이션(자금 - 20)\n");
			Scanner makeupnum1 = new Scanner(System.in);
			base = makeupnum1.nextInt(); 
			Basekind bkind = new Basekind();
			if(base == 1) {
				Clio mone = new Clio();
				bkind.baseFinish(mone);
				a = -10;
				System.out.println(" 자금이 " + a + " 되었습니다.\n");
				break;
			} else if(base == 2) {
				Laneige mtwo = new Laneige();
				bkind.baseFinish(mtwo);
				a = -15;
				System.out.println(" 자금이 " + a + " 되었습니다.\n");
				break;
			} else if(base == 3) {
				Hera mthree = new Hera();
				bkind.baseFinish(mthree);
				a = -20;
				System.out.println(" 자금이 " + a + " 되었습니다.\n");
				break;
			} else {
				if(x == 4) {
					System.out.println("입력 횟수 제한(5) 초과로 프로그램을 종료합니다.");
					System.exit(0);
				System.out.println("1, 2, 3번 중에 다시 입력하세요.");
				}
			}
		}
		
		for(int y = 0; y <= 4; y++) {
			System.out.println("두번째로 아이 메이크업을 시작합니다.\n원하는 아이섀도우를 선택하세요.");
			System.out.println(" 1. 에뛰드 인더카페 아이섀도우(자금 - 10)\n 2. 어반디케이 네이키드 아이섀도우(자금 - 15)\n 3. 샤넬 레 베쥬 아이섀도우(자금 - 20)\n");
			Scanner makeupnum2 = new Scanner(System.in);
			eye = makeupnum2.nextInt(); 
			Eyekind ekind = new Eyekind();
			if(eye == 1) {
				Etude mone = new Etude();
				ekind.eyeFinish(mone);
				b = -10;
				System.out.println(" 자금이 " + b + " 되었습니다.\n");
				break;
			} else if(eye == 2) {
				Urbandecay mtwo = new Urbandecay();
				ekind.eyeFinish(mtwo);
				b = -15;
				System.out.println(" 자금이 " + b + " 되었습니다.\n");
				break;
			} else if(eye == 3) {
				Chanel mthree = new Chanel();
				ekind.eyeFinish(mthree);
				b = -20;
				System.out.println(" 자금이 " + b + " 되었습니다.\n");
				break;
			} else {
				if(y == 4) {
					System.out.println("입력 횟수 제한(5) 초과로 프로그램을 종료합니다.");
					System.exit(0);
				System.out.println("1, 2, 3번 중에 다시 입력하세요.");
				}
			}
		}
		
		for(int z = 0; z <= 4; z++) {
			System.out.println("세번째로 아이브로우 메이크업을 시작합니다.\n원하는 아이브로우를 선택하세요.");
			System.out.println(" 1. 이니스프리 납작 아이브로우(자금 - 10)\n 2. 슈에무라 하드포뮬라 아이브로우(자금 - 15)\n 3. 베네피트 프리사이슬리 아이브로우(자금 - 20)");
			Scanner makeupnum3 = new Scanner(System.in);
			eyebrow = makeupnum3.nextInt(); 
			Eyebrowkind ebkind = new Eyebrowkind();
			if(eyebrow == 1) {
				Innisfree mone = new Innisfree();
				ebkind.eyebrowFinish(mone);
				c = -10;
				System.out.println(" 자금이 " + c + " 되었습니다.\n");
				break;
			} else if(eyebrow == 2) {
				Shuuemura mtwo = new Shuuemura();
				ebkind.eyebrowFinish(mtwo);
				c = -15;
				System.out.println(" 자금이 " + c + " 되었습니다.\n");
				break;
			} else if(eyebrow == 3) {
				Benefit mthree = new Benefit();
				ebkind.eyebrowFinish(mthree);
				c = -20;
				System.out.println(" 자금이 " + c + " 되었습니다.\n");
				break;
			} else {
				if(z == 4) {
					System.out.println("입력 횟수 제한(5) 초과로 프로그램을 종료합니다.");
					System.exit(0);
				System.out.println("1, 2, 3번 중에 다시 입력하세요.");
				}
			}
		}
		
		for(int t = 0; t <= 4; t++) {
			System.out.println("네번째로 립 메이크업을 시작합니다.\n원하는 립스틱을 선택하세요.");
			System.out.println(" 1. 에스쁘아 노웨어 립스틱(자금 - 10)\n 2. 맥 파우더 키스 립스틱(자금 - 15)\n 3. 입생로랑 루쥬 볼립떼 립스틱(자금 - 20)");
			Scanner makeupnum4 = new Scanner(System.in);
			lip = makeupnum4.nextInt(); 
			Lipkind lkind = new Lipkind();
			if(lip == 1) {
				Espoir mone = new Espoir();
				lkind.lipFinish(mone);
				d = -10;
				System.out.println(" 자금이 " + d + " 되었습니다.\n");
				break;
			} else if(lip == 2) {
				Mac mtwo = new Mac();
				lkind.lipFinish(mtwo);
				d = -15;
				System.out.println(" 자금이 " + d + " 되었습니다.\n");
				break;
			} else if(lip == 3) {
				Yvessaintlaurent mthree = new Yvessaintlaurent();
				lkind.lipFinish(mthree);
				d = -20;
				System.out.println(" 자금이 " + d + " 되었습니다.\n");
				break;
			} else {
				if(t == 4) {
					System.out.println("입력 횟수 제한(5) 초과로 프로그램을 종료합니다.");
					System.exit(0);
				System.out.println("1, 2, 3번 중에 다시 입력하세요.");
				}
			}
		}
		sum = +(a+b+c+d);
		System.out.println("화장하기 위해 사용한 화장품의 총 비용은 " + sum + " 입니다.");
		mnum = (base * 10) + (eye * 10) + (eyebrow * 10) + (lip * 10); //사용한 화장품에 따라 다르게 적용되는 고객 지불 비용 
		return mnum;
	}
	
	int spendMakeup (int snum) { //main에서 소비한 화장품의 비용을 사용하기 위해 메소드를 만들어 snum 리턴
		snum = 0;
		snum += sum;
		return snum;
	}
}



class Clio implements OpenBase {
	public String baseName() {
		return "클리오 킬커버 파운데이션";
	}
}

class Laneige implements OpenBase {
	public String baseName() {
		return "라네즈 네오 파운데이션";
	}
}

class Hera implements OpenBase {
	public String baseName() {
		return "헤라 블랙 파운데이션";
	}
}

class Basekind extends Makeup {
	void baseFinish(OpenBase basemakeup) {
		System.out.println(basemakeup.baseName() + "으로 베이스 메이크업을 시작합니다.");
		System.out.println("피부 위에 얇게 바르고 파우더를 뿌려준 뒤, 쉐딩으로 얼굴 윤곽을 깎았습니다.\n");
		System.out.print(basemakeup.baseName() +"를 사용해");
	}
}

class Etude implements OpenEye {
	public String eyeName() {
		return "에뛰드 인더카페 아이섀도우";
	}
}

class Urbandecay implements OpenEye {
	public String eyeName() {
		return "어반디케이 네이키드 아이섀도우";
	}
}

class Chanel implements OpenEye {
	public String eyeName() {
		return "샤넬 레 베쥬 아이섀도우";
	}
}

class Eyekind extends Makeup {
	void eyeFinish(OpenEye eyemakeup) {
		System.out.println(eyemakeup.eyeName() + "로 아이 메이크업을 시작합니다.");
		System.out.println("눈두덩 위에 바르고 아이라인을 그려준 뒤, 마스카라로 속눈썹을 한 올 한 올 올렸습니다.\n");
		System.out.print(eyemakeup.eyeName() +"를 사용해");
	}
}

class Innisfree implements OpenEyebrow {
	public String eyebrowName() {
		return "이니스프리 납작 아이브로우";
	}
}

class Shuuemura implements OpenEyebrow {
	public String eyebrowName() {
		return "슈에무라 하드포뮬라 아이브로우";
	}
}

class Benefit implements OpenEyebrow {
	public String eyebrowName() {
		return "베네피트 프리사이슬리 아이브로우";
	}
}

class Eyebrowkind extends Makeup {
	void eyebrowFinish(OpenEyebrow eyebrowmakeup) {
		System.out.println(eyebrowmakeup.eyebrowName() + "로 아이브로우 메이크업을 시작합니다.");
		System.out.println("눈썹 위에 결대로 그려주고 브로우 카라로 눈썹에 색을 입혀줍니다.\n");
		System.out.print(eyebrowmakeup.eyebrowName() +"를 사용해");
	}
}

class Espoir implements OpenLip {
	public String lipName() {
		return "에스쁘아 노웨어 립스틱";
	}
}

class Mac implements OpenLip {
	public String lipName() {
		return "맥 파우더 키스 립스틱";
	}
}

class Yvessaintlaurent implements OpenLip {
	public String lipName() {
		return "입생로랑 루쥬 볼립떼 립스틱";
	}
}

class Lipkind extends Makeup {
	void lipFinish(OpenLip lipmakeup) {
		System.out.println(lipmakeup.lipName() + "으로 립 메이크업을 시작합니다.");
		System.out.println("입술 위에 바르고 립 글로즈로 반짝거리게 만들어 줍니다.\n");
		System.out.print(lipmakeup.lipName() +"를 사용해");
	}
}

