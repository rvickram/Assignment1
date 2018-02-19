/*
By: Ryan Vickramasinghe
 */
package assignment1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author ryanv
 */
public class Assignment1 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {   //main form, loads start window
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.getIcons().add(new Image("file:src/assignment1/WesternLogo.png"));
        stage.setTitle("Assignment 1");
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
