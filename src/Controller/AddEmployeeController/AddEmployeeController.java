package Controller.AddEmployeeController;

import Model.Objects.Employee;
import Model.Objects.User;
import View.AddView.AddEmployeeView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Created by Studio on 12/13/2016.
 */
public class AddEmployeeController {

    public AddEmployeeController(AddEmployeeView addEmployeeView) {
        addEmployeeView.setAddEmployeeListener(new AddEmployeeListener() {
            @Override
            public void btnClicked(AddEmployeeEventObject ev) {
                Alert confirmAdd = new Alert(Alert.AlertType.CONFIRMATION);
                confirmAdd.setTitle("Confirm");
                confirmAdd.setHeaderText("Add New Employee");
                confirmAdd.setContentText("Would you like to add this Employee?");
                confirmAdd.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        User e = new Employee(ev.getfName(), ev.getlName(), ev.getuName(), ev.getPass(),
                                ev.getRank(), ev.getPayType(), ev.getPay(), ev.getHiringDate(), "NA");
                        addEmployeeView.getfNameField().clear();
                        addEmployeeView.getlNameField().clear();
                        addEmployeeView.getuNameField().clear();
                        addEmployeeView.getPassField().clear();
                        addEmployeeView.getRankField().clear();
                        addEmployeeView.getPayTypeField().clear();
                        addEmployeeView.getPayField().clear();
                        addEmployeeView.getHiringDateField().clear();
                        addEmployeeView.getUserIdField().setText(Integer.toString(User.getCount()));
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Added!");
                        alert.setHeaderText("Employee added!");
                        alert.showAndWait();
                    }
                });

            }
        });
    }

}
