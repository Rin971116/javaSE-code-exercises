package com.selfdefine;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/5/24 下午 05:20
 * @Version 1.0
 */
public class SubOrder5<E> extends Order<Integer>{ //指名父類的泛型，額外新增當前類的新泛型，從父類那繼承來的屬性、方法等，有使用泛型的都套用Integer
    E field;

    public SubOrder5(Integer field, String name, E field1) {
        super(field, name);
        this.field = field1;
    }

    public SubOrder5(E field) {
        this.field = field;
    }

    public E getField() {
        return field;
    }

    public void setField(E field) {
        this.field = field;
    }
}
