package main.Screens;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.resources.ResourceLocation;

public class ModButtons extends ImageButton {
    private static final float HOVER_SCALE = 1.15f;
    // the sigil art is drawn on a 32x32 canvas, but each glyph sits at a different size and
    // offset inside it, so the button fits the glyph itself into the ring's node circle
    private static final int SIGIL_CANVAS = 32;
    private static final float GLYPH_WIDTH = 13f;
    private static final float GLYPH_HEIGHT = 15f;
    private String type;
    private int color;
    private int btnSize;
    private final float glyphScale;
    private final float glyphCenterX;
    private final float glyphCenterY;
    public ModButtons(int x, int y, int width, int height, WidgetSprites sprites, OnPress onPress,String type,int color,int[] glyphBounds) {
        super(x, y, width, height, sprites, onPress);
        this.type = type;
        this.color= color;
        this.btnSize=width;
        this.setX(x+200/2-btnSize/2);
        this.setY(y+300/2 - btnSize/2);
        float glyphW = glyphBounds[2] - glyphBounds[0] + 1;
        float glyphH = glyphBounds[3] - glyphBounds[1] + 1;
        this.glyphScale = Math.min(GLYPH_WIDTH / glyphW, GLYPH_HEIGHT / glyphH);
        this.glyphCenterX = (glyphBounds[0] + glyphBounds[2] + 1) / 2f;
        this.glyphCenterY = (glyphBounds[1] + glyphBounds[3] + 1) / 2f;
    }
    public String Get_Type(){
        return this.type;
    }
    public int Get_Color(){
        return this.color;
    }

    @Override
    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        ResourceLocation sprite = this.sprites.get(this.isActive(), this.isHoveredOrFocused());
        // the sigil has no dedicated hover sprite, so grow it slightly instead
        float scale = this.glyphScale * (this.isHoveredOrFocused() ? HOVER_SCALE : 1f);
        float centerX = this.getX() + this.width / 2f;
        float centerY = this.getY() + this.height / 2f;
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(centerX - this.glyphCenterX * scale, centerY - this.glyphCenterY * scale, 0);
        guiGraphics.pose().scale(scale, scale, 1f);
        guiGraphics.blitSprite(sprite, 0, 0, SIGIL_CANVAS, SIGIL_CANVAS);
        guiGraphics.pose().popPose();
    }
}
