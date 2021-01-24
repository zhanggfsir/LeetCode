package _88_VIP6;

// 单例的双重检测实现 -- 实现线程安全的单例写法
public class Singleton {
    private static Singleton instance;
    private Singleton(){};
    public static Singleton getInstance(){
        // 第一次检测
        if(instance==null){
            // 同步
            synchronized (Singleton.class){
                if(instance==null){
                    // 多线程环境下可能会出现问题的地方
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
}
