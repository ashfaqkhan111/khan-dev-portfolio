import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
	public class calculator {

	  public static void main(String [] args) {

		JFrame window = new JFrame ("Calculator");

		window.setSize(400, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);

		window.setVisible(true);
		
		JTextField display = new JTextField ();
		display.setEditable(false);
		display.setHorizontalAlignment(JTextField.RIGHT);

		window.add(display, BorderLayout.NORTH);
		window.setVisible(true);




	}




}
