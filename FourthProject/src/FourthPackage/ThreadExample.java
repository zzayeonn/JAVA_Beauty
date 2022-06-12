package FourthPackage;

//쓰레드 : 보통 한 개의 프로세스는 한 가지의 일을 하지만 쓰레드는 한 프로세스 내에서 두 가지, 그 이상의 일을 동시에 할 수 있음 
public class ThreadExample extends Thread {
	int seq;
	
	public ThreadExample(int seq) {
		this.seq = seq;
	}
	
	public void run() { //Thread를 상속하면 run 메소드를 구현해야 함 
		System.out.println(this.seq + "thread start.");
		try {
			Thread.sleep(1000); //1초 대기 
		} catch (Exception e) {
		}
		System.out.println(this.seq + "thread end."); //쓰레드 종료 
	}	
	
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) { //총 10개의 쓰레드를 생성하여 실행 
			Thread t = new ThreadExample(i);
			t.start(); //start()로 쓰레드 실행(TreadExample 객체의 run 메소드 수행)
		}
		System.out.println("main end."); //main 메소드 종료 
	}

}
