import controller.Controller;
import model.SystemModel;
import view.MainWindow;

public class Main {

	public static void main(String[] args) 
	{
		SystemModel model = SystemModel.getSystem();
		MainWindow view = MainWindow.getMainWindow();
		Controller controller = Controller.getController(model, view);
		view.initGui(controller.getCurrentUserType());
	}

}
