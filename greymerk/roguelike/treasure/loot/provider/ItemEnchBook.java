package greymerk.roguelike.treasure.loot.provider;

import greymerk.roguelike.treasure.loot.Loot;

import java.util.Random;

import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class ItemEnchBook extends ItemBase{

	public ItemEnchBook(int weight, int level) {
		super(weight, level);
	}

	@Override
	public ItemStack getLootItem(Random rand, int level) {
		ItemStack book = new ItemStack(Item.book);
		Loot.enchantItem(book, rand, Loot.getEnchantLevel(rand, level));
		return book;
	}

}
