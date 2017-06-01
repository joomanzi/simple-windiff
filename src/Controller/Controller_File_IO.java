package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Model.Model_Block;
import Model.Model_File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller_File_IO {

	private BufferedReader bufferedReader = null;
	private BufferedWriter bufferedWriter = null;
	private Model_File leftFile = null;
	private Model_File rightFile = null;
	private ObservableList<Model_Block> blocks = null;

	private Scanner in;
	
	public Model_File getLeftFile() {return leftFile;}

	public void setLeftFile(Model_File leftFile) {this.leftFile = leftFile;}

	public Model_File getRightFile() {return rightFile;}

	public void setRightFile(Model_File rightFile) {this.rightFile = rightFile;}

	public BufferedReader getBufferedReader() {return bufferedReader;}
	
	public void setBufferedReader(BufferedReader bufferedReader) {this.bufferedReader = bufferedReader;}
	
	public void newBufferedReader(String fileName) throws FileNotFoundException{this.bufferedReader = new BufferedReader(new FileReader(fileName));}
	
	public ObservableList<Model_Block> getBlocks() {return blocks;}
	
	public void setBlocks(ObservableList<Model_Block> blocks) {this.blocks = blocks;}
	
	public BufferedWriter getBufferedWriter() {return bufferedWriter;}
	
	public void setBufferedWriter(BufferedWriter bufferedWriter) {this.bufferedWriter = bufferedWriter;}
	
	public void newBufferedWriter(String fileName) throws IOException{this.bufferedWriter = new BufferedWriter(new FileWriter(fileName));}
	
	public Scanner getIn() {return in;}
	
	public void setIn(Scanner in) {this.in = in;}
	
	public Controller_File_IO(){ blocks = FXCollections.observableArrayList(); }
	
	public void fileLoad(String fileName, int leftOrRight) throws IOException {
		
		Model_File new_file = new Model_File(fileName);
		
		this.newBufferedReader(fileName);
		
		this.in = new Scanner(this.bufferedReader);
		String s;
		
		while((s = this.getBufferedReader().readLine()) != null)		
			new_file.setLinesLineByLine(s);
		switch(leftOrRight){
		
		case 0:
			this.leftFile = new_file;
			break;
			
		case 1:
			this.rightFile = new_file;
			break;
			
		default:
			System.out.println("Load operation has been failed");
			System.exit(1);
		}
	}
	
	public void fileSave(int leftOrRight) throws IOException{

		int index;
		
		if(this.blocks == null){	//compare,merge ���� ���
			switch(leftOrRight){
		
			case 0:	//���� ���� ����
				this.newBufferedWriter(this.leftFile.getfileName());
				for(int i = 0; i < this.leftFile.getLines().size(); i++)
					this.bufferedWriter.write(this.leftFile.getLines().get(i).getValue());
				break;
			
			case 1:	//������ ���� ����
				this.newBufferedWriter(this.rightFile.getfileName());
				for(int i = 0; i < this.rightFile.getLines().size(); i++)
					this.bufferedWriter.write(this.rightFile.getLines().get(i).getValue());
				break;
			
			default:
				System.out.println("Save operation has been failed");
				System.exit(1);
				break;
			}
		}
		else{	//compare, merge�� ���
			switch(leftOrRight){
			
			case 0:	//���� ���� ����	
				this.newBufferedWriter(this.leftFile.getfileName());
				for(int i = 0; i < this.blocks.size(); i++){
					for(int j = 0; j < this.blocks.get(i).getLeftLineInfo().size(); j++){
						index = this.blocks.get(i).getLeftLineInfo().get(j);
						
						if(this.blocks.get(i).getFlag()==2)
							this.bufferedWriter.write(this.rightFile.getLines().get(index).getValue());
						else
							this.bufferedWriter.write(this.leftFile.getLines().get(index).getValue());
					}
				}
				break;
				
			case 1:	//������ ���� ����
				this.newBufferedWriter(this.rightFile.getfileName());
				for(int i = 0; i < this.blocks.size(); i++){
					for(int j = 0; j < this.blocks.get(i).getRightLineInfo().size(); j++){
						index = this.blocks.get(i).getRightLineInfo().get(j);
						
						if(this.blocks.get(i).getFlag()==1)
							this.bufferedWriter.write(this.leftFile.getLines().get(index).getValue());
						else
							this.bufferedWriter.write(this.rightFile.getLines().get(index).getValue());	
					}
				}
				break;
				
			default:
				System.out.println("Save operation has been failed");
				System.exit(1);
				break;
			}
		}
		this.bufferedWriter.close();
	}
	
	public void fileSaveAs(int leftOrRight, String fileName) throws IOException{
		
		this.newBufferedWriter(fileName);
		int index;
		
		if(this.blocks == null){	//compare,merge ���� ���
			switch(leftOrRight){
		
			case 0:	//���� ���� ����
				for(int i = 0; i < this.leftFile.getLines().size(); i++)
					this.bufferedWriter.write(this.leftFile.getLines().get(i).getValue());
				break;
			
			case 1:	//������ ���� ����
				for(int i = 0; i < this.rightFile.getLines().size(); i++)
					this.bufferedWriter.write(this.rightFile.getLines().get(i).getValue());
				break;
			
			default:
				System.out.println("SaveAs operation has been failed");
				System.exit(1);
				break;
			}
		}
		else{	//compare, merge�� ���
			switch(leftOrRight){
			
			case 0:	//���� ���� ����	
				for(int i = 0; i < this.blocks.size(); i++){
					for(int j = 0; j < this.blocks.get(i).getLeftLineInfo().size(); j++){
						index = this.blocks.get(i).getLeftLineInfo().get(j);
						
						if(this.blocks.get(i).getFlag()==1)
							this.bufferedWriter.write(this.leftFile.getLines().get(index).getValue());
						else
							this.bufferedWriter.write(this.rightFile.getLines().get(index).getValue());	
					}
				}
				break;
				
			case 1:	//������ ���� ����
				for(int i = 0; i < this.blocks.size(); i++){
					for(int j = 0; j < this.blocks.get(i).getRightLineInfo().size(); j++){
						index = this.blocks.get(i).getRightLineInfo().get(j);
						
						if(this.blocks.get(i).getFlag()==1)
							this.bufferedWriter.write(this.leftFile.getLines().get(index).getValue());
						else
							this.bufferedWriter.write(this.rightFile.getLines().get(index).getValue());	
					}
				}
				break;
				
			default:
				System.out.println("SaveAs operation has been failed");
				System.exit(1);
				break;
			}
		}
		this.bufferedWriter.close();
	}
}
