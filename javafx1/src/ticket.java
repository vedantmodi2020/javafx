import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.sql.SQLException;
//fast times shadow of mine
public class ticket extends Application {

    public static void main(String[] args) throws IOException, InstantiationException , ClassNotFoundException,IllegalAccessException {
        launch(args);
        
    }

    public void connect()
    {
        try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/javafx?characterEncoding=latin1&useConfigs=maxPerformance", "root",
                "Mahabharata@123");
        System.out.println("Connection established Succesfully");
        con.close();
    } catch (Exception e) {
        System.out.println(e);
    }
    }

    @Override
    public void start(Stage arg0) throws Exception {
        Stage s = new Stage();
        s.setTitle("Railway Ticket Booking");
        TextField txt1 = new TextField();
        DatePicker d= new DatePicker();
        TextField txt4 = new TextField();
        TextField txt2 = new TextField();
        Label l1 = new Label("Enter name : ");
        Label l2 = new Label("Select Age : ");
        Label l3 = new Label("Enter departure Date : ");
        Label l7 = new Label("Enter Boarding Station : ");
        Label l4 = new Label("Enter Destination Station : ");
        Label l5 = new Label("Select Train  : ");
        Label l6 = new Label("Select Class : ");
        Label l8 = new Label();
        Label l9 = new Label();
        Label l10 = new Label();
        Label l11 = new Label();
        Button b1 = new Button("Submit");
        ComboBox<Integer> age = new ComboBox<Integer>();
        for (int i = 18; i < 60; i++) {
            age.getItems().add(i);
        }
        ComboBox<String> Trains = new ComboBox<String>();
        Trains.getItems().add("Rajdhani Express");
        Trains.getItems().add("Swantranta shanini");
        Trains.getItems().add("Bihar Smapark Kranti");
        Trains.getItems().add("Satabdi Express");
        ComboBox<String> Class = new ComboBox<String>();
        Class.getItems().add("Third AC");
        Class.getItems().add("Second AC");
        Class.getItems().add("First AC");
        GridPane root = new GridPane();
        root.add(l1, 0, 1);
        root.add(l2, 0, 2);
        root.add(l3, 0, 3);
        root.add(l7, 0, 4);
        root.add(l4, 0, 5);
        root.add(l5, 0, 6);
        root.add(l6, 0, 7);
        root.add(txt1, 1, 1);
        root.add(age, 1, 2);
        root.add(d, 1, 3);
        root.add(txt4, 1, 5);
        root.add(txt2, 1, 4);
        root.add(b1, 0, 8);
        root.add(Trains, 1, 6);
        root.add(Class, 1, 7);
        root.add(l10,1,9);
        root.add(l8,1,10);
        root.add(l9,1,11);
        root.add(l11,1,12);
        b1.setOnAction(e -> {
            l10.setText("Welcome " + txt1.getText());
            l8.setText("Your Ticket has Been Booked for " + txt4.getText() + " from " + txt2.getText() + " on "
                    + d.getValue());
            if (Trains.getValue().equals("Rajdhani Express")) {
                double fair = 2400;
                if (Class.getValue().equals("Third AC")) {
                    l9.setText("Total Price : " + (fair));
                } else if (Class.getValue().equals("Second AC")) {
                    l9.setText("Total Price : " + (fair + 300));
                } else if (Class.getValue().equals("First AC")) {
                    l9.setText("Total Price : " + (fair + 600));
                }
            } else if (Trains.getValue().equals("Swantranta shanini")) {
                double fair = 1400;
                if (Class.getValue().equals("Third AC")) {
                    l9.setText("Total Price : " + (fair));
                } else if (Class.getValue().equals("Second AC")) {
                    l9.setText("Total Price : " + (fair + 300));
                } else if (Class.getValue().equals("First AC")) {
                    l9.setText("Total Price : " + (fair + 600));
                }
            } else if (Trains.getValue().equals("Bihar Smapark Kranti")) {
                double fair = 2000;
                if (Class.getValue().equals("Third AC")) {
                    l9.setText("Total Price : " + (fair));
                } else if (Class.getValue().equals("Second AC")) {
                    l9.setText("Total Price : " + (fair + 300));
                } else if (Class.getValue().equals("First AC")) {
                    l9.setText("Total Price : " + (fair + 600));
                }
            } else if (Trains.getValue().equals("Satabdi Express")) {
                double fair = 2100;
                if (Class.getValue().equals("Third AC")) {
                    l9.setText("Total Price : " + (fair));
                } else if (Class.getValue().equals("Second AC")) {
                    l9.setText("Total Price : " + (fair + 300));
                } else if (Class.getValue().equals("First AC")) {
                    l9.setText("Total Price : " + (fair + 600));
                }
            } else {
                l9.setText("Please Select Train");
            }
            int x=0;
            l11.setText("Your PNR Number is : 4663772638");

            //Platform.exit();
            connect();
            
        });
        Scene sc = new Scene(root,600,600, Color.DARKGREEN);
        BackgroundFill f = new BackgroundFill(Color.AZURE, CornerRadii.EMPTY, Insets.EMPTY);
        Background b = new Background(f);
        root.setBackground(b);
        s.setScene(sc);
        s.show();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
