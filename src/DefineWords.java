public class DefineWords {
//단어 정의와 관련된 단어 모음!
	    public DefineWords(){
		    	    	
	    	PrimDict.getInstance().put(":",new PrimWord() {
				
				@Override
				public Object excute() throws Exception{
					// TODO Auto-generated method stub
					
          if(UserWord.defineState != null){ // 현재 정의되고 있는 단어가 있는지를 찾음(':' 단어 중복 실행 방지) 
						throw new Exception("아직 정의되고 있는 단어가 있습니다!!!");
					}
					Lamda<Object> lamda  = new Lamda<Object>(); // 람다 생성
					UserWord.defineState = lamda; // 현재 정의되고 있는 단어에 생성한 람다를 넣음
          UserWord.defineName = SmingGo.getInstance().nextWord(); // : '단어이름'을 가지고 옮
					
					if(UserWord.defineName == null) //단어 이름이 없을 경우
						throw new Exception("사용자 정의 단어의 이름을 정의하지 않았습니다 ! -- \":\"");
					else if( SmingGo.getInstance().StringToObject(UserWord.defineName,true) != null) // 있는데 중복일 경우!
						throw new Exception("\""+UserWord.defineName+"\" 이름으로 정의된 단어가 이미 존재합니다! -- \":\"");

					String str = SmingGo.getInstance().nextWord();
					if(str.charAt(0)=='[')
						UserWord.defineMeaning = SmingGo.getInstance().nextCharsUpTo(']');
					else{
						UserWord.defineMeaning = null;
						Object objTmp = SmingGo.getInstance().StringToObject(str,false);
						if(objTmp != null)  lamda.add(objTmp);
					}

					UserDict.getInstance().put( // 재귀 호출을 위해 이름 까지만 정의된 단어를 등록!
							UserWord.defineName,
							new UserWord(UserWord.defineName,
							UserWord.defineMeaning,
							UserWord.defineState));
                     
					SmingGo.getInstance().stackState = false;
					
					while(!SmingGo.getInstance().stackState){
						Object obj = SmingGo.getInstance().nextObject(true);
						
						if(obj != null)  
							lamda.add(obj);
					}

					return null;
					
				}
				public String toString(){
					return ":";
				}
			});
	    	
	    	PrimDict.getInstance().put(";",new PrimWord() {
				
				@Override
				public Object excute() throws Exception{
					// TODO Auto-generated method stub					
					if(UserWord.defineState != null){
						SmingGo.getInstance().stackState = true ;
					}
					else{
						throw new Exception("현재 정의되고 있는 단어가 없습니다!!!");
					}
					
					UserDict.getInstance().put(
							UserWord.defineName, 
							new UserWord(UserWord.defineName,
							UserWord.defineMeaning,
							UserWord.defineState));
					
					UserWord.defineName = null;
					UserWord.defineMeaning = null;
					UserWord.defineState = null ;
					
					return null;

				}
				public String toString(){
					return ";";
				}
			});
	    	
	    	PrimDict.getInstance().put("define",new PrimWord() {
				
				@Override
				public Object excute() throws Exception{
					// TODO Auto-generated method stub
					Error.enoughMsg(2,"define");

					Object obj2 = DataStack.getInstance().pop();
					Object obj1 = DataStack.getInstance().pop();
					
					
					if (obj1 instanceof Lamda) {
						Lamda lam = (Lamda) obj1;
					
						if (obj2 instanceof Symbol) {
							Symbol sym  = (Symbol) obj2;
							
							UserDict.getInstance().put(
									sym.toString(), 
									new UserWord(sym.toString(),null,lam));
						}
						else{
							Error.errorSymbol("두","define");
						}
					}
					else{
						Error.errorLamda("첫","define");
					}
					return null;

				}
				public String toString(){
					return "define";
				}
			});	    	
	    	

	    	PrimDict.getInstance().put("@int",new PrimWord() {
				
				@Override
				public Object excute() throws Exception{
					// TODO Auto-generated method stub
						
					Object obj = SmingGo.getInstance().nextObject(false);
					
					if(obj != null){
						DataStack.getInstance().push(obj);
					}
					else{
						throw new Exception("자료가 있지 않습니다!!!");
					}
						return null;

				}
				public String toString(){
					return "@";
				}
			});

 	    	PrimDict.getInstance().put("@float",new PrimWord() {
				
				@Override
				public Object excute() throws Exception{
					// TODO Auto-generated method stub
						
					Object obj = SmingGo.getInstance().nextObject(false);
					
					if(obj != null){
						DataStack.getInstance().push(obj);
					}
					else{
						throw new Exception("자료가 있지 않습니다!!!");
					}
						return null;

				}
				public String toString(){
					return "@";
				}
			});

 	    	PrimDict.getInstance().put("@num",new PrimWord() {
				
				@Override
				public Object excute() throws Exception{
					// TODO Auto-generated method stub
						
					Object obj = SmingGo.getInstance().nextObject(false);
					
					if(obj != null){
						DataStack.getInstance().push(obj);
					}
					else{
						throw new Exception("자료가 있지 않습니다!!!");
					}
						return null;

				}
				public String toString(){
					return "@";
				}
			});

	    	PrimDict.getInstance().put("@str",new PrimWord() { // 문자열만 담을 수 있음
				
				@Override
				public Object excute() throws Exception{
					// TODO Auto-generated method stub
						
					Object obj = SmingGo.getInstance().nextObject(false);
					
					if(obj != null){
						DataStack.getInstance().push(obj);
					}
					else{
						throw new Exception("자료가 있지 않습니다!!!");
					}
						return null;

				}
				public String toString(){
					return "@";
				}
			});

	    	
	    	PrimDict.getInstance().put("@sym",new PrimWord() { // 심볼만 담을수 있음
				
				@Override
				public Object excute() throws Exception{
					// TODO Auto-generated method stub
						
					Object obj = SmingGo.getInstance().nextObject(false);
					
					if(obj != null){
						DataStack.getInstance().push(obj);
					}
					else{
						throw new Exception("자료가 있지 않습니다!!!");
					}
						return null;

				}
				public String toString(){
					return "@";
				}
			});
 

	    	PrimDict.getInstance().put("@",new PrimWord() { // 워드만 담을수 있음!
				
				@Override
				public Object excute() throws Exception{
					// TODO Auto-generated method stub
						
					Object obj = SmingGo.getInstance().nextObject(false);
					
					if(obj != null){
						DataStack.getInstance().push(obj);
					}
					else{
						throw new Exception("자료가 있지 않습니다!!!");
					}
						return null;

				}
				public String toString(){
					return "@";
				}
			});
         
	    	
	    	PrimDict.getInstance().put("meaning",new PrimWord() {
				
				@Override
				public Object excute() throws Exception{
					// TODO Auto-generated method stub
					Error.enoughMsg(1,"meaning");
					Object object = DataStack.getInstance().pop();
					
					if (object instanceof PrimWord) {
						PrimWord pri = (PrimWord) object;
						System.out.println(pri.meaning);
						return null;
					}
					else if (object instanceof UserWord) {
						UserWord user = (UserWord) object;
						System.out.println(user.meaning);
						return null;
					}
					else{
						throw new Exception("이 단어는 '사용자 정의 단어'나 '기본 정의 단어'가 아닙니다 ! -- \"meaning\"");
					}

				}
				public String toString(){
					return "meaning";
				}
			});
	    	
	    	PrimDict.getInstance().get(":").im = true;
	    	PrimDict.getInstance().get(";").im = true;
          
	      // PrimDict.getInstance().get(":").level = 2; @@@
	      // PrimDict.getInstance().get(";").level = 2; @@@         
	    	
	    	PrimDict.getInstance().get(":").meaning = " -- word ";
	    	PrimDict.getInstance().get("@").meaning = " -- x ";	
	    	PrimDict.getInstance().get("meaning").meaning = " word -- ";
	    }

}
