package View;

import java.io.IOException;

import Controller.EditTextAreaController;
import Controller.FileIOController;
import Model.Model_File;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class EditingWindow extends Stage{
	FXMLLoader loader;
	EditTextAreaController editTextAreaController;
    public EditingWindow(Model_File file) {
        Parent root = null;
        loader = new FXMLLoader(getClass().getResource("/View/EditTextArea.fxml"));
        try {
			root = loader.load();
			
			this.setTitle("Editing Window");
			this.setScene(new Scene(root, 800, 600));
			this.show();
			editTextAreaController = loader.getController();
			editTextAreaController.setFileText(file);
			this.setOnCloseRequest(new EventHandler<WindowEvent>() {
		          public void handle(WindowEvent we) {
		        	  editTextAreaController.changeEditedFile();
		        	  editTextAreaController.showStat();		        	  
		          }
		      });    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
  
    public Object getEditTextAreaController(){
    	return loader.getController();
    }
}