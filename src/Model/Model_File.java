package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Model_File {
	private String directory; //directory
	private String fileName; // 
	private int lineNumber;
	private ArrayList<String> lineContent;
		
	//getter
	public String getDirectory(){
		return this.directory;
	}
	public String getfileName(){ 
		return this.fileName;
	}
	public int getLineNumber(){
		return this.lineNumber;
	}
	public ArrayList<String> getLineContent(){
		return lineContent;
	}
	//setter
	public void setDirectory(String directory){
		this.directory = directory;
	}
	public void setfileName(String filename){
		this.fileName = fileName;
	}
	public void setLineNumber(int lineNumber){
		this.lineNumber = lineNumber;
	}
	public void setLineContent(ArrayList<String> lineContent){
		this.lineContent = lineContent;
	}	
}
