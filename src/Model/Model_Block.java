package Model;

import java.util.ArrayList;

public class Model_Block {
	/*
	 * blank : 블럭에 공백 줄  수
	 * modified: merge를 통해 수정이 됐는지
	 * */
	private ArrayList<Integer> lineInfo;
	private int blank;
	private boolean modified;
	private boolean isSame;
	
	public Model_Block(){
		lineInfo = new ArrayList<Integer>();
		blank = 0;
		modified = false;
		modified = isSame;
	}
	//getter
	public ArrayList<Integer> getLineInfo() {
		return lineInfo;
	}
	public int getBlank(){
		return blank;
	}
	public boolean isModified(){
		return modified;
	}
	public boolean isSame(){
		return isSame;
	}
	//setter
	public void setLineInfo(ArrayList<Integer> lineInfo) {
		this.lineInfo = lineInfo;
	}
	public void setBlank(int blank){
		this.blank = blank;
	}
	public void setisModified(boolean modified){
		this.modified = modified;
	}
	public void setisSame(boolean isSame){
		this.isSame = isSame;
	}
}
