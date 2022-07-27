

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class PrintJDBCDrivers {

    public static void main(String[] args) {
        Enumeration<Driver> drives = DriverManager.getDrivers();
        Driver driver;
        do {
            driver = drives.nextElement();
            System.out.println("DRIVE: " + driver.getClass().getCanonicalName() + "VERSÂO: " + driver.getMajorVersion());
        }while (drives.hasMoreElements());
    }
}
