package algorithm;

// JAVA 主线程等待所有子线程执行完毕再执行


import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * java主线程等待所有子线程执行完毕在执行，这个需求其实我们在工作中经常会用到，
 * 比如用户下单一个产品，后台会做一系列的处理，为了提高效率，每个处理都可以用一个线程来执行，所有处理完成了之后才会返回给用户下单成功
 */
public class _0_java主线程等待所有子线程执行完毕再执行 {
}


//-----------------------------前2种方法不用看了，直接看最后2种方法-----------------------------

// 用sleep方法，让主线程睡眠一段时间，当然这个睡眠时间是主观的时间，是我们自己定的，这个方法不推荐，但是在这里还是写一下，毕竟是解决方法
class Test1{
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程执行 ！！");
                }
            }).start();
        }
        Thread.sleep(5000);
        System.out.println("主线程执行！！");
    }
}


// 使用Thread的join()等待所有的子线程执行完毕，主线程再执行，
// thread.join()把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程。
// 比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B。
class Test2 {
    public static void main(String[] args) throws InterruptedException {
        Vector<Thread> threadsVector = new Vector<Thread>();
        for (int i = 0; i < 5; i++) {
            Thread childThread = new Thread((new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程执行 ！！");
                }
            }));
            threadsVector.add(childThread);
            childThread.start();
        }
        for (Thread thread : threadsVector) {
            thread.join();
        }
        System.out.println("主线程执行！！");
    }
}

//-----------------------------分割线-----------------------------
//-----------------------------并发包里非常有用的并发工具类-----------------------------

/*
等待多线程完成的CountDownLatch
countDownLatch 不可能重新初始化或者修改 CountDownLatch 对象内部计数器的值，一个线程调用countdown方法happen-before另外一个线程调用await方法
 */
class Test3{
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch=new CountDownLatch(5);
        for (int i=0;i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程执行 ！！");
                    latch.countDown(); // 让latch 中的数值减1
                }
            }).start();
        }
        latch.await(); // 阻塞当前线程直到latch中的值为0
        System.out.println("主线程执行！！");
    }
}

/*
同步屏障CyclicBarrier
 */

class  Test4{
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        final CyclicBarrier barrier=new CyclicBarrier(5);
        for (int i=0;i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程执行 ！！");
                    try {
                        barrier.await(); // 到达屏障
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        barrier.await();
        System.out.println("主线程执行 ！！");
    }
}

//-----------------------------总结-----------------------------

/*
 countDownLatch和cyclicBarrier有什么区别呢：
 countDownLatch只能使用一次，而CyclicBarrier方法可以使用reset()方法重置，所以CyclicBarrier方法可以能处理更为复杂的业务场景。


  在网上看到一个关于countDownLatch和cyclicBarrier的形象比喻，就是在百米赛跑的比赛中若使用
  countDownLatch的话冲过终点线一个人就给评委发送一个人的成绩，10个人比赛发送10次，如果用CyclicBarrier，
  则只在最后一个人冲过终点线的时候发送所有人的数据，仅仅发送一次，这就是区别。
 */






/*
CMS收集器（标记-清理算法）
CMS（Concurrent Mark Sweep）收集器是一种以获取最短回收停顿时间为目标的收集器。
目前很大一部分的Java应用都集中在互联网站或B/S系统的服务端上，这类应用尤其重视服务的响应速度，希望系统停顿时间最短，以给用户带来较好的体验。

从名字（包含“Mark Sweep”）上就可以看出CMS收集器是基于“标记-清除”算法实现的，
它的运作过程相对于前面几种收集器来说要更复杂一些，整个过程分为4个步骤，包括：

初始标记（CMS initial mark）

并发标记（CMS concurrent mark）

重新标记（CMS remark）

并发清除（CMS concurrent sweep）

其中初始标记、重新标记这两个步骤仍然需要“Stop The World”。
初始标记仅仅只是标记一下GC Roots能直接关联到的对象，速度很快，并发标记阶段就是进行GC Roots Tracing的过程，
而重新标记阶段则是为了修正并发标记期间，因用户程序继续运作而导致标记产生变动的那一部分对象的标记记录，
这个阶段的停顿时间一般会比初始标记阶段稍长一些，但远比并发标记的时间短。

   由于整个过程中耗时最长的并发标记和并发清除过程中，收集器线程都可以与用户线程一起工作，
所以总体上来说，CMS收集器的内存回收过程是与用户线程一起并发地执行。老年代收集器（新生代使用ParNew）

 优点:

        并发收集、低停顿、响应时间快

 缺点：

      1、对CPU资源非常敏感
      2、CMS收集器无法处理浮动垃圾，即清除时用户进程同时产生的垃圾，只能等到下次GC时回收，并发阶段会降低吞吐量
      3、因为是使用“标记-清除”算法，所以会产生大量碎片

特点：响应时间优先，减少垃圾收集停顿时间，适用于对响应时间要求高的系统

适应场景：大型服务器等。

通过JVM参数 -XX:+UseConcMarkSweepGC设置



g1收集器
在G1中，堆被划分成 许多个连续的区域(region)。采用G1算法进行回收，吸收了CMS收集器特点。

特点：支持很大的堆，高吞吐量

  --支持多CPU和垃圾回收线程

  --在主线程暂停的情况下，使用并行收集

  --在主线程运行的情况下，使用并发收集

实时目标：可配置在N毫秒内最多只占用M毫秒的时间进行垃圾回收

通过JVM参数 -XX:+UseG1GC 使用G1垃圾回收器

注意: 并发是指一个处理器同时处理多个任务。 
并行是指多个处理器或者是多核的处理器同时处理多个不同的任务。 
并发是逻辑上的同时发生（simultaneous），而并行是物理上的同时发生。 
来个比喻：并发是一个人同时吃三个馒头，而并行是三个人同时吃三个馒头。 

 */