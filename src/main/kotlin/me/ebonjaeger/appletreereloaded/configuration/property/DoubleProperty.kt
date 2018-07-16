package me.ebonjaeger.appletreereloaded.configuration.property

import ch.jalu.configme.properties.Property
import ch.jalu.configme.resource.PropertyResource

/**
 * Double property.
 */
class DoubleProperty(path: String, defaultValue: Double) : Property<Double>(path, defaultValue)
{

    override fun getFromResource(resource: PropertyResource?): Double?
    {
        return resource?.getDouble(path)
    }
}
