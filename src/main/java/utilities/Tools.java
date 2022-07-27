package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tools {

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
