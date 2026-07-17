package main.Screens;

import com.mojang.math.Axis;
import main.Main;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RuinedPageScreen extends Screen {
    private static final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(Main.MODID,"textures/gui/ruined_page.png");
    private static final ResourceLocation first_ring = ResourceLocation.fromNamespaceAndPath(Main.MODID,"textures/gui/box1.png");
    private static final ResourceLocation inside_ring = ResourceLocation.fromNamespaceAndPath(Main.MODID,"textures/gui/inside_ring.png");
    private static final ResourceLocation circle = ResourceLocation.fromNamespaceAndPath(Main.MODID,"textures/gui/circle.png");
    private static final int btnSize = 15;
    private record SinDef(String name, int dx, int dy, int color) {}
    private final Map<String, ModButtons> sinButtons = new LinkedHashMap<>();
    public RuinedPageScreen(Component title) {
        super(title);
    }

    public List<ModButtons> buttonList = new java.util.ArrayList<>();
    @Override
    protected void init() {
        super.init();
        buttonList.clear();
        int panelX = (width / 2) - (200 / 2);
        int panelY = (height / 4) - 15;
        initSinButtons(panelX,panelY);
    }
    private WidgetSprites CreateWidget(String name){
        return new WidgetSprites(ResourceLocation.fromNamespaceAndPath(Main.MODID, name+"_neutral"),
                ResourceLocation.fromNamespaceAndPath(Main.MODID, name+"_clicked"),
                ResourceLocation.fromNamespaceAndPath(Main.MODID, name+"_hovered"),
                ResourceLocation.fromNamespaceAndPath(Main.MODID, name+"_clicked"));
    }
    private void initSinButtons(int panelX, int panelY) {
        List<SinDef> defs = List.of(
                new SinDef("Pride",0,0, ChatFormatting.GRAY.getColor()),
                new SinDef("Envy",0,-40, ChatFormatting.GREEN.getColor()),
                new SinDef("Sloth",39,-20, ChatFormatting.AQUA.getColor()),
                new SinDef("Gluttony",40,20, ChatFormatting.RED.getColor()),
                new SinDef("Greed",0,43, ChatFormatting.YELLOW.getColor()),
                new SinDef("Wrath",-39,20, ChatFormatting.BLUE.getColor()),
                new SinDef("Lust",-40,-20, ChatFormatting.LIGHT_PURPLE.getColor())
        );
        for (SinDef d : defs) {
            ModButtons btn = new ModButtons(
                    panelX + d.dx(), panelY + d.dy(), btnSize, btnSize,
                    CreateWidget("button"),
                    b ->System.out.println(d.name+" Button pressed"),d.name(), d.color());
            sinButtons.put(d.name(), btn);
            buttonList.add(btn);
        }
        for (ModButtons buttons : buttonList){
            addRenderableWidget(buttons);
        }
    }


    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        int x = (width/2) - 100;
        int y = (height/4) - 15;
        guiGraphics.blit(texture, x, 20, 0, 0, 0, 200, 300, 200, 300);
        guiGraphics.blit(inside_ring, x, y, 0, 0, 0, 200, 300, 200, 300);
        guiGraphics.blit(circle, x, y, 0, 0, 0, 200, 300, 200, 300);
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(x + 200/2f, y + 300/2f, 0);
        float rotationSpeed = 45f;
        float angle = (System.currentTimeMillis() % 360000L) / 1000f * rotationSpeed;
        guiGraphics.pose().mulPose(Axis.ZP.rotationDegrees(-angle));
        guiGraphics.pose().translate(-(200/2f), -(300/2f), 0);
        guiGraphics.blit(first_ring, 0, 0, 0, 0, 0, 200, 300, 200, 300);
        guiGraphics.pose().popPose();
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(x + 200/2f, y + 300/2f, 0);
        guiGraphics.pose().mulPose(Axis.ZP.rotationDegrees(angle+5));
        guiGraphics.pose().translate(-(200/2f), -(300/2f), 0);
        guiGraphics.blit(first_ring, 0, 0, 0, 0, 0, 200, 300, 200, 300);
        guiGraphics.pose().popPose();
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        for (ModButtons button : buttonList){
            if (button != null && button.isHovered()) {
                guiGraphics.drawCenteredString(
                        this.font,
                        Component.literal(button.Get_Type()),
                        sinButtons.get("Pride").getX()+6,
                        sinButtons.get("Pride").getY() -  100,
                        button.Get_Color()
                );
            }
        }
    }
    @Override
    public void renderBackground(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
    }

}
