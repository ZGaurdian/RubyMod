package net.zgaurdian.rubymod.util;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum ModToolTier implements IItemTier {

    RUBY(3001, 11, 0.0F, 4, 12, () -> {
        return Ingredient.fromItems(RegistryHandler.RUBY.get());
    });

    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int harvestLevel;
    private final int enchantibility;
    private final Supplier<Ingredient> repairMaterial;

    ModToolTier(int maxUses, float efficiency, float attackDamage, int harvestLevel, int enchantibility, Supplier<Ingredient> repairMaterial) {

        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.harvestLevel = harvestLevel;
        this.enchantibility = enchantibility;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantibility;
    }

    @Override
    public @NotNull Ingredient getRepairMaterial() {
        return repairMaterial.get();
    }
}
