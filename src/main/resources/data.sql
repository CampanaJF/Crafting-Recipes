insert ignore into materials (name, item_level, rarity, sell_price) values
 ("Khorium Bar", 70, "Uncommon", 1.25),
 ("Hardened Adamantite Bar", 65, "Common", 3),
 ("Eternium Bar", 70, "Uncommon", 0.25),
 ("Felsteel Bar", 60, "Uncommon", 2.25),
 ("Primal Might", 65, "Rare", 1.60),
 ("Primal Nether", 65, "Rare", 1.60),
 ("Primal Mana", 65, "Uncommon", 0.60),
 ("Primal Fire", 65, "Uncommon", 0.60),
 ("Primal Air", 65, "Uncommon", 0.60),
 ("Primal Water", 65, "Uncommon", 0.60),
 ("Primal Earth", 65, "Uncommon", 0.60);

insert ignore into recipes (name, item_level, rarity, profession, sell_price) values
 ("Plans: Hammer of Righteous Might", 73, "Epic", "Blacksmith", 12.00),
 ("Plans: Hand of Eternity", 73, "Epic", "Blacksmith", 12.00),
 ("Plans: Felsteel Longblade", 73, "Epic", "Blacksmith", 12.00),
 ("Plans: Khorium Belt", 72, "Rare", "Blacksmith", 6.00),
 ("Plans: Greater Ward of Shielding", 75, "Rare", "Blacksmith", 7.50),
 ("Plans: Felsteel Helm", 73, "Rare", "Blacksmith", 1.50),
 ("Plans: Adamantite Weapon Chain", 63, "Uncommon", "Blacksmith", 0.09);

insert ignore into ingredients(recipe_id, material_id, quantity) values
 (1, 1, 16),
 (1, 4, 12),
 (1, 5, 6),
 (1, 6, 2);

insert ignore into ingredients(recipe_id, material_id, quantity) values
 (2, 1, 10),
 (2, 2, 4),
 (2, 3, 10),
 (2, 5, 8),
 (2, 6, 4);

insert ignore into ingredients(recipe_id, material_id, quantity) values
 (3, 1, 10),
 (3, 4, 10),
 (3, 5, 6),
 (3, 6, 2);

insert ignore into ingredients(recipe_id, material_id, quantity) values
 (4, 1, 3),
 (4, 7, 2),
 (4, 10, 2);

insert ignore into ingredients(recipe_id, material_id, quantity) values
 (5, 3, 1);

insert ignore into ingredients(recipe_id, material_id, quantity) values
 (6, 4, 8);

insert ignore into ingredients(recipe_id, material_id, quantity) values
 (7, 2, 2),
 (7, 1, 1);