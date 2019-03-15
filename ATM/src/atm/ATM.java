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
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Window;
/**
 *
 * @author SalahAbdou
 */
public class ATM extends Application implements EventHandler<ActionEvent>
{
    BAcc Acc = new BAcc("عم احمد",0,"1999",0);
        
    Stage MainWindow, D_W_Window, Error;
    Scene page1, page2, page3;
    Label lab2 = new Label("Please Enter Credit Card Pass: ");
    public static Label lab3 = new Label ("");
          Button bclear = new Button("Clear");
         
          Button bgo = new Button("Enter");
          Button bD = new Button("Deposit");
          Button bW = new Button("Withdraw");
          public static Button bprev = new Button("Previous");
          public static Button bnext = new Button("Next");
          Button bbalinq = new Button("Bal. Inquiry");
    TextField txt1 = new PasswordField();
          GridPane layout1 = new GridPane();
          GridPane layout2 = new GridPane();
    public static void main(String[] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception 
        {
          MainWindow = stage;
          
          
          
          layout1.setVgap(5); 
          layout1.setHgap(5);
          layout1.setPadding(new Insets(10, 10, 10, 10)); 
          layout1.setAlignment(Pos.CENTER);
          layout1.add(txt1, 2, 3);
          layout1.add(lab2, 2, 1);
          bclear.setOnAction(this);
          bgo.setOnAction(this);
          /*layout1.add(b1, 0, 2);
          layout1.add(b2, 1, 2);
          layout1.add(b3, 2, 2);
          layout1.add(b4, 1, 3);
          layout1.add(b5, 2, 3);
          layout1.add(b6, 3, 3);
          layout1.add(b7, 1, 4);
          layout1.add(b8, 2, 4);
          layout1.add(b9, 2, 4);
          layout1.add(b0, 3, 5);*/
          layout1.add(bgo, 3, 5);
          layout1.add(bclear, 1, 5);
          layout1.setMinSize(400,200);
          MainWindow.setTitle("Welcome to Salah Banking System(SBS)");
          page1= new Scene(layout1);
          page2= new Scene(layout2);
          MainWindow.setScene(page1);
          MainWindow.show();
          
          
          
          
          
          layout2.setVgap(50); 
          layout2.setHgap(50);
          layout2.setPadding(new Insets(10, 50, 10, 10)); 
          
          layout2.add(bD, 1, 3);
          layout2.add(bW, 3, 3);
          layout2.add(bbalinq,2,2);
          layout2.add(bprev, 1, 1);
          layout2.add(bnext, 3, 1);
          layout2.add(lab3, 2, 0);
          lab3.setAlignment(Pos.CENTER);
          lab3.setMinWidth(150);
          layout2.setMinSize(50,300);
          bbalinq.setOnAction(this);
          bnext.setOnAction(this);
          bprev.setOnAction(this);
          bD.setOnAction(this);
          bW.setOnAction(this);
          
         bprev.setDisable(true);
          bnext.setDisable(true);
       
          
        }

    @Override
    public void handle(ActionEvent click) {
        if (click.getSource()== bgo)
        {
            String password = txt1.getText();
            if(Acc.validate(password))
            {
            MainWindow.setScene(page2);
            MainWindow.setTitle("SBS Withdrawal/Deposit/Bal Inquiry");
            lab3.setText("User Found!");
            }
            else
            Alert.alert("Access Denied", "Incorrect Password! Re-enter another one");
            
            
        }
        if (click.getSource()== bclear)
        {   txt1.setText("");
            txt1.setText(""); //bug in netbeans
        }
    
        
        
        
        
        
        
        
        if(click.getSource()==bbalinq)
        {
            
            lab3.setText(Float.toString(Acc.balinq()));
        }
        if(click.getSource()==bD)
        {
        Acc=WithDepo.Deposit0withdraw1 (0 , Acc);
        
        }
        
        if(click.getSource()==bW)
        {
        Acc=WithDepo.Deposit0withdraw1 (1 , Acc);
        
        
        }
        if(click.getSource()==bprev)
        {
        float prev = Acc.previous();
        check(0);
        int type = (prev>0)? 1 : 0;
        switch (type)
        {
        case 1://deposit
            
            lab3.setText("Deposit of "+Float.toString(prev));
            
            break;
        case 0://withdraw
            prev=-prev;
            lab3.setText("Withdraw of "+Float.toString(prev));
            
            break;
        }
        }
        if(click.getSource()==bnext)
        {
        float next = Acc.next();
        int type = (next>0)? 1 : 0;
        
        check(1);
        switch (type)
        {
        case 1://deposit
            
            lab3.setText("Deposit of "+Float.toString(next));
            
            break;
        case 0://withdraw
            next=-next;
            lab3.setText("Withdraw of "+Float.toString(next));
            
            break;
        }
        }
    }
    
    public void check(int check)
    {
        
        if(check == 1)
        {
            bprev.setDisable(false);
            
    if((Acc.icursor<4&&Acc.history[Acc.icursor+1]==0)||(Acc.prevnextcount==0||Acc.prevnextcount==1))
        bnext.setDisable(true);
              else
                  bnext.setDisable(false);
        }
        if(check==0)
                       

        { if(Acc.prevnextcount>1)
                bnext.setDisable(false);
      if((Acc.prevnextcount==5)||(Acc.icursor==0&&Acc.history[4]==0))
          bprev.setDisable(true);
          else
              bprev.setDisable(false);
        }
    }
    
 
}
