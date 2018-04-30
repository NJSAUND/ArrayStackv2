import java.awt.EventQueue;
import java.awt.Font;

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
	private JTextField txtStack0;
	private JTextField txtStack1;
	private JTextField txtStack3;
	private JTextField txtStack2;
	private JTextField txtStack7;
	private JTextField txtStack6;
	private JTextField txtStack5;
	private JTextField txtStack4;
	private JTextField txtStack9;
	private JTextField txtStack8;
	JTextField[] txtArray;
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
	
	public void showStack() {

		txtArray = new JTextField [10];//creates JTextField Array to store each object
		txtArray[0] = txtStack0;//aligns each txtfield to its designated index
		txtArray[1] = txtStack1;
		txtArray[2] = txtStack2;
		txtArray[3] = txtStack3;
		txtArray[4] = txtStack4;
		txtArray[5] = txtStack5;
		txtArray[6] = txtStack6;
		txtArray[7] = txtStack7;
		txtArray[8] = txtStack8;
		txtArray[9] = txtStack9;
		
		
		//loop to update only the amount of items in the stack
		for (int i = 0; i<stack.length; i++) {
			txtArray[i].setText(String.valueOf(stack[i]));
			if(i>=counter) {
				txtArray[i].setText(null);
			}
		}
	}

	//initialize frame contents
	private void initialize() {
		frame = new JFrame();//frame
		frame.setTitle("RPN Calculator");//title
		frame.setBounds(100, 100, 469, 439);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane errorDisplay = new JTextPane();//errorDisplay field
		errorDisplay.setEditable(false);//uneditable
		errorDisplay.setBounds(155, 90, 150, 44);
		frame.getContentPane().add(errorDisplay);
		
		
		
		numericEntry = new JTextField();//numericEntry field
		numericEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userInput = numericEntry.getText();
			}
		});
		numericEntry.setBounds(155, 20, 150, 25);
		frame.getContentPane().add(numericEntry);
		numericEntry.setColumns(10);
		numericEntry.requestFocusInWindow();
		
		JTextPane numericDisplay = new JTextPane();//numericDisplay field
		//numericDisplay.setText("" + top + "");
		numericDisplay.setEditable(false);//non editable
		numericDisplay.setBounds(155, 55, 150, 25);
		frame.getContentPane().add(numericDisplay);
		
		
		//plusButton
		JButton plusButton = new JButton("+");//plus button
		plusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter >= 2){//if counter is greater than or equal to 2 run  
					try {
						add();	//add	method		
						errorDisplay.setText(null);//sets errorDisplay to null
						numericDisplay.setText("" + stack[0] + "");	//shows top of stack
						showStack();//showStack method
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
		plusButton.setBounds(65, 145, 70, 40);
		frame.getContentPane().add(plusButton);
		

		//subButton
		JButton minusButton = new JButton("-");//sub button
		minusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter >= 2) {//if counter is greater than or equal to 2 run
					try {
						sub();//sub method
						errorDisplay.setText(null);//sets errorDisplay to null
						numericDisplay.setText("" + stack[0] + "");	//shows top of stack
						showStack();//showStack method
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
		minusButton.setBounds(150, 145, 70, 40);
		frame.getContentPane().add(minusButton);
		
		//multButton
		JButton multiplyButton = new JButton("*");//mult button
		multiplyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter >= 2) {//if counter is greater than or equal to 2 run
					try {
						mult();//mult method
						errorDisplay.setText(null);//sets errorDisplay to null
						numericDisplay.setText("" + stack[0] + "");	//shows top of stack
						showStack();//showStack method
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
		multiplyButton.setBounds(235, 145, 70, 40);
		frame.getContentPane().add(multiplyButton);
		
		//divButton
		JButton divideButton = new JButton("/");//div button
		divideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter >= 2) {//if counter is greater than or equal to 2 run
					try {
						div();//dive method						
						errorDisplay.setText(null);//sets errorDisplay to null
						numericDisplay.setText("" + stack[0] + "");	//shows top of stack
						showStack();//showStack method
						numericEntry.setText(null);//sets numericEntry to null
						numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
					} catch (Exception e1) {
						errorDisplay.setText("Error");
					}
				}		
				else if(counter < 2) {//if counter is less than 2 throw exception
					errorDisplay.setText("Stack does not have enough to div.");
					numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
				}
			}
		});
		divideButton.setBounds(150, 195, 70, 40);
		frame.getContentPane().add(divideButton);
		
		//dupButton
		JButton dupButton = new JButton("dup");//dup button
		dupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isEmpty() && counter < capacity) {//if array isn't empty and counter is less than capacity then run
					try {
						dup();//dup method
						errorDisplay.setText(null);//sets errorDisplay to null
						numericDisplay.setText("" + stack[0] + "");	//shows top of stack
						showStack();//showStack method
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
		dupButton.setBounds(65, 195, 70, 40);
		frame.getContentPane().add(dupButton);
		
		//2dupButton
		JButton twodupButton = new JButton("2dup");//2dup button
		twodupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((capacity - counter) >= 2) {//if capacity left is greater than or equal to two then run
					try {
						twoDup(); //twoDup method
						errorDisplay.setText(null);//sets errorDisaply to null
						numericDisplay.setText("" + stack[0] + "");	//shows top of stack
						showStack();//showStack method
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
		twodupButton.setBounds(65, 245, 70, 40);
		frame.getContentPane().add(twodupButton);
		
		//clrButton
		JButton clrButton = new JButton("clr");//clr button
		clrButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					clear();//clear method
					errorDisplay.setText(null);//sets errorDisplay to nu
					numericDisplay.setText("" + stack[0] + "");	//shows top of stack
					showStack();//showStack method
					numericEntry.setText(null);//sets numericEntry to null
					numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
					txtArray= null;
				} catch (Exception e1) {
					errorDisplay.setText("Error");
				}
			}
		});
		clrButton.setBounds(65, 345, 113, 40);
		frame.getContentPane().add(clrButton);
		
		
		//popButton
		JButton popButton = new JButton("pop"); //pop button
		popButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isEmpty()) {//checks if empty
					try {
						pop();//pop method
						numericDisplay.setText("" + stack[0] + "");	//shows top of stack
						errorDisplay.setText(null);//sets errorDisplay to null
						showStack();//showStack method
						numericEntry.setText(null);//sets numericEntry to null
						numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
						showStack();
					} catch (Exception e1) {
						errorDisplay.setText("Error");
					}
				}
				
				else {
					errorDisplay.setText("Stack is empty: cannot pop!");//error message for empty stack
				}
				
			}
		});
		popButton.setBounds(235, 195, 70, 40);
		frame.getContentPane().add(popButton);
		
		//pushButton
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
							showStack();//showStack method
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
		pushButton.setBounds(195, 345, 112, 40);
		frame.getContentPane().add(pushButton);
		
		//powerofButton
		JButton powerofButton = new JButton("x^y");
		powerofButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(counter >= 2) {//if counter is greater than or equal to 2 run
					try {
						powerof();//powerof method						
						errorDisplay.setText(null);//sets errorDisplay to null
						numericDisplay.setText("" + stack[0] + "");	//shows top of stack
						showStack();//showStack method
						numericEntry.setText(null);//sets numericEntry to null
						numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
					} catch (Exception e1) {
						errorDisplay.setText("Error");
					}
				}		
				else if(counter < 2) {//if counter is less than 2 throw exception
					errorDisplay.setText("Stack does not have enough to powerof.");
					numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
				}
			}
		});
		powerofButton.setBounds(65, 295, 70, 40);
		frame.getContentPane().add(powerofButton);
		
		//squaredButton
		JButton squaredButton = new JButton("x^2");
		squaredButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isEmpty()) {//if array isn't emptyy then run
					try {
						squared();//squared method
						errorDisplay.setText(null);//sets errorDisplay to null
						numericDisplay.setText("" + stack[0] + "");	//shows top of stack
						showStack();//showStack method
						numericEntry.setText(null);//sets numericEntry to null
						numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
					} catch (Exception e1) {
						errorDisplay.setText("Error");
					}
				}	
				else if (isEmpty()) {//if array is empty throw exception
				errorDisplay.setText("Stack is empty cannot square");
				numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
				}
			}
		});
		squaredButton.setBounds(150, 245, 70, 40);
		frame.getContentPane().add(squaredButton);
		
		//sqrt button
		JButton squareroot = new JButton("sqrt");
		squareroot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isEmpty()) {//if array isn't emptyy then run
					try {
						sqrt();//sqrt method
						errorDisplay.setText(null);//sets errorDisplay to null
						numericDisplay.setText("" + stack[0] + "");	//shows top of stack
						showStack();//showStack method
						numericEntry.setText(null);//sets numericEntry to null
						numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
					} catch (Exception e1) {
						errorDisplay.setText("Error");
					}
				}	
				else if (isEmpty()) {//if array is empty throw exception
				errorDisplay.setText("Stack is empty cannot square");
				numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
				}
			}
		});
		squareroot.setBounds(150, 295, 70, 40);
		frame.getContentPane().add(squareroot);
		
		
		//logButton
		JButton logButton = new JButton("log");
		logButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isEmpty()) {//if array isn't emptyy then run
					try {
						logTen();//log method
						errorDisplay.setText(null);//sets errorDisplay to null
						numericDisplay.setText("" + stack[0] + "");	//shows top of stack
						showStack();//showStack method
						numericEntry.setText(null);//sets numericEntry to null
						numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
					} catch (Exception e1) {
						errorDisplay.setText("Error");
					}
				}	
				else if (isEmpty()) {//if array is empty throw exception
				errorDisplay.setText("Stack is empty cannot log");
				numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
				}
				
			}
		});
		logButton.setBounds(235, 245, 70, 40);
		frame.getContentPane().add(logButton);
		
		//lnButton
		JButton lnButton = new JButton("ln");
		lnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isEmpty()) {//if array isn't emptyy then run
					try {
						naturalLog();//ln method
						errorDisplay.setText(null);//sets errorDisplay to null
						numericDisplay.setText("" + stack[0] + "");	//shows top of stack
						showStack();//showStack method
						numericEntry.setText(null);//sets numericEntry to null
						numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
					} catch (Exception e1) {
						errorDisplay.setText("Error");
					}
				}	
				else if (isEmpty()) {//if array is empty throw exception
				errorDisplay.setText("Stack is empty cannot natural log");
				numericEntry.requestFocusInWindow();//puts cursor back into numericEntry
				}
			}
		});
		lnButton.setBounds(235, 295, 70, 40);
		frame.getContentPane().add(lnButton);
		
		
		JLabel lblUserInput = new JLabel("User Input:");//user input label
		lblUserInput.setBounds(65, 25, 71, 14);
		frame.getContentPane().add(lblUserInput);
		
		JLabel lblTopOfStack = new JLabel("Result:");//result label
		lblTopOfStack.setBounds(65, 62, 74, 14);
		frame.getContentPane().add(lblTopOfStack);
		
		JLabel lblErrorMessage = new JLabel("Error Message:");//error message label
		lblErrorMessage.setBounds(65, 108, 89, 14);
		frame.getContentPane().add(lblErrorMessage);
		
		JLabel lblTheStack = new JLabel("The Stack");
		lblTheStack.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTheStack.setBounds(340, 48, 73, 14);
		frame.getContentPane().add(lblTheStack);
		
		txtStack0 = new JTextField();
		txtStack0.setEditable(false);
		txtStack0.setBounds(331, 77, 98, 20);
		frame.getContentPane().add(txtStack0);
		txtStack0.setColumns(10);
		//txtStack0.setText("" + this.peekedValue +"");
		
		txtStack1 = new JTextField();
		txtStack1.setEditable(false);
		txtStack1.setColumns(10);
		txtStack1.setBounds(331, 103, 98, 20);
		frame.getContentPane().add(txtStack1);
		
		txtStack3 = new JTextField();
		txtStack3.setEditable(false);
		txtStack3.setColumns(10);
		txtStack3.setBounds(331, 155, 98, 20);
		frame.getContentPane().add(txtStack3);
		
		txtStack2 = new JTextField();
		txtStack2.setEditable(false);
		txtStack2.setColumns(10);
		txtStack2.setBounds(331, 129, 98, 20);
		frame.getContentPane().add(txtStack2);
		
		txtStack7 = new JTextField();
		txtStack7.setEditable(false);
		txtStack7.setColumns(10);
		txtStack7.setBounds(331, 261, 98, 20);
		frame.getContentPane().add(txtStack7);
		
		txtStack6 = new JTextField();
		txtStack6.setEditable(false);
		txtStack6.setColumns(10);
		txtStack6.setBounds(331, 235, 98, 20);
		frame.getContentPane().add(txtStack6);
		
		txtStack5 = new JTextField();
		txtStack5.setEditable(false);
		txtStack5.setColumns(10);
		txtStack5.setBounds(331, 209, 98, 20);
		frame.getContentPane().add(txtStack5);
		
		txtStack4 = new JTextField();
		txtStack4.setEditable(false);
		txtStack4.setColumns(10);
		txtStack4.setBounds(331, 183, 98, 20);
		frame.getContentPane().add(txtStack4);
		
		txtStack9 = new JTextField();
		txtStack9.setEditable(false);
		txtStack9.setColumns(10);
		txtStack9.setBounds(331, 315, 98, 20);
		frame.getContentPane().add(txtStack9);
		
		txtStack8 = new JTextField();
		txtStack8.setEditable(false);
		txtStack8.setColumns(10);
		txtStack8.setBounds(331, 289, 98, 20);
		frame.getContentPane().add(txtStack8);
				
	}
}
