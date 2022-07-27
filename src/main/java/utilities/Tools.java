package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tools {
    public static void cerrarBanner(WebDriver driver) {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor)driver).executeScript("document.getElementById(\"qcCmpUi\").classList.remove(\"qc-cmp-ui\")");
        } else {
            throw new IllegalStateException("This driver does not support JavaScript!");
        }
    }

    public static void scrollToTable(WebDriver driver, WebElement element){
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script, element);
    }

    public static void scrollTo(WebDriver driver, int x, int y){
        String script = "window.scrollTo(" + x + ", " + y +")";
        ((JavascriptExecutor)driver).executeScript(script);
    }

    public static void setTextSequencial(WebElement inputText, String text, int delay){
        for(int i = 0; i < text.length(); i=i+2){
            if(i+2 < text.length()) {
                inputText.sendKeys(text.substring(i, i + 2));
            } else {
                inputText.sendKeys(text.substring(i, i+1));
            }
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void delay(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
