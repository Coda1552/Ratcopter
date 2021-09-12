package coda.ratcopter.client.renderer;

import coda.ratcopter.Ratcopter;
import coda.ratcopter.client.model.RatcopterModel;
import coda.ratcopter.entities.RatcopterEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RatcopterRenderer extends MobRenderer<RatcopterEntity, RatcopterModel<RatcopterEntity>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(Ratcopter.MOD_ID, "textures/entity/ratcopter.png");

    public RatcopterRenderer(EntityRendererManager manager) {
        super(manager, new RatcopterModel<>(), 2.0f);
    }

    @Override
    public ResourceLocation getTextureLocation(RatcopterEntity entity) {
        return TEXTURE;
    }
}
