package files2;
public class AsyncData implements Runnable,ChangeHandler {
	Filecontr afd;
public AsyncData(Filecontr fd) {
		this.afd=fd;
	}
	public void run() {
		while(true){
		 afd.compare();
			 try {
	                Thread.sleep(3000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
		 }
}
public void onChange() {
	
	}
}
