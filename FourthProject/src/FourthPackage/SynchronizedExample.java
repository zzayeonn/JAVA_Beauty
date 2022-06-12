package FourthPackage;

//동기화 : 멀티쓰레드 환경에서 어떤 쓰레드가 자원을 이용하는데 동시에 그 자원을 사용하면 안 될 때 필요 
class Key {	
	public void open(String name){
		System.out.println(name+"이(가) 화장실 문을 연다.");
	}
	
	public void close(String name){
		System.out.println(name+"이(가) 화장실 문을 닫는다.");
	}
	public void defecate(String name){
		System.out.println(name+"이(가) 볼 일을 본다.");
	}
	public synchronized void useToilet(String name){ //한번에 실행하도록 동기화
		open(name);
		defecate(name);
		close(name);
	}	
}

class MyThread extends Thread{
	private String name;
	private Key key; //클래스 Key의 객체 선언
	public MyThread(String name,Key key){
		this.name=name;
		this.key=key;
	}
	public void run(){
		key.useToilet(name); //객체 key의 useToilet 메소드에 name을 넣어 실행
	}
}
public class SynchronizedExample {

	public static void main(String[] ar) throws Exception{
		Key key=new Key(); //이 객체를 쓰레드 3개에서 사용
		MyThread thread1=new MyThread("철수", key);
		MyThread thread2=new MyThread("영희", key);
		MyThread thread3=new MyThread("영철", key);
		
		thread1.start(); //synchronized된 useToilet의 메소드 전체 실행
		thread2.start();
		thread3.start();
	}
	
}
