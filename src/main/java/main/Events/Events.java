package main.Events;

import main.Entities.ModEntities;
import main.GeckolibRelated.GeoBlockItemRenderer;
import main.Main;
import main.Renderers.PedestalRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

@Mod(value = Main.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = Main.MODID, bus = EventBusSubscriber.Bus.GAME)
public class Events {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModEntities.PEDESTAL_BLOCK.get(), context -> new PedestalRenderer( Minecraft.getInstance().getItemRenderer()));
    }
}
