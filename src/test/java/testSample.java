import java.io.IOException;
import java.util.ArrayList;

public class testSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//access method craete class
	
	dataDriven d=new dataDriven();
	ArrayList<String> data= d.getData("Delete Profile");
	System.out.println(data.get(0));
	System.out.println(data.get(1));
	System.out.println(data.get(2));
	System.out.println(data.get(3));
	}

}
