package me.ebonjaeger.appletreereloaded.command

import ch.jalu.configme.SettingsManager
import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import co.aikar.commands.annotation.Description
import co.aikar.commands.annotation.Subcommand
import org.bukkit.ChatColor
import org.bukkit.command.CommandSender

@CommandAlias("appletree|at")
@Description("Commands for AppleTreeReloaded")
class GeneralCommands (private val settings: SettingsManager) : BaseCommand() {

    @Subcommand("reload")
    @CommandPermission("appletreereloaded.command.reload")
    @Description("Reloads the configuration file")
    fun onReload(sender: CommandSender) {
        settings.reload()
        sender.sendMessage("${ChatColor.BLUE}» ${ChatColor.GRAY}Configuration files reloaded!")
    }
}