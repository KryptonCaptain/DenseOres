package com.rwtema.denserores.modintegration;

import com.rwtema.denserores.DenseOre;
import net.minecraft.item.ItemStack;

public interface ModInterface {
    public void registerOre(DenseOre ore, ItemStack denseOre, ItemStack originalOre);
}
