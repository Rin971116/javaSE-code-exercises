package com.selfdefine;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/5/24 下午 05:06
 * @Version 1.0
 */
public class SubOrder3<T,E> extends Order<T>{
    E field;

    public SubOrder3(T field, String name, E field1) {
        super(field, name);
        this.field = field1;
    }

    public SubOrder3(E field) {
        this.field = field;
    }

    public E getField() {
        return field;
    }

    public void setField(E field) {
        this.field = field;
    }
}
