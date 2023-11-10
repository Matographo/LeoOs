package LeoOS;

public class LoadingScreen {
    private String userName;
    private byte loading;

    public void showStartScreen() throws InterruptedException {
        System.out.print("LeoOs wird gestartet");
        byte z = 0;
        while(z<=3) {
            if(System.nanoTime()%700000000 == 0) {
                if(z!=3) {
                    System.out.print(".");
                    z++;
                } else {
                    System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
                    break;
                }
            }
        }
    }

    public void showLoadingScreen() throws InterruptedException {
        for(int i=0; i<10; i++) {
            System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        }
        System.out.print("Loading: [");
        for(int i=0; i<loading; i++) {
            System.out.print("X");
        }
        for(int i=0; i<100-loading; i++) {
            System.out.print("-");
        }
        System.out.print("] " + loading + "%");
        if(loading >= 100) {
            Thread.sleep(1000);
            for(int i=0; i<10; i++) {
                System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
            }
        }
    }

    public void showLoginScreen() {

    }

    public void increaseLoading(byte i) {
        loading+=i;
        if(loading > 100) {
            loading=100;
        }
    }

    public void increaseLoading() {
        increaseLoading((byte)1);
    }

    public void resetLoadscreen() {
        loading = 0;
    }
}