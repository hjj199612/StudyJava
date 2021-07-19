package src.functionCoding;

/**
 * @Description:
 * @Author: huangjj24
 * @CreateDate: 2021-4-14 16:13
 **/
@FunctionalInterface
public interface Operation<T,R> {

    R operation(T t1,T t2);
    default void operation2(T t1,T t2) {
    }

}
