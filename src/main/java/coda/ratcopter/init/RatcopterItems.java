package coda.ratcopter.init;

import coda.ratcopter.Ratcopter;
import coda.ratcopter.entities.RatcopterEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RatcopterItems {
    /*
    Official executive comment: "LOL";
     */
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ratcopter.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Ratcopter.MOD_ID);

    public static final RegistryObject<EntityType<RatcopterEntity>> RATCOPTER_2 = create("ratcopter", EntityType.Builder.of(RatcopterEntity::new, EntityClassification.CREATURE).sized(0.8f, 0.8f));
    public static final RegistryObject<Item> RATCOPTER = ITEMS.register("ratcopter", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION).stacksTo(1)));

    private static <T extends Entity> RegistryObject<EntityType<T>> create(String name, EntityType.Builder<T> builder) {
        return ENTITIES.register(name, () -> builder.build(Ratcopter.MOD_ID + "." + name));
    }
}
