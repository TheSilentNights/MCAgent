package cn.thesilentnights.mcagent;

import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;

public class MCAgent extends JavaPlugin{
    @Override
    public void onEnable() {
        NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, "McAgentTest1");
        npc.spawn(getServer().getWorlds().get(1).getSpawnLocation());
    }

    @Override
    public void onDisable() {
    }


}