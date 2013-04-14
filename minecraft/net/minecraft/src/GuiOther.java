package net.minecraft.src;

public class GuiOther extends GuiScreen
{
    /**
     * An array of options that can be changed directly from the options GUI.
     */
    private static final EnumOptions[] relevantOptions = new EnumOptions[] {EnumOptions.MUSIC, EnumOptions.SOUND, EnumOptions.INVERT_MOUSE, EnumOptions.SENSITIVITY, EnumOptions.FOV, EnumOptions.DIFFICULTY, EnumOptions.TOUCHSCREEN};

    /**
     * A reference to the screen object that created this. Used for navigating between screens.
     */
    private final GuiScreen parentScreen;

    /** Reference to the GameSettings object. */
    private final GameSettings options;

    /** The title string that is displayed in the top-center of the screen. */
    protected String screenTitle = "Other Settings";

    public GuiOther(GuiScreen par1GuiScreen, GameSettings par2GameSettings)
    {
        this.parentScreen = par1GuiScreen;
        this.options = par2GameSettings;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        StringTranslate var1 = StringTranslate.getInstance();
        int var2 = 0;
        this.screenTitle = var1.translateKey("Other Settings");
        EnumOptions[] var3 = relevantOptions;
        int var4 = var3.length;

     

      //  this.buttonList.add(new GuiButton(101, this.width / 2 - 100, this.height / 6 + 96 + 12, var1.translateKey("options.video")));
        //this.buttonList.add(new GuiButton(100, this.width / 2 - 100, this.height / 6 + 120 + 12, var1.translateKey("options.controls")));
        //this.buttonList.add(new GuiButton(102, this.width / 2 + 5, this.height / 6 + 95 - 35, 150, 20, var1.translateKey("options.language")));
        this.buttonList.add(new GuiButton(103, this.width / 2 - 100, this.height /  6 + 85, var1.translateKey("options.multiplayer.title")));
      //  this.buttonList.add(new GuiButton(105, this.width / 2 - 152, this.height / 6 + 144 - 6, 150, 20, var1.translateKey("options.texture.pack")));
        this.buttonList.add(new GuiButton(104, this.width / 2 - 100, this.height /6 + 96 + 12, var1.translateKey("options.snooper.view")));
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168, var1.translateKey("gui.done")));
        this.buttonList.add(new GuiButton(4, this.width / 2 - 100, this.height / 6 + 120 + 12, var1.translateKey("menu.quit")));
    }

    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.enabled)
        {
            if (par1GuiButton.id < 100 && par1GuiButton instanceof GuiSmallButton)
            {
                this.options.setOptionValue(((GuiSmallButton)par1GuiButton).returnEnumOptions(), 1);
                par1GuiButton.displayString = this.options.getKeyBinding(EnumOptions.getEnumOptions(par1GuiButton.id));
            }

            if (par1GuiButton.id == 101)
            {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiVideoSettings(this, this.options));
            }

            if (par1GuiButton.id == 100)
            {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiControls(this, this.options));
            }

            if (par1GuiButton.id == 102)
            {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiLanguage(this, this.options));
            }

            if (par1GuiButton.id == 103)
            {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new ScreenChatOptions(this, this.options));
            }
            if (par1GuiButton.id == 4)
            {
                this.mc.shutdown();
            }


            if (par1GuiButton.id == 104)
            {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiSnooper(this, this.options));
            }

            if (par1GuiButton.id == 200)
            {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.parentScreen);
            }

            if (par1GuiButton.id == 105)
            {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiTexturePacks(this, this.options));
            }
        }
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 15, 16777215);
        super.drawScreen(par1, par2, par3);
    }
}
