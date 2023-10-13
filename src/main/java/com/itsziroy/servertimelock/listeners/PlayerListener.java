package com.itsziroy.servertimelock.listeners;

import com.itsziroy.servertimelock.ServerTimeLock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerListener implements Listener {

    private final ServerTimeLock plugin;

    public PlayerListener(ServerTimeLock plugin) {
        this.plugin = plugin;
    }
    @EventHandler()
    public void onPreJoin(PlayerLoginEvent event) {
        if(plugin.isLocked()) {
            event.disallow(PlayerLoginEvent.Result.KICK_OTHER, "The Server is currently offline.");
        }
    }
}
