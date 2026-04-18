package utils;

import drivers.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.nio.file.Files;

public class ScreenshotUtil {

    public static void takeScreenshot(String name) {
        try {
            File directory = new File("target/screenshots");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            File src = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            Files.copy(src.toPath(),
                    new File("target/screenshots/" + name + ".png").toPath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}