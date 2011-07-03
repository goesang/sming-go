

public class PrintTingWords {

    public PrintTingWords(){
     	
    	PrimDict.getInstance().put("print",new PrimWord() {
			
			@Override
			public Object excute() throws Exception  {
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"print");
					System.out.print(DataStack.getInstance().pop().toString());
					return null;
			}
			public String toString(){
				return "print";
			}
		});
    	
    	PrimDict.getInstance().put("cr",new PrimWord() {
			
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
					System.out.println("");
					return null;
			}
			public String toString(){
				return "cr";
			}
		});
    	
    	PrimDict.getInstance().put("pstack",new PrimWord() {
			
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				DataStack.getInstance().print();
				return null;
			}
			public String toString(){
				return "pstack";
			}
		});
    	
    	
    }
	
}
