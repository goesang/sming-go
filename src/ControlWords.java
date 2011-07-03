import java.util.List;

public class ControlWords {
	
	public ControlWords(){
	    	
		PrimDict.getInstance().put("run",new PrimWord() {
				
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"run");
					
				Object object = DataStack.getInstance().pop();
					
				if (object instanceof List) {
					List<Object> list = (List<Object>) object;
					for (Object ob : list){
						if (ob instanceof PrimWord) {
							PrimWord fu = (PrimWord) ob;
							Object obj = fu.excute();
							if(obj != null)
								DataStack.getInstance().push(obj);
						}
								
						else if (ob instanceof UserWord) {
							UserWord uf = (UserWord) ob;
							DataStack.getInstance().push(uf.toArray());
							excute();
						}
						
						else{ 
							DataStack.getInstance().push(ob);
						}
					}
				}
				else{
					Error.errorList("이","run");
				}
				return null;
			}
				
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "run";
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
						
					if (obj1 instanceof List) {
						List<Object> list = (List<Object> ) obj1;
						
						for(int i =0; i<num.intValue(); i++){
							DataStack.getInstance().push(list);
							PrimDict.getInstance().get("run").excute();
								
							if(this.state == "continue") { 
								this.state = "nil";
								continue; 
							}	
							else if(this.state == "break") { 
								this.state = "nil"; 
								break; 
							}
						}
					}
					else{
						Error.errorList("첫번째","repeat");
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
					List<Object> list1 = null;
					List<Object> list2 = null;
					
					if (obj2 instanceof List) {	
						list1 = (List<Object>)obj2;
					}
					else{
						Error.errorList("두번째","if");
					}
					
					if (obj3 instanceof List) {	
						list2 = (List<Object>)obj3;
					}
					else{
						Error.errorList("세번째","if");
					}
					
					if(bool.booleanValue()){
						DataStack.getInstance().push(list1);
						PrimDict.getInstance().get("run").excute();
					}
					else{
						DataStack.getInstance().push(list2);
						PrimDict.getInstance().get("run").excute();
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
 	
	PrimDict.getInstance().put("loop",new PrimWord() {
		
		@Override
		public Object excute() throws Exception {
			// TODO Auto-generated method stub
			Error.enoughMsg(1,"loop");

				Object obj1 = DataStack.getInstance().pop();
				
					if (obj1 instanceof List) {
						List<Object> list = (List<Object> ) obj1;
						while(true){
							DataStack.getInstance().push(list);
							PrimDict.getInstance().get("run").excute();
							if(this.state == "continue") { this.state = "normal"; continue; }
							else if(this.state == "break") { this.state = "normal"; break; }
						}
					}
					else{
						Error.errorList("이","loop");
					}
					return null;
		}
		public String toString(){
			return "loop";
		}
	});
	
	
    PrimDict.getInstance().put("continue",new PrimWord() {
		
		@Override
		public Object excute() {
			// TODO Auto-generated method stub
			this.state = "continue";
			return null;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "continue";
		}
	});
    
    PrimDict.getInstance().put("break",new PrimWord() {
		
		@Override
		public Object excute() {
			// TODO Auto-generated method stub
			this.state = "break";
			return null;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "break";
		}
	});
    
    PrimDict.getInstance().put("normal",new PrimWord() {
		
		@Override
		public Object excute() {
			// TODO Auto-generated method stub
			this.state = "normal";
			return null;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "normal";
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

    
    
    PrimDict.getInstance().get("run").meaning = " list -- ";
    
    
	    }
}
