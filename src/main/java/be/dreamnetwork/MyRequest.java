package be.dreamnetwork;

import be.alexandre01.dnplugin.api.connection.request.packets.RequestExample;
import be.alexandre01.dnplugin.api.utils.messages.Message;

import java.lang.annotation.Annotation;

/*
 ↬   Made by Alexandre01Dev 😎
 ↬   done on 05/11/2023 at 11:53
*/
@SuppressWarnings("all")
public enum MyRequest implements RequestExample<MyRequestHandler> {
    MaRequeteCustom,
    SendPlayer,

    HelloWorld;

    final private String value;
    MyRequest() {
        this.value = getProjectName() +"-"+ ordinal();
    }


    public String value(){
        return value;
    }

    @Override
    public String getProjectName() {
        return "Edalia";
    }
}
