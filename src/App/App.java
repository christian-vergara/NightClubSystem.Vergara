package App;

import Controller.Login.LoginController;

import Model.Bags.ItemBag;
import Model.Bags.TableBag;
import Model.Objects.Customer;
import Model.Objects.Employee;
import Model.Objects.User;
import Model.Bags.UserBag;
import Model.OpenBin;
import Model.SaveBin;
import View.MainView.LoginView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

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

        try {
            OpenBin.openFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        User m1 = new Employee("Joseph", "Example", "jd1221", "password", "Manager", "Salary", 55000, "NA", "NA");
        User e1 = new Employee("Joe", "Brown", "employee", "employee", "General", "Hourly", 24.50, "11/9/16", "11/10/16");
        User c1 = new Customer("David", "Appleseed", "customer", "customer" );
        User o1 = new Employee("Johnny", "James", "owner", "owner", "Owner", "Salary", 100000, "NA", "NA");
        User m2 = new Employee("Manager", "Example", "manager", "manager", "Manager", "Salary", 55000, "12/7/14", "NA");

        launch(args);
        //TEMP USERS FOR QUICK LOGIN
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        App.primaryStage = primaryStage;
        LoginView view = new LoginView(primaryStage);
        primaryStage.setOnCloseRequest(e -> {
            Alert save = new Alert(Alert.AlertType.CONFIRMATION);
            save.setTitle("Save?");
            save.setHeaderText("Would you like to save changes before exiting?");

            Optional<ButtonType> result = save.showAndWait();
            if(result.get() == ButtonType.OK){
                try {
                    SaveBin.save();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                Platform.exit();
            } else{
                Platform.exit();
            }

        });
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

    public static void setUserBag(UserBag userBag) {
        App.userBag = userBag;
    }

    public static void setItemBag(ItemBag itemBag) {
        App.itemBag = itemBag;
    }

    public static void setTableBag(TableBag tableBag) {
        App.tableBag = tableBag;
    }


}
