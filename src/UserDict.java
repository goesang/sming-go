import java.util.HashMap;


public class UserDict {
	
	private HashMap<String, UserWord> userDict;
	
	  private static UserDict single = new UserDict();
	  
	  public static UserDict getInstance(){
	        return single;
	    }
	    	
	private UserDict(){
		this.userDict = new HashMap<String, UserWord>();
	}
	public void put(String str,UserWord func){
		this.userDict.put(str,func);
	}
	public UserWord get(String str){
		return this.userDict.get(str);
	}
	
	public String toString(){
		return userDict.toString();
	}
	
}
