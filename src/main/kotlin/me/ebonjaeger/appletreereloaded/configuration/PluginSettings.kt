package me.ebonjaeger.appletreereloaded.configuration

import ch.jalu.configme.Comment
import ch.jalu.configme.SettingsHolder
import ch.jalu.configme.properties.DoubleProperty
import ch.jalu.configme.properties.Property
import ch.jalu.configme.properties.PropertyInitializer.newListProperty
import ch.jalu.configme.properties.PropertyInitializer.newProperty

/**
 * Object to hold settings for general plugin operation.
 */
object PluginSettings : SettingsHolder {

    @JvmField
    @Comment("Worlds listed here will be ignored by the plugin")
    val IGNORED_WORLDS: Property<List<String>> = newListProperty("ignored-worlds", "creative")

    @JvmField
    @Comment("Should items be dropped on normal leaf decay")
    val DROP_ON_DECAY: Property<Boolean> = newProperty("drop-on-decay", true)

    @JvmField
    @Comment("Regular apple drop chance (between 0 and 1)")
    val APPLE_CHANCE: Property<Double> = DoubleProperty("apple-chance", 0.05)

    @JvmField
    @Comment("Golden apple drop chance (between 0 and 1)")
    val GOLDEN_APPLE_CHANCE: Property<Double> = DoubleProperty("golden-apple-chance", 0.05)

    @JvmField
    @Comment("Cocoa drop chance (between 0 and 1)")
    val COCOA_CHANCE: Property<Double> = DoubleProperty("cocoa-chance", 0.02)

    @JvmField
    @Comment("Should leaves drop on block break")
    val DROP_LEAVES: Property<Boolean> = newProperty("drop-leaves", false)

    @JvmField
    @Comment("Should leaves drop on leaf decay")
    val DROP_LEAVES_DECAY: Property<Boolean> = newProperty("drop-leaves-decay", false)

    @JvmField
    @Comment("leaf drop chance (between 0 and 1)")
    val SAPLING_CHANCE: Property<Double> = DoubleProperty("sapling-chance", 0.05)
}
