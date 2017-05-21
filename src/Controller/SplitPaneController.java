package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class SplitPaneController implements Initializable {
	
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
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		menuBar_left = null; menuBar_right = null;
		menu_left_file = null; menu_left_edit = null; menu_right_file = null; menu_right_edit = null;
		menuItem_left_load = null; menuItem_left_save = null; menuItem_left_saveas = null; menuItem_left_close = null; menuItem_left_edit = null;
		menuItem_right_load = null; menuItem_right_save = null; menuItem_right_saveas = null; menuItem_right_close = null; menuItem_right_edit = null;
		textField_left = null; textField_right = null;
		
	}
	
	@FXML
 	public void leftLoadOnAction(){
 		System.out.println("Left LOAD!");
	}
	
	@FXML
 	public void leftSaveOnAction(){
 		System.out.println("Left SAVE!");
	}
	
	@FXML
 	public void leftSaveasOnAction(){
 		System.out.println("Left SAVEAS!");
	}
	
	@FXML
 	public void leftCloseOnAction(){
 		System.out.println("Left CLOSE!");
	}
	
	@FXML
 	public void leftEditOnAction(){
 		System.out.println("Left EDIT!");
	}
	
	
	
	@FXML
 	public void rightLoadOnAction(){
 		System.out.println("Right LOAD!");
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
	}
	
	@FXML
 	public void rightEditOnAction(){
 		System.out.println("Right EDIT!");
	}
}
