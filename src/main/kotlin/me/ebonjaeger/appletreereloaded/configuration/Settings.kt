package me.ebonjaeger.appletreereloaded.configuration

import ch.jalu.configme.SettingsHolder
import ch.jalu.configme.SettingsManagerImpl
import ch.jalu.configme.configurationdata.ConfigurationData
import ch.jalu.configme.configurationdata.ConfigurationDataBuilder
import ch.jalu.configme.migration.MigrationService
import ch.jalu.configme.migration.PlainMigrationService
import ch.jalu.configme.resource.YamlFileResource
import java.io.File

/**
 * Settings class.
 *
 * @param file The configuration file to load
 * @param configurationData The configuration data for the settings
 * @param migrator The configuration migrator to use to add new config options
 */
class Settings private constructor(file: YamlFileResource,
                                   configurationData: ConfigurationData,
                                   migrator: MigrationService) :
        SettingsManagerImpl(file, configurationData, migrator) {

    companion object {

        /** All [SettingsHolder] classes. */
        private val PROPERTY_HOLDERS = arrayOf(PluginSettings::class.java)

        /**
         * Creates a [Settings] instance, using the given file as config file.
         *
         * @param file the config file to load
         * @return settings instance for the file
         */
        fun create(file: File): Settings {
            val fileResource = YamlFileResource(file)
            val configurationData = ConfigurationDataBuilder.createConfiguration(*PROPERTY_HOLDERS)
            val migrator = PlainMigrationService()

            return Settings(fileResource, configurationData, migrator)
        }
    }
}
