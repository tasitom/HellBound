package main.Screens;

import com.mojang.math.Axis;
import main.Main;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.awt.*;
import java.util.List;

public class RuinedPageScreen extends Screen {
    private static final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(Main.MODID,"textures/gui/ruined_page.png");
    private static final ResourceLocation first_ring = ResourceLocation.fromNamespaceAndPath(Main.MODID,"textures/gui/box1.png");
    private static final ResourceLocation inside_ring = ResourceLocation.fromNamespaceAndPath(Main.MODID,"textures/gui/inside_ring.png");
    private static final ResourceLocation circle = ResourceLocation.fromNamespaceAndPath(Main.MODID,"textures/gui/circle.png");
    private static final WidgetSprites Gluttony_image = new WidgetSprites(
            ResourceLocation.fromNamespaceAndPath(Main.MODID, "button_neutral"),
            ResourceLocation.fromNamespaceAndPath(Main.MODID, "button_clicked"),
            ResourceLocation.fromNamespaceAndPath(Main.MODID, "button_hovered"),
            ResourceLocation.fromNamespaceAndPath(Main.MODID, "button_clicked")
            );
    private ModButtons Envy_button;
    private ModButtons Greed_button;
    private ModButtons Wrath_button;
    private ModButtons Gluttony_button;
    private ModButtons Pride_button;
    private ModButtons Sloth_button;
    private ModButtons Lust_button;
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
        int btnSize = 15;
        Greed_button = new ModButtons(panelX, panelY+40, btnSize, btnSize, Gluttony_image,
                button -> System.out.println("Image Button Clicked!"),"Greed", ChatFormatting.YELLOW.getColor());
        Wrath_button = new ModButtons(panelX-39, panelY+20, btnSize, btnSize, Gluttony_image,
                button -> System.out.println("Image Button Clicked!"),"Wrath",ChatFormatting.BLUE.getColor());
        Gluttony_button = new ModButtons(panelX+40, panelY+20, btnSize, btnSize, Gluttony_image,
                button -> System.out.println("Image Button Clicked!"),"Gluttony",ChatFormatting.RED.getColor());
        Sloth_button = new ModButtons(panelX+39, panelY-20, btnSize, btnSize, Gluttony_image,
                button -> System.out.println("Image Button Clicked!"),"Sloth",ChatFormatting.AQUA.getColor());
        Pride_button = new ModButtons(panelX, panelY, btnSize, btnSize, Gluttony_image,
                button -> System.out.println("Image Button Clicked!"),"Pride",ChatFormatting.GRAY.getColor());
        Lust_button = new ModButtons(panelX-40, panelY-20, btnSize, btnSize, Gluttony_image,
                button -> System.out.println("Image Button Clicked!"),"Lust",ChatFormatting.LIGHT_PURPLE.getColor());
        Envy_button = new ModButtons(panelX, panelY-40, btnSize, btnSize, Gluttony_image,
                button -> System.out.println("Image Button Clicked!"),"Envy",ChatFormatting.GREEN.getColor());
        buttonList.add(Greed_button);
        buttonList.add(Wrath_button);
        buttonList.add(Gluttony_button);
        buttonList.add(Sloth_button);
        buttonList.add(Lust_button);
        buttonList.add(Envy_button);
        buttonList.add(Pride_button);
        for (ModButtons button : buttonList){
            this.addRenderableWidget(button);
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
                        Pride_button.getX()+6,
                        Pride_button.getY() -  100,
                        button.Get_Color()
                );
            }
        }
    }
    @Override
    public void renderBackground(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
    }

}
