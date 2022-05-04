import java.awt.Color;

import javax.swing.Action;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class javafxtextinput extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       TextField name = new TextField();
       name.setMaxWidth(300);
       PasswordField pass = new PasswordField();
       pass.setMaxWidth(300);
       Button b1 = new Button("Click here");
       Label l1 = new Label();
       b1.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               l1.setText("Welcome MR. " +name.getText());
               l1.setFont(new Font(32));

           }
       });
       VBox root = new VBox();
       root.getChildren().addAll(name,pass,b1,l1);
       Scene sc = new Scene(root);
       primaryStage.setTitle("Text field Input");
       primaryStage.setScene(sc);
       primaryStage.setHeight(500);
       primaryStage.setWidth(500);
       primaryStage.show();
    }
}
