package me.ebonjaeger.appletreereloaded

import org.bukkit.Material

object Utils
{

    fun isLeafBlock(type: Material): Boolean = type == Material.ACACIA_LEAVES ||
            type == Material.BIRCH_LEAVES ||
            type == Material.DARK_OAK_LEAVES ||
            type == Material.JUNGLE_LEAVES ||
            type == Material.OAK_LEAVES ||
            type == Material.SPRUCE_LEAVES
}
