import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Assignment2 of BCIT
 *
 * @author Andres Arevalo
 * @version 1.0
 */
public class Assignment2
{
    private final Scanner scanner;
    private static final String ADDRESSES_FILE_NAME = "address_data.txt";
    private static final String PROPERTIES_FILE_NAME = "property_data.txt";
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
    private static final int OPTION_RESIDENCE_QUERIES = 2;
    private static final int OPTION_COMMERCIAL_QUERIES = 3;
    private static final int OPTION_RETAIL_QUERIES = 4;
    private static final int OPTION_EXIT_PROGRAM = 5;

    private static final int OPTION_BY_PROPERTY_ID = 1;
    private static final int OPTION_BY_PRICE = 2;
    private static final int OPTION_BY_STREET = 3;
    private static final int OPTION_BY_TYPE = 4;
    private static final int OPTION_BACK_MAIN_MENU = 5;

    private static final int OPTION_BY_BEDROOM = 1;
    private static final int OPTION_BY_POOL = 2;
    private static final int OPTION_BY_STRATA = 3;
    private static final int OPTION_EXIT_RESIDENCE_MENU = 4;

    private static final int OPTION_BY_LOADING_DOCK = 1;
    private static final int OPTION_BY_HIGHWAY_ACCESS= 2;
    private static final int OPTION_EXIT_COMMERCIAL_MENU = 3;

    private static final int OPTION_BY_SQUARE_FOOTAGE = 1;
    private static final int OPTION_BY_CUSTOMER_PARKING = 2;
    private static final int OPTION_EXIT_RETAIL_MENU = 3;

    private final Agency agency;

    public Assignment2()
    {
        agency = new Agency("Property Agency");
        scanner = new Scanner(System.in);
    }


    public static void main(final String[] args) throws FileNotFoundException
    {
        try
        {
            Assignment2 assignment2;

            assignment2 = new Assignment2();
            assignment2.init();
            assignment2.doSearch();
        }
        catch(FileNotFoundException fileNotFoundException)
        {
            System.out.println(fileNotFoundException.toString());
        }
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


    /**
     * This method provides the primary user interface through command prompts
     * that will allow the user to choose which search operations to perform.
     * The method prompts the user to select a query category (General, Residence, Commercial, Retail)
     * and performs corresponding property searches.
     */
    public void doSearch()
    {
        int mainMenuOption;
        int generalQueriesOption;
        int residenceQueriesOption;
        int commercialQueriesOption;
        int retailQueriesOption;

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

            if(mainMenuOption == OPTION_EXIT_PROGRAM)
            {
                System.out.println("Goodbye for now!");
                break;
            }

            while(true)
            {
                if(mainMenuOption == OPTION_GENERAL_QUERIES)
                {
                    System.out.println("General Queries");
                    System.out.println("\t1. By Property Id\n" +
                                               "\t2. By Price\n" +
                                               "\t3. By Street\n" +
                                               "\t4. By Type\n" +
                                               "\t5. Back");

                    generalQueriesOption = Integer.parseInt(scanner.next());

                    if(generalQueriesOption == OPTION_BACK_MAIN_MENU)
                    {
                        break;
                    }

                    processGeneralQueries(generalQueriesOption);
                }
                else if(mainMenuOption == OPTION_RESIDENCE_QUERIES)
                {
                    System.out.println("Residence Queries");
                    System.out.println("\t1. By Bedroom\n" +
                                               "\t2. By Pool\n" +
                                               "\t3. By Strata\n" +
                                               "\t4. Back");

                    residenceQueriesOption = scanner.nextInt();

                    if(residenceQueriesOption == OPTION_EXIT_RESIDENCE_MENU)
                    {
                        break;
                    }

                    processResidenceQueries(residenceQueriesOption);

                }
                else if(mainMenuOption == OPTION_COMMERCIAL_QUERIES)
                {
                    System.out.println("Commercial Queries");
                    System.out.println("\t1. By Loading Dock\n" +
                                               "\t2. By Highway Access\n" +
                                               "\t3. Back");

                    commercialQueriesOption = scanner.nextInt();

                    if(commercialQueriesOption == OPTION_EXIT_COMMERCIAL_MENU)
                    {
                        break;
                    }

                    processCommercialQueries(commercialQueriesOption);
                }
                else if(mainMenuOption == OPTION_RETAIL_QUERIES)
                {
                    System.out.println("Retail Queries");
                    System.out.println("\t1. By Square Footage\n" +
                                               "\t2. By Customer Parking\n" +
                                               "\t3. Back");

                    retailQueriesOption = scanner.nextInt();

                    if(retailQueriesOption == OPTION_EXIT_RETAIL_MENU)
                    {
                        break;
                    }

                    processRetailQueries(retailQueriesOption);
                }
                else
                {
                    System.out.println("Invalid Option. Try Again!");
                }
            }

        }
    }


    /**
     * Processes retail queries based on the selected option.
     *
     * @param retailQueriesOption the selected retail query option
     */
    private void processRetailQueries(final int retailQueriesOption)
    {
        final ArrayList<Retail> propertiesWithSquareFootage;
        final ArrayList<Retail> propertiesWithCustomerParking;
        final int minSquareFootage;

        if(retailQueriesOption == OPTION_BY_SQUARE_FOOTAGE)
        {
            System.out.println("Enter min square footage: ");
            minSquareFootage = scanner.nextInt();

            propertiesWithSquareFootage = agency.getPropertiesSquareFootage(minSquareFootage);

            System.out.println("Retail properties with minimum square footage of: " + minSquareFootage);

            for(Property propertyWithSquareFootage : propertiesWithSquareFootage)
            {
                System.out.println(propertyWithSquareFootage);
            }
        }
        else if(retailQueriesOption == OPTION_BY_CUSTOMER_PARKING)
        {
            propertiesWithCustomerParking = agency.getPropertiesWithCustomerParking();
            System.out.println("Retail Properties with Customer Parking");

            if(propertiesWithCustomerParking == null)
            {
                System.out.println("There are not properties with customer parking");
            }
            else
            {
                for(Property propertyWithCustomerParking : propertiesWithCustomerParking)
                {
                    System.out.println(propertyWithCustomerParking);
                }
            }
        }
        else
        {
            System.out.println("Invalid Option. Try Again!");
        }
    }


