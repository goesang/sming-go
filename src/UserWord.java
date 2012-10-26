import java.util.Stack;



public class UserWord {
	
	public static Lamda<Object> defineState = null;
	public static Stack<Lamda> callee = new Stack<Lamda>();
	public static String defineMeaning;
	public static String defineName;
	
	
	public String meaning;
	
	private Lamda<Object> lamda;
	private String name;

	public int level;

	public UserWord(String name,String meaning,Lamda<Object> lamda){
		this.name = name;
		this.meaning = meaning;
		this.lamda = lamda;
	}

	public String toString(){
		return this.name;
	}

	public Lamda<Object> toArray(){
		Lamda<Object> lamda = new Lamda<Object>();
	
		for(Object obj : this.lamda)
		{
			if (obj instanceof UserWord) {
				UserWord new_name = (UserWord) obj;
				lamda.addAll(new_name.toArray());
			}
			else lamda.add(obj);
		}
		return lamda;
	}
   
  public void excute() throws Exception {			
			
			Lamda.callee.push(this.lamda); // 현재 진행되는 람다에 넣음
			
			for (Object ob : this.lamda){ // 하나 하나 꺼내서
				if (ob instanceof PrimWord) { // 기본 단어의 경우
					PrimWord word = (PrimWord) ob; // 기본 단어로 전환하여 실행함
					Object obj = word.excute();
					if(obj != null)
						DataStack.getInstance().push(obj); // 나중에 빼자 %%%%
				}
						
				else if (ob instanceof UserWord) { // 사용자 단어 의 경우
					UserWord word = (UserWord) ob; // 
					word.excute();
				}
				
				else{ 
					DataStack.getInstance().push(ob);
				}
			}
			Lamda.callee.pop();
  }  
}
