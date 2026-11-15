package itemsadder.m;

import org.bukkit.Bukkit;
import org.bukkit.Instrument;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.MultipleFacing;
import org.bukkit.block.data.type.Fire;
import org.bukkit.block.data.type.NoteBlock;

public class BlockDataNoteBlockHolder {
    public static final BlockData AA;
    public static final BlockData AB;
    public static final BlockData AC;
    public static final BlockData AD;
    public static final NoteBlock AE;
    public static final BlockData AF;
    public static final BlockData AG;
    public static final BlockData AH;

    private static BlockData e(Material material) {
        switch (material) {
            case NOTE_BLOCK: {
                NoteBlock noteBlock = (NoteBlock)Bukkit.createBlockData((Material)material);
                noteBlock.setNote(new Note(0));
                noteBlock.setPowered(false);
                noteBlock.setInstrument(Instrument.PIANO);
                return noteBlock;
            }
            case MUSHROOM_STEM: 
            case BROWN_MUSHROOM_BLOCK: 
            case RED_MUSHROOM_BLOCK: 
            case CHORUS_PLANT: {
                BlockData blockData = Bukkit.createBlockData((Material)material);
                MultipleFacing multipleFacing = (MultipleFacing)blockData;
                multipleFacing.setFace(BlockFace.NORTH, true);
                multipleFacing.setFace(BlockFace.SOUTH, true);
                multipleFacing.setFace(BlockFace.EAST, true);
                multipleFacing.setFace(BlockFace.WEST, true);
                multipleFacing.setFace(BlockFace.DOWN, true);
                multipleFacing.setFace(BlockFace.UP, true);
                return multipleFacing;
            }
            case FIRE: {
                Fire fire = (Fire)Bukkit.createBlockData((Material)material);
                fire.setAge(0);
                return fire;
            }
            case TRIPWIRE: {
                return Bukkit.createBlockData((Material)material);
            }
        }
        return Bukkit.createBlockData((Material)material);
    }

    public static BlockData f(Material material) {
        switch (material) {
            case BROWN_MUSHROOM_BLOCK: {
                return AA;
            }
            case RED_MUSHROOM_BLOCK: {
                return AB;
            }
            case MUSHROOM_STEM: {
                return AC;
            }
            case CHORUS_PLANT: {
                return AD;
            }
            case NOTE_BLOCK: {
                return AE;
            }
            case FIRE: {
                return AF;
            }
            case TRIPWIRE: {
                return AG;
            }
        }
        return null;
    }

    static {
        AD = BlockDataNoteBlockHolder.e(Material.CHORUS_PLANT);
        AC = BlockDataNoteBlockHolder.e(Material.MUSHROOM_STEM);
        AB = BlockDataNoteBlockHolder.e(Material.RED_MUSHROOM_BLOCK);
        AA = BlockDataNoteBlockHolder.e(Material.BROWN_MUSHROOM_BLOCK);
        AE = (NoteBlock)BlockDataNoteBlockHolder.e(Material.NOTE_BLOCK);
        AF = BlockDataNoteBlockHolder.e(Material.FIRE);
        AG = BlockDataNoteBlockHolder.e(Material.TRIPWIRE);
        AH = Bukkit.createBlockData((Material)Material.AIR);
    }
}
