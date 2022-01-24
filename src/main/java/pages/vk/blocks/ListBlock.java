package pages.vk.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import pages.html_elements.DropDown;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title("Блок список")
public interface ListBlock extends AbstractBlockElement, DropDown.WithDropDown {

    @WithName("Список")
    @FindBy(".//td[@class='selector']/../../../..")
    DropDown dayList();

    interface WithDayListBlock extends AbstractBlockElement {
        @FindBy("//div[@id='container{{ value }}']")
        ListBlock dayListBlock(@Param("value") String value);
    }
}
