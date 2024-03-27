import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * PropertyReader of BCIT
 *
 * @author Andres Arevalo
 * @version 1.0
 */
public class PropertyReader
{

    /**
     * Reads property data from the given file and adds Strings (for each line) to an ArrayList<String> and returns it.
     *
     * @param file the File object representing the file to read
     * @return an ArrayList of property strings read from the file
     * @throws FileNotFoundException if the specified file is not found
     */
    public static ArrayList<String> readPropertyData(File file) throws FileNotFoundException
    {
        final ArrayList<String> properties;
        final Scanner scanner;
        String propertyString;

        if(!file.isFile())
        {
            throw new FileNotFoundException("File Not Found");
        }

        scanner = new Scanner(file);
        properties = new ArrayList<>();

        while(scanner.hasNext())
        {
            propertyString = scanner.nextLine();
            properties.add(propertyString);
        }

        return properties;
    }
}
