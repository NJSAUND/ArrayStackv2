package edu.gcu.saunders.nathan.rpn;
import java.text.DecimalFormat;

public class ForthStack extends ArrayStack implements Forth {//extends ArrayStack and implements Forth...self explanatory

	
	public ForthStack() {
		stack = new double [10];
		//Auto-generated constructor stub
	}

	@Override
	public void add() throws Exception {
		if(counter >= 2) {//if counter is greater than or equal to 2 run
			
			double num2 = stack[0];//makes num2 equal to first index
			double num1 = stack[1];//makes num1 equal to second index  
			double sum = num1 + num2; //adds num1 and num2 together
			pop();//pop method
			pop();
			push(sum);//pushes sum to index 0
			
		}	
			
		else if(counter < 2) {//if counter is less than 2 throw exception
			throw new Exception ("Stack does not have enough to add.");
		
		}
	}

	@Override
	public void sub() throws Exception {
		if(counter >= 2) {//if counter is greater than or equal to 2 run
			
			double num2 = stack[0];//makes num2 equal to first index
			double num1 = stack[1];//makes num1 equal to second index 
			double sub = num1 - num2; //subtracts num2 from num1
			pop();//pop method
			pop();
			push(sub);//pushes sub to index 0
			
		}	
			
		else if(counter < 2) {//if counter is less than 2 throw exception
			
			throw new Exception("Stack does not have enough to sub.");
		
		}
		
	}

	@Override
	public void mult() throws Exception {
		if(counter >= 2) {//if counter is greater than or equal to 2 run
			
			double num2 = stack[0];//makes num2 equal to first index
			double num1 = stack[1];//makes num1 equal to second index 
			double mult = num1 * num2; //multiplies num1 and num2
			pop();//pop method
			pop();
			push(mult);//pushes mult to index 0
			
		}	
			
		else if(counter < 2) {//if counter is less than 2 throw exception
			throw new Exception("Stack does not have enough to mult.");
		
		}
		
	}		


	@Override
	public void div() throws Exception {
		if(counter >= 2) {//if counter is greater than or equal to 2 run
			
			double num2 = stack[0];//makes num2 equal to first index
			double num1 = stack[1];//makes num1 equal to second index 
			double div = num1 / num2;
			pop();//pop method
			pop();
			push(div);//pushes div to index 0
		}	
			
		else if(counter < 2) {//if counter is less than 2 throw exception
			throw new Exception("Stack does not have enough to div.");
		}
	}

	@Override
	public void dup() throws Exception {
		if(!isEmpty() && counter < capacity) {//if array isn't empty and counter is less than capacity then run
				double num1 = stack[0]; //
				push(num1);
		}	
		else if(counter == capacity) {//if capacity left is less than 2 throw exception
				throw new Exception("Stack is full cannot duplicate");
		}
		else if (isEmpty()) {//if array is empty throw exception
				throw new Exception("Stack is empty cannot duplicate");
		}
	}

	@Override
	public void twoDup() throws Exception {
		if((capacity - counter) >= 2) {//if capacity left is greater than or equal to two then run
			
			double num1 = stack[0];//makes num1 equal to first index
			double num2 = stack[1];//makes num1 equal to second index 
			push(num2);//pushes num2
			push(num1);//pushes num1
			
		}	
			
		else if((counter - capacity) < 2 ) {//if capacity left is less than 2 throw exception
			throw new Exception("Stack is does not have two available indices and cannot duplicate twice");
		}
		else if (isEmpty()) {//if array is empty throw exception
			throw new Exception("Stack is empty cannot duplicate twice");
		}
		
	}
	
	//below are the added buttons
	public void powerof() throws Exception {
		if(counter >= 2) {//if counter is greater than or equal to 2 run
			
			double num2 = stack[0];//makes num2 equal to first index
			double num1 = stack[1];//makes num1 equal to second index 
			double powerof = java.lang.Math.pow(num1,num2);//make num1 to the power of num2
			pop();//pop method
			pop();
			push(powerof);//pushes powerof to index 0
		}	
			
		else if(counter < 2) {//if counter is less than 2 throw exception
			throw new Exception("Stack does not have enough to powerof");
		}
	}
	
	public void squared() throws Exception {
			if(!isEmpty()) {//if array isn't empty then run
				double num1 = stack[0];
				double squared = Math.pow(num1,2);//num1 to the power of 2 aka squared
				pop();//pop method
				push(squared);//push squared 
		}	
		else if (isEmpty()) {//if array is empty throw exception
				throw new Exception("Stack is empty cannot square");
		}
	}	
	
	//sqrt
	public void sqrt() throws Exception {
		if(!isEmpty()) {//if array isn't empty then run
			double num1 = stack[0];
			double sqrt = Math.sqrt(num1);//square root function
			DecimalFormat df = new DecimalFormat("#.###########");//rounds for display purposes
			sqrt = Double.valueOf(df.format(sqrt));
			pop();
			push(sqrt);//push sqrt
			
		}	
		else if (isEmpty()) {//if array is empty throw exception
				throw new Exception("Stack is empty cannot and cannot square root.");
		}
	}
		
	
	public void logTen() throws Exception {
		if(!isEmpty()) {//if array isn't empty then run
			double num1 = stack[0];
			double log = Math.log10(num1);//log function
			DecimalFormat df = new DecimalFormat("#.###########");//rounds for display purposes
			log = Double.valueOf(df.format(log));
			pop();
			push(log);//push log
			
		}	
		else if (isEmpty()) {//if array is empty throw exception
				throw new Exception("Stack is empty cannot use log");
		}
	}
	
	public void naturalLog() throws Exception {
		if(!isEmpty()) {//if array isn't empty then run
			double num1 = stack[0];
			double ln = Math.log(num1);//natural log function
			DecimalFormat df = new DecimalFormat("#.###########");//rounds for display purposes
			ln = Double.valueOf(df.format(ln));
			pop();
			push(ln);//push ln
			
		}	
		else if (isEmpty()) {//if array is empty throw exception
				throw new Exception("Stack is empty cannot use natural log");
		}
	}	

	
}