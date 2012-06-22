
public class ProcessingWords {
	public ProcessingWords(){
	    PrimDict.getInstance().put("p-size",new PrimWord() {
			
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				ProcessingStack.getInstance().stack.add(1);
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "p-size";
			}
		});
	    
	    PrimDict.getInstance().put("background",new PrimWord() {
			
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				ProcessingStack.getInstance().stack.add(2);
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "background";
			}
		});
	    
	    PrimDict.getInstance().put("fill",new PrimWord() {
			
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				ProcessingStack.getInstance().stack.add(3);
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "fill";
			}
		});
	    
	    PrimDict.getInstance().put("line",new PrimWord() {
			
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				ProcessingStack.getInstance().stack.add(4);
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "line";
			}
		});
		
	    PrimDict.getInstance().put("setup",new PrimWord() {
			
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				Object obj = DataStack.getInstance().pop();
				if (obj instanceof Lamda) {
					Lamda lamda = (Lamda) obj;
					Processing.getInstance().lamda=lamda;
					Processing.getInstance().setup = true;
					ProcessingWindow.getInstance();
				}
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "setup";
			}
		});
	    
	    PrimDict.getInstance().put("draw",new PrimWord() {
			
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				Object obj = DataStack.getInstance().pop();
				if (obj instanceof Lamda) {
					Lamda lamda = (Lamda) obj;
					Processing.getInstance().lamda=lamda;
					Processing.getInstance().draw = true;
				}
				ProcessingWindow.getInstance();
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "draw";
			}
		});
	    
	}
}
