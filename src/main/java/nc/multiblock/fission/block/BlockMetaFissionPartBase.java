package nc.multiblock.fission.block;

import nc.enumm.IBlockMetaEnum;
import nc.multiblock.MultiblockBlockMetaPartBase;
import nc.tab.NCTabs;
import nc.util.BlockHelper;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockMetaFissionPartBase<T extends Enum<T> & IStringSerializable & IBlockMetaEnum> extends MultiblockBlockMetaPartBase<T> {
	
	public BlockMetaFissionPartBase(Class<T> enumm, PropertyEnum<T> property) {
		super(enumm, property, Material.IRON, NCTabs.MULTIBLOCK);
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return BlockHelper.REDUCED_BLOCK_AABB;
	}
	
	@Override
	public void onEntityCollision(World world, BlockPos pos, IBlockState state, Entity entity) {
		BlockFissionPartBase.onEntityCollisionWithFissionReactor(world, pos, entity);
	}
}
