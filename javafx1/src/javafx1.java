import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

public class javafx1 extends Application {
    public static void main(String[] args) throws IOException {
        launch(args);

    }

    @Override
    public void start(Stage arg0) throws Exception {
        Stage s = new Stage();
        s.setTitle("This is Vedant Modi");
        s.setWidth(300);
        s.setHeight(300);
        s.show();
    }
}
