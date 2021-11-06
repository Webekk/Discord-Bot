package Events;

import net.dv8tion.jda.api.events.channel.category.CategoryDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CategoryDelete extends ListenerAdapter {

        public void onCategoryDelete(CategoryDeleteEvent e){
            e.getGuild().getDefaultChannel().sendMessage("HALOO!!!! KTOS USUNAL KATEGORIE").queue();
        }
}
