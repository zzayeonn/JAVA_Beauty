package FourthPackage;

import java.util.ArrayList;

//join : 쓰레드가 종료될 때까지 기다리게 하는 메소드, 쓰레드가 종료된 후 그 다음 로직을 수행할 때 꼭 필요 
public class JoinExample extends Thread {
	int seq;
	
	public JoinExample(int seq) {
		this.seq = seq;
	}
	
	public void run() { 
		System.out.println(this.seq + "thread start.");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		System.out.println(this.seq + "thread end."); 
	}	
	
	public static void main(String[] args) {
		ArrayList<Thread> threads = new ArrayList<>(); //생성된 쓰레드를 담기 위해서 ArrayList 객체인 threads 생성
		for(int i = 0; i < 10; i++) { 
			Thread t = new JoinExample(i);
			t.start(); 
			threads.add(t); //쓰레드 생성 시 생성된 객체를 threads에 저장 
		}
		
		for(int i = 0; i < threads.size(); i++) {
			Thread t = threads.get(i);
			try {
				t.join(); //main 메소드가 종료되기 전에 threads에 담긴 각각의 쓰레드에 join 메소드를 호출하여 쓰레드가 종료될 때까지 대기
			} catch(Exception e) {
			}
		}
		System.out.println("main end."); 
	}
}
