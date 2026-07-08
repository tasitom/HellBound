package main.Screens;

import main.Main;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class RuinedPageScreen extends Screen {
    public static ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(Main.MODID,"textures/gui/ruined_page.png");
    public RuinedPageScreen(Component title) {
        super(title);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
    }

    @Override
    public void renderBackground(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        guiGraphics.blit(texture,(width/2)-100,20,0,0,0,200,300,200,300);
    }

}
