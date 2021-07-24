package current.thread.mkevin.demo3;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 内存操作
 */
public class UnsafeDemo5 {

    public static int state = 0;

    public static void main(String[] args) {
        UnsafeDemo5 demo0 = new UnsafeDemo5();
        try {
            //通过反射获取Unsafe的静态成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //设置此字段为可存取
            field.setAccessible(true);
            //获取变量的值,强转为Unsafe类对象
            Unsafe unsafe = (Unsafe) field.get(null);

            //获取单个内存地址大小
            int addressSize = unsafe.addressSize();
            System.out.println("Kevin-1-addressSize>"+addressSize);
            //获取内存页大小
            int pageSize = unsafe.pageSize();
            System.out.println("Kevin-2-pageSize>"+pageSize);

            //分配8字节内存，并返回内存首地址
            long address = unsafe.allocateMemory(8L);
            System.out.println("Kevin-3-allocateMemory>"+address);

            //初始化内存
            unsafe.setMemory(address,8L, (byte)1);

            //设置内存地址的值,为10
            unsafe.putInt(address,10);
            System.out.println("Kevin-4-getInt:" + unsafe.getInt(address));

            //设置内存地址+4的值,为10
            unsafe.putInt(address+4,12);
            System.out.println("Kevin-5-getInt:" + unsafe.getInt(address+4));

            //设置内存地址+8的值,为13
            unsafe.putInt(address+4+4,13);
            System.out.println("Kevin-6-getInt:" + unsafe.getInt(address+4+4));

            //覆盖起始地址值为8L
            unsafe.putLong(address,81L);
            System.out.println("Kevin-7-getLong:" + unsafe.getLong(address));

            System.out.println("Kevin-8-getInt:"  + unsafe.getInt(address+4+4));

            //再分配一块内存
            long newAddress = unsafe.allocateMemory(8l);
            //copy内存
            unsafe.copyMemory(address,newAddress,8L);
            System.out.println("Kevin-9-getLong:" + unsafe.getLong(newAddress));

            //释放内存
            unsafe.freeMemory(address);
            System.out.println("Kevin-10-getLong:" + unsafe.getLong(address));

            //Kevin: 重复释放会导致JRE异常
            //unsafe.freeMemory(address);


        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
