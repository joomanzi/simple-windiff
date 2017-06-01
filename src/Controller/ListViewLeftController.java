package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;

import Model.Model_Block;
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
	
	@FXML
	private ListView listView_left;
	
	private ObservableList<TextArea> data = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//setDatas();
		
	}
	
	public void setDatas(){
		TextArea ta = new TextArea();
		
		//ta.setPrefSize(ta.getParent().getScaleX(), ta.getParent().getScaleY());
		
        for(int i = 0 ; i < controller_file_IO.getFiles().get(0).getLines().size(); i++){
        	ta.appendText(controller_file_IO.getFiles().get(0).getLines().get(i).getValue());
        }
        data.add(ta);
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
