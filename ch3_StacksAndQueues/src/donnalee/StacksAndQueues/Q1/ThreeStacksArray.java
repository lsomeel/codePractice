package donnalee.StacksAndQueues.Q1;

public class ThreeStacksArray {

	private int[] array;
	private int size;
	
	//Start index of each stack
	private int startIndex1;
	private int startIndex2;
	private int startIndex3;
	
	//Index of topmost node for each stack
	private int topIndex1;
	private int topIndex2;
	private int topIndex3;
	
	public ThreeStacksArray(){
		this.size = 0;
		this.array = null;
		this.startIndex1 = 0;
		this.startIndex2 = 0;
		this.startIndex3 = 0;
		//by default, top index for each stack will be -1
		this.topIndex1 = -1;
		this.topIndex2 = -1;
		this.topIndex3 = -1;
	}
	
	public ThreeStacksArray(int s) throws IllegalArgumentException{
		//If s < 0, throw an exception
		if(s < 3){
			throw new IllegalArgumentException ("Exception: Invalid Size to create stacks");
		}
		
		this.size = s;
		this.array = new int[size];
		this.startIndex1 = 0;
		this.startIndex2 = this.startIndex1 + (size/3);
		//In case of size % 3 != 0, stack 3 will have the greatest size
		this.startIndex3 = this.startIndex2 + (size/3);
		this.topIndex1 = -1;
		this.topIndex2 = -1;
		this.topIndex3 = -1;
	}
	
	public void setStackSize(int s){
		this.size = s;
		this.array = new int[size];
		
		this.startIndex1 = 0;
		this.startIndex2 = this.startIndex1 + (size/3);
		this.startIndex3 = this.startIndex2 + (size/3);
	}
	
	public void pushToStack1(int d) throws Exception{
		//If stack is empty, push element to start index of the stack
		if(topIndex1 == -1){
			topIndex1 = startIndex1;
			array[topIndex1] = d;
			
			System.out.println("Pushed element " + d + " onto index " + topIndex1 + " of Stack 1");
			return;
		}
		//make sure that there is enough space to push an element
		if(topIndex1 < (startIndex2 - 1)){
			array[++topIndex1] = d;
			
			System.out.println("Pushed element " + d + " onto index " + topIndex1 + " of Stack 1");
		}
		else{
			//Overflow exception
			throw new Exception("Exception: Stack 1 is full. Cannot perform push.");
		}
	}
	
	public void pushToStack2(int d) throws Exception{
		//If stack is empty, push element to start index of the stack
		if(topIndex2 == -1){
			topIndex2 = startIndex2;
			array[topIndex2] = d;
			
			System.out.println("Pushed element " + d + " onto index " + topIndex2 + " of Stack 2");
			return;
		}
		//Make sure that there is enough space to push an element
		if(topIndex2 < (startIndex3 - 1)){
			array[++topIndex2] = d;
			
			System.out.println("Pushed element " + d + " onto index " + topIndex2 + " of Stack 2");
		}
		else{
			//Overflow exception
			throw new Exception("Exception: Stack 2 is full. Cannot perform push.");
		}
	}
	
	public void pushToStack3(int d) throws Exception{
		//If stack is empty, push element to start index of the stack
		if(topIndex3 == -1){
			topIndex3 = startIndex3;
			array[topIndex3] = d;
			
			System.out.println("Pushed element " + d + " onto index " + topIndex3 + " of Stack 3");
			return;
		}
		//Make sure that there is enough space to push an element
		if(topIndex3 < (size - 1)){
			array[++topIndex3] = d;
			
			System.out.println("Pushed element " + d + " onto index " + topIndex3 + " of Stack 3");
		}
		else{
			//Overflow exception
			throw new Exception("Exception: Stack 3 is full. Cannot perform push.");
		}
	}
	
	public int popFromStack1() throws Exception{
		if(topIndex1 == -1){
			//Underflow exception
			throw new Exception("Exception: Stack 1 is empty. Cannot perform pop.");
		}
		
		return array[topIndex1--];
	}
	
	public int popFromStack2() throws Exception{
		if(topIndex2 == -1){
			//Underflow exception
			throw new Exception("Exception: Stack 2 is empty. Cannot perform pop.");
		}
		//if it is the last element in stack, pop it and empty the stack
		else if(topIndex2 == startIndex2){
			int tmp = array[topIndex2];
			topIndex2 = -1;
			
			return tmp;
		}
		return array[topIndex2--];
	}
	
	public int popFromStack3() throws Exception{
		if(topIndex3 == -1){
			//underflow exception
			throw new Exception("Exception: Stack 3 is empty. Cannot perform pop.");
		}
		//if it is the last element in stack, pop it and empty the stack
		else if(topIndex3 == startIndex3){
			int tmp = array[topIndex3];
			topIndex3 = -1;
			
			return tmp;
		}
		return array[topIndex3--];
	}
	
	public int getStartIndex1(){
		return this.startIndex1;
	}
	
	public int getTopIndex1(){
		return this.topIndex1;
	}
	
	public int getTopIndex2(){
		return this.topIndex2;
	}

	public int getStartIndex2(){
		return this.startIndex2;
	}
	
	public int getTopIndex3(){
		return this.topIndex3;
	}
	
	public int getStartIndex3(){
		return this.startIndex3;
	}
	
