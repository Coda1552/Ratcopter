package coda.ratcopter.init;

import coda.ratcopter.Ratcopter;
import coda.ratcopter.entities.RatcopterEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RatcopterEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Ratcopter.MOD_ID);

    public static final RegistryObject<EntityType<RatcopterEntity>> RATCOPTER = create("ratcopter", EntityType.Builder.of(RatcopterEntity::new, EntityClassification.CREATURE).sized(1.8f, 1.8f));

    private static <T extends Entity> RegistryObject<EntityType<T>> create(String name, EntityType.Builder<T> builder) {
        return ENTITIES.register(name, () -> builder.build(Ratcopter.MOD_ID + "." + name));
    }
}
