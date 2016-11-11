package Controller;

import Model.MyEventListener;
import Model.MyEventObject;
import Model.User;
import Model.UserBag;
import View.MainView;
import javafx.scene.control.Alert;

/**
 * Created by chris on 11/9/2016.
 */
public class MainController {

    public MainController(UserBag userBag, MainView view) {
        view.setLoginButtonListener(new MyEventListener() {
            @Override
            public void btnClicked(MyEventObject ev) {
                loginPress();
            }

            public void loginPress() {
                if (verifyLogin() != null) {
                    if (verifyLogin().getType().matches("emp")) {
                        System.out.print("Hello");
                    } else {
                        alertUser();
                    }
                }
            }

            public User verifyLogin() {
                return UserBag.getUserBagClass().verifyLogin(view.getUserField().getText(), view.getPassField().getText());
            }

            public void alertUser() {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Username/Password!");
                alert.setContentText("Please try again");
                alert.showAndWait();
                view.getPassField().clear();
            }

        });
    }


}






