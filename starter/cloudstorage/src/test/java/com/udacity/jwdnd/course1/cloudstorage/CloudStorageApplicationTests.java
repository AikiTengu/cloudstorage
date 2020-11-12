package com.udacity.jwdnd.course1.cloudstorage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CloudStorageApplicationTests {

	@LocalServerPort
	private int port;

	private WebDriver driver;

	@BeforeAll
	static void beforeAll() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	public void beforeEach() {
		this.driver = new ChromeDriver();
	}

	@AfterEach
	public void afterEach() {
		if (this.driver != null) {
			driver.quit();
		}
	}

	@Test
	public void getLoginPage() {
		driver.get("http://localhost:" + this.port + "/login");
		Assertions.assertEquals("Login", driver.getTitle());
	}

	@Test
	public void getSignupPage() {
		driver.get("http://localhost:" + this.port + "/signup");
		Assertions.assertEquals("Sign Up", driver.getTitle());
	}

	@Test
	public void wrongLogin() {
		String username = "Teddy";
		String password = "qwerty";

		driver.get("http://localhost:" + this.port + "/login");
		LoginPage loginPage = new LoginPage(driver);

		loginPage.login(username, password);

		try {
		Thread.sleep(5000);
		}
		catch (InterruptedException e){
		};
		//Assertions.assertEquals("Invalid username or password", driver.getClass());
	}

	@Test
	public void SignupLoginLogoutFLow() {
		String userName = "Teddy";
		String firstName = "Teddy";
		String lastName = "Teddy";
		String password = "qwerty";

		driver.get("http://localhost:" + this.port + "/signup");
		SignupPage signupPage = new SignupPage(driver);
		signupPage.signup(firstName, lastName, userName, password);

		try {
			Thread.sleep(5000);
		}
		catch (InterruptedException e){
		};

		driver.get("http://localhost:" + this.port + "/login");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(userName, password);

		try {
			Thread.sleep(5000);
		}
		catch (InterruptedException e) {
		};

		driver.get("http://localhost:" + this.port + "/home");
		HomePage homePage = new HomePage(driver);
		homePage.logout();

		};
		//Assertions.assertEquals("Invalid username or password", driver.getClass());
	}

	//TODO: Test uploading files, viewing files, deleting files,
	// Test adding new notes, viewing notes, deleting notes,
	//Test adding new credentials, viewing credentials, deleting credentials

