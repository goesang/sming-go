import processing.core.PApplet;

public class Processing extends PApplet {

	List<Object> list;
	
	
	public Processing(){
		super();
		this.list = new List<Object>();
	}
	
	private void excute(){
		if(ProcessingStack.getInstance().stack.size()>0){

			for(int i = ProcessingStack.getInstance().stack.size()-1; i>=0;i--){
				
				Integer num = (Integer)ProcessingStack.getInstance().stack.get(i);
				
				switch (num) {
				case 1:

					size(	((Integer)DataStack .getInstance().pop()).intValue(),
							((Integer)DataStack .getInstance().pop()).intValue());
					break;
					
				case 2:
					int a1 = ((Integer)DataStack .getInstance().pop());
					int a2 = ((Integer)DataStack .getInstance().pop());
					int a3 = ((Integer)DataStack .getInstance().pop());
					System.out.println("background");
					System.out.println(a3);
					System.out.println(a2);
					System.out.println(a1);
					background(	a3,
							a2,
							a1);
					break;
					
				case 3:
					fill(	((Integer)DataStack .getInstance().pop()).intValue(),
							((Integer)DataStack .getInstance().pop()).intValue(),
							((Integer)DataStack .getInstance().pop()).intValue());
					break;	
					
				case 4:
					System.out.println("line");
					int a5 = ((Integer)DataStack .getInstance().pop());
					int a6 = ((Integer)DataStack .getInstance().pop());
					int a7 = ((Integer)DataStack .getInstance().pop());
					int a8 = ((Integer)DataStack .getInstance().pop());
					System.out.println(a8);
					System.out.println(a7);
					System.out.println(a6);
					System.out.println(a5);
					line(a8,a7,a6,a5);
					break;
				
				default:
					break;
				}
			}
		}
	}
	
	public void setup() {
		try{
			for (Object ob : list){
				if (ob instanceof PrimWord) {
					PrimWord fu = (PrimWord) ob;
					Object obj = fu.excute();
					if(obj != null)
						DataStack.getInstance().push(obj);
				}
						
				else if (ob instanceof UserWord) {
					UserWord uf = (UserWord) ob;
					DataStack.getInstance().push(uf.toArray());
					PrimDict.getInstance().get("run").excute();
				}
				
				else{ 
					DataStack.getInstance().push(ob);
				}
				excute();
	
			}
			
			excute();
		}
		catch(Exception e){
			System.out.println("프로세싱 에러!");
		}
	}

  
}