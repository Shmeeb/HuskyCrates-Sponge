package com.codehusky.huskycrates;

import com.codehusky.huskycrates.crate.physical.PhysicalCrate;
import com.codehusky.huskycrates.crate.virtual.Crate;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.monster.Husk;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

public class OpenVirtualCommand implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) {
        if (!(src instanceof Player) && !args.getOne(Text.of("target")).isPresent()) {
            Util.sendMessage(src, "&cTarget argument must be supplied");
            return CommandResult.empty();
        }

        Player target = args.<Player>getOne(Text.of("target")).get();
        String type = args.<String>getOne("type").get();
        Crate crate = HuskyCrates.registry.getCrate(type);

        if (crate == null) {
            Util.sendMessage(src, "&cInvalid crate!");
            return CommandResult.success();
        }

        Location<World> loc = new Location<>(Sponge.getServer().getWorld("warps").get(), 666, 255, 666);

//        crate.launchView(physicalCrate, target);

        return CommandResult.success();
    }
}