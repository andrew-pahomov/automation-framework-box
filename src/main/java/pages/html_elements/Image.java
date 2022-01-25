package pages.html_elements;

import io.qameta.atlas.webdriver.extension.FindBy;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.element.UIElement;

@Title("Изображение")
public interface Image extends UIElement {

    interface WithImage extends UIElement {
        @FindBy(".//img")
        Image img();
    }
}
