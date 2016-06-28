package singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 测试五种方式的效率
 * @author Admain
 *
 */
public class CompareTest {
	public static void main(String[] args) throws InterruptedException {
		long start=System.currentTimeMillis();
		int threadNum=10;
		final CountDownLatch countDownLatch=new CountDownLatch(threadNum);
		for(int i=0;i<threadNum;i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int i=0;i<100000;i++){
//						Object o=LazyStyle.getInstance();
//						Object o=EnumStyle.instance;
						Object o=StaticInnerClass.getInstance();
					}
					countDownLatch.countDown();
				}
			}).start();
		}
	countDownLatch.await(); //main线程阻塞
	long end=System.currentTimeMillis();
	System.out.println("总耗时"+(end-start));
	}
}
