package Events;


import net.dv8tion.jda.api.events.channel.voice.VoiceChannelCreateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class VoiceChCreate extends ListenerAdapter {
        public void onVoiceChannelCreate(VoiceChannelCreateEvent e){
            e.getGuild().getDefaultChannel().sendMessage("wlasnie stworzyles kanal glosowy :D").queue();
        }
}
