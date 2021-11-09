//Filtrowanie wiadomosci na kanalach tekstowych discord
package Commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static Commands.FilterMessage.allowed;

public class Filter extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent e) {
        if(FilterOnOff.filterOn == true) {
            String[] LIST_OF_BAD_WORDS = {"anal", "gówno", "sraka", "cipa", "szmata", "kurwa", "kurwy", "kutas", "kutafon"};
            String[] message = e.getMessage().getContentRaw().split(" ");
            for (int i = 0; i < message.length; i++) {
                for (int b = 0; b < LIST_OF_BAD_WORDS.length; b++) {
                    if (message[i].equalsIgnoreCase(LIST_OF_BAD_WORDS[b])) {
                        e.getMessage().delete().queue();
                        if(allowed == true){
                            e.getChannel().sendMessage("uwazaj na swoje slownictwo ancymonie").queue();
                        }
                    }
                }
            }
        }else if(FilterOnOff.filterOn ==false ){
            System.out.println("The filter is disabled");
        }
    }
}
