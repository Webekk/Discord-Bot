package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserInfoCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent e) {
        //SimpleDateFormat pozwala wstawic mi date w wybranym formacie i jako string
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        //Oddziela spacje w tablicy o nazwie message
        String[] message = e.getMessage().getContentRaw().split(" ");
        if (message[0].equalsIgnoreCase("$wizytowka") && message.length == 1) {
            e.getChannel().sendMessage("Ta komenda pokazuje twoja wizytowke lub innego uzytkownika ^^ /(skladnia) $wizytowka [nazwa]").queue();
        }else if (message[0].equalsIgnoreCase("$wizytowka") && message.length == 2){
            String userName = message[1];
            User user = e.getGuild().getMembersByName(userName,true).get(0).getUser();
            String avatar = user.getAvatarUrl();
            EmbedBuilder eb = new EmbedBuilder();


            eb.setTitle(userName + "'s info:");
            eb.setColor(Color.BLUE);
            eb.addField("Nick:",user.getName(),true);
            eb.addField("Status Online:",e.getGuild().getMembersByName(userName,true).get(0).getOnlineStatus().toString(), true); // Online status nie chce sie do konca dobrze pokazac wiec trzeba bedzie na to popatrzec
            eb.addField("Avatar:","Avatar jest ponizej " + e.getMember().getAsMention(),true);
            eb.setImage(avatar);
            eb.setFooter("Request was made @ " + formatter.format(date),e.getGuild().getIconUrl());
            e.getChannel().sendMessage(eb.build()).queue();
        }
    }
}
