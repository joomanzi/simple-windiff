package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class MainFrameController implements Initializable {

	@FXML
	private BorderPane border_main_frame;
	@FXML
	private ButtonBar buttonBar_main;
	@FXML
	private Button button_compare;
	@FXML
	private SplitMenuButton splitMenu_merge;
	@FXML
	private MenuItem menuItem_lefttoright, menuItem_righttoleft;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		buttonBar_main = null;
		button_compare = null;
		splitMenu_merge = null;
		menuItem_lefttoright = null;
		menuItem_righttoleft = null;
	}
	
	@FXML
 	public void compareOnAction(){
 		System.out.println("COMPARE!");
 	}
	
	@FXML
	public void lefttorightOnAction(){
		System.out.println("Left To Right MERGE!");
	}
	
	@FXML
	public void righttoleftOnAction(){
		System.out.println("Right To Left MERGE!");
	}
	
	
	
	
}

