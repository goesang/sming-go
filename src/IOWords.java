import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;


public class IOWords {
	public IOWords(){
    	PrimDict.getInstance().put("read",new PrimWord() {
			
			@Override
			public Object excute() throws Exception{
				// TODO Auto-generated method stub
				Error.enoughMsg(1,"read");
				Object obj = DataStack.getInstance().pop();
				if (obj instanceof String) {
					String str = (String) obj;
					try{
						FileReader fr = new FileReader(str);
						BufferedReader br = new BufferedReader(fr);
						StringBuilder fStr = new StringBuilder();
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
						throw new Exception("\"" + str+"\"이란 파일은 존재하지 않습니다! -- \"read\"");
					}
				}
				else{
					Error.errorString("이","read");
				}
				return null;

			}
			public String toString(){
				return "read";
			}
		});
    	
    	PrimDict.getInstance().put("write",new PrimWord() {
			
			@Override
			public Object excute() throws Exception{
				// TODO Auto-generated method stub
				Error.enoughMsg(2,"write");
				Object obj2 = DataStack.getInstance().pop();
				Object obj1 = DataStack.getInstance().pop();
				if (obj1 instanceof String) {
					String str1 = (String) obj1;
					if (obj2 instanceof String) {
						String str2 = (String) obj2;
						try{
							FileWriter fw = new FileWriter(str1);
							BufferedWriter bw = new BufferedWriter(fw);
							bw.write(str2);
							bw.close();
							fw.close();
						}
						catch(Exception e){
							throw new Exception("파일을 저장하는데 오류가 발생했습니다! -- \"write\"");
						}
					}
					else{
						Error.errorString("두번째","write");
					}
				}
				else{
					Error.errorString("첫번째","write");
				}
				return null;

			}
			public String toString(){
				return "read";
			}
		});
	}
}
