import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class radioButooninput extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       ToggleGroup g = new ToggleGroup();
       CheckBox cb = new CheckBox("Mathmatics");
       RadioButton opt1 = new RadioButton("English");
       RadioButton opt2 = new RadioButton("Physcis");
       RadioButton opt3 = new RadioButton("Maths");
       RadioButton opt4 = new RadioButton("Computer Science");
       Button submit = new Button("Submit");
       Label l1 = new Label();
       opt1.setToggleGroup(g);
       opt2.setToggleGroup(g);
       opt3.setToggleGroup(g);
       opt4.setToggleGroup(g);
       VBox root = new VBox();
       root.getChildren().addAll(opt1,opt2,opt3,opt4,submit,l1);
       submit.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               if(opt1.isSelected())
               {
                   l1.setText("Correct Answer : ".concat(opt1.getText()));
               }
               else
               {
                   l1.setText("Wrong Answer");
               }
           }
       });
       Scene sc = new Scene(root);
       primaryStage.setTitle("Radio Butoon");
       primaryStage.setScene(sc);
       primaryStage.setHeight(500);
       primaryStage.setWidth(500);
       primaryStage.show();
    }
}
