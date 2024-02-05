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

    public String getUnitNumber()
    {
        return unitNumber;
    }

    public int getStreetNumber()
    {
        return streetNumber;
    }

    public String getStreetName()
    {
        return streetName;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public String getCity()
    {
        return city;
    }

    private boolean isValidCity(final String city)
    {
        return city.length() > 0 && city.length() <= 30;
    }

    private boolean isValidPostalCode(final String postalCode)
    {
        return postalCode.length() == 5 || postalCode.length() == 6;
    }

    private boolean isValidStreetName(final String streetName)
    {
        return streetName.length() > 0 && streetName.length() <= 20;
    }

    private boolean isValidStreetNumber(final int streetNumber)
    {
        return streetNumber >= 0 && streetNumber <= 999999;
    }

    private boolean isValidUnitNumber(final String unitNumber)
    {
        return !unitNumber.isEmpty() && unitNumber.length() <= 4;
    }
}
