package net.zgaurdian.rubymod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;
import org.jetbrains.annotations.NotNull;

public class NetherRubyOre extends OreBlock {
    public NetherRubyOre() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(3.0F, 4.0F)
                .sound(SoundType.NETHERITE)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool()
        );
    }
    @Override
    public int getExpDrop(@NotNull BlockState state, @NotNull IWorldReader reader, @NotNull BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? 20 : 5;
    }
}
