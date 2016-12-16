package Controller.AddEntertainerController;

import Model.Objects.Entertainer;
import Model.Objects.User;
import View.AddView.AddEntertainerView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Created by Studio on 12/12/2016.
 */
public class AddEntertainerController {
    public AddEntertainerController(AddEntertainerView addEntertainerView) {

        addEntertainerView.setAddEntertainerListener(eventObject -> {
            Alert confirmAdd = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAdd.setTitle("Confirm");
            confirmAdd.setHeaderText("Add New Entertainer");
            confirmAdd.setContentText("Would you like to add this entertainer?");
            confirmAdd.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    User e = new Entertainer(eventObject.getfName(), eventObject.getlName(), eventObject.getuName(), eventObject.getPass(),
                            eventObject.getType(), eventObject.getPay(), 0, "0");
                    addEntertainerView.getfNameField().clear();
                    addEntertainerView.getlNameField().clear();
                    addEntertainerView.getuNameField().clear();
                    addEntertainerView.getPassField().clear();
                    addEntertainerView.getTypeField().clear();
                    addEntertainerView.getPayField().clear();
                    addEntertainerView.getUserIdField().setText(Integer.toString(User.getCount()));
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Added!");
                    alert.setHeaderText("Entertainer Added!");
                    alert.showAndWait();
                }
            });

        });
    }
}

