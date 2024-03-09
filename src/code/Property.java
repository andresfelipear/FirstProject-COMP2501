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
    private final String type;
    private final String propertyId;

    private static final int MAX_PROPERTY_ID_LENGTH = 6;
    private static final double MIN_PRICE_USD = 0;


    /**
     * Constructs a new Property object with the specified details.
     *
     * @param priceUsd         The price of the property in USD.
     *                         Throws IllegalArgumentException if the price is invalid.
     * @param address          The address of the property.
     *                         Throws NullPointerException if the address is null.
     * @param type             The type of the property.
     *                         Throws NullPointerException if the type is null.
     *                         Throws IllegalArgumentException if the type is invalid.
     * @param propertyId       The unique identifier of the property.
     *                         Throws NullPointerException if the propertyId is null.
     *                         Throws IllegalArgumentException if the propertyId is invalid.
     */
    public Property(final double priceUsd,
                    final Address address,
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
     * Returns a string representation of the Property, including details such as property ID, type, price, number of bedrooms,
     * swimming pool availability, and the property's address.
     *
     * @return A formatted string representing the Property.
     */
    @Override
    public String toString()
    {
        return "Property Id: " + propertyId + "\n" +
                "Type: " + type + "\n" +
                "Price: $" + priceUsd + "\n" +
                "Address: " + address.toString();
    }

}
