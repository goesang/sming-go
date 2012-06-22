
public class Error {
	public static void enoughMsg(int num,String name) throws Exception{
		if(DataStack.getInstance().size()<num)
		throw new Exception("자료 더미에 단어가 충분히 쌓이지 않았습니다! -- \""+name+"\"");
	}
	public static void errorInt(String num,String name) throws Exception{
		throw new Exception(num+" 단어는 '정수'가 아닙니다! -- \""+name+"\"");
	}
	public static void errorFloat(String num,String name) throws Exception{
		throw new Exception(num+" 단어는 '실수'가 아닙니다! -- \""+name+"\"");
	}
	public static void errorNum(String num,String name) throws Exception{
		throw new Exception(num+" 단어는 '숫자'가 아닙니다! -- \""+name+"\"");
	}
	public static void errorList(String num,String name) throws Exception{
		throw new Exception(num+" 단어는 '목록'이 아닙니다! -- \""+name+"\"");
	}
	public static void errorBool(String num,String name) throws Exception{
		throw new Exception(num+" 단어는 '불 대수'가 아닙니다! -- \""+name+"\"");
	}
	public static void errorString(String num,String name) throws Exception{
		throw new Exception(num+" 단어는  '문자열'이 아닙니다! -- \""+name+"\"");
	}
	public static void errorPrimWord(String num,String name) throws Exception{
		throw new Exception(num+" 단어는 '기본 정의 단어'가 아닙니다! -- \""+name+"\"");
	}
	public static void errorUserWord(String num,String name) throws Exception{
		throw new Exception(num+" 단어는 '사용자 정의 단어'가 아닙니다! -- \""+name+"\"");
	}
	public static void errorLamda(String num,String name) throws Exception{
		throw new Exception(num+" 단어는 '람다'가 아닙니다! -- \""+name+"\"");
	}
	public static void errorSymbol(String num,String name) throws Exception{
		throw new Exception(num+" 단어는 '심볼'이 아닙니다! -- \""+name+"\"");
	}
}
