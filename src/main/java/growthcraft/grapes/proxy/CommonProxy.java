package growthcraft.grapes.proxy;

public class CommonProxy {

    public void init() {
        registerModelBakeryVariants();
        registerSpecialRenders();
    }

    public void preInit() {
        registerRenders();
        registerTileEntities();
    }

    public void registerRenders() { }

    public void registerTileEntities() {
//        GameRegistry.registerTileEntity(TileEntityGrapeVineFruit.class, Reference.MODID + ":grape_vine_fruit");
    }

    public void registerModelBakeryVariants() { }

    public void registerSpecialRenders() { }

}
