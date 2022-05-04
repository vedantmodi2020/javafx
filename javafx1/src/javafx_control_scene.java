import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class javafx_control_scene extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1 = new Button("submit");
        HBox root = new HBox();
        root.getChildren().add(b1);
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setHeight(300);
        primaryStage.setWidth(300);
        primaryStage.show();
    }
    
}
