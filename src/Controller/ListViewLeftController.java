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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
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
	private FileIOController fileIOController;
//	private Model_File file;

	@FXML
	private ListView<Model_Block> listView_left;
	@FXML
	private ObservableList<Model_Block> listItems = FXCollections.observableArrayList();
	@FXML
	private Model_File file;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
        listView_left.setCellFactory(new Callback<ListView<Model_Block>, ListCell<Model_Block>>() {
            @Override
            public ListCell<Model_Block> call(ListView<Model_Block> p) {
 
                ListCell<Model_Block> cell = new ListCell<Model_Block>() {
                    @Override
                    protected void updateItem(Model_Block t, boolean empty) {
                        super.updateItem(t, empty); 
                        if (t != null) {
                        	int blankNum = t.getLeftBlank();
                        	StringBuilder sb = new StringBuilder();
                        	if(!t.isModified()){
	                        	for(int j = 0 ; j < t.getLeftLineInfo().size() ; j++){
	                        		sb.append(file.getLines().get((t.getLeftLineInfo().get(j))).getValue()+"\t\n");
	                        	}
	                        	for(int j = 0 ; j < blankNum ; j++){
	                        		sb.append("\t\n");
	                        	}
                        	}else if(t.isModified() && t.getFlag()==1){
                        		System.out.println("when t is modified as right to left");
	                        	for(int j = 0 ; j < t.getLeftLineInfo().size() ; j++){
		                        	sb.append(fileIOController.getRightFile().getLines().get((t.getLeftLineInfo().get(j))).getValue()+"\t\n");
		                       	}
                        	}else if(t.isModified() && t.getFlag()==2){
	                        	for(int j = 0 ; j < t.getLeftLineInfo().size() ; j++){
	                        		sb.append(file.getLines().get((t.getLeftLineInfo().get(j))).getValue()+"\n");
	                        	}
                        	}
                        	if(!t.isSame()&&fileIOController.getBlocks().size()>1){
                       		
                         		this.setStyle("-fx-background-color : yellow");
 	
                        	}
                        	this.setText(sb.toString());
                        }
                    }
                };
                return cell;
            }
        });
        listView_left.setItems(listItems);
        
	}
	
	public void showFile(){
		file = fileIOController.getLeftFile();
		listItems = fileIOController.getBlocks();
		
		Model_Block initBlock;
		if(listItems.isEmpty()){
			initBlock = new Model_Block(file, null);
			listItems.add(initBlock);
		}else{
			initBlock = listItems.get(0);
			ArrayList<Integer> al = new ArrayList<Integer>();
			for (int i = 0 ; i < file.getLines().size() ; i++){
				al.add(i);
			}
			initBlock.setLeftLineInfo(al);
		}
		
		for(int i = 0 ; i < initBlock.getLeftLineInfo().size() ; i++){
			//	System.out.println(initBlock.getLeftLineInfo().get(i));
			}
		listView_left.setItems(listItems);
	}
	
	public void showBlocks(){
		ObservableList<Model_Block> blocks = fileIOController.getBlocks();
		for(int i = 0 ; i < blocks.size() ; i++){
			listItems.add(blocks.get(i));
		}
		listView_left.autosize();
        listView_left.setItems(listItems);
	}
	
	public void setControllerFileIO(FileIOController fileIOController){
		this.fileIOController = fileIOController;
	}
	public ListView<Model_Block> getListViewLeft(){
		return this.listView_left;
	}
	
	
	@FXML
	public void onListViewLeftMouseClicked(){
		int index = listView_left.getSelectionModel().getSelectedIndex();

		System.out.println("BlockIdx : " + index);
		fileIOController.setSelectedBlockIndex(index);
		//listView_right.getSelectionModel().select(index);
		
		
		
	}
	
	
	
	
}
