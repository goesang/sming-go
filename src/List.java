import java.util.LinkedList;


public class List<E> extends LinkedList<E> {

	public List(){
		super();
	}
	public List(List<E> list){
		super(list);
	}
	public String toString(){
		if(super.size() == 0) return "[]";
		else{
			StringBuilder str = new StringBuilder("[ ");
		for (Object obj : super.toArray()){
			if (obj instanceof String) {
				str.append("\""+(String) obj.toString()+"\", ");
			}
			else if (obj instanceof List) {
				str.append(obj.toString()+", ");
			}
			else{
				str.append(obj.toString()+", ");
			}
		}
		if(str.length() >=100) return str.substring(0, 98)+"..."+" ]";
		else return str.toString().substring(0, str.length()-2)+" ]";
		}
	}
}
