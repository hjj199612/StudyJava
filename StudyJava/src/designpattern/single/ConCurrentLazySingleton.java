package designpattern.single;

/**
 * @author hjj199612
 * @date 2021/8/9 10:36 下午
 * @description 多线程 懒汉 懒加载 单例模式
 */
public class ConCurrentLazySingleton {

    private static volatile ConCurrentLazySingleton singleton;

    private ConCurrentLazySingleton() {
    }

    public ConCurrentLazySingleton getSingleton() {
        if (singleton == null) {
            synchronized (ConCurrentLazySingleton.class) {
                if (singleton == null) {
                    singleton = new ConCurrentLazySingleton();
                }
            }
        }
        return singleton;
    }

}
