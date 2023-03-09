package net.zgaurdian.rubymod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class RubyBlock extends Block {
    public RubyBlock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(6.0F, 6.5F)
                .sound(SoundType.METAL)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool()
        );
    }
}
