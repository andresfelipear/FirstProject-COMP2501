/**
 * Address of BCIT
 *
 * @author Andres Arevalo
 * @version 1.0
 */
public class Address
{
    private final String unitNumber;
    private final int streetNumber;
    private final String streetName;
    private final String postalCode;
    private final String city;

    /**
     * Constructs a new Address object with the specified details.
     *
     * @param unitNumber   The unit number of the address (nullable).
     *                     Throws IllegalArgumentException if the unitNumber is invalid.
     * @param streetNumber The street number of the address.
     *                     Throws IllegalArgumentException if the streetNumber is invalid.
     * @param streetName   The street name of the address (nullable).
     *                     Throws NullPointerException if the streetName is null.
     *                     Throws IllegalArgumentException if the streetName is invalid.
     * @param postalCode   The postal code of the address (nullable).
     *                     Throws NullPointerException if the postalCode is null.
     *                     Throws IllegalArgumentException if the postalCode is invalid.
     * @param city         The city of the address (nullable).
     *                     Throws NullPointerException if the city is null.
     *                     Throws IllegalArgumentException if the city is invalid.
     */
    public Address(final String unitNumber,
                   final int streetNumber,
                   final String streetName,
                   final String postalCode,
                   final String city)
    {

        if(unitNumber == null || isValidUnitNumber(unitNumber))
        {
            this.unitNumber = unitNumber;
        } else
        {
            throw new IllegalArgumentException("Invalid unit number: " + unitNumber);
        }

        if(isValidStreetNumber(streetNumber))
        {
            this.streetNumber = streetNumber;
        } else
        {
            throw new IllegalArgumentException("Invalid street number: " + streetNumber);
        }

        if(streetName == null)
        {
            throw new NullPointerException("Invalid street name: " + streetName);
        } else if(isValidStreetName(streetName))
        {
            this.streetName = streetName;
        } else
        {
            throw new IllegalArgumentException("Invalid street name: " + streetName);
        }

        if(postalCode == null)
        {
            throw new NullPointerException("Invalid postal code: " + postalCode);
        } else if(isValidPostalCode(postalCode))
        {
            this.postalCode = postalCode;
        } else
        {
            throw new IllegalArgumentException("Invalid postal code: " + postalCode);
        }

        if(city == null)
        {
            throw new NullPointerException("Invalid city: " + city);
        } else if(isValidCity(city))
        {
            this.city = city;
        } else
        {
            throw new IllegalArgumentException("Invalid city: " + city);
        }

    }

    /**
     * @return unit number
     */
    public String getUnitNumber()
    {
        return unitNumber;
    }

    /**
     * @return street number
     */
    public int getStreetNumber()
    {
        return streetNumber;
    }

    /**
     * @return street name
     */
    public String getStreetName()
    {
        return streetName;
    }

    /**
     * @return postal code
     */
    public String getPostalCode()
    {
        return postalCode;
    }

    /**
     * @return city
     */
    public String getCity()
    {
        return city;
    }

    /**
     * Validates if the provided city is not null, not empty, and has a length between 1 and 30 characters.
     *
     * @param city The city to be validated.
     * @return true if the city is valid, false otherwise.
     */
    private boolean isValidCity(final String city)
    {
        return city != null && !city.isEmpty() && city.length() <= 30;
    }

    /**
     * Validates if the provided postal code is not null and has a length of either 5 or 6 characters.
     *
     * @param postalCode The postal code to be validated.
     * @return true if the postal code is valid, false otherwise.
     */
    private boolean isValidPostalCode(final String postalCode)
    {
        return postalCode != null && (postalCode.length() == 5 || postalCode.length() == 6);
    }

    /**
     * Validates if the provided street name is not null, not empty, and has a length between 1 and 20 characters.
     *
     * @param streetName The street name to be validated.
     * @return true if the street name is valid, false otherwise.
     */
    private boolean isValidStreetName(final String streetName)
    {
        return streetName != null && !streetName.isEmpty() && streetName.length() <= 20;
    }

    /**
     * Validates if the provided street number is non-negative and does not exceed 999999.
     *
     * @param streetNumber The street number to be validated.
     * @return true if the street number is valid, false otherwise.
     */
    private boolean isValidStreetNumber(final int streetNumber)
    {
        return streetNumber >= 0 && streetNumber <= 999999;
    }

    /**
     * Validates if the provided unit number is not empty and has a length not exceeding 4 characters.
     *
     * @param unitNumber The unit number to be validated.
     * @return true if the unit number is valid, false otherwise.
     */
    private boolean isValidUnitNumber(final String unitNumber)
    {
        return !unitNumber.isEmpty() && unitNumber.length() <= 4;
    }

}
