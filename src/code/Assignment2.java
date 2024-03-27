import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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

    private static final int COMMERCIAL_PRICE_USD = 0;
    private static final int COMMERCIAL_TYPE = 1;
    private static final int COMMERCIAL_PROPERTY_ID = 2;
    private static final int LOADING_DOCK = 3;
    private static final int HIGHWAY_ACCESS = 4;

    private static final int OPTION_GENERAL_QUERIES = 1;


    private final Agency agency;

    public Assignment2()
    {
        agency = new Agency("Property Agency");
    }


    /**
     * This method gets the ArrayList,<Address> and ArrayList<String> form AddressReader and PropertyReader,
     * and uses them to create subtype Objects and adds them to the Agency.HashMap<String, Property> properties.
     * @throws FileNotFoundException If addressFile or property file is not found throws and exception.
     */
    public void init() throws FileNotFoundException
    {
        final ArrayList<Address> addresses;
        final ArrayList<String> stringProperties;
        final File addressesFile;
        final File propertiesFile;
        Address address;
        String propertyString;
        Property property;

        addressesFile = new File(ADDRESSES_FILE_NAME);
        propertiesFile = new File(PROPERTIES_FILE_NAME);

        addresses = AddressReader.readAddressData(addressesFile);
        stringProperties = PropertyReader.readPropertyData(propertiesFile);

        for(int i = 0; i < stringProperties.size(); i++)
        {
            propertyString = stringProperties.get(i);
            address = addresses.get(i);

            property = getPropertyFromString(propertyString, address);

            agency.addProperty(property);
        }
    }


    public void doSearch()
    {
        Scanner scanner;
        int mainMenuOption;
        scanner = new Scanner(System.in);

        while(true)
        {
            System.out.println("Welcome to our Property search. ");
            System.out.println("Choose one of the following options: ");
            System.out.println("\t1. General Queries\n" +
                                       "\t2. Residence Queries\n" +
                                       "\t3. Commercial Queries\n" +
                                       "\t4. Retail Queries\n" +
                                       "\t5. Exit");

            mainMenuOption = Integer.parseInt(scanner.next());

            while(true)
            {

            }
            if(mainMenuOption == OPTION_GENERAL_QUERIES)
            {
                System.out.println("General Queires");
                System.out.println("\t1. By Property Id\n" +
                                           "\t2. By Price\n" +
                                           "\t3. By Street\n" +
                                           "\t4. By Type\n" +
                                           "\t5. Back");

            }

        }
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
                                  propertyArray[RETAIL_PROPERTY_ID], Integer.parseInt(propertyArray[SQUARE_FOOTAGE]),
                                  Boolean.parseBoolean(propertyArray[CUSTOMER_PARKING]));
        }
        else if(propertyString.contains("commercial"))
        {
            property = new Commercial(Double.parseDouble(propertyArray[COMMERCIAL_PRICE_USD]), address,
                                      propertyArray[COMMERCIAL_TYPE], propertyArray[COMMERCIAL_PROPERTY_ID],
                                      Boolean.parseBoolean(propertyArray[LOADING_DOCK]), Boolean.parseBoolean(propertyArray[HIGHWAY_ACCESS]));
        }
        else
        {
            return null;
        }

        return property;
    }
}
