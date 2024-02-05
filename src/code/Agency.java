import java.util.*;

/**
 * Agency of BCIT
 *
 * @author Andres Arevalo
 * @version 1.0
 */
public class Agency
{

    private final String name;
    private final Map<String, Property> properties;

    public Agency(final String name)
    {
        // validates name
        if(name == null)
        {
            throw new NullPointerException("Invalid name: " + name);
        } else if(isValidName(name))
        {
            this.name = name;
        } else
        {
            throw new IllegalArgumentException("Invalid nameL " + name);
        }

        this.properties = new HashMap<>();

    }

    private boolean isValidName(final String name)
    {
        return !name.isEmpty() && name.length() <= 30;
    }

    public void addProperty(final Property property)
    {
        if(property != null)
        {
            properties.put(property.getPropertyId(), property);
        }
    }

    public void removeProperty(final String propertyId)
    {
        if(propertyId != null)
        {
            properties.remove(propertyId);
        }
    }

    public Property getProperty(final String propertyId)
    {
        return properties.getOrDefault(propertyId, null);
    }

    public double getTotalPropertyValues()
    {
        double totalAmountUsd;
        final Set<String> keys;

        totalAmountUsd = 0;
        keys = properties.keySet();

        for(final String key : keys)
        {
            totalAmountUsd += properties.get(key).getPriceUsd();
        }

        return totalAmountUsd;
    }

    public List<Property> getPropertiesWithPools()
    {
        final List<Property> propertiesWithPools;
        final Set<String> keys;

        propertiesWithPools = new ArrayList<>();
        keys = properties.keySet();

        for(final String key : keys)
        {
            if(properties.get(key).hasSwimmingPool())
            {
                propertiesWithPools.add(properties.get(key));
            }
        }

        if(!propertiesWithPools.isEmpty())
        {
            return propertiesWithPools;
        }
        else
        {
            return null;
        }
    }

    public Property[] getPropertiesBetween(final double minUsd, final double maxUsd)
    {
        final List<Property> propertiesBetween;
        final Set<String> keys;
        final Property[] propertiesBetweenArray;

        double propertyPriceUsd;
        propertiesBetween = new ArrayList<>();

        keys = properties.keySet();

        for(final String key : keys)
        {
            propertyPriceUsd = properties.get(key).getPriceUsd();

            if(propertyPriceUsd >= minUsd && propertyPriceUsd <= maxUsd)
            {
                propertiesBetween.add(properties.get(key));
            }
        }

        if(propertiesBetween.isEmpty())
        {
            return null;
        }
        else
        {
            propertiesBetweenArray = propertiesBetween.toArray(new Property[0]);
            return propertiesBetweenArray;
        }
    }

    public List<Address> getPropertiesOn(final String streetName)
    {
        final List<Address> addressesOn;
        final Set<String> keys;
        Property property;
        Address propertyAddress;

        keys = properties.keySet();
        addressesOn = new ArrayList<>();

        for(final String key:  keys)
        {
            property = properties.get(key);
            propertyAddress = property.getAddress();

            if(propertyAddress.getStreetName().equalsIgnoreCase(streetName))
            {
                addressesOn.add(propertyAddress);
            }
        }

        if(!addressesOn.isEmpty())
        {
            return addressesOn;
        }
        else
        {
            return null;
        }
    }

    public Map<String, Property> getPropertiesWithBedrooms(final int minBedrooms, final int maxBedrooms)
    {

    }
}