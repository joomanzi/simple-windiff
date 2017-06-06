
package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import Controller.FileIOController;
import Model.Model_File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;

public class SplitPaneController implements Initializable {
	private static int FILE_LEFT = 0;
	private static int FILE_RIGHT = 1;
	private FileIOController fileIOController;
	
	@FXML
	private SplitPane split_text_frame;
	@FXML
	private BorderPane border_left_frame, border_right_frame;
	@FXML
	private MenuBar menuBar_left, menuBar_right;
	@FXML
	private Menu menu_left_file, menu_left_edit,
				menu_right_file, menu_right_edit;
	@FXML
	private MenuItem menuItem_left_load, menuItem_left_save, menuItem_left_saveas, menuItem_left_close, menuItem_left_edit,
					menuItem_right_load, menuItem_right_save, menuItem_right_saveas, menuItem_right_close, menuItem_right_edit;
	@FXML
	private TextField textField_left, textField_right;
	@FXML
	private Parent listView_left;
	@FXML
	private ListViewLeftController listView_leftController;
	@FXML
	private ListViewRightController listView_rightController;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		menuBar_left = null; menuBar_right = null;
		menu_left_file = null; menu_left_edit = null; menu_right_file = null; menu_right_edit = null;
		menuItem_left_load = null; menuItem_left_save = null; menuItem_left_saveas = null; menuItem_left_close = null; menuItem_left_edit = null;
		menuItem_right_load = null; menuItem_right_save = null; menuItem_right_saveas = null; menuItem_right_close = null; menuItem_right_edit = null;
		textField_left = null; textField_right = null;
	
		//textArea_left.setDisable(true);  //占싣울옙 占싫븝옙占쏙옙 -> 占쏙옙占쏙옙占쏙옙 load占싹몌옙 false占쏙옙 占쌕뀐옙途
	}
	
	@FXML
 	public void leftLoadOnAction(){
		
		FileChooser filechooser = myFileChooser("Left FileChooser");
		File file = filechooser.showOpenDialog(null);
		
		try {
			fileIOController.fileLoad(file.getAbsolutePath().toString(), FILE_LEFT);
			listView_leftController.showFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//load占쌀띰옙 占쌩븝옙占싯삼옙 flag占쏙옙占쏙옙 占십울옙
		//load占쏙옙占쏙옙占쏙옙 textArea disable true -> false占쏙옙
		//load占쏙옙占쏙옙占쏙옙 edit button 활占쏙옙화(占쏙옙占시삼옙占쏙옙)
		
		
 		System.out.println("Left LOAD!");
	}
	
	@FXML
 	public void leftSaveOnAction() throws IOException{
		this.fileIOController.fileSave(FILE_LEFT);
 		System.out.println("Left SAVE!");
	}
	
	@FXML
 	public void leftSaveasOnAction(){
 		System.out.println("Left SAVEAS!");
	}
	
	@FXML
 	public void leftCloseOnAction(){
 		System.out.println("Left CLOSE!");
 		Alert alert = new Alert(AlertType.WARNING, 
 				"No file to close", 
                ButtonType.YES, ButtonType.NO);

 		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.YES){
			alert.close();
		} else {
			alert.close();
		}
	}
	
	@FXML
 	public void leftEditOnAction(){
 		System.out.println("Left EDIT!");
 		try {
 			fileIOController.getBlocks().clear();
			fileIOController.fileLoad(fileIOController.getLeftFile().getfileName(), FILE_LEFT);
			fileIOController.fileLoad(fileIOController.getRightFile().getfileName(), FILE_RIGHT);
			listView_leftController.showFile();
			listView_rightController.showFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
 	public void rightLoadOnAction(){
		System.out.println("Right LOAD!");
		FileChooser filechooser = myFileChooser("Right FileChooser");
		File file = filechooser.showOpenDialog(null);
		
		try {
			fileIOController.fileLoad(file.getAbsolutePath().toString(), FILE_RIGHT);
			listView_rightController.showFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@FXML
 	public void rightSaveOnAction(){
 		System.out.println("Right SAVE!");
	}
	
	@FXML
 	public void rightSaveasOnAction(){
 		System.out.println("Right SAVEAS!");
	}
	
	@FXML
 	public void rightCloseOnAction(){
		System.out.println("Right CLOSE!");
 		Alert alert = new Alert(AlertType.WARNING, 
                "No file to close", 
                ButtonType.YES, ButtonType.NO);

 		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.YES){
			alert.close();
		} else {
			alert.close();
		}
	}
	
	@FXML
 	public void rightEditOnAction(){
		try {
 			fileIOController.getBlocks().clear();
			fileIOController.fileLoad(fileIOController.getLeftFile().getfileName(), FILE_LEFT);
			fileIOController.fileLoad(fileIOController.getRightFile().getfileName(), FILE_RIGHT);
			listView_leftController.showFile();
			listView_rightController.showFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setControllerFileIO(FileIOController fileIOController){
		this.fileIOController = fileIOController;
		listView_leftController.setControllerFileIO(fileIOController);
		listView_rightController.setControllerFileIO(fileIOController);
		
	}
	
	public ListViewLeftController getListViewLeftController(){
		return this.listView_leftController;
	}
	public ListViewRightController getListViewRightController(){
		return this.listView_rightController;
	}
	
	public void foo(String foo) {
	       System.out.println(foo);
	    }
	/*FileChooser*/
	FileChooser myFileChooser(String name){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle(name);
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("All Files","*.txt","*.c","*.java"),
				new FileChooser.ExtensionFilter("Text Files","*.txt")
				);
		return fileChooser;
	}

	


}
