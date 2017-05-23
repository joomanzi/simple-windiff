package Controller;

import Model.Model_Block;
import Model.Model_File;

public class MergeCode {
	Model_Block left;
	Model_Block right;
	
	MergeCode(Model_Block left, Model_Block right){
		this.left = left;
		this.right = right;
	}
	
	private void copy(Model_Block from, Model_Block to){
		to.setLineInfo(from.getLineInfo());
		to.setBlank(from.getBlank());
		to.setisModified(true);
	}
	public void copyLeftToRight(){
		copy(this.left,this.right);
	}
	
	public void copyRightToleft(){
		copy(this.right,this.left);
	}
	
}
