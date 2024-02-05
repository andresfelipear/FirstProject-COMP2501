/**
 * Property of BCIT
 *
 * @author Andres Arevalo
 * @version 1.0
 */
public class Property
{
    private double priceUsd;
    private final Address address;
    private final int numberOfBedrooms;
    private final boolean swimmingPool;
    private final String type;
    private final String propertyId;

    public Property(final double priceUsd,
                    final Address address,
                    final int numberOfBedrooms,
                    final boolean swimmingPool,
                    final String type,
                    final String propertyId)
    {
        // price usd validation
        if(isValidPriceUsd(priceUsd))
        {
            this.priceUsd = priceUsd;
        } else
        {
            throw new IllegalArgumentException("Invalid price: " + priceUsd);
        }

        // address validation
        if(address == null)
        {
            throw new NullPointerException("Invalid address: " + address);
        } else
        {
            this.address = address;
        }

        // number of bedrooms validation
        if(isValidNumberBedrooms(numberOfBedrooms))
        {
            this.numberOfBedrooms = numberOfBedrooms;
        } else
        {
            throw new IllegalArgumentException("Invalid number of bedrooms: " + numberOfBedrooms);
        }

        this.swimmingPool = swimmingPool;

        // type validation
        if(type == null)
        {
            throw new NullPointerException("Invalid property type: " + type);
        } else if(isValidType(type))
        {
            this.type = type;
        } else
        {
            throw new IllegalArgumentException("Invalid property type: " + type);
        }

        if(propertyId == null)
        {
            throw new NullPointerException("Invalid property id: " + propertyId);
        } else if(isValidPropertyId(propertyId))
        {
            this.propertyId = propertyId;
        } else
        {
            throw new IllegalArgumentException("Invalid property id: " + propertyId);
        }


    }

    /**
     * Gets the price of the property in USD.
     *
     * @return The price of the property in USD.
     */
    public double getPriceUsd()
    {
        return priceUsd;
    }

    /**
     * Gets the address of the property.
     *
     * @return The address of the property.
     */
    public Address getAddress()
    {
        return address;
    }

    /**
     * Gets the number of bedrooms in the property.
     *
     * @return The number of bedrooms in the property.
     */
    public int getNumberOfBedrooms()
    {
        return numberOfBedrooms;
    }

    /**
     * Checks if the property has a swimming pool.
     *
     * @return true if the property has a swimming pool, false otherwise.
     */
    public boolean hasSwimmingPool()
    {
        return swimmingPool;
    }

    /**
     * Gets the type of the property.
     *
     * @return The type of the property.
     */
    public String getType()
    {
        return type;
    }

    /**
     * Gets the property ID.
     *
     * @return The property ID.
     */
    public String getPropertyId()
    {
        return propertyId;
    }

    /**
     * Sets the price of the property in USD.
     *
     * @param priceUsd The new price of the property.
     */
    public void setPriceUsd(final double priceUsd)
    {
        this.priceUsd = priceUsd;
    }

    /**
     * Validates if the provided property ID has a length between 1 and 6 characters.
     *
     * @param propertyId The property ID to be validated.
     * @return true if the property ID is valid, false otherwise.
     */
    private boolean isValidPropertyId(final String propertyId)
    {
        return !propertyId.isEmpty() && propertyId.length() <= 6;
    }

    /**
     * Validates if the provided property type is one of "residence", "commercial", or "retail" (case-insensitive).
     *
     * @param type The property type to be validated.
     * @return true if the property type is valid, false otherwise.
     */
    private boolean isValidType(final String type)
    {
        return type.equalsIgnoreCase("residence") ||
                type.equalsIgnoreCase("commercial") ||
                type.equalsIgnoreCase("retail");
    }

    /**
     * Validates if the provided number of bedrooms is between 1 and 20.
     *
     * @param numberBedrooms The number of bedrooms to be validated.
     * @return true if the number of bedrooms is valid, false otherwise.
     */
    private boolean isValidNumberBedrooms(final int numberBedrooms)
    {
        return numberBedrooms >= 1 && numberBedrooms <= 20;
    }

    /**
     * Validates if the provided price in USD is non-negative.
     *
     * @param priceUsd The price in USD to be validated.
     * @return true if the price is valid, false otherwise.
     */
    private boolean isValidPriceUsd(final double priceUsd)
    {
        return priceUsd >= 0;
    }

}
