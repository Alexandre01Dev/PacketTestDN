package be.dreamnetwork;

import be.alexandre01.dnplugin.api.connection.request.packets.RequestExample;

import java.lang.annotation.Annotation;

/*
 ↬   Made by Alexandre01Dev 😎
 ↬   done on 05/11/2023 at 11:53
*/
@SuppressWarnings("all")
public enum TestRequest implements RequestExample {
    MaRequeteCustom,
    SendPlayer;

    final String value;
    TestRequest() {
        this.value = getProjectName() +"-"+ ordinal();
    }


    public String value(){
        return value;
    }

    @Override
    public String getProjectName() {
        return "Edalia";
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
