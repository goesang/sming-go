import java.io.File;
import java.io.FileNotFoundException;



public class CheckWords {
	public CheckWords(){
    	PrimDict.getInstance().put("string?",new PrimWord() {
			
			@Override
				public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"string?");
				Object obj = DataStack.getInstance().pop();
				
				if (obj instanceof String) {
					return true;
				}
				else
					return false;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "string?";
			}
		});
    	PrimDict.getInstance().put("integer?",new PrimWord() {
			
			@Override
				public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"integer?");
				Object obj = DataStack.getInstance().pop();
				
				if (obj instanceof Integer) {
					return true;
				}
				else
					return false;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "integer?";
			}
		});
    	
    	PrimDict.getInstance().put("float?",new PrimWord() {
			
			@Override
				public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"float?");
				Object obj = DataStack.getInstance().pop();
				
				if (obj instanceof Float) {
					return true;
				}
				else
					return false;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "float?";
			}
		});
    	
    	PrimDict.getInstance().put("list?",new PrimWord() {
			
			@Override
				public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"list?");
				Object obj = DataStack.getInstance().pop();
				
				if (obj instanceof List) {
					return true;
				}
				else
					return false;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "list?";
			}
		});
    	
    	PrimDict.getInstance().put("word?",new PrimWord() {
			
			@Override
				public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"word?");
				Object obj = DataStack.getInstance().pop();
				
				if (obj instanceof PrimWord) {
					return true;
				}
				else if (obj instanceof UserWord) {
					return true;
				}
				else
					return false;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "word?";
			}
		});
    	
    	PrimDict.getInstance().put("boolean?",new PrimWord() {
			
			@Override
				public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"boolean?");
				Object obj = DataStack.getInstance().pop();
				
				if (obj instanceof Boolean) {
					return true;
				}
				else
					return false;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "boolean?";
			}
		});
    	
    	PrimDict.getInstance().put("file?",new PrimWord() {
			
    		@Override
    		public Object excute() throws Exception {
    			// TODO Auto-generated method stub
    			Error.enoughMsg(1,"file?");
				Object obj = DataStack.getInstance().pop();
				
				if (obj instanceof String) {
					String str = (String)obj;
					File file = new File(str);
					return file.exists();				
				}
				else
					Error.errorString("이", "file?");
			
				return false;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "file?";
			}
		});
    	
    	PrimDict.getInstance().put("file-read?",new PrimWord() {
			
    		@Override
    		public Object excute() throws Exception {
    			// TODO Auto-generated method stub
    			Error.enoughMsg(1,"file-read?");
				Object obj = DataStack.getInstance().pop();
				
				if (obj instanceof String) {
					String str = (String)obj;
					File file = new File(str);
					return file.canRead();				
				}
				else
					Error.errorString("이", "file-read?");
			
				return false;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "file-read?";
			}
		});
    	
    	PrimDict.getInstance().put("file-write?",new PrimWord() {
			
    		@Override
    		public Object excute() throws Exception {
    			// TODO Auto-generated method stub
    			Error.enoughMsg(1,"file-write?");
				Object obj = DataStack.getInstance().pop();
				
				if (obj instanceof String) {
					String str = (String)obj;
					File file = new File(str);
					return file.canWrite();				
				}
				else
					Error.errorString("이", "file-write?");
			
				return false;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "file-write?";
			}
		});
    	

	}
}
