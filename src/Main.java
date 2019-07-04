
import java.io.IOException;

import com.db.Db;
import com.gui.MainGUI;
import com.service.UserService;

class Main {

	public static void main(String[] args) throws IOException {
		Db.readFromFile();
		new Db().writeToFile();
		UserService.periodicallySendEmail();
		UserService.periodicallyWriteToDb();
		UserService.clearYesterdayUnavailable();
		new MainGUI().setVisible(true);

	}

}
