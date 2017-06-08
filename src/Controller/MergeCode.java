package Controller;

import Model.Model_Block;

public class MergeCode {
	FileIOController fileIO;
	int blockIndex;
	
	public MergeCode(FileIOController fileIO){
		this.fileIO = fileIO;
		this.blockIndex = fileIO.getSelectedBlockIndex();
		
	}
		
	public void copyRightToleft(){
		this.fileIO.getBlocks().get(this.blockIndex).setFlag(1);
		this.fileIO.getBlocks().get(this.blockIndex).setLeftLineInfo(this.fileIO.getBlocks().get(this.blockIndex).getRightLineInfo());
		this.fileIO.getBlocks().get(this.blockIndex).setLeftBlank(this.fileIO.getBlocks().get(this.blockIndex).getRightBlank());
		this.fileIO.getBlocks().get(this.blockIndex).setisModified(true);
		this.fileIO.getBlocks().set(this.blockIndex, this.fileIO.getBlocks().get(this.blockIndex));
	} 
	
	public void copyLeftToRight(){
		this.fileIO.getBlocks().get(this.blockIndex).setFlag(2);
		this.fileIO.getBlocks().get(this.blockIndex).setRightLineInfo(this.fileIO.getBlocks().get(this.blockIndex).getLeftLineInfo());
		this.fileIO.getBlocks().get(this.blockIndex).setRightBlank(this.fileIO.getBlocks().get(this.blockIndex).getLeftBlank());
		this.fileIO.getBlocks().get(this.blockIndex).setisModified(true);
		this.fileIO.getBlocks().set(this.blockIndex, this.fileIO.getBlocks().get(this.blockIndex));
	} 
}
