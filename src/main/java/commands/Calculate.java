package Commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Calculate extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent e) {

        String[] message = e.getMessage().getContentRaw().split(" ");


        if(message[0].equalsIgnoreCase("!calculate")&&message.length == 1){
            e.getChannel().sendMessage("Aby uzyc tej komendy napisz(bez nawiasow!) !calculate [sum/roz/mno/dziel] [pierwszyNumer] [drugiNumer]").queue();
        }else if(message[0].equalsIgnoreCase("!calculate")&&message[1].equalsIgnoreCase("sum")){
            int num1 = Integer.parseInt(message[2]);
            int num2 = Integer.parseInt(message[3]);
            e.getChannel().sendMessage("Oto wynik: " + (num1 + num2)).queue();
        }else if(message[0].equalsIgnoreCase("!calculate") && message[1].equalsIgnoreCase("roz")){
            int num1 = Integer.parseInt(message[2]);
            int num2 = Integer.parseInt(message[3]);
            e.getChannel().sendMessage("Oto wynik: " + (num1 - num2)).queue();
        }else if(message[0].equalsIgnoreCase("!calculate") && message[1].equalsIgnoreCase("mno")){
            int num1 = Integer.parseInt(message[2]);
            int num2 = Integer.parseInt(message[3]);
            e.getChannel().sendMessage("Oto wynik: " + (num1 * num2)).queue();
        }else if (message[0].equalsIgnoreCase("!calculate") && message[1].equalsIgnoreCase("dziel")){
            int num1 = Integer.parseInt(message[2]);
            int num2 = Integer.parseInt(message[3]);
            e.getChannel().sendMessage("Oto wynik: " + (num1 / num2)).queue();
        }
    }
}
