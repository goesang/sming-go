
public class VarWord {
	public VarWord(){
		PrimDict.getInstance().put("named",new PrimWord() {
			
			@Override
			public Object excute()throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(2,"named");

				Object obj2 = DataStack.getInstance().pop();
				Object obj1 = DataStack.getInstance().pop();
				

				if (obj2 instanceof Symbol) {
					Symbol newObj2 = (Symbol) obj2;
					Lamda<Object> lamda  = new Lamda<Object>();
					lamda.add(obj1);
					UserDict.getInstance().put(
							newObj2.toString(), 
							new UserWord(newObj2.toString(),"X -- ",lamda));
				}
				else{
					Error.errorSymbol("��","named");
					}
				return null;
				
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "named";
			}
		});
		
		PrimDict.getInstance().put("=",new PrimWord() {
			
			@Override
			public Object excute()throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"=");

				Object obj1 = DataStack.getInstance().pop();
				Object obj2 = SmingGo.getInstance().nextObject(1);
				
				
				if (obj2 instanceof Symbol) {
					Symbol sym = (Symbol) obj2;
					if(Lamda.callee.size() != 0){
						Lamda.callee.peek().put(sym, obj1);
					}
					else{
						Lamda<Object> lamda  = new Lamda<Object>();
						lamda.add(obj1);
						UserDict.getInstance().put(
								sym.toString(), 
								new UserWord(sym.toString(),"X -- ",lamda));
					}
				}else{
					Error.errorSymbol("��", "=");
				}
				
				
				
				return null;
				
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "=";
			}
		});
		
	}
}
