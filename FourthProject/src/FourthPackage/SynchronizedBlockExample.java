package FourthPackage;

//부분 동기화 : 원하는 부분만 동기화
class Key2 {
	
	public void lookIntoAMirror(String name){
		System.out.println(name+"이(가) 거울을 본다.");
	}
	public void open(String name){
		System.out.println(name+"이(가) 화장실 문을 연다.");
	}
	public void close(String name){
		System.out.println(name+"이(가) 화장실 문을 닫는다.");
	}
	public void defecate(String name){
		System.out.println(name+"이(가) 볼 일을 본다.");
	}
	public void useToilet(String name){
		lookIntoAMirror(name); //동기화 불필요
		synchronized(this){ //(lock 시킬 객체) = key 객체
			open(name);
			defecate(name);
			close(name);
		}
	}	
}

class MyThread2 extends Thread{
	private String name;
	private Key2 key;
	public MyThread2(String name,Key2 key){
		this.name=name;
		this.key=key;
	}
	public void run(){
		key.useToilet(name);
	}
}

public class SynchronizedBlockExample {
	public static void main(String[] ar) throws Exception{
		Key2 key=new Key2();
		MyThread2 thread1=new MyThread2("철수", key);
		MyThread2 thread2=new MyThread2("영희", key);
		MyThread2 thread3=new MyThread2("영철", key);
		
		thread1.start(); //useToilet을 실행하나 synchronized된 block만 한꺼번에 실행
		thread2.start(); //synchronized 되지 않은 부분은 멀티쓰레드
		thread3.start();
	}	
}
