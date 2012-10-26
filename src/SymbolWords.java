public class SymbolWords {
//심볼과 관련된 단어들의 정의함
    public SymbolWords(){
    	
    	PrimDict.getInstance().put("#",new PrimWord() {
			//심볼 생성단어 '#' (뒤에 부분의 한단어가 심볼이 됨)
			@Override
				public Object excute() throws Exception {
				// TODO Auto-generated method stub
         DataStack.getInstance().push(
								new Symbol(SmingGo.getInstance().nextWord()));
				
        return null;
			} 
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "#";
			}
		});

    	
    	PrimDict.getInstance().put("union",new PrimWord() {
			//심볼 두개를 받아 심볼 한개로 만듬
			@Override
				public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(2,"union");

				Object obj2 = DataStack.getInstance().pop();
				Object obj1 = DataStack.getInstance().pop();
            
				if (obj1 instanceof Symbol) {
					Symbol newObj1 = (Symbol) obj1;
					if (obj2 instanceof Symbol) {
						Symbol newObj2 = (Symbol) obj2;
						DataStack.getInstance().push(
								new Symbol(newObj1.toString() + newObj2.toString()));
					}
					else{
						Error.errorSymbol("두","union");
					}
				}
				else{
					Error.errorSymbol("첫","union");
				}
				return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "union";
			}
		});
    	
    	PrimDict.getInstance().get("#").im = true;
      // PrimDict.getInstance().get("#").level = 2; @@@
    }
}
