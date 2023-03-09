package net.zgaurdian.rubymod.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.zgaurdian.rubymod.RubyMod;

public class NetherRubyOreItem extends BlockItem {
    public NetherRubyOreItem(Block block) {
        super(block, new Item.Properties().group(RubyMod.MOD_TAB));
    }
}
