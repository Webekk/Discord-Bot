
package Commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class FilterOnOff extends ListenerAdapter {


        public static boolean filterOn = true;
        @Override
        public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent e) {
                if(e.getMessage().getContentRaw().equalsIgnoreCase("$togglefilter") && filterOn == true){
                        filterOn = false;
                        e.getChannel().sendMessage("The Curse-Filter has been disabled by " + e.getMember().getUser().getName()).queue();
                }else if (e.getMessage().getContentRaw().equalsIgnoreCase("$togglefilter")&& filterOn==false){
                        filterOn = true;
                        e.getChannel().sendMessage("The Curse Filter has been enabled by " + e.getMember().getUser().getName()).queue();
                }

        }
}
