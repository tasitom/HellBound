package main.GeckolibRelated;

import main.Main;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PedestalItemGeoModel extends GeoModel<GeoBlockItem> {
    @Override
    public ResourceLocation getModelResource(GeoBlockItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(Main.MODID,"geo/block/pedestal.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeoBlockItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(Main.MODID,"textures/entity/pedestal.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeoBlockItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(Main.MODID,"animations/pedestal.json");
    }
}
