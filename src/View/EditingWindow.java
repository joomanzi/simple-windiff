package View;

import java.io.IOException;

import Controller.FileIOController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EditingWindow extends Stage{

    public void EditingWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/EditTextArea.fxml"));
        Parent root = null;

        try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Scene scene = new Scene(root);
        
        this.setTitle("Editing Window");
        this.setScene(scene);

      
        this.show();
    }
}