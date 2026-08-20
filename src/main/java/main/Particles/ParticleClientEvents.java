package main.Particles;

import main.Main;
import net.minecraft.client.particle.FlameParticle;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = Main.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ParticleClientEvents {

    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
        // Renders the custom candle flames using flame behavior + our own sprites.
        event.registerSpriteSet(CandleParticles.ENVY_FLAME.get(), FlameParticle.Provider::new);
        event.registerSpriteSet(CandleParticles.GLUTTONY_FLAME.get(), FlameParticle.Provider::new);
        event.registerSpriteSet(CandleParticles.GREED_FLAME.get(), FlameParticle.Provider::new);
        event.registerSpriteSet(CandleParticles.LUST_FLAME.get(), FlameParticle.Provider::new);
        event.registerSpriteSet(CandleParticles.PRIDE_FLAME.get(), FlameParticle.Provider::new);
        event.registerSpriteSet(CandleParticles.SLOTH_FLAME.get(), FlameParticle.Provider::new);
        event.registerSpriteSet(CandleParticles.WRATH_FLAME.get(), FlameParticle.Provider::new);
    }
}
