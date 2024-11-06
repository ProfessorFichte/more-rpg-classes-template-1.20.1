2.0.9
- BUGFIX: Fixed the error occurring when leaving the server causing the client crashing the game (something with the registry of my sounds was wrong)
- added a Poison Smoke particle
- fixed a typo in poison smoke particle
- increased Frosted Particle Count

2.0.8
- Changed Frosted & Frozen Solid Effect a tiny bit
- changed the model for the Frozen Solid effect
- added Poison Gas Cloud Particles
- fixed a calculation mistake with the Rage Attribute

2.0.7
- forgot to include a wind particle from the 1.20.1 version

2.0.6
- added the wind charge item to the storm rune recipe material
- added air magic sounds for the Wind Elemental Wizard

2.0.5
- made rage damage calc clearer, configurable & changed it, so rage has more impact the more you have
- made playerentitymixin code more clean for better visibility
- added 15% multiplier for the rage attribute in the simply skills compat datapack

2.0.4
- bleeding effect now gets removed correctly when the target is in undead tag
- fixed some wrong animation names
- fixed an error with enchanting not working
- damage types for air, earth and water spell school

2.0.3
- fixed an error with some status effects
- fixed issues with some Helper Methods and deleted unused ones
- made Elemental Mastery translation more clear
- forgot to change item to id in the advancement section
- fixed a tag issue with enchantments

2.0.2
- translation was not assigned correct to attributes in lang files

2.0.1
- forgot to change the new data folder structures (recipes -> recipe, items -> item, etc.)
- forgot to change to 1.21 recipe json structure

2.0.0
- 1.21.1 Update

1.2.1
- tweaked some animations and shifted some of them to the Berserker Mod

1.2.0
- Changed the Status of the Lib Mod from Beta to Release 
- code clean up
- shifted all related attributes, particles, sounds, animations of certain class mods to their mods for better management
- deleted sign intensity and adrenaline attribute, because now its present in the Witcher Mod
- registering the attributes with the vanilla minecraft attributes
- added optional compat for tierify, tiered & simply skills (can be disabled in tweaks config)
- added new particles

1.1.10
- added a config option for the elemental mastery enchantment

1.1.9
- added tags for the elemental runes
- updated for Spell Power 0.11, because it had API changes about enchantments
- removed Water-, Earth- & Air Mastery Enchantments. Elemental Mastery is now for Armor, because Spell Power now works for Elemental Staves & Wands

1.1.8
- added a tag for fur items to make compat crafting
- Fur Compat for EnviromentZ and Frostiful
- italian translation thanks to Zano1999
- The Frosted effect now converts to frozen solid, after it reaches a certain amplifier (can be tweaked in config)

1.1.7
- bleeding don't works on undead monsters
- added enchantments for the elemental Spell Powers Air, Earth and Water
- you can craft white wool with wolf and polar bear fur
- added sounds for water and earth spells
- added the water and earth particles to this lib
- added frozen ticks to Frosted and FrozenSolid

1.1.6
- added russian translation thanks to C'King
- removed the unused incoming damage modifier and reduction, they caused an issue on o modpack
- added a bleeding status effect for future projects and classes

1.1.5
- fixed a small error
- fix for the advancement root

1.1.4
- fixed Custom magic schools not benefiting from Spell Power Enchantment
- added descriptions for all status effect, compat with mods that show effect descriptions
- added my Discord Server Link in the ModMenu
- created an advancement root for my other mods
- support for the german language

1.1.3
- Created a config file for the status effect values
- Final release for the elemental Spell Schools Air, Earth and Water
- Created runes as magic ammo for the other Spell Schools

1.1.2
- Experimental Update for new Spell Engine 0.14 Version and Spell Power 0.10 Version
- Will not work with earlier versions I mentioned above
- Shifted some Status Effects & Particles to the class mods
- Created Custom Air,Earth and Water Spell Power Attributes for Elemental Magic
- Created some Custom ParticlesTypes for other depending on Mods

1.1.1
- Again small hotfix

1.1.0
- Hotfix for the release of depending on mods

1.0.0
- first Beta Version
- now serves as a Library, the classes will receive their own Mods
- removed Items, Armor and Blocks
- Animations, Particles, Sounds, Effects and Attributes stay in the Mods, because different Classes from different Mods will use them
- Until the separate class mods are released you should stay on Alpha version if you want to play

0.1.2
- Update for a playable version
- created tier 1 and tier 2 armor for all three classes
- loot table for the items
- added spells: rumbling swing, axii, yrden, etc.

0.1.1
- Add more Spells
- Add first Armor
- changed many spells
- changed Knuckle Weapon-models

0.1.0
- First Alpha Version for testing and feedback
- Released the first test version
- Released Basic Spells and Weapons