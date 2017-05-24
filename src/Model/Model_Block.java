package Model;

import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Model_Block {
	/*
	 * startIndex : ���� �����ϴ� index
	 * lastIndex : ���� ������ Index;
	 * blank : ���� ���� ��  ��
	 * modified: merge�� ���� ������ �ƴ���
	 * */
	private ObservableList<StringProperty> lineInfo;
	public ObservableList<StringProperty> getLineInfo() {
		return lineInfo;
	}
	public void setLineInfo(ObservableList<StringProperty> lineInfo) {
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
