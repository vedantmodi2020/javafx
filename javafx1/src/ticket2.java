import javafx.application.Application;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class ticket2  extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage s = new Stage();
        Label l1 = new Label();
        Label l2 = new Label();
        Label l3 = new Label();
        Label l4 = new Label();
        Label l5 = new Label();
        Label l6 = new Label();
        Label l7 = new Label();
        Label l8 = new Label();
        TextField txt1 = new TextField();
        TextField txt2 = new TextField();
        TextField txt3 = new TextField();
        TextField txt4 = new TextField();
        TextField txt5 = new TextField();
        ComboBox cb = new ComboBox<>();
        for(int i=18;i<61;i++)
        {
            cb.getItems().add(i);
        }
        DatePicker d = new DatePicker();
        RadioButton rb1 = new RadioButton("Male");
        RadioButton rb2 = new RadioButton("Female");
        RadioButton rb3 = new RadioButton("Others");
        ToggleGroup tb = new ToggleGroup();
        rb1.setToggleGroup(tb);
        rb2.setToggleGroup(tb);
        rb3.setToggleGroup(tb);
        l1.setText("Enter Name : ");
        l2.setText("Enter Age : ");
        l3.setText("Enter Day of travelling : ");
        l4.setText("Enter boarding station : ");
        l5.setText("Enter Destination : ");
        l6.setText("Enter Gender : ");
        l7.setText("Enter Train Name : ");
        l8.setText("Enter class : ");
        Label l9 = new Label();
        

    

        
    }
    
}
