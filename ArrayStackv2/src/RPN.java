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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

public class RPN extends ForthStack {
	
	
	
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
		
		JTextPane errorDisplay = new JTextPane();
		errorDisplay.setEditable(false);
		errorDisplay.setBounds(165, 90, 140, 44);
		frame.getContentPane().add(errorDisplay);
		
		numericEntry = new JTextField();
		numericEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userInput = numericEntry.getText();
				//double userInput = Integer.parseInt(numericEntry.getText());
			}
		});
		numericEntry.setBounds(165, 20, 140, 25);
		frame.getContentPane().add(numericEntry);
		numericEntry.setColumns(10);
		
		
		JTextPane numericDisplay = new JTextPane();
		//numericDisplay.setText("" + top + "");
		numericDisplay.setEditable(false);
		numericDisplay.setBounds(165, 55, 140, 25);
		frame.getContentPane().add(numericDisplay);
		
		
		
		JButton plusButton = new JButton("+");
		plusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter >= 2){  
					try {
						errorDisplay.setText("");
						add();
					} catch (Exception e1) {
						errorDisplay.setText("Error");
					}//add
					numericDisplay.setText("" + stack[0] + "");	
				}
				else {//if counter is less than 2 throw exception
					errorDisplay.setText("Stack does not have enough to add.");
				}
			}
		});
		plusButton.setBounds(66, 145, 71, 40);
		frame.getContentPane().add(plusButton);
		

		
		JButton minusButton = new JButton("-");
		minusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter >= 2) {//if counter is greater than or equal to 2 run
					try {
						errorDisplay.setText("");
						sub();
					} catch (Exception e1) {
						errorDisplay.setText("Error");
					}	
					numericDisplay.setText("" + stack[0] + "");
				}	
				else if(counter < 2) {//if counter is less than 2 throw exception
					errorDisplay.setText("Stack does not have enough to sub.");
				}	
			}
		});
		minusButton.setBounds(147, 145, 76, 40);
		frame.getContentPane().add(minusButton);
		
		JButton multiplyButton = new JButton("*");
		multiplyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter >= 2) {//if counter is greater than or equal to 2 run
					try {
						errorDisplay.setText("");
						mult();
					} catch (Exception e1) {
						errorDisplay.setText("Error");;
					}
					numericDisplay.setText("" + stack[0] + "");

				}		
				else if(counter < 2) {//if counter is less than 2 throw exception
					errorDisplay.setText("Stack does not have enough to mult.");
				}
			}
		});
		multiplyButton.setBounds(66, 196, 71, 40);
		frame.getContentPane().add(multiplyButton);
		
		JButton divideButton = new JButton("/");
		divideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter >= 2) {//if counter is greater than or equal to 2 run
					try {
						errorDisplay.setText("");
						div();
					} catch (Exception e1) {
						errorDisplay.setText("Error");
					}
				}		
				else if(counter < 2) {//if counter is less than 2 throw exception
					errorDisplay.setText("Stack does not have enough to mult.");
				}
			}
		});
		divideButton.setBounds(147, 196, 76, 40);
		frame.getContentPane().add(divideButton);
		
		JButton dupButton = new JButton("dup");
		dupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isEmpty() && counter < capacity) {//if array isn't empty and counter is less than capacity then run
					try {
						dup();
					} catch (Exception e1) {
						errorDisplay.setText("Error");
					}
				}	
				else if(counter == capacity) {//if capacity left is less than 2 throw exception
				errorDisplay.setText("Stack is full cannot duplicate");
				}
				else if (isEmpty()) {//if array is empty throw exception
				errorDisplay.setText("Stack is empty cannot duplicate");
				}
			}
		});
		dupButton.setBounds(66, 247, 71, 40);
		frame.getContentPane().add(dupButton);
		
		JButton twodupButton = new JButton("2dup");
		twodupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((capacity - counter) >= 2) {//if capacity left is greater than or equal to two then run
					try {
						twoDup();
					} catch (Exception e1) {
						errorDisplay.setText("Error");
					}
				}		
				else if((counter - capacity) < 2 ) {//if capacity left is less than 2 throw exception
					errorDisplay.setText("Stack is does not have two available indices and cannot duplicate twice");
				}
				else if (isEmpty()) {//if array is empty throw exception
					errorDisplay.setText("Stack is empty cannot duplicate twice");
				}
			}
		});
		twodupButton.setBounds(147, 247, 76, 40);
		frame.getContentPane().add(twodupButton);
		
		JButton clrButton = new JButton("clr");
		clrButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					errorDisplay.setText("");
					clear();
					numericDisplay.setText("" + stack[0] + "");
				} catch (Exception e1) {
					errorDisplay.setText("Error");
				}
			}
		});
		clrButton.setBounds(233, 145, 77, 40);
		frame.getContentPane().add(clrButton);
		
		JButton popButton = new JButton("pop");
		popButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isEmpty()) {//checks if empty
					try {
						errorDisplay.setText("");
						pop();
					} catch (Exception e1) {
						errorDisplay.setText("Error");
					}
					numericDisplay.setText("" + stack[0] + "");
				}
				
				else {
					errorDisplay.setText("Stack is empty: cannot pop!");//error message for empty stack
				}
				
			}
		});
		popButton.setBounds(233, 196, 77, 40);
		frame.getContentPane().add(popButton);
		
		JButton pushButton = new JButton("push");
		pushButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userInput1 = numericEntry.getText();

				if (userInput1 == null) {
					if(counter < capacity) {
					double userInput2 = Integer.parseInt(numericEntry.getText());//get user input
					try {
						errorDisplay.setText(" ");
						push(userInput2);//push
					} catch (Exception e1) {
						errorDisplay.setText("Error");
					}
					numericDisplay.setText("" + stack[0] + "");
					}
						
					else {
						errorDisplay.setText("Stack overflow");
					}
				}
				else {
					errorDisplay.setText("Must enter a user input to push");
				}
				
				
			}
		});
		pushButton.setBounds(233, 247, 77, 40);
		frame.getContentPane().add(pushButton);
		
		JLabel lblUserInput = new JLabel("User Input:");
		lblUserInput.setBounds(66, 25, 71, 14);
		frame.getContentPane().add(lblUserInput);
		
		JLabel lblTopOfStack = new JLabel("Top of Stack:");
		lblTopOfStack.setBounds(66, 68, 74, 14);
		frame.getContentPane().add(lblTopOfStack);
		
		JLabel lblErrorMessage = new JLabel("Error Message:");
		lblErrorMessage.setBounds(66, 108, 89, 14);
		frame.getContentPane().add(lblErrorMessage);
		
		
		
		
	}
}
