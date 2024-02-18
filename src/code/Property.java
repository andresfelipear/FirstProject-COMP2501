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

    private static final int SINGLE_BEDROOM = 1;
    private static final int MAX_PROPERTY_ID_LENGTH = 6;
    private static final int MAX_NUMBER_OF_BEDROOMS = 20;
    private static final double MIN_PRICE_USD = 0;


    /**
     * Constructs a new Property object with the specified details.
     *
     * @param priceUsd        The price of the property in USD.
     *                        Throws IllegalArgumentException if the price is invalid.
     * @param address         The address of the property.
     *                        Throws NullPointerException if the address is null.
     * @param numberOfBedrooms The number of bedrooms in the property.
     *                        Throws IllegalArgumentException if the number of bedrooms is invalid.
     * @param swimmingPool    Indicates whether the property has a swimming pool.
     * @param type            The type of the property.
     *                        Throws NullPointerException if the type is null.
     *                        Throws IllegalArgumentException if the type is invalid.
     * @param propertyId      The unique identifier of the property.
     *                        Throws NullPointerException if the propertyId is null.
     *                        Throws IllegalArgumentException if the propertyId is invalid.
     */
    public Property(final double priceUsd,
                    final Address address,
                    final int numberOfBedrooms,
                    final boolean swimmingPool,
                    final String type,
                    final String propertyId)
    {
        if(!isValidPriceUsd(priceUsd))
        {
            throw new IllegalArgumentException("Invalid price: " + priceUsd);
        }

        if(address == null)
        {
            throw new NullPointerException("Invalid address: " + address);
        }

        if(!isValidNumberBedrooms(numberOfBedrooms))
        {
            throw new IllegalArgumentException("Invalid number of bedrooms: " + numberOfBedrooms);
        }

        if(type == null)
        {
            throw new NullPointerException("Invalid property type: " + type);
        }
        if(!isValidType(type))
        {
            throw new IllegalArgumentException("Invalid property type: " + type);
        }

        if(propertyId == null)
        {
            throw new NullPointerException("Invalid property id: " + propertyId);
        }
        if(!isValidPropertyId(propertyId))
        {
            throw new IllegalArgumentException("Invalid property id: " + propertyId);
        }

        this.propertyId = propertyId;
        this.type = type;
        this.priceUsd = priceUsd;
        this.address = address;
        this.numberOfBedrooms = numberOfBedrooms;
        this.swimmingPool = swimmingPool;
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
        return !propertyId.isEmpty() && propertyId.length() <= MAX_PROPERTY_ID_LENGTH;
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
        return numberBedrooms >= 1 && numberBedrooms <= MAX_NUMBER_OF_BEDROOMS;
    }


    /**
     * Validates if the provided price in USD is non-negative.
     *
     * @param priceUsd The price in USD to be validated.
     * @return true if the price is valid, false otherwise.
     */
    private boolean isValidPriceUsd(final double priceUsd)
    {
        return priceUsd >= MIN_PRICE_USD;
    }


    /**
     * Generates a string representing the details of the property based on the number of bedrooms and the presence of a pool.
     *
     * @return A string describing the property details, including the number of bedrooms and whether it has a pool.
     */
    public String getPropertyDetails()
    {
        if(swimmingPool)
        {
            if(numberOfBedrooms == SINGLE_BEDROOM)
            {
                return numberOfBedrooms + " bedroom plus pool";
            }
            else
            {
                return numberOfBedrooms + " bedrooms plus pool";
            }
        }
        else
        {
            if(numberOfBedrooms == SINGLE_BEDROOM)
            {
                return numberOfBedrooms + " bedroom";
            }
            else
            {
                return numberOfBedrooms + " bedrooms";
            }
        }
    }
}
