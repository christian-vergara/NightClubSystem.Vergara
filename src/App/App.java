package App;

import Controller.Login.LoginController;

import Model.Bags.ItemBag;
import Model.Bags.TableBag;
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
    private static TableBag tableBag = new TableBag();
    private static AddUser addUser;

    public static void main(String args[]) {


        User m1 = new Employee("Joseph", "Example", "jd1221", "password", "Manager", "Salary", 55000, "NA", "NA");
        launch(args);
        //TEMP USERS FOR QUICK LOGIN
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        App.primaryStage = primaryStage;
        LoginView view = new LoginView(primaryStage);
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.setTitle("Night Club Manager");


    }





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

    public static TableBag getTableBag() {
        return tableBag;
    }
}
