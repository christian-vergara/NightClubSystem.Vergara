package Controller.ViewEmployeeController;

import Model.Objects.Employee;
import Model.Objects.User;
import View.AddView.AddEmployeeView;
import View.ViewView.ViewEmployeeView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Created by Studio on 12/13/2016.
 */
public class ViewEmployeeController {

    public ViewEmployeeController(ViewEmployeeView viewEmployeeView, Employee employee) {
        viewEmployeeView.setViewEmployeeListener(new ViewEmployeeListener() {
            @Override
            public void btnClicked(ViewEmployeeEventObject ev) {
                Alert confirmAdd = new Alert(Alert.AlertType.CONFIRMATION);
                confirmAdd.setTitle("Confirm");
                confirmAdd.setHeaderText("Update Employee");
                confirmAdd.setContentText("Would you like to update this Employee?");
                confirmAdd.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        employee.setfName(ev.getfName());
                        employee.setlName(ev.getlName());
                        employee.setUserName(ev.getuName());
                        employee.setPassword(ev.getPass());
                        employee.setPay(ev.getPay());
                        employee.setHiringDate(ev.getHiringDate());
                        employee.setLeaveDate(ev.getLeaveDate());
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Updated!");
                        alert.setHeaderText("Employee Successfully Updated!");
                        alert.showAndWait();
                    }
                });

            }
        });
    }

}
