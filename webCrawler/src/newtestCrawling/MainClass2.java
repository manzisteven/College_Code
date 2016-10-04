package newtestCrawling;

import java.io.IOException;

public class MainClass2 {

	public static void main(String[] args) {
	final crawler obj = new crawler ();
	
	obj.show();
	
	Thread thread = new Thread(new Runnable() {
		
		public void run() {
			final crawler obj1 = new crawler ();
	 try {
		   obj.loadIndexFiletoHashmap();
		} catch (IOException eks) {
			// TODO Auto-generated catch block
			
		}
	
		
	try {
		obj.docReadSearchCacheToMem();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
		}
	});
	thread.start();
	

	}

}
