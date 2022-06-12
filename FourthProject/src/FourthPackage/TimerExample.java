package FourthPackage;

import java.util.Timer;
import java.util.TimerTask;

public class TimerExample {
	
	public static void main(String[] args) {
		System.out.println("밤이 되어 취침에 들어갔습니다.\n");
		
		Timer m_timer = new Timer();
		TimerTask m_task = new TimerTask() {
			public void run() {
				System.out.println("아침이 되었습니다.");
			}
		};
			
		m_timer.schedule(m_task, 5000);
	}

}
