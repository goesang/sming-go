
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
				if (obj instanceof List) {
					List list = (List) obj;
					Processing pro = new Processing();
					pro.list=list;
					new ProcessingWindow(pro);
				}
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "setup";
			}
		});
	    
	}
}
