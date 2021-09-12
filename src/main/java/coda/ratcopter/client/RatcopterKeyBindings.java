package coda.ratcopter.client;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.List;

public class RatcopterKeyBindings {
    public static final List<KeyBinding> LIST = new ArrayList<>();
    public static final KeyBinding RATCOPTER_DESCEND = register("ratcopterDescend", 90);

    private static KeyBinding register(String name, int key) {
        KeyBinding keyBinding = new KeyBinding("key." + name, key, "key.categories.ratcopter");
        LIST.add(keyBinding);
        return keyBinding;
    }
}
