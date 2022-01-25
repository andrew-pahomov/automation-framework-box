package steps;

import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;
import io.qameta.atlas.webdriver.AtlasWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.springframework.http.HttpStatus;
import pages.html_elements.*;
import utils.JsonUtils;
import utils.data.helpers.DataRandomGenerator;

import java.util.Map;
import java.util.Random;

import static citrus.endpoints.EndpointConfig.vk;
import static utils.JsonUtils.getFieldFromJson;

public class VkSteps extends BaseSteps {

    @И("проверить что страница логина VK открыта")
    public void isOpen() {
        softAssert().assertTrue(getCurrentPage().isOpen());
    }

    @И("в выпадающем списке выбрать случайное значение если поле пустое")
    public void setRandomValueInListByIndex() {
        String selectedValue = ((DropDown) getUIElement(DropDown.class)).getSelectedDropdownValue();
        if (selectedValue.equals("0")) {
            int numberElements = ((DropDown) getUIElement(DropDown.class)).getNumberDropdownElements();
            int randomValue = 1 + new Random().nextInt(numberElements - 1);
            ((DropDown) getUIElement(DropDown.class)).setElementInListByIndex(randomValue);
        } else getUIElement(DropDown.class).click();
    }

    @И("в выпадающем списке выбрать элемент по значению {string}")
    public void setRandomValueInList(String value) {
        ((DropDown) getUIElement(DropDown.class)).setListElementByValue(value);
    }

    @Если("в {type} {string} ввести случайный город")
    public void setRandomCityInList(Class<? extends AtlasWebElement> type, String elementName) {
        getElementByName(elementName, type).sendKeys(DataRandomGenerator.getCityName("ru"));
    }

    @И("отправить в сервис vk запрос Get {string} и извлечь данные по пути {string} и записать их в переменную response")
    public void sendGetMessage(String request, String jsonPath) {
        getCitrusRunner().http(httpActionBuilder -> httpActionBuilder
                .client("vk")
                .send()
                .get(request));
        getCitrusRunner().http(httpActionBuilder -> httpActionBuilder
                .client("vk")
                .receive()
                .response(HttpStatus.OK)
                .extractFromPayload(jsonPath, "response"));
    }

    @И("отправить в сервис vk запрос Post multipart по полученному адресу {string} и извлечь данные по пути {string} и записать их в переменную response")
    public void sendPostMessage(String key, String jsonPath) {
        getCitrusRunner().http(httpActionBuilder -> httpActionBuilder
                .client(vk(getCitrusVariable(key)))
                .send()
                .post()
                .contentType("multipart/form-data")
        );
        getCitrusRunner().http(httpActionBuilder -> httpActionBuilder
                .client("vk")
                .receive()
                .response(HttpStatus.OK)
                .extractFromPayload(jsonPath, "response"));
    }

    @И("извлечь данные из переменной response")
    public void saveJsonData(Map<String, String> vars) {
        String responseBody = getCitrusVariable("response");
        vars.forEach((k, jsonPath) -> {
            String extractedValue = JsonUtils.extractBrackets(getFieldFromJson(responseBody, jsonPath));
            setCitrusVariable(k, extractedValue);
        });
    }

    @И("нажать кнопку выбора фотографии")
    public void pressBubbleButton() {
        getUIElement(Button.class).click();
    }

    @И("переместить мышь на фото")
    public void moveMouseToPhoto() {
        Actions actionProvider = new Actions(getDriver());
        actionProvider.moveToElement(getUIElement(Image.class));
    }

    @И("выбрать файл по пути {string}")
    public void choiceFile(String filePath) {
        getUIElement(Input.class).sendKeys(filePath);
    }

    @И("деактивировать чекбокс с именем {string}")
    public void uncheckCheckBoxByName(String elementName) {
        CheckBox checkBox = getElementByName(elementName, CheckBox.class);
        checkBox.setCheckedByName(false);
    }
}

