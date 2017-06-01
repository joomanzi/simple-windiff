package Controller;


import java.io.IOException;

public class temp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Controller_File_IO[] c = new Controller_File_IO[4];
		
		for(int i=0;i<4;i++)
			c[i] = new Controller_File_IO();
		
		c[0].fileLoad("C:\\Users\\MINWOOK\\gitHub\\SimpleMergeSGJA\\test.txt",0);
		c[1].fileLoad("C:\\Users\\MINWOOK\\gitHub\\SimpleMergeSGJA\\test2.txt",1);
		c[2].fileLoad("C:\\Users\\MINWOOK\\gitHub\\SimpleMergeSGJA\\test3.txt",1);
		c[3].fileLoad("C:\\Users\\MINWOOK\\gitHub\\SimpleMergeSGJA\\test4.txt",0);
		
		c[0].fileSave(0);
		c[1].fileSave(1);
		c[2].fileSave(1);
		c[3].fileSave(0);

	}

}
