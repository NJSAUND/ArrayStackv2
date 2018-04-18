
public class ForthStack extends ArrayStack implements Forth {//extends ArrayStack and implements Forth...self explanatory

	
	public ForthStack(int size) {
		super(size);
		//Auto-generated constructor stub
	}

	@Override
	public void add() throws Exception {
		if(counter >= 2) {//if counter is greater than or equal to 2 run
			
			double num1 = stack[0];//makes num1 equal to first index
			double num2 = stack[1];//makes num1s equal to second index 
			double sum = num1 + num2; //adds num1 and num2 together
			pop();//pop method
			pop();
			push(sum);//pushes sum to index 0
			
		}	
			
		else if(counter < 2) {//if counter is less than 2 throw exception
			throw new Exception("Stack does not have enough to add.");
		
		}
	}

	@Override
	public void sub() throws Exception {
		if(counter >= 2) {//if counter is greater than or equal to 2 run
			
			double num1 = stack[0];//makes num1 equal to first index
			double num2 = stack[1];//makes num1s equal to second index 
			double sub = num1 - num2; //subtracts num2 from num1
			pop();//pop method
			pop();
			push(sub);//pushes sub to index 0
			
		}	
			
		else if(counter < 2) {//if counter is less than 2 throw exception
			throw new Exception("Stack does not have enough to add.");
		
		}
		
	}

	@Override
	public void mult() throws Exception {
		if(counter >= 2) {//if counter is greater than or equal to 2 run
			
			double num1 = stack[0];//makes num1 equal to first index
			double num2 = stack[1];//makes num1s equal to second index 
			double mult = num1 * num2; //multiplies num1 and num2
			pop();//pop method
			pop();
			push(mult);//pushes mult to index 0
			
		}	
			
		else if(counter < 2) {//if counter is less than 2 throw exception
			throw new Exception("Stack does not have enough to add.");
		
		}
		
	}		


	@Override
	public void div() throws Exception {
		if(counter >= 2) {//if counter is greater than or equal to 2 run
			
			double num1 = stack[0];//makes num1 equal to first index
			double num2 = stack[1];//makes num1s equal to second index 
			double div = num2 / num1;
			pop();//pop method
			pop();
			push(div);//pushes div to index 0
		}	
			
		else if(counter < 2) {//if counter is less than 2 throw exception
			throw new Exception("Stack does not have enough to add.");
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
			double num2 = stack[1];//makes num1s equal to second index 
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
		
}