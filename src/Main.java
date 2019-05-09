

import java.io.IOException;

import com.db.Db;
import com.gui.MainGUI;
import com.service.UserService;

class Main {
	
	
	
	public static void main(String[] args) throws IOException {
		Db.readFromFile();
		
		new UserService().periodicallySendEmail();
		
		new MainGUI().setVisible(true);
		
		
		
		
		
		
	
	}

	

}
