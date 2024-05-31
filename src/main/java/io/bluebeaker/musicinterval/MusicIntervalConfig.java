package io.bluebeaker.musicinterval;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.RangeInt;
import net.minecraftforge.common.config.Config.RequiresMcRestart;
import net.minecraftforge.common.config.Config.Type;

@Config(modid = MusicIntervalMod.MODID,type = Type.INSTANCE,category = "general")
public class MusicIntervalConfig {
    @LangKey("config.musicinterval.mininterval.name")
    @Comment("Min interval between musics.")
    @RequiresMcRestart
    @RangeInt(min = 0)
    public static int mininterval = 0;
    @LangKey("config.musicinterval.maxinterval.name")
    @Comment("Max interval between musics. If less than min then this is used instead.")
    @RequiresMcRestart
    @RangeInt(min = 0)
    public static int maxinterval = 100;
}