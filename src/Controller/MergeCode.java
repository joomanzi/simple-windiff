package Controller;

public class MergeCode {
//	Model_Block block;	
	FileIOController fileIO;
	int flag;
	int blockIndex;
	
	/*
	MergeCode(Model_Block block, int flag){
		this.block = block;
		this.flag = flag;
		copy(flag);
	}
	*/
	
	public MergeCode(FileIOController fileIO, int blockIndex, int flag){
		this.fileIO = fileIO;
		this.flag = flag;
		this.blockIndex = blockIndex;
		this.copy(this.flag);
		
		
	}
	private void copy(int flag){
		if(flag == 1) copyRightToleft();  
		if(flag == 2) copyLeftToRight();  
		else return;
	}
		
	private void copyRightToleft(){
		this.fileIO.getBlocks().get(this.blockIndex).setFlag(flag);
		this.fileIO.getBlocks().get(this.blockIndex).setLeftLineInfo(this.fileIO.getBlocks().get(this.blockIndex).getRightLineInfo());
		this.fileIO.getBlocks().get(this.blockIndex).setLeftBlank(this.fileIO.getBlocks().get(this.blockIndex).getRightBlank());
		this.fileIO.getBlocks().get(this.blockIndex).setisModified(true);
	} 
	
	private void copyLeftToRight(){
		this.fileIO.getBlocks().get(this.blockIndex).setFlag(flag);
		this.fileIO.getBlocks().get(this.blockIndex).setRightLineInfo(this.fileIO.getBlocks().get(this.blockIndex).getLeftLineInfo());
		this.fileIO.getBlocks().get(this.blockIndex).setRightBlank(this.fileIO.getBlocks().get(this.blockIndex).getLeftBlank());
		this.fileIO.getBlocks().get(this.blockIndex).setisModified(true);
	} 
}
