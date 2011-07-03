import java.util.Stack;


public class ProcessingStack {
	public Stack<Object> stack;
	
	private static ProcessingStack single = new ProcessingStack();
	  
	public static ProcessingStack getInstance(){
		return single;
	}
	private ProcessingStack(){
		this.stack = new Stack<Object>();
	}
}
