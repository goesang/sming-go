public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SmingGo interpreter = SmingGo.getInstance();
		
		new PrintTingWords();
		new StackWords();
		new StringWords();
		new DefineWords();
		new ListWords();
		new MathWords();
		new ControlWords();
		new BooleanWords();
		new CommentWords();
		new IOWords();
		new CheckWords();
		new ConvertWords();
		new ProcessingWords();
		
		interpreter.run(" ( 200 300 p-size 1 2 3 background ) draw");
	}
}
