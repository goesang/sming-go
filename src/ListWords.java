public class ListWords {

    public ListWords(){

    	PrimDict.getInstance().put("[",new PrimWord() {
    		//목록을 만드는 단어			
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				Object obj = null;
				List<Object> list  = new List<Object>();
				while(true){
					obj = SmingGo.getInstance().nextObject(']',true);
				if(obj == null)  break;
				
				list.add(obj);
				}
				return(list);
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "[";
			}
			
		});
    	
    	PrimDict.getInstance().put("add",new PrimWord() {
    		//목록에 단어를 넣는 단어
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(2,"add");
				
				Object obj1 = DataStack.getInstance().pop();
				Object obj2 = DataStack.getInstance().pop();
				
				if (obj2 instanceof List) {
					List<Object> arr = (List<Object>) obj2;
					arr.add(obj1);
					return arr;
				}
				else {
					Error.errorList("이","add");
				}
				return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "add";
			}
		});
    	
    	PrimDict.getInstance().put("times",new PrimWord() {
    		//목록을 복사하여 원래 목록에 붙이는 단어
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(2,"times");
				
				Object obj2 = DataStack.getInstance().pop();
				Object obj1 = DataStack.getInstance().pop();
				
				int num = 0;
				
				if (obj2 instanceof Integer) {
					num = ((Integer)obj2).intValue();
				}
				else{
					Error.errorInt("두번째","times");
				}
				
				if (obj1 instanceof List) {
					List<Object> arr = (List<Object>) obj1;
					List<Object> arr2 = new List<Object>(arr);
					
					for(int i = 1 ;i<num ;i++)
						arr.addAll(arr2);
					
					return arr;
				}
				else {
					Error.errorList("첫번째","times");
				}
				return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "times";
			}
		});
    	
    	PrimDict.getInstance().put("size",new PrimWord() {
    		//목록의 크기를 알아내는 단어
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"size");
				Object obj1 = DataStack.getInstance().pop();
				if (obj1 instanceof List) {
					List<Object> list = (List<Object>)obj1;
					return list.size();
				}
				else{
					Error.errorList("이", "size");
				}
				return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "size";
			}
		});
    	
    	PrimDict.getInstance().put("head",new PrimWord() {
    		//목록의 첫번째 단어를 뽑아내는 단어
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"head");
				
				Object obj1 = DataStack.getInstance().pop();
				
				if (obj1 instanceof List) {
					List<Object> list = (List<Object>)obj1;
					return list.getFirst();
				}
				else{
					Error.errorList("이", "head");
				}
				return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "head";
			}
		});

    	PrimDict.getInstance().put("tail",new PrimWord() {
    		//목록의 첫번째 단어를 제외한 나머지 단어들을 뽑아내는 단어
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"tail");
				
				Object obj1 = DataStack.getInstance().pop();
				
				if (obj1 instanceof List) {
					List<Object> list = (List<Object>)obj1;
					list.remove(0);
					return list;
				}
				else{
					Error.errorList("이", "tail");
				}
				return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "tail";
			}
		});
    	
 
    	PrimDict.getInstance().put("concat",new PrimWord() {
    		//목록과 목록을 이어 붙이는 단어
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(2,"concat");
				
				Object obj2 = DataStack.getInstance().pop();
				Object obj1 = DataStack.getInstance().pop();
				
				if (obj1 instanceof List) {
					List<Object> list1 = (List<Object>)obj1;
					if (obj2 instanceof List) {
						List<Object> list2 = (List<Object>)obj2;
						list1.addAll(list2);
						return list1;
					}
					else{
						Error.errorList("두", "concat");
					}
				}
				else{
					Error.errorList("첫", "concat");
				}
				return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "concat";
			}
		});
    	
    	PrimDict.getInstance().get("[").immediate = true;
    	
    	PrimDict.getInstance().get("[").meaning = " x... -- list ";
    	PrimDict.getInstance().get("add").meaning = " list1 x -- list2 ";
    	PrimDict.getInstance().get("times").meaning = " list1 int -- list2 ";
    	PrimDict.getInstance().get("size").meaning = " list -- int ";
    	PrimDict.getInstance().get("head").meaning = " list -- x ";	
    	PrimDict.getInstance().get("tail").meaning = " list1 -- list2 ";	
    	PrimDict.getInstance().get("concat").meaning = " list1 list2 -- list3 ";	
    }
    
}

