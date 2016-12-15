package App;

import Controller.Login.LoginController;

import Model.Bags.ItemBag;
import Model.Objects.Employee;
import Model.Objects.User;
import Model.Bags.UserBag;
import View.MainView.LoginView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * Created by chris on 11/9/2016.
 */
public class App extends Application{

    private static Stage primaryStage;
    private static UserBag userBag = new UserBag();
    private static ItemBag itemBag = new ItemBag();

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        App.primaryStage = primaryStage;
        LoginView view = new LoginView(primaryStage);
        LoginController controller = new LoginController(userBag, view);
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.setTitle("Night Club Manager");
    }


    AddUser a = new AddUser();
    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        App.primaryStage = primaryStage;
    }

    public static UserBag getUserBag() {
        return userBag;
    }

    public static ItemBag getItemBag() {
        return itemBag;
    }
}
