package greymerk.roguelike.treasure.loot.provider;

import java.util.Random;

import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class ItemEnchBonus extends ItemBase{

	public ItemEnchBonus(int weight, int level) {
		super(weight, level);
	}

	@Override
	public ItemStack getLootItem(Random rand, int level) {
		if(rand.nextBoolean()) return new ItemStack(Item.expBottle, 1 + rand.nextInt(5));
		return new ItemStack(Item.enderPearl, 1 + rand.nextInt(2));
	}

	
}
