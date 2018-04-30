package edu.gcu.saunders.nathan.rpn;
	
public abstract class AbstractStack {
	
	public abstract void push(double item) throws Exception;//abstract method push
	
	public abstract double pop() throws Exception;//abstract method pop
	
	public abstract boolean isEmpty();//abstract method isEmpty
	
	public abstract double peek();//abstract method peek

	public abstract void clear() throws Exception;//abstract method clear
	
	
	
	
}
