package me.webek.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class bot {

    public static void main(String[]args) throws Exception{
        JDA jda = JDABuilder.createDefault("TOKEN").build();
        
        jda.addEventListener(new HelloEvent());

    }
}
