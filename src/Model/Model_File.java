package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Model_File {
	private String directory; //directory
	private String fileName; // 
  private boolean isCompare;
	private ArrayList<String> lineContent;
	public ArrayList<Model_Block> blocks;
  
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
	public boolean isCompare(){
		return isCompare;
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
	public void setLineContent(ArrayList<String> lineContent){
		this.lineContent = lineContent;
	}
	public void setIsCompare(boolean isComapre){
		this.isCompare = isCompare;
	}
/*	public String toString(){
		Iterator<Model_Block> list = blocks.iterator();
		StringBuilder result = new StringBuilder();
		
		while(list.hasNext()){
			Model_Block tmp = list.next();
			for(int i = tmp.getStartIndex(); i <= tmp.getLastIndex(); i++){
				result.append(lineContent.get(i));
			}
			for(int i = 0 ; i < tmp.getBlank(); i++){
				result.append("\r\n");
			}
		}
		
		
		return result.toString();
	}*/
}
