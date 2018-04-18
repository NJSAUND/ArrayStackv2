
public class TestForth {

	public static void main(String[] args) throws Exception {

			int size = 4; //sets array size
			ForthStack myStack = new ForthStack(size); // initiate new array from ArrayStack
			
			System.out.println(myStack.isEmpty()+"\n");
			
			myStack.push(10);
			myStack.push(11);
			myStack.add();
			System.out.println(myStack.peek(0));//peeks at first index
			System.out.println(myStack.peek(1));//peeks at second index
			System.out.println(myStack.peek(2));//peeks at third index
			System.out.println(myStack.peek(3));//peeks at fourth index
			System.out.println("Count: "+ myStack.count()+"\n");//shows total used indices
			myStack.clear();
			
			myStack.push(10);
			myStack.push(11);
			myStack.sub();
			System.out.println(myStack.peek(0));//peeks at first index
			System.out.println(myStack.peek(1));//peeks at second index
			System.out.println(myStack.peek(2));//peeks at third index
			System.out.println(myStack.peek(3));//peeks at fourth index
			System.out.println("Count: "+ myStack.count()+"\n");//shows total used indices
			myStack.clear();

			myStack.push(5);
			myStack.push(5);
			myStack.mult();
			System.out.println(myStack.peek(0));//peeks at first index
			System.out.println(myStack.peek(1));//peeks at second index
			System.out.println(myStack.peek(2));//peeks at third index
			System.out.println(myStack.peek(3));//peeks at fourth index
			System.out.println("Count: "+ myStack.count()+"\n");//shows total used indices
			myStack.clear();
			
			myStack.push(25);
			myStack.push(5);
			myStack.div();
			System.out.println(myStack.peek(0));//peeks at first index
			System.out.println(myStack.peek(1));//peeks at second index
			System.out.println(myStack.peek(2));//peeks at third index
			System.out.println(myStack.peek(3));//peeks at fourth index
			System.out.println("Count: "+ myStack.count()+"\n");//shows total used indices
			myStack.clear();


			myStack.push(10);
			myStack.push(5);
			myStack.dup();
			System.out.println(myStack.peek(0));//peeks at first index
			System.out.println(myStack.peek(1));//peeks at second index
			System.out.println(myStack.peek(2));//peeks at third index
			System.out.println(myStack.peek(3));//peeks at fourth index
			System.out.println("Count: "+ myStack.count()+"\n");//shows total used indices
			myStack.clear();

			myStack.push(25);
			myStack.push(5);
			myStack.twoDup();
			System.out.println(myStack.peek(0));//peeks at first index
			System.out.println(myStack.peek(1));//peeks at second index
			System.out.println(myStack.peek(2));//peeks at third index
			System.out.println(myStack.peek(3));//peeks at fourth index
			System.out.println("Count: "+ myStack.count()+"\n");//shows total used indices

			
		}

}


