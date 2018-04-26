import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextPane;

public class RPN {

	private JFrame frame;
	private JTextField numericEntry;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RPN window = new RPN();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RPN() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton plusButton = new JButton("+");
		plusButton.setBounds(88, 136, 61, 40);
		frame.getContentPane().add(plusButton);
		
		numericEntry = new JTextField();
		numericEntry.setBounds(78, 22, 229, 25);
		frame.getContentPane().add(numericEntry);
		numericEntry.setColumns(10);
		
		JTextPane numericDisplay = new JTextPane();
		numericDisplay.setEditable(false);
		numericDisplay.setBounds(78, 58, 229, 25);
		frame.getContentPane().add(numericDisplay);
		
		JTextPane errorDisplay = new JTextPane();
		errorDisplay.setEditable(false);
		errorDisplay.setBounds(78, 94, 229, 25);
		frame.getContentPane().add(errorDisplay);
		
		JButton minusButton = new JButton("-");
		minusButton.setBounds(159, 136, 61, 40);
		frame.getContentPane().add(minusButton);
		
		JButton multiplyButton = new JButton("*");
		multiplyButton.setBounds(88, 187, 61, 40);
		frame.getContentPane().add(multiplyButton);
		
		JButton divideButton = new JButton("/");
		divideButton.setBounds(159, 187, 61, 40);
		frame.getContentPane().add(divideButton);
		
		JButton dupButton = new JButton("dup");
		dupButton.setBounds(88, 238, 61, 40);
		frame.getContentPane().add(dupButton);
		
		JButton twodupButton = new JButton("2dup");
		twodupButton.setBounds(159, 238, 61, 40);
		frame.getContentPane().add(twodupButton);
		
		JButton clrButton = new JButton("clr");
		clrButton.setBounds(230, 136, 61, 40);
		frame.getContentPane().add(clrButton);
		
		JButton popButton = new JButton("pop");
		popButton.setBounds(230, 187, 61, 40);
		frame.getContentPane().add(popButton);
		
		JButton pushButton = new JButton("push");
		pushButton.setBounds(230, 238, 61, 40);
		frame.getContentPane().add(pushButton);
	}
}
