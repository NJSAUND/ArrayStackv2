package edu.gcu.saunders.nathan.rpn;

public class ArrayStack extends AbstractStack {
	
	int capacity;//allows variable to be used across class
	protected double stack[]; //initiates array
	int counter; //tracks the top of the array
		
	
	public ArrayStack(){

		
		stack = new double [10];
		capacity = stack.length;
		//double forthstack[size];
	
	}
	
	public ArrayStack(int size) {
		
		capacity = stack.length; //allows variable to be used across class
		stack = new double[capacity]; //sets array size to int capacity
		counter = 0; //sets count of items in array as 0
		//test
	}
	
	public void push(double item) throws Exception {
		if(counter < capacity) {
			double pushStack[] = new double [capacity]; //temporary stack for moving indices
			//move indices down one
			for(int i=0; i<stack.length-1; i++) { 
				pushStack[i+1] = stack[i];
			}
			
			stack = pushStack; //puts stack as push stack
			stack[0] = item;//pushes new item to top
			counter++;//adds to counter
			
		}
		else if(counter >= capacity) {
			throw new Exception("Stack overflow!");//error handling if more than maxSize
		}
		else {
			throw new Exception("Stack overflow!");//error handling if more than maxSize
		}
	}
	
	public double pop() throws Exception {
		
		if (!isEmpty()) {//checks if empty
			double popStack[] = new double [capacity]; //temporary stack for moving indices
			
			for(int i=0; i<stack.length-1; i++) { //move indices up one
				popStack[i] = stack[i+1];
			}
			stack = popStack; //puts stack as pop stack
			
			
			counter--; //subtracts from counter
			return stack[0]; //returns the top index
		}
		
		else {
			throw new Exception("Stack is empty: cannot pop!");//error message for empty stack
		}
	}
	
	
	public boolean isEmpty() {//isEmpty method
		return counter == 0;	//returns false and true depending on if its empty
	}
	
	public double peek(int n) throws Exception{
		if(counter > 0 && counter <= capacity) {//if top is greater than 0 it will continue as normal
			return stack[n]; //returns specified index
		}
		else {//throws error for exceeding boundary or size
			throw new Exception("Desired input is outside of array!");
		}
	}
	
	public int count() { //count method
		return counter;
	}
	
	@Override
	public double peek() {//peek() method
		return stack[0];//returns top of stack or stack[0]
		
	}

	public void clear() throws Exception {//clear method
		while (!isEmpty()) {//while this array is not empty
			pop();//pop method
		
		}
	}
	
}
