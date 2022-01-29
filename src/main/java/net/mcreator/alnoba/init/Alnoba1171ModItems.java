
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.alnoba.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.alnoba.item.NineMMAmmoItem;
import net.mcreator.alnoba.item.Glock18Item;
import net.mcreator.alnoba.item.AlnobalogoItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Alnoba1171ModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item ALNOBALOGO = register(new AlnobalogoItem());
	public static final Item IRONFURNACE = register(Alnoba1171ModBlocks.IRONFURNACE, Alnoba1171ModTabs.TAB_ALNOBA);
	public static final Item NINE_MM_AMMO = register(new NineMMAmmoItem());
	public static final Item GLOCK_18 = register(new Glock18Item());

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	private static Item register(Block block, CreativeModeTab tab) {
		return register(new BlockItem(block, new Item.Properties().tab(tab)).setRegistryName(block.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
