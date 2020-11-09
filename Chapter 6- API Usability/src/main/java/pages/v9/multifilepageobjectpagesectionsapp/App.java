package pages.v9.multifilepageobjectpagesectionsapp;

import core.*;

public class App implements AutoCloseable {
    private Boolean _disposed = false;

    public App(Browser browserType)
    {
        LoggingSingletonDriver.getInstance().start(browserType);
    }

    public NavigationService getNavigationService() {
        return SingletonFactory.getInstance(NavigationService.class);
    }

    public BrowserService getBrowserService() {
        return SingletonFactory.getInstance(BrowserService.class);
    }

    public CookiesService getCookiesService() {
        return SingletonFactory.getInstance(CookiesService.class);
    }

    public DialogService getDialogService() {
        return SingletonFactory.getInstance(DialogService.class);
    }

    public <TPage extends NavigatableEShopPage> TPage goTo(Class<TPage> pageOf)
    {
        var page = SingletonFactory.getInstance(pageOf);
        page.open();

        return page;
    }

    public <TPage extends EShopPage> TPage create(Class<TPage> pageOf)
    {
        return SingletonFactory.getInstance(pageOf);
    }

    @Override
    public void close() throws Exception {
        if (_disposed)
        {
            return;
        }

        LoggingSingletonDriver.getInstance().quit();

        _disposed = true;
    }
}
