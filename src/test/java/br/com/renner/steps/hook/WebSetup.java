package br.com.renner.steps.hook;

import br.com.renner.robots.SeleniumRobotsTool;
import br.com.renner.robots.builder.SeleniumRobotsBuilder;
import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.CustomField;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResultFactory;
import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.*;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.Result;
import io.cucumber.plugin.event.TestCase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static br.com.renner.toolbox.GlobalTools.*;
import static br.com.renner.toolbox.RennerTools.*;

public class WebSetup {

    public static SeleniumRobotsTool seleniumRobotsTool;
    public static WebDriver driver;
    public static String baseUrl = getExecutionUrl();
    public static String build = "";
    public static String scenarioName;
    public static Scenario scenario;
    ReportiumClient reportiumClient;
    private int indexStep = 0;


    @AfterAll()
    public static void teardDownAll() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Before()
    public void initiate(Scenario scenarioTest) throws MalformedURLException {

        System.out.printf("TESTE %s is started%n", scenarioTest.getName());
        scenarioName = scenarioTest.getName().replaceAll("-", " ");
        scenario = scenarioTest;
        if (build.isEmpty()) {
            build = "Web-YouCom-Regressivo-" + getExecutionAmbiente();
        }

        switch (getExecutionNavegador()) {
            case "chrome": {
                System.out.println("Chrome");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--window-size=1366,768");
                chromeOptions.addArguments("--disable-notifications");

                WebDriverManager.chromedriver()
                        .cachePath("src/test/resources/drivers")
                        .setup();

                seleniumRobotsTool = new SeleniumRobotsBuilder()
                        .timeoutSeconds(1)
                        .pollingSeconds(1)
                        .setChromeOptions(chromeOptions)
                        .build();
                driver = seleniumRobotsTool.getDriver();
                break;
            }
            case "edge": {
                System.out.println("Edge");
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                seleniumRobotsTool = new SeleniumRobotsBuilder()
                        .pollingSeconds(5)
                        .timeoutSeconds(30)
                        .edge()
                        .build();
                break;
            }
            case "opera": {
                System.out.println("Opera");
                WebDriverManager.operadriver().setup();
                WebDriverManager.operadriver().setup();
                seleniumRobotsTool = new SeleniumRobotsBuilder()
                        .pollingSeconds(5)
                        .timeoutSeconds(30)
                        .build();
                break;
            }
            case "firefox": {
                System.out.println("Firefox");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                seleniumRobotsTool = new SeleniumRobotsBuilder()
                        .pollingSeconds(5)
                        .timeoutSeconds(30)
                        .firefox()
                        .build();
                break;
            }
            case "remote": {
                System.out.println("Remote Chrome");
                WebDriverManager.chromedriver().setup();
                HashMap<String, Object> chromePrefs = new HashMap<>();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.prompt_for_download", "false");
                chromePrefs.put("plugins.plugins_disabled", new String[]{"Adobe Flash Player", "Chrome PDF Viewer"});
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", chromePrefs);
                options.addArguments("--lang=pt");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--aggressive-cache-discard");
                options.addArguments("--disable-cache");
                options.addArguments("--disable-application-cache");
                options.addArguments("--disable-offline-load-stale-cache");
                options.addArguments("--disk-cache-size=0");
                options.addArguments("--disable-gpu");
                options.addArguments("--dns-prefetch-disable");
                options.addArguments("--no-proxy-server");
                options.addArguments("--log-level=3");
                options.addArguments("--silent");
                options.addArguments("--disable-browser-side-navigation");
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                options.setAcceptInsecureCerts(true);
                System.setProperty("webdriver.chrome.silentOutput", "true");

                driver = new RemoteWebDriver(new java.net.URL("http://localhost:4444/wd/hub"), options);
                seleniumRobotsTool = new SeleniumRobotsBuilder()
                        .pollingSeconds(5)
                        .timeoutSeconds(30)
                        .remoteExec("http://localhost:4444/wd/hub")
                        .chrome()
                        .setChromeOptions(options)
                        .build();
                break;
            }
            case "perfecto": {
                System.out.println("Perfecto Chrome");
                WebDriverManager.chromedriver().setup();
                HashMap<String, Object> chromePrefs = new HashMap<>();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.prompt_for_download", "false");
                chromePrefs.put("plugins.plugins_disabled", new String[]{"Adobe Flash Player", "Chrome PDF Viewer"});
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", chromePrefs);
                options.addArguments("--disable-notifications");
                options.addArguments("--lang=pt");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--aggressive-cache-discard");
                options.addArguments("--disable-cache");
                options.addArguments("--disable-application-cache");
                options.addArguments("--disable-offline-load-stale-cache");
                options.addArguments("--disk-cache-size=0");
                options.addArguments("--disable-gpu");
                options.addArguments("--dns-prefetch-disable");
                options.addArguments("--no-proxy-server");
                options.addArguments("--log-level=3");
                options.addArguments("--silent");
                options.addArguments("--disable-browser-side-navigation");
                options.setAcceptInsecureCerts(true);
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

                Map<String, Object> perfectoOptions = new HashMap<>();
                perfectoOptions.put("browserName", "Chrome");
                perfectoOptions.put("browserVersion", "127");
                perfectoOptions.put("location", "US East");
                perfectoOptions.put("platformName", "Windows");
                perfectoOptions.put("platformVersion", "10");
                perfectoOptions.put("resolution", "1366x768");
                perfectoOptions.put("securityToken", getTokenPerfecto());

                options.setCapability("perfecto:options", perfectoOptions);
                System.setProperty("webdriver.chrome.silentOutput", "true");

                driver = new RemoteWebDriver(new java.net.URL(getUrlPerfecto()), options);
                seleniumRobotsTool = new SeleniumRobotsBuilder()
                        .pollingSeconds(5)
                        .timeoutSeconds(30)
                        .remoteExec(getUrlPerfecto())
                        .chrome()
                        .setChromeOptions(options)
                        .build();

                indexStep = 0;
                break;
            }
            default:
                throw new IllegalArgumentException("Navegador '" + getExecutionNavegador() + "' não suportado.");
        }

        if (getExecutionNavegador().equalsIgnoreCase("perfecto")) {
            String tags = String.join(", ", scenarioTest.getSourceTagNames());
            if (reportiumClient == null) {
                PerfectoExecutionContext perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                        .withProject(new Project("Web-YouCom-Regressivo-" + getExecutionAmbiente(), "1.0.0"))
                        .withJob(new Job(build, Integer.parseInt(System.getProperty("buildNumber", "1"))))
                        .withWebDriver(driver)
                        .build();
                reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(perfectoExecutionContext);
            }

            reportiumClient.testStart(scenarioName, new TestContext.Builder()
                    .withTestExecutionTags(tags)
                    .withCustomFields(new CustomField("ambiente", getExecutionAmbiente()))
                    .build());
        }

        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        if (driver != null && !driver.getWindowHandles().isEmpty()) {
            driver.switchTo().window(driver.getWindowHandle());
        }

        if (getExecutionNavegador().equalsIgnoreCase("perfecto")) {
            driver.manage().window().maximize();
        }
    }

