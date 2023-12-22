package be.dreamnetwork.listener;

import be.alexandre01.dnplugin.api.NetworkBaseAPI;
import be.alexandre01.dnplugin.api.connection.request.packets.PacketCast;
import be.alexandre01.dnplugin.api.utils.messages.Message;
import be.alexandre01.dnplugin.plugins.spigot.api.events.server.ServerStartedEvent;
import be.dreamnetwork.MyRequest;
import be.dreamnetwork.MyRequestHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/*
 ↬   Made by Alexandre01Dev 😎
 ↬   done on 05/11/2023 at 13:24
*/
public class ServerStart implements Listener {
    @EventHandler
    public void onServerStart(ServerStartedEvent event){
        new Message("test").toPacket(event.getServer()).dispatch();
        new Message("test2").toPacket(event.getServer()).dispatch();
        new Message("test3").set("test","Test 3 youpi !").toPacket(event.getServer()).dispatch();
        new Message("test4").set("test","Test 4 letttss gooo !").toPacket(event.getServer()).dispatch();
        new Message("another").toPacket(event.getServer()).dispatch();

        NetworkBaseAPI.getInstance().getReceiverManager().addResponse(new Handler());

        MyRequest.SendPlayer.getMessage().set("Wow","Héhé").toPacket(event.getServer()).dispatch();


        Player player = null;
        new Message("Edalia-Send-Player").set("player",player).set("server",event.getServer()).toPacket(event.getServer()).dispatch();

        MyRequest.HelloWorld.getMessage().set("message","Hello World");

        //You can register accessible data to a server
        NetworkBaseAPI.getInstance().setLocalData("Status","Waiting players");

        // You can subscribe to a dataManager
        event.getServer().getDataManager().find("Status",String.class).subscribe(string -> {
            System.out.println("New status for " + event.getServer() + " : " + string);
            // do my code
        });

        // you can get one time a data
        event.getServer().getDataManager().find("Status",String.class).ask(string -> {
            System.out.println("New status for " + event.getServer() + " : " + string);
            // do my code
        }).whenComplete((unused, throwable) -> {
            if(throwable != null){
                // the data cannot be found
            }
        });
    }
}
