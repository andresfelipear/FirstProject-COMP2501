import java.io.File;

/**
 * Main of BCIT
 *
 * @author Andres Arevalo
 * @version 1.0
 */
public class Main
{
    public static void main(final String[] args)
    {
        File file = new File("address_data.txt");

        try
        {
            System.out.println(AddressReader.readAddressData(file));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
