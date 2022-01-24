package steps;

import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;
import io.qameta.atlas.webdriver.AtlasWebElement;
import org.openqa.selenium.By;
import pages.html_elements.DropDown;
import utils.data.helpers.DataRandomGenerator;

import java.util.Random;

public class VkSteps extends BaseSteps {

    @И("проверить видимость страницы VK")
    public void isVisible() {
        softAssert().assertTrue(getCurrentPage().findElement(By.xpath("//div[@id='index_login']")).isDisplayed());
    }

    @И("в выпадающем списке выбрать случайное значение если поле пустое")
    public void setRandomValueInListByIndex() {
        String selectedValue = ((DropDown) getUIElement(DropDown.class)).getSelectedDropdownValue();
        if (selectedValue.equals("0")) {
            int numberElements = ((DropDown) getUIElement(DropDown.class)).getNumberDropdownElements();
            int randomValue = 1 + new Random().nextInt(numberElements - 1);
            ((DropDown) getUIElement(DropDown.class)).setElementInListByIndex(randomValue);
        }
    }

    @И("в выпадающем списке выбрать элемент по значению {string}")
    public void setRandomValueInList(String value) {
        ((DropDown) getUIElement(DropDown.class)).setListElementByValue(value);
    }

    @Если("в {type} {string} ввести случайный город")
    public void setRandomCityInList(Class<? extends AtlasWebElement> type, String elementName) {
        getElementByName(elementName, type).sendKeys(DataRandomGenerator.getCityName("ru"));
    }

}
