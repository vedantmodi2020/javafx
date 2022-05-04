import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class javafxmenubar extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        MenuBar main_menu = new MenuBar();
        Menu File = new Menu("File");
        Menu Edit = new Menu("Edit");
        Menu Source = new Menu("Source");
        Menu Refactor = new Menu("Refactor");

        main_menu.getMenus().add(File);
        main_menu.getMenus().add(Edit);
        main_menu.getMenus().add(Source);
        main_menu.getMenus().add(Refactor);
        //Drop down items for the menu
        MenuItem New = new MenuItem("New");
        MenuItem Save = new MenuItem("Save");
        MenuItem Close = new MenuItem("Close");

        File.getItems().add(New);
        File.getItems().add(Save);
        File.getItems().add(Close);

        //Submenu items for the menu items
        MenuItem JavaProject = new MenuItem("Java Project");
        MenuItem Project = new MenuItem("Project");

//        New.getItems().add(JavaProject);
  //      New.getItems().add(Project);

        BorderPane root = new BorderPane();
        root.setTop(main_menu);
        Scene sc = new Scene(root);
        primaryStage.setTitle("JavaFX MENU BAR");
        primaryStage.setScene(sc);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
        
    }
}

