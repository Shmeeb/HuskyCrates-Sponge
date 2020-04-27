package com.codehusky.huskycrates;

import com.codehusky.huskycrates.crate.virtual.Crate;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

public class OpenVirtualCommand implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) {
        if (!(src instanceof Player) && !args.getOne(Text.of("target")).isPresent()) {
            Util.sendMessage(src, "&cTarget argument must be supplied");
            return CommandResult.empty();
        }

        Player target = args.<Player>getOne(Text.of("target")).get();
        Crate crate = args.<Crate>getOne("type").get();
        crate.launchView(crate, target);

        return CommandResult.success();
    }
}