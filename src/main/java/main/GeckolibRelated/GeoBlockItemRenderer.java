package main.GeckolibRelated;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class GeoBlockItemRenderer extends GeoItemRenderer<GeoBlockItem> {
    public GeoBlockItemRenderer() {
        super(new PedestalItemGeoModel());
    }
}
