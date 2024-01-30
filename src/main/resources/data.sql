insert ignore into materials (id, name, item_level, rarity, sell_price) values
 (1, "Khorium Bar", 70, "Uncommon", 1.25),
 (2, "Hardened Adamantite Bar", 65, "Common", 3),
 (3, "Eternium Bar", 70, "Uncommon", 0.25),
 (4, "Felsteel Bar", 60, "Uncommon", 2.25),
 (5, "Primal Might", 65, "Rare", 1.60),
 (6, "Primal Nether", 65, "Rare", 1.60),
 (7, "Primal Mana", 65, "Uncommon", 0.60),
 (8, "Primal Fire", 65, "Uncommon", 0.60),
 (9, "Primal Air", 65, "Uncommon", 0.60),
 (10, "Primal Water", 65, "Uncommon", 0.60),
 (11, "Primal Earth", 65, "Uncommon", 0.60);

insert ignore into recipes (id, name, item_level, rarity, profession, sell_price) values
 (1, "Plans: Hammer of Righteous Might", 73, "Epic", "Blacksmith", 12.00),
 (2, "Plans: Hand of Eternity", 73, "Epic", "Blacksmith", 12.00),
 (3, "Plans: Felsteel Longblade", 73, "Epic", "Blacksmith", 12.00),
 (4, "Plans: Khorium Belt", 72, "Rare", "Blacksmith", 6.00),
 (5, "Plans: Greater Ward of Shielding", 75, "Rare", "Blacksmith", 7.50),
 (6, "Plans: Felsteel Helm", 73, "Rare", "Blacksmith", 1.50),
 (7, "Plans: Adamantite Weapon Chain", 63, "Uncommon", "Blacksmith", 0.09);

insert ignore into ingredients(id, recipe_id, material_id, quantity) values
 (1, 1, 1, 16),
 (2, 1, 4, 12),
 (3, 1, 5, 6),
 (4, 1, 6, 2);

insert ignore into ingredients(id, recipe_id, material_id, quantity) values
 (5, 2, 1, 10),
 (6, 2, 2, 4),
 (7, 2, 3, 10),
 (8, 2, 5, 8),
 (9, 2, 6, 4);

insert ignore into ingredients(id, recipe_id, material_id, quantity) values
 (10, 3, 1, 10),
 (11, 3, 4, 10),
 (12, 3, 5, 6),
 (13, 3, 6, 2);

insert ignore into ingredients(id, recipe_id, material_id, quantity) values
 (14, 4, 1, 3),
 (15, 4, 7, 2),
 (16, 4, 10, 2);

insert ignore into ingredients(id, recipe_id, material_id, quantity) values
 (17, 5, 3, 1);

insert ignore into ingredients(id, recipe_id, material_id, quantity) values
 (18, 6, 4, 8);

insert ignore into ingredients(id, recipe_id, material_id, quantity) values
 (19, 7, 2, 2),
 (20, 7, 1, 1);