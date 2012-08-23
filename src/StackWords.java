public class StackWords {
//스택조작에 관련된 단어들
	public StackWords(){
		
		PrimDict.getInstance().put("drop",new PrimWord() {
			// 스택에 자료하나를 버림
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
	   // 스택에서 자료 하나를 깊은 복사(deep copy)를 함  			
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"dup");
				Object object = DataStack.getInstance().pop();
				DataStack.getInstance().push(object);
				if (object instanceof Lamda) {
					Lamda<Object> lamda = (Lamda<Object>) object;
					DataStack.getInstance().push(lamda.clone());
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
		
		PrimDict.getInstance().put("this",new PrimWord() {
			// 스택에서 하나를 얕은 복사(shallow copy)를 함
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"this");
				Object object = DataStack.getInstance().peek();
				DataStack.getInstance().push(object);
				return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "this";
			}
		});
	    	
	 	 PrimDict.getInstance().put("these",new PrimWord() {
			// 스택에서 두개를 얕은 복사(shallow copy)를 함
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(2,"these");
					Object object2 = DataStack.getInstance().pop();
					Object object1 = DataStack.getInstance().pop();
					
					DataStack.getInstance().push(object1);
          DataStack.getInstance().push(object1);     
					DataStack.getInstance().push(object2);
          DataStack.getInstance().push(object2);     
				return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "these";
			}
		});
	    	   	
		PrimDict.getInstance().put("swap",new PrimWord() {
				// 스택상의 자료의 위치를 서로 맞바꿈.
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
				// 스택에서 첫번째 자료를 복사후 세번째로 이동시킴.
				@Override
				public Object excute() throws Exception {
					// TODO Auto-generated method stub
					Error.enoughMsg(2,"over");
					Object object2 = DataStack.getInstance().pop();
					Object object1 = DataStack.getInstance().pop();
					
					DataStack.getInstance().push(object1);
					DataStack.getInstance().push(object2);
					
					if (object1 instanceof Lamda) {
						Lamda<Object> lamda = (Lamda<Object>) object1;
						DataStack.getInstance().push(lamda.clone());
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
				// 스택에 자료 3개의 순서를 바꿈.
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
				// 자료 2개를 깊은 복사(deep copy)함 
				@Override
				public Object excute() throws Exception {
					// TODO Auto-generated method stub
					Error.enoughMsg(2,"2dup");
					Object object2 = DataStack.getInstance().pop();
					Object object1 = DataStack.getInstance().pop();
					
					DataStack.getInstance().push(object1);
					DataStack.getInstance().push(object2);
					
					if (object1 instanceof Lamda) {
						Lamda<Object> lamda = (Lamda<Object>) object1;
						DataStack.getInstance().push(lamda.clone());
					}else{
						DataStack.getInstance().push(object1);
					}
					if (object2 instanceof Lamda) {
						Lamda<Object> lamda = (Lamda<Object>) object2;
						DataStack.getInstance().push(lamda.clone());
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
				// 자료 두개를 버림
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
				// 자료를 두개씩 위치를 바꿈
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
				// 첫번째 자료를 3번 복사함
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

					if (object1 instanceof Lamda) {
						Lamda<Object> lamda = (Lamda<Object>) object1;
						DataStack.getInstance().push(lamda.clone());
					}else{
						DataStack.getInstance().push(object1);
					}
					if (object2 instanceof Lamda) {
						Lamda<Object> lamda = (Lamda<Object>) object2;
						DataStack.getInstance().push(lamda.clone());
					}else{
						DataStack.getInstance().push(object2);
					}
					if (object3 instanceof Lamda) {
						Lamda<Object> lamda = (Lamda<Object>) object3;
						DataStack.getInstance().push(lamda.clone());
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
				// 자료 3개를 버림
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
				// 첫번째 자료를 세번째로 옮김
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
					
					if (object1 instanceof Lamda) {
						Lamda<Object> lamda = (Lamda<Object>) object1;
						DataStack.getInstance().push(lamda.clone());
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
				// 자료 4개를 섞음
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
	    	
			PrimDict.getInstance().put("one",new PrimWord() {
				// 자료 하나만 남기고 다 비움
				@Override
				public Object excute() throws Exception {
					// TODO Auto-generated method stub
					Error.enoughMsg(1,"one");
					Object object1 = DataStack.getInstance().pop();
					DataStack.getInstance().clear();
					DataStack.getInstance().push(object1);
					return null;
					}
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "one";
				}
				});
	    	
			PrimDict.getInstance().put("clear",new PrimWord() {
				// 스택을 비워버림
				@Override
				public Object excute() throws Exception {
					// TODO Auto-generated method stub
					DataStack.getInstance().clear();
					return null;
					}
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "clear";
				}
				});
			
			PrimDict.getInstance().put("depth",new PrimWord() {
				// 스택의 길이를 알아냄
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
