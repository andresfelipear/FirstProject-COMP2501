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

    public static final int MAX_CITY_LENGTH = 30;
    public static final int MAX_STREET_NAME = 20;
    public static final int MAX_STREET_NUMBER = 999999;
    public static final int MAX_UNIT_NUMBER_LENGTH = 4;
    public static final int MAX_POSTAL_CODE_LENGTH = 6;
    public static final int MIN_STREET_NUMBER = 0;
    public static final int MIN_POSTAL_CODE_LENGTH = 5;


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

        if(!isValidUnitNumber(unitNumber))
        {
            throw new IllegalArgumentException("Invalid unit number: " + unitNumber);
        }

        if(!isValidStreetNumber(streetNumber))
        {
            throw new IllegalArgumentException("Invalid street number: " + streetNumber);
        }

        if(streetName == null)
        {
            throw new NullPointerException("Invalid street name: " + streetName);
        }
        if(!isValidStreetName(streetName))
        {
            throw new IllegalArgumentException("Invalid street name: " + streetName);
        }

        if(postalCode == null)
        {
            throw new NullPointerException("Invalid postal code: " + postalCode);
        }
        if(!isValidPostalCode(postalCode))
        {
            throw new IllegalArgumentException("Invalid postal code: " + postalCode);
        }

        if(city == null)
        {
            throw new NullPointerException("Invalid city: " + city);
        }
        if(!isValidCity(city))
        {
            throw new IllegalArgumentException("Invalid city: " + city);
        }

        this.unitNumber = unitNumber;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.city = city;
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
        return city != null && !city.isEmpty() && city.length() <= MAX_CITY_LENGTH;
    }


    /**
     * Validates if the provided postal code is not null and has a length of either 5 or 6 characters.
     *
     * @param postalCode The postal code to be validated.
     * @return true if the postal code is valid, false otherwise.
     */
    private boolean isValidPostalCode(final String postalCode)
    {
        return postalCode != null && (postalCode.length() >= MIN_POSTAL_CODE_LENGTH &&
                postalCode.length() <= MAX_POSTAL_CODE_LENGTH);
    }


    /**
     * Validates if the provided street name is not null, not empty, and has a length between 1 and 20 characters.
     *
     * @param streetName The street name to be validated.
     * @return true if the street name is valid, false otherwise.
     */
    private boolean isValidStreetName(final String streetName)
    {
        return streetName != null && !streetName.isEmpty() && streetName.length() <= MAX_STREET_NAME;
    }


    /**
     * Validates if the provided street number is non-negative and does not exceed 999999.
     *
     * @param streetNumber The street number to be validated.
     * @return true if the street number is valid, false otherwise.
     */
    private boolean isValidStreetNumber(final int streetNumber)
    {
        return streetNumber >= MIN_STREET_NUMBER && streetNumber <= MAX_STREET_NUMBER;
    }


    /**
     * Validates if the provided unit number is not empty and has a length not exceeding 4 characters.
     *
     * @param unitNumber The unit number to be validated.
     * @return true if the unit number is valid, false otherwise.
     */
    private boolean isValidUnitNumber(final String unitNumber)
    {
        return unitNumber == null || !unitNumber.isEmpty() && unitNumber.length() <= MAX_UNIT_NUMBER_LENGTH;
    }


    /**
     * Format the address to be printed as a string including all the details.
     * @return string address for print details.
     */
    public String getFullAddress()
    {
        final String fullAddress;

        if(unitNumber != null)
        {
            fullAddress = "unit #" + unitNumber + " at " + streetNumber + " " + getStringTitleCase(streetName) + " " +
                    postalCode.toUpperCase() + " in " + getStringTitleCase(city);
        }
        else
        {
            fullAddress = streetNumber + " " + getStringTitleCase(streetName) + " " +
                    postalCode.toUpperCase() + " in " + getStringTitleCase(city);
        }

        return fullAddress;
    }


    /**
     * Converts a given string to title case, capitalizing the first letter of each word.
     * Whitespace characters are preserved.
     *
     * @param string The input string to be converted to title case.
     * @return The string in title case, or null if the input string is null or empty.
     */
    private String getStringTitleCase(final String string)
    {
        if(string == null || string.isEmpty())
        {
            return null;
        }

        boolean capitalizeNext;
        StringBuilder titleCase;

        capitalizeNext = true;
        titleCase = new StringBuilder();

        for(final char c : string.toCharArray())
        {
            if(Character.isWhitespace(c))
            {
                titleCase.append(c);
                capitalizeNext = true;
            }
            else if(capitalizeNext)
            {
                titleCase.append(Character.toTitleCase(c));
                capitalizeNext = false;
            }
            else
            {
                titleCase.append(Character.toLowerCase(c));
            }
        }

        return titleCase.toString();
    }
}
