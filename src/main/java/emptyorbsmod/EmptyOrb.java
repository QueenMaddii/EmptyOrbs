package emptyorbsmod;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.OrbStrings;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import emptyorbsmod.util.TextureLoader;

import static emptyorbsmod.EmptyOrbsMain.makeID;

public class EmptyOrb extends AbstractOrb
{
    public static final String ORB_ID = "Empty";
    private static final OrbStrings orbString = CardCrawlGame.languagePack.getOrbString(makeID("Empty"));
    public static final String[] DESC = orbString.DESCRIPTION;
    private static final float ORB_BORDER_SCALE = 1.2F;

    private final Texture ORB_EMPTY = TextureLoader.getTexture(EmptyOrbsMain.resourcePath("emptyOrb.png"));

    private float vfxTimer = 0.5F;

    private static final float VFX_INTERVAL_TIME = 0.25F;

    public EmptyOrb()
    {
        this.ID = ORB_ID;
        this.img = ORB_EMPTY;
        this.name = orbString.NAME;
        this.baseEvokeAmount = 0;
        this.basePassiveAmount = 0;
        this.passiveAmount = 0;
        updateDescription();
        this.channelAnimTimer = vfxTimer;
    }

    @Override
    public void updateDescription()
    {
        applyFocus();
        this.description = DESC[0] + DESC[1];
    }

    @Override
    public void onEvoke()
    {

    }

    @Override
    public AbstractOrb makeCopy()
    {
        return new EmptyOrb();
    }

    @Override
    public void render(SpriteBatch sb)
    {
        sb.setColor(this.c);
        sb.draw(this.img, this.cX - 48.0F, this.cY - 48.0F + this.bobEffect.y, 48.0F, 48.0F, 96.0F, 96.0F, this.scale, this.scale, this.angle, 0, 0, 96, 96, false, false);
        this.c.a /= 3.0F;
        sb.setColor(this.shineColor);
        sb.setBlendFunction(770, 1);
        sb.draw(this.img, this.cX - 48.0F, this.cY - 48.0F + this.bobEffect.y, 48.0F, 48.0F, 96.0F, 96.0F, this.scale * 1.2F, this.scale * 1.2F, this.angle / 1.2F, 0, 0, 96, 96, false, false);
        sb.draw(this.img, this.cX - 48.0F, this.cY - 48.0F + this.bobEffect.y, 48.0F, 48.0F, 96.0F, 96.0F, this.scale * 1.5F, this.scale * 1.5F, this.angle / 1.4F, 0, 0, 96, 96, false, false);
        sb.setBlendFunction(770, 771);
        renderText(sb);
        this.hb.render(sb);
    }

    @Override
    public void playChannelSFX()
    {
        CardCrawlGame.sound.play("ORB_DARK_CHANNEL", 0.1F);
    }
}
