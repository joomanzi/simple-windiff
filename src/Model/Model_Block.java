package Model;

public class Model_Block {
	/*
	 * startIndex : 블럭이 시작하는 index
	 * lastIndex : 블럭이 끝나는 Index;
	 * blank : 블럭에 공백 줄  수
	 * modified: merge를 통해 수정이 됐는지
	 * */
	private int startIndex;
	private int lastIndex;
	private int blank;
	private boolean modified;
	private boolean isSame = false;
	
	public Model_Block(int startIndex,int lastIndex,int blank){
		this.startIndex = startIndex;
		this.lastIndex = lastIndex;
		this.blank = blank;
	}
	//getter
	public int getStartIndex(){
		return startIndex;
	}
	public int getLastIndex(){
		return lastIndex;
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
	public void setStartIndex(int startIndex){
		this.startIndex = startIndex;
	}
	public void setLastIndex(int lastIndex){
		this.lastIndex = lastIndex;
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
