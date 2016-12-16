package Controller.Login;

import App.App;
import Model.Bags.UserBag;
import Model.Objects.Customer;
import Model.Objects.Employee;
import Model.Objects.User;
import View.CustomerHomeView.CustomerHomeView;
import View.EmployeeHomeView.EmployeeHomeView;
import View.MainView.LoginView;
import View.ManagerHomeView.ManagerHomeView;
import javafx.scene.control.Alert;

/**
 * Created by chris on 11/9/2016.
 */
public class LoginController {

    private LoginView view;
    private static User currentUser;

    public LoginController(LoginView view) {
        this.view = view;
        view.setLoginButtonListener((LoginEventObject ev) -> {
            setCurrentUser(ev.getUserId());
            if (ev.getType().equals("emp")) {
                System.out.println("Success");
                if(((Employee) currentUser).getRank().equals("General")){
                    EmployeeHomeView employeeHomeView = new EmployeeHomeView(App.getPrimaryStage());
                } else if (((Employee) currentUser).getRank().equals("Manager")) {
                    ManagerHomeView managerHomeView = new ManagerHomeView(App.getPrimaryStage());
                } else if (((Employee) currentUser).getRank().equals("Owner")) {
                    ManagerHomeView managerHomeView = new ManagerHomeView(App.getPrimaryStage());
                }
            } else if (ev.getType().equals("cust")) {
                CustomerHomeView customerHomeView = new CustomerHomeView(App.getPrimaryStage());
                customerHomeView.setCurrent((Customer) currentUser);
            }
                //Temp for quick login
                //EmployeeHomeView employeeHomeView = new EmployeeHomeView(App.App.getPrimaryStage());

            });
        }


    public boolean verifyLogin(String userName, String pass) {
        //REMEMBER TO UNCOMMENT THIS IS JUST FOR QUICK LOGIN*****
        if(App.getUserBag().verifyLogin(userName, pass) != null);
        return true;

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

    public static void setCurrentUser(int index) {
        currentUser = App.getUserBag().findUser(index);
    }
}






