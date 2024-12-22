import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Calculator implements ActionListener{
    JButton[] numberButtons = new JButton[10];
    JFrame frame;
    JTextField textfield;
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, delButton, clrButton, eqButton;
    JPanel panel;
    Font myFont = new Font("Ink free",Font.BOLD,30);
    double num1=0, num2 = 0, result = 0;
    char operator;

    // conctructor
    Calculator(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,500);
        frame.setLayout(null);
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        eqButton = new JButton("=");
        decButton = new JButton(".");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = clrButton;
        functionButtons[5] = delButton;
        functionButtons[6] = eqButton;
        functionButtons[7] = decButton;
        
        for (int i=0 ; i < 8 ; i++ ){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false); 
        }

        for (int i=0 ; i < 10 ; i++ ){
            numberButtons[i] = new JButton(String.valueOf(i)) ;
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        delButton.setBounds(50,430,150,50);
        clrButton.setBounds(200,430,150,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.GRAY);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[9]);
        panel.add(numberButtons[9]);
        panel.add(numberButtons[0]);
        panel.add(functionButtons[0]);
        panel.add(functionButtons[1]);
        panel.add(functionButtons[2]);
        panel.add(functionButtons[3]);
        panel.add(functionButtons[4]);
        panel.add(functionButtons[5]);
        panel.add(functionButtons[6]);
        panel.add(functionButtons[7]);
    
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);

    }
    public static void main(String[] args){
        // instance of calculator
        Calculator clac = new Calculator();

    }
    public void actionPerformed (ActionEvent e){
        for (int i = 0; i < 10; i++){
            if(e.getSource()  == numberButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));

            }
        }
        if (e.getSource() == decButton){
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == addButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+' ;
            textfield.setText("");

        }
        if (e.getSource() == subButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == mulButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if (e.getSource() == divButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if (e.getSource() == eqButton){
            num2 = Double.parseDouble(textfield.getText());
            
            switch (operator) {
                case '+':
                    result = num1 + num2;

                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
            
        }
        if(e.getSource()== clrButton){
            textfield.setText(" ");
        }
        if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
        }
         

    }
}
