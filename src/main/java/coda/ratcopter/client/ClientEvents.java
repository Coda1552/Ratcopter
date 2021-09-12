package coda.ratcopter.client;

import coda.ratcopter.client.renderer.RatcopterRenderer;
import coda.ratcopter.init.RatcopterEntities;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientEvents {

    public static void clientSetup() {
        RenderingRegistry.registerEntityRenderingHandler(RatcopterEntities.RATCOPTER.get(), RatcopterRenderer::new);

        RatcopterKeyBindings.LIST.forEach(ClientRegistry::registerKeyBinding);
    }
}
