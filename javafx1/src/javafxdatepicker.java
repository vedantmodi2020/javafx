import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class javafxdatepicker extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       DatePicker d= new DatePicker();
       d.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               System.out.println(d.getValue());
           }
       });

       BorderPane root = new BorderPane();
       root.setCenter(d);
       Scene sc = new Scene(root);
       primaryStage.setTitle("JAVAFX DATE PICKER");
       primaryStage.setScene(sc);
       primaryStage.setWidth(500);
       primaryStage.setHeight(500);
       primaryStage.show();
        
    }
}
