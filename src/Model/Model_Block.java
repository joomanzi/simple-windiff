package Model;

public class Model_Block {
	/*
	 * startIndex : 블럭이 시작하는 index
	 * lastIndex : 블럭이 끝나는 Index;
	 * blank : 블럭에 공백 줄  수
	 * modified: merge를 통해 수정이 됐는지
	 * */
	private ArrayList<String> lineInfo;
	public ArrayList<String> getLineInfo() {
		return lineInfo;
	}
	public void setLineInfo(ArrayList<String> lineInfo) {
		this.lineInfo = lineInfo;
	}
	private int blank;
	private boolean modified = false;
	private boolean isSame = false;
	
	public Model_Block(int blank){
		this.blank = blank;
	}
	//getter
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
