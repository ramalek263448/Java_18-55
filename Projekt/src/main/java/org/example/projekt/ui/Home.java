package org.example.projekt.ui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("")
@AnonymousAllowed
public class Home extends AppLayout {

    public Home() {
        H1 appTitle = new H1("MyApp");
        appTitle.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("line-height", "var(--lumo-size-l)")
                .set("margin", "0 var(--lumo-space-m)");

        SideNav views = getPrimaryNavigation();

        Scroller scroller = new Scroller(views);
        scroller.setClassName(LumoUtility.Padding.SMALL);

        DrawerToggle toggle = new DrawerToggle();

        H2 viewTitle = new H2("Orders");
        viewTitle.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        HorizontalLayout subViews = getSecondaryNavigation();
        subViews.getElement();

        HorizontalLayout wrapper = new HorizontalLayout(toggle, viewTitle);
        wrapper.setAlignItems(FlexComponent.Alignment.CENTER);
        wrapper.setSpacing(false);

        VerticalLayout viewHeader = new VerticalLayout(wrapper, subViews);
        viewHeader.setPadding(false);
        viewHeader.setSpacing(false);

        addToDrawer(appTitle, scroller);
        addToNavbar(viewHeader);

        setPrimarySection(Section.DRAWER);
    }

    private SideNav getPrimaryNavigation() {
        SideNav sideNav = new SideNav();
        sideNav.addItem(new SideNavItem("Admin", "/admin",
                        VaadinIcon.DASHBOARD.create()),
                new SideNavItem("New", "/new",
                        VaadinIcon.CART.create()),
                new SideNavItem("Login", "/login",
                        VaadinIcon.USER_HEART.create()),
                new SideNavItem("Report", "/report",
                        VaadinIcon.PACKAGE.create()));
        return sideNav;
    }

    private HorizontalLayout getSecondaryNavigation() {
        HorizontalLayout navigation = new HorizontalLayout();
        navigation.addClassNames(LumoUtility.JustifyContent.CENTER,
                LumoUtility.Gap.SMALL, LumoUtility.Height.MEDIUM);
        return navigation;
    }
}
