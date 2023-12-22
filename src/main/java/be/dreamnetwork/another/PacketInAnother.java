package be.dreamnetwork.another;

import be.alexandre01.dnplugin.api.connection.request.packets.PacketGlobal;
import be.alexandre01.dnplugin.api.connection.request.packets.PacketHandler;

/*
 ↬   Made by Alexandre01Dev 😎
 ↬   done on 05/11/2023 at 13:23
*/
@PacketGlobal
public class PacketInAnother {
    @PacketHandler(header = "another")
    public void another(){
        System.out.println("another");
    }
}
