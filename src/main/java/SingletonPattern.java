import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author zhangjin
 * 单例模式：
 * 意图：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * 主要解决：一个全局使用的类频繁地创建与销毁。
 * 何时使用：当您想控制实例数目，节省系统资源的时候。
 * 如何解决：判断系统是否已经有这个单例，如果有则返回，如果没有则创建。
 * 关键代码：构造函数是私有的。
 */
public class SingletonPattern {
    private static final Logger logger = LogManager.getLogger(SingletonPattern.class);
    /**
     * 懒汉，满足延迟加载，线程不安全or线程安全，效率低（synchronized getInstance函数）。
     * 饿汉，不满足延迟加载，线程安全，类加载时即实例化，容易产生垃圾对象。
     * 双重校验锁，满足延迟加载，线程安全，效率较高（因JVM指令重排序问题，可能会产生空指针，使用volatile解决），本例，
     * 静态内部类，相较双重校验锁简单，利用classloader原理，实现延迟加载。
     * static class ClassHolder{
     * private static final SingletonPattern INSTANCE = new SingletonPattern();
     * }
     * public static final getInstance(){
     * return ClassHolder.INSTANCE;
     * }
     */
    private static volatile SingletonPattern INSTANCE;

    private SingletonPattern() {
    }

    public static SingletonPattern getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonPattern.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonPattern();
                }
            }
        }
        return INSTANCE;
    }

    public void check(String input) {
        logger.trace(input);
    }
}
