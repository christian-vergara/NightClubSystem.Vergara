package View;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;



/**
 * Created by chris on 11/6/2016.
 */
public class Main extends Application{

    Stage window;
    Scene scene;

    public static void main(String args[]) {
        launch(args);

    }

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Night Club Manager");

        Label mainLabel = new Label("Night Club Manager");
        mainLabel.setFont(Font.font(70));
        mainLabel.setTextFill(Color.WHITE);
        TextField userField = new TextField();
        userField.setPromptText("Username");
        userField.setMaxWidth(300);
        TextField passField = new TextField();
        passField.setPromptText("Password");
        passField.setMaxWidth(300);
        Button loginButton = new Button("Login");

        VBox pane = new VBox(5);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setSpacing(10);
        pane.getChildren().addAll(mainLabel, userField, passField, loginButton);
        pane.setAlignment(Pos.CENTER);

        BackgroundImage myBI = new BackgroundImage(new Image("http://wallpaperswide.com/download/city_night_3-wallpaper-1280x720.jpg",1280,720,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        pane.setBackground(new Background(myBI));

        scene = new Scene(pane, 1280, 720);
        window.setScene(scene);
        window.show();

        window.setOnCloseRequest(e -> Platform.exit());


    }

    public void setScene(Scene scene) {
        this.scene = scene;

    }


}
