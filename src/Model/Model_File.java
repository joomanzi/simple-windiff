package Model;



import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.text.Text;

public class Model_File {
	private String directory; //directory
	private String fileName; // 
	private boolean isCompare;
	private ObservableList<StringProperty> lines;
	private StringProperty line;
	//public ObservableList<Model_Block> blocks;
  
	public Model_File(String fileName){
		this.newLines();
		this.setfileName(fileName);
		
	}
  			
	//getter
	public String getDirectory(){
		return this.directory;
	}
	public String getfileName(){ 
		return this.fileName;
	}
	public void newLines(){
		this.lines = FXCollections.observableArrayList();
	}
	public ObservableList<StringProperty> getLines(){
		return this.lines;
	}
	public boolean isCompare(){
		return isCompare;
	}
	//setter
	public void setDirectory(String directory){
		this.directory = directory;
	}
	public void setfileName(String fileName){
		this.fileName = fileName;
	}
	public void setLines(ObservableList<StringProperty> lines){
		this.lines = lines;
	}
	public void setIsCompare(boolean isCompare){
		this.isCompare = isCompare;
	}
	public void setLinesLineByLine(String value){
		line = new SimpleStringProperty(value);
		lines.add(line);
	}
}
