/**
 * Retail
 *
 * @author user
 * @version 1.0
 */
public class Retail extends Property
{

    private final int squareFootage;
    private final boolean customerParking;

    /**
     * Constructs a new Retail property with the specified details.
     *
     * @param priceUsd        The price of the retail property in USD.
     * @param address         The address of the retail property.
     * @param type            The type of the retail property.
     * @param propertyId      The unique identifier of the retail property.
     * @param squareFootage   The amount of floor space available in square footage.
     * @param customerParking Indicates whether customer parking is available.
     */
    public Retail(final double priceUsd,
                  final Address address,
                  final String type,
                  final String propertyId,
                  final int squareFootage,
                  final boolean customerParking)
    {
        super(priceUsd,
              address,
              type,
              propertyId);

        this.squareFootage = squareFootage;
        this.customerParking = customerParking;
    }


    /**
     * Returns the amount of floor space available in square footage.
     *
     * @return The square footage of the retail property.
     */
    public int getSquareFootage()
    {
        return squareFootage;
    }


    /**
     * Returns whether customer parking is available at the retail property.
     *
     * @return true if customer parking is available, false otherwise.
     */
    public boolean isCustomerParking()
    {
        return customerParking;
    }


    /**
     * Returns a string representation of the Retail property, including details such as property type, property ID,
     * price, address, square footage, and customer parking availability.
     *
     * @return A formatted string representing the Retail property.
     */
    @Override
    public String toString()
    {
        return "Retail\n" +
                super.toString() +
                "Square Footage: " + squareFootage + " sq.ft.\n" +
                "Customer Parking: " + (customerParking ? "yes" : "no");
    }
}
