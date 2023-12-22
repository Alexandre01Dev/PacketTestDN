package be.dreamnetwork;

import be.alexandre01.dnplugin.api.connection.request.packets.PacketHandler;
import be.alexandre01.dnplugin.api.utils.messages.Message;
import org.bukkit.Bukkit;

/*
 ↬   Made by Alexandre01Dev 😎
 ↬   done on 06/11/2023 at 20:37
*/
public class MyHandlerClass {
    @PacketHandler(header = "SkyWarsStart")
    public void onSkyWarsStart(Message message, String status){
        message.getProvider().ifPresent(netEntity -> {
            Bukkit.broadcastMessage("Le serveur "+ netEntity.getName()+" a changé de status en "+status);
        });

    }

}
