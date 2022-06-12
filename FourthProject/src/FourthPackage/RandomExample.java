package FourthPackage;

import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random random = new Random();
		
		int rand = random.nextInt(4); //0-3 중에 무작위로 실행
		System.out.println("random : " + rand);

		System.out.println("end");
		
	}

}
