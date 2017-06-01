package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Model_File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller_File_IO {

	private BufferedReader bufferedReader = null;
	private BufferedWriter bufferedWriter = null;
	private ObservableList<Model_File> files = null;
	private Scanner in;
	
	public BufferedReader getBufferedReader() {return bufferedReader;}
	
	public void setBufferedReader(BufferedReader bufferedReader) {this.bufferedReader = bufferedReader;}
	
	public void newBufferedReader(String fileName) throws FileNotFoundException{
		this.bufferedReader = new BufferedReader(new FileReader(fileName));
	}
	
	public BufferedWriter getBufferedWriter() {return bufferedWriter;}
	
	public void setBufferedWriter(BufferedWriter bufferedWriter) {this.bufferedWriter = bufferedWriter;}
	
	public void newBufferedWriter(String fileName) throws IOException{this.bufferedWriter = new BufferedWriter(new FileWriter(fileName));}
	
	public ObservableList<Model_File> getFiles() {return files;}
	
	public void setFiles(ObservableList<Model_File> files) {this.files = files;}
	
	public Scanner getIn() {return in;}
	
	public void setIn(Scanner in) {this.in = in;}
	
	public Controller_File_IO(){
		files = FXCollections.observableArrayList();
		System.out.println("Controller IO : constructor");
	}
	
	public void fileLoad(String fileName) throws IOException {
		
		Model_File new_file = new Model_File(fileName);
		
		this.newBufferedReader(fileName);
		
		this.in = new Scanner(this.bufferedReader);
		String s;
		
		while((s=this.getBufferedReader().readLine())!=null)		
			new_file.setLinesLineByLine(s);
		
		files.add(new_file);
	}
	public void saidSomething(){
		System.out.println("hey I'm instatnciazed");
	}
	public void fileSave(String fileName, int idx) throws IOException{
		this.newBufferedWriter(fileName);
		int i = 0;
		
		while(i < files.get(idx).getLines().size()){
			this.bufferedWriter.write(files.get(idx).getLines().get(i).toString());
			i++;
		}
		
		this.bufferedWriter.close();
	}
	
}
