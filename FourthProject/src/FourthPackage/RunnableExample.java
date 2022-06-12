package FourthPackage;

import java.util.ArrayList;

//Runnable : Thread 클래스를 상속하면 다른 클래스를 상속할 수 없기 때문에 Runnable 인터페이스를 주로 사용 
public class RunnableExample implements Runnable {
	int seq;
	
	public RunnableExample(int seq) {
		this.seq = seq;
	}
	
	public void run() { //Runnable 인터페이스는 run 메소드를 구현하도록 강제함 
		System.out.println(this.seq + "thread start.");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		System.out.println(this.seq + "thread end."); 
	}	
	
	public static void main(String[] args) {
		ArrayList<Thread> threads = new ArrayList<>(); 
		for(int i = 0; i < 10; i++) { 
			Thread t = new Thread(new RunnableExample(i)); //Thread의 생성자로 Runnable 인터페이스를 구현한 객체를 넘길 수 있음 
			t.start(); 
			threads.add(t); 
		}
		
		for(int i = 0; i < threads.size(); i++) {
			Thread t = threads.get(i);
			try {
				t.join(); 
			} catch(Exception e) {
			}
		}
		System.out.println("main end."); 
	}
}

