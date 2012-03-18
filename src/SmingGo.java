import java.util.List;


public class SmingGo {

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
	        || (cr == '(');
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
    
    public Object nextObject (char cr,boolean immediate) { // 객체를 반환하는 매서드
    	
    	String word = this.nextWord().toLowerCase();
    	
    	if(word.charAt(0) == cr) 
    		return null;
       
    	try{
    		if(UserDict.getInstance().get(word) != null)  		
    			return (UserDict.getInstance().get(word));
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
        	if(PrimDict.getInstance().get(word).immediate && immediate)	
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
        	if(PrimDict.getInstance().get(word).immediate)	
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
        
        int new_pos = position; 
        
        while (text.charAt(new_pos) != cr) {
            new_pos ++;
            if (new_pos >= text.length())
                System.out.println("문자열의 길이를 초과하여 오류가 발생했습니다!");
        }
        String collector = text.substring(position, new_pos);
        new_pos ++;
        position =  new_pos; // Skip the delimiter.
        return collector;
    }
    
    public void run (String text) { // 텍스트를 번역함
    	this.text.append(text);
        String word;

        while (	this.text.length() > this.position ) {
        	try{
        		word = this.nextWord().toLowerCase(); // 일단 소문자로 만듬
        	}
        	catch(Exception e){
        		return;
        	}
        	
        	try{
        		List<Object> arrayList = UserDict.getInstance().get(word).toArray(); // 실수로 만들어 오류가 안나면 푸시
	        	  
        		if(arrayList != null){
        			DataStack.getInstance().push(arrayList);
        			PrimDict.getInstance().get("run").excute();
        			continue;	
        		}	
        	} catch(Exception e){}
	          	
            try{
            	DataStack.getInstance().push(Integer.parseInt(word));		
            	continue; 
            } // 정수로 만들어 오류가 안나면 푸시
            catch(Exception e){}
           
            try{  
            	DataStack.getInstance().push(Float.parseFloat(word));
            	continue;	
            } // 부동 소수로 만들어 오류가 안나면 푸시
            catch(Exception e){}

	          
            try{
            	Object obj = PrimDict.getInstance().get(word).excute(); // 실수로 만들어 오류가 안나면 푸시
            	
            	if(obj != null){
            		DataStack.getInstance().push(obj);
            		continue;
            	}	
            }
            catch(NullPointerException e){ 
            	System.out.println("이 사전에 '" + word+"'이란 단어는 없습니다!");
            	System.exit(0);
            	return;
            }
            catch (Exception e) {
            	System.out.println(e.getMessage());
            	System.exit(0);
            	return;
            }
        }
    } 
}