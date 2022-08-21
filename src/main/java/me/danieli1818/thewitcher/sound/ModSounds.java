package me.danieli1818.thewitcher.sound;

import me.danieli1818.thewitcher.TheWitcher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {

	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister
			.create(ForgeRegistries.SOUND_EVENTS, TheWitcher.MOD_ID);

	public static final RegistryObject<SoundEvent> DOWSING_ROD_FOUND_ORE = registerSoundEvent("dowsing_rod_found_ore");

	public static final RegistryObject<SoundEvent> CITRINE_LAMP_BREAK = registerSoundEvent("citrine_lamp_break");
	public static final RegistryObject<SoundEvent> CITRINE_LAMP_STEP = registerSoundEvent("citrine_lamp_step");
	public static final RegistryObject<SoundEvent> CITRINE_LAMP_PLACE = registerSoundEvent("citrine_lamp_place");
	public static final RegistryObject<SoundEvent> CITRINE_LAMP_HIT = registerSoundEvent("citrine_lamp_hit");
	public static final RegistryObject<SoundEvent> CITRINE_LAMP_FALL = registerSoundEvent("citrine_lamp_fall");

	public static final ForgeSoundType CITRINE_LAMP_SOUNDS = new ForgeSoundType(1.0F, 1.0F, CITRINE_LAMP_BREAK,
			CITRINE_LAMP_STEP, CITRINE_LAMP_PLACE, CITRINE_LAMP_HIT, CITRINE_LAMP_FALL);

	private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
		return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(TheWitcher.MOD_ID, name)));
	}

	public static void register(IEventBus eventBus) {
		SOUND_EVENTS.register(eventBus);
	}

}
