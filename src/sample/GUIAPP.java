
package sample;
import javafx.event.EventHandler;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.ButtonBase;
//import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
//import javafx.scene.layout.Pane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
//import javafx.scene.layout.HBox;

//import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIAPP extends Application  {




    Stage window ;
    Scene scene1,scene2,scene3,scene4,scene5,scene6,scene7,scene8,scene9;


    Button b1,button1,button2,button3,button4,button5,button6;
    int index=0;


    public static void main(String[] args) {


        launch(args);
    }
    @Override

    public void start(Stage primaryStage) throws Exception{






        ATMmachine machine= new ATMmachine();
        machine.setBalance(0);
        window = primaryStage;



        primaryStage.setTitle("ATM machine");
        Label cardNO= new Label("Enter Your Card Number: ");
        Label password= new Label(" Enter Password:    "); //password variable label password
        Label resultLabel= new Label();
        PasswordField pass= new PasswordField(); // pass variable PasswordField
        TextField cardNumber=new TextField();
        GridPane grid = new GridPane();
        b1 = new Button("Done");
        grid.add(cardNO,3,4); // cardNo variable label
        grid.add(password,3,5);
        grid.add(pass,4,5);
        grid.add(cardNumber,4,4);//cardNumber variable TextField
        grid.add(b1,4,9);
        grid.add(resultLabel, 4,11);
        b1.setOnAction( new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                String Password=pass.getText();
                String cardnumber= cardNumber.getText();
                boolean valid= machine.validate(cardnumber,Password);
                if(valid) {


                    window.setScene(scene2);
                }
                else resultLabel.setText("Wrong card number or username");
            }

        });
        scene1= new Scene(grid,350,350);

        // scene 2 the five buttons
        BorderPane root= new BorderPane();

        primaryStage.setTitle(" Atm Machine ");
        button1 = new Button("Deposit");
        button2 = new Button("Withdraw");
        button3 = new Button("Balance Inquiry");
        button4 = new Button("Previous");
        button5 = new Button("Next");
        button6 = new Button("Exit");
        //  Label transaction = new Label("What transaction you want?");



        VBox vb = new VBox(20);
        VBox vb1= new VBox(20);
        VBox vb2= new VBox(20);

        button1.setPrefHeight(400);
        button2.setPrefHeight(400);
        button3.setPrefHeight(400);
        button1.setPrefWidth(100);
        button2.setPrefWidth(100);
        button3.setPrefWidth(100);
        button4.setPrefHeight(75);
        button5.setPrefHeight(75);
        button4.setPrefWidth(90);
        button5.setPrefWidth(90);
        button6.setPrefWidth(90);
        button6.setPrefHeight(75);


        vb.setSpacing(30);
        vb.setPadding(new Insets(100));

        vb.getChildren().addAll(button1,button2,button3);
        vb1.getChildren().addAll(button4);
        vb2.getChildren().addAll(button5);
        root.setCenter(vb);
        root.setLeft(vb1);
        root.setRight(vb2);
        root.setBottom(button6);
        scene2 = new Scene(root,500,500);
        button1.setOnAction(e-> window.setScene(scene3));

// scene 3 the place to deposit money in

        Button b6 = new Button("Done");
        Button back2= new Button("Back");
        TextField deposit= new TextField();
        GridPane grid2= new GridPane();
        Label depositLabel= new Label("Enter money to deposit:   ");
        grid2.add(depositLabel,0,2);
        grid2.add(deposit,1,2);
        grid2.add(b6,1,4);
        grid2.add(back2,1,8);
        Button back= new Button("Back ");

        b6.setOnAction(e->{

                    int n= Integer.parseInt(deposit.getText());

                    machine.deposit(n);
                    int valid1=machine.getBalance();



                    Label validResult= new Label();
                    GridPane grid3 = new GridPane();
                    grid3.add(back,3,5);
                    grid3.add(validResult,2,4);
                    validResult.setText("The money after deposit : " + valid1);
                    scene4= new Scene(grid3,350,350);
                    window.setScene(scene4);


                }
        );
        back.setOnAction(e-> window.setScene(scene2));
        back2.setOnAction(e->window.setScene(scene2));

        scene3 = new Scene(grid2,400,350);

        //scene 5 withdraw money
        button2.setOnAction(e-> window.setScene(scene5));

        Button b7= new Button("Done");
        Label withdrawLabel= new Label("Enter the amount of money to withdraw:  ");
        TextField withdrawField= new TextField();
        GridPane grid4= new GridPane();
        grid4.add(withdrawLabel,2,1);
        grid4.add(withdrawField,2,3);
        grid4.add(b7,2,4);
        Button back1= new Button("Back");

        b7.setOnAction(e->{

            int s=machine.getBalance();
            int k= Integer.parseInt(withdrawField.getText());
            machine.withdraw(k);
            int valid3 =machine.getBalance();



            Label validationResult= new Label();
            GridPane grid5= new GridPane();

            grid5.add(validationResult,5,4);
            grid5.add(back1,6,7);

            scene6 = new Scene (grid5,350,350);
            window.setScene(scene6);

            if(valid3==s){

                validationResult.setText(" you can't withdraw money sorry try again!");

            }
            else{
                validationResult.setText(" Balance after withdrawing:" + valid3);




            }
            scene6 = new Scene (grid5,450,350);
            window.setScene(scene6);
        });
        back1.setOnAction( e->window.setScene(scene2));

        scene5= new Scene(grid4,350,350);

// scene 6 balance inquiry

        Button back3= new Button(" Back");
        button3.setOnAction(e-> {

            machine.balanceInquiry();
            Label balanceResult= new Label();
            balanceResult.setText(" You current Balance is " + machine.getBalance());
            GridPane grr = new GridPane();
            grr.add(balanceResult,5,5);
            grr.add(back3,6,7);
            scene7= new Scene(grr,300,300);
            window.setScene(scene7);
        });

        back3.setOnAction(e-> {
            window.setScene(scene2);
        });

// scene 8 for previous button
        Button back4= new Button("Back");
        button4.setOnAction(e->{


            Label prev= new Label();
            //  int u=machine.getI();
            prev.setText(machine.showPrevNext(index++));
            GridPane grr1 = new GridPane();
            grr1.add(back4,4,7);
            grr1.add(prev,2,4);
            scene8= new Scene(grr1,350,300);
            window.setScene(scene8);



        });
        back4.setOnAction(e->{

            window.setScene(scene2);

        });
// scene 9 for next button

        Button back5= new Button("Back");
        button5.setOnAction(e->{


            Label next= new Label();
            //  int m= machine.getI();
            next.setText(machine.showPrevNext(index--));
            GridPane grr2 = new GridPane();
            grr2.add(back5,4,7);
            grr2.add(next,3,3);
            scene9= new Scene(grr2,350,300);
            window.setScene(scene9);


        });

        back5.setOnAction(e->{

            window.setScene(scene2);

        });
        button6.setOnAction(e->{
           machine.exit();
        });



        window.setScene(scene1);

        window.show();

    }


}

