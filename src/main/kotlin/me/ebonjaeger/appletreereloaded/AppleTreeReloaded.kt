package me.ebonjaeger.appletreereloaded

import ch.jalu.configme.SettingsManagerBuilder
import co.aikar.commands.PaperCommandManager
import me.ebonjaeger.appletreereloaded.command.GeneralCommands
import me.ebonjaeger.appletreereloaded.configuration.PluginSettings
import me.ebonjaeger.appletreereloaded.listener.BlockBreakListener
import me.ebonjaeger.appletreereloaded.listener.LeafDecayListener
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.nio.file.Files

class AppleTreeReloaded : JavaPlugin() {

    override fun onEnable() {
        // Create config file if it does not exist
        if (!Files.exists(File(dataFolder, "config.yml").toPath())) {
            saveResource("config.yml", false)
        }

        val file = File(dataFolder, "config.yml")
        val settings = SettingsManagerBuilder
            .withYamlFile(file)
            .configurationData(PluginSettings::class.java)
            .useDefaultMigrationService()
            .create()

        server.pluginManager.registerEvents(BlockBreakListener(settings), this)
        server.pluginManager.registerEvents(LeafDecayListener(settings), this)

        val commandManager = PaperCommandManager(this)
        commandManager.registerCommand(GeneralCommands(settings))
    }
}
