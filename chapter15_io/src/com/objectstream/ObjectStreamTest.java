package com.objectstream;

import org.junit.Test;

import java.io.*;

/**
 * ClassName:
 * Description:
 *
 *                  ObjectInputStream, ObjectOutputStream 的目的在於將 物件，序列化(寫入、保存)到文件中，
 *                  避免其在內存中當電腦關了or沒在使用時等原因 被 GC回收
 *
 *                  自定義類 想要序列化:
 *                      1. 需要implements Serializable接口
 *                      2. 需要聲明一個全局常量 static final long serialVersionUID = 424746L; (數字隨便改)
 *                      3. 需要自定義類中的 所有屬性 都必須是要可序列化的
 *                              > 基本數據類型: 默認就是可序列化的
 *                              > 引用數據類型: 必須要 implements Serializable接口，並加上全局常量 (數字隨便改)
 *                      ! 若類中的屬性 聲明 transient 或 static 都不會參與序列化
 *
 * @Author Rin
 * @Create 2024/6/5 下午 12:58
 * @Version 1.0
 */
public class ObjectStreamTest {

    /**
     * String類物件的 序列化、反序列化
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        File file = new File("object.txt");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

        //writeUTF(): 寫入 "String類物件" 的方法
        oos.writeUTF("這是一行測試字串");

        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        //readUTF(): 讀取文件中保存的 "String類物件" 的方法
        String str = ois.readUTF();

        System.out.println(str);

        ois.close();
    }

    /**
     * 自定義類物件的 序列化、反序列化，規則如最上 Description
     * @throws IOException
     */
    @Test
    public void test2() throws IOException, ClassNotFoundException {
        File file = new File("object2.txt");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

        //writeObject():
        Person p = new Person("brian", 20, new Account(3000));
        Person p1 = new Person("gummy", 24, new Account(10000));
        oos.writeObject(p);
        oos.writeObject(p1);

        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        //readObject():

        Object o = ois.readObject();
        Object o1 = ois.readObject();

        System.out.println(o);
        System.out.println(o1);

        ois.close();
    }
}
