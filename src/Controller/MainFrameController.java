
package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.jws.soap.SOAPBinding.Use;

import Controller.Controller_File_IO;
import View.MainFrame;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class MainFrameController implements Initializable {

	private MainFrame mainFrame;
	private CompareCode compareCode;
	private Controller_File_IO controller_file_IO;
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
	@FXML
	private Parent split_text_frame;
	@FXML
	private SplitPaneController split_text_frameController; 		//Nested Controllers
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		buttonBar_main = null;
		button_compare = null;
		splitMenu_merge = null;
		menuItem_lefttoright = null;
		menuItem_righttoleft = null;
		
		controller_file_IO = new Controller_File_IO();
		split_text_frameController.setControllerFileIO(controller_file_IO);
	}
	
	@FXML
 	public void compareOnAction(){
 		compareCode = new CompareCode(controller_file_IO);
 		compareCode.foo();
 		System.out.println("COMPARE!");
 		ListViewLeftController lc = split_text_frameController.getListViewLeftController();
 		ListViewRightController rc = split_text_frameController.getListViewRightController();
 		ScrollbarBinding.bind(lc.getListViewLeft(), rc.getListViewRight());
 		lc.showBlocks();
 		rc.showBlocks();
 	}
	
	@FXML
	public void lefttorightOnAction(){
		System.out.println("Left To Right MERGE!");
	}
	
	@FXML
	public void righttoleftOnAction(){
		System.out.println("Right To Left MERGE!");
	}	
	
	public void setMainFrame(MainFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	
}
