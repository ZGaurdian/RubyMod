package net.zgaurdian.rubymod.world.gen;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.zgaurdian.rubymod.RubyMod;
import net.zgaurdian.rubymod.util.RegistryHandler;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = RubyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModOreGen {

    @SubscribeEvent
    public static void genOres(FMLLoadCompleteEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {
            Biome.Category biomeCategory = biome.getCategory();

            // Nether Gen
            if (biomeCategory.equals(Biome.Category.NETHER)) {
                genOre(biome, 4, 9, 5, 24, OreFeatureConfig.FillerBlockType.NETHERRACK, RegistryHandler.NETHER_RUBY_ORE.get().getDefaultState(), 6);
            }

            // End Gen
            else if (biome.getCategory().equals(Biome.Category.THEEND)) {
                return;
            }

            // Overworld Gen
            else {
                genOre(biome, 2, 9, 5, 12, OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.RUBY_ORE.get().getDefaultState(), 6);
            }
        }
    }
    private static void genOre(@NotNull Biome biome, int count, int bottomOffset, int topOffset, int max, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockstate, int size) {
        CountRangeConfig range = new CountRangeConfig(count, bottomOffset, topOffset, max);
        OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockstate, size);
        ConfiguredPlacement<CountRangeConfig> config = Placement.field_215028_n.configure(range);
        biome.func_203611_a(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));
    }
}
