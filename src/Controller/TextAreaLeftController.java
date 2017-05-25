
package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
<<<<<<< HEAD
import javafx.scene.control.TextArea;

public class TextAreaLeftController implements Initializable {
	
	@FXML
	private TextArea textArea_left;
=======
import javafx.scene.control.*;

public class TextAreaLeftController implements Initializable {

	/*TEST*/
	ArrayList<String> test1 = new ArrayList<String>();
	
	
	@FXML
	TextArea textArea_left;
>>>>>>> a767bd64df522f920ea76ddf337d3d43c99c48b0
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		textArea_left = null;
=======
		
		textArea_left.setEditable(false); //SplitPane에서 해야할듯
		//textArea_left.setDisable(true);  //아예 안보임 -> 파일을 load하면 false로 바뀌게끔
										  //close하면 setDisable true상태로바꿈
		//textArea_left.setVisible(true); //
		
		//textArea_left.requestFocus(); //커서재배치
		
		setString();
		setTextArea(test1);
>>>>>>> a767bd64df522f920ea76ddf337d3d43c99c48b0
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
			textArea_left.appendText(str.get(i)); //setText는 text변경 appendText는 text추가
		}
	}
	
}
