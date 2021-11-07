package Commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class InviteCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent e) {
        String[] message = e.getMessage().getContentRaw().split(" ");
        int timeString = 3600;
        if(message[0].equalsIgnoreCase("$invite") && message.length==1){
            e.getChannel().sendMessage("Aby zaprosic kogos na serwer napisz: $invite create").queue();
        }else if(message.length>=2 && message[0].equalsIgnoreCase("$invite") && message[1].equalsIgnoreCase("create")){
        e.getChannel().sendMessage("Hey " + e.getAuthor().getName() + "! Chcesz kogos zaprosic ? Spoko :D").queue();
        e.getChannel().sendMessage("Daj im ten link: " + e.getChannel().createInvite().setMaxAge(timeString).complete().getUrl()).queue();
        e.getChannel().sendMessage("Zaproszenie przestanie dzialac po " + timeString + " wiec lepiej sie sprężajcie 0_0").queue();
        }
    }
}
