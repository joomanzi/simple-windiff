package Controller;

import Model.Model_Block;
import Model.Model_File;

public class MergeCode {
	Model_Block block;	
	int flag;
	
	MergeCode(Model_Block block, int flag){
		this.block = block;
		this.flag = flag;
		copy(flag);
	}
	private void copy(int flag){
		if(flag == 1) copyRightToleft();  
		if(flag == 2) copyLeftToRight();  
		else return;
	}
		
	private void copyRightToleft(){
		block.setFlag(flag);
		block.setLeftLineInfo(block.getRightLineInfo());
		block.setLeftBlank(block.getRightBlank());
		block.setisModified(true);
	} 
	
	private void copyLeftToRight(){
		block.setFlag(flag);
		block.setRightLineInfo(block.getLeftLineInfo());
		block.setRightBlank(block.getLeftBlank());
		block.setisModified(true);
	} 
}
