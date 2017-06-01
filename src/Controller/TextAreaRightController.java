
package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class TextAreaRightController implements Initializable {

	ArrayList<String> test1 = new ArrayList<String>();
	@FXML
	private TextArea textArea_right;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		setString();
		setTextArea(test1);
	}
	
	public void setString(){
		test1.add("AADDGGSSBB\r\n");
		test1.add("null\r\n");
		test1.add("null\r\n");
		test1.add("aabbsseedd\r\n");
		test1.add("11ggccgg2\r\n");
		test1.add("END\r\n");
	}

	public void setTextArea(ArrayList<String> str){
		
		for(int i=0;i<str.size();i++){
			textArea_right.appendText(str.get(i)); //setText�� text���� appendText�� text�߰�
		}
	}
	
}
