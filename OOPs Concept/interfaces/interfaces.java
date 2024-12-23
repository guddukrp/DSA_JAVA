package interfaces;

interface d1{
	int  sum();
}
interface d2{
	int  sum();
}

class d3 implements d1,d2{
	public int  sum() {
		return 10;
	}
}

public class interfaces {

	public static void main(String[] args) {
		
		d1 a = new d3();
		d2 b = new d3();
		
		System.out.println(((d3)a).sum());
		System.out.println(b.sum());

	}

}
