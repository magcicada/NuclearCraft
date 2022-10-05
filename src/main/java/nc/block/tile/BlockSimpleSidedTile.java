package nc.block.tile;

<<<<<<< HEAD
import nc.handler.TileInfoHandler;
=======
import nc.enumm.BlockEnums.SimpleTileType;
>>>>>>> parent of 007db45b (Undo revert of "Start of machine refactor")
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSimpleSidedTile extends BlockSidedTile implements ITileType {
	
	private final SimpleTileType type;
	
	public BlockSimpleSidedTile(SimpleTileType type) {
		super(Material.IRON);
<<<<<<< HEAD
		tileInfo = TileInfoHandler.getBlockSimpleTileInfo(name);
		setCreativeTab(tileInfo.getCreativeTab());
=======
		this.type = type;
		setCreativeTab(type.getCreativeTab());
>>>>>>> parent of 007db45b (Undo revert of "Start of machine refactor")
	}
	
	@Override
	public String getTileName() {
		return type.getName();
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return type.getTile();
	}
}
