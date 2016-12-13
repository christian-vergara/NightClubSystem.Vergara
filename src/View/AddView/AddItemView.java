package View.AddView;

import Controller.AddItemController.AddItemController;
import Controller.AddItemController.AddItemEventListener;
import Controller.AddItemController.AddItemEventObject;
import View.EmployeeHomeView.EmployeeHomeView;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



/**
 * Created by chris on 12/10/2016.
 */
public class AddItemView {
    private AddItemEventListener addItemEventListener;
    private Stage stage;
    private TextField nameField, priceField;
    private TextArea descriptionField;
    private ChoiceBox typeField;

    public AddItemView(Stage stage) {
        this.stage = stage;

        AddItemController controller = new AddItemController(this);

        BorderPane root = new BorderPane();
        root.setTop(EmployeeHomeView.getEmployeeMenuBar());
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(5));
        pane.setVgap(5);
        pane.setHgap(5);

        Label addLabel = new Label("Add Item");
        addLabel.setStyle("-fx-font-size: 53");
        pane.add(addLabel, 0, 0, 4, 4);

        Label typeLabel = new Label("Type: ");
        typeField = new ChoiceBox();
        typeField.setStyle("-fx-background-color: #383838");
        typeField.setItems(FXCollections.observableArrayList("Food", "Drink", "Beer/Wine"));
        pane.add(typeLabel, 0, 5);
        pane.add(typeField, 1, 5);

        Label nameLabel = new Label("Name: ");
        nameField = new TextField();
        pane.add(nameLabel, 0, 6);
        pane.add(nameField, 1, 6);

        Label descriptionLabel = new Label("Description: ");
        descriptionField = new TextArea();
        pane.add(descriptionLabel, 0, 7);
        pane.add(descriptionField, 1, 7, 2, 2);

        Label priceLabel = new Label("Price: ");
        priceField = new TextField();
        pane.add(priceLabel, 0, 9);
        pane.add(priceField, 1, 9);

        Button addButton = new Button("Add Item");
        pane.add(addButton, 0, 10);
        addButton.setOnAction(event -> {
            String type, name, description;
            Double price;
            type = typeField.getValue().toString();
            name = nameField.getText();
            description = nameField.getText();
            price = Double.parseDouble(priceField.getText());
            AddItemEventObject eventObject = new AddItemEventObject(this, type, name, description, price);
            if (addItemEventListener != null) {
                addItemEventListener.btnClicked(eventObject);
            }
        });

        root.setCenter(pane);
        Scene scene = new Scene(root, 1280, 720);
        scene.getStylesheets().add("View/AddView/AddStyleSheet.css");
        stage.setScene(scene);
        stage.show();
    }

    public void setAddItemEventListener(AddItemEventListener addItemEventListener) {
        this.addItemEventListener = addItemEventListener;
    }

    public ChoiceBox getTypeField() {
        return typeField;
    }

    public TextField getNameField() {
        return nameField;
    }

    public TextField getPriceField() {
        return priceField;
    }

    public TextArea getDescriptionField() {
        return descriptionField;
    }
}
