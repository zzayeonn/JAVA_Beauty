package FourthPackage;

class Counter{
	public Integer cnt=0;
	
	public void increase(String threadName){
		synchronized(this){ //=Counter 객체 
		//synchronized(cnt) //thread1, 2의 increase 중 무작위 실행, cnt로 락을 걸었기에 cnt가 쓰이지 않는 순간 다른 쓰레드 실행
			for(int i=0;i<10;i++)
				System.out.println(threadName+", cnt:"+(cnt++));
			System.out.println();
		}
	}	
}

class MyThread3 extends Thread{
	private String threadName;
	private Counter counter;
	public MyThread3(String threadName,Counter counter){
		this.threadName=threadName;
		this.counter=counter;
	}
	public void run(){
		counter.increase(threadName);
	}
}

public class SynchronizedBlockExample2 {

	public static void main(String[] ar) throws Exception{
		Counter counter=new Counter();
		MyThread3 thread1=new MyThread3("thread1",counter);
		MyThread3 thread2=new MyThread3("thread2",counter);
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		System.out.println(counter.cnt); //join 때문에 대기하다 모든 쓰레드의 동작이 끝난 후 실행
	}
}