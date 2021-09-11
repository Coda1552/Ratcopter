package coda.ratcopter;

import coda.ratcopter.entities.RatcopterEntity;
import coda.ratcopter.init.RatcopterItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Ratcopter.MOD_ID)
public class Ratcopter {
	public static final String MOD_ID = "ratcopter";
	public static final Logger LOGGER = LogManager.getLogger();

	public Ratcopter() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		IEventBus forgeBus = MinecraftForge.EVENT_BUS;
		bus.addListener(Ratcopter::registerEntityAttributes);

		RatcopterItems.ITEMS.register(bus);
		RatcopterItems.ENTITIES.register(bus);
	}

	private static void registerEntityAttributes(EntityAttributeCreationEvent event) {
		event.put(RatcopterItems.RATCOPTER_2.get(), RatcopterEntity.createBaseHorseAttributes().build());
	}
}
