import java.util.Scanner;


public class StringWords {

	    public StringWords(){
	    	
	    	PrimDict.getInstance().put("\"",new PrimWord() {
				
				@Override
					public Object excute() throws Exception {
					// TODO Auto-generated method stub
					return SmingGo.getInstance().nextCharsUpTo('\"');
				}
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "\"";
				}
			});
	    	
	    	PrimDict.getInstance().put("append",new PrimWord() {
				
				@Override
					public Object excute() throws Exception {
					// TODO Auto-generated method stub
					Error.enoughMsg(2,"append");
					
					Object object2 = DataStack.getInstance().pop();
					Object object1 = DataStack.getInstance().pop();
					
					if (object1 instanceof String) {
						String str = (String) object1;
						
						return str+object2.toString();
					}
					else{
						Error.errorString("이", "append");
					}
					return null;
				}
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "append";
				}
			});
	    	
	    	PrimDict.getInstance().put("length",new PrimWord() {
				
				@Override
					public Object excute() throws Exception {
					// TODO Auto-generated method stub
					Error.enoughMsg(1,"length");
				
					Object object1 = DataStack.getInstance().pop();
					if (object1 instanceof String) {
						String str = (String) object1;
						return str.length();
					}
					else{
						Error.errorString("이", "length");
					}
					return null;
				}
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "length";
				}
			});
	    	
	    	PrimDict.getInstance().put("spilt",new PrimWord() {
				
				@Override
					public Object excute() throws Exception {
					// TODO Auto-generated method stub
					Error.enoughMsg(2,"spilt");
					
					Object object2 = DataStack.getInstance().pop();
					Object object1 = DataStack.getInstance().pop();
					
					if (object1 instanceof String) {
						String str1 = (String) object1;
						if (object2 instanceof String) {
							String str2 = (String) object2;
							Lamda<Object> lamda = new Lamda<Object>();
							
							for(Object obj : str1.split(str2) ){
								lamda.add(obj);
							}
							
							return lamda;
						}
						else{
							Error.errorString("두번째", "spilt");
						}
					}
					else{
						Error.errorString("첫번째", "spilt");
					}
					return null;
				}
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "spilt";
				}
			});
	    	
	    	PrimDict.getInstance().put("find",new PrimWord() {
				
				@Override
					public Object excute() throws Exception {
					// TODO Auto-generated method stub
					Error.enoughMsg(2,"find");
					
					Object object2 = DataStack.getInstance().pop();
					Object object1 = DataStack.getInstance().pop();
					
					if (object1 instanceof String) {
						String str1 = (String) object1;
						if (object2 instanceof String) {
							String str2 = (String) object2;
							return str1.indexOf(str2);
						}
						else{
							Error.errorString("두번째", "find");
						}
					}
					else{
						Error.errorString("첫번째", "find");
					}
					return null;
				}
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "find";
				}
			});
	    	
	    	PrimDict.getInstance().put("replace",new PrimWord() {
				
				@Override
					public Object excute() throws Exception {
					// TODO Auto-generated method stub
					Error.enoughMsg(3,"replace");
					
					Object object3 = DataStack.getInstance().pop();
					Object object2 = DataStack.getInstance().pop();
					Object object1 = DataStack.getInstance().pop();
					
					if (object1 instanceof String) {
						String str1 = (String) object1;
						if (object2 instanceof String) {
							String str2 = (String) object2;
							if (object3 instanceof String) {
								String str3 = (String) object3;
								return str1.replaceAll(str2, str3);
							}
							else{
								Error.errorString("세번째", "replace");
							}
						}
						else{
							Error.errorString("두번째", "replace");
						}
					}
					else{
						Error.errorString("첫번째", "replace");
					}
					return null;
				}
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "replace";
				}
			});
	    	
	    	
	    	PrimDict.getInstance().put("cut",new PrimWord() {
				
				@Override
					public Object excute() throws Exception {
					// TODO Auto-generated method stub
					Error.enoughMsg(3,"cut");
					
					Object object3 = DataStack.getInstance().pop();
					Object object2 = DataStack.getInstance().pop();
					Object object1 = DataStack.getInstance().pop();
					
					if (object1 instanceof String) {
						String str1 = (String) object1;
						
						if (object2 instanceof Integer) {
							Integer int1 = (Integer) object2;
							
							if (object3 instanceof Integer) {
								Integer int2 = (Integer) object3;
								
								if(str1.length() < int2)
									throw new Exception("문자열의 길이보다 더 큰 범위를 지정하였습니다! -- \"cut\"");
								else if(int1 > int2)
									throw new Exception("범위를 잘못 지정하였습니다! -- \"cut\"");
								else
									return str1.substring(int1, int2);
							}
							else{
								Error.errorInt("세번째", "cut");
							}
						}
						else{
							Error.errorInt("두번째", "cut");
						}
					}
					else{
						Error.errorString("첫번째", "cut");
					}
					return null;
				}
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "cut";
				}
			});
	    	
	    	PrimDict.getInstance().put("input",new PrimWord() {
				
				@Override
					public Object excute() throws Exception {
					// TODO Auto-generated method stub
					Scanner scan = new Scanner(System.in);
					return scan.nextLine();
				}
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "input";
				}
			});

	    	PrimDict.getInstance().get("\"").im = true;
       // PrimDict.getInstance().get("\"").level = 2;  
	    }
}
