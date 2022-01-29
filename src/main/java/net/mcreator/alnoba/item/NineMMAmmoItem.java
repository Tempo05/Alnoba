
package net.mcreator.alnoba.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.alnoba.init.Alnoba1171ModTabs;

public class NineMMAmmoItem extends Item {
	public NineMMAmmoItem() {
		super(new Item.Properties().tab(Alnoba1171ModTabs.TAB_ALNOBA).stacksTo(64).fireResistant().rarity(Rarity.COMMON));
		setRegistryName("nine_mm_ammo");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0.9F;
	}
}
