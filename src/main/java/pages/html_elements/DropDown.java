package pages.html_elements;

import io.qameta.atlas.webdriver.extension.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.element.UIElement;

import java.util.List;

@Title("ДропДаун")
public interface DropDown extends UIElement {

    default void selectByValue(String value) {
        this.sendKeys(value);
    }

    default int getNumberDropdownElements() {
        return this.findElements(By.xpath(".//div[@class='results_container']//li")).size();
    }

    default String getSelectedDropdownValue() {
        return this.findElement(By.xpath(".//input[@class='resultField']")).getAttribute("value");
    }

    default void setElementInList(int index) {
        WebElement element = this.getWrappedElement();
        List<WebElement> elementList = this.findElements(By.xpath(".//div[@class='results_container']//li"));
        elementList.stream().skip(index).findFirst().get().click();
    }

    default void selectByIndex(int index) {
        this.sendKeys();
    }

    default void selectMultipleItemsInDropdown(String... selectedLabels) {
        sendKeys(selectedLabels);
    }

    default String getSelectedInDropdownValue() {
        return getText();
    }

    interface WithDropDown extends UIElement {
        @FindBy(".//select")
        DropDown dropDown();
    }
}
