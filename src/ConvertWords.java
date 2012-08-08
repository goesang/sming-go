public class ConvertWords {
//기본 자료형 변환에 관한 단어들
	public ConvertWords(){
	    PrimDict.getInstance().put("str->int",new PrimWord() {
			//문자열에서 정수형으로 변환
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				System.exit(0);
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "str->int";
			}
		});
	    
	    PrimDict.getInstance().put("str->float",new PrimWord() {
 			//문자열에서 부동소수형으로 변환  		
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				System.exit(0);
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "str->float";
			}
		});	
	    
	    PrimDict.getInstance().put("str->bool",new PrimWord() {
 			//문자열에서 부울대수형으로 변환  		
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				System.exit(0);
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "str->bool";
			}
		}); 
      
	    PrimDict.getInstance().put("str->sym",new PrimWord() {
 			//문자열에서 심볼형으로 변환  		
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				System.exit(0);
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "str->sym";
			}
		});	    
	    PrimDict.getInstance().put("int->str",new PrimWord() {
			//정수형에서 문자열로 변환 
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				System.exit(0);
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "int->str";
			}
		});
	    
	    PrimDict.getInstance().put("int->float",new PrimWord() {
			//정수형에서 부동소수형으로 변환
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				System.exit(0);
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "int->float";
			}
		});	
	    
	    PrimDict.getInstance().put("float->int",new PrimWord() {
			//부동소수형에서 정수형으로 변환
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				System.exit(0);
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "float->int";
			}
		}); 
      
	    PrimDict.getInstance().put("float->str",new PrimWord() {
			//부동소수형에서 문자열로 변환
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				System.exit(0);
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "float->str";
			}
		}); 
	    PrimDict.getInstance().put("float->sym",new PrimWord() {
			//부동소수형에서 심볼형으로 변환
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				System.exit(0);
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "float->sym";
			}
		});
	    
	    PrimDict.getInstance().put("sym->int",new PrimWord() {
			//심볼형에서 정수형으로 변환
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				System.exit(0);
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "sym->int";
			}
		});	
	    
	    PrimDict.getInstance().put("sym->float",new PrimWord() {
			//심볼형에서 부동소수형으로 변환			
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				System.exit(0);
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "sym->float";
			}
		}); 
      
	    PrimDict.getInstance().put("sym->str",new PrimWord() {
			//심볼형에서 문자열로 변환  			
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				System.exit(0);
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "sym->str";
			}
		}); 
	    PrimDict.getInstance().put("sym->bool",new PrimWord() {
			//심볼형에서 부울대수형으로 변환  ﻿			
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				System.exit(0);
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "sym->bool";
			}
		});
	    
	    PrimDict.getInstance().put("bool->sym",new PrimWord() {
			//부울대수형에서 심볼형으로 변환			
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				System.exit(0);
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "bool->sym";
			}
		});	
	    
	    PrimDict.getInstance().put("bool->str",new PrimWord() {
 			//부울대수형에서 문자열로 변환 		
			@Override
			public Object excute() {
				// TODO Auto-generated method stub
				System.exit(0);
				return null;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "bool->str";
			}
		}); 
      
	 
	}
}
