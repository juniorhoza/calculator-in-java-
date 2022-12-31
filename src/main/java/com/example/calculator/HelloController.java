package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    public Label equation_label;
    public Label answer_label;


   public void reset(ActionEvent e){
       equation_label.setText("");
   }
    public void WriteToLabel(ActionEvent e) {
       Button butt= (Button) e.getSource();

       if(butt.getText().equals("+") || butt.getText().equals("-") || butt.getText().equals("*")|| butt.getText().equals("/") ){

           equation_label.setText(equation_label.getText() + " "+butt.getText() + " ");
       }
       else{
           equation_label.setText(equation_label.getText() + butt.getText());

       }
    }

    public void sqaureRoot(ActionEvent e){
       try {
           int number = Integer.parseInt(equation_label.getText().trim());
           double answer = Math.sqrt(number);
           answer_label.setText(answer + " ");
       }
       catch (NumberFormatException ex){
           answer_label.setText("impossible to convert equation");
       }
    }
    public void showanswer(){
       String[] equation = equation_label.getText().split(" ");
            double answer=0;

            double a=0,b=0;
            try{
                a= Double.parseDouble(equation[0]);
                b= Double.parseDouble(equation[2]);

            }
            catch (NumberFormatException ex){
                answer_label.setText("invalid equation");
            }
        for (int i = 1; i < equation.length; i+=2) {
            if(i!=1){
                a= answer;
                try {
                    b=Double.parseDouble( equation[i+1]);

                }  catch (NumberFormatException ex){
                    answer_label.setText("invalid equation");
                }

            }
            if(equation[i].equals("+")){
               answer= addition(a,b);
            }
            else if(equation[i].equals("*") ){
                answer= multiplicaiton(a,b);
            }
            else if(equation[i].equals("/") ){
                answer= division(a,b);
            }
            else if(equation[i].equals("-") ){
                answer= subtraction(a,b);
            }
        }

//        String[] answersplited = Double.toString(answer).split(".");
//        System.out.println(answersplited.length);
//        for(String i:answersplited){
//            System.out.println(i);
//        }
//        if(answersplited.length==0 && answersplited[1].equals(0)){
//            int integerAnswer = Integer.parseInt(Double.toString(answer).substring(0,0));
//            answer_label.setText(integerAnswer+"");
//
//        }else{
            answer_label.setText(answer + " ");
//       /////was trying to remove the trailing 0 in every answer
//        }
    }
//basic calculations
    public double addition(double a, double b){
       return a+b;
    }
    public double multiplicaiton(double a, double b){
        return a*b;
    }
    public double subtraction(double a, double b){
        return a-b;
    }
    public double division(double a, double b){
        try{
            return  a/b;
        }
        catch(Exception ex){
            return 0;
        }
    }
}