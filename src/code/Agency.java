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

    /**
     * Represents a real estate agency with a specified name and a collection of properties.
     *
     * The name of the agency must not be null and must be a non-empty string with a length not exceeding 30 characters.
     *
     * @param name The name of the agency.
     * @throws NullPointerException     if the provided name is null.
     * @throws IllegalArgumentException if the provided name is invalid.
     */
    public Agency(final String name) {
        // Validates name
        if (name == null) {
            throw new NullPointerException("Invalid name: " + name);
        } else if (isValidName(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid name: " + name);
        }

        this.properties = new HashMap<>();
    }

    /**
     * Validates if the provided name is not null, not empty, and has a length between 1 and 30 characters.
     *
     * @param name The name to be validated.
     * @return true if the name is valid, false otherwise.
     */
    private boolean isValidName(final String name) {
        return !name.isEmpty() && name.length() <= 30;
    }

    /**
     * Adds a property to the agency's collection.
     *
     * @param property The property to be added.
     */
    public void addProperty(final Property property) {
        if (property != null) {
            properties.put(property.getPropertyId(), property);
        }
    }

    /**
     * Removes a property from the agency's collection based on its property ID.
     *
     * @param propertyId The property ID of the property to be removed.
     */
    public void removeProperty(final String propertyId) {
        if (propertyId != null) {
            properties.remove(propertyId);
        }
    }

    /**
     * Retrieves a property from the agency's collection based on its property ID.
     *
     * @param propertyId The property ID of the desired property.
     * @return The property with the specified property ID, or null if not found.
     */
    public Property getProperty(final String propertyId) {
        return properties.getOrDefault(propertyId, null);
    }

    /**
     * Calculates and returns the total value of all properties in the agency in USD.
     *
     * @return The total value of all properties in the agency.
     */
    public double getTotalPropertyValues() {
        double totalAmountUsd = 0;

        for (Property property : properties.values()) {
            totalAmountUsd += property.getPriceUsd();
        }

        return totalAmountUsd;
    }

    /**
     * Retrieves a list of properties in the agency that have swimming pools.
     *
     * @return A list of properties with swimming pools, or null if none found.
     */
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

    /**
     * Retrieves an array of properties within a specified price range (inclusive).
     *
     * @param minUsd The minimum price in USD.
     * @param maxUsd The maximum price in USD.
     * @return An array of properties within the specified price range, or null if none found.
     */
    public Property[] getPropertiesBetween(final double minUsd, final double maxUsd) {
        final List<Property> propertiesBetween = new ArrayList<>();

        for (Property property : properties.values()) {
            double propertyPriceUsd = property.getPriceUsd();

            if (propertyPriceUsd >= minUsd && propertyPriceUsd <= maxUsd) {
                propertiesBetween.add(property);
            }
        }

        return propertiesBetween.isEmpty() ? null : propertiesBetween.toArray(new Property[0]);
    }

    /**
     * Retrieves a list of addresses for properties on a specific street.
     *
     * @param streetName The name of the street.
     * @return A list of addresses for properties on the specified street, or null if none found.
     */
    public List<Address> getPropertiesOn(final String streetName) {
        final List<Address> addressesOn = new ArrayList<>();

        for (Property property : properties.values()) {
            Address propertyAddress = property.getAddress();

            if (propertyAddress.getStreetName().equalsIgnoreCase(streetName)) {
                addressesOn.add(propertyAddress);
            }
        }

        return addressesOn.isEmpty() ? null : addressesOn;
    }

    /**
     * Retrieves a map of properties with a number of bedrooms within a specified range.
     * The key is the propertyId and the value is the property.
     *
     * @param minBedrooms The minimum number of bedrooms.
     * @param maxBedrooms The maximum number of bedrooms.
     * @return A map of properties with the specified number of bedrooms, or null if none found.
     */
    public HashMap<String, Property> getPropertiesWithBedrooms(final int minBedrooms, final int maxBedrooms) {
        final HashMap<String, Property> propertiesWithBedrooms = new HashMap<>();

        for (Property property : properties.values()) {
            if (property.getNumberOfBedrooms() >= minBedrooms && property.getNumberOfBedrooms() <= maxBedrooms) {
                propertiesWithBedrooms.put(property.getPropertyId(), property);
            }
        }

        return propertiesWithBedrooms.isEmpty() ? null : propertiesWithBedrooms;
    }

    /**
     * Retrieves a list of property details of a specific type.
     *
     * @param propertyType The type of property.
     * @return A list of property details for properties of the specified type, or null if none found.
     */
    public ArrayList<String> getPropertiesOfType(final String propertyType) {
        final ArrayList<String> propertiesOfType = new ArrayList<>();
        int counter = 1;

        // header
        propertiesOfType.add("Type: " + propertyType.toUpperCase() + "\n");

        for (Property property : properties.values()) {
            if (property.getType().equalsIgnoreCase(propertyType)) {
                String propertyDetails = counter + ") Property " + property.getPropertyId() + ": " +
                        property.getAddress().getFullAddress() + " (" + property.getPropertyDetails() +
                        String.format("): $%.0f", property.getPriceUsd()) + ".\n";

                propertiesOfType.add(propertyDetails);
                counter++;
            }
        }

        if (propertiesOfType.size() == 1) {
            propertiesOfType.add("<none found>");
        }

        return propertiesOfType;
    }

}
