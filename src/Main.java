public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SmingGo interpreter = SmingGo.getInstance();
		
		Object ob1 = new PrintTingWords();
		Object ob2 = new StackWords();
		Object ob3 = new StringWords();
		Object ob4 = new DefineWords();
		Object ob5 = new ListWords();
		Object ob6 = new MathWords();
		Object ob7 = new ControlWords();
		Object ob8 = new BooleanWords();
		Object ob9 = new CommentWords();
		Object ob10 = new IOWords();
		Object ob11 = new CheckWords();
		Object ob12 = new ConvertWords();
		Object ob13 = new ProcessingWords();
		
		long start = System.currentTimeMillis();
		interpreter.run("  [ 255 255 3 background 0 0 0 pstack ]  setup ");
		
		long end = System.currentTimeMillis();

		System.out.println( "실행 시간 : " + ( end - start )/1000.00 ); 
	}
}
