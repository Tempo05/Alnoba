
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.alnoba.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class Alnoba1171ModTabs {
	public static CreativeModeTab TAB_ALNOBA;

	public static void load() {
		TAB_ALNOBA = new CreativeModeTab("tabalnoba") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Alnoba1171ModItems.ALNOBALOGO);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
