package App;

import Controller.MainController;

import Model.Employee;
import Model.User;
import Model.UserBag;
import View.MainView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * Created by chris on 11/9/2016.
 */
public class App extends Application{

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainView view = new MainView(primaryStage);
        MainController controller = new MainController(UserBag.getUserBagClass(), view);
        User e1 = new Employee("Joe", "McMullan", "mc12", "mc12", "Shmuck", "Hourly", 24.50, "11/9/16", "11/10/16");

        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.setTitle("Night Club Manager");
    }
}
