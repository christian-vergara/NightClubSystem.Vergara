package View.ViewView;

import App.App;
import Controller.Login.LoginController;
import Controller.ViewTablesController.ViewTablesController;
import Controller.ViewTablesController.ViewTablesEventObject;
import Controller.ViewTablesController.ViewTablesListener;
import Model.Objects.*;
import View.EmployeeHomeView.EmployeeHomeView;
import View.ManagerHomeView.ManagerHomeView;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Optional;

/**
 * Created by chris on 12/10/2016.
 */
public class ViewTablesView {
    private BorderPane pane;
    private TextArea currentCustomerField;
    private Stage stage;
    private GridPane grid;
    private TextField tblNumberField;
    private TextField tblCapacityField;
    private Button addTableButton;
    private ViewTablesListener viewTablesListener;
    private Table tableresult;

    public ViewTablesView(Stage stage) {
        this.stage = stage;

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("View Table");
        dialog.setHeaderText("Enter Table Number");

        Optional<String> result = dialog.showAndWait();

        if (App.getTableBag().findTable(Integer.parseInt(result.get())) != null) {

            tableresult = App.getTableBag().findTable(Integer.parseInt(result.get()));
            ViewTablesController controller = new ViewTablesController(this, this.tableresult);

            pane = new BorderPane();
            Employee searchResult = (Employee) LoginController.getCurrentUser();
            if (searchResult.getRank().equals("General")) {
                pane.setTop(EmployeeHomeView.getEmployeeMenuBar());
            } else if(searchResult.getRank().equals("Manager") || searchResult.getRank().equals("Owner")){
                pane.setTop(ManagerHomeView.getMenuBar());
            }


            grid = new GridPane();
            grid.setHgap(5);
            grid.setVgap(10);
            grid.setPadding(new Insets(5));


            Label title = new Label("Table");
            title.setStyle("-fx-font-size: 53");
            grid.add(title, 0, 0, 7, 4);

            Label tblNumberLabel = new Label("Table Number: ");
            tblNumberField = new TextField(Integer.toString(tableresult.getTblNbr()));
            grid.add(tblNumberLabel, 0, 5);
            grid.add(tblNumberField, 1, 5);

            Label tblCapacityLabel = new Label("Capacity: ");
            tblCapacityField = new TextField(Integer.toString(tableresult.getTblCapacity()));
            grid.add(tblCapacityLabel, 0, 6);
            grid.add(tblCapacityField, 1, 6);

            Label currentCustomer = new Label("Current Customers: ");
            currentCustomerField = new TextArea(tableresult.printCustomer());
            currentCustomerField.setEditable(false);
            grid.add(currentCustomer, 0, 7);
            grid.add(currentCustomerField, 1, 7, 2, 3);

            Button updateTableButton = new Button("Update Table");
            grid.add(updateTableButton, 0, 10);

            updateTableButton.setOnAction(event -> {
                int tblNumber = Integer.parseInt(tblNumberField.getText());
                int tblCapacity = Integer.parseInt(tblCapacityField.getText());
                ViewTablesEventObject ev = new ViewTablesEventObject(this, tblNumber, tblCapacity);
                if (viewTablesListener != null) {
                    viewTablesListener.btnClicked(ev);
                }
            });

            Button clearTableButton = new Button("Clear Table");
            grid.add(clearTableButton, 0, 11);

            clearTableButton.setOnAction(event -> {
                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                confirm.setTitle("Confirm");
                confirm.setHeaderText("Table Cleared!");
                tableresult.removeSitting(tableresult.getCurrentSitting());
                tableresult.getCustomerBag().getCustomerBag().clear();
                currentCustomerField.clear();
            });
        } else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Table not found!");
            alert.showAndWait();
            System.out.println(App.getTableBag().getTableList().size() + "size");
        }

        pane.setCenter(grid);
        Scene scene = new Scene(pane, 1280, 720);
        scene.getStylesheets().addAll("View/AddView/AddStyleSheet.css");
        stage.setScene(scene);
        stage.show();
    }

    public Table getTableresult() {
        return tableresult;
    }

    public TextField getTblNumberField() {
        return tblNumberField;
    }

    public void setTblNumberField(TextField tblNumberField) {
        this.tblNumberField = tblNumberField;
    }

    public TextField getTblCapacityField() {
        return tblCapacityField;
    }

    public void setTblCapacityField(TextField tblCapacityField) {
        this.tblCapacityField = tblCapacityField;
    }

    public Button getAddTableButton() {
        return addTableButton;
    }

    public void setAddTableButton(Button addTableButton) {
        this.addTableButton = addTableButton;
    }

    public ViewTablesListener getViewTablesListener() {
        return viewTablesListener;
    }

    public void setViewTablesListener(ViewTablesListener viewTablesListener) {
        this.viewTablesListener = viewTablesListener;
    }
}
