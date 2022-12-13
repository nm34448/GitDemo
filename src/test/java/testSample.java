import java.io.IOException;
import java.util.ArrayList;

public class testSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		DataDriven d=new DataDriven();
		ArrayList data=d.getData("Add Profile");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		System.out.println("this is for git test");
		System.out.println("this is for git test3333");
		System.out.println("this is for git merge issue test3333");
		System.out.println("this is for git merge issue GITX test3333");
				
	}

}
