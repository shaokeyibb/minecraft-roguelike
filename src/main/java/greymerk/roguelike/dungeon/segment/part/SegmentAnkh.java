package greymerk.roguelike.dungeon.segment.part;

import java.util.Random;

import greymerk.roguelike.dungeon.IDungeonLevel;
import greymerk.roguelike.theme.ITheme;
import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IStair;
import greymerk.roguelike.worldgen.MetaBlock;
import greymerk.roguelike.worldgen.WorldEditor;
import greymerk.roguelike.worldgen.blocks.ColorBlock;
import greymerk.roguelike.worldgen.blocks.DyeColor;
import net.minecraft.init.Blocks;

public class SegmentAnkh extends SegmentBase{

	@Override
	protected void genWall(WorldEditor editor, Random rand, IDungeonLevel level, Cardinal dir, ITheme theme, int x, int y, int z) {
		Coord start;
		Coord end;
		Coord cursor;
		
		MetaBlock air = new MetaBlock(Blocks.air);
		IStair stair = theme.getSecondaryStair();
		MetaBlock glass = ColorBlock.get(ColorBlock.GLASS, rand);
		MetaBlock white = ColorBlock.get(ColorBlock.GLASS, DyeColor.WHITE);
		MetaBlock glowstone = new MetaBlock(Blocks.glowstone);
		
		Cardinal[] orth = Cardinal.getOrthogonal(dir);
		
		start = new Coord(x, y, z);
		start.add(dir, 2);
		end = new Coord(start);
		end.add(Cardinal.UP, 2);
		
		editor.fillRectSolid(rand, start, end, air, true, true);
		
		
		for(Cardinal o : orth){
			
			cursor = new Coord(x, y, z);
			cursor.add(dir, 2);
			cursor.add(o);
			stair.setOrientation(Cardinal.reverse(o), false).setBlock(editor, cursor);
			cursor.add(Cardinal.UP);
			stair.setOrientation(Cardinal.reverse(o), false).setBlock(editor, cursor);
			cursor.add(Cardinal.UP);
			stair.setOrientation(Cardinal.reverse(o), true).setBlock(editor, cursor);
		}
		
		start = new Coord(x, y, z);
		start.add(dir, 3);
		end = new Coord(start);
		start.add(orth[0]);
		end.add(orth[1]);
		end.add(Cardinal.UP, 2);
		editor.fillRectSolid(rand, start, end, glass, true, true);
		start.add(dir);
		end.add(dir);
		editor.fillRectSolid(rand, start, end, white, true, true);
		
		cursor = new Coord(x, y, z);
		cursor.add(dir, 3);
		cursor.add(Cardinal.DOWN);
		glowstone.setBlock(editor, cursor);
		cursor.add(Cardinal.UP, 4);
		glowstone.setBlock(editor, cursor);
	}

}