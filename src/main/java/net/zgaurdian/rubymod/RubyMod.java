package net.zgaurdian.rubymod;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.zgaurdian.rubymod.util.RegistryHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@Mod("rubymod")
public class RubyMod {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "rubymod";
    public IEventBus eventBus;

    public RubyMod() {
        eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setup);
        eventBus.addListener(this::doClientStuff);

        // Registering
        RegistryHandler.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {   }

    private void doClientStuff(final FMLClientSetupEvent event) {   }

    public static final ItemGroup MOD_TAB = new ItemGroup("rubyTab") {
        @Override
        public @NotNull ItemStack createIcon() {
            return new ItemStack(RegistryHandler.RUBY.get());
        }
    };
}
