public class ControlWords {
//각종 제어문에 관련된 부분
	public ControlWords(){
	    	
		PrimDict.getInstance().put("<<",new PrimWord() { // 람다를 실행하는 단어
				
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"<<");					
				Object object = DataStack.getInstance().pop();
					
				if (object instanceof Lamda) { // 람다일 경우
					System.gc(); // 혹시모를 메모리 쓰레기를 제거
					Lamda lamda = (Lamda) object;
					Lamda.callee.push(lamda); // 현재 진행되는 람다에 넣음
					
					for (Object ob : lamda){ // 하나 하나 꺼내서
						if (ob instanceof PrimWord) { // 기본 단어의 경우
							PrimWord word = (PrimWord) ob; // 기본 단어로 전환하여 실행함
							Object obj = word.excute();
							if(obj != null)
								DataStack.getInstance().push(obj); // 나중에 빼자 %%%%
						}
								
						else if (ob instanceof UserWord) { // 사용자 단어 의 경우
							UserWord word = (UserWord) ob; // 
							DataStack.getInstance().push(word.toArray());
							UserWord.callee.push(word.toArray());
							excute();
							UserWord.callee.pop();
						}
						
						else{ 
							DataStack.getInstance().push(ob);
						}
					}
					Lamda.callee.pop();
				}
				else if(object instanceof Symbol){
					Symbol symTmp = (Symbol)object;
					Object objTmp = SmingGo.getInstance().StringToObject(symTmp.toString(),false);
					DataStack.getInstance().push(objTmp);
					excute();
					return null; 
				}
				else if (object instanceof PrimWord) {
					PrimWord pri = (PrimWord) object;
					return pri.excute(); 
				}
				else if (object instanceof UserWord) {
					UserWord user = (UserWord) object;
					
					Lamda.callee.push(user.toArray());
					UserWord.callee.push(user.toArray());
					
					DataStack.getInstance().push(user.toArray());
					excute();
					UserWord.callee.pop();
					Lamda.callee.pop();
					return null; 
					
				}
				else{
					Error.errorLamda("첫","<<");
				}
				return null;
			}
				
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "<<";
			}
		});
	    	
		
		PrimDict.getInstance().put("repeat",new PrimWord() {
				
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(2,"repeat");
				
				Object obj2 = DataStack.getInstance().pop();
				Object obj1 = DataStack.getInstance().pop();
					
				if (obj2 instanceof Integer) {
					Integer num = (Integer)obj2;
						
					if (obj1 instanceof Lamda) {
						Lamda<Object> lamda = (Lamda<Object> ) obj1;
						
						for(int i =0; i<num.intValue(); i++){
							DataStack.getInstance().push(lamda);
							PrimDict.getInstance().get("<<").excute();
								
	
						}
					}
					else{
						Error.errorLamda("첫번째","repeat");
					}
				}
				else{
					Error.errorNum("두번째","repeat");
				}
				return null;
			}
			public String toString(){
				return "repeat";
			}
		});
	    	
 	
		PrimDict.getInstance().put("if",new PrimWord() {
		
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(3,"if");
							
				Object obj3 = DataStack.getInstance().pop();
				Object obj2 = DataStack.getInstance().pop();
				Object obj1 = DataStack.getInstance().pop();
				
				if (obj1 instanceof Boolean) {	
					Boolean bool = (Boolean)obj1;
					Lamda lamda1 = null;
					Lamda lamda2 = null;
					
					if (obj2 instanceof Lamda) {	
						lamda1 = (Lamda)obj2;
					}
					else{
						Error.errorLamda("두번째","if");
					}
					
					if (obj3 instanceof Lamda) {	
						lamda2 = (Lamda)obj3;
					}
					else{
						Error.errorLamda("세번째","if");
					}
					
					if(bool.booleanValue()){
						DataStack.getInstance().push(lamda1);
						PrimDict.getInstance().get("<<").excute();
					}
					else{
						DataStack.getInstance().push(lamda2);
						PrimDict.getInstance().get("<<").excute();
					}
					
				}
				else { 
					Error.errorBool("첫번째","if");
				}
				
				return null;
		}
		public String toString(){
			return "if";
		}
	});
 	
    
    PrimDict.getInstance().put("when",new PrimWord() {
		
		@Override
		public Object excute() throws Exception {
			// TODO Auto-generated method stub
			Error.enoughMsg(3,"when");
							
				Object obj2 = DataStack.getInstance().pop();
				Object obj1 = DataStack.getInstance().pop();
				
				if (obj1 instanceof Boolean) {	
					Boolean bool = (Boolean)obj1;
					Lamda lamda1 = null;
					
					if (obj2 instanceof Lamda) {	
						lamda1 = (Lamda)obj2;
					}
					else{
						Error.errorLamda("두번째","when");
					}
					
					if(bool.booleanValue()){
						DataStack.getInstance().push(lamda1);
						PrimDict.getInstance().get("<<").excute();
					}
					else{
						return null;
					}
					
				}
				else { 
					Error.errorBool("첫번째","when");
				}
				
				return null;
		}
		public String toString(){
			return "when";
		}
	});   
    
    /* 앞으로 만들 단어들
    PrimDict.getInstance().put("cond",new PrimWord() {
		
		@Override
		public Object excute() throws Exception {
			// TODO Auto-generated method stub
			
		  
			return null;
		}
		public String toString(){
			return "cond";
		}
	});
   
    	PrimDict.getInstance().put("while",new PrimWord() {
		
		@Override
		public Object excute() throws Exception {
			// TODO Auto-generated method stub
			
		  
			return null;
		}
		public String toString(){
			return "while";
		}
	});   
        
   PrimDict.getInstance().put("case",new PrimWord() {
		
		@Override
		public Object excute() throws Exception {
			// TODO Auto-generated method stub
			
		  
			return null;
		}
		public String toString(){
			return "case";
		}
	});
   
    	PrimDict.getInstance().put("foreach",new PrimWord() {
		
		@Override
		public Object excute() throws Exception {
			// TODO Auto-generated method stub
			
		  
			return null;
		}
		public String toString(){
			return "foreach";
		}
	});
   
   PrimDict.getInstance().put("try-catch",new PrimWord() {
		
		@Override
		public Object excute() throws Exception {
			// TODO Auto-generated method stub
			
		  
			return null;
		}
		public String toString(){
			return "try-catch";
		}
	});   
    
*/
	PrimDict.getInstance().put("loop",new PrimWord() {
		
		@Override
		public Object excute() throws Exception {
			// TODO Auto-generated method stub
			Error.enoughMsg(1,"loop");

				Object obj1 = DataStack.getInstance().pop();
				
					if (obj1 instanceof Lamda) {
						Lamda<Object> lamda = (Lamda<Object> ) obj1;
						while(true){
							DataStack.getInstance().push(lamda);
							PrimDict.getInstance().get("<<").excute();
	}
					}
					else{
						Error.errorLamda("이","loop");
					}
					return null;
		}
		public String toString(){
			return "loop";
		}
	});
	
	PrimDict.getInstance().put("callee-next",new PrimWord() {
		
		@Override
		public Object excute() throws Exception {
			// TODO Auto-generated method stub
			
			if(Lamda.callee.size() < 2 ) 
				throw new Exception("계산되는 람다가 부족합니다!");
			
			return null;
		}
		public String toString(){
			return "callee-next";
		}
	});
	
	PrimDict.getInstance().put("callee",new PrimWord() {
		
		@Override
		public Object excute() throws Exception {
			// TODO Auto-generated method stub
			if(UserWord.callee.size() <= 1 ) 
				throw new Exception("다음 계산되는 람다가 없습니다!");

			DataStack.getInstance().push(Lamda.callee.pop());

			return null;
		}
		public String toString(){
			return "callee";
		}
	});
	
	PrimDict.getInstance().put("callee",new PrimWord() {
		
		@Override
		public Object excute() throws Exception {
			// TODO Auto-generated method stub
			if(Lamda.callee.size() == 0 ) 
				throw new Exception("현재 계산되는 람다가 없습니다!"); 
			DataStack.getInstance().push(Lamda.callee.pop());
			PrimDict.getInstance().get("<<").excute();
			return null;
		}
		public String toString(){
			return "callee";
		}
	});
	

	

    
    
    PrimDict.getInstance().put("error",new PrimWord() {
		
		@Override
		public Object excute() throws Exception {
			// TODO Auto-generated method stub
			Error.enoughMsg(1,"error");

			Object obj1 = DataStack.getInstance().pop();
			
			if (obj1 instanceof String) {
				String str = (String) obj1;
				throw new Exception(str);
			}
			else{
				Error.errorString("이", "error");
			}
			
			return null;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "error";
		}
	});
    
    PrimDict.getInstance().put("exit",new PrimWord() {
		
		@Override
		public Object excute() {
			// TODO Auto-generated method stub
			System.exit(0);
			return null;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "exit";
		}
	});	

    
    PrimDict.getInstance().get("<<").meaning = " lamda -- ";
    
    
	    }
}
