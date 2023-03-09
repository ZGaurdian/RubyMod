package net.zgaurdian.rubymod.util;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.zgaurdian.rubymod.RubyMod;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum ModArmourMaterial implements IArmorMaterial {
    RUBY(RubyMod.MOD_ID + ":ruby", 40, new int[] { 4, 6, 8, 4 }, 12, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.5F, () -> {
        return Ingredient.fromItems(RegistryHandler.RUBY.get());
    }, 0.02F);

    private static final int[] MAX_DAMAGE_ARRAY = new int[] { 11, 16, 15, 13 };
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantibility;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;
    private final float kbResistance;

    ModArmourMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantibility, SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial, float kbResistance) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantibility = enchantibility;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
        this.kbResistance = kbResistance;
    }

    @Override
    public int getDurability(@NotNull EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(@NotNull EquipmentSlotType slotIn) {
        return damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return enchantibility;
    }

    @Override
    public @NotNull SoundEvent getSoundEvent() {
        return soundEvent;
    }

    @Override
    public @NotNull Ingredient getRepairMaterial() {
        return repairMaterial.get();
    }

    @Override
    public @NotNull String getName() {
        return name;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return kbResistance;
    }
}
