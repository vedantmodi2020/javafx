import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class javafx_jdbc {
    public static void main(String[] args) {
        launch(args);
    }

    private static void launch(String[] args) {
    }

}

class registrationForm {
    Label namelbl;
    TextField nametxt;
    Label passlbl;
    PasswordField passtxt;
    Label genderlbl;
    RadioButton opt1;
    RadioButton opt2;
    Label subjectlbl;
    CheckBox chk1;
    CheckBox chk2;
    CheckBox chk3;
    Label countrylbl;
    ComboBox<String> country;
    Button submit;
    Label errorlbl;

    public void showForm(Stage primaryStage) {
        namelbl = new Label("Enter your Name");
        nametxt = new TextField();
        passlbl = new Label("Enter your Password");
        passtxt = new PasswordField();
        genderlbl = new Label("Select your Gender");
        ToggleGroup group = new ToggleGroup();
        opt1 = new RadioButton("Male");
        opt2 = new RadioButton("Female");
        opt1.setToggleGroup(group);
        opt2.setToggleGroup(group);
        subjectlbl = new Label("Select all your subjects");
        chk1 = new CheckBox("English");
        chk2 = new CheckBox("Maths");
        chk3 = new CheckBox("Database Management Systems");
        countrylbl = new Label("Select your Country");
        country = new ComboBox<String>();
        country.getItems().add("India");
        country.getItems().add("US");
        country.getItems().add("UK");
        submit = new Button("Submit");
        errorlbl = new Label();
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String subjects = "";
                String gender;
                boolean connect_database = validate_form();
                try {
                    if (connect_database) {
                        if (opt1.isSelected()) {
                            gender = opt1.getText();
                        } else {
                            gender = opt2.getText();
                        }
                        if (chk1.isSelected()) {
                            subjects += chk1.getText() + " ";
                        }
                        if (chk2.isSelected()) {
                            subjects += chk2.getText() + " ";
                        }
                        if (chk3.isSelected()) {
                            subjects += chk3.getText();
                        }
                        String selectedcountry = (String) country.getValue();
                        student s = new student(nametxt.getText(), passtxt.getText(), gender, subjects,
                                selectedcountry);
                        try {
                            s.insertStudentRecord();
                            errorlbl.setTextFill(Color.GREEN);
                            errorlbl.setText("Record inserted successfully");
                        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException
                                | SQLException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                            errorlbl.setText(e.getMessage());
                        }
                    } else {
                        errorlbl.setTextFill(Color.RED);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        GridPane root = new GridPane();
        root.add(namelbl, 0, 1);
        root.add(nametxt, 1, 1);
        root.add(passlbl, 0, 2);
        root.add(passtxt, 1, 2);
        root.add(genderlbl, 0, 3);
        root.add(opt1, 0, 4);
        root.add(opt2, 0, 5);
        root.add(subjectlbl, 0, 6);
        root.add(chk1, 0, 7);
        root.add(chk2, 0, 8);
        root.add(chk3, 0, 9);
        root.add(countrylbl, 0, 10);
        root.add(country, 0, 11);
        root.add(submit, 0, 12);
        root.add(errorlbl, 0, 13);
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }

    public boolean validate_form() {
        boolean proceed = true;
        if (nametxt.getText().isEmpty() && proceed == true) {
            errorlbl.setText("Please Enter the Name");
            proceed = false;
        }
        if (passtxt.getText().isEmpty() && proceed == true) {
            errorlbl.setText("Please Enter the Password");
            proceed = false;
        }
        if (opt1.isSelected() == false && opt2.isSelected() == false && proceed == true) {
            errorlbl.setText("Select your Gender");
            proceed = false;
        }
        if (chk1.isSelected() == false && chk2.isSelected() == false && chk3.isSelected() == false
                && proceed == true) {
            errorlbl.setText("Select your Subjects");
            proceed = false;
        }
        if (country.getValue() == null && proceed == true) {
            errorlbl.setText("Select your Country");
            proceed = false;
        }
        return proceed;
    }
}

class student {
    String name;
    String pass;
    String gender;
    String subjects;
    String country;

    public student(String name, String pass, String gender, String subjects, String country) {
        this.name = name;
        this.pass = pass;
        this.gender = gender;
        this.subjects = subjects;
        this.country = country;
    }

    public void insertStudentRecord() throws InstantiationException, IllegalAccessException,
            ClassNotFoundException, SQLException {
        try {
            dbmsconnection dbmsconnect = new dbmsconnection("jdbc:mysql://localhost:3306/vit", "root", "");
            Connection con = dbmsconnect.getConnection();
            System.out.println(subjects);
            String sql = "insert into student1 values (?,?,?,?,?);";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, pass);
            stmt.setString(3, gender);
            stmt.setString(4, subjects);
            stmt.setString(5, country);
            int i = stmt.executeUpdate();
            System.out.println("The value of i is " + i);
            dbmsconnect.closeConnection(con, stmt);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class dbmsconnection {
    String url;
    String username;
    String password;

    public dbmsconnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws InstantiationException, IllegalAccessException,
            ClassNotFoundException, SQLException {
        Connection con = null;
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection Established Successfully");
        return con;
    }

    public void closeConnection(Connection con, Statement stmt) throws SQLException {
        stmt.close();
        con.close();
        System.out.println("The connection is closed");
    }
}