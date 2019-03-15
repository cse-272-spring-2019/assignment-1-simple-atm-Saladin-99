/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
public class WithDepo {
    static public float amount=0;
    
    
    private StringProperty valuest = new SimpleStringProperty(this,"0","0") ;
    
       public String getValuest() {
        return valuest.get();
    }

    
    public void setValuest(String valuest) {
        this.valuest.set(valuest);
    }

    
    public static BAcc Deposit0withdraw1 (int type, BAcc Acc)
    { 
        
    WithDepo value = new WithDepo();
    Stage window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setAlwaysOnTop(true);
    
          TextField txt = new TextField("");
          Label label = new Label("Enter Amount:");
    
          Button bclear = new Button("Clear");
          bclear.setOnAction(e -> txt.setText(""));
          Button b1 = new Button("1");
          b1.setOnAction(e -> txt.appendText("1"));
          Button b2 = new Button("2");
          b2.setOnAction(e -> txt.appendText("2"));
          Button b3 = new Button("3");
          b3.setOnAction(e -> txt.appendText("3"));
          Button b4 = new Button("4");
          b4.setOnAction(e -> txt.appendText("4"));
          Button b5 = new Button("5");
          b5.setOnAction(e -> txt.appendText("5"));
          Button b6 = new Button("6");
          b6.setOnAction(e -> txt.appendText("6"));
          Button b7 = new Button("7");
          b7.setOnAction(e -> txt.appendText("7"));
          Button b8 = new Button("8");
          b8.setOnAction(e -> txt.appendText("8"));
          Button b9 = new Button("9");
          b9.setOnAction(e -> txt.appendText("9"));
          Button b0 = new Button("0");
          b0.setOnAction(e -> txt.appendText("0"));
          Button bgo = new Button("Enter");
          
          bgo.setOnAction(e ->
          {
            if (!"\0".equals(txt.getText()))
            {
            value.setValuest(txt.getText());
            amount = Float.parseFloat(value.getValuest());
            if(Acc.balinq()<amount&&type==1)
            Alert.alert("Error!", "Insufficient funds.");
            else
            {
            switch(type)
          {     
              case 0:
                  
                  
                  Acc.deposit(amount, Acc.balinq());
                            
                  if((Acc.icursor<4&&Acc.history[Acc.icursor+1]==0)||Acc.prevnextcount==0)
              ATM.bnext.setDisable(true);
              else
                  ATM.bnext.setDisable(false);
    
      if((Acc.prevnextcount==5)||(Acc.icursor==0&&Acc.history[4]==0))
          ATM.bprev.setDisable(true);
          else
              ATM.bprev.setDisable(false);
          ATM.lab3.setText("Deposit Successful!");
                  window.close();
              
                  break;
              case 1:
                  
                  Acc.withdraw(amount, Acc.balinq());
                  

        
    if(Acc.history[Acc.icursor]==0||Acc.prevnextcount==0)
              ATM.bnext.setDisable(true);
              else
                 ATM.bnext.setDisable(false);
    
      if((Acc.prevnextcount==5)||(Acc.icursor==0&&Acc.history[4]==0))
          ATM.bprev.setDisable(true);
          else
              ATM.bprev.setDisable(false);
    ATM.lab3.setText("Withdrawal Successful!");
                  window.close();
                  break;
          
            }
            }
            }
          });
          
                 
             if(type==1)
                 window.setTitle("Withdraw Money");
             else
                 window.setTitle("Deposit Money");
          
          GridPane layout1 = new GridPane();
          
          
          
        
          
          layout1.setVgap(20); 
          layout1.setHgap(10);
          layout1.setPadding(new Insets(10, 50, 10, 50));
          
          layout1.add(b1, 0, 2);
          layout1.add(b2, 1, 2);
          layout1.add(b3, 2, 2);
          layout1.add(b4, 0, 3);
          layout1.add(b5, 1, 3);
          layout1.add(b6, 2, 3);
          layout1.add(b7, 0, 4);
          layout1.add(b8, 1, 4);
          layout1.add(b9, 2, 4);
          layout1.add(b0, 1, 5);
          layout1.add(bgo, 2, 5);
          layout1.add(bclear, 0, 5);
          layout1.add(txt, 1, 0);
          layout1.add(label, 0, 0);
          layout1.setMinSize(50,300);
          
          Scene scene = new Scene(layout1);
          window.setScene(scene);
          window.show();
    
    return Acc;
    }



   
    
   
}
