package nc.block.tile.dummy;

import nc.block.tile.BlockSimpleSidedTile;
import nc.enumm.BlockEnums.SimpleTileType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSimpleSidedDummy extends BlockSimpleSidedTile {
	
	public BlockSimpleSidedDummy(SimpleTileType type) {
		super(type);
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		if (worldIn.getTileEntity(pos) != null) {
			worldIn.removeTileEntity(pos);
		}
	}
}
