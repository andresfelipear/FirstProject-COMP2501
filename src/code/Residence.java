/**
 * Residence
 *
 * @author Andres Arevalo
 * @version 1.0
 */
public class Residence extends Property
{
    private final int numberOfBedrooms;
    private final boolean swimmingPool;
    private final boolean strata;

    private static final int MAX_NUMBER_OF_BEDROOMS = 20;

    /**
     * Constructs a new Residence with the specified details.
     *
     * @param priceUsd         The price of the residence in USD.
     * @param address          The address of the residence.
     * @param numberOfBedrooms The number of bedrooms in the residence.
     * @param swimmingPool     Indicates whether the residence has a swimming pool.
     * @param type             The type of the residence.
     * @param propertyId       The unique identifier of the residence.
     * @param strata           Indicates whether the residence is part of a strata.
     * @throws IllegalArgumentException if the number of bedrooms is invalid.
     */
    public Residence(final double priceUsd,
                     final Address address,
                     final int numberOfBedrooms,
                     final boolean swimmingPool,
                     final String type,
                     final String propertyId,
                     final boolean strata)
    {
        super(priceUsd,
              address,
              type,
              propertyId);

        if(isValidNumberBedrooms(numberOfBedrooms))
        {
            throw new IllegalArgumentException("Invalid number of bedrooms: " + numberOfBedrooms);
        }

        this.numberOfBedrooms = numberOfBedrooms;
        this.swimmingPool = swimmingPool;
        this.strata = strata;
    }


    /**
     * Validates if the provided number of bedrooms is between 1 and 20.
     *
     * @param numberBedrooms The number of bedrooms to be validated.
     * @return true if the number of bedrooms is valid, false otherwise.
     */
    public boolean isValidNumberBedrooms(final int numberBedrooms)
    {
        return numberBedrooms >= 1 && numberBedrooms <= MAX_NUMBER_OF_BEDROOMS;
    }


    /**
     * Returns a string representation of the Residence, including details such as property type, property ID,
     * price, address, number of bedrooms, swimming pool availability, and strata information.
     *
     * @return A formatted string representing the Residence.
     */
    @Override
    public String toString()
    {
        return "Residence\n" +
                super.toString() +
                "Number of Bedrooms: " + numberOfBedrooms + "\n" +
                "Swimming Pool: " + (swimmingPool ? "yes" : "no") + "\n" +
                "Strata: " + (strata ? "yes" : "no");
    }

    public int getNumberOfBedrooms()
    {
        return numberOfBedrooms;
    }

    public boolean hasSwimmingPool()
    {
        return swimmingPool;
    }

    public boolean hasStrata()
    {
        return strata;
    }
}