	public boolean Stack1IsFull(){
		if(this.topIndex1 == (this.startIndex2 - 1)){
			return true;
		}
		return false;
	}
	
	public boolean Stack2IsFull(){
		if(this.topIndex2 == (this.startIndex3 - 1)){
			return true;
		}
		return false;
	}
	
	public boolean Stack3IsFull(){
		if(this.topIndex3 == (this.size - 1)){
			return true;
		}
		return false;
	}
	
	public void FullCheck(){
		if(this.Stack1IsFull()){
			System.out.println("Stack 1 is now full.");
		}
		
		if(this.Stack2IsFull()){
			System.out.println("Stack 2 is now full.");
		}
		
		if(this.Stack3IsFull()){
			System.out.println("Stack 3 is now full.");
		}
	}
	
	public boolean Stack1IsEmpty(){
		if(this.topIndex1 == -1){
			return true;
		}
		return false;
	}
	
	public boolean Stack2IsEmpty(){
		if(this.topIndex2 == -1){
			return true;
		}
		return false;
	}
	
	public boolean Stack3IsEmpty(){
		if(this.topIndex3 == -1){
			return true;
		}
		return false;
	}
	
	public void EmptyCheck(){
		if(this.Stack1IsEmpty()){
			System.out.println("Stack 1 is now empty.");
		}
		
		if(this.Stack2IsEmpty()){
			System.out.println("Stack 2 is now empty.");
		}
		
		if(this.Stack3IsEmpty()){
			System.out.println("Stack 3 is now empty.");
		}
	}
	
	public void printStartIndex(){
		System.out.println("Start Index of Stack 1: " + this.getStartIndex1());
		System.out.println("Start Index of Stack 2: " + this.getStartIndex2());
		System.out.println("Start Index of Stack 3: " + this.getStartIndex3());
	}
	
	public void printTopIndex(){
		System.out.println("Top Index of Stack 1: " + this.getTopIndex1());
		System.out.println("Top Index of Stack 2: " + this.getTopIndex2());
		System.out.println("Top Index of Stack 3: " + this.getTopIndex3());
	}
	//TODO: peek
	//TODO: Print Stack
	
	public static void main(String args[]){
		
		try{
			
			/*
			 * Test Case 1: Invalid array size ( < 3) when creating an array of three stacks
			 * 
			 * Expected: Must throw Illegal Argument Exception
			 */
			//ThreeStacksArray myArray = new ThreeStacksArray(2);
			
			/*
			 * Test Case 2: Valid but minimum array size (3) when creating array of three stacks
			 * 
			 * Expected: Must be able to push only one element for each stack. Must be able to detect
			 *           when each stack is empty or full.
			 */
			ThreeStacksArray myArray2 = new ThreeStacksArray(3);
			
			System.out.println("===================MyArray 2: =====================");
			
			//Empty stacks
			myArray2.printStartIndex();
			myArray2.printTopIndex();

			//Push an element to each stack
			myArray2.pushToStack1(10);
			myArray2.pushToStack2(20);
			myArray2.pushToStack3(30);

			//After Push
			myArray2.printTopIndex();
			myArray2.FullCheck();

			//Push an element to each stack, which is full. All of the three commands below must throw Exception
			//myArray2.pushToStack1(10);
			//myArray2.pushToStack2(20);
			//myArray2.pushToStack3(30);
			
			//Pop Elements
			System.out.println("Pop an element from Stack 1: " + myArray2.popFromStack1());
			System.out.println("Pop an element from Stack 2: " + myArray2.popFromStack2());
			System.out.println("Pop an element from Stack 3: " + myArray2.popFromStack3());
			
			//After Pop
			myArray2.printTopIndex();
			myArray2.EmptyCheck();
			
			//Pop an element from each stack, which is empty. All of the three commands below must throw Exception
			//myArray2.popFromStack1();
			//myArray2.popFromStack2();
			//myArray2.popFromStack3();
			
			/*
			 * Test Case 3: Valid array size that is not multiple of 3 ( % 3 != 0) when creating 
			 * array of three stacks
			 * 
			 * Expected: Must return correct index for Start and Top. Must perform push and pop correctly. 
			 *           Stack 3 must have the greatest size and must be able to push elements until it is full.
			 */

			ThreeStacksArray myArray3 = new ThreeStacksArray();
			myArray3.setStackSize(8);
			
			System.out.println("===================MyArray 3: =====================");
			myArray3.printStartIndex();
			
			//Push an element to each stack
			myArray3.pushToStack1(10);
			myArray3.pushToStack2(20);
			myArray3.pushToStack3(30);
			
			//After Push
			myArray3.printTopIndex();
			myArray3.FullCheck();
	
			//Push next element to each stack
			myArray3.pushToStack1(100);
			myArray3.pushToStack2(200);
			myArray3.pushToStack3(300);
			
			//After Push
			myArray3.printTopIndex();
			myArray3.FullCheck();
			
			//Push next elements to Stack 3
			myArray3.pushToStack3(1000);
			myArray3.printTopIndex();
			
			myArray3.pushToStack3(10000);
			myArray3.printTopIndex();
			myArray3.FullCheck(); //All should be full
			myArray3.EmptyCheck(); //Nothing should be printed out since none are empty
			
			//Push next element to Stack 3, which is now full. The following command must throw Exception.
			myArray3.pushToStack3(100000);
		}

		catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}
