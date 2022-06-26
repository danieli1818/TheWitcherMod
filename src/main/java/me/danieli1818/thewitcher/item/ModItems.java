package me.danieli1818.thewitcher.item;

import com.google.common.base.Supplier;

import me.danieli1818.thewitcher.TheWitcher;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {

	private ModItems() {
		
	}
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
	
	public static RegistryObject<Item> registerItem(String name, Supplier<? extends Item> itemSupplier) {
		return ITEMS.register(name, itemSupplier);
	}
	
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS
			, TheWitcher.MOD_ID);
	
	public static final RegistryObject<Item> RUBY = registerItem("ruby", PreciousStone::new);
	
	public static final RegistryObject<Item> RAW_RUBY = registerItem("raw_ruby", PreciousStone::new);
	
	public static final RegistryObject<Item> CITRINE = registerItem("citrine", PreciousStone::new);
	
	public static final RegistryObject<Item> RAW_CITRINE = registerItem("raw_citrine", PreciousStone::new);

	
}
