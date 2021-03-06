import java.util.List;


public class SmingGo {

	public static boolean stackState;	
	
	private StringBuilder text;
	private int position;
	
	private static SmingGo single = new SmingGo();
	  
	public static SmingGo getInstance(){
		return single;
	}
	    
	private SmingGo(){
		this.text = new StringBuilder();
		this.position = 0;
	}

	public boolean isWhitespace(char cr) { //문자가 공백인지 검사
	    return (cr == ' ')
	        || (cr == '\t')
	        || (cr == '\r') 
	        || (cr == '\'')   
	        || (cr == '\n');
	}
	
	public boolean isSpacialSyntax(char cr) { // 특수 문자인지 검사
	    return (cr == '\"')
	        || (cr == '[')
	        || (cr == '@')
	        || (cr == '$')
	        || (cr == '(')
	        || (cr == ')')
	        ;
	}
	
	
 
    public String nextWord () { //공백을 제거하고 텍스트를 보내는 매서드
        if (this.position >= this.text.length()) 
        	return null; // 아무것도 입력받지 않았으면 널 반환
        
        while (isWhitespace(text.charAt(position))) { // 공백 제거
            position ++;
        
            if (position >= text.length()) 
            	return null;
         }
         
        int new_pos = position;		// 처음 실제 명령이 시작되는 위치
        
        while (!isWhitespace(text.charAt(new_pos))) {
          
          if(isSpacialSyntax(text.charAt(new_pos))) 
        	{
        		new_pos ++; break;
        	}
        	
        	new_pos ++;
            
        	if (new_pos >= text.length()) 
        		break;
        }
        
        String collector = text.substring(position, new_pos); // 명령이 시작하는 부분을 복사
        new_pos ++ ;
        position = --new_pos; // 한칸 띄고 다시
        return collector;
    }
    

    
    public Object nextObject (int level) { // 객체를 반환하는 매서드로 레벨을 인자로 받아
        // 단어검색시 레벨보다 작으면 객체로 반환(아니면 실행)

    	String word = this.nextWord(); 

    	if (word == null) System.exit(0);

    	if (Lamda.defineState.size() >= 0  ){ // 지금 정의중인 상태인지 검사
    		try{	// 람다 정의중에 변수를 찾아냄
    			for(Lamda lamda : Lamda.defineState){
    				Object obj = lamda.get(new Symbol(word));
    				if(obj != null) 
    					return obj; 
    			}
    		} 
    		catch(Exception e){}
    	}

    	try{	// 사용자 정의 단어를 찾아냄
    		if(UserDict.getInstance().get(word).level >= level){
    			UserDict.getInstance().get(word).excute();
    			return null;
    		}
    		else 
    			return UserDict.getInstance().get(word);
    	} 
    	catch(Exception e){}

    	try{
    		return (Integer.parseInt(word));
    	} // 정수형 단어이면 정수로 변환
    	catch(Exception e){}

    	try{

    		return(Float.parseFloat(word));

    	} // 부동 소수형 단어이면 부동 소수로 변환
    	catch(Exception e){}

    	try{  

    		if(PrimDict.getInstance().get(word).level >= level)	
    			return(PrimDict.getInstance().get(word).excute());
    		else 
    			return PrimDict.getInstance().get(word);
    	}
    	catch(NullPointerException e){ 
    		System.out.println("이 사전에 '" + word+"'이란 단어는 없습니다!");
    		System.exit(0);
    		return null;
    	}
    	catch (Exception e) {
    		System.out.println(e.getMessage());
    		System.exit(0);
    		return null;
    	}
    }   
    
    
    
    public Object StringToObject (String str, boolean serach) { // 문자열을 받아서 객체로 반환함
    	
    	String word = str.toLowerCase();
    	
        try{
        	if(UserDict.getInstance().get(word) != null)  		
        		return (UserDict.getInstance().get(word));
        } 
        catch(Exception e){}
    	
        try{
        	return (Integer.parseInt(word));
        } // 정수형 단어이면 정수로 변환
        catch(Exception e){}
        
        try{return(Float.parseFloat(word));} // 부동 소수형 단어이면 부동 소수로 변환
        catch(Exception e){}
       

        try{  
        	if(PrimDict.getInstance().get(word).im)	
        		return(PrimDict.getInstance().get(word).excute());
        	else return PrimDict.getInstance().get(word);
        			 }
        catch(NullPointerException e){ 
        	if(serach){ 
        		return null;
        	}
        	else{
        		System.out.println("이 사전에 '" + word+"'이란 단어는 없습니다!");
        		System.exit(0);
        		return null;
        	}
  		  }
        catch (Exception e) {
    	    System.out.println(e.getMessage());
    	    return null;
        }
    }
    
    public String nextCharsUpTo(char cr) {	//다음 단어(cr)까지 문자열로 감쌈
      
      if (position >= text.length()) 
        	return null; // 아무것도 입력받지 않았으면 널 반환
        
        int newPosition = position; 
        
        while (text.charAt(newPosition) != cr) {
        	newPosition ++;
            if (newPosition >= text.length())
                System.out.println("문자열의 길이를 초과하여 오류가 발생했습니다!");
        }
        String collector = text.substring(position, newPosition);
        newPosition ++;
        position =  newPosition; // Skip the delimiter.
        return collector;
    }
    
    public void run (String text) { // 사용자에 입력받은 문자을 번역함
      this.text.append(text);
      String word;

        while (	this.text.length() > this.position ) {
        	Object obj = nextObject(0);
        	if(obj != null)
        	DataStack.getInstance().push(obj);
        }
    } 
}
