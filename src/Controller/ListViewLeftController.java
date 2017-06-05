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
	private Controller_File_IO controller_file_IO;
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
                    protected void updateItem(Model_Block t, boolean bln) {
                        super.updateItem(t, bln);
                         
                        TextArea ta = new TextArea();
                        if (t != null) {
                        	for(int j = 0 ; j < t.getLeftLineInfo().size() ; j++){
                        		ta.appendText(file.getLines().get((t.getLeftLineInfo().get(j))).getValue());
                        		
                        	}
                            ta.autosize();
                        }
                    }
                };
                return cell;
            }
        });
        listView_left.setItems(listItems);
	}
	
	public void showFile(){
		file = controller_file_IO.getLeftFile();
		listItems = controller_file_IO.getBlocks();
		
		Model_Block initBlock = new Model_Block(file);
		for(int i = 0 ; i < initBlock.getLeftLineInfo().size() ; i++){
			System.out.println(initBlock.getLeftLineInfo().get(i));
		}
		listItems.add(initBlock);
		listView_left.setItems(listItems);
	}
	public void showBlocks(){
		/*listItems.clear();
		ObservableList<Model_Block> blocks = controller_file_IO.getBlocks();
		for(int i = 0 ; i < blocks.size() ; i++){
			ArrayList<Integer> index = blocks.get(i).getLeftLineInfo();
			int blankNum = blocks.get(i).getLeftBlank();

			StringBuilder sb = new StringBuilder();
			for(int j = 0 ; j < index.size() ; j++){
				sb.append(file.getLines().get(index.get(j)).getValue()+"\n");
			}
			for(int j = 0 ; j < blankNum ; j++){
				sb.append("\n");
			}
			listItems.add(sb.toString());
		}
		 listView_left.cell
		listView_left.autosize();
        listView_left.setItems(listItems);*/
	}
	
	public void setControllerFileIO(Controller_File_IO controller_file_IO){
		this.controller_file_IO = controller_file_IO;
	}
	public ListView<Model_Block> getListViewLeft(){
		return this.listView_left;
	}
	
	@FXML
	public void onListViewLeftMouseClicked(){
		int index = listView_left.getSelectionModel().getSelectedIndex();
		System.out.println("BlockIdx : " + index);
	}
	
}
