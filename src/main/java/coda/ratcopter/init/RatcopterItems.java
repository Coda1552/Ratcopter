package coda.ratcopter.init;

import coda.ratcopter.Ratcopter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RatcopterItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ratcopter.MOD_ID);

    public static final RegistryObject<Item> RATCOPTER = ITEMS.register("ratcopter", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION).stacksTo(1)));
}
