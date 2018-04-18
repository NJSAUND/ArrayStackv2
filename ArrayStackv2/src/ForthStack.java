
public class ForthStack extends ArrayStack implements Forth {

	
	public ForthStack(int size) {
		super(size);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add() throws Exception {
		if(counter >= 2) {
			
			double num1 = stack[0];
			double num2 = stack[1];
			double sum = num1 + num2;
			pop();
			pop();
			push(sum);
			
		}	
			
		else if(counter < 2) {
			throw new Exception("Stack does not have enough to add.");
		
		}
	}

	@Override
	public void sub() throws Exception {
		if(counter >= 2) {
			
			double num1 = stack[0];
			double num2 = stack[1];
			double sub = num1 - num2;
			pop();
			pop();
			push(sub);
			
		}	
			
		else if(counter < 2) {
			throw new Exception("Stack does not have enough to add.");
		
		}
		
	}

	@Override
	public void mult() throws Exception {
		if(counter >= 2) {
			
			double num1 = stack[0];
			double num2 = stack[1];
			double mult = num1 * num2;
			pop();
			pop();
			push(mult);
			
		}	
			
		else if(counter < 2) {
			throw new Exception("Stack does not have enough to add.");
		
		}
		
	}		


	@Override
	public void div() throws Exception {
		if(counter >= 2) {
			
			double num1 = stack[0];
			double num2 = stack[1];
			double div = num2 / num1;
			pop();
			pop();
			push(div);
			
		}	
			
		else if(counter < 2) {
			throw new Exception("Stack does not have enough to add.");
		
		}
		
	}

	@Override
	public void dup() throws Exception {
		if(!isEmpty() && counter < capacity) {
				double num1 = stack[0];
				push(num1);
		}	
		else if(counter == capacity) {
				throw new Exception("Stack is full cannot use method dup");
		}
		else if (isEmpty()) {
				throw new Exception("Stack is empty cannot use method dup");
		}
	}

	@Override
	public void twoDup() throws Exception {
		if((capacity - counter) >= 2) {
			
			double num1 = stack[0];
			double num2 = stack[1];
			push(num2);
			push(num1);
			
		}	
			
		else if((counter - capacity) < 2 ) {
			throw new Exception("Stack is does not have two available indices and cannot use method twoDup");
		}
		else if (isEmpty()) {
			throw new Exception("Stack is empty cannot use method twodup");
		}
		
	}
		
}