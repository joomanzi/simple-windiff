package View;

import java.io.IOException;

import Controller.MainFrameController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainFrame extends Application {

	private Stage primaryStage;
    private BorderPane mainFrameLayout;
    private MainFrameController mainFrameController;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("SimpleMerge");

        initMainLayout();
    }

    public void initMainLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainFrame.class.getResource("/View/MainFrameLayout.fxml"));
            mainFrameLayout = (BorderPane) loader.load();

            Scene scene = new Scene(mainFrameLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            mainFrameController = loader.getController();
            mainFrameController.setMainFrame(this);
            
            
            /*
            Parent loader = FXMLLoader.load(getClass().getResource("../View/MainFrameLayout.fxml"));
            primaryStage.setTitle("Simple Merge");
            primaryStage.setScene(new Scene(loader));
            primaryStage.show(); */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }

	public static void main(String[] args) {
		launch(args);
	}
}
