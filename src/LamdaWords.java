public class LamdaWords {

    public LamdaWords(){

    	PrimDict.getInstance().put("(",new PrimWord() {
    		//목록을 만드는 단어			
			@Override
			public Object excute() {
				// TODO Auto-generated method stub	
				Object obj = null;
				Lamda<Object> lamda  = new Lamda<Object>(); //람다 생성
				
				if(UserWord.defineState != null){ // 현재 단어 정의 중인지 확인
					if(!Lamda.defineState.empty()){ // 현재 다른 람다가 정의되는지 확인
						Lamda.defineState.peek().add(lamda); 
						//단어가 정의되는 중이고 또 람다가 정의중이라면 람다에 현재 람다를 넣는다
					}
					else{
						UserWord.defineState.add(lamda); 
						// 단어 정의되고 람다가 정의중이 아니라면 걍 사용자 정의에 넣는다.
					}
				}else{ // 단어가 정의되지 않을때
					if(!Lamda.defineState.empty()){ // 현재 다른 람다가 정의되는지 확인
						Lamda.defineState.peek().add(lamda); 
						//단어가 정의되지 않고 또 람다가 정의중이라면 람다에 현재 람다를 넣는다	
					}
				}
				
				Lamda.defineState.push(lamda); // 현재 정의되는 람다를 가리킴
				SmingGo.getInstance().stackState = false; // 스택에 넣지 않음
				
				while(!SmingGo.getInstance().stackState){ // 스택에 넣지 않는 동안 리스트에 넣음
					obj = SmingGo.getInstance().nextObject(1);
					if(obj != null) 
						lamda.add(obj);
				}
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "(";
			}
			
		});
    	
    	PrimDict.getInstance().put(")",new PrimWord() {
    		//목록을 만드는 단어			
			@Override
			public Object excute() {
				// TODO Auto-generated method stub

				if(Lamda.defineState.size() == 1){
					SmingGo.getInstance().stackState = true ;
					if(UserWord.defineState ==  null){
						DataStack.getInstance().push(Lamda.defineState.pop());
					}
					else{
						Lamda.defineState.pop();
					}
				}
				else{
					Lamda.defineState.pop();
					Object obj;
					while(!SmingGo.getInstance().stackState){
						obj = SmingGo.getInstance().nextObject(1);
						if(obj != null) 
							Lamda.defineState.peek().add(obj);
					}
				}
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return ")";
			}
			
		});
    	
    	PrimDict.getInstance().put("add",new PrimWord() {
    		//목록에 단어를 넣는 단어
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(2,"add");
				
				Object obj1 = DataStack.getInstance().pop();
				Object obj2 = DataStack.getInstance().pop();
				
				if (obj2 instanceof Lamda) {
					Lamda<Object> arr = (Lamda<Object>) obj2;
					arr.add(obj1);
					return arr;
				}
				else {
					Error.errorLamda("첫","add");
				}
				return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "add";
			}
		});
    	
    	PrimDict.getInstance().put("times",new PrimWord() {
    		//목록을 복사하여 원래 목록에 붙이는 단어
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(2,"times");
				
				Object obj2 = DataStack.getInstance().pop();
				Object obj1 = DataStack.getInstance().pop();
				
				int num = 0;
				
				if (obj2 instanceof Integer) {
					num = ((Integer)obj2).intValue();
				}
				else{
					Error.errorInt("두","times");
				}
				
				if (obj1 instanceof Lamda) {
					Lamda<Object> arr = (Lamda<Object>) obj1;
					Lamda<Object> arr2 = new Lamda<Object>(arr);
					
					for(int i = 1 ;i<num ;i++)
						arr.addAll(arr2);
					
					return arr;
				}
				else {
					Error.errorLamda("첫","times");
				}
				return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "times";
			}
		});
    	
    	PrimDict.getInstance().put("size",new PrimWord() {
    		//목록의 크기를 알아내는 단어
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"size");
				Object obj1 = DataStack.getInstance().pop();
				if (obj1 instanceof Lamda) {
					Lamda<Object> lamda = (Lamda<Object>)obj1;
					return lamda.size();
				}
				else{
					Error.errorLamda("이", "size");
				}
				return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "size";
			}
		});
    	
    	PrimDict.getInstance().put("=>",new PrimWord() {
    		//목록의 크기를 알아내는 단어
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				if(Lamda.defineState.size() == 0)
					throw new Exception("현재 람다 정의 상태가 아닙니다!!!");
				if(Lamda.defineState.peek().size() == 0)
					throw new Exception("현재 람다에 자료가 없습니다!!!");
				Object obj = SmingGo.getInstance().nextObject(1);
				
				if (obj instanceof Symbol) {
					Symbol sym = (Symbol) obj;	
					Lamda.defineState.peek().put(
							sym,
							Lamda.defineState.peek().removeLast());	
				}
				else{
					Error.errorSymbol("두", "=>");
				}			
				return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "=>";
			}
		});
    	
       	PrimDict.getInstance().put("get",new PrimWord() {
    		//목록의 크기를 알아내는 단어
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				
				Error.enoughMsg(2, "get");
				Object obj2 = DataStack.getInstance().pop();
				Object obj1 = DataStack.getInstance().pop();
				
				if (obj1 instanceof Lamda) {
					Lamda newObj1 = (Lamda) obj1;
					if (obj2 instanceof Symbol) {
						Symbol newObj2 = (Symbol) obj2;
						Object obj3 = newObj1.get(newObj2);
						if(obj3 == null) 
							throw new Exception("해시에 일치하는 키가 없습니다.");
						DataStack.getInstance().push(obj3);
					}
					else
						Error.errorSymbol("두", "get");
				}
				else{
					Error.errorLamda("첫", "get");
				}
				
				return null;


			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "get";
			}
		});
    	
       	PrimDict.getInstance().put("put",new PrimWord() {
    		//목록의 크기를 알아내는 단어
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				
				Error.enoughMsg(3, "put");
				Object obj3 = DataStack.getInstance().pop();
				Object obj2 = DataStack.getInstance().pop();
				Object obj1 = DataStack.getInstance().pop();
				
				if (obj1 instanceof Lamda) {
					Lamda newObj1 = (Lamda) obj1;
					if (obj3 instanceof Symbol) {
						Symbol newObj2 = (Symbol) obj3;
						newObj1.put(newObj2,obj2);
					}
					else
						Error.errorSymbol("세", "put");
				}
				else{
					Error.errorLamda("첫", "put");
				}
				
				return null;


			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "put";
			}
		});
       	
    	PrimDict.getInstance().put("=",new PrimWord() {
    		//목록의 크기를 알아내는 단어
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"size");
				Object obj1 = DataStack.getInstance().pop();
				if (obj1 instanceof Lamda) {
					Lamda<Object> lamda = (Lamda<Object>)obj1;
					return lamda.size();
				}
				else{
					Error.errorLamda("이", "size");
				}
				return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "=";
			}
		});
    	
    	PrimDict.getInstance().put("car",new PrimWord() {
    		//목록의 첫번째 단어를 뽑아내는 단어
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"car");
				
				Object obj1 = DataStack.getInstance().pop();
				
				if (obj1 instanceof Lamda) {
					Lamda<Object> lamda = (Lamda<Object>)obj1;
					return lamda.getFirst();
				}
				else{
					Error.errorLamda("이", "car");
				}
				return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "car";
			}
		});

    	PrimDict.getInstance().put("cdr",new PrimWord() {
    		//목록의 첫번째 단어를 제외한 나머지 단어들을 뽑아내는 단어
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"cdr");
				
				Object obj1 = DataStack.getInstance().pop();
				
				if (obj1 instanceof Lamda) {
					Lamda<Object> lamda = (Lamda<Object>)obj1;
					lamda.remove(0);
					return lamda;
				}
				else{
					Error.errorLamda("이", "cdr");
				}
				return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "cdr";
			}
		});
    	
 
    	PrimDict.getInstance().put("concat",new PrimWord() {
    		//목록과 목록을 이어 붙이는 단어
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(2,"concat");
				
				Object obj2 = DataStack.getInstance().pop();
				Object obj1 = DataStack.getInstance().pop();
				
				if (obj1 instanceof Lamda) {
					Lamda<Object> lamda1 = (Lamda<Object>)obj1;
					if (obj2 instanceof Lamda) {
						Lamda<Object> lamda2 = (Lamda<Object>)obj2;
						lamda1.addAll(lamda2);
						return lamda1;
					}
					else{
						Error.errorLamda("두", "concat");
					}
				}
				else{
					Error.errorLamda("첫", "concat");
				}
				return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "concat";
			}
		});
    	
    	PrimDict.getInstance().get("(").level = 1;
    	PrimDict.getInstance().get(")").level = 1;
    	
    	PrimDict.getInstance().get("=>").level = 1;
    	PrimDict.getInstance().get("=").level = 1;
    	
    	PrimDict.getInstance().get("(").meaning = " X... -- Spacial ";
    	PrimDict.getInstance().get("(").meaning = " Spacial -- Lamda ";
    	PrimDict.getInstance().get("add").meaning = " Lamda X -- Lamda ";
    	PrimDict.getInstance().get("times").meaning = " Lamda Int -- Lamda ";
    	PrimDict.getInstance().get("size").meaning = " Lamda -- Int ";
    	PrimDict.getInstance().get("car").meaning = " Lamda -- X ";	
    	PrimDict.getInstance().get("cdr").meaning = " Lamda -- Lamda ";	
    	PrimDict.getInstance().get("concat").meaning = " Lamda Lamda -- Lamda ";	
    }
    
}

