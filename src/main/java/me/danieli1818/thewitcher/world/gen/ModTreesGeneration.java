package me.danieli1818.thewitcher.world.gen;

import java.util.List;
import java.util.Set;

import me.danieli1818.thewitcher.world.placement.ModVegetationPlacements;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class ModTreesGeneration {

	public static void generateTrees(final BiomeLoadingEvent event) {

		ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
		Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

		if (types.contains(BiomeDictionary.Type.PLAINS)) {
			List<Holder<PlacedFeature>> base = event.getGeneration().getFeatures(Decoration.VEGETAL_DECORATION);
			base.add(ModVegetationPlacements.MOD_TREES_PLAINS);
		}

	}

}
