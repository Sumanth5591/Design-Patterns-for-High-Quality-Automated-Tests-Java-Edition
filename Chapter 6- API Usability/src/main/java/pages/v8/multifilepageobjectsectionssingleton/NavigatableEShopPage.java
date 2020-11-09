package pages.v8.multifilepageobjectsectionssingleton;

import core.NavigationService;

public abstract class NavigatableEShopPage extends EShopPage {
    protected final NavigationService navigationService;

    public NavigatableEShopPage() {
        this.navigationService = LoggingSingletonDriver.getInstance();
    }

    protected abstract String getUrl();

    public void open()
    {
        navigationService.goToUrl(getUrl());
    }
}