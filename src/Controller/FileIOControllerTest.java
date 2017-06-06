package Controller;

import static org.junit.Assert.*;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileIOControllerTest {
	
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	private FileIOController c1 = null;
	private FileIOController c2 = null;
	private FileIOController c3 = null;
	
	@Before
	public void setUpLoad(){
		this.c1 = new FileIOController();
		this.c2 = new FileIOController();
	}
	@After
	public void tearDownLoad(){
		this.c1 = null;
		this.c2 = null;
	}
	@Test
	public void testFileLoad() throws IOException {
		this.c1.fileLoad("test1.txt", LEFT);
		this.c2.fileLoad("test2.txt", RIGHT);
		assertNotNull(this.c1.getLeftFile());	//왼쪽 파일 입력 성공시 NotNull
		assertNull(this.c1.getRightFile());		//왼쪽 파일만 입력 했으므로 Null
		assertNotNull(this.c2.getRightFile());	//오른쪽 파일 입력 성공시 NotNull
		assertNull(this.c2.getLeftFile());		//오른쪽 파일만 입력 했으므로 Null
		assertEquals(this.c1.getLeftFile().getLines().size(), this.c2.getRightFile().getLines().size());
		//내용이 같고 파일명이 다른 파일 2개를 로드했으므로 파일 내용을 담은 list의 사이즈는 동일 해야 함
		for(int i = 0; i < this.c1.getLeftFile().getLines().size(); i++){
			assertTrue(this.c1.getLeftFile().getLines().get(i).getValue()
					.equals(this.c2.getRightFile().getLines().get(i).getValue()));			
		}	//내용이 같고 파일명이 다른 파일 2개를 로드했으므로 파일의 내용은 모두 동일 해야 함
	}
	
	@Before
	public void setUpSave() throws IOException{
		this.c1 = new FileIOController();
		this.c2 = new FileIOController();
		this.c3 = new FileIOController();
		this.c1.fileLoad("test1.txt", LEFT);
		this.c2.fileLoad("test3.txt", RIGHT);
		this.c1.getLeftFile().setLines(this.c2.getRightFile().getLines());
	}
	@After
	public void tearDownSave(){
		this.c1 = null;
		this.c2 = null;
		this.c3 = null;
	}
	@Test
	public void testFileSave() throws IOException {
		this.c1.fileSave(LEFT);
		this.c3.fileLoad("test1.txt", LEFT);
		
		assertNotNull(this.c3.getLeftFile());
		assertEquals(this.c3.getLeftFile().getLines().size(), this.c2.getRightFile().getLines().size());
		
		for(int i = 0; i < this.c3.getLeftFile().getLines().size(); i++)
		assertTrue(this.c3.getLeftFile().getLines().get(i).getValue()
				.equals(this.c2.getRightFile().getLines().get(i).getValue()));
	}
	
	@Before
	public void setUpSaveAs() throws IOException{
		this.c1 = new FileIOController();
		this.c2 = new FileIOController();
		this.c3 = new FileIOController();
		this.c1.fileLoad("test1.txt", LEFT);
		this.c2.fileLoad("test3.txt", RIGHT);
		this.c1.getLeftFile().setLines(this.c2.getRightFile().getLines());
	}
	@After
	public void tearDownSaveAs(){
		this.c1 = null;
		this.c2 = null;
		this.c3 = null;
	}
	@Test
	public void testFileSaveAs() throws IOException {
		String asName = "test5.txt";
		this.c1.fileSaveAs(LEFT, asName);
		this.c3.fileLoad(asName, LEFT);
		
		assertNotNull(this.c3.getLeftFile());
		assertEquals(this.c3.getLeftFile().getLines().size(), this.c2.getRightFile().getLines().size());

		for(int i = 0; i < this.c3.getLeftFile().getLines().size(); i++)
		assertTrue(this.c3.getLeftFile().getLines().get(i).getValue()
				.equals(this.c2.getRightFile().getLines().get(i).getValue()));
	}

}
