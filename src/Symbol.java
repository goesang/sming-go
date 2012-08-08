public class Symbol {
	//스밍고에서 심볼로 쓰일 객체!
  private String symbol; // 표시될 문자열이 저장되는 부분
	
	public Symbol(String str) {
		// TODO Auto-generated constructor stub
    // 심볼 객체는 문자열을 받아 심볼객체를 만듬!
		this.symbol = str;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return symbol;
	}
}
