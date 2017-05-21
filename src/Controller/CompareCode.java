package Controller;
import java.util.ArrayList;

import Model.Model_Block;
import Model.Model_File;
/*
 * 1. 같은 라인의 Index를 찾는다. 같은라인이면 체크해줘야할듯?
 * 2. 같은 라인이전까지 한 블럭
 * 3. 
 * 
 * */
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
/*		int previousPos_file1 = 0;
		int previousPos_file2 = 0;
		int pos_file1;
		int pos_file2;
		int blank_file1, blank_file2;
		
		for(int i = LCS.getLCSlength() - 1 ; i >= 0 ; i--){
			pos_file1 = LCS.X_Index.get(i);
			pos_file2 = LCS.Y_Index.get(i);
			 
			blank_file1 = calculateBlank(pos_file1, pos_file2);
			blank_file2 = calculateBlank(pos_file2, pos_file1);
						
			if(blank_file1 + previousPos_file1 == pos_file1){
				file1.blocks.add(new Model_Block(previousPos_file1, pos_file1-1, blank_file1));
			}
			if(blank_file2 + previousPos_file2 == pos_file2){
				file2.blocks.add(new Model_Block(previousPos_file2, pos_file2-1,  blank_file2));
			}
			
			addCurrentBlock(pos_file1, pos_file2);
			
			previousPos_file1 = ++pos_file1;
			previousPos_file2 = ++pos_file2;

		}
		*/
	}
	private int calculateBlank(int pos1, int pos2){
		return (pos1 < pos2) ? (pos2-pos1) : 0;
	}
	
	private boolean isPreviousBlockExist(int pos, int priorPos){
		if(pos - priorPos == 0) return false;
		return true;
	}
	
	private void addCurrentBlock(int pos_file1,int pos_file2){
		Model_Block a = new Model_Block(pos_file1, pos_file1, 0);
		Model_Block b = new Model_Block(pos_file2, pos_file2, 0);
		a.setisSame(true);
		b.setisSame(true);
		file1.blocks.add(a);
		file2.blocks.add(b);
	}
}
