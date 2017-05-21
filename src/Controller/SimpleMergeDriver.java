package Controller;

import java.io.IOException;

public class SimpleMergeDriver {
	public static void main(String[] args) throws IOException{
		Controller_File_IO test = new Controller_File_IO();
		Controller_File_IO test2 = new Controller_File_IO();
		test.fileLoad("C:\\Users\\USER01\\Desktop\\test.txt");
		test2.fileLoad("C:\\Users\\USER01\\Desktop\\test2.txt");
				
		new CompareCode(test.getModel_File(), test2.getModel_File());
		
		System.out.println("---TEST 1 ---");
		System.out.println(test.getModel_File().toString());
		System.out.println("---TEST 2 ---");
		System.out.println(test2.getModel_File().toString());
		
	}
}
