import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;


public class IOWords {
	public IOWords(){
   //파일을 다루는 단어들 모음!
    	PrimDict.getInstance().put("file-easy-read",new PrimWord() {
			//단순히 파일을 읽어와서 문자열로 값을 내놓음
			@Override
			public Object excute() throws Exception{
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"file-easy-read");
				Object obj = DataStack.getInstance().pop();
				if (obj instanceof Symbol) {
					Symbol sym = (Symbol) obj;
					try{
						FileReader fr = new FileReader(sym.toString()); // 파일 리더 만듬
						BufferedReader br = new BufferedReader(fr);    // 버퍼 리더로 감쌈
						StringBuilder fStr = new StringBuilder();     // 옮겨 적음 스트링빌더 생성
						do {
							String strTmp = br.readLine();
							if(strTmp == null) break;
							fStr.append(strTmp+"\n");
						} while(true);
						DataStack.getInstance().push(fStr.toString());
						br.close();
						fr.close();
					}
					catch(Exception e){
						throw new Exception("\"" + str+"\"이란 파일은 존재하지 않습니다! -- \"file-easy-read\"");
					}
				}
				else{
					Error.errorString("이","file-easy-read");
				}
				return null;

			}
			public String toString(){
				return "file-easy-read";
			}
		});
    	
    	PrimDict.getInstance().put("file-easy-write",new PrimWord() {
			//단순히 문자열을 파일에 씀
			@Override
			public Object excute() throws Exception{
				// TODO Auto-generated method stub
				Error.enoughMsg(2,"file-easy-write");
				Object obj2 = DataStack.getInstance().pop();
				Object obj1 = DataStack.getInstance().pop();
				if (obj1 instanceof Symbol) {
					Symbol sym = (Symbol) obj1;
					if (obj2 instanceof String) {
						String str = (String) obj2;
						try{
							FileWriter fw = new FileWriter(sym.toString());
							BufferedWriter bw = new BufferedWriter(fw);
							bw.write(str2);
							bw.close();
							fw.close();
						}
						catch(Exception e){
							throw new Exception("파일을 저장하는데 오류가 발생했습니다! -- \"file-easy-write\"");
						}
					}
					else{
						Error.errorString("두번째","file-easy-write");
					}
				}
				else{
					Error.errorString("첫번째","file-easy-write");
				}
				return null;

			}
			public String toString(){
				return "file-easy-write";
			}
		});
      
       PrimDict.getInstance().put("file-open",new PrimWord() {
			//단순히 문자열을 파일에 씀
			@Override
			public Object excute() throws Exception{
				// TODO Auto-generated method stub
			 

			}
			public String toString(){
				return "file-open";
			}
		});
      
       PrimDict.getInstance().put("file-read",new PrimWord() {
			//단순히 문자열을 파일에 씀
			@Override
			public Object excute() throws Exception{
				// TODO Auto-generated method stub
			 

			}
			public String toString(){
				return "file-read";
			}
		});
      
      PrimDict.getInstance().put("file-write",new PrimWord() {
			//단순히 문자열을 파일에 씀
			@Override
			public Object excute() throws Exception{
				// TODO Auto-generated method stub
			 

			}
			public String toString(){
				return "file-write";
			}
		});
      
      PrimDict.getInstance().put("file-close",new PrimWord() {
			//단순히 문자열을 파일에 씀
			@Override
			public Object excute() throws Exception{
				// TODO Auto-generated method stub
			 

			}
			public String toString(){
				return "file-close";
			}
		});
      
	}
}
