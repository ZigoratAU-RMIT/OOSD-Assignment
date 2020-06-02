package Patterns.Chain;

public abstract class AbstractLogger {
	public static int SHARK = 1;
	public static int SHAEKATTACK = 2;
	public static int EAGLE = 3;
	public static int EAGLEATTACK = 4;
	
	
	protected int level;
	public String message;
	
	
	//next element responsibility
	 protected AbstractLogger nextLogger;
	 
	 public void setNextLogger(AbstractLogger nextLogger) {
		 this.nextLogger = nextLogger;
	 }
	 	 
	 public void setwMessage(int level, String message) {
		 if(this.level <= level) {
			 changeMessage(message);
		 }
		 if(nextLogger != null) {
			 nextLogger.setwMessage(level, message);
		 }
	 }
	 
	 abstract protected void changeMessage(String message);
}
