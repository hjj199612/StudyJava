package src.designpattern.annotaionProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author huangjj24
 * @date 2021-7-17 10:12
 **/
public class TransactionHandler implements InvocationHandler {
    Object object;

    public TransactionHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        if (method.isAnnotationPresent(Transaction.class) || method.getDeclaringClass()
                .isAnnotationPresent(Transaction.class)) {
            try {
                System.out.println("开启事务");
                result = method.invoke(object, args);
                System.out.println("提交事务");
            } catch (Exception e) {
                System.out.println("回滚事务");
                throw e;
            }
        } else {
            result = method.invoke(object, args);
        }
        return result;
    }
}
