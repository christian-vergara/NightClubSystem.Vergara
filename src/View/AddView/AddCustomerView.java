package View.AddView;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by chris on 12/10/2016.
 */
public class AddCustomerView {

    private Stage stage;

    public AddCustomerView(Stage stage) {
        this.stage = stage;

        BorderPane pane = new BorderPane();

        Scene scene = new Scene(pane, 1280, 720);
        stage.setScene(scene);
        stage.show();
    }
}
