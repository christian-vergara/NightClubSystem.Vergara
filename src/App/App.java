package App;

import Controller.Main.MainController;

import Model.Objects.Employee;
import Model.Objects.User;
import Model.Bags.UserBag;
import View.MainView.MainView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * Created by chris on 11/9/2016.
 */
public class App extends Application{

    private static Stage primaryStage;

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        App.primaryStage = primaryStage;
        MainView view = new MainView(primaryStage);
        MainController controller = new MainController(UserBag.getUserBagClass(), view);
        User e1 = new Employee("Joe", "McMullan", "mc12", "mc12", "General", "Hourly", 24.50, "11/9/16", "11/10/16");

        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.setTitle("Night Club Manager");
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        App.primaryStage = primaryStage;
    }
}
