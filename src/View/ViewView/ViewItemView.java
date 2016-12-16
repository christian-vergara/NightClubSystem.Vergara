package View.ViewView;

import App.App;
import Controller.Login.LoginController;
import Controller.ViewItemController.*;
import Model.Objects.*;
import View.EmployeeHomeView.EmployeeHomeView;
import View.ManagerHomeView.ManagerHomeView;
import javafx.collections.FXCollections;
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
public class ViewItemView {
    private Stage stage;
    private ViewItemEventListener viewItemEventListener;
    private TextField nameField, priceField, brandField, originField, alcVolField, colorField;
    private TextArea descriptionField;
    //private ChoiceBox typeField;
    private String selected = "Food";
    private GridPane pane;
    private GridPane tempPane;
    private BorderPane root;
    private ChoiceBox typeField;
    private Item item;
    private Beer beerResult;
    private Wine wineResult;
    private Liquor liquorResult;


    public ViewItemView(Stage stage) {
        this.stage = stage;

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Find Item");
        dialog.setHeaderText("Enter Item Name");

        Optional<String> result = dialog.showAndWait();

        if (App.getItemBag().findItem(result.get()) != null) {
            item = App.getItemBag().findItem(result.get());
            if (item.getType().equals("Beer")) {
                beerResult = (Beer) item;
            } else if (item.getType().equals("Wine")) {
                wineResult = (Wine) item;
            } else if (item.getType().equals("Liquor")) {
                liquorResult = (Liquor) item;
            }

            root = new BorderPane();
            Employee searchResult = (Employee) LoginController.getCurrentUser();
            if (searchResult.getRank().equals("General")) {
                root.setTop(EmployeeHomeView.getEmployeeMenuBar());
            } else if(searchResult.getRank().equals("Manager") || searchResult.getRank().equals("Owner")){
                root.setTop(ManagerHomeView.getMenuBar());
            }
            pane = new GridPane();
            pane.setPadding(new Insets(5));
            pane.setVgap(5);
            pane.setHgap(5);
            root.setCenter(pane);

            ViewItemController controller = new ViewItemController(this, item);


        } else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Not Found! Please try again");
            alert.showAndWait();
        }
        listenForChange(item.getType());
        Scene scene = new Scene(root, 1280, 720);
        scene.getStylesheets().add("View/AddView/AddStyleSheet.css");
        stage.setScene(scene);
        stage.show();

    }



    public void listenForChange(String selected) {
        if (selected.equals("Food") || selected.equals("Drink")) {

            Label addLabel = new Label("Item");
            addLabel.setStyle("-fx-font-size: 53");
            pane.add(addLabel, 0, 0, 4, 4);

            Label typeLabel = new Label("Type: ");
            typeField = new ChoiceBox();
            typeField.setStyle("-fx-background-color: #383838");

            pane.add(typeLabel, 0, 5);
            pane.add(typeField, 1, 5);

            if (selected.equals(("Food"))) {
                typeField.setItems(FXCollections.observableArrayList("Food"));
            }
            if (selected.equals(("Drink"))) {
                typeField.setItems(FXCollections.observableArrayList("Drink"));
            }
            Label nameLabel = new Label("Name: ");
            nameField = new TextField(item.getName());
            pane.add(nameLabel, 0, 6);
            pane.add(nameField, 1, 6);

            Label descriptionLabel = new Label("Description: ");
            descriptionField = new TextArea(item.getDescription());
            pane.add(descriptionLabel, 0, 7);
            pane.add(descriptionField, 1, 7, 2, 2);

            Label priceLabel = new Label("Price: ");
            priceField = new TextField(Double.toString(item.getPrice()));
            pane.add(priceLabel, 0, 9);
            pane.add(priceField, 1, 9);

            Button addButton = new Button("Update Item");
            pane.add(addButton, 0, 10);
            addButton.setOnAction(event -> {
                String type, name, description;
                Double price;
                type = typeField.getValue().toString();
                name = nameField.getText();
                description = descriptionField.getText();
                price = Double.parseDouble(priceField.getText());
                ViewItemEventObject eventObject = new ViewItemEventObject(this, type, name, description, price);

                if (viewItemEventListener != null) {
                    viewItemEventListener.btnClicked(eventObject);
                }
            });
        }


        if (selected.equals("Beer")) {

            Label addLabel = new Label("Item");
            addLabel.setStyle("-fx-font-size: 53");
            pane.add(addLabel, 0, 0, 4, 4);

            Label typeLabel = new Label("Type: ");
            typeField = new ChoiceBox();
            typeField.setStyle("-fx-background-color: #383838");
            typeField.setItems(FXCollections.observableArrayList("Beer"));
            pane.add(typeLabel, 0, 5);
            pane.add(typeField, 1, 5);


            typeField.setValue("Beer");
            //listen for selection changes


            Label nameLabel = new Label("Name: ");
            nameField = new TextField(beerResult.getName());
            pane.add(nameLabel, 0, 6);
            pane.add(nameField, 1, 6);

            Label descriptionLabel = new Label("Description: ");
            descriptionField = new TextArea(beerResult.getDescription());
            pane.add(descriptionLabel, 0, 7);
            pane.add(descriptionField, 1, 7, 2, 2);

            Label priceLabel = new Label("Price: ");
            priceField = new TextField(Double.toString(beerResult.getPrice()));
            pane.add(priceLabel, 0, 9);
            pane.add(priceField, 1, 9);

            Label brandLabel3 = new Label("Brand: ");
            brandField = new TextField(beerResult.getBrand());
            pane.add(brandLabel3, 0, 10);
            pane.add(brandField, 1, 10);

            Label originLabel3 = new Label("Origin: ");
            originField = new TextField(beerResult.getOrigin());
            pane.add(originLabel3, 0, 11);
            pane.add(originField, 1, 11);

            Label alcVolLabel3 = new Label("Alcohol %: ");
            alcVolField = new TextField(Double.toString(beerResult.getAlcVol()));
            pane.add(alcVolLabel3, 0, 12);
            pane.add(alcVolField, 1, 12);

            Button updateButton3 = new Button("Update Item");
            pane.add(updateButton3, 0, 13);
            updateButton3.setOnAction(event -> {
                String type3, name3, description3, brand3, origin3;
                Double price3, alcVol3;
                type3 = typeField.getValue().toString();
                name3 = nameField.getText();
                description3 = nameField.getText();
                price3 = Double.parseDouble(priceField.getText());
                brand3 = brandField.getText();
                origin3 = originField.getText();
                alcVol3 = Double.parseDouble(alcVolField.getText());
                ViewBeerEventObject eventObject3 = new ViewBeerEventObject(this, type3, name3, description3, brand3, origin3, price3, alcVol3);
                if (viewItemEventListener != null) {
                    viewItemEventListener.btnClickedBeer(eventObject3);
                }

            });
        }

        if (selected.equals("Wine")) {

            Label addLabel = new Label("Item");
            addLabel.setStyle("-fx-font-size: 53");
            pane.add(addLabel, 0, 0, 4, 4);

            Label typeLabel = new Label("Type: ");
            typeField = new ChoiceBox();
            typeField.setStyle("-fx-background-color: #383838");
            typeField.setItems(FXCollections.observableArrayList("Wine"));
            pane.add(typeLabel, 0, 5);
            pane.add(typeField, 1, 5);

            typeField.setValue("Wine");

            Label nameLabel = new Label("Name: ");
            nameField = new TextField(wineResult.getName());
            pane.add(nameLabel, 0, 6);
            pane.add(nameField, 1, 6);

            Label descriptionLabel = new Label("Description: ");
            descriptionField = new TextArea(wineResult.getDescription());
            pane.add(descriptionLabel, 0, 7);
            pane.add(descriptionField, 1, 7, 2, 2);

            Label priceLabel = new Label("Price: ");
            priceField = new TextField(Double.toString(wineResult.getPrice()));
            pane.add(priceLabel, 0, 9);
            pane.add(priceField, 1, 9);

            Label brandLabel1 = new Label("Brand: ");
            brandField = new TextField(wineResult.getBrand());
            pane.add(brandLabel1, 0, 10);
            pane.add(brandField, 1, 10);

            Label originLabel1 = new Label("Origin: ");
            originField = new TextField(wineResult.getOrigin());
            pane.add(originLabel1, 0, 11);
            pane.add(originField, 1, 11);

            Label alcVolLabel1 = new Label("Alcohol %: ");
            alcVolField = new TextField(Double.toString(wineResult.getAlcVol()));
            pane.add(alcVolLabel1, 0, 12);
            pane.add(alcVolField, 1, 12);

            Label colorLabel = new Label("Color: ");
            colorField = new TextField(wineResult.getColor());
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
                ViewWineEventObject eventObject1 = new ViewWineEventObject(this, type1, name1, description1, brand1, origin1, color1, price1, alcVol1);
                if (viewItemEventListener != null) {
                    viewItemEventListener.btnClickedWine(eventObject1);
                }
            });
        }

        if (selected.equals("Liquor")) {

            Label addLabel = new Label("Item");
            addLabel.setStyle("-fx-font-size: 53");
            pane.add(addLabel, 0, 0, 4, 4);

            Label typeLabel = new Label("Type: ");
            typeField = new ChoiceBox();
            typeField.setStyle("-fx-background-color: #383838");
            typeField.setItems(FXCollections.observableArrayList("Liquor"));
            pane.add(typeLabel, 0, 5);
            pane.add(typeField, 1, 5);

            typeField.setValue("Liquor");


            Label nameLabel = new Label("Name: ");
            nameField = new TextField(liquorResult.getName());
            pane.add(nameLabel, 0, 6);
            pane.add(nameField, 1, 6);

            Label descriptionLabel = new Label("Description: ");
            descriptionField = new TextArea(liquorResult.getDescription());
            pane.add(descriptionLabel, 0, 7);
            pane.add(descriptionField, 1, 7, 2, 2);

            Label priceLabel = new Label("Price: ");
            priceField = new TextField(Double.toString(liquorResult.getPrice()));
            pane.add(priceLabel, 0, 9);
            pane.add(priceField, 1, 9);

            Label brandLabel2 = new Label("Brand: ");
            brandField = new TextField(liquorResult.getBrand());
            pane.add(brandLabel2, 0, 10);
            pane.add(brandField, 1, 10);

            Label originLabel2 = new Label("Origin: ");
            originField = new TextField(liquorResult.getOrigin());
            pane.add(originLabel2, 0, 11);
            pane.add(originField, 1, 11);

            Label alcVolLabel2 = new Label("Alcohol %: ");
            alcVolField = new TextField(Double.toString(liquorResult.getAlcVol()));
            pane.add(alcVolLabel2, 0, 12);
            pane.add(alcVolField, 1, 12);

            Button addButton2 = new Button("Update Item");
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
                ViewLiquorEventObject eventObject2 = new ViewLiquorEventObject(this, type2, name2, description2, brand2, origin2, price2, alcVol2);
                if (viewItemEventListener != null) {
                    viewItemEventListener.btnClickedLiquor(eventObject2);
                }
            });
        }
    }

    public ViewItemEventListener getViewItemEventListener() {
        return viewItemEventListener;
    }

    public void setViewItemEventListener(ViewItemEventListener viewItemEventListener) {
        this.viewItemEventListener = viewItemEventListener;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public TextField getNameField() {
        return nameField;
    }

    public void setNameField(TextField nameField) {
        this.nameField = nameField;
    }

    public TextField getPriceField() {
        return priceField;
    }

    public void setPriceField(TextField priceField) {
        this.priceField = priceField;
    }

    public TextField getBrandField() {
        return brandField;
    }

    public void setBrandField(TextField brandField) {
        this.brandField = brandField;
    }

    public TextField getOriginField() {
        return originField;
    }

    public void setOriginField(TextField originField) {
        this.originField = originField;
    }

    public TextField getAlcVolField() {
        return alcVolField;
    }

    public void setAlcVolField(TextField alcVolField) {
        this.alcVolField = alcVolField;
    }

    public TextField getColorField() {
        return colorField;
    }

    public void setColorField(TextField colorField) {
        this.colorField = colorField;
    }

    public TextArea getDescriptionField() {
        return descriptionField;
    }

    public void setDescriptionField(TextArea descriptionField) {
        this.descriptionField = descriptionField;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public GridPane getPane() {
        return pane;
    }

    public void setPane(GridPane pane) {
        this.pane = pane;
    }

    public GridPane getTempPane() {
        return tempPane;
    }

    public void setTempPane(GridPane tempPane) {
        this.tempPane = tempPane;
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }

    public ChoiceBox getTypeField() {
        return typeField;
    }

    public void setTypeField(ChoiceBox typeField) {
        this.typeField = typeField;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Beer getBeerResult() {
        return beerResult;
    }

    public void setBeerResult(Beer beerResult) {
        this.beerResult = beerResult;
    }

    public Wine getWineResult() {
        return wineResult;
    }

    public void setWineResult(Wine wineResult) {
        this.wineResult = wineResult;
    }

    public Liquor getLiquorResult() {
        return liquorResult;
    }

    public void setLiquorResult(Liquor liquorResult) {
        this.liquorResult = liquorResult;
    }
}
