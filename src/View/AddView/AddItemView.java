package View.AddView;

import Controller.AddItemController.*;
import View.EmployeeHomeView.EmployeeHomeView;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.*;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.Color;


/**
 * Created by chris on 12/10/2016.
 */
public class AddItemView {
    private AddItemEventListener addItemEventListener;
    private Stage stage;
    private TextField nameField, priceField, brandField, originField, alcVolField, colorField;
    private TextArea descriptionField;
    //private ChoiceBox typeField;
    private String selected = "Food";
    private GridPane pane;
    private GridPane tempPane;
    private BorderPane root;
    private ChoiceBox<String> typeField;

    public AddItemView(Stage stage) {
        this.stage = stage;

        AddItemController controller = new AddItemController(this);

        root = new BorderPane();
        root.setTop(EmployeeHomeView.getEmployeeMenuBar());
        pane = new GridPane();
        pane.setPadding(new Insets(5));
        pane.setVgap(5);
        pane.setHgap(5);

        Label addLabel = new Label("Add Item");
        addLabel.setStyle("-fx-font-size: 53");
        pane.add(addLabel, 0, 0, 4, 4);

        Label typeLabel = new Label("Type: ");
        typeField = new ChoiceBox();
        typeField.setStyle("-fx-background-color: #383838");
        typeField.setItems(FXCollections.observableArrayList("Food", "Drink", "Beer", "Wine", "Liquor"));
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

        root.setCenter(pane);


//listen for selection changes
        typeField.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            selected = newValue.toString();
            pane.getChildren().clear();
            listenForChange(selected);
            root.setCenter(pane);
        });

        Scene scene = new Scene(root, 1280, 720);
        scene.getStylesheets().add("View/AddView/AddStyleSheet.css");
        stage.setScene(scene);
        stage.show();

    }


    public void listenForChange(String selected) {
        if (selected.equals("Food") || selected.equals("Drink")) {

            Label addLabel = new Label("Add Item");
            addLabel.setStyle("-fx-font-size: 53");
            pane.add(addLabel, 0, 0, 4, 4);

            Label typeLabel = new Label("Type: ");
            typeField = new ChoiceBox();
            typeField.setStyle("-fx-background-color: #383838");
            typeField.setItems(FXCollections.observableArrayList("Food", "Drink", "Beer", "Wine", "Liquor"));
            pane.add(typeLabel, 0, 5);
            pane.add(typeField, 1, 5);

            if (selected.equals(("Food"))) {
                typeField.setValue("Food");
            }
            if (selected.equals(("Drink"))) {
                typeField.setValue("Drink");
            }
            //listen for selection changes
            typeField.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
                setSelected(newValue);
            });

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
        }




        if (selected.equals("Beer")) {

            Label addLabel = new Label("Add Item");
            addLabel.setStyle("-fx-font-size: 53");
            pane.add(addLabel, 0, 0, 4, 4);

            Label typeLabel = new Label("Type: ");
            typeField = new ChoiceBox();
            typeField.setStyle("-fx-background-color: #383838");
            typeField.setItems(FXCollections.observableArrayList("Food", "Drink", "Beer", "Wine", "Liquor"));
            pane.add(typeLabel, 0, 5);
            pane.add(typeField, 1, 5);

            typeField.setValue("Beer");
            //listen for selection changes
            typeField.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
                setSelected(newValue);
            });

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

            Label brandLabel3 = new Label("Brand: ");
            brandField = new TextField();
            pane.add(brandLabel3, 0, 10);
            pane.add(brandField, 1, 10);

            Label originLabel3 = new Label("Origin: ");
            originField = new TextField();
            pane.add(originLabel3, 0, 11);
            pane.add(originField, 1, 11);

            Label alcVolLabel3 = new Label("Alcohol %: ");
            alcVolField = new TextField();
            pane.add(alcVolLabel3, 0, 12);
            pane.add(alcVolField, 1, 12);

            Button addButton3 = new Button("Add Item");
            pane.add(addButton3, 0, 13);
            addButton3.setOnAction(event -> {
                String type3, name3, description3, brand3, origin3;
                Double price3, alcVol3;
                type3 = typeField.getValue().toString();
                name3 = nameField.getText();
                description3 = nameField.getText();
                price3 = Double.parseDouble(priceField.getText());
                brand3 = brandField.getText();
                origin3 = originField.getText();
                alcVol3 = Double.parseDouble(alcVolField.getText());
                AddBeerEventObject eventObject3 = new AddBeerEventObject(this, type3, name3, description3, brand3, origin3, price3, alcVol3);
                if (addItemEventListener != null) {
                    addItemEventListener.btnClickedBeer(eventObject3);
                }

            });
        }

        if (selected.equals("Wine")) {

            Label addLabel = new Label("Add Item");
            addLabel.setStyle("-fx-font-size: 53");
            pane.add(addLabel, 0, 0, 4, 4);

            Label typeLabel = new Label("Type: ");
            typeField = new ChoiceBox();
            typeField.setStyle("-fx-background-color: #383838");
            typeField.setItems(FXCollections.observableArrayList("Food", "Drink", "Beer", "Wine", "Liquor"));
            pane.add(typeLabel, 0, 5);
            pane.add(typeField, 1, 5);

            typeField.setValue("Wine");
            //listen for selection changes
            typeField.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
                setSelected(newValue);
            });

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

            Label brandLabel1 = new Label("Brand: ");
            brandField = new TextField();
            pane.add(brandLabel1, 0, 10);
            pane.add(brandField, 1, 10);

            Label originLabel1 = new Label("Origin: ");
            originField = new TextField();
            pane.add(originLabel1, 0, 11);
            pane.add(originField, 1, 11);

            Label alcVolLabel1 = new Label("Alcohol %: ");
            alcVolField = new TextField();
            pane.add(alcVolLabel1, 0, 12);
            pane.add(alcVolField, 1, 12);

            Label colorLabel = new Label("Color: ");
            colorField = new TextField();
            pane.add(colorLabel, 0, 13);
            pane.add(colorField, 1, 13);

            Button addButton1 = new Button("Add Item");
            pane.add(addButton1, 0, 14);
            addButton1.setOnAction(event1 -> {
                String type1, name1, description1, brand1, origin1, color1;
                Double price1, alcVol1;
                type1 = typeField.getValue().toString();
                name1 = nameField.getText();
                description1 = nameField.getText();
                price1 = Double.parseDouble(priceField.getText());
                brand1 = brandField.getText();
                origin1 = originField.getText();
                alcVol1 = Double.parseDouble(alcVolField.getText());
                color1 = colorField.getText();
                AddWineEventObject eventObject1 = new AddWineEventObject(this, type1, name1, description1, brand1, origin1, color1, price1, alcVol1);
                if (addItemEventListener != null) {
                    addItemEventListener.btnClickedWine(eventObject1);
                }
            });
        }

        if (selected.equals("Liquor")) {

            Label addLabel = new Label("Add Item");
            addLabel.setStyle("-fx-font-size: 53");
            pane.add(addLabel, 0, 0, 4, 4);

            Label typeLabel = new Label("Type: ");
            typeField = new ChoiceBox();
            typeField.setStyle("-fx-background-color: #383838");
            typeField.setItems(FXCollections.observableArrayList("Food", "Drink", "Beer", "Wine", "Liquor"));
            pane.add(typeLabel, 0, 5);
            pane.add(typeField, 1, 5);

            typeField.setValue("Liquor");
            //listen for selection changes
            typeField.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
                setSelected(newValue);
            });

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

            Label brandLabel2 = new Label("Brand: ");
            brandField = new TextField();
            pane.add(brandLabel2, 0, 10);
            pane.add(brandField, 1, 10);

            Label originLabel2 = new Label("Origin: ");
            originField = new TextField();
            pane.add(originLabel2, 0, 11);
            pane.add(originField, 1, 11);

            Label alcVolLabel2 = new Label("Alcohol %: ");
            alcVolField = new TextField();
            pane.add(alcVolLabel2, 0, 12);
            pane.add(alcVolField, 1, 12);

            Button addButton2 = new Button("Add Item");
            pane.add(addButton2, 0, 13);
            addButton2.setOnAction(event2 -> {
                String type2, name2, description2, brand2, origin2;
                Double price2, alcVol2;
                type2 = typeField.getValue().toString();
                name2 = nameField.getText();
                description2 = nameField.getText();
                price2 = Double.parseDouble(priceField.getText());
                brand2 = brandField.getText();
                origin2 = originField.getText();
                alcVol2 = Double.parseDouble(alcVolField.getText());
                AddLiquorEventObject eventObject2 = new AddLiquorEventObject(this, type2, name2, description2, brand2, origin2, price2, alcVol2);
                if (addItemEventListener != null) {
                    addItemEventListener.btnClickedLiquor(eventObject2);
                }
            });
        }
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
        pane.getChildren().clear();
        listenForChange(selected);
        root.setCenter(pane);
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

    public TextField getBrandField() {
        return brandField;
    }

    public TextField getOriginField() {
        return originField;
    }

    public TextField getAlcVolField() {
        return alcVolField;
    }

    public TextField getColorField() {
        return colorField;
    }
}
