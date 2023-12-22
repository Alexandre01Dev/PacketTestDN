package be.dreamnetwork;

import be.alexandre01.dnplugin.api.NetworkBaseAPI;
import be.alexandre01.dnplugin.api.connection.request.Packet;
import be.alexandre01.dnplugin.api.connection.request.packets.PacketCast;
import be.alexandre01.dnplugin.api.connection.request.packets.PacketGlobal;
import be.alexandre01.dnplugin.api.connection.request.packets.PacketHandler;
import be.alexandre01.dnplugin.api.objects.server.DNServer;
import be.alexandre01.dnplugin.api.utils.messages.Message;
import org.bukkit.entity.Player;

import java.util.Optional;

/*
 ↬   Made by Alexandre01Dev 😎
 ↬   done on 05/11/2023 at 13:20
*/

@PacketGlobal
@SuppressWarnings("unused")
public class PacketRoot {
    @PacketHandler(header = "test")
    public void test(){
        System.out.println("test");
    }
    @PacketHandler(header = "test2")
    public void test2(Message message){
        System.out.println("test2");
    }
    @PacketHandler(header = "test3")
    public void test3(Message message,String test){
        System.out.println(test);
    }

    @MyRequestHandler(id = MyRequest.SendPlayer)
    public Optional<Packet> sendPlayer(Message message, Optional<Player> player, String wow){

        return message.getProvider().map(netEntity -> {
            Message newMessage = new Message();
            NetworkBaseAPI.getInstance().getByFullName("main/lobby-1").ifPresent(dnServer -> {
                newMessage.set("Server",dnServer);
            });

            player.ifPresent(p -> {
                newMessage.set("CustomPlayer",p);
            });

            return newMessage.toPacket(netEntity);
        });
    }

    @PacketHandler(header = "test4")
    public void test4(Message message,@PacketCast(key = "test") String blabla){
        System.out.println(blabla);
    }

    @PacketHandler(header = "Edalia-Send-Player")
    public void onSendPlayer(Message message, Player player,DNServer dnServer){
        new Message("Edalia-Send-Player").set("CustomPlayer",player).set("Server",dnServer);
    }
}
