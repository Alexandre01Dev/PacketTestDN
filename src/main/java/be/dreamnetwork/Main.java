package be.dreamnetwork;


import be.alexandre01.dnplugin.api.NetworkBaseAPI;
import be.alexandre01.dnplugin.api.connection.request.packets.exceptions.PacketInvalidAnnotation;
import be.alexandre01.dnplugin.api.objects.RemoteExecutor;
import be.alexandre01.dnplugin.api.utils.messages.Message;
import be.dreamnetwork.another.PacketInAnother;
import be.dreamnetwork.listener.ServerStart;
import org.bukkit.plugin.java.JavaPlugin;

/*
 ↬   Made by Alexandre01Dev 😎
 ↬   done on 05/11/2023 at 13:17
*/
public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Hello World!");
        NetworkBaseAPI.getInstance().onInitialise(baseAPI -> {
            try {
                baseAPI.getPacketFactory().addRequestAnnotation(MyRequestHandler.class);
            } catch (PacketInvalidAnnotation e) {
                e.printStackTrace();
            }
            baseAPI.getPacketFactory().registerHandlingClass(PacketInAnother.class);
            baseAPI.getPacketFactory().registerHandlingClass(PacketRoot.class);


            baseAPI.getPacketFactory().registerHandlingClass(MyHandlerClass.class);

            RemoteExecutor remoteExecutor = baseAPI.getByName("main/Lobby").orElse(null);
            //code du skywars
            NetworkBaseAPI.getInstance().setLocalData("Status","Waiting players");
            //code du lobby
            NetworkBaseAPI.getInstance().getByName("main/Skywars",0).ifPresent(dnServer -> {
                dnServer.getDataManager().find("Status",String.class).subscribe(string -> {
                    System.out.println("New status for " + dnServer + " : " + string);
                    // do my code
                });
            });

        });

        getServer().getPluginManager().registerEvents(new ServerStart(), this);
    }
}