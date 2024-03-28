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

    private static final int INITIAL_LIST_SIZE = 1;
    public static final int MAX_NAME_LENGTH = 30;

    /**
     * Represents a real estate agency with a specified name and a collection of properties.
     * <p>
     * The name of the agency must not be null and must be a non-empty string with a length not exceeding 30 characters.
     *
     * @param name The name of the agency.
     * @throws NullPointerException     if the provided name is null.
     * @throws IllegalArgumentException if the provided name is invalid.
     */
    public Agency(final String name)
    {
        if(name == null)
        {
            throw new NullPointerException("Invalid name: " + name);
        }

        if(!isValidName(name))
        {
            throw new IllegalArgumentException("Invalid name: " + name);
        }

        this.name = name;
        this.properties = new HashMap<>();
    }

    /**
     * Validates if the provided name is not null, not empty, and has a length between 1 and 30 characters.
     *
     * @param name The name to be validated.
     * @return true if the name is valid, false otherwise.
     */
    private boolean isValidName(final String name)
    {
        return !name.isEmpty() && name.length() <= MAX_NAME_LENGTH;
    }

    /**
     * Adds a property to the agency's collection.
     *
     * @param property The property to be added.
     */
    public void addProperty(final Property property)
    {
        if(property != null)
        {
            properties.put(property.getPropertyId(), property);
        }
    }

    /**
     * Removes a property from the agency's collection based on its property ID.
     *
     * @param propertyId The property ID of the property to be removed.
     */
    public void removeProperty(final String propertyId)
    {
        if(propertyId != null)
        {
            properties.remove(propertyId);
        }
    }

    /**
     * Retrieves a property from the agency's collection based on its property ID.
     *
     * @param propertyId The property ID of the desired property.
     * @return The property with the specified property ID, or null if not found.
     */
    public Property getProperty(final String propertyId)
    {
        return properties.getOrDefault(propertyId, null);
    }


    /**
     * Calculates and returns the total value of all properties in the agency in USD.
     *
     * @return The total value of all properties in the agency.
     */
    public double getTotalPropertyValues()
    {
        double totalAmountUsd;
        totalAmountUsd = 0;

        for(Property property : properties.values())
        {
            totalAmountUsd += property.getPriceUsd();
        }

        return totalAmountUsd;
    }

    /**
     * Retrieves a list of properties in the agency that have swimming pools.
     *
     * @return A list of properties with swimming pools, or null if none found.
     */
    public ArrayList<Residence> getPropertiesWithPools()
    {
        final ArrayList<Residence> propertiesWithPools;
        final Set<String> keys;
        Residence residenceProperty;

        propertiesWithPools = new ArrayList<>();
        keys = properties.keySet();

        for(final String key : keys)
        {
            if(properties.get(key) instanceof Residence)
            {
                residenceProperty = (Residence) properties.get(key);

                if(residenceProperty.hasSwimmingPool())
                {
                    propertiesWithPools.add(residenceProperty);
                }
            }
        }

        if(!propertiesWithPools.isEmpty())
        {
            return propertiesWithPools;
        }

        return null;
    }

    /**
     * Retrieves an array of properties within a specified price range (inclusive).
     *
     * @param minUsd The minimum price in USD.
     * @param maxUsd The maximum price in USD.
     * @return An array of properties within the specified price range, or null if none found.
     */
    public Property[] getPropertiesBetween(final double minUsd,
                                           final double maxUsd)
    {
        final List<Property> propertiesBetween;
        double propertyPriceUsd;

        propertiesBetween = new ArrayList<>();

        for(Property property : properties.values())
        {
            propertyPriceUsd = property.getPriceUsd();

            if(propertyPriceUsd >= minUsd && propertyPriceUsd <= maxUsd)
            {
                propertiesBetween.add(property);
            }
        }

        if(propertiesBetween.isEmpty())
        {
            return null;
        }

        return propertiesBetween.toArray(new Property[0]);
    }

    /**
     * Retrieves a list of addresses for properties on a specific street.
     *
     * @param streetName The name of the street.
     * @return A list of addresses for properties on the specified street, or null if none found.
     */
    public ArrayList<Address> getPropertiesOn(final String streetName)
    {
        final ArrayList<Address> addressesOn;
        Address propertyAddress;

        addressesOn = new ArrayList<>();

        for(Property property : properties.values())
        {
            propertyAddress = property.getAddress();

            if(propertyAddress.getStreetName().equalsIgnoreCase(streetName))
            {
                addressesOn.add(propertyAddress);
            }
        }

        if(addressesOn.isEmpty())
        {
            return null;
        }

        return addressesOn;
    }

    /**
     * Retrieves a map of properties with a number of bedrooms within a specified range.
     * The key is the propertyId and the value is the property.
     *
     * @param minBedrooms The minimum number of bedrooms.
     * @param maxBedrooms The maximum number of bedrooms.
     * @return A map of properties with the specified number of bedrooms, or null if none found.
     */
    public HashMap<String, Residence> getPropertiesWithBedrooms(final int minBedrooms,
                                                               final int maxBedrooms)
    {
        final HashMap<String, Residence> propertiesWithBedrooms;
        propertiesWithBedrooms = new HashMap<>();
        Residence residenceProperty;

        for(Property property : properties.values())
        {
            if(property instanceof Residence)
            {
                residenceProperty = (Residence) property;

                if(residenceProperty.getNumberOfBedrooms() >= minBedrooms &&
                        residenceProperty.getNumberOfBedrooms() <= maxBedrooms)
                {
                    propertiesWithBedrooms.put(property.getPropertyId(), residenceProperty);
                }
            }
        }

        if(propertiesWithBedrooms.isEmpty())
        {
            return null;
        }

        return propertiesWithBedrooms;
    }

    /**
     * Retrieves a list of property details of a specific type.
     *
     * @param propertyType The type of property.
     * @return A list of property details for properties of the specified type, or null if none found.
     */
    public ArrayList<Property> getPropertiesOfType(final String propertyType)
    {
        final ArrayList<Property> propertiesOfType;

        propertiesOfType = new ArrayList<>();

        for(Property property : properties.values())
        {
            if(property.getType().equalsIgnoreCase(propertyType))
            {
                propertiesOfType.add(property);
            }
        }

        if(propertiesOfType.size() == INITIAL_LIST_SIZE)
        {
            return null;
        }

        return propertiesOfType;
    }

    /**
     * Returns an ArrayList of Commercial properties that have a loading dock available.
     *
     * @return an ArrayList of Commercial properties with loading docks, or null if none are found
     */
    public ArrayList<Commercial> getPropertiesWithLoadingDocks()
    {
        final ArrayList<Commercial> propertiesWithLoadingDock;
        Commercial commercialProperty;

        propertiesWithLoadingDock = new ArrayList<>();

        for(Property property : properties.values())
        {
            if(property instanceof  Commercial)
            {
                commercialProperty = (Commercial) property;

                if(commercialProperty.hasLoadingDock())
                {
                    propertiesWithLoadingDock.add(commercialProperty);
                }
            }
        }

        if(propertiesWithLoadingDock.size() == INITIAL_LIST_SIZE)
        {
            return null;
        }

        return propertiesWithLoadingDock;
    }


    /**
     * Returns an ArrayList of Commercial properties that have highway access.
     *
     * @return an ArrayList of Commercial properties with highway access, or null if none are found
     */
    public ArrayList<Commercial> getPropertiesWithHighwayAccess()
    {
        final ArrayList<Commercial> propertiesWithHighwayAccess;
        Commercial commercialProperty;

        propertiesWithHighwayAccess = new ArrayList<>();

        for(Property property : properties.values())
        {
            if(property instanceof  Commercial)
            {
                commercialProperty = (Commercial) property;

                if(commercialProperty.hasHighwayAccess())
                {
                    propertiesWithHighwayAccess.add(commercialProperty);
                }
            }
        }

        if(propertiesWithHighwayAccess.size() == INITIAL_LIST_SIZE)
        {
            return null;
        }

        return propertiesWithHighwayAccess;
    }


    /**
     * Returns an ArrayList of Retail properties where the square footage is at least the specified value.
     *
     * @param squareFootage the minimum square footage required
     * @return an ArrayList of Retail properties meeting the square footage criteria, or null if none are found
     */
    public ArrayList<Retail> getPropertiesSquareFootage(int squareFootage)
    {
        final ArrayList<Retail> propertiesWithSquareFootage;
        Retail retailProperty;

        propertiesWithSquareFootage = new ArrayList<>();

        for(Property property : properties.values())
        {
            if(property instanceof  Retail)
            {
                retailProperty = (Retail) property;

                if(retailProperty.getSquareFootage() >= squareFootage)
                {
                    propertiesWithSquareFootage.add(retailProperty);
                }
            }
        }

        if(propertiesWithSquareFootage.size() == INITIAL_LIST_SIZE)
        {
            return null;
        }

        return propertiesWithSquareFootage;
    }

    /**
     * Returns an ArrayList of Retail properties where customer parking is available.
     *
     * @return an ArrayList of Retail properties with customer parking, or null if none are found
     */
    public ArrayList<Retail> getPropertiesWithCustomerParking()
    {
        final ArrayList<Retail> propertiesWithCustomerParking;
        Retail retailProperty;

        propertiesWithCustomerParking = new ArrayList<>();

        for(Property property : properties.values())
        {
            if(property instanceof  Retail)
            {
                retailProperty = (Retail) property;

                if(retailProperty.hasCustomerParking())
                {
                    propertiesWithCustomerParking.add(retailProperty);
                }
            }
        }

        if(propertiesWithCustomerParking.size() == INITIAL_LIST_SIZE)
        {
            return null;
        }

        return propertiesWithCustomerParking;
    }


    /**
     * Returns an ArrayList of Residence properties that are in a strata.
     *
     * @return an ArrayList of Residence properties in a strata, or null if none are found
     */
    public ArrayList<Residence> getPropertiesWithStrata()
    {
        final ArrayList<Residence> propertiesWithStrata;
        Residence residenceProperty;

        propertiesWithStrata = new ArrayList<>();

        for(Property property : properties.values())
        {
            if(property instanceof  Residence)
            {
                residenceProperty = (Residence) property;

                if(residenceProperty.hasStrata())
                {
                    propertiesWithStrata.add(residenceProperty);
                }
            }
        }

        if(propertiesWithStrata.size() == INITIAL_LIST_SIZE)
        {
            return null;
        }

        return propertiesWithStrata;
    }
}
