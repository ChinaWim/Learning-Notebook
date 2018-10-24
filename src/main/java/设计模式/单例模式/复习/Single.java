package 设计模式.单例模式.复习;

public class Single{
	private Single(){}
	private static class T{
		public static Single single = new Single();
	}
	public static Single getSingle(){
		return T.single;
	}
}