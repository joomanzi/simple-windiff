package Controller;

import Controller.Controller_File_IO;

public class EditController {

	private boolean editFlag = false;
	
	public EditController(Controller_File_IO controller_File_IO){}
	
	public void stateChanger(){
		
		if(!this.editFlag){
			this.editFlag = true;
		}
		else{
			this.editFlag = false;
		}
	}
}
