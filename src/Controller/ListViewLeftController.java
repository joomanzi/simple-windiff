package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;

import Model.Model_Block;
import Model.Model_File;
import View.MainFrame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.Parent;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;
import javafx.scene.control.ListCell;
public class ListViewLeftController implements Initializable {
	/*TODO
	 * FXML로 TextArea짜기
	 * Model_File 읽어내고, Model_Block 형태로 변환, Model_Block 하나하나 TextArea에 넣
	 */
	private Controller_File_IO controller_file_IO;
	private Model_File file;
	@FXML
	private ListView<TextArea> listView_left;
	
	private ObservableList<TextArea> data = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//setDatas();
		
	}
	
	public void setDatas(){
		//ta.setPrefSize(ta.getParent().getScaleX(), ta.getParent().getScaleY());
		
		file = controller_file_IO.getFiles().get(controller_file_IO.getFiles().size()-1);
		TextArea ta = new TextArea();
        for(int i = 0 ; i < file.getLines().size(); i++){
           	ta.appendText(file.getLines().get(i).getValue());
        }
        data.add(ta);
        listView_left.setItems(data);
	}
	
	public void showBlocks(){
		data.clear();
		ObservableList<Model_Block> blocks = controller_file_IO.getBlocks();
		for(int i = 0 ; i < blocks.size() ; i++){
			TextArea ta = new TextArea();
			ArrayList<Integer> index = blocks.get(i).getLeftLineInfo();
			for(int j = 0 ; j < index.size() ; j++){
				ta.appendText(file.getLines().get(index.get(j)).getValue());
			}
			data.add(ta);
        }
        listView_left.setItems(data);
	}
	
	public void setControllerFileIO(Controller_File_IO controller_file_IO){
		this.controller_file_IO = controller_file_IO;
		//System.out.println(controller_file_IO.toString());
	}
	
	public void foo(String foo){
		controller_file_IO.saidSomething();
	} 
}
