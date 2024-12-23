package multithreading;


class P1 implements Runnable{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(i+" ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}

class P2 implements Runnable{
	public void run() {
		for(int i=10;i>0;i--) {
			System.out.println(i+" ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}


public class RunnableInterface {

	public static void main(String[] args) {
		
		P1 p1 = new P1();
		P2 p2 = new P2();
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		
		t2.setDaemon(true);
		
		t1.start();
		t2.start();
	}

}
