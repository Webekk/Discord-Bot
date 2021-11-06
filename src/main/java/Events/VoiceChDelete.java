package Events;

import net.dv8tion.jda.api.events.channel.voice.VoiceChannelDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class VoiceChDelete  extends ListenerAdapter {

        public void onVoiceChannelDelete(VoiceChannelDeleteEvent e){
            e.getGuild().getDefaultChannel().sendMessage("O NIE KTOS MI USUNAL KANAL :(").queue();
        }
}
