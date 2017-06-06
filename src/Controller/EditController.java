package Controller;

import Controller.FileIOController;

public class EditController {

	private boolean editFlag = false;
	
	public EditController(FileIOController controller_File_IO){}
	
	public void stateChanger(){
		
		if(!this.editFlag){
			this.editFlag = true;
		}
		else{
			this.editFlag = false;
		}
	}
}
