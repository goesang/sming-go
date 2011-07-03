import java.util.HashMap;


public class PrimDict {

		private HashMap<String, PrimWord> dict;
		
		  private static PrimDict single = new PrimDict();
		  
		  public static PrimDict getInstance(){
		        return single;
		    }
		    	
		private PrimDict(){
			this.dict = new HashMap<String, PrimWord>();
		}
		public void put(String str,PrimWord word){
			this.dict.put(str,word);
		}
		public PrimWord get(String str){
			return this.dict.get(str);
		}
		
	}