    /**
     * Processes commercial queries based on the selected option.
     *
     * @param commercialQueriesOption the selected commercial query option
     */
    private void processCommercialQueries(final int commercialQueriesOption)
    {
        final ArrayList<Commercial> propertiesWithLoadingDock;
        final ArrayList<Commercial> propertiesWithHighwayAccess;

        if(commercialQueriesOption == OPTION_BY_LOADING_DOCK)
        {
            propertiesWithLoadingDock = agency.getPropertiesWithLoadingDocks();
            System.out.println("Commercial Properties with Loading Dock");

            for(Property propertyWithLoadingDock : propertiesWithLoadingDock)
            {
                System.out.println(propertyWithLoadingDock);
            }
        }
        else if(commercialQueriesOption == OPTION_BY_HIGHWAY_ACCESS)
        {
            propertiesWithHighwayAccess = agency.getPropertiesWithHighwayAccess();
            System.out.println("Commercial Properties with Highway Access");

            for(Property propertyWithHighwayAccess : propertiesWithHighwayAccess)
            {
                System.out.println(propertyWithHighwayAccess);
            }
        }
        else
        {
            System.out.println("Invalid Option. Try Again!");
        }
    }


    /**
     * Processes residence queries based on the selected option.
     *
     * @param residenceQueriesOption the selected residence query option
     */
    private void processResidenceQueries(final int residenceQueriesOption)
    {
        final int minNumberBedrooms;
        final int maxNumberBedrooms;
        final HashMap<String, Residence> propertiesWithBedrooms;
        final List<Residence> propertiesWithPool;
        final ArrayList<Residence> propertiesWithStata;

        if(residenceQueriesOption == OPTION_BY_BEDROOM)
        {
            System.out.print("Enter min number of bedrooms: ");
            minNumberBedrooms = scanner.nextInt();

            System.out.print("Enter max number of bedrooms: ");
            maxNumberBedrooms = scanner.nextInt();

            propertiesWithBedrooms = agency.getPropertiesWithBedrooms(minNumberBedrooms, maxNumberBedrooms);

            for(Property propertyWithBedrooms : propertiesWithBedrooms.values())
            {
                System.out.println(propertyWithBedrooms);
            }
        }
        else if(residenceQueriesOption == OPTION_BY_POOL)
        {
            propertiesWithPool = agency.getPropertiesWithPools();
            System.out.println("Residences with swimming pool: ");

            for(Property propertyWithPool : propertiesWithPool)
            {
                System.out.println(propertyWithPool);
            }
        }
        else if(residenceQueriesOption == OPTION_BY_STRATA)
        {
            propertiesWithStata = agency.getPropertiesWithStrata();
            System.out.println("Residences with strata: ");

            for(Property propertyWithStrata : propertiesWithStata)
            {
                System.out.println(propertyWithStrata);
            }
        }
        else
        {
            System.out.println("Invalid Option. Try Again!");
        }
    }


    /**
     * Processes general queries based on the selected option.
     *
     * @param generalQueriesOption the selected general query option
     */
    private void processGeneralQueries(final int generalQueriesOption)
    {
        final String propertyId;
        final Property property;
        final double minPrice;
        final double maxPrice;
        final String streetName;
        final String propertyType;

        final Property[] propertiesBetween;
        final List<Address> propertiesAddressOn;
        final ArrayList<Property> propertiesOfType;

        if(generalQueriesOption == OPTION_BY_PROPERTY_ID)
        {
            System.out.print("Enter property id: ");
            propertyId = scanner.next();
            property = agency.getProperty(propertyId);

            System.out.println(property);
        }
        else if(generalQueriesOption == OPTION_BY_PRICE)
        {
            System.out.print("Enter Min property price: $");
            minPrice = Double.parseDouble(scanner.next());

            System.out.print("Enter Max property price: $");
            maxPrice = Double.parseDouble(scanner.next());

            propertiesBetween = agency.getPropertiesBetween(minPrice, maxPrice);

            System.out.format("Find next the properties between %.2f and %.2f", minPrice, maxPrice);
            for(Property propertyBetween : propertiesBetween)
            {
                System.out.println(propertyBetween);
            }
        }
        else if(generalQueriesOption == OPTION_BY_STREET)
        {
            System.out.print("Enter the Street name: ");
            streetName = scanner.next();
            propertiesAddressOn = agency.getPropertiesOn(streetName);

            System.out.println("Property addresses on " + streetName);
            for(Address addressOn : propertiesAddressOn)
            {
                System.out.println(addressOn);
            }
        }
        else if(generalQueriesOption == OPTION_BY_TYPE)
        {
            System.out.print("Please enter the property type: ");
            propertyType = scanner.next();

            propertiesOfType = agency.getPropertiesOfType(propertyType);
            for(Property propertyOfType : propertiesOfType)
            {
                System.out.println(propertyOfType);
            }
        }
        else
        {
            System.out.println("Invalid Option. Try Again!");
        }
    }


    /**
     * Parses a string representing a property and creates a Property object from it.
     *
     * @param propertyString the string representing the property
     * @param address the address associated with the property
     * @return a Property object parsed from the input string
     */
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
