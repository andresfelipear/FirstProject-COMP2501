import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * AddressReader of BCIT
 *
 * @author Andres Arevalo
 * @version 1.0
 */
public class AddressReader
{
    private static final String SPLIT_CHARACTER = "\\|";
    private static final int UNIT_NUMBER = 0;
    private static final int STREET_NUMBER = 1;
    private static final int STREET_NAME = 2;
    private static final int POSTAL_CODE = 3;
    private static final int CITY = 4;

    /**
     * Reads address data from the given file and returns an ArrayList of Address objects.
     *
     * @param file the File object representing the file to read
     * @return an ArrayList of Address objects read from the file
     * @throws FileNotFoundException if the specified file is not found
     */
    public static ArrayList<Address> readAddressData(final File file) throws FileNotFoundException
    {
        final ArrayList<Address> addresses;
        final Scanner scanner;
        String addressString;
        Address address;

        if(!file.isFile())
        {
            throw new FileNotFoundException("File Not Found");
        }

        scanner = new Scanner(file);
        addresses = new ArrayList<>();

        while(scanner.hasNext())
        {
            addressString = scanner.nextLine();
            address = getAddressFromString(addressString);

            addresses.add(address);
        }

        return addresses;
    }


    /**
     * Parses a string representing an address in the format "unitNumber|streetNumber|streetName|postalCode|city"
     * and returns an Address object.
     *
     * @param addressString the string representing the address in the format "unitNumber|streetNumber|streetName|postalCode|city"
     * @return an Address object parsed from the input string
     */
    private static Address getAddressFromString(final String addressString)
    {
        String[] addressArray;
        Address address;

        addressArray = addressString.split(SPLIT_CHARACTER);
        address = new Address(addressArray[UNIT_NUMBER], Integer.parseInt(addressArray[STREET_NUMBER]),
                              addressArray[STREET_NAME], addressArray[POSTAL_CODE], addressArray[CITY]);

        return address;
    }
}
