package growthcraft.grapes.common.init;

import growthcraft.cellar.shared.item.ItemBoozeBottle;
import growthcraft.core.GrowthcraftCore;
import growthcraft.core.shared.definition.ItemDefinition;
import growthcraft.core.shared.definition.ItemTypeDefinition;
import growthcraft.core.shared.client.render.utils.ItemRenderUtils;
import growthcraft.grapes.Reference;
import growthcraft.grapes.common.handlers.EnumHandler.GrapeTypes;
import growthcraft.grapes.common.handlers.EnumHandler.WineTypes;
import growthcraft.grapes.common.items.ItemGrape;
import growthcraft.grapes.common.items.ItemGrapeSeed;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

public class GrowthcraftGrapesItems {
    public static ItemDefinition grape;
    public static ItemDefinition grape_seed;
	public static ItemTypeDefinition<ItemBoozeBottle> grapeWine;

    public static void preInit() {
        grape = new ItemDefinition( new ItemGrape("grape", 1, 1, false) );
        grape_seed = new ItemDefinition( new ItemGrapeSeed("grape_seed") );
        grapeWine = new ItemTypeDefinition<ItemBoozeBottle>( new ItemBoozeBottle() );
    }

	private static void registerOres()
	{
		OreDictionary.registerOre("foodFruit", GrapeTypes.GREEN.asStack());
		OreDictionary.registerOre("foodFruit", GrapeTypes.PURPLE.asStack());
		OreDictionary.registerOre("foodFruit", GrapeTypes.RED.asStack());
		OreDictionary.registerOre("foodGrapesPurple", GrapeTypes.PURPLE.asStack());
		OreDictionary.registerOre("foodGrapesGreen", GrapeTypes.GREEN.asStack());
		OreDictionary.registerOre("foodGrapesRed", GrapeTypes.RED.asStack());
		OreDictionary.registerOre("foodGrapejuice", grapeWine.asStack(1, 0));
	}
	
    private static void registerLoot() {
		
		
	}
    
    public static void register() {
    	grape.getItem().setCreativeTab(GrowthcraftCore.tabGrowthcraft);
    	grape.register();
    	grape_seed.getItem().setCreativeTab(GrowthcraftCore.tabGrowthcraft);
    	grape_seed.register();
		grapeWine.register(new ResourceLocation(Reference.MODID, "grapewine"));
		grapeWine.getItem().setCreativeTab(GrowthcraftCore.tabGrowthcraft);
		
		registerOres();
		registerLoot();
    }


	public static void registerRenders() {
    	grape_seed.registerRenders(GrapeTypes.class);
    	grape.registerRenders(GrapeTypes.class);
		grapeWine.registerRenders(WineTypes.class);
    }
    
	public static void registerItemColorHandlers() {
		ItemRenderUtils.registerItemColorHandler(grapeWine.getItem());
	}

	public static void registerItemVariants() {
		grape_seed.registerModelBakeryVariants(GrapeTypes.class);
    	grape.registerModelBakeryVariants(GrapeTypes.class);
		grapeWine.registerModelBakeryVariants(WineTypes.class);
	}
}
