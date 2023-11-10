package Commands;

import LeoOS.LeoOs;

import java.io.IOException;

public class Logout implements Command, FakeLoading{
    @Override
    public String[] execute(String[] arguments) {
        FakeLoading fakeLoading = new FakeLoading() {
            @Override
            public void fakeLoading(){
                FakeLoading.super.fakeLoading();
            }
        };
        fakeLoading.fakeLoading();
        LeoOs.LOGIN = false;
        String[] verabschiedung = {"Sie sind nun ausgeloggt"};
        return verabschiedung;
    }
}
