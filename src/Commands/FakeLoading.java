package Commands;

import LeoOS.LeoOs;

public interface FakeLoading {
    default void fakeLoading() {
        try {
            for(int i=0; i<=100; i++) {
                LeoOs.loadScreen.showLoadingScreen();
                Thread.sleep(10);
                LeoOs.loadScreen.increaseLoading();
            }
        } catch (InterruptedException e) {
            throw new IllegalArgumentException("Es ist ein Unerwarteter Fehler beim Laden aufgetreten");
        }
        LeoOs.loadScreen.resetLoadscreen();
    }
}
