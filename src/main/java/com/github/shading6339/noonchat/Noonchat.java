package com.github.shading6339.noonchat;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Noonchat extends JavaPlugin implements Listener {
    private static Noonchat instance;
    @EventHandler
    public void onPlayerChat(org.bukkit.event.player.PlayerChatEvent event) {
        Bukkit.getScheduler().runTask(Noonchat.getInstance(), () -> {
            String message = event.getMessage();
            String newMassage = message + " HelloWorld";
            event.setMessage(newMassage);
        });
    }
    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(this, this);
        saveDefaultConfig();
        PluginCommand cmd = getCommand("noonchat");
        if(cmd != null) {
            cmd.setExecutor(this);
        }
    }
    public static Noonchat getInstance() {
        return instance;
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
