package Controller.Login;

import Model.Bags.UserBag;
import Model.Objects.User;
import View.EmployeeHomeView.EmployeeHomeView;
import View.MainView.LoginView;
import javafx.scene.control.Alert;

/**
 * Created by chris on 11/9/2016.
 */
public class LoginController {

    private LoginView view;
    private static User currentUser;

    public LoginController(UserBag userBag, LoginView view) {
        this.view = view;
        view.setLoginButtonListener(new LoginEventListener() {
            @Override
            public void btnClicked(LoginEventObject ev) {
                loginPress();
            }

            //Verifying Login Info
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
                //Temp for quick login
                EmployeeHomeView employeeHomeView = new EmployeeHomeView(App.App.getPrimaryStage());
            }


        });
    }


    public User verifyLogin() {
        //REMEMBER TO UNCOMMENT THIS IS JUST FOR QUICK LOGIN*****
        //return UserBag.getUserBagClass().verifyLogin(view.getUserField().getText(), view.getPassField().getText());
        return UserBag.getUserBagClass().verifyLogin("mc12", "mc12");
    }

    public void alertUser() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid Username/Password!");
        alert.setContentText("Please try entering your info again.");
        alert.showAndWait();
        view.getPassField().clear();
    }

    public LoginView getView() {
        return view;
    }

    public void setView(LoginView view) {
        this.view = view;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        LoginController.currentUser = currentUser;
    }
}






