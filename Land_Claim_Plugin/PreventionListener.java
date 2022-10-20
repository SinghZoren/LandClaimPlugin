package zoren3105.zeradentsmp;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PreventionListener implements Listener {

    private final  ZeradentSMP plugin;

    public PreventionListener(ZeradentSMP plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if(event.getClickedBlock() != null){
            Chunk chunk = event.getClickedBlock().getChunk();
            String chunkID = chunk.getX() + "_" + chunk.getZ();

            if(plugin.isChunk(chunkID)){
                Player player = event.getPlayer();

                if(!plugin.getOwner(chunkID).equals(player.getUniqueId())){
                    if(!player.isOp()){
                        event.setCancelled(true);
                        player.sendMessage(ChatColor.RED + "you are not the owner");
                    }
                }
            }
        }
    }
}
