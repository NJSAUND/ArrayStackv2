public class TestArrayStack {

	public static void main(String[] args) throws Exception {
		int size = 4; //sets array size
		ArrayStack myStack = new ArrayStack(size); // initiates new array from ArrayStack
		
		System.out.println(myStack.isEmpty()+"\n");
		myStack.push(1);//push method
		System.out.println(myStack.peek(0));//peeks at first index
		System.out.println(myStack.peek(1));//peeks at second index
		System.out.println(myStack.peek(2));//peeks at third index
		System.out.println(myStack.peek(3));//peeks at fourth index
		System.out.println("Count: "+ myStack.count()+"\n");//shows total used indices
		System.out.println(myStack.isEmpty()+"\n");
		
		myStack.push(2);//push method
		System.out.println(myStack.peek(0));//peeks at first index
		System.out.println(myStack.peek(1));//peeks at second index
		System.out.println(myStack.peek(2));//peeks at third index
		System.out.println(myStack.peek(3));//peeks at fourth index
		System.out.println("Count: "+ myStack.count()+"\n");//shows total used indices
		
		myStack.pop(); //pop method
		System.out.println(myStack.peek(0));//peeks at first index
		System.out.println(myStack.peek(1));//peeks at second index
		System.out.println(myStack.peek(2));//peeks at third index
		System.out.println(myStack.peek(3));//peeks at fourth index
		System.out.println("Count: "+ myStack.count()+"\n");//shows total used indices
		
		myStack.push(3);//push method
		System.out.println(myStack.peek(0));//peeks at first index
		System.out.println(myStack.peek(1));//peeks at second index
		System.out.println(myStack.peek(2));//peeks at third index
		System.out.println(myStack.peek(3));//peeks at fourth index
		System.out.println("Count: "+ myStack.count()+"\n");//shows total used indices
		
		myStack.push(4);//push method
		System.out.println(myStack.peek(0));//peeks at first index
		System.out.println(myStack.peek(1));//peeks at second index
		System.out.println(myStack.peek(2));//peeks at third index
		System.out.println(myStack.peek(3));//peeks at fourth index
		System.out.println("Count: "+ myStack.count()+"\n");//shows total used indices
		
		myStack.push(5);//push method
		System.out.println(myStack.peek(0));//peeks at first index
		System.out.println(myStack.peek(1));//peeks at second index
		System.out.println(myStack.peek(2));//peeks at third index
		System.out.println(myStack.peek(3));//peeks at fourth index
		System.out.println("Count: "+ myStack.count()+"\n");//shows total used indices
		
	}

}
