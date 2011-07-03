import java.util.Random;


public class MathWords {
	
	public MathWords(){

    	PrimDict.getInstance().put("+",new PrimWord() {
			
			@Override
			public Object excute() throws Exception  {
				// TODO Auto-generated method stub
				Error.enoughMsg(2,"+");

					Object obj = DataStack.getInstance().pop();
					Object sub = DataStack.getInstance().pop();
					if (sub instanceof Float) {
						Float newSub = (Float) sub;
						
						if (obj instanceof Float) {
							Float newObj = (Float) obj;
							return(newSub + newObj);
						}
						else if (obj instanceof Integer){
							Float newObj = new Float(obj.toString());
							return(newSub + newObj);
						}
						else{
							Error.errorNum("두번째","+");
						}
					}
					else if(sub instanceof Integer){
						if (obj instanceof Integer) {
							Integer newSub = (Integer)sub;
							Integer newObj = new Integer(obj.toString());
							return(newSub + newObj);
						}
						else if(obj instanceof Float){
							Float newSub = new Float(sub.toString());
							Float newObj =(Float) obj;
							return(newSub + newObj);
						}
						else{
							Error.errorNum("두번째","+");
						}
					}
					else {
						Error.errorNum("첫번째","+");
					}
					return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "+";
			}
		});
    	
    	PrimDict.getInstance().put("-",new PrimWord() {
			
			@Override
			public Object excute() throws Exception  {
				// TODO Auto-generated method stub
				Error.enoughMsg(2,"-");

				Object obj = DataStack.getInstance().pop();
				Object sub = DataStack.getInstance().pop();
				
				if (sub instanceof Float) {
					Float newSub = (Float) sub;
						
					if (obj instanceof Float) {
						Float newObj = (Float) obj;
						return(newSub - newObj);
					}
					else if (obj instanceof Integer){
						Float newObj = new Float(obj.toString());
						return(newSub - newObj);
					}
					else{
						Error.errorNum("두번째","-");
						}
					}
					else if(sub instanceof Integer){
						
						if (obj instanceof Integer) {
							Integer newSub = (Integer)sub;
							Integer newObj = new Integer(obj.toString());
							return(newSub - newObj);
						}
						else if(obj instanceof Float){
							Float newSub = new Float(sub.toString());
							Float newObj =(Float) obj;
							return(newSub - newObj);
						}
						else{
							Error.errorNum("첫번째","-");
						}
					}
					else {
						Error.errorNum("첫번째","-");
					}
				
				return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "-";
			}
		});
    	
    	PrimDict.getInstance().put("*",new PrimWord() {
			
			@Override
			public Object excute() throws Exception  {
				// TODO Auto-generated method stub
				Error.enoughMsg(2,"*");

					Object obj = DataStack.getInstance().pop();
					Object sub = DataStack.getInstance().pop();
					
					if (sub instanceof Float) {
						Float newSub = (Float) sub;
						
						if (obj instanceof Float) {
							Float newObj = (Float) obj;
							return(newSub * newObj);
						}
						else if (obj instanceof Integer){
							Float newObj = new Float(obj.toString());
							return(newSub * newObj);
						}
						else{
							Error.errorNum("두번째","*");
						}
						
					}
					else if(sub instanceof Integer){
				
						if (obj instanceof Integer) {
							Integer newSub = (Integer)sub;
							Integer newObj = new Integer(obj.toString());
							return(newSub * newObj);
						}
						else if(obj instanceof Float){
							Float newSub = new Float(sub.toString());
							Float newObj =(Float) obj;
							return(newSub * newObj);
						}
						else{
							Error.errorNum("두번째","*");
						}
						
					}
					else {
						Error.errorNum("첫번째","*");
					}
					return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "*";
			}
		});
    	
    	PrimDict.getInstance().put("/",new PrimWord() {
			
			@Override
			public Object excute() throws Exception {
				// TODO Auto-generated method stub
				Error.enoughMsg(2,"/");

					Object obj = DataStack.getInstance().pop();
					Object sub = DataStack.getInstance().pop();
					
					if (sub instanceof Float) {
						Float newSub = (Float) sub;
						
						if (obj instanceof Float) {
							Float newObj = (Float) obj;
							return(newSub / newObj);
						}
						else if (obj instanceof Integer){
							Float newObj = ((Integer)obj).floatValue();
							return(newSub / newObj);
						}
						else{
							Error.errorNum("두번째","/");
						}
					}
					else if(sub instanceof Integer){
					
						if (obj instanceof Integer) {
							Integer newSub = (Integer)sub;
							Integer newObj = (Integer)obj;
							return(newSub / newObj);
						}
						else if(obj instanceof Float){
							Float newSub = ((Integer)sub).floatValue();
							Float newObj =(Float) obj;
							return(newSub / newObj);
						}
						else{
							Error.errorNum("두번째","/");
						}	
					}
					else {
						Error.errorNum("첫번째","/");
					}
					return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "/";
			}
		});
    	
    	PrimDict.getInstance().put("%",new PrimWord() {
			
			@Override
			public Object excute() throws Exception  {
				// TODO Auto-generated method stub
				Error.enoughMsg(2,"%");

					Object obj = DataStack.getInstance().pop();
					Object sub = DataStack.getInstance().pop();
				
					if (sub instanceof Float) {
						Float newSub = (Float) sub;
						
						if (obj instanceof Float) {
							Float newObj = (Float) obj;
							return(newSub % newObj);
						}
						else if (obj instanceof Integer){
							Float newObj = ((Integer)obj).floatValue();
							return(newSub % newObj);
						}
						else{
							System.out.println("두번째 단어는 숫자가 아닙니다.");
							return null;
						}
						
					}
					else if(sub instanceof Integer){
						
						if (obj instanceof Integer) {
							Integer newSub = (Integer)sub;
							Integer newObj = (Integer)obj;
							return(newSub % newObj);
						}
						else if(obj instanceof Float){
							Float newSub = ((Integer)sub).floatValue();
							Float newObj = (Float) obj;
							return(newSub % newObj);
						}
						else{
							Error.errorNum("두번째","%");
						}
					}
					else {
						Error.errorNum("첫번째","%");
					}
					return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "%";
			}
		});
    	
	PrimDict.getInstance().put(">?",new PrimWord() {
			
			@Override
			public Object excute() throws Exception  {
				// TODO Auto-generated method stub
				Error.enoughMsg(2,">?");
				
					Object obj = DataStack.getInstance().pop();
					Object sub = DataStack.getInstance().pop();
				
					if (sub instanceof Float) {
						Float newSub = (Float) sub;
						
						if (obj instanceof Float) {
							Float newObj = (Float) obj;
							return(newSub > newObj);
						}
						else if (obj instanceof Integer){
							Float newObj = ((Integer)obj).floatValue();
							return(newSub > newObj);
						}
						else{
							Error.errorNum("두번째",">?");
						}
						
					}
					else if(sub instanceof Integer){
						
						if (obj instanceof Integer) {
							Integer newSub = (Integer)sub;
							Integer newObj = (Integer)obj;
							return(newSub > newObj);
						}
						else if(obj instanceof Float){
							Float newSub = ((Integer)sub).floatValue();
							Float newObj = (Float) obj;
							return(newSub > newObj);
						}
						else{
							Error.errorNum("두번째",">?");
						}
						
					}
					else {
						Error.errorNum("첫번째",">?");
					}
					
					return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return ">?";
			}
		});
	
	PrimDict.getInstance().put(">=?",new PrimWord() {
		
		@Override
		public Object excute() throws Exception  {
			// TODO Auto-generated method stub
			Error.enoughMsg(2,">=?");

				Object obj = DataStack.getInstance().pop();
				Object sub = DataStack.getInstance().pop();
			
				if (sub instanceof Float) {
					Float newSub = (Float) sub;
					
					if (obj instanceof Float) {
						Float newObj = (Float) obj;
						return(newSub > newObj);
					}
					else if (obj instanceof Integer){
						Float newObj = ((Integer)obj).floatValue();
						return(newSub > newObj);
					}
					else{
						Error.errorNum("두번째",">=?");
					}
					
				}
				else if(sub instanceof Integer){
					
					if (obj instanceof Integer) {
						Integer newSub = (Integer)sub;
						Integer newObj = (Integer)obj;
						return(newSub > newObj);
					}
					else if(obj instanceof Float){
						Float newSub = ((Integer)sub).floatValue();
						Float newObj = (Float) obj;
						return(newSub > newObj);
					}
					else{
						Error.errorNum("두번째",">=?");
					}
					
				}
				else {
					Error.errorNum("첫번째",">=?");
				}
				return null;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return ">=?";
		}
	});
	
	PrimDict.getInstance().put("<?",new PrimWord() {
		
		@Override
		public Object excute() throws Exception  {
			// TODO Auto-generated method stub
			Error.enoughMsg(2,"<?");

				Object obj = DataStack.getInstance().pop();
				Object sub = DataStack.getInstance().pop();
			
				if (sub instanceof Float) {
					Float newSub = (Float) sub;
					
					if (obj instanceof Float) {
						Float newObj = (Float) obj;
						return(newSub > newObj);
					}
					else if (obj instanceof Integer){
						Float newObj = ((Integer)obj).floatValue();
						return(newSub < newObj);
					}
					else{
						Error.errorNum("두번째","<?");
					}
					
				}
				else if(sub instanceof Integer){
					
					if (obj instanceof Integer) {
						Integer newSub = (Integer)sub;
						Integer newObj = (Integer)obj;
						return(newSub < newObj);
					}
					else if(obj instanceof Float){
						Float newSub = ((Integer)sub).floatValue();
						Float newObj = (Float) obj;
						return(newSub < newObj);
					}
					else{
						Error.errorNum("두번째","<?");
					}
					
				}
				else {
					Error.errorNum("첫번째","<?");
				}
				return null;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "<?";
		}
	});
	
PrimDict.getInstance().put("<=?",new PrimWord() {
		
		@Override
		public Object excute() throws Exception  {
			// TODO Auto-generated method stub
			Error.enoughMsg(2,"<=?");

				Object obj = DataStack.getInstance().pop();
				Object sub = DataStack.getInstance().pop();
			
				if (sub instanceof Float) {
					Float newSub = (Float) sub;
					
					if (obj instanceof Float) {
						Float newObj = (Float) obj;
						return(newSub > newObj);
					}
					else if (obj instanceof Integer){
						Float newObj = ((Integer)obj).floatValue();
						return(newSub < newObj);
					}
					else{
						Error.errorNum("두번째","<=?");
					}
					
				}
				else if(sub instanceof Integer){
					
					if (obj instanceof Integer) {
						Integer newSub = (Integer)sub;
						Integer newObj = (Integer)obj;
						return(newSub < newObj);
					}
					else if(obj instanceof Float){
						Float newSub = ((Integer)sub).floatValue();
						Float newObj = (Float) obj;
						return(newSub < newObj);
					}
					else{
						Error.errorNum("두번째","<=?");
					}
					
				}
				else {
					Error.errorNum("첫번째","<=?");
				}
				return null;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "<=?";
		}
	});
    	
    	PrimDict.getInstance().put("^",new PrimWord() {
			
			@Override
			public Object excute() throws Exception  {
				// TODO Auto-generated method stub
				Error.enoughMsg(2,"^");

				Object obj = DataStack.getInstance().pop();
				Object sub = DataStack.getInstance().pop();
				
				if (sub instanceof Float) {
					Float newSub = (Float) sub;
					
					if (obj instanceof Float) {
						Float newObj = (Float) obj;
						return(Math.pow(newSub,newObj));
					}
					else if (obj instanceof Integer){
						Float newObj = ((Integer)obj).floatValue();
						return(Math.pow(newSub,newObj));
					}
					else{
						Error.errorNum("두번째","^");
					}
						
				}
				else if(sub instanceof Integer){
						
					if (obj instanceof Integer) {
						Integer newSub = (Integer)sub;
						Integer newObj = (Integer)obj;
						return(Math.pow(newSub,newObj));
					}
					else if(obj instanceof Float){
						Float newSub = ((Integer)sub).floatValue();
							Float newObj =(Float) obj;
							return(Math.pow(newSub,newObj));
						}
						else{
							Error.errorNum("두번째","^");
						}
					}
					else {
						Error.errorNum("첫번째","^");
					}
				return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "^";
			}
		});
    	
    	PrimDict.getInstance().put("random",new PrimWord() {
			
			@Override
			public Object excute() throws Exception  {
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"random");
				
				Object sub = DataStack.getInstance().pop();
				Random ran = new Random();
				if (sub instanceof Float) {
					Integer newSub = ((Float)sub).intValue();
					return ran.nextInt(newSub);
				}
				else if(sub instanceof Integer){
					return ran.nextInt(((Integer)sub).intValue());
				}
				else {
					Error.errorNum("이","random");
				}
				return null;
    	}
    	@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "random";
			}
		});
    	
  	PrimDict.getInstance().put("abs",new PrimWord() {
			
			@Override
			public Object excute() throws Exception  {
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"abs");

					Object sub = DataStack.getInstance().pop();
					if (sub instanceof Float) {
						return (Math.abs(((Float) sub).floatValue()));
					}
					else if(sub instanceof Integer){
						return (Math.abs(((Integer) sub).intValue()));
					}
					else {
						Error.errorNum("이","abs");
					}
					return null;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "abs";
			}
		});
    	
	PrimDict.getInstance().get("+").meaning = " num1 num2 -- num3 ";
	PrimDict.getInstance().get("-").meaning = " num1 num2 -- num3 ";
	PrimDict.getInstance().get("*").meaning = " num1 num2 -- num3 ";
	PrimDict.getInstance().get("/").meaning = " num1 num2 -- num3 ";
	PrimDict.getInstance().get("%").meaning = " num1 num2 -- num3 ";
	PrimDict.getInstance().get(">?").meaning = " num1 num2 -- bool ";
	PrimDict.getInstance().get(">=?").meaning = " num1 num2 -- bool ";
	PrimDict.getInstance().get("<?").meaning = " num1 num2 -- bool ";
	PrimDict.getInstance().get("<=?").meaning = " num1 num2 -- bool ";
	PrimDict.getInstance().get("^").meaning = " num1 num2 -- num3 ";
	PrimDict.getInstance().get("random").meaning = " num1 -- num2 ";
	PrimDict.getInstance().get("abs").meaning = " num1 -- num2 "; 	
	}

}
