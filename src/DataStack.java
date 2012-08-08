import java.util.Stack;


public class DataStack {
	// 스밍고에 핵심을 이루는 기본 자료 스택!
  private Stack<Object> stack; // 실제 저장되는 스택
  String stackDummy; // 스택 검사를 위해 기억해 놓는 문자열
	
	private static DataStack single = new DataStack(); // 싱글톤 준비
	  
	public static DataStack getInstance(){ // 스택에 싱글톤을 내놓음
		return single;
	}
	    
	private DataStack(){ // 초기화
		this.stack = new Stack<Object>(); 
    this.stackDummy = new String("");  
	}
	public void push(Object obj,String type){
		this.stack.push(obj);
    this.stackDummy.concat(type);
	}
	public Object pop(){
		return this.stack.pop();
    this.stackDummy = this.stackDummy.substring(1);
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
		System.out.println("스택 자료 ( " + this.stack.size()+" ) :");
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
				else if (obj instanceof Lamda) {
					str.append("lamda : " + obj.toString());
				}
				else if (obj instanceof Symbol) {
					str.append("symbol : " + obj.toString());
				}
				else{
					str.append("??? : " + obj.toString());
				}
				if(str.length()>=100) System.out.println(str.substring(0, 100)+"...");
				else System.out.println(str);
			}

	}

	
}

