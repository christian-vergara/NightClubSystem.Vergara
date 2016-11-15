package Controller;

import Model.*;
import View.EmployeeHomeView;
import View.MainView;
import javafx.scene.control.Alert;

/**
 * Created by chris on 11/9/2016.
 */
public class MainController {

    private MainView view;
    private static User currentUser;

    public MainController(UserBag userBag, MainView view) {
        this.view = view;
        view.setLoginButtonListener(new MyEventListener() {
            @Override
            public void btnClicked(MyEventObject ev) {
                loginPress();
            }

            public void loginPress() {
//                    if (verifyLogin() instanceof Employee && ((Employee) verifyLogin()).getRank().equals("Owner")) {
//                        System.out.println("Owner");
//                        currentUser = verifyLogin();
//                    }
//                    else if (verifyLogin() instanceof Employee && ((Employee) verifyLogin()).getRank().equals("Manager")) {
//                        System.out.println("Manager");
//                        currentUser = verifyLogin();
//                    }
//                    else if (verifyLogin() instanceof Employee && ((Employee) verifyLogin()).getRank().equals("General")) {
//                        System.out.println("General");
//                        currentUser = verifyLogin();
//                        EmployeeHomeView employeeHomeView = new EmployeeHomeView(App.App.getPrimaryStage());
//                    }
//                    else if(verifyLogin() instanceof Customer){
//                        System.out.println("Customer");
//                        currentUser = verifyLogin();
//                    } else {
//                        System.out.println("Error");
//                        alertUser();
//                    }

                currentUser = verifyLogin();
                EmployeeHomeView employeeHomeView = new EmployeeHomeView(App.App.getPrimaryStage());
            }


        });
    }


    public User verifyLogin() {
        //return UserBag.getUserBagClass().verifyLogin(view.getUserField().getText(), view.getPassField().getText());
        return  UserBag.getUserBagClass().verifyLogin("mc12", "mc12");
    }

    public void alertUser() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid Username/Password!");
        alert.setContentText("Please try entering your info again.");
        alert.showAndWait();
        view.getPassField().clear();
    }

    public MainView getView() {
        return view;
    }

    public void setView(MainView view) {
        this.view = view;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        MainController.currentUser = currentUser;
    }
}






