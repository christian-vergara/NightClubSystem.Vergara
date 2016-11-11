package View;

import Controller.MainController;
import Model.Employee;
import Model.MyEventListener;
import Model.MyEventObject;
import Model.User;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;


/**
 * Created by chris on 11/6/2016.
 */
public class MainView {

    private Stage stage;
    private Scene scene;
    private Button loginButton;
    private TextField userField;
    private PasswordField passField;



    private MyEventListener loginButtonListener;


    public MainView(Stage stage) {
        this.stage = stage;

        Label mainLabel = new Label("Night Club Manager");
        mainLabel.setStyle("-fx-font-size: 72");
        Label userLabel = new Label("Username:");
        userField = new TextField();
        Label passLabel = new Label("Password:");
        passField = new PasswordField();
        loginButton = new Button("Login");

        HBox field = new HBox(5);
        field.setSpacing(10);
        field.setPadding(new Insets(5));
        field.getChildren().addAll(userLabel, userField);
        field.setAlignment(Pos.CENTER);

        HBox pass = new HBox(5);
        pass.setSpacing(10);
        pass.setPadding(new Insets(5));
        pass.getChildren().addAll(passLabel, passField);
        pass.setAlignment(Pos.CENTER);

        // MainView VBox: Title + Fields
        VBox pane = new VBox(5);
        pane.setPadding(new Insets(5));
        pane.setSpacing(10);
        pane.getChildren().addAll(mainLabel, field, pass, loginButton);
        pane.setAlignment(Pos.CENTER);

        //Background image
        BackgroundImage myBI = new BackgroundImage(new Image("http://wallpaperswide.com/download/city_night_3-wallpaper-1920x1080.jpg",1920,1080,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        pane.setBackground(new Background(myBI));


        //Login Button Event Listener
        loginButton.setOnAction(e -> {
            String userName = userField.getText();
            String password = passField.getText();
            MyEventObject ev = new MyEventObject(this, userName, password);
            if(loginButtonListener != null){
                loginButtonListener.btnClicked(ev);
            }
        });

        scene = new Scene(pane, 1280, 720);
        scene.getStylesheets().add("View/Main.css");
        stage.setScene(scene);
        stage.show();


    }

    public void setLoginButtonListener(MyEventListener loginButtonListener) {
        this.loginButtonListener = loginButtonListener;
    }

    public TextField getUserField() {
        return userField;
    }

    public PasswordField getPassField() {
        return passField;
    }


}
