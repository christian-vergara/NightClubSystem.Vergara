package View.AddView;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by chris on 12/10/2016.
 */
public class AddCustomerView {

    private Stage stage;

    public AddCustomerView(Stage stage) {
        this.stage = stage;

        BorderPane pane = new BorderPane();
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5));

        Label nameLabel = new Label();
        gridPane.add(nameLabel,0,0);
        
        Scene scene = new Scene(pane, 1280, 720);
        stage.setScene(scene);
        stage.show();
    }
}
