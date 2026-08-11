import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




	public class calculator {

	  public static void main(String [] args) {

		JFrame window = new JFrame ("Calculator");

		window.setSize(400, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);

		window.setVisible(true);
		
		JTextField display = new JTextField ("0");
		display.setEditable(false);
		display.setHorizontalAlignment(JTextField.RIGHT);

		display.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 32));

		JPanel buttonPanel = new JPanel();

		buttonPanel.setLayout(new GridLayout(4,4,5,5));
		
		JButton button7 = new JButton("7");
		JButton button8 = new JButton("8");
		JButton button9 = new JButton("9");
		JButton buttonDivide = new JButton("/");

		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		JButton button6 = new JButton("6");
		JButton buttonMultiply = new JButton("x");

		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton buttonMinus = new JButton("-");

		JButton button0 = new JButton("0");
		JButton buttonDecimal = new JButton(".");
		JButton buttonEqual = new JButton("=");
		JButton buttonPlus = new JButton("+");


		buttonPanel.add(button7);
		buttonPanel.add(button8);
		buttonPanel.add(button9);
		buttonPanel.add(buttonDivide);

		buttonPanel.add(button4);
		buttonPanel.add(button5);
		buttonPanel.add(button6);
		buttonPanel.add(buttonMultiply);

		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		buttonPanel.add(buttonMinus);

		buttonPanel.add(button0);
		buttonPanel.add(buttonDecimal);
		buttonPanel.add(buttonEqual);
		buttonPanel.add(buttonPlus);
		window.add(display,BorderLayout.NORTH);
		window.add(buttonPanel, BorderLayout.CENTER);

		window.setVisible(true);


		ActionListener numberListener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				JButton clickedButton = (JButton) e.getSource();
				String number = clickedButton.getText();

				if (display.getText().equals("0")){
					display.setText(number);
					}
					else{display.setText(display.getText()+number);}
				}

				};

		button0.addActionListener(numberListener);
		button1.addActionListener(numberListener);
		button2.addActionListener(numberListener);
		button3.addActionListener(numberListener);
		button4.addActionListener(numberListener);
		button5.addActionListener(numberListener);
		button6.addActionListener(numberListener);
		button7.addActionListener(numberListener);
		button8.addActionListener(numberListener);
		button9.addActionListener(numberListener);

	}




}
