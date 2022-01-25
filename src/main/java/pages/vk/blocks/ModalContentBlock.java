package pages.vk.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.html_elements.Button;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title("Блок выбора миниатюры")
public interface ModalContentBlock extends AbstractBlockElement, Button.WithButton {

    @WithName("Кнопка сохранения")
    @FindBy(".//button")
    Button saveButton();

    interface WithModalContentBlock extends AbstractBlockElement {
        @FindBy(".//div[@class='OwnerAvatarEditor__content']")
        ModalContentBlock modalContentBlock();
    }
}
