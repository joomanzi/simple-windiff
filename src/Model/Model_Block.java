package Model;

<<<<<<< HEAD
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Model_Block {
	/*
	 * startIndex : ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ï´ï¿½ index
	 * lastIndex : ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ Index;
	 * blank : ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½  ï¿½ï¿½
	 * modified: mergeï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½Æ´ï¿½ï¿½ï¿½
	 * */
	private ObservableList<StringProperty> lineInfo;
	public ObservableList<StringProperty> getLineInfo() {
		return lineInfo;
	}
	public void setLineInfo(ObservableList<StringProperty> lineInfo) {
		this.lineInfo = lineInfo;
	}
=======
import java.util.ArrayList;

public class Model_Block {
	/*
	 * blank : ºí·°¿¡ °ø¹é ÁÙ  ¼ö
	 * modified: merge¸¦ ÅëÇØ ¼öÁ¤ÀÌ µÆ´ÂÁö
	 * */
	private ArrayList<Integer> lineInfo;
>>>>>>> 5d6182eaafdd2a5348f266f286f361acf5b11510
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
