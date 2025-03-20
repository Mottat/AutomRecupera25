package br.com.renner.toolbox;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static br.com.renner.steps.hook.WebSetup.*;

public class RennerTools {

    private static final Duration MAX_DURATION = Duration.ofSeconds(30L);
    private static final Duration POOL_DURATION = Duration.ofSeconds(2L);

    public static void trocarParaNovaJanela() {
        String janelaOriginal = driver.getWindowHandle();
        for (String janela : driver.getWindowHandles()) {
            if (!janela.equals(janelaOriginal)) {
                driver.switchTo().window(janela);
                break;
            }
        }
    }

    public static void selectIfrmAppPrinc(){
        try {
            WebElement iframe = driver.findElement(By.id("ifrmAppPrinc"));
            driver.switchTo().frame(iframe);
            driver.manage().window().fullscreen();
        } catch (Exception e) {
            System.out.println("Erro ao tentar trocar para o iframe de ocorrência: " + e.getMessage());
        }
    }

    public static void selectcCframe1(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement iframe1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cframe1")));
            driver.switchTo().frame(iframe1);

        } catch (Exception e) {
            System.out.println("Erro ao tentar trocar para o iframe 'cframe1': " + e.getMessage());
        }
    }

    public static void selectcCframe3(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement iframe2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cframe3")));
            driver.switchTo().frame(iframe2);
            System.out.println("Iframe 'cframe2' selecionado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao tentar trocar para o iframe 'cframe1': " + e.getMessage());
        }
    }

    public static void defaultContent(){
        driver.switchTo().defaultContent();
    }

    public static void tirarPrint(Scenario scenario) {
        try {
            if (driver != null && !driver.getWindowHandles().isEmpty()) {
                if (scenario.isFailed()) {
                    final byte[] screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screen, "image/png", scenario.getName());
                    System.out.println("Screenshot tirado com sucesso.");
                }
            } else {
                System.out.println("Janela fechada, não foi possível tirar o print.");
            }
        } catch (NoSuchWindowException e) {
            System.out.println("Janela fechada, não foi possível tirar o print: " + e.getMessage());
        } catch (WebDriverException e) {
            System.out.println("Erro ao tirar print: " + e.getMessage());
        }
    }

