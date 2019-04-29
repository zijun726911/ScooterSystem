

import java.io.IOException;

import com.db.Db;
import com.gui.MainGUI;

class Main {
	
	
	
	public static void main(String[] args) throws IOException {
		Db.readFromFile();
		new MainGUI().setVisible(true);
		
		
		
		
//        System.out.println(Main.class.getResource("Main.class").getFile()); 
		
	
	}

	

}
