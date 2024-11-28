package com.omrBranch.baseClass;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;
	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Properties;
	import java.util.Set;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxBinary;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.openqa.selenium.safari.SafariDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import net.masterthought.cucumber.json.Output;


		

	public class BaseClass {

		public static WebDriver driver;
		Select select;

	
		RequestSpecification reqSpec;
		Response response;
		
		public void addHeaders(Headers headers) {
			reqSpec = RestAssured.given().headers(headers);
		}
		

		public void addHeader(String key, String value) {
			reqSpec = RestAssured.given().header(key, value);
		}
		public void addBasicAuth(String username,String password) {
			reqSpec = reqSpec.auth().preemptive().basic(username, password);
		}
		public void addBody(Object body) {
			reqSpec  = reqSpec.body(body);
		}
		

		public void addBody(String body) {
			reqSpec = reqSpec.body(body);
		}

		public Response addReqType(String type, String endpoint) {
			switch (type) {
			case "GET":
				response = reqSpec.get(endpoint);
				break;
			case "POST":
				response = reqSpec.post(endpoint);
				break;
			case "PUT":
				response = reqSpec.log().all().put(endpoint);
				break;
			case "PATCH":
				response = reqSpec.patch(endpoint);
				break;
			case "DELETE":
				response = reqSpec.delete(endpoint);
				break;

			default:
				break;
			}

			return response;
		}
	
		public int getStatusCode(Response response) {
			int statusCode = response.getStatusCode();
			return statusCode;
		}

		public String getResBodyAsString(Response response) {
			String asString = response.asString();
			return asString;
		}

		public String getResBodyAsPrettyString(Response response) {
			String asPrettyString = response.asPrettyString();
			return asPrettyString;
		}




	public byte[] screenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] b = screenshot.getScreenshotAs(OutputType.BYTES);
		return b;
	}

	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "\\config\\Config.properties"));

		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}

	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}

	public void elementSendKeysEnter(WebElement element, String data) {
		elementVisibility(element);

		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			element.sendKeys(data, Keys.ENTER);
		}
	}

	public void pressEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();

	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();

	}

	public void promptAlert(String data) {
		driver.switchTo().alert().sendKeys(data);
	}

	public List<String> getAllOptionsText(WebElement element) {
		List<String> lstText = new ArrayList<>();
		select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement webElement : options) {
			String text = webElement.getText();
			lstText.add(text);

		}
		return lstText;
	}

	public void switchToChildWindow() {
		String pWindow = driver.getWindowHandle();
		Set<String> allWindowsId = driver.getWindowHandles();

		for (String eachWindowId : allWindowsId) {
			if (!pWindow.equals(eachWindowId)) {
				driver.switchTo().window(eachWindowId);
			}
		}
	}

	// public String
	// getProjectPath("C:\\Users\\vishn\\OneDrive\\Desktop\\eclipse\\OmrHotel") {
	// String property = System.getProperty("user.dir");
	// return property;
	// }

	public void screenshot(WebElement element, String sName) throws IOException {
		File s = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(s, new File(getProjectPath() + "\\images\\" + sName + ".png"));
	}

	public void screenshot(String sName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(s, new File(getProjectPath() + "\\images\\" + sName + ".png"));
	}

	public void elementClear(WebElement element) {
		elementVisibility(element);
		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			element.clear();
		}

	}

	public void elementVisibility(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driverWait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void implicitWait(int secs) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	public static void browserLaunch() {
		driver = new ChromeDriver();
	}

	public static void enterApplnUrl(String url) {
		driver.get(url);

	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void elementSendKeys(WebElement element, String data) {
		elementVisibility(element);

		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			element.sendKeys(data);
		}
	}

	public void elementSendKeysJs(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}

	public void elementClick(WebElement element) {
		elementVisibility(element);
		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			element.click();
		}
	}

	public String getApplnTitle() {
		String title = driver.getTitle();
		return title;
	}

	public WebElement findLocatorById(String attributeValue) {
		WebElement findElement = driver.findElement(By.id(attributeValue));
		return findElement;
	}

	public WebElement findLocatorByName(String attributeValue) {
		WebElement findElement = driver.findElement(By.name(attributeValue));
		return findElement;
	}

	public WebElement findLocatorByClassName(String attributeValue) {
		WebElement findElement = driver.findElement(By.className(attributeValue));
		return findElement;
	}

	public WebElement findLocatorByXpath(String attributeValue) {
		WebElement findElement = driver.findElement(By.xpath(attributeValue));
		return findElement;
	}

	public String getAppnUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void closeWindow() {
		driver.close();
	}

	public static void quitWindow() {
		driver.quit();
	}

	public boolean elementIsEnabled(WebElement element) {
		elementVisibility(element);
		boolean enabled = element.isEnabled();
		return enabled;
	}

	public boolean elementIsDisplayed(WebElement element) {
		elementVisibility(element);
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	public boolean elementIsSelected(WebElement element) {
		elementVisibility(element);
		boolean selected = element.isSelected();
		return selected;
	}

	public String elementGetText(WebElement element) {
		elementVisibility(element);
		String text = element.getText();
		return text;
	}

	// 99%--->value fixed
	public String elementGetAttributeValue(WebElement element) {
		elementVisibility(element);
		String attribute = null;
		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			attribute = element.getAttribute("value");
		}
		return attribute;

	}

	// 1%--->value is NOT fixed
	public String elementGetAttributeValue(WebElement element, String attributeName) {
		elementVisibility(element);
		String attribute = null;
		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			attribute = element.getAttribute(attributeName);
		}
		return attribute;
	}

	public void selectOptionByText(WebElement element, String text) {

		elementVisibility(element);
		select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectOptionByValue(WebElement element, String text) {
		elementVisibility(element);
		select = new Select(element);
		select.selectByValue(text);
	}

	public void selectOptionByIndex(WebElement element, int index) {
		elementVisibility(element);
		select = new Select(element);
		select.selectByIndex(index);
	}

	public static void browserLaunch(String browserType) {
		switch (browserType) {
		case "CHROME":
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			driver = new FirefoxDriver();
			break;
		case "IE":
			driver = new InternetExplorerDriver();
			break;
		case "EDGE":
			driver = new EdgeDriver();
			break;
		case "SAFARI":
			driver = new SafariDriver();
			break;

		default:
			break;
		}

	}

}

	




