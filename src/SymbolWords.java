
public class SymbolWords {
    public SymbolWords(){
    	
    	PrimDict.getInstance().put("$",new PrimWord() {
			
			@Override
				public Object excute() throws Exception {
				// TODO Auto-generated method stub
				return new Symbol(SmingGo.getInstance().nextWord());
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "$";
			}
		});
    	
    	PrimDict.getInstance().put("union",new PrimWord() {
			
			@Override
				public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(2,"+");

				Object obj2 = DataStack.getInstance().pop();
				Object obj1 = DataStack.getInstance().pop();
				if (obj1 instanceof Symbol) {
					Symbol newObj1 = (Symbol) obj1;
					if (obj2 instanceof Symbol) {
						Symbol newObj2 = (Symbol) obj2;
						DataStack.getInstance().push(
								new Symbol(newObj1.toString()+newObj2.toString()));
					}
					else{
						Error.errorSymbol("µÎ","union");
					}
				}
				else{
					Error.errorSymbol("Ã¹","union");
				}
				return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "union";
			}
		});
    	
    	PrimDict.getInstance().get("$").im = true;
    	
    }
}
