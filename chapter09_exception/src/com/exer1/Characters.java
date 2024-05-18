package com.exer1;

import java.util.Objects;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/15 下午 06:25
 * @Version 1.0
 */
public class Characters {

    private String name;
    private int lifeValue;
    private static int CharactersAmount;

    public Characters(){};

    public Characters(String name, int lifeValue) {
        this.name = name;
        setLifeValue(lifeValue);
//        this.lifeValue = lifeValue; 注意!!這邊不能這樣賦值，如果這樣賦值的話就不會經過setLifeValue()的判斷。
        CharactersAmount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifeValue() {
        return lifeValue;
    }

    public void setLifeValue(int lifeValue) {
        if (lifeValue <= 0) {
            throw new NoLifeValueException("血量小於等於0");
        }else {
            this.lifeValue = lifeValue;
        }
    }

    @Override
    public String toString() {
        return "Characters" + CharactersAmount + " {" +
                "name='" + name + '\'' +
                ", lifeValue=" + lifeValue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Characters that = (Characters) o;
        return lifeValue == that.lifeValue && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lifeValue);
    }
}
