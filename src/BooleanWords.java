public class BooleanWords {

	public BooleanWords(){
	    	
		PrimDict.getInstance().put("true",new PrimWord() {	
			
				@Override
				public Object excute() {
					// TODO Auto-generated method stub
							return true;
				}
				
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "true";
				}
			});
	     
	     PrimDict.getInstance().put("false",new PrimWord() {
				
				@Override
				public Object excute() {
					// TODO Auto-generated method stub
							return false;
				}
				
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "false";
				}
			});
	     
	     PrimDict.getInstance().put("=?",new PrimWord() {
				
				@Override
				public Object excute() {
					// TODO Auto-generated method stub
					Object obj2 = DataStack.getInstance().pop();
					Object obj1 = DataStack.getInstance().pop();
					
					return obj1 == obj2;
				}
				
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "=?";
				}
			});
	     
	     PrimDict.getInstance().put("=?",new PrimWord() {
				
				@Override
				public Object excute() {
					// TODO Auto-generated method stub
					Object obj2 = DataStack.getInstance().pop();
					Object obj1 = DataStack.getInstance().pop();
					
					return obj1 == obj2;
				}
				
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "=?";
				}
			});
	     
	     PrimDict.getInstance().put("!?",new PrimWord() {
				
				@Override
				public Object excute() {
					// TODO Auto-generated method stub
					Object obj2 = DataStack.getInstance().pop();
					Object obj1 = DataStack.getInstance().pop();
					
					return obj1 != obj2;
				}
				
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "!?";
				}
			});
	     
	     PrimDict.getInstance().put("and",new PrimWord() {
				
				@Override
				public Object excute() throws Exception{
					// TODO Auto-generated method stub
					Object obj2 = DataStack.getInstance().pop();
					Object obj1 = DataStack.getInstance().pop();
					
					if (obj1 instanceof Boolean) {	
						Boolean bool1 = (Boolean)obj1;
						if (obj2 instanceof Boolean) {	
							Boolean bool2 = (Boolean)obj2;
							return bool1.booleanValue() && bool2.booleanValue();
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
				
				@Override
				public Object excute() throws Exception{
					// TODO Auto-generated method stub
					Object obj2 = DataStack.getInstance().pop();
					Object obj1 = DataStack.getInstance().pop();
					
					if (obj1 instanceof Boolean) {	
						Boolean bool1 = (Boolean)obj1;
						if (obj2 instanceof Boolean) {	
							Boolean bool2 = (Boolean)obj2;
							return bool1.booleanValue() || bool2.booleanValue();
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
				
				@Override
				public Object excute() throws Exception{
					// TODO Auto-generated method stub
					Object obj1 = DataStack.getInstance().pop();
					
					if (obj1 instanceof Boolean) {	
						Boolean bool1 = (Boolean)obj1;
						
							return !bool1.booleanValue();
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
	     

		    PrimDict.getInstance().get("true").immediate = true;
		    PrimDict.getInstance().get("false").immediate = true;
		    
		    PrimDict.getInstance().get("true").meaning = " -- bool ";
		    PrimDict.getInstance().get("false").meaning = " -- bool ";
		    PrimDict.getInstance().get("=?").meaning = " x1 x2 -- bool ";
		    PrimDict.getInstance().get("!?").meaning = " x1 x2 -- bool ";
		    PrimDict.getInstance().get("and").meaning = " bool1 bool2 -- bool3 ";
		    PrimDict.getInstance().get("or").meaning = " bool1 bool2 -- bool3 ";
		    PrimDict.getInstance().get("not").meaning = " bool -- bool ";
	    }

}
