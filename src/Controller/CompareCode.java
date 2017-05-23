package Controller;
import java.io.IOException;
import java.util.ArrayList;

import Model.Model_Block;
import Model.Model_File;


public class CompareCode {
	Model_File file1;
	Model_File file2;
	ArrayList<String> file1LineContents;
	ArrayList<String> file2LineContents;
	LCSalgorithms LCS;
	
	CompareCode(Model_File file1, Model_File file2){
		this.file1 = file1;
		this.file2 = file2;
		file1.blocks = new ArrayList<Model_Block>();
		file2.blocks = new ArrayList<Model_Block>();
		this.file1LineContents = file1.getLineContent();
		this.file2LineContents = file2.getLineContent();
		file1.setIsCompare(true);
		file2.setIsCompare(true);
		
		LCS = new LCSalgorithms(file1LineContents, file2LineContents);
		createBlock();
	}
	
	private void createBlock(){
		/*
		 * 1. 넣어줘야할 이전의 블락이 있는지 확인한다.
		 * 2. -> 없는 경우, 이전의 모델과 같다면 lineInfo에 추가만. 이전의 모델이 없다면 그냥 넣어줌
		 * 3. -> 있는 경우 , 이전의 블락을 넣어주고 , 지금 블락을 새로운 블락에 넣어준다.
		 * */
		int priorIndex1 = -1, priorIndex2 = -1;
		int currentIndex1, currentIndex2;
		for(int i = LCS.getLCSlength() -1 ; i >= 0 ; i--){
			currentIndex1 = LCS.X_Index.get(i);
			currentIndex2 = LCS.Y_Index.get(i);
			
			if(hasPriorBlock(priorIndex1, priorIndex2, currentIndex1, currentIndex2)){
				insertBlock(priorIndex1, priorIndex2, currentIndex1, currentIndex2);
			}
			//currentBlock insert
			insertCurrentBlock(priorIndex1, priorIndex2, currentIndex1, currentIndex2);
			
			priorIndex1 = currentIndex1;
			priorIndex2 = currentIndex2;
		}
		//insertLastblock
		insertLastBlock(priorIndex1, priorIndex2, file1.getLineContent().size()-1, file2.getLineContent().size()-1);
	
	}
	private boolean hasPriorBlock(int prior1, int prior2, int current1, int current2){
		if(current1 - prior1 != 1 || current2 - prior2 != 1)
			return true;
		return false;
	}
	private void insertBlock(int prior1, int prior2, int current1, int current2){
				int blockSize;
		Model_Block block1 = new Model_Block();
		Model_Block block2 = new Model_Block();
		insertLineInfo(block1, prior1, current1);
		insertLineInfo(block2, prior2, current2);
		
		if(current1-prior1 >= current2-prior2)
			blockSize = current1-prior1-1;
		else
			blockSize = current2-prior2-1;
		
		block1.setBlank(blockSize - block1.getLineInfo().size());
		block2.setBlank(blockSize - block2.getLineInfo().size());
		
		file1.blocks.add(block1);
		file2.blocks.add(block2);
	}
	private void insertLineInfo(Model_Block block, int start, int end){
		for(int i = start+1 ; i < end; i++){
			block.getLineInfo().add(i);
		}
	}
	private void insertCurrentBlock(int prior1, int prior2, int current1, int current2){
		Model_Block block1 = new Model_Block();
		Model_Block block2 = new Model_Block();
		block1.setisSame(true);
		block2.setisSame(true);
		
		
		if(!hasPriorBlock(prior1, prior2, current1, current2)){// 넣을 블락이 없었다면
			if(file1.blocks.size() == 0 && file2.blocks.size() == 0){//블락이 하나도 없는경우
				block1.getLineInfo().add(current1);
				block2.getLineInfo().add(current2);
				file1.blocks.add(block1);
				file2.blocks.add(block2);
			}
			else{ //블락이 하나라도 있다면 이전 블락에다가 라인정보만 추가한다.
				file1.blocks.get(file1.blocks.size()-1).getLineInfo().add(current1);
				file2.blocks.get(file2.blocks.size()-1).getLineInfo().add(current2);
			}		
		}
		
		else{
			block1.getLineInfo().add(current1);
			block2.getLineInfo().add(current2);
			file1.blocks.add(block1);
			file2.blocks.add(block2);
		}
		
		return;
	}
	private void insertLastBlock(int start1, int start2, int last1, int last2){
		//insert할 block이 없는 경우
		if(start1 == last1 && start2 == last2) return;
		//insert할 block이 둘다 line 하나인 경우.
		
		if(!hasPriorBlock(start1, start2, last1, last2)){
			Model_Block block1 = new Model_Block();
			Model_Block block2 = new Model_Block();
			block1.getLineInfo().add(last1);
			block2.getLineInfo().add(last2);
			file1.blocks.add(block1);
			file2.blocks.add(block2);
		}
		else{
			insertBlock(start1, start2, last1, last2);
		}
		return;
	}
	public static void main(String[] args) throws IOException{
		Controller_File_IO a = new Controller_File_IO();
		Controller_File_IO b = new Controller_File_IO();
		
		a.fileLoad("C:\\Users\\USER01\\Desktop\\test.txt");
		b.fileLoad("C:\\Users\\USER01\\Desktop\\test2.txt");
		new CompareCode(a.getModel_File(), b.getModel_File());
		System.out.println("done");
	}
}
