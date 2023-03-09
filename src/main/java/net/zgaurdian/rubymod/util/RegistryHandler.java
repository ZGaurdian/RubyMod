package net.zgaurdian.rubymod.util;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.zgaurdian.rubymod.RubyMod;
import net.zgaurdian.rubymod.blocks.NetherRubyOre;
import net.zgaurdian.rubymod.blocks.RubyBlock;
import net.zgaurdian.rubymod.blocks.RubyOre;
import net.zgaurdian.rubymod.items.NetherRubyOreItem;
import net.zgaurdian.rubymod.items.Ruby;
import net.zgaurdian.rubymod.items.RubyBlockItem;
import net.zgaurdian.rubymod.items.RubyOreItem;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RubyMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RubyMod.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, RubyMod.MOD_ID);

    // Items
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", Ruby::new);

    // Blocks
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);
    public static final RegistryObject<OreBlock> RUBY_ORE = BLOCKS.register("ruby_ore", RubyOre::new);
    public static final RegistryObject<Block> NETHER_RUBY_ORE = BLOCKS.register("nether_ruby_ore", NetherRubyOre::new);

    // Block Items
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", () -> new RubyBlockItem(RUBY_BLOCK.get()));
    public static final RegistryObject<Item> RUBY_ORE_ITEM = ITEMS.register("ruby_ore", () -> new RubyOreItem(RUBY_ORE.get()));
    public static final RegistryObject<Item> NETHER_RUBY_ORE_ITEM = ITEMS.register("nether_ruby_ore", () -> new NetherRubyOreItem(NETHER_RUBY_ORE.get()));

    // Tools
    public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register(
            "ruby_sword", () -> new SwordItem(ModToolTier.RUBY, 9, -2.4F, new Item.Properties().group(RubyMod.MOD_TAB).isImmuneToFire()));

    public static final RegistryObject<PickaxeItem> RUBY_PICKAXE = ITEMS.register(
            "ruby_pickaxe", () -> new PickaxeItem(ModToolTier.RUBY, 6, -2.6F, new Item.Properties().group(RubyMod.MOD_TAB).isImmuneToFire()));

    public static final RegistryObject<AxeItem> RUBY_AXE = ITEMS.register(
            "ruby_axe", () -> new AxeItem(ModToolTier.RUBY, 11, -2.6F, new Item.Properties().group(RubyMod.MOD_TAB).isImmuneToFire()));

    public static final RegistryObject<HoeItem> RUBY_HOE = ITEMS.register(
            "ruby_hoe", () -> new HoeItem(ModToolTier.RUBY, 6, -3.0F, new Item.Properties().group(RubyMod.MOD_TAB).isImmuneToFire()));

    public static final RegistryObject<ShovelItem> RUBY_SHOVEL = ITEMS.register(
            "ruby_shovel", () -> new ShovelItem(ModToolTier.RUBY, 6, -2.6F, new Item.Properties().group(RubyMod.MOD_TAB).isImmuneToFire()));

    // Armor
    public static final RegistryObject<ArmorItem> RUBY_HELMET = ITEMS.register(
            "ruby_helmet", () -> new ArmorItem(ModArmourMaterial.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(RubyMod.MOD_TAB).isImmuneToFire()));

    public static final RegistryObject<ArmorItem> RUBY_CHESTPLATE = ITEMS.register(
            "ruby_chestplate", () -> new ArmorItem(ModArmourMaterial.RUBY, EquipmentSlotType.CHEST, new Item.Properties().group(RubyMod.MOD_TAB).isImmuneToFire()));

    public static final RegistryObject<ArmorItem> RUBY_LEGGINGS = ITEMS.register(
            "ruby_leggings", () -> new ArmorItem(ModArmourMaterial.RUBY, EquipmentSlotType.LEGS, new Item.Properties().group(RubyMod.MOD_TAB).isImmuneToFire()));

    public static final RegistryObject<ArmorItem> RUBY_BOOTS = ITEMS.register(
            "ruby_boots", () -> new ArmorItem(ModArmourMaterial.RUBY, EquipmentSlotType.FEET, new Item.Properties().group(RubyMod.MOD_TAB).isImmuneToFire()));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
        BLOCKS.register(bus);
        ENTITIES.register(bus);
    }
}