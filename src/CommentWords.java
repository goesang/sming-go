public class CommentWords {
//주석과 관련된 단어들이 정의됨
		public CommentWords(){
			PrimDict.getInstance().put("!!~",new PrimWord() {
		  // '!!~'를 입력시 그줄이 주석처리됨
				@Override
				public Object excute() throws Exception  {
					// TODO Auto-generated method stub
					SmingGo.getInstance().nextCharsUpTo('\n');
					return null;
				}
				public String toString(){
					return "!!~";
			}
		});
			
			PrimDict.getInstance().put("!~",new PrimWord() {
		  // '!~'를 입력시 '~!'까지 주석처리됨				
				@Override
				public Object excute() throws Exception  {
					// TODO Auto-generated method stub
					SmingGo.getInstance().nextCharsUpTo('!');
					return null;
				}
				public String toString(){
					return "!~";
			}
		});
			
		    PrimDict.getInstance().get("!!~").im = true;
		    PrimDict.getInstance().get("!~").im = true;
		    
     //    PrimDict.getInstance().get("!!~").level = 2;         @@@
		 //   PrimDict.getInstance().get("!~").level = 2;          @@@
          
          
		    PrimDict.getInstance().get("!!~").meaning = " -- ";
		    PrimDict.getInstance().get("!~").meaning = " -- ";			
	}
}
