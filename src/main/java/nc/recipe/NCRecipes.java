package nc.recipe;

import java.util.List;

import nc.ModCheck;
import nc.integration.crafttweaker.CTRegistration;
import nc.integration.crafttweaker.CTRegistration.RegistrationInfo;
import nc.integration.tconstruct.TConstructExtras;
import nc.radiation.RadBlockEffects.*;
import nc.radiation.RadSources;
import nc.recipe.generator.*;
import nc.recipe.multiblock.*;
import nc.recipe.other.*;
import nc.recipe.processor.*;
import nc.recipe.vanilla.*;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class NCRecipes {
	
	private static boolean initialized = false;
	
	public static ManufactoryRecipes manufactory;
	public static SeparatorRecipes separator;
	public static DecayHastenerRecipes decay_hastener;
	public static FuelReprocessorRecipes fuel_reprocessor;
	public static AlloyFurnaceRecipes alloy_furnace;
	public static InfuserRecipes infuser;
	public static MelterRecipes melter;
	public static SupercoolerRecipes supercooler;
	public static ElectrolyzerRecipes electrolyzer;
	public static AssemblerRecipes assembler;
	public static IngotFormerRecipes ingot_former;
	public static PressurizerRecipes pressurizer;
	public static ChemicalReactorRecipes chemical_reactor;
	public static SaltMixerRecipes salt_mixer;
	public static CrystallizerRecipes crystallizer;
	public static EnricherRecipes enricher;
	public static ExtractorRecipes extractor;
	public static CentrifugeRecipes centrifuge;
	public static RockCrusherRecipes rock_crusher;
	public static CollectorRecipes collector;
	public static DecayGeneratorRecipes decay_generator;
	public static FissionModeratorRecipes fission_moderator;
	public static FissionReflectorRecipes fission_reflector;
	public static FissionIrradiatorRecipes fission_irradiator;
	public static PebbleFissionRecipes pebble_fission;
	public static SolidFissionRecipes solid_fission;
	public static FissionHeatingRecipes fission_heating;
	public static SaltFissionRecipes salt_fission;
	public static FusionRecipes fusion;
	public static CoolantHeaterRecipes coolant_heater;
	public static FissionEmergencyCoolingRecipes fission_emergency_cooling;
	public static HeatExchangerRecipes heat_exchanger;
	public static CondenserRecipes condenser;
	public static TurbineRecipes turbine;
	public static RadiationScrubberRecipes radiation_scrubber;
	public static RadiationBlockMutation radiation_block_mutation;
	public static RadiationBlockPurification radiation_block_purification;
	
	public static BasicRecipeHandler[] processor_recipe_handlers;
	
	@SubscribeEvent(priority = EventPriority.LOW)
	public void registerRecipes(RegistryEvent.Register<IRecipe> event) {
		if (initialized) {
			return;
		}
		
		RadSources.init();
		
		manufactory = new ManufactoryRecipes();
		separator = new SeparatorRecipes();
		decay_hastener = new DecayHastenerRecipes();
		fuel_reprocessor = new FuelReprocessorRecipes();
		alloy_furnace = new AlloyFurnaceRecipes();
		infuser = new InfuserRecipes();
		melter = new MelterRecipes();
		supercooler = new SupercoolerRecipes();
		electrolyzer = new ElectrolyzerRecipes();
		assembler = new AssemblerRecipes();
		ingot_former = new IngotFormerRecipes();
		pressurizer = new PressurizerRecipes();
		chemical_reactor = new ChemicalReactorRecipes();
		salt_mixer = new SaltMixerRecipes();
		crystallizer = new CrystallizerRecipes();
		enricher = new EnricherRecipes();
		extractor = new ExtractorRecipes();
		centrifuge = new CentrifugeRecipes();
		rock_crusher = new RockCrusherRecipes();
		collector = new CollectorRecipes();
		decay_generator = new DecayGeneratorRecipes();
		fission_moderator = new FissionModeratorRecipes();
		fission_reflector = new FissionReflectorRecipes();
		fission_irradiator = new FissionIrradiatorRecipes();
		pebble_fission = new PebbleFissionRecipes();
		solid_fission = new SolidFissionRecipes();
		fission_heating = new FissionHeatingRecipes();
		salt_fission = new SaltFissionRecipes();
		fusion = new FusionRecipes();
		coolant_heater = new CoolantHeaterRecipes();
		fission_emergency_cooling = new FissionEmergencyCoolingRecipes();
		heat_exchanger = new HeatExchangerRecipes();
		condenser = new CondenserRecipes();
		turbine = new TurbineRecipes();
		radiation_scrubber = new RadiationScrubberRecipes();
		radiation_block_mutation = new RadiationBlockMutation();
		radiation_block_purification = new RadiationBlockPurification();
		
		processor_recipe_handlers = new BasicRecipeHandler[] {manufactory, separator, decay_hastener, fuel_reprocessor, alloy_furnace, infuser, melter, supercooler, electrolyzer, assembler, ingot_former, pressurizer, chemical_reactor, salt_mixer, crystallizer, enricher, extractor, centrifuge, rock_crusher};
		
		CraftingRecipeHandler.registerCraftingRecipes();
		FurnaceRecipeHandler.registerFurnaceRecipes();
		GameRegistry.registerFuelHandler(new FurnaceFuelHandler());
		
		for (RegistrationInfo info : CTRegistration.INFO_LIST) {
			info.recipeInit();
		}
		
		initialized = true;
	}
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void registerIntegrationRecipes(RegistryEvent.Register<IRecipe> event) {
		if (ModCheck.tinkersLoaded()) {
			TConstructExtras.init();
		}
		
		for (BasicRecipeHandler handler : processor_recipe_handlers) {
			handler.addGTCERecipes();
		}
	}
	
	public static List<List<String>> infuser_valid_fluids;
	public static List<List<String>> melter_valid_fluids;
	public static List<List<String>> supercooler_valid_fluids;
	public static List<List<String>> electrolyzer_valid_fluids;
	public static List<List<String>> assembler_valid_fluids;
	public static List<List<String>> ingot_former_valid_fluids;
	public static List<List<String>> chemical_reactor_valid_fluids;
	public static List<List<String>> salt_mixer_valid_fluids;
	public static List<List<String>> crystallizer_valid_fluids;
	public static List<List<String>> enricher_valid_fluids;
	public static List<List<String>> extractor_valid_fluids;
	public static List<List<String>> centrifuge_valid_fluids;
	public static List<List<String>> fission_heating_valid_fluids;
	public static List<List<String>> salt_fission_valid_fluids;
	public static List<List<String>> fusion_valid_fluids;
	public static List<List<String>> coolant_heater_valid_fluids;
	public static List<List<String>> fission_emergency_cooling_valid_fluids;
	public static List<List<String>> heat_exchanger_valid_fluids;
	public static List<List<String>> condenser_valid_fluids;
	public static List<List<String>> turbine_valid_fluids;
	public static List<List<String>> radiation_scrubber_valid_fluids;
	
	public static void init() {
		manufactory.init();
		separator.init();
		decay_hastener.init();
		fuel_reprocessor.init();
		alloy_furnace.init();
		infuser.init();
		melter.init();
		supercooler.init();
		electrolyzer.init();
		assembler.init();
		ingot_former.init();
		pressurizer.init();
		chemical_reactor.init();
		salt_mixer.init();
		crystallizer.init();
		enricher.init();
		extractor.init();
		centrifuge.init();
		rock_crusher.init();
		collector.init();
		decay_generator.init();
		fission_moderator.init();
		fission_reflector.init();
		fission_irradiator.init();
		pebble_fission.init();
		solid_fission.init();
		fission_heating.init();
		salt_fission.init();
		fusion.init();
		coolant_heater.init();
		fission_emergency_cooling.init();
		heat_exchanger.init();
		condenser.init();
		turbine.init();
		radiation_scrubber.init();
		radiation_block_mutation.init();
		radiation_block_purification.init();
		
		infuser_valid_fluids = RecipeHelper.validFluids(infuser);
		melter_valid_fluids = RecipeHelper.validFluids(melter);
		supercooler_valid_fluids = RecipeHelper.validFluids(supercooler);
		electrolyzer_valid_fluids = RecipeHelper.validFluids(electrolyzer);
		assembler_valid_fluids = RecipeHelper.validFluids(assembler);
		ingot_former_valid_fluids = RecipeHelper.validFluids(ingot_former);
		chemical_reactor_valid_fluids = RecipeHelper.validFluids(chemical_reactor);
		salt_mixer_valid_fluids = RecipeHelper.validFluids(salt_mixer);
		crystallizer_valid_fluids = RecipeHelper.validFluids(crystallizer);
		enricher_valid_fluids = RecipeHelper.validFluids(enricher);
		extractor_valid_fluids = RecipeHelper.validFluids(extractor);
		centrifuge_valid_fluids = RecipeHelper.validFluids(centrifuge);
		fission_heating_valid_fluids = RecipeHelper.validFluids(fission_heating);
		salt_fission_valid_fluids = RecipeHelper.validFluids(salt_fission);
		fusion_valid_fluids = RecipeHelper.validFluids(fusion);
		coolant_heater_valid_fluids = RecipeHelper.validFluids(coolant_heater);
		fission_emergency_cooling_valid_fluids = RecipeHelper.validFluids(fission_emergency_cooling);
		heat_exchanger_valid_fluids = RecipeHelper.validFluids(heat_exchanger);
		condenser_valid_fluids = RecipeHelper.validFluids(condenser);
		turbine_valid_fluids = RecipeHelper.validFluids(turbine);
		radiation_scrubber_valid_fluids = RecipeHelper.validFluids(radiation_scrubber);
	}
	
	public static void refreshRecipeCaches() {
		manufactory.refreshCache();
		separator.refreshCache();
		decay_hastener.refreshCache();
		fuel_reprocessor.refreshCache();
		alloy_furnace.refreshCache();
		infuser.refreshCache();
		melter.refreshCache();
		supercooler.refreshCache();
		electrolyzer.refreshCache();
		assembler.refreshCache();
		ingot_former.refreshCache();
		pressurizer.refreshCache();
		chemical_reactor.refreshCache();
		salt_mixer.refreshCache();
		crystallizer.refreshCache();
		enricher.refreshCache();
		extractor.refreshCache();
		centrifuge.refreshCache();
		rock_crusher.refreshCache();
		collector.refreshCache();
		decay_generator.refreshCache();
		fission_moderator.refreshCache();
		fission_reflector.refreshCache();
		fission_irradiator.refreshCache();
		pebble_fission.refreshCache();
		solid_fission.refreshCache();
		fission_heating.refreshCache();
		salt_fission.refreshCache();
		fusion.refreshCache();
		coolant_heater.refreshCache();
		fission_emergency_cooling.refreshCache();
		heat_exchanger.refreshCache();
		condenser.refreshCache();
		turbine.refreshCache();
		radiation_scrubber.refreshCache();
		radiation_block_mutation.refreshCache();
		radiation_block_purification.refreshCache();
	}
}
