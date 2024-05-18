package com.enum_class.exer2;

/**
 * ClassName:
 * Description:
 *              聲明枚舉類 Color表示以RED,GREEN,BLUE (三原色各自 0-255色階)的全組合結果
 * @Author Rin
 * @Create 2024/4/6 下午 01:52
 * @Version 1.0
 */
public enum Color {

    RED(255,0,0,"紅色"),
    ORANGE(255,128,0,"橘色"),
    YELLOW(255,255,0,"黃色"),
    GREEN(0,255,0,"綠色"),
    BLUE(0,0,255,"藍色"),
    CYAN(0,255,255,"靛色"),
    PURPLE(128,0,255,"紫色");

    private final int red;
    private final int green;
    private final int blue;
    private final String description;

    private Color(int red, int green, int blue, String description) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.description = description;
    }

    public String toString(){
        return this.name() + "(" + this.red + "," +
                                   this.green + "," +
                                   this.blue + "," + ")->" +
                                   this.description;
    }
}
