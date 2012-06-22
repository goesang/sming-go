import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;


public class Lamda<E> extends LinkedList<E> {

	public static Stack<Lamda> defineState = new Stack<Lamda>();
	public static Stack<Lamda> callee = new Stack<Lamda>();
	
	private HashMap<String,Object> dict;
	
	public Lamda(){
		super();
		this.dict = new HashMap<String, Object>();
	}
	public Lamda(Lamda<E> lamda){
		super(lamda);
		this.dict = lamda.dict;
	}
	
	public void put(Symbol sym,Object obj){
		dict.put(sym.toString(), obj);
	}
	
	public Object get(Symbol sym){
		return dict.get(sym.toString());
	}
	
	public String toString(){
		if(super.size() == 0) return "()";
		else{
			StringBuilder str = new StringBuilder("( ");
		for (Object obj : super.toArray()){
			if (obj instanceof String) {
				str.append("\""+(String) obj.toString()+"\", ");
			}
			else if (obj instanceof Lamda) {
				str.append(obj.toString()+", ");
			}
			else{
				str.append(obj.toString()+", ");
			}
		}
		if(str.length() >=100) return str.substring(0, 98)+"..."+" )";
		else return str.toString().substring(0, str.length()-2)+" )";
		}
	}
}
