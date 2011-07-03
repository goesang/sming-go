public class StackWords {

	public StackWords(){
		
		PrimDict.getInstance().put("drop",new PrimWord() {
			
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"drop");
				DataStack.getInstance().pop();
				return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "drop";
			}
		});
	    	
		PrimDict.getInstance().put("dup",new PrimWord() {
				
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"dup");
				Object object = DataStack.getInstance().pop();
				DataStack.getInstance().push(object);
				if (object instanceof List) {
					List<Object> list = (List<Object>) object;
					DataStack.getInstance().push(list.clone());
					return null;
				}
				DataStack.getInstance().push(object);
				return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "dup";
			}
		});
	    	
	    	
		PrimDict.getInstance().put("swap",new PrimWord() {
				
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(2,"swap");
				Object object2 = DataStack.getInstance().pop();
				Object object1 = DataStack.getInstance().pop();
				DataStack.getInstance().push(object2);
				DataStack.getInstance().push(object1);		

				return null;
				}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "swap";
			}
			
			});
	    	
	    	PrimDict.getInstance().put("over",new PrimWord() {
				
				@Override
				public Object excute() throws Exception {
					// TODO Auto-generated method stub
					Error.enoughMsg(2,"over");
					Object object2 = DataStack.getInstance().pop();
					Object object1 = DataStack.getInstance().pop();
					
					DataStack.getInstance().push(object1);
					DataStack.getInstance().push(object2);
					
					if (object1 instanceof List) {
						List<Object> list = (List<Object>) object1;
						DataStack.getInstance().push(list.clone());
					}else{
						DataStack.getInstance().push(object1);
					}
					return null;
				}
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "over";
				}
			});
	    	
	    	PrimDict.getInstance().put("rot",new PrimWord() {
				
				@Override
				public Object excute() throws Exception {
					// TODO Auto-generated method stub
					Error.enoughMsg(3,"rot");
					Object object3 = DataStack.getInstance().pop();
					Object object2 = DataStack.getInstance().pop();
					Object object1 = DataStack.getInstance().pop();
					DataStack.getInstance().push(object2);
					DataStack.getInstance().push(object3);	
					DataStack.getInstance().push(object1);


					return null;
				}
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "rot";
				}
			});
	    	
	    	PrimDict.getInstance().put("2dup",new PrimWord() {
				
				@Override
				public Object excute() throws Exception {
					// TODO Auto-generated method stub
					Error.enoughMsg(2,"2dup");
					Object object2 = DataStack.getInstance().pop();
					Object object1 = DataStack.getInstance().pop();
					
					DataStack.getInstance().push(object1);
					DataStack.getInstance().push(object2);
					
					if (object1 instanceof List) {
						List<Object> list = (List<Object>) object1;
						DataStack.getInstance().push(list.clone());
					}else{
						DataStack.getInstance().push(object1);
					}
					if (object2 instanceof List) {
						List<Object> list = (List<Object>) object2;
						DataStack.getInstance().push(list.clone());
					}else{
						DataStack.getInstance().push(object2);
					}
					return null;
				}
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "2dup";
				}
			});
	    	
	    	
	    	
	    	PrimDict.getInstance().put("2drop",new PrimWord() {
				
				@Override
				public Object excute() throws Exception {
					// TODO Auto-generated method stub
					Error.enoughMsg(2,"2drop");
					DataStack.getInstance().pop();
					DataStack.getInstance().pop();
					return null;
				}
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "2drop";
				}
			});
	    	
			PrimDict.getInstance().put("2swap",new PrimWord() {
				
				@Override
				public Object excute() throws Exception {
					// TODO Auto-generated method stub
					Error.enoughMsg(4,"2swap");
					Object object4 = DataStack.getInstance().pop();
					Object object3 = DataStack.getInstance().pop();
					Object object2 = DataStack.getInstance().pop();
					Object object1 = DataStack.getInstance().pop();
					
					DataStack.getInstance().push(object3);
					DataStack.getInstance().push(object4);	
					DataStack.getInstance().push(object1);
					DataStack.getInstance().push(object2);
					return null;
					}
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "2swap";
				}
				});
			
	    	PrimDict.getInstance().put("3dup",new PrimWord() {
				
				@Override
				public Object excute() throws Exception {
					// TODO Auto-generated method stub
					Error.enoughMsg(3,"3dup");
					Object object3 = DataStack.getInstance().pop();
					Object object2 = DataStack.getInstance().pop();
					Object object1 = DataStack.getInstance().pop();
					
					DataStack.getInstance().push(object1);
					DataStack.getInstance().push(object2);
					DataStack.getInstance().push(object3);

					if (object1 instanceof List) {
						List<Object> list = (List<Object>) object1;
						DataStack.getInstance().push(list.clone());
					}else{
						DataStack.getInstance().push(object1);
					}
					if (object2 instanceof List) {
						List<Object> list = (List<Object>) object2;
						DataStack.getInstance().push(list.clone());
					}else{
						DataStack.getInstance().push(object2);
					}
					if (object3 instanceof List) {
						List<Object> list = (List<Object>) object3;
						DataStack.getInstance().push(list.clone());
					}else{
						DataStack.getInstance().push(object1);
					}	
					return null;
				}
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "3dup";
				}
			});

	    	PrimDict.getInstance().put("3drop",new PrimWord() {
				
				@Override
				public Object excute() throws Exception {
					// TODO Auto-generated method stub
					Error.enoughMsg(3,"3drop");
					DataStack.getInstance().pop();
					DataStack.getInstance().pop();
					DataStack.getInstance().pop();
					return null;
				}
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "3drop";
				}
			});
	    	
	    	PrimDict.getInstance().put("3over",new PrimWord() {
				
				@Override
				public Object excute() throws Exception {
					// TODO Auto-generated method stub
					Error.enoughMsg(3,"3over");
					Object object3 = DataStack.getInstance().pop();
					Object object2 = DataStack.getInstance().pop();
					Object object1 = DataStack.getInstance().pop();
					
					DataStack.getInstance().push(object1);
					DataStack.getInstance().push(object2);
					DataStack.getInstance().push(object3);
					
					if (object1 instanceof List) {
						List<Object> list = (List<Object>) object1;
						DataStack.getInstance().push(list.clone());
					}else{
						DataStack.getInstance().push(object1);
					}
					return null;
				}
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "3over";
				}
			});
			
	    	PrimDict.getInstance().put("4rot",new PrimWord() {
				
				@Override
				public Object excute() throws Exception {
					// TODO Auto-generated method stub
					Error.enoughMsg(4,"4rot");
					
					Object object1 = DataStack.getInstance().pop();
					Object object2 = DataStack.getInstance().pop();
					Object object3 = DataStack.getInstance().pop();
					Object object4 = DataStack.getInstance().pop();
					
					DataStack.getInstance().push(object1);
					DataStack.getInstance().push(object2);
					DataStack.getInstance().push(object3);
					DataStack.getInstance().push(object4);
					return null;
				}
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "4rot";
				}
			});
	    	
			PrimDict.getInstance().put("..",new PrimWord() {
				
				@Override
				public Object excute() throws Exception {
					// TODO Auto-generated method stub
					Error.enoughMsg(1,"..");
					Object object1 = DataStack.getInstance().pop();
					DataStack.getInstance().clear();
					DataStack.getInstance().push(object1);
					return null;
					}
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "..";
				}
				});
	    	
			PrimDict.getInstance().put("...",new PrimWord() {
				
				@Override
				public Object excute() throws Exception {
					// TODO Auto-generated method stub
					DataStack.getInstance().clear();
					return null;
					}
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "...";
				}
				});
			
			PrimDict.getInstance().put("depth",new PrimWord() {
				
				@Override
				public Object excute() throws Exception {
					// TODO Auto-generated method stub
					return DataStack.getInstance().size();
					}
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "depth";
				}
				});
	    	
	    }

}
