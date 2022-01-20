package pages.vk;

import pages.html_elements.Link;
import pages.vk.blocks.SideBarBlock;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;

@Title("Страница новостей")
public interface FeedPage extends AbstractPage, SideBarBlock.WithSideBarBlock, Link.WithLink {
}
