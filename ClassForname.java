package jdbc_Connection;

public class ClassForname {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		// Method -1 
		
//		Pqr pqr = new Pqr();
		
		//Method - 2
		
//		Class.forName("Pqr").newInstance();
		

	}

}

class Pqr{
	
	static {
		System.out.println("In Static");
	}
	
	{
		System.out.println("In instance block");
	}
	
}