//    public static void tirarPrint(Scenario scenario) {
//        try {
//            if (driver != null && !driver.getWindowHandles().isEmpty()) {
//                final byte[] screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//                scenario.attach(screen, "image/png", scenario.getName());
//            }
//        } catch (NoSuchWindowException e) {
//            System.out.println("Janela fechada, não foi possível tirar o print.");
//        }
//    }

    public static void deletarCookies() {
        try {
            if (driver != null && !driver.getWindowHandles().isEmpty()) {
                driver.manage().deleteAllCookies();
//                System.out.println("Cookies deletados com sucesso.");
            } else {
                System.out.println("Janela fechada, não foi possível deletar os cookies.");
            }
        } catch (NoSuchWindowException e) {
            System.out.println("Janela fechada, não foi possível deletar os cookies: " + e.getMessage());
        } catch (WebDriverException e) {
            System.out.println("Erro ao deletar cookies: " + e.getMessage());
        }
    }

    public static String extractFeatureName(String filePath) {
        int lastSlashIndex = filePath.lastIndexOf('/');
        int featureExtensionIndex = filePath.lastIndexOf(".feature");

        return filePath.substring(lastSlashIndex + 1, featureExtensionIndex);
    }
    public static void scrollAteElemento(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView({  behavior: 'auto',block: 'center',inline: 'center'})", element);
    }

    public static void setChangedMaxValue(WebElement shadowHost, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        SearchContext shadowRoot = (SearchContext) js.executeScript("return arguments[0].shadowRoot;", shadowHost);

        WebElement secondElement = shadowRoot.findElements(By.cssSelector("input-price-range")).get(1);

        js.executeScript("arguments[0].setAttribute('changedmaxvalue', arguments[1]);", secondElement, value);
    }

    public static void scrollAjustado(int numeroDeVezes) {

        for (int i = 0; i < numeroDeVezes; i++) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,200)");
            try {
                Thread.sleep(200);
            }catch (Exception ignore){}
        }
    }

    public static void scrollUpAjustado(int numeroDeVezes) {

        for (int i = 0; i < numeroDeVezes; i++) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(200,0)");
        }
    }

    public static void aguardar(int tempo) {
        try {
            Thread.sleep(tempo* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void aguardarTelaDeLoad() {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(MAX_DURATION)
                .pollingEvery(POOL_DURATION)
                .ignoring(JavascriptException.class);
        try {
            wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return jQuery.active == 0"));
        }catch (Exception ignored){
        }

    }

    public static void scrollAteOElementoWeb(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static WebElement esperarWeb(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(MAX_DURATION)
                .pollingEvery(POOL_DURATION)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement esperarElementoVisivel(String xpathLocator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(MAX_DURATION)
                .pollingEvery(POOL_DURATION)
                .ignoring(NoSuchElementException.class);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
    }

    public static WebElement esperarElementoVisivel(WebElement elemento) {
        WebDriverWait wait = new WebDriverWait(driver, MAX_DURATION);
        return wait.until(ExpectedConditions.visibilityOf(elemento));
    }

    public static void clickByJavaScript(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", element);
    }

    public static void pressEnter(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public static WebElement esperarWeb(By by) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(MAX_DURATION)
                .pollingEvery(POOL_DURATION)
                .ignoring(NoSuchElementException.class);

        return wait.until(driver -> driver.findElement(by));
    }

    public static void tirarFoco() {
        esperarWeb(By.xpath("//body")).click();
    }

    public static void esperarClickableWeb(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(MAX_DURATION)
                .pollingEvery(POOL_DURATION)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void aguardoElementoClicavel(String xpath) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeAsyncScript(
                "function isElementClickable(element) {" +
                        "    const rect = element.getBoundingClientRect();" +
                        "    const isVisible = rect.width > 0 && rect.height > 0;" +
                        "    const isInViewport = rect.top >= 0 && rect.left >= 0 && rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) && rect.right <= (window.innerWidth || document.documentElement.clientWidth);" +
                        "    return isVisible && isInViewport;" +
                        "}" +
                        "function waitForElementToBeClickable(xpath, retries, delay, callback) {" +
                        "    function attemptCheck(retriesLeft) {" +
                        "        const element = document.evaluate(xpath, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                        "        if (element && isElementClickable(element)) {" +
                        "            callback('Element is clickable');" +
                        "        } else if (retriesLeft > 0) {" +
                        "            setTimeout(() => attemptCheck(retriesLeft - 1), delay);" +
                        "        } else {" +
                        "            callback('Element not clickable after multiple attempts');" +
                        "        }" +
                        "    }" +
                        "    attemptCheck(retries);" +
                        "}" +
                        "waitForElementToBeClickable(arguments[0], 10, 500, arguments[arguments.length - 1]);",
                xpath
        );
    }

    public static void aguardoElementoClicavel(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeAsyncScript(
                "function isElementClickable(element) {" +
                        "    const rect = element.getBoundingClientRect();" +
                        "    const isVisible = rect.width > 0 && rect.height > 0;" +
                        "    const isInViewport = rect.top >= 0 && rect.left >= 0 && rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) && rect.right <= (window.innerWidth || document.documentElement.clientWidth);" +
                        "    return isVisible && isInViewport;" +
                        "}" +
                        "function waitForElementToBeClickable(element, retries, delay, callback) {" +
                        "    function attemptCheck(retriesLeft) {" +
                        "        if (isElementClickable(element)) {" +
                        "            callback('Element is clickable');" +
                        "        } else if (retriesLeft > 0) {" +
                        "            setTimeout(() => attemptCheck(retriesLeft - 1), delay);" +
                        "        } else {" +
                        "            callback('Element not clickable after multiple attempts');" +
                        "        }" +
                        "    }" +
                        "    attemptCheck(retries);" +
                        "}" +
                        "waitForElementToBeClickable(arguments[0], 10, 500, arguments[1]);",
                element
        );
    }

    public static String extractSku(String url) {
        String regex = "[?&]sku=([^&]*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return null;
        }
    }

    public static void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }

    public static void aguardoAnimacoesJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeAsyncScript(
                "const callback = arguments[arguments.length - 1];" +
                        "const sleep = (ms) => new Promise(resolve => setTimeout(resolve, ms));" +
                        "const animationsFinished = () => {" +
                        "    const animations = document.getAnimations();" +
                        "    return animations.length === 0;" +
                        "};" +
                        "const waitForAnimations = async () => {" +
                        "    await sleep(1000);" +
                        "    while (document.readyState !== 'complete' || !animationsFinished()) {" +
                        "        await sleep(100);" +
                        "    }" +
                        "    callback();" +
                        "};" +
                        "waitForAnimations();"
        );
    }

    public static void verificarCashBack(Runnable acao) {
        try {
            acao.run();
        } catch (Exception ignored) {

        }
    }

    public static String extractNumbers(String input) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
        StringBuilder numbers = new StringBuilder();
        while (matcher.find()) {
            numbers.append(matcher.group());
        }
        return numbers.toString();
    }

    public static String getJsonData(String key) {
        org.json.JSONObject jsonData = loadJsonSanityFromFile();
        return jsonData.getJSONObject(extractFeatureName(scenario.getUri().toString())).getString(key);
    }
    public static void setJsonData(String key, String value) {
        org.json.JSONObject jsonData = loadJsonSanityFromFile();
        jsonData.getJSONObject(extractFeatureName(scenario.getUri().toString())).put(key, value);
        try {
            Files.write(Paths.get("src/test/resources/configs/data/testData.json"), jsonData.toString(4).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static org.json.JSONObject loadJsonSanityFromFile() {
        org.json.JSONObject jsonData = null;
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get("src/test/resources/configs/data/testData.json")));
            jsonData = new org.json.JSONObject(jsonContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonData;
    }

    public static void esperarElementoVisivelClicavel(WebElement elemento) {
        WebDriverWait wait = new WebDriverWait(driver, MAX_DURATION);
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(elemento),
                ExpectedConditions.elementToBeClickable(elemento)));
    }

    public static WebElement esperarElementoClicavel(WebElement elemento) {
        WebDriverWait wait = new WebDriverWait(driver, MAX_DURATION);
        return wait.until(ExpectedConditions.elementToBeClickable(elemento));
    }

    public static void uploadCameraSearch(String nomeImagem){
        String caminhoProjeto = Paths.get("").toAbsolutePath().toString();
        String caminhoArquivo = caminhoProjeto + "/src/test/resources/imagens/"+nomeImagem;

        WebElement uploadElement = driver.findElement(By.xpath("//input[@type='file'][@accept='image/jpeg,image/png,image/webp']"));
        uploadElement.sendKeys(caminhoArquivo);
    }

}
