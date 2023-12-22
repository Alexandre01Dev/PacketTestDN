package be.dreamnetwork.listener;

import be.alexandre01.dnplugin.api.connection.request.communication.ClientReceiver;
import be.alexandre01.dnplugin.api.utils.messages.Message;
import io.netty.channel.ChannelHandlerContext;

/*
 ↬   Made by Alexandre01Dev 😎
 ↬   done on 05/11/2023 at 20:29
*/
public class Handler extends ClientReceiver {
    @Override
    public void onReceive(Message message, ChannelHandlerContext ctx) throws Exception {
        if(message.hasHeader()){
            if(message.getHeader().equals("Edalia-Send-Player")){
                System.out.println("Edalia-Send-Player");
            }
        }
    }
}
