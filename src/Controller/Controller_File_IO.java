package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Model_File;

public class Controller_File_IO {

	private BufferedReader bufferedReader = null;
	private BufferedWriter bufferedWriter = null;
	private ArrayList<String> fileContent;
	private Scanner in;
	private Model_File model_file;
	
	public Controller_File_IO(String fileName){
		
		this.model_file = new Model_File();
	}
	
	public void fileLoad(String fileName) throws IOException{
		
		this.bufferedReader = new BufferedReader(new FileReader(fileName));
		this.bufferedWriter = new BufferedWriter(new FileWriter(fileName));
		
		this.model_file.setOriginContent(this.OriginalFile(bufferedReader));
	}
	
	public void fileSave(ArrayList<String> lineContent) throws IOException{
		
		for(int i = 0; i<lineContent.size(); i++){

			this.bufferedWriter.write(lineContent.get(i));
			if(i<lineContent.size())
				this.bufferedWriter.newLine();
		}
		
		this.bufferedWriter.close();
		
	}
	
	public ArrayList<String> OriginalFile(BufferedReader bufferedReader){
		
		this.in = new Scanner(bufferedReader);
		
		while(in.hasNext()){
			
			this.fileContent.add(in.nextLine());
		}
		
		return this.fileContent;
		
	}
}
