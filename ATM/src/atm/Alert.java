/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Window;
/**
 *
 * @author SalahAbdou
 */
public class Alert {
    public static void alert(String title, String message)
    {
    Stage window = new Stage();
    
    window.initModality(Modality.APPLICATION_MODAL);
    window.setAlwaysOnTop(true);
    window.setTitle(title);
    window.setMinWidth(250);
    
    Label label = new Label();
    label.setText(message);
    Button close = new Button("Close");
    close.setOnAction(e -> window.close());
    
    VBox layout = new VBox(10);
    layout.getChildren().addAll(label, close);
    layout.setAlignment(Pos.CENTER);
    
    Scene scene = new Scene(layout);
    window.setScene(scene);
    window.show();
    }
}
