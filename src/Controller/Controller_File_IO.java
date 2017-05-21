package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Model_File;

public class Controller_File_IO {

	private Model_File model_File = null;
	private BufferedReader bufferedReader = null;
	private BufferedWriter bufferedWriter = null;
	private ArrayList<String> fileContent;
	private Scanner in;
	
	public BufferedReader getBufferedReader() {return bufferedReader;}
	
	public void setBufferedReader(BufferedReader bufferedReader) {this.bufferedReader = bufferedReader;}
	
	public void newBufferedReader(String fileName) throws FileNotFoundException{this.bufferedReader = new BufferedReader(new FileReader(fileName));}
	
	public BufferedWriter getBufferedWriter() {return bufferedWriter;}
	
	public void setBufferedWriter(BufferedWriter bufferedWriter) {this.bufferedWriter = bufferedWriter;}
	
	public void newBufferedWriter(String fileName) throws IOException{this.bufferedWriter = new BufferedWriter(new FileWriter(fileName));}
	
	public ArrayList<String> getFileContent() {return fileContent;}
	
	public void setFileContent(ArrayList<String> fileContent) {this.fileContent = fileContent;}
	
	public Scanner getIn() {return in;}
	
	public void setIn(Scanner in) {this.in = in;}
	
	public Model_File getModel_File() {return model_File;}
	
	public void setModel_File(Model_File model_file) {this.model_File = model_file;}
	
	public void newModel_File(String fileName){this.model_File = new Model_File(fileName);}
	
	public Controller_File_IO(){
		
	}
	
	public void fileLoad(String fileName) throws IOException {
		
		this.newModel_File(fileName);
		this.newBufferedReader(fileName);
		
		this.in = new Scanner(this.bufferedReader);
		String s;
		
		while((s=this.getBufferedReader().readLine())!=null)		
			this.model_File.setLineContent(s);
		
	}
	
	public void fileSave(String fileName) throws IOException{
		
		this.newBufferedWriter(fileName);
		int i = 0;
		
		while(i < this.model_File.getLineContent().size()){
			
			this.bufferedWriter.write(this.model_File.getLineContent().get(i));
			
			i++;
			
		}
		
		this.bufferedWriter.close();
		
	}
	
}
