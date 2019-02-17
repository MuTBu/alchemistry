package al132.alchemistry.blocks

import al132.alchemistry.items.ItemBlockChemicalCombiner
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.Entity
import net.minecraft.item.Item
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.EnumBlockRenderType
import net.minecraft.util.math.AxisAlignedBB
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import net.minecraft.world.World
import net.minecraftforge.event.RegistryEvent

/**
 * Created by al132 on 6/22/2017.
 */


class ChemicalCombinerBlock(name: String,
                            tileClass: Class<out TileEntity>,
                            guiID: Int)
    : BaseTileBlock(name, tileClass, guiID) {

    val boundingBox = AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.875, 1.0)

    override fun registerItemBlock(event: RegistryEvent.Register<Item>){
        event.registry.register(ItemBlockChemicalCombiner(ModBlocks.chemical_combiner).setRegistryName(this.registryName))
    }

    override fun getRenderType(state: IBlockState): EnumBlockRenderType = EnumBlockRenderType.MODEL

    override fun isOpaqueCube(state: IBlockState) = false

    override fun isFullCube(state: IBlockState?): Boolean = false

    override fun getBoundingBox(state: IBlockState, source: IBlockAccess, pos: BlockPos): AxisAlignedBB = boundingBox

    override fun addCollisionBoxToList(state: IBlockState,
                                       worldIn: World,
                                       pos: BlockPos,
                                       entityBox: AxisAlignedBB,
                                       collidingBoxes: List<AxisAlignedBB>,
                                       entityIn: Entity?, mysteryboolean: Boolean) {

        addCollisionBoxToList(pos, entityBox, collidingBoxes, boundingBox)
    }
}