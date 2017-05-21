package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Model_File {
	private String directory; //directory
	private String fileName; // 
	private ArrayList<String> lineContent;
	
	public Model_File(String fileName){
		
		this.newLineContent();
		this.setfileName(fileName);
	}
		
	//getter
	public String getDirectory(){
		return this.directory;
	}
	public String getfileName(){ 
		return this.fileName;
	}
	public void newLineContent(){
		this.lineContent = new ArrayList<String>();
	}
	public ArrayList<String> getLineContent(){
		return this.lineContent;
	}
	
	//setter
	public void setDirectory(String directory){
		this.directory = directory;
	}
	public void setfileName(String fileName){
		this.fileName = fileName;
	}
	public void setLineContent(String lineContent){
		this.lineContent.add(lineContent+"\r\n");
	}

	
}
