package me.webek.bot;

import Commands.Calculate;
import Commands.InviteCommand;
import Commands.UserInfoCommand;
import Events.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class bot extends ListenerAdapter {



    public static void main(String[]args) throws Exception{
        JDA jda = JDABuilder.createDefault("TOKEN").build();

       jda.addEventListener(new HelloEvent());
        jda.addEventListener(new CategoryCreate());
        jda.addEventListener(new CategoryDelete());
        jda.addEventListener(new VoiceChCreate());
        jda.addEventListener(new VoiceChDelete());
        jda.addEventListener(new Calculate());
        jda.addEventListener(new InviteCommand());
        jda.addEventListener(new UserInfoCommand());
        jda.addEventListener(new Filter());
        jda.addEventListener(new FilterOnOff());
        jda.addEventListener(new FilterMessage());
    }
}
