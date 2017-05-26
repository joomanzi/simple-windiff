package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Model.Model_Block;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ListViewLeftController implements Initializable {
	
	@FXML
	private ListView<Model_Block> listView_left;
	
	private ObservableList<Model_Block> listItems;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		listView_left = new ListView<>();
		listItems = FXCollections.observableArrayList(
				new Model_Block(),
				new Model_Block()
				);
		listItems.get(0).setNameForTest("model first");
		listItems.get(1).setNameForTest("model Second");
		
		listView_left.setEditable(true);
		listView_left.setItems(listItems);
		
		System.out.println(listView_left.getItems().get(0).getNameForTest());
        /*listView_left.setCellFactory(lv -> new ListCell<Model_Block>() {
            private TextField textField = new TextField() ;

            {
                textField.setOnAction(e -> {
                    commitEdit(getItem());
                });
                textField.addEventFilter(KeyEvent.KEY_RELEASED, e -> {
                    if (e.getCode() == KeyCode.ESCAPE) {
                        cancelEdit();
                    }
                });
            }

            @Override
            protected void updateItem(Model_Block model, boolean empty) {
                super.updateItem(model, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else if (isEditing()) {
                    textField.setText(model.getNameForTest());
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(model.getNameForTest());
                    setGraphic(null);
                }
            }

            @Override
            public void startEdit() {
                super.startEdit();
                textField.setText(getItem().getNameForTest());
                setText(null);
                setGraphic(textField);
                textField.selectAll();
                textField.requestFocus();
            }

            @Override
            public void cancelEdit() {
                super.cancelEdit();
                setText(getItem().getNameForTest());
                setGraphic(null);
            }

            @Override
            public void commitEdit(Model_Block model) {
                super.commitEdit(model);
                model.setNameForTest(textField.getText());
                setText(textField.getText());
                setGraphic(null);
            }
        });*/
        
        listView_left.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                listView_left.getItems().forEach(p -> System.out.println(p.getNameForTest()));
            }
        });
        
	}
	public void foo(String foo){
		System.out.println("foo");
	}
	
}
