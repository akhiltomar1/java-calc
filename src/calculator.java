import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class calculator implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton add,sub,mul,div,dec,eq,del,clr,neg;
    JPanel panel;

    double num1 = 0, num2 = 0, result= 0;
    char opr;


    calculator(){

        frame = new JFrame("CALCULATOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setEditable(false);

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        dec = new JButton(".");
        eq = new JButton("=");
        del = new JButton("Delete");
        clr = new JButton("Clear");
        neg = new JButton("(-)");

        functionButtons[0] = add;
        functionButtons[1] = sub;
        functionButtons[2] = mul;
        functionButtons[3] = div;
        functionButtons[4] = dec;
        functionButtons[5] = eq;
        functionButtons[6] = del;
        functionButtons[7] = clr;
        functionButtons[8] = neg;

        for(int i = 0;i < 9;i++){

            functionButtons[i].addActionListener(this);
            functionButtons[i].setFocusable(false);

        }

        for(int i = 0;i < 10;i++){

            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);

        }

        neg.setBounds(50,430,70,50);
        del.setBounds(150,430,70,50);
        clr.setBounds(230,430,70,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(add);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(sub);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mul);
        panel.add(dec);
        panel.add(numberButtons[0]);
        panel.add(eq);
        panel.add(div);





        frame.add(panel);
        frame.add(neg);
        frame.add(del);
        frame.add(clr);
        frame.add(textfield);
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        calculator clc = new calculator();
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        for(int i = 0;i<10;i++){

            if(actionEvent.getSource() == numberButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
            if(actionEvent.getSource() == dec){
                textfield.setText(textfield.getText().concat(String.valueOf(".")));
            }

            if(actionEvent.getSource() == add){

                num1 = Double.parseDouble(textfield.getText());
                opr = '+';
                textfield.setText("");
            }

            if(actionEvent.getSource() == sub){

                num1 = Double.parseDouble(textfield.getText());
                opr = '-';
                textfield.setText("");
            }
            if(actionEvent.getSource() == mul){

                num1 = Double.parseDouble(textfield.getText());
                opr = '*';
                textfield.setText("");
            }
            if(actionEvent.getSource() == div){

                num1 = Double.parseDouble(textfield.getText());
                opr = '/';
                textfield.setText("");
            }

            if(actionEvent.getSource() == eq){

                num2 = Double.parseDouble(textfield.getText());
                switch(opr){

                    case'+':
                        result=num1+num2;
                        break;
                    case'-':
                        result=num1-num2;
                        break;
                    case'*':
                        result=num1*num2;
                        break;
                    case'/':
                        result=num1/num2;
                        break;

                }

                textfield.setText(String.valueOf(result));

                num1=result;

            }

        if(actionEvent.getSource() == clr){
            textfield.setText("");
        }

        if(actionEvent.getSource() == del){

            String string = textfield.getText();
            textfield.setText("");
            for(int i = 0;i < string.length()-1;i++){
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }

        if(actionEvent.getSource() == neg){

            double temp = Double.parseDouble(textfield.getText());
            temp*=-1;
            textfield.setText(String.valueOf(temp));
        }


        }
    }


