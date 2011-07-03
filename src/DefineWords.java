public class DefineWords {

	    public DefineWords(){
		    	    	
	    	PrimDict.getInstance().put(":",new PrimWord() {
				
				@Override
				public Object excute() throws Exception{
					// TODO Auto-generated method stub
					
					String name = null;
					String meaning = null;
					List<Object> list  = new List<Object>();
					
					name = SmingGo.getInstance().nextWord();
					
					
					if(name == null) 
						throw new Exception("사용자 정의 단어의 이름을 정의하지 않았습니다 ! -- \":\"");
					else if( SmingGo.getInstance().StringToObject(name,true) != null)
						throw new Exception("\""+name+"\" 이름으로 정의된 단어가 이미 존재합니다! -- \":\"");
					
					String strTmp =SmingGo.getInstance().nextWord();
					
					if(strTmp.charAt(0)=='(')
						meaning = SmingGo.getInstance().nextCharsUpTo(')');
					else{
						meaning = "???";
						Object objTmp = SmingGo.getInstance().StringToObject(strTmp,false);
						if(objTmp != null)  list.add(objTmp);
					}
					while(true){
						Object obj = SmingGo.getInstance().nextObject(';',true);
						if(obj == null)  break;
						list.add(obj);
					}
					UserDict.getInstance().put(name, new UserWord(name,meaning,list));
					return null;
				}
			});
	    	
	    	
	    	PrimDict.getInstance().put("search",new PrimWord() {
				
				@Override
				public Object excute() throws Exception{
					// TODO Auto-generated method stub
					Error.enoughMsg(1,"search");
					Object obj = DataStack.getInstance().pop();
					if (obj instanceof String) {
						String str = (String) obj;
						Object objTmp = SmingGo.getInstance().StringToObject(str,false);
							
						if(objTmp != null)
							return objTmp;
						else
							return null;
					}
					else{
						Error.errorString("이","search");
					}
					return null;
						
				}
				public String toString(){
					return "search";
				}
			});
	    	
	    	PrimDict.getInstance().put("@",new PrimWord() {
				
				@Override
				public Object excute() throws Exception{
					// TODO Auto-generated method stub
						
						return SmingGo.getInstance().nextObject('\n',true);

				}
				public String toString(){
					return "@";
				}
			});
	    	
	    	PrimDict.getInstance().put("$",new PrimWord() {
				
				@Override
				public Object excute() throws Exception{
					// TODO Auto-generated method stub
						
						return SmingGo.getInstance().nextObject('\n',false);

				}
				public String toString(){
					return "$";
				}
			});
	    	
	    	PrimDict.getInstance().put("call",new PrimWord() {
				
				@Override
				public Object excute() throws Exception{
					// TODO Auto-generated method stub
					Error.enoughMsg(1,"call");
					Object object = DataStack.getInstance().pop();
					
					if (object instanceof PrimWord) {
						PrimWord pri = (PrimWord) object;
						return pri.excute(); 
					}
					else if (object instanceof UserWord) {
						UserWord user = (UserWord) object;
						DataStack.getInstance().push(user.toArray());
						PrimDict.getInstance().get("run").excute();
						return null; 
					}
					else{
						throw new Exception("이 단어는 '사용자 정의 단어'나 '기본 정의 단어'가 아닙니다 ! - \"call\"");
					}
					
				}
				public String toString(){
					return "call";
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
	    	
	    	PrimDict.getInstance().get(":").immediate = true;
	    	
	    	PrimDict.getInstance().get(":").meaning = " -- word ";
	    	PrimDict.getInstance().get("@").meaning = " -- x ";
	    	PrimDict.getInstance().get("search").meaning = " str -- word ";
	    	PrimDict.getInstance().get("call").meaning = " word -- ";		
	    	PrimDict.getInstance().get("meaning").meaning = " word -- ";
	    }

}
