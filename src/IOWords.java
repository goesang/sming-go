import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;


public class IOWords {
	public IOWords(){
   //파일을 다루는 단어들 모음!
    	PrimDict.getInstance().put("file-read",new PrimWord() {
			//단순히 파일을 읽어와서 문자열로 값을 내놓음
			@Override
			public Object excute() throws Exception{
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"file-read");
				Object obj = DataStack.getInstance().pop();
				if (obj instanceof Symbol) {
					Symbol symbol = (Symbol) obj;
					try{
						FileReader fr = new FileReader(symbol.toString()); // 파일 리더 만듬
						BufferedReader br = new BufferedReader(fr);    // 버퍼 리더로 감쌈
						StringBuilder readString = new StringBuilder();     // 옮겨 적음 스트링빌더 생성
						do {
							String stringTmp = br.readLine();
							if(stringTmp == null) break;
							readString.append(stringTmp+"\n");
						} while(true);
						DataStack.getInstance().push(readString);
						br.close();
						fr.close();
					}
					catch(Exception e){
						throw new Exception("\"" + symbol.toString()+"\"이란 파일은 존재하지 않습니다! -- \"file-easy-read\"");
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
    	
    	PrimDict.getInstance().put("file-write",new PrimWord() {
			//단순히 문자열을 파일에 씀
			@Override
			public Object excute() throws Exception{
				// TODO Auto-generated method stub
				Error.enoughMsg(2,"file-write");
				Object obj2 = DataStack.getInstance().pop();
				Object obj1 = DataStack.getInstance().pop();
				if (obj1 instanceof Symbol) {
					Symbol sym = (Symbol) obj1;
					if (obj2 instanceof String) {
						String writeString = (String) obj2;
						try{
							FileWriter fw = new FileWriter(sym.toString());
							BufferedWriter bw = new BufferedWriter(fw);
							bw.write(writeString);
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
      
      
	}
}
