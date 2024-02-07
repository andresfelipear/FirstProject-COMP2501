import java.util.ArrayList;

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
        Agency agency;

        agency = new Agency("BCIT Ltd");

        Address a1 = new Address("1a", 777, "56th avenue", "v7n2m8", "surrey");
        Property p1 = new Property(499000.00, a1, 2, false, "residence", "abc123");

        Address a2 = new Address(null, 123, "main street", "v7r2g2", "west vancouver");
        Property p2 = new Property(5999999.00, a2, 5, true, "residence", "xyz789");

        Address a3 = new Address(null, 456, "elm street", "90210", "los angeles");
        Property p3 = new Property(2500000.00, a3, 6, true, "residence", "777def");

        Address a4 = new Address("44", 1111, "maple street", "v8y3r5", "vancouver");
        Property p4 = new Property(1000000.00, a4, 1, false, "retail", "876tru");

        Address a5 = new Address("9", 99, "gretzky way", "t6v7h3", "toronto");
        Property p5 = new Property(99999.00, a5, 1, false, "commercial", "9999");

        Address a6 = new Address("b", 711, "country road", "v8h5f5", "maple ridge");
        Property p6 = new Property(740100.00, a6, 3, false, "residence", "mr6789");

        Address a7 = new Address(null, 8785, "pinnacle avenue", "v9u3h3", "north vancouver");
        Property p7 = new Property(15000000.00, a7, 20, true, "residence", "78444a");

        Address a8 = new Address(null, 800, "elm street", "90557", "los angeles");
        Property p8 = new Property(7100000.00, a8, 10, false, "residence", "mmm33");

        Address a9 = new Address(null, 1515, "main street", "v8y7r3", "west vancouver");
        Property p9 = new Property(4000000.00, a9, 2, true, "commercial", "678T");

        Address a10 = new Address("6", 60, "60th street", "v8u9b1", "burnaby");
        Property p10 = new Property(700000.00, a10, 2, true, "retail", "y6yyy");

        Address a11 = new Address("7h", 1500, "railway avenue", "v9v5v4", "richmond");
        Property p11 = new Property(840000.00, a11, 4, false, "commercial", "A1212");

        Address a12 = new Address(null, 333, "elm street", "90111", "los angeles");
        Property p12 = new Property(1600000.00, a12, 3, false, "residence", "9000a");


        agency.addProperty(p1);
        agency.addProperty(p2);
        agency.addProperty(p3);
        agency.addProperty(p4);
        agency.addProperty(p5);
        agency.addProperty(p6);
        agency.addProperty(p7);
        agency.addProperty(p8);
        agency.addProperty(p9);
        agency.addProperty(p10);
        agency.addProperty(p11);
        agency.addProperty(p12);

        ArrayList<String> agencyData = agency.getPropertiesOfType("cOmmercial");
        System.out.println("the size of the array: " + agencyData.size());

        for(String string: agencyData)
        {
            System.out.print(string);
        }
    }

}
