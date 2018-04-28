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
	
	
	
	private JFrame frame;//main frame
	private JTextField numericEntry; //text field
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Create the event queue
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RPN window = new RPN();
					//shows the main frame
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();//exception
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

	//initialize frame contents
	private void initialize() {
		frame = new JFrame();//frame
		frame.setTitle("RPN Calculator");//title
		frame.setBounds(100, 100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane errorDisplay = new JTextPane();//errorDisplay field
		errorDisplay.setEditable(false);//uneditable
		errorDisplay.setBounds(165, 90, 140, 44);
		frame.getContentPane().add(errorDisplay);
		
		
		
		numericEntry = new JTextField();//numericEntry field
		numericEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userInput = numericEntry.getText();
			}
		});
		numericEntry.setBounds(165, 20, 140, 25);
		frame.getContentPane().add(numericEntry);
		numericEntry.setColumns(10);
		numericEntry.requestFocusInWindow();
		
		JTextPane numericDisplay = new JTextPane();//numericDisplay field
		//numericDisplay.setText("" + top + "");
		numericDisplay.setEditable(false);//non editable
		numericDisplay.setBounds(165, 55, 140, 25);
		frame.getContentPane().add(numericDisplay);
		
		
		
		JButton plusButton = new JButton("+");//plus button
		plusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter >= 2){//if counter is greater than or equal to 2 run  
					try {
						add();	//add	method		
						errorDisplay.setText(null);//sets errorDisplay to null
						numericDisplay.setText("" + stack[0] + "");	//shows top of stack
						numericEntry.setText(null);//sets numericEntry to null
						numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
					} catch (Exception e1) {
						errorDisplay.setText("Error");
					}
				}
				else {//if counter is less than 2 throw exception
					errorDisplay.setText("Stack does not have enough to add.");
					numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
				}
			}
		});
		plusButton.setBounds(66, 145, 71, 40);
		frame.getContentPane().add(plusButton);
		

		
		JButton minusButton = new JButton("-");//sub button
		minusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter >= 2) {//if counter is greater than or equal to 2 run
					try {
						sub();//sub method
						errorDisplay.setText(null);//sets errorDisplay to null
						numericDisplay.setText("" + stack[0] + "");	//shows top of stack
						numericEntry.setText(null);//sets numericEntry to null
						numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
					} catch (Exception e1) {
						errorDisplay.setText("Error");
					}	
				}	
				else if(counter < 2) {//if counter is less than 2 throw exception
					errorDisplay.setText("Stack does not have enough to sub.");
					numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
				}	
			}
		});
		minusButton.setBounds(147, 145, 76, 40);
		frame.getContentPane().add(minusButton);
		
		JButton multiplyButton = new JButton("*");//mult button
		multiplyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter >= 2) {//if counter is greater than or equal to 2 run
					try {
						mult();//mult method
						errorDisplay.setText(null);//sets errorDisplay to null
						numericDisplay.setText("" + stack[0] + "");	//shows top of stack
						numericEntry.setText(null);//sets numericEntry to null
						numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
					} catch (Exception e1) {
						errorDisplay.setText("Error");;
					}
				}		
				else if(counter < 2) {//if counter is less than 2 throw exception
					errorDisplay.setText("Stack does not have enough to mult.");
					numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
				}
			}
		});
		multiplyButton.setBounds(66, 196, 71, 40);
		frame.getContentPane().add(multiplyButton);
		
		JButton divideButton = new JButton("/");//div button
		divideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter >= 2) {//if counter is greater than or equal to 2 run
					try {
						div();//dive method						
						errorDisplay.setText(null);//sets errorDisplay to null
						numericDisplay.setText("" + stack[0] + "");	//shows top of stack
						numericEntry.setText(null);//sets numericEntry to null
						numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
					} catch (Exception e1) {
						errorDisplay.setText("Error");
					}
				}		
				else if(counter < 2) {//if counter is less than 2 throw exception
					errorDisplay.setText("Stack does not have enough to mult.");
					numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
				}
			}
		});
		divideButton.setBounds(147, 196, 76, 40);
		frame.getContentPane().add(divideButton);
		
		JButton dupButton = new JButton("dup");//dup button
		dupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isEmpty() && counter < capacity) {//if array isn't empty and counter is less than capacity then run
					try {
						dup();//dup method
						errorDisplay.setText(null);//sets errorDisplay to null
						numericDisplay.setText("" + stack[0] + "");	//shows top of stack
						numericEntry.setText(null);//sets numericEntry to null
						numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
					} catch (Exception e1) {
						errorDisplay.setText("Error");
					}
				}	
				else if(counter == capacity) {//if capacity left is less than 2 throw exception
				errorDisplay.setText("Stack is full cannot duplicate");
				numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
				}
				else if (isEmpty()) {//if array is empty throw exception
				errorDisplay.setText("Stack is empty cannot duplicate");
				numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
				}
			}
		});
		dupButton.setBounds(66, 247, 71, 40);
		frame.getContentPane().add(dupButton);
		
		JButton twodupButton = new JButton("2dup");//2dup button
		twodupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((capacity - counter) >= 2) {//if capacity left is greater than or equal to two then run
					try {
						twoDup(); //twoDup method
						errorDisplay.setText(null);//sets errorDisaply to null
						numericDisplay.setText("" + stack[0] + "");	//shows top of stack
						numericEntry.setText(null);//sets numericEntry to null
						numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
					} catch (Exception e1) {
						errorDisplay.setText("Error");
					}
				}		
				else if((counter - capacity) < 2 ) {//if capacity left is less than 2 throw exception
					errorDisplay.setText("Stack is too full and cannot duplicate twice");
					numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
				}
				else if (isEmpty()) {//if array is empty throw exception
					errorDisplay.setText("Stack is empty cannot duplicate twice");
					numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
				}
			}
		});
		twodupButton.setBounds(147, 247, 76, 40);
		frame.getContentPane().add(twodupButton);
		
		JButton clrButton = new JButton("clr");//clr button
		clrButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					clear();//clear method
					errorDisplay.setText(null);//sets errorDisplay to nu
					numericDisplay.setText("" + stack[0] + "");	//shows top of stack
					numericEntry.setText(null);//sets numericEntry to null
					numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
				} catch (Exception e1) {
					errorDisplay.setText("Error");
				}
			}
		});
		clrButton.setBounds(233, 145, 77, 40);
		frame.getContentPane().add(clrButton);
		
		JButton popButton = new JButton("pop"); //pop button
		popButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isEmpty()) {//checks if empty
					try {
						pop();//pop method
						numericDisplay.setText("" + stack[0] + "");	//shows top of stack
						errorDisplay.setText(null);//sets errorDisplay to null
						numericEntry.setText(null);//sets numericEntry to null
						numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
					} catch (Exception e1) {
						errorDisplay.setText("Error");
					}
				}
				
				else {
					errorDisplay.setText("Stack is empty: cannot pop!");//error message for empty stack
				}
				
			}
		});
		popButton.setBounds(233, 196, 77, 40);
		frame.getContentPane().add(popButton);
		
		JButton pushButton = new JButton("push"); //push button
		pushButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userInput1 = numericEntry.getText();//used to check if user has inputed data

				if (!userInput1.isEmpty()) {
					if(counter < capacity) {
						double userInput2 = Integer.parseInt(numericEntry.getText());//get user input
						try {
							push(userInput2);//push method
							numericDisplay.setText("" + stack[0] + "");	//shows top of stack
							errorDisplay.setText(null);//sets errorDisplay to null
							numericEntry.setText(null);//sets numericEntry to null
							numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
						} catch (Exception e1) {
							errorDisplay.setText("Error");
						}
					}
					else {
						errorDisplay.setText("Stack overflow");//stack overflow error
					}
				}
				else {
					errorDisplay.setText("Must enter a user input to push");//error for no input
				}
			}
		});
		pushButton.setBounds(233, 247, 77, 40);
		frame.getContentPane().add(pushButton);
		
		JLabel lblUserInput = new JLabel("User Input:");//user input label
		lblUserInput.setBounds(66, 25, 71, 14);
		frame.getContentPane().add(lblUserInput);
		
		JLabel lblTopOfStack = new JLabel("Result");//result label
		lblTopOfStack.setBounds(66, 68, 74, 14);
		frame.getContentPane().add(lblTopOfStack);
		
		JLabel lblErrorMessage = new JLabel("Error Message:");//error message label
		lblErrorMessage.setBounds(66, 108, 89, 14);
		frame.getContentPane().add(lblErrorMessage);
		
		
		
		
	}
}
