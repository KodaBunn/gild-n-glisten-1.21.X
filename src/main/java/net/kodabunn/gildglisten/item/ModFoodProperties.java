package net.kodabunn.gildglisten.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties GLISTEN = new FoodProperties.Builder()
            .nutrition(3).saturationModifier(0f).alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1),1f).build();
}
