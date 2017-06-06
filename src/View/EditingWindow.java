package View;

import java.io.IOException;

import Controller.FileIOController;
import Model.Model_File;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EditingWindow{
	
    public EditingWindow(Model_File file) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/EditTextArea.fxml"));
        Parent root = null;

        try {
			root = loader.load();
			Stage stage = new Stage();
			stage.setTitle("Editing Window");
			stage.setScene(new Scene(root, 450, 450));
			stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}