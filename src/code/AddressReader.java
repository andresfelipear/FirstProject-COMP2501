import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * AddressReader
 *
 * @author user
 * @version 1.0
 */
public class AddressReader
{
    public static ArrayList<Address> addresses;

    public AddressReader()
    {
        addresses = new ArrayList<>();
    }

    public static ArrayList<Address> readAddressData(final File file) throws FileNotFoundException
    {
        final Scanner scanner;
        String addressString;
        Address address;

        if(!file.isFile())
        {
            throw new FileNotFoundException("File Not Found");
        }

        scanner = new Scanner(file);

        while(scanner.hasNext())
        {
            addressString = scanner.nextLine();
            address = getAddressFromString(addressString);
        }




    }

    private static Address getAddressFromString(final String addressString)
    {
        String[] addressArray;
        addressArray = addressString.split("\\|");

    }
}
