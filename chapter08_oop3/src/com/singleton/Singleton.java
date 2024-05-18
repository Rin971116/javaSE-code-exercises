package com.singleton;

/**
 * ClassName:
 * Description:
 *              singleton單例模式，意在不讓外部創建此類，因此constructor聲明為 private，
 *              在當前類中new一個當前類的對象，也聲明為 private，不給外面去直接調用，
 *              但可以透過static 讓外部只能用 類名去調用的get()，而得到該類內部創立的 "唯一對象"
 *
 * @Author Rin
 * @Create 2024/3/26 上午 12:11
 * @Version 1.0
 */

//singleton 單例模式_餓漢式 (立即隨類加載，線程安全)
public class Singleton {

    private static Singleton singleton = new Singleton();
    private Singleton() {
    }

    public static Singleton getSingleton(){
        return singleton;
    }

}


//singleton 單例模式_懶漢式 (延遲加載，需要時才創建，但線程不安全)
class Singleton2{
    private static Singleton2 singleton = null;

    private Singleton2(){
    }

    public static Singleton2 getSingleton(){
        if (singleton == null){
            singleton = new Singleton2();
        }
        return singleton;
    }
}

