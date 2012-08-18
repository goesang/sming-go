public class BooleanWords {
//부울대수와 관련한 기본 단어들 정의
	public BooleanWords(){
	    	
	     PrimDict.getInstance().put("=?",new PrimWord() {
				//부울대수 연산자로 서로가 같은지 따져 물음.
				@Override
				public Object excute() {
					// TODO Auto-generated method stub
					Object obj2 = DataStack.getInstance().pop();
					Object obj1 = DataStack.getInstance().pop();
					
					DataStack.getInstance().push(obj1 == obj2);
          return null;
				}
				
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "=?";
				}
			});
	     
	     
	     PrimDict.getInstance().put("!?",new PrimWord() {
 			  //부울대수 연산자로 서로가 다른지 따져 물음.
				@Override
				public Object excute() {
					// TODO Auto-generated method stub
					Object obj2 = DataStack.getInstance().pop();
					Object obj1 = DataStack.getInstance().pop();
					 
          DataStack.getInstance().push(obj1 != obj2);
          return null;
				}
				
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "!?";
				}
			});
	     
	     PrimDict.getInstance().put("and",new PrimWord() {
 			  //부울대수 연산자로 서로가 'true' 일 경우 'true'를 스택에 넣음.
				
				@Override
				public Object excute() throws Exception{
					// TODO Auto-generated method stub
					Object obj2 = DataStack.getInstance().pop();
					Object obj1 = DataStack.getInstance().pop();
					
					if (obj1 instanceof Boolean) {	
						Boolean bool1 = (Boolean)obj1;
						if (obj2 instanceof Boolean) {	
							Boolean bool2 = (Boolean)obj2;
							DataStack.getInstace().push(bool1.booleanValue() && bool2.booleanValue());      
							return null;
						}
						else{
							Error.errorBool("두번째","and");
							return null;
						}
					}
					else{
						Error.errorBool("첫번째","and");
						return null;
					}

				}
				
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "and";
				}
			});
	     
	     PrimDict.getInstance().put("or",new PrimWord() {
       //부울대수 연산자로 둘중하나가 'true' 일 경우 'true'를 스택에 넣음.			
				@Override
				public Object excute() throws Exception{
					// TODO Auto-generated method stub
					Object obj2 = DataStack.getInstance().pop();
					Object obj1 = DataStack.getInstance().pop();
					
					if (obj1 instanceof Boolean) {	
						Boolean bool1 = (Boolean)obj1;
						if (obj2 instanceof Boolean) {	
							Boolean bool2 = (Boolean)obj2;
							DataStack.getInstace().push(bool1.booleanValue() || bool2.booleanValue());      
							return null;
						}
						else{
							Error.errorBool("두번째","or");
							return null;
						}
					}
					else{
						Error.errorBool("첫번째","or");
						return null;
					}

				}
				
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "or";
				}
			});
	     
	     PrimDict.getInstance().put("not",new PrimWord() {
				//부울대수 연산자로 스택에서 빼온 부울대수 값을 바꿈.
				@Override
				public Object excute() throws Exception{
					// TODO Auto-generated method stub
					Object obj1 = DataStack.getInstance().pop();
					
					if (obj1 instanceof Boolean) {	
						Boolean bool1 = (Boolean)obj1;
                  
            DataStack.getInstace().push(!bool1.booleanValue());      
						 return null;
					}
					else{
						Error.errorBool("이","not");
						return null;
					}

				}
				
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "not";
				}
			});
	     
		    
		    PrimDict.getInstance().get("true").meaning = " -- bool ";
		    PrimDict.getInstance().get("false").meaning = " -- bool ";
		    PrimDict.getInstance().get("=?").meaning = " Anony x -- bool ";
		    PrimDict.getInstance().get("!?").meaning = " x x -- bool ";
		    PrimDict.getInstance().get("and").meaning = " bool bool -- bool ";
		    PrimDict.getInstance().get("or").meaning = " bool bool -- bool ";
		    PrimDict.getInstance().get("not").meaning = " bool -- bool ";
	    }

}