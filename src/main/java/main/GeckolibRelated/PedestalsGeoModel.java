package main.GeckolibRelated;

import main.Entities.PedestalEntity;
import main.Main;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PedestalsGeoModel extends GeoModel<PedestalEntity> {
    @Override
    public ResourceLocation getModelResource(PedestalEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(Main.MODID,"geo/block/pedestal.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PedestalEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(Main.MODID,"textures/entity/pedestal.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PedestalEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(Main.MODID,"animations/pedestal.json");
    }
}
