package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;

import Model.Model_Block;
import Model.Model_File;
import View.MainFrame;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener.Change;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.geometry.Orientation;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
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
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.scene.control.ListCell;
public class ListViewRightController implements Initializable {
	/*TODO
	 * FXML濡� TextArea吏쒓린
	 * Model_File �씫�뼱�궡怨�, Model_Block �삎�깭濡� 蹂��솚, Model_Block �븯�굹�븯�굹 TextArea�뿉 �꽔
	 */
	private Controller_File_IO controller_file_IO;
	@FXML
	private ListView<String> listView_right;
	@FXML
	private ObservableList<String> listItems = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void showFile(){
		Model_File file = controller_file_IO.getRightFile();
		listView_right.setPrefHeight(listItems.size()*15+2);
		listItems.addListener(new ListChangeListener(){
			@Override
			public void onChanged(Change c) {
				// TODO Auto-generated method stub
				 listView_right.setPrefHeight(listItems.size() * 15+ 2);
			}
		});
		for(int i = 0 ; i < file.getLines().size(); i++){
	           	listItems.add(file.getLines().get(i).getValue());
	        }
		 listView_right.setItems(listItems);
		
	}
	
	public void showBlocks(){
		Model_File file = controller_file_IO.getRightFile();
		listItems.clear();
		ObservableList<Model_Block> blocks = controller_file_IO.getBlocks();
		for(int i = 0 ; i < blocks.size() ; i++){
			ArrayList<Integer> index = blocks.get(i).getRightLineInfo();
			int blankNum = blocks.get(i).getRightBlank();

			StringBuilder sb = new StringBuilder();
			for(int j = 0 ; j < index.size() ; j++){
				sb.append(file.getLines().get(index.get(j)).getValue()+"\n");
			}
			for(int j = 0 ; j < blankNum ; j++){
				sb.append("\n");
			}
			
			listItems.add(sb.toString());
        }
		listView_right.autosize();
        listView_right.setItems(listItems);
	}
	public void setControllerFileIO(Controller_File_IO controller_file_IO){
		this.controller_file_IO = controller_file_IO;
	} 
	public ListView<String> getListViewRight(){
		return this.listView_right;
	}
	
	@FXML
	public void onListViewRightMouseClicked(){
		int index = listView_right.getSelectionModel().getSelectedIndex();
		System.out.println("BlockIdx : "+ index);
	}
}
