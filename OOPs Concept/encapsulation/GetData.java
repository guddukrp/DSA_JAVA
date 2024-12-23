//Encapsulation is a way to protect important parts of code by making them
//private and inaccessible from outside;

package encapsulation;

class BackAccount{
	private float bal;
	
	public void setData(float x) {
		if(x>0) {
			bal=x;
		}
	}
	public float getData() {
		return bal;
	}
}

public class GetData {

	public static void main(String[] args) {
		
		BackAccount ba = new BackAccount();
		
		ba.setData(10000);
		
		System.out.println(ba.getData());
		

	}

}
