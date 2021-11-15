package com.revature.AHBank.util;


import com.revature.AHBank.Screens.Screen;
import com.revature.AHBank.util.LinkedList;

public class ScreenRouter {

    private final LinkedList<Screen> screens;

    public ScreenRouter() {
        screens = new LinkedList<>();
    }

    public void addScreen(Screen screen) {
        screens.add(screen);
    }

    public void navigate(String route) throws Exception {
        System.out.println("DEBUG"+screens.size());
        for (int i = 0; i < screens.size(); i++) {
            Screen thisScreen = screens.get(i);
            System.out.println("DEBUG"+thisScreen);
            if (thisScreen.getRoute().equals(route)) {
                thisScreen.render();
            }

        }
    }
}