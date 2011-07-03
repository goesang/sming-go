//////////// 만드셈!!!!
public class ConvertWords {
	public ConvertWords(){
	    PrimDict.getInstance().put("str-int",new PrimWord() {
			
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				System.exit(0);
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "str-int";
			}
		});
	    
	    PrimDict.getInstance().put("str-float",new PrimWord() {
			
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				System.exit(0);
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "str-float";
			}
		});	
	    
	    PrimDict.getInstance().put("str-bool",new PrimWord() {
			
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				System.exit(0);
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "str-bool";
			}
		});	
	}
}
