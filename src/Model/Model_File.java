package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Model_File {
	private String directory; //directory
	private String fileName; // 
	private int lineNumber;
	private boolean isCompare;
	private ArrayList<String> lineContent;
	public ArrayList<Model_Block> blocks = new ArrayList<Model_Block>();
		
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
	public boolean isCompare(){
		return isCompare;
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
	public void setIsCompare(boolean isComapre){
		this.isCompare = isCompare;
	}
	
}
