/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.Scanner;
import javafx.event.EventType;

/**
 *
 * @author SalahAbdou
 */
public class BAcc {
    private String name;
    private String cardnum;
    private float bal;
    private int i;                       //counter for array
    public int icursor;                 //cursor for array
    public int prevnextcount=0;           //to know when stop
    public float history[]=new float[5];             //history array
    
    public BAcc(String name,int i, String cardnum, float bal)
    {
    this.name = name;
    this.i=i;
    this.icursor=this.i;
    this.cardnum = cardnum;
    this.bal = bal;
    }
    public void card(String cardnum)
    {
    this.cardnum = cardnum;
    }
    public void balance(float bal)
    {
    this.bal = bal;
    }
    public void deposit(float deposit_amount,float current_balance)
    {   this.prevnextcount=0; 
    current_balance=current_balance+deposit_amount;
    this.bal = current_balance;
    if (this.i>=4)
    this.i=0;
    this.history[this.i]=deposit_amount;
    if (this.i>=4)
    this.i=0;
    else
    this.i++;
    
    this.icursor=this.i;
    }
    public void withdraw(float withdraw_amount,float current_balance)
    {    this.prevnextcount=0;                                                       //add if withdraw>>bal
    current_balance=current_balance-withdraw_amount;
    
    this.history[this.i]=-(withdraw_amount);
    this.bal = current_balance;
    if (this.i>=4)
    this.i=0;
    else
    this.i++;
    
    this.icursor=this.i;
    }
    public float previous()
    {
      
        if (this.icursor==0&&this.history[4]!=0)
        {
            this.icursor=4;
            this.prevnextcount++;
        }
        
        else
        {
            this.prevnextcount++;
            this.icursor--;
        }
        int type = (this.history[this.icursor]>0)? 1 : 0;
        switch (type)
        {
            case 1://deposit
                return this.history[this.icursor];
                
            case 0://withdraw
                return this.history[this.icursor];
                
        }
        return 0;
    }
    public float next()
    {
       
    if (this.icursor==4)
        this.icursor=0;
    else
        this.icursor++;
    int type = (this.history[this.icursor]>0)? 1 : 0;
    switch (type)
        {
        case 1://deposit
            this.prevnextcount--;
            return this.history[this.icursor];
            
        case 0://withdraw
            this.prevnextcount--;
            return this.history[this.icursor];
            
        }
    
    
        
       return 0;
    }
    public boolean validate(String password)
        {
        return this.cardnum.equals(password);
                    
        }
    public float balinq()
    {
    return this.bal;
    }
    public static void main(String[] args) {
        BAcc Acc1 = new BAcc("عم احمد",0,"1999",0);
        Acc1.balance(0);
        Acc1.card("1999");
        
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter Credit Card Number: ");
        String usercard = scan.nextLine();
        while(!(usercard.equals(Acc1.cardnum)))
        {
            System.out.println("Error! No User Found\nEnter new Credit Card Number: ");
            usercard = scan.nextLine();
        }
        System.out.println("User found: "+Acc1.name);
        while(1>0)
        {
        System.out.println("Which operation?\n\t1.Deposit\n\t2.Withdraw\n\t3.Balance Inquiry\n\t4.Previous\t5.Next\n\t6.Exit");
        int operand = scan.nextInt();
        switch(operand)
        {   
            case 3:
                System.out.println("Balance: "+Acc1.bal);
                break;
            case 1:
                System.out.println("Amount to deposit: ");
                float deposit_amount = scan.nextFloat();
                Acc1.deposit(deposit_amount, Acc1.bal);
                System.out.println("Deposit Successful!");
                break;
                
            case 2:
                System.out.println("Amount to withdraw: ");
                float withdraw_amount = scan.nextFloat();
                Acc1.withdraw(withdraw_amount, Acc1.bal);
                System.out.println("Withdrawal Successful!");
                break;
            
            case 4:
                Acc1.previous();
                break;
           
            case 5:
                Acc1.next();
                break;
                
            case 6:
                System.exit(0);
            default:
                System.out.println("Incorrect input please choose :");
        }
    }
    } 
}
