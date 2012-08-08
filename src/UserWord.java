import java.util.Stack;



public class UserWord {
	
	public static Lamda<Object> defineState = null;
	public static Stack<Lamda> callee = new Stack<Lamda>();
	public static String defineMeaning;
	public static String defineName;
	
	
	public String meaning;
	
	private Lamda<Object> list;
	private String name;

	public boolean immediate;

	public UserWord(String name,String meaning,Lamda<Object> list){
		this.name = name;
		this.meaning = meaning;
		this.list = list;
	}

	public String toString(){
		return this.name;
	}

	public Lamda<Object> toArray(){
		Lamda<Object> list = new Lamda<Object>();
	
		for(Object obj : this.list)
		{
			if (obj instanceof UserWord) {
				UserWord new_name = (UserWord) obj;
				list.addAll(new_name.toArray());
			}
			else list.add(obj);
		}
		return list;
	}
   
  public void excute(){
  //실행관련 내용을 입력하삼!!!!
  }  
}
