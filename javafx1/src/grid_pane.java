import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class grid_pane extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {
        Stage s = new Stage();
        s.setTitle("This is Vedant Modi");
        TextField txt1 = new TextField();
        Label l1 = new Label("Enter Name : ");
        Button bt = new Button("Click Here");
        GridPane root = new GridPane();
        root.add(l1, 0, 1);
        root.add(txt1, 1, 1);
        root.add(bt, 0, 2);
        root.setHgap(20);
        root.setVgap(20);
        Scene sc = new Scene(root,300,300);
        s.setScene(sc);
        s.show();
    }
    
}
