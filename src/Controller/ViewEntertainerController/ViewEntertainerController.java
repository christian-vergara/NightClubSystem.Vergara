package Controller.ViewEntertainerController;

import Model.Objects.Entertainer;
import Model.Objects.User;
import View.AddView.AddEntertainerView;
import View.ViewView.ViewEntertainerView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Created by Studio on 12/12/2016.
 */
public class ViewEntertainerController {
    public ViewEntertainerController(ViewEntertainerView view, Entertainer e) {


        view.setViewEntertainerListener(new ViewEntertainerListener() {

            @Override
            public void btnClicked(ViewEntertainerEventObject eventObject) {
                Alert confirmAdd = new Alert(Alert.AlertType.CONFIRMATION);
                confirmAdd.setTitle("Confirm");
                confirmAdd.setHeaderText("Add New Entertainer");
                confirmAdd.setContentText("Would you like to add this entertainer?");
                confirmAdd.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        e.setfName(eventObject.getfName());
                        e.setlName(eventObject.getlName());
                        e.setUserName(eventObject.getuName());
                        e.setPassword(eventObject.getPass());
                        e.setPay(eventObject.getPay());
                        e.setType(eventObject.getType());
                        Alert success = new Alert(Alert.AlertType.INFORMATION);
                        success.setTitle("Success!");
                        success.setHeaderText("Entertainer Updated!");
                        success.showAndWait();
                    }

                });

            }
        });
    }
}

