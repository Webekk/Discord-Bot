 //Filter message nie dziala tak jak powinien (do sprawdzenia)

package Commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;


import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class FilterMessage extends ListenerAdapter {


    public static boolean allowed = true;

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent e) {

        if(FilterOnOff.filterOn == true) {
            if (e.getMessage().getContentRaw().equalsIgnoreCase("$filtermessage") && allowed == true) {
                e.getChannel().sendMessage("Filter Resposne Has been disabled ").queue();
                System.out.println("Disabled");
                allowed = false;
            } else if (e.getMessage().getContentRaw().equalsIgnoreCase("$filtermessage") && allowed == false)
                e.getChannel().sendMessage("Filter Response Has Been Enabled").queue();
            System.out.println("Enabled");
            allowed = true;
        }else if(e.getMessage().getContentRaw().equalsIgnoreCase("$filtermessage") && FilterOnOff.filterOn == false){
            e.getChannel().sendMessage("You cant toggle filter response while the filter is off").queue();
        }
    }
}
