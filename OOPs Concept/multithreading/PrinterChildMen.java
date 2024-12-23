package multithreading;


class Printer implements Runnable{
	
	synchronized public void run() {
		String name = Thread.currentThread().getName();	

		for(int i=0;i<10;i++) {
			System.out.println(name+" is printing");
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
		
}


public class PrinterChildMen {

	public static void main(String[] args) {
		
		Printer p = new Printer();
		
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(p);
		Thread t3 = new Thread(p);
		
		t1.setName("child");
		t2.setName("men");
		t3.setName("women");
		
		t1.start();
		t2.start();
		t3.start();

	}

}
