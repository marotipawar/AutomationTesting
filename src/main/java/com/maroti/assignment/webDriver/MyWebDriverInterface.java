package com.maroti.assignment.webDriver;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.logging.Logs;

public interface MyWebDriverInterface extends SearchContext {
    void get(String url);

    String getCurrentUrl();

    String getTitle();

    List<WebElement> findElements(By by);

    WebElement findElement(By by);

    String getPageSource();

    void close();

    void quit();

    Set<String> getWindowHandles();

    String getWindowHandle();

    org.openqa.selenium.WebDriver.TargetLocator switchTo();

    org.openqa.selenium.WebDriver.Navigation navigate();

    org.openqa.selenium.WebDriver.Options manage();

    @Beta
    interface Window {
        Dimension getSize();

        void setSize(Dimension targetSize);

        Point getPosition();

        void setPosition(Point targetPosition);

        void maximize();

        void minimize();

        void fullscreen();
    }

    interface Navigation {
        void back();

        void forward();

        void to(String url);

        void to(URL url);

        void refresh();
    }

    interface TargetLocator {
        org.openqa.selenium.WebDriver frame(int index);

        org.openqa.selenium.WebDriver frame(String nameOrId);

        org.openqa.selenium.WebDriver frame(WebElement frameElement);

        org.openqa.selenium.WebDriver parentFrame();

        org.openqa.selenium.WebDriver window(String nameOrHandle);

        org.openqa.selenium.WebDriver newWindow(WindowType typeHint);

        org.openqa.selenium.WebDriver defaultContent();

        WebElement activeElement();

        Alert alert();
    }

    interface Timeouts {
        /** @deprecated */
        @Deprecated
        org.openqa.selenium.WebDriver.Timeouts implicitlyWait(long time, TimeUnit unit);

        default org.openqa.selenium.WebDriver.Timeouts implicitlyWait(Duration duration) {
            return this.implicitlyWait(duration.toMillis(), TimeUnit.MILLISECONDS);
        }

        default Duration getImplicitWaitTimeout() {
            throw new UnsupportedCommandException();
        }

        /** @deprecated */
        @Deprecated
        org.openqa.selenium.WebDriver.Timeouts setScriptTimeout(long time, TimeUnit unit);

        /** @deprecated */
        @Deprecated
        default org.openqa.selenium.WebDriver.Timeouts setScriptTimeout(Duration duration) {
            return this.setScriptTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
        }

        default org.openqa.selenium.WebDriver.Timeouts scriptTimeout(Duration duration) {
            return this.setScriptTimeout(duration);
        }

        default Duration getScriptTimeout() {
            throw new UnsupportedCommandException();
        }

        /** @deprecated */
        @Deprecated
        org.openqa.selenium.WebDriver.Timeouts pageLoadTimeout(long time, TimeUnit unit);

        default org.openqa.selenium.WebDriver.Timeouts pageLoadTimeout(Duration duration) {
            return this.pageLoadTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
        }

        default Duration getPageLoadTimeout() {
            throw new UnsupportedCommandException();
        }
    }

    interface Options {
        void addCookie(Cookie cookie);

        void deleteCookieNamed(String name);

        void deleteCookie(Cookie cookie);

        void deleteAllCookies();

        Set<Cookie> getCookies();

        Cookie getCookieNamed(String name);

        org.openqa.selenium.WebDriver.Timeouts timeouts();

        org.openqa.selenium.WebDriver.Window window();

        @Beta
        Logs logs();
    }
}
