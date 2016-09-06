package com.rwtema.denserores;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashMap;
import java.util.Map;

public class DenseOresRegistry {

    public static Map<Integer, BlockDenseOre> blocks = new HashMap<Integer, BlockDenseOre>();

    public static Map<Integer, DenseOre> ores = new HashMap<Integer, DenseOre>();

    // add vanilla entries (TODO: add a way to disable vanilla ores)
    public static void initExampleOres() {
        registerOre(0, "minecraft:bedrock", 0, 0, "stone", "bedrock", 0,  0);
        //because vanilla ores were actually being registered here first, and not in the config, this data was fixed 
        //so things were being ignored even if you changed them in the config - like probability
        //hence why I replaced this with a "dense bedrock" entry, which also provides the config example now
    }

    public static String blockPrefix = DenseOresMod.MODID;

    // create the blocks needed
    public static void buildBlocks() {
        for (DenseOre ore : ores.values()) {
            int bId = ore.id / 16;
            BlockDenseOre newBlock = blocks.get(bId);

            if (newBlock == null) {
                newBlock = (BlockDenseOre) ((new BlockDenseOre()).setBlockName(blockPrefix + ":block" + bId).setHardness(3));
                blocks.put(bId, newBlock);
                GameRegistry.registerBlock(newBlock, ItemBlockDenseOre.class, "block" + bId);
            }

            newBlock.setEntry(ore.id % 16, ore);
            ore.setBlock(newBlock);
        }
    }

    public static DenseOre registerOre(int id, String baseBlock, int metadata, int prob, String underlyingBlock, String texture, int retroGenId,  int renderType) {

        if ("".equals(baseBlock) || "minecraft:air".equals(baseBlock))
            return null;


        int ind = baseBlock.indexOf(58);

        if (ind > 1) {
            String modname = baseBlock.substring(0, ind);
            if (!"minecraft".equals(modname) && !Loader.isModLoaded(modname))
                return null;
        } else {
            throw new RuntimeException("Block " + id + " is not formatted correctly. Must be in the form mod:block");
        }

        final DenseOre ore = new DenseOre(id, baseBlock, metadata, prob, underlyingBlock, texture, retroGenId, renderType);
        ores.put(id, ore);
        return ore;
    }

    public static boolean hasEntry(int id) {
        return ores.containsKey(id);
    }

    //Look for valid ore dictionary references and add new ones
    public static void buildOreDictionary() {
        for (DenseOre ore : ores.values()) {
            int bId = ore.id / 16;
            int meta = ore.id % 16;
            if (blocks.get(bId).isValid(meta)) {
                Block b = blocks.get(bId).getBlock(meta);
                for (int oreid : OreDictionary.getOreIDs(new ItemStack(b, 1, ore.metadata))) {
                    String k = OreDictionary.getOreName(oreid);
                    if (k.startsWith("ore")) {
                        ore.baseOreDictionary = k;
                        k = "dense" + k;
                        ore.oreDictionary = k;
                        OreDictionary.registerOre(k, new ItemStack(blocks.get(bId), 1, meta));
                    }
                }
            }
        }
    }
}