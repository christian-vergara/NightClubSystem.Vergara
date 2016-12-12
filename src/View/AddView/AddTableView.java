package View.AddView;

import Controller.AddTableController.AddTableController;
import Controller.AddTableController.AddTableEventObject;
import Controller.AddTableController.AddTableListener;
import View.EmployeeHomeView.EmployeeHomeView;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;




/**
 * Created by chris on 12/10/2016.
 */
public class AddTableView {
    private Stage stage;
    private TextField tblNumberField;
    private TextField tblCapacityField;
    private Button addTableButton;
    private AddTableListener addTableListener;

    public AddTableView(Stage stage) {
        this.stage = stage;
        AddTableController controller = new AddTableController(this);

        BorderPane pane = new BorderPane();
        pane.setTop(EmployeeHomeView.getEmployeeMenuBar());

        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(10);
        grid.setPadding(new Insets(5));
        pane.setLeft(grid);

        Label title = new Label("New Table");
        title.setStyle("-fx-font-size: 53");
        grid.add(title, 0, 0, 7, 4);

        Label tblNumberLabel = new Label("Table Number: ");
        tblNumberField = new TextField();
        grid.add(tblNumberLabel, 0, 5);
        grid.add(tblNumberField, 1, 5);

        Label tblCapacityLabel = new Label("Capacity: ");
        tblCapacityField = new TextField();
        grid.add(tblCapacityLabel, 0, 6);
        grid.add(tblCapacityField, 1, 6);

        addTableButton = new Button("Add Table");
        grid.add(addTableButton, 0, 7);

        addTableButton.setOnAction(event -> {
            int tblNumber = Integer.parseInt(tblNumberField.getText());
            int tblCapacity = Integer.parseInt(tblCapacityField.getText());
            AddTableEventObject ev = new AddTableEventObject(this, tblNumber, tblCapacity);
            if (addTableListener != null) {
                addTableListener.btnClicked(ev);
            }
        });

        Scene scene = new Scene(pane, 1280, 720);
        scene.getStylesheets().addAll("View/AddView/AddTableStyle.css");
        stage.setScene(scene);
        stage.show();
    }

    public void setAddTableListener(AddTableListener addTableListener) {
        this.addTableListener = addTableListener;
    }

    public Button getAddTableButton() {
        return addTableButton;
    }

    public TextField getTblNumberField() {
        return tblNumberField;
    }

    public TextField getTblCapacityField() {
        return tblCapacityField;
    }
}