    @BeforeStep()
    public void beforeStep(Scenario scenario) {
        if (getExecutionNavegador().equalsIgnoreCase("perfecto")) {
            reportiumClient.stepStart(getCurrentStep(scenario));
        }
    }

    public String getCurrentStep(Scenario scenario) {
        try {
            Field delegate = scenario.getClass().getDeclaredField("delegate");
            delegate.setAccessible(true);
            TestCaseState testCaseState = (TestCaseState) delegate.get(scenario);

            Field testCaseField = testCaseState.getClass().getDeclaredField("testCase");
            testCaseField.setAccessible(true);
            TestCase testCase = (TestCase) testCaseField.get(testCaseState);

            List<PickleStepTestStep> testStepTitles = testCase.getTestSteps()
                    .stream()
                    .filter(step -> step instanceof PickleStepTestStep)
                    .map(step -> (PickleStepTestStep) step)
                    .collect(Collectors.toList());

            PickleStepTestStep stepTestStep = testStepTitles.get(indexStep);
            indexStep = indexStep + 1;
            return stepTestStep != null ? stepTestStep.getStep().getText() : "";
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return "";
    }

    @AfterStep()
    public void afterStep(Scenario scenario) {
        if (getExecutionNavegador().equalsIgnoreCase("perfecto")) {
            reportiumClient.stepEnd();
        }
    }

    @After()
    public void tearDown(Scenario scenario) throws IOException {
        System.out.printf("TESTE %s is %s%n", scenario.getName(), scenario.getStatus().name());

        if (driver != null) {
            try {
                if (!driver.getWindowHandles().isEmpty()) {
                    tirarPrint(scenario);
                }
            } catch (NoSuchWindowException e) {
                System.out.println("Janela fechada, não foi possível tirar o print.");
            }
        }

        if (getExecutionNavegador().equalsIgnoreCase("perfecto") && reportiumClient != null) {
            reportiumClient.testStop(scenario.isFailed()
                    ? TestResultFactory.createFailure(getFailureMessage(scenario))
                    : TestResultFactory.createSuccess());

            String reportURL = reportiumClient.getReportUrl();
            System.out.println("Report URL - " + reportURL);
        }

        try {
            if (driver != null && !driver.getWindowHandles().isEmpty()) {
                deletarCookies();
            }
        } catch (NoSuchWindowException e) {
            System.out.println("Janela fechada, não foi possível deletar os cookies.");
        }

        try {
            if (driver != null && !driver.toString().contains("null")) {
                driver.quit();
                driver = null;
            }
        } catch (NoSuchSessionException e) {
            System.out.println("Sessão já foi finalizada.");
        }
        indexStep = 0;
    }

    public String getFailureMessage(Scenario scenario) {
        Result failResult = null;
        try {
            Field delegate = scenario.getClass().getDeclaredField("delegate");
            delegate.setAccessible(true);
            TestCaseState testCaseState = (TestCaseState) delegate.get(scenario);

            Field stepResults = testCaseState.getClass().getDeclaredField("stepResults");
            stepResults.setAccessible(true);
            List<Result> results = (List<Result>) stepResults.get(testCaseState);

            for (Result result : results) {
                if (result.getStatus().name().equalsIgnoreCase("FAILED")) {
                    failResult = result;
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return (failResult != null) ? failResult.getError().getMessage() : "";
    }
}