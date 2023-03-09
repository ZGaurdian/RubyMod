package net.zgaurdian.rubymod.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.zgaurdian.rubymod.RubyMod;

public class Ruby extends Item {
    public Ruby() {
        super(new Item.Properties().group(RubyMod.MOD_TAB).isImmuneToFire());
    }
}
