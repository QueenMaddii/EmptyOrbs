package emptyorbsmod.patches;

import com.evacipated.cardcrawl.modthespire.lib.ByRef;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import emptyorbsmod.EmptyOrb;

public class EmptyOrbing
{
    @SpirePatch(clz= AbstractPlayer.class,method="channelOrb",paramtypez = {AbstractOrb.class})
    public static class ChannelOverride
    {
        @SpirePrefixPatch
        public static void Prefix(AbstractPlayer __instance, @ByRef AbstractOrb[] __orb)
        {
            __orb[0] = new EmptyOrb();
        }
    }
}
