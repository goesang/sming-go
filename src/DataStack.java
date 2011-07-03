import java.util.List;
import java.util.Stack;


public class DataStack {
	private Stack<Object> stack;
	
	private static DataStack single = new DataStack();
	  
	public static DataStack getInstance(){
		return single;
	}
	    
	private DataStack(){
		this.stack = new Stack<Object>();
	}
	public void push(Object obj){
		this.stack.push(obj);
	}
	public Object pop(){
		return this.stack.pop();
	}
	public Object peek(){
		return this.stack.peek();
	}
	
	public int size(){
		return this.stack.size();
	}
	
	public String toString(){
		return this.stack.toString();
	}
	public void clear(){
		this.stack.clear();
	}
	public void print(){
		System.out.println("자료 더미 ( " + this.stack.size()+" ) :");
			for (Object obj : this.stack.toArray()){
				StringBuilder str = new StringBuilder();
				if (obj instanceof String) {
					str.append("str : " + "\""+(String) obj+"\"");
				}
				else if (obj instanceof Boolean) {
					str.append("bool : " + obj.toString());
				}
				else if (obj instanceof Integer) {
					str.append("int : " + obj.toString());
				}
				else if (obj instanceof Float) {
					str.append("float : " + obj.toString());
				}
				else if (obj instanceof UserWord) {
					str.append("word : " + obj.toString());
				}
				else if (obj instanceof PrimWord) {
					str.append("word : " + obj.toString());
				}
				else if (obj instanceof List) {
					str.append("list : " + obj.toString());
				}
				else{
					str.append("??? : " + obj.toString());
				}
				if(str.length()>=100) System.out.println(str.substring(0, 100)+"...");
				else System.out.println(str);
			}

	}

	
}

