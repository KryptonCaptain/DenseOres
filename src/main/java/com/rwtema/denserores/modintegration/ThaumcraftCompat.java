package com.rwtema.denserores.modintegration;

import com.rwtema.denserores.DenseOre;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Optional.Method;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

import java.util.Map;

public class ThaumcraftCompat implements ModInterface {

    @Method(modid = "Thaumcraft")
    private void registerOre_do(DenseOre ore, ItemStack denseOre, ItemStack originalOre) {
        AspectList aspectList = new AspectList(originalOre);
        if (aspectList.visSize() == 0)
            return;
        AspectList newList = new AspectList();
        for (Map.Entry<Aspect, Integer> entry : aspectList.aspects.entrySet()) {
            newList.add(entry.getKey(), (entry.getValue() * 5) >> 1);
        }

        ThaumcraftApi.registerObjectTag(denseOre.copy(), newList);
    }

    @Override
    public void registerOre(DenseOre ore, ItemStack denseOre, ItemStack originalOre) {
        if (Loader.isModLoaded("Thaumcraft"))
            registerOre_do(ore, denseOre, originalOre);
    }
}
