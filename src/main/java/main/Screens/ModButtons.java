package main.Screens;

import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.WidgetSprites;

public class ModButtons extends ImageButton {
    private String type;
    private int color;
    private int btnSize;
    public ModButtons(int x, int y, int width, int height, WidgetSprites sprites, OnPress onPress,String type,int color) {
        super(x, y, width, height, sprites, onPress);
        this.type = type;
        this.color= color;
        this.btnSize=width;
        this.setX(x+200/2-btnSize/2);
        this.setY(y+300/2 - btnSize/2);
    }
    public String Get_Type(){
        return this.type;
    }
    public int Get_Color(){
        return this.color;
    }
}
