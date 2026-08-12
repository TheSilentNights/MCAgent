package cn.thesilentnights.mcagent;

import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;

import net.citizensnpcs.api.CitizensAPI;

public class MCAgent extends JavaPlugin{
    @Override
    public void onEnable() {
        CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, "McAgentTest1");
    }

    @Override
    public void onDisable() {
    }


}