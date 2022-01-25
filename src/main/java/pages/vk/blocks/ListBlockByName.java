package pages.vk.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import pages.html_elements.DropDown;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title("Блок список по имени")
public interface ListBlockByName extends AbstractBlockElement, DropDown.WithDropDown {

    @WithName("Список по имени")
    @FindBy(".//td[@class='selector']/../../../..")
    DropDown dayList();

    interface WithListBlockByName extends AbstractBlockElement {
        @FindBy("//div[text()='{{value}}']/following-sibling::div/div")
        ListBlockByName dayListBlockByName(@Param("value") String value);
    }
}
