
public class CommentWords {
		public CommentWords(){
			PrimDict.getInstance().put("##",new PrimWord() {
		
				@Override
				public Object excute() throws Exception  {
					// TODO Auto-generated method stub
					SmingGo.getInstance().nextCharsUpTo('\n');
					return null;
				}
				public String toString(){
					return "##";
			}
		});
			
			PrimDict.getInstance().put("#",new PrimWord() {
				
				@Override
				public Object excute() throws Exception  {
					// TODO Auto-generated method stub
					SmingGo.getInstance().nextCharsUpTo('#');
					return null;
				}
				public String toString(){
					return "#";
			}
		});
			
		    PrimDict.getInstance().get("##").im = true;
		    PrimDict.getInstance().get("#").im = true;
		    
		    PrimDict.getInstance().get("##").meaning = " -- ";
		    PrimDict.getInstance().get("#").meaning = " -- ";			
	}
}
