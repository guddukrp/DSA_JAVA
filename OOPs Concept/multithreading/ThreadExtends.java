package multithreading;


class Program extends Thread{
	
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(i+" ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Program2 extends Thread{
	public void run() {
		for(int i=10;i>0;i--) {
			System.out.println(i+" ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


public class ThreadExtends {

	public static void main(String[] args) throws InterruptedException {
		Program p = new Program();
		Program2 p2 = new Program2();
		
		System.out.println("main is starting");
		
//		p2.setDaemon(true);
		
		p.start();
		p.join();
		p2.start();
		p2.join();
		
		
		System.out.println("main is ended");

	}

}
