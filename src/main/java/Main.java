import org.apache.commons.cli.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException
    {
        CLParser clParser = new CLParser(args);
        CommandLine cmd = clParser.getCmd();
        String page = cmd.getOptionValue("uri");

        WebDriver driver = Driver.getDriver();
        try {

            driver.get(page);

            List<WebElement> elements = driver.findElements(By.xpath("//li[contains(@class,'size-selector__size-list-item')]"));
            WebElement singleStuff = driver.findElement(By.xpath("//div[contains(@class,'button__lines-wrapper')]/span"));


            if (elements != null && elements.size() != 0) {
                for (WebElement el : elements) {
                    boolean isOutgOfStock = el.getAttribute("disabled") != null;
                    if (isOutgOfStock) System.out.println(" " + el.getText() + " is Disabled");
                    else System.out.println(" " + el.getText() + " is Enabled");
                }
            } else {
                String text = singleStuff.getText();
                if (text.contains("Dodaj do koszyka")) System.out.println("enabled");
                else System.out.println("disabled");
            }
        } finally {
            driver.quit();
        }
    }
}
