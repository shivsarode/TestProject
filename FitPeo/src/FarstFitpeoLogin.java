import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FarstFitpeoLogin {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://fitpeo.com/");
	     driver.findElement(By.xpath("//div[text()='Revenue Calculator']")).click();
	     Thread.sleep(2000);
	     JavascriptExecutor js1 = (JavascriptExecutor) driver;
		 WebElement slider = driver.findElement(By.xpath("//input[contains(@type,'range')]"));
		 js1.executeScript("arguments[0].scrollIntoView(true);", slider);
		 
		 Actions move = new Actions(driver);
		 move.dragAndDropBy(slider, 93, 0).build().perform();
		 Thread.sleep(2000);
		 WebElement textField = driver.findElement(By.xpath("//input[@id=':r0:']"));
		 js1.executeScript("arguments[0].scrollIntoView(true);", textField);
		 textField.sendKeys(Keys.BACK_SPACE);
		 textField.sendKeys(Keys.BACK_SPACE);
		 textField.sendKeys(Keys.BACK_SPACE);
		 textField.sendKeys("560");
		 ExpectedConditions.attributeToBe(slider, "value", "560");  
         System.out.println("Slider position updated correctly to 560.");
         Thread.sleep(3000);
         WebElement Cheakbox63 = driver.findElement(By.xpath("//span[text()='63']"));
         js1.executeScript("arguments[0].scrollIntoView(true);", Cheakbox63);
         Thread.sleep(3000);
         Cheakbox63.click();
         String[] checkboxXpaths = {
                 "//input[@type='checkbox' and @id='CPT-99091']",
                 "//input[@type='checkbox' and @id='CPT-99453']",
                 "//input[@type='checkbox' and @id='CPT-99454']",
                 "//input[@type='checkbox' and @id='CPT-99474']"
             };
         for (String xpath : checkboxXpaths) {
             WebElement checkbox = driver.findElement(By.xpath(xpath));
             if (!checkbox.isSelected()) {
                 checkbox.click();
                 
                 WebElement headerElement = driver.findElement(By.xpath("//header[contains(text(), 'Total Recurring Reimbursement for all Patients Per Month')]"));

                 
                 String displayedValue = headerElement.getText();

                 
                 String expectedValue = "Total Recurring Reimbursement for all Patients Per Month: $110700";

                
                 if (displayedValue.equals(expectedValue)) {
                     System.out.println("Validation Passed: The value is displayed correctly.");
                 } else {
                     System.out.println("Validation Failed: Expected '" + expectedValue + "' but found '" + displayedValue + "'.");
                 }
             }
         }
     }
     
}


