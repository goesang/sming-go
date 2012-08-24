import java.util.HashMap;


public class UserDict {
	
	private HashMap<String, UserWord> userDict;
	 //  private HashMap<String, HashMap> userDict;
      
	  private static UserDict single = new UserDict();
	  
	  public static UserDict getInstance(){
	        return single;
	    }
	    	
	private UserDict(){
		this.userDict = new HashMap<String, UserWord>();
	}
   /*
   	private UserDict(){
		this.userDict = new HashMap<String, HashMap>();
    
	}
   */
	public void put(String str,UserWord word){
		this.userDict.put(str,word);
	}
  /*
 	public void putVoca(String str,HashMap voca){
		this.userDict.put(str,voca);
	} 
   
   public void putWord(String wordName,UserWord word){
   HashMap<String, HashMap> stdVoca = new HashMap<String, HashMap>();
   stdVoca.put(wordName,voca);
   
		this.userDict.put("standard",stdVoca );
	} 
   
   	public UserWord get(String vocaName , String wordName){
		return this.userDict.get(vocaName).get(wordName);
	}
	
   */
	public UserWord get(String str){
		return this.userDict.get(str);
	}
	
	public String toString(){
		return userDict.toString();
	}
	
}
