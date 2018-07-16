package me.ebonjaeger.appletreereloaded.configuration

import ch.jalu.configme.Comment
import ch.jalu.configme.SettingsHolder
import ch.jalu.configme.properties.Property
import ch.jalu.configme.properties.PropertyInitializer.newListProperty
import ch.jalu.configme.properties.PropertyInitializer.newProperty

/**
 * Object to hold settings for general plugin operation.
 */
object PluginSettings : SettingsHolder
{

    @JvmField
    @Comment("Worlds listed here will be ignored by the plugin")
    val IGNORED_WORLDS: Property<List<String>> = newListProperty("ignored-worlds", "creative")

    @JvmField
    @Comment("Should items be dropped on normal leaf decay")
    val DROP_ON_DECAY: Property<Boolean> = newProperty("drop-on-decay", false)

    @JvmField
    @Comment("Regular apple drop chance (between 0 and 100)")
    val APPLE_CHANCE: Property<Int> = newProperty("apple-chance", 5)

    @JvmField
    @Comment("Golden apple drop chance (between 0 and 100)")
    val GOLDEN_APPLE_CHANCE: Property<Int> = newProperty("golden-apple-chance", 1)

    @JvmField
    @Comment("Cocoa drop chance (between 0 and 100)")
    val COCOA_CHANCE: Property<Int> = newProperty("cocoa-chance", 2)

    @JvmField
    @Comment("Leaf drop chance (between 0 and 100)")
    val LEAF_CHANCE: Property<Int> = newProperty("leaf-chance", 5)
}
