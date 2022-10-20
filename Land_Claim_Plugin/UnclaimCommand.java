package zoren3105.zeradentsmp;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class UnclaimCommand implements CommandExecutor {


    private final ZeradentSMP plugin;

    public UnclaimCommand(ZeradentSMP plugin) {
        this.plugin = plugin;
    }

    String[] leaders = {"IrathTEG", "Zeradentt", "kashiikiwii", "CryptenGaming_Tv", "aridonnie", "TheMoBrosGaming", "zoren3105"};

    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;

            Chunk chunk = player.getLocation().getChunk();

            String name = player.getName();

            String chunkID = chunk.getX() + "_" + chunk.getZ();
            if (Arrays.asList(leaders).contains(name)) {
                if (plugin.isChunk(chunkID)) {
                    plugin.removeChunk(chunkID, player.getUniqueId());
                    sender.sendMessage(ChatColor.GREEN + "Unclaimed Succesfuly");
                } else {
                    sender.sendMessage(ChatColor.RED + "Chunk Is Unclaimed");
                }
            }
            else {
                sender.sendMessage(ChatColor.RED + "You Are Not A Team Leader");
            }
        }
        return true;
    }
}
