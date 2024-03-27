import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Assignment2 of BCIT
 *
 * @author Andres Arevalo
 * @version 1.0
 */
public class Assignment2
{
    private static final String ADDRESSES_FILE_NAME = "address_data.txt";
    private static final String PROPERTIES_FILE_NAME = "property_data";
    private static final String SPLIT_CHARACTER = "\\|";

    private static final int RESIDENCE_PRICE_USD = 0;
    private static final int NUMBER_OF_BEDROOMS = 1;
    private static final int SWIMMING_POOL = 2;
    private static final int RESIDENCE_TYPE = 3;
    private static final int RESIDENCE_PROPERTY_ID = 4;
    private static final int STRATA = 5;

    private static final int RETAIL_PRICE_USD = 0;
    private static final int RETAIL_TYPE = 1;
    private static final int RETAIL_PROPERTY_ID = 2;
    private static final int SQUARE_FOOTAGE = 3;
    private static final int CUSTOMER_PARKING = 4;


    private final Agency agency;

    public Assignment2()
    {
        agency = new Agency("Property Agency");
    }


    public void init() throws FileNotFoundException
    {
        final ArrayList<Address> addresses;
        final ArrayList<String> stringProperties;
        final File addressesFile;
        final File propertiesFile;

        addressesFile = new File(ADDRESSES_FILE_NAME);
        propertiesFile = new File(PROPERTIES_FILE_NAME);

        addresses = AddressReader.readAddressData(addressesFile);
        stringProperties = PropertyReader.readPropertyData(propertiesFile);


    }

    private static Property getPropertyFromString(final String propertyString, final Address address)
    {
        String[] propertyArray;
        Property property;

        propertyArray = propertyString.split(SPLIT_CHARACTER);

        if(propertyString.contains("residence"))
        {
            property = new Residence(Double.parseDouble(propertyArray[RESIDENCE_PRICE_USD]), address,
                                     Integer.parseInt(propertyArray[NUMBER_OF_BEDROOMS]),
                                     Boolean.parseBoolean(propertyArray[SWIMMING_POOL]),
                                     propertyArray[RESIDENCE_TYPE],
                                     propertyArray[RESIDENCE_PROPERTY_ID],
                                     Boolean.parseBoolean(propertyArray[STRATA]));
        }
        else if(propertyString.contains("retail"))
        {
            property = new Retail(Double.parseDouble(propertyArray[RETAIL_PRICE_USD]), address, propertyArray[RETAIL_TYPE],
                                  propertyArray[RETAIL_PROPERTY_ID], propertyArray[SQUARE_FOOTAGE],
                                  propertyArray[CUSTOMER_PARKING]);
        }
        else if(propertyString.contains("commercial"))
        {
            property = new Commercial(propertyArray[COMMERCIAL_PRICE_USD], address, propertyArray[COMMERCIAL_TYPE],
                                      propertyArray[COMMERCIAL_PROPERTY_ID], propertyArray[LOADING_DOCK],
                                      propertyArray[HIGHWAY_ACCESS]);
        }
        else
        {
            return null;
        }

        property = new Property()
    }
}
