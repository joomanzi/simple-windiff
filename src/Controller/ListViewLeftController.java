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
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
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
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.scene.control.ListCell;

public class ListViewLeftController implements Initializable {
	/*TODO
	 * FXML濡� TextArea吏쒓린
	 * Model_File �씫�뼱�궡怨�, Model_Block �삎�깭濡� 蹂��솚, Model_Block �븯�굹�븯�굹 TextArea�뿉 �꽔
	 */
	private Controller_File_IO controller_file_IO;
	private Model_File file;
	@FXML
	private ListView<TextArea> listView_left;
	
	@FXML
	private TextArea ta;
	private Text textHolder;
	private double oldHeight = 0;
	@FXML
	private ObservableList<TextArea> data = FXCollections.observableArrayList();
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ListViewLeftController.class.getResource("/View/BlockTextArea.fxml"));
			ta = (TextArea) loader.load();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void setDatas(){
		file = controller_file_IO.getLeftFile();
		ta = new TextArea();
		ta.setWrapText(true);
		textHolder = new Text();
        textHolder.textProperty().bind(ta.textProperty());
        textHolder.layoutBoundsProperty().addListener(new ChangeListener<Bounds>() {
            @Override
            public void changed(ObservableValue<? extends Bounds> observable, Bounds oldValue, Bounds newValue) {
                if (oldHeight != newValue.getHeight()) {
                    System.out.println("newValue = " + newValue.getHeight());
                    oldHeight = newValue.getHeight();
                    ta.setPrefHeight(textHolder.getLayoutBounds().getHeight() + 20); // +20 is for paddings
                }
            }
        });
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
			ta = new TextArea();
			ArrayList<Integer> index = blocks.get(i).getLeftLineInfo();
			ta.setWrapText(true);
			textHolder = new Text();
	        textHolder.textProperty().bind(ta.textProperty());
	        textHolder.layoutBoundsProperty().addListener(new ChangeListener<Bounds>() {
	            @Override
	            public void changed(ObservableValue<? extends Bounds> observable, Bounds oldValue, Bounds newValue) {
	                if (oldHeight != newValue.getHeight()) {
	                    System.out.println("newValue = " + newValue.getHeight());
	                    oldHeight = newValue.getHeight();
	                    ta.setPrefHeight(textHolder.getLayoutBounds().getHeight() + 20); // +20 is for paddings
	                }
	            }
	        });
			if(blocks.get(i).isSame() == false){
				ta.setStyle("-fx-control-inner-background:yellow");
			}
			for(int j = 0 ; j < index.size() ; j++){
				ta.appendText(file.getLines().get(index.get(j)).getValue());
			}
			data.add(ta);
        }
		listView_left.autosize();
        listView_left.setItems(data);
	}
	
	public void setControllerFileIO(Controller_File_IO controller_file_IO){
		this.controller_file_IO = controller_file_IO;
	}
	public ListView<TextArea> getListViewLeft(){
		return this.listView_left;
	}
	
	@FXML
	public void onListViewLeftMouseClicked(){
		int index = listView_left.getSelectionModel().getSelectedIndex();
		System.out.println("BlockIdx : " + index);
	}
	
}
