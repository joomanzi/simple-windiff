package Controller;

import java.io.BufferedReader;
import java.io.Reader;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Model_File;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class EditTextAreaController implements Initializable {

	@FXML
	private TextArea editTextArea;
	@FXML
	private String editingFileName;
	private Model_File oldFile;
	private Model_File newFile = new Model_File("NewFile");
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		editTextArea.setWrapText(true);
		
		editTextArea.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				oldValue = newValue;
			
				newFile.setLinesLineByLine(newValue);
			}
        });
		
		
		}
	
	public void setFileText(Model_File file){
		oldFile = file;
		editingFileName = oldFile.getfileName();
		for(int i = 0; i < oldFile.getLines().size(); i++){
			editTextArea.appendText(oldFile.getLines().get(i).getValue()+"\n");
		}
	}
	public void changeEditedFile(){
		System.out.println("----------Editresult------------");
		oldFile.getLines().clear();
		for(int i = 0 ; i < newFile.getLines().size() ; i++){
			oldFile.setLinesLineByLine(newFile.getLines().get(i).getValue()+"\n");
		}
	}
	
	public void showStat(){
		System.out.println("------show--------");
		for(int i = 0 ; i < newFile.getLines().size() ; i++){
			System.out.println(oldFile.getLines().get(i).getValue());
		}
	}
}
