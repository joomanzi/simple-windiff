package Model;

import java.util.ArrayList;

public class Model_Block {
	
	private ArrayList<Integer> leftLineInfo;
	private ArrayList<Integer> rightLineInfo;
	private int leftBlank;
	private int rightBlank;
	private int flag; //flag==1 getData From Left, flag==2 getDataFromright flag==0 getDataFromThis
	private boolean modified;
	private boolean isSame;
		
	public Model_Block(){
		leftLineInfo = new ArrayList<Integer>();
		rightLineInfo = new ArrayList<Integer>();
		leftBlank = 0;
		rightBlank = 0;
		flag = 0;
		modified = false;
		isSame = false;
	}
	public Model_Block(Model_File file){
		leftLineInfo = new ArrayList<Integer>();
		rightLineInfo = new ArrayList<Integer>();
		leftBlank = 0;
		rightBlank = 0;
		flag = 0;
		modified = false;
		isSame = false;
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0 ; i < file.getLines().size() ; i++){
			al.add(i);
		}
		setLeftLineInfo(al);
		setRightLineInfo(al);
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	//getter
	public boolean isModified(){
		return modified;
	}
	public boolean isSame(){
		return isSame;
	}
	//setter
	public ArrayList<Integer> getLeftLineInfo() {
		return leftLineInfo;
	}
	public void setLeftLineInfo(ArrayList<Integer> leftLineInfo) {
		this.leftLineInfo = leftLineInfo;
	}
	public ArrayList<Integer> getRightLineInfo() {
		return rightLineInfo;
	}
	public void setRightLineInfo(ArrayList<Integer> rightLineInfo) {
		this.rightLineInfo = rightLineInfo;
	}
	public int getLeftBlank() {
		return leftBlank;
	}
	public void setLeftBlank(int leftBlank) {
		this.leftBlank = leftBlank;
	}
	public int getRightBlank() {
		return rightBlank;
	}
	public void setRightBlank(int rightBlank) {
		this.rightBlank = rightBlank;
	}
	public void setisModified(boolean modified){
		this.modified = modified;
	}
	public void setisSame(boolean isSame){
		this.isSame = isSame;
	}
}
