package com.highradius;

/*All Possible cases of using try/catch/finally block of statements below:
 * 
 * 1. Try,Finally clause can be used without using catch clause. But only try clause cannot be
 * used. need to have contract like try finally clauses,try catch clauses,try catch finally clauses
 * 
 * 2. Code below throw new Exception(); statement will results in compile time exception,
 * as below code cannot be never reachable.
 * 
 * 3. If we add code like throw new Exception(), then need to add catch to handle this exception
 * 
 * 4. If called method might throw an exception in method signature or it might throw an runtime or compile
 * time exception programmatically then calling method should surely handle that exception using try/catch clause
 * or using 'throws' Exception in method signature
 * 
 * 5. If System.exit(0); is called in try/catch block, then finally block will not executed
 * as JVM Shutdown on this exit method call 
 * 
 */

public class TryCatchQues {

	public static void main(String[] args){
		try{
			System.out.println("In Try");
			//throw new Exception(); --> point 2
			call();
		} catch (Exception e) {
			System.out.println("In calling method catch");
			//System.exit(0);
		} finally{
			System.out.println("Execute Finally");
		}

	}

	public static void call() throws Exception {
		System.out.println("In called method");
		try{
			int div = 1/0;
			System.out.println(div);
		}finally{
			System.out.println("In called method finally block");
			//System.exit(0);
		}
		
	}

}
