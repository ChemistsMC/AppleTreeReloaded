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

    fun getSaplingType(type: Material): Material {
        return when (type) {
            Material.BIRCH_LEAVES -> Material.BIRCH_SAPLING
            Material.DARK_OAK_LEAVES -> Material.DARK_OAK_SAPLING
            Material.JUNGLE_LEAVES -> Material.JUNGLE_SAPLING
            Material.OAK_LEAVES -> Material.OAK_SAPLING
            Material.SPRUCE_LEAVES -> Material.SPRUCE_SAPLING
            else -> Material.AIR
        }
    }
}
