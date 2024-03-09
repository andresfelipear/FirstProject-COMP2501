/**
 * Commercial
 *
 * @author user
 * @version 1.0
 */
public class Commercial extends Property
{
    private final boolean loadingDock;
    private final boolean highwayAccess;

    /**
     * Constructs a new Commercial property with the specified details.
     *
     * @param priceUsd      The price of the commercial property in USD.
     * @param address       The address of the commercial property.
     * @param type          The type of the commercial property.
     * @param propertyId    The unique identifier of the commercial property.
     * @param loadingDock   Indicates whether the commercial property has a loading dock.
     * @param highwayAccess Indicates whether the commercial property has highway access.
     */
    public Commercial(final double priceUsd,
                      final Address address,
                      final String type,
                      final String propertyId,
                      final boolean loadingDock,
                      final boolean highwayAccess)
    {
        super(priceUsd,
              address,
              type,
              propertyId);

        this.loadingDock = loadingDock;
        this.highwayAccess = highwayAccess;
    }


    /**
     * Returns whether the commercial property has a loading dock.
     *
     * @return true if the property has a loading dock, false otherwise.
     */
    public boolean isLoadingDock()
    {
        return loadingDock;
    }


    /**
     * Returns whether the commercial property has highway access.
     *
     * @return true if the property has highway access, false otherwise.
     */
    public boolean isHighwayAccess()
    {
        return highwayAccess;
    }


    /**
     * Returns a string representation of the Commercial property, including details such as property type, property ID,
     * price, address, loading dock availability, and highway access.
     *
     * @return A formatted string representing the Commercial property.
     */
    @Override
    public String toString()
    {
        return "Commercial\n" +
                super.toString() +
                "Loading Dock: " + (loadingDock ? "yes" : "no") + "\n" +
                "Highway Access: " + (highwayAccess ? "yes" : "no");
    }
}
