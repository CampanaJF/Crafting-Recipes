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
 (11, "Primal Earth", 65, "Uncommon", 0.60),
 (12, "Primal Life", 65, "Uncommon", 0.60),
 (13, "Netherweave Cloth", 60, "Common", 0.08),
 (14, "Elemental Blasting Powder", 60, "Common", 0.05),
 (15, "Void Crystal", 70, "Epic", null),
 (16, "Large Prismatic Shard", 70, "Rare", null),
 (17, "Greater Planar Essence", 65, "Uncommon", null),
 (18, "Arcane Dust", 60, "Common", null),
 (19, "Bolt of Netherweave", 60, "Common", 0.40);

insert ignore into recipes (id, name, item_level, rarity, profession, sell_price) values
 (1, "Plans: Hammer of Righteous Might", 73, "Epic", "Blacksmithing", 12.00),
 (2, "Plans: Hand of Eternity", 73, "Epic", "Blacksmithing", 12.00),
 (3, "Plans: Felsteel Longblade", 73, "Epic", "Blacksmithing", 12.00),
 (4, "Plans: Khorium Belt", 72, "Rare", "Blacksmithing", 6.00),
 (5, "Plans: Greater Ward of Shielding", 75, "Rare", "Blacksmithing", 7.50),
 (6, "Plans: Felsteel Helm", 73, "Rare", "Blacksmithing", 1.50),
 (7, "Plans: Adamantite Weapon Chain", 63, "Uncommon", "Blacksmithing", 0.09),
 (8, "Schematic: White Smoke Flare", 63, "Common", "Engineering", 1.50),
 (9, "Formula: Enchant Weapon - Mongoose", 75, "Rare", "Enchanting", 1.50),
 (10, "Formula: Void Shatter", 72, "Common", "Enchanting", 3.75),
 (11, "Formula: Enchant Ring - Healing Power", 74, "Common", "Enchanting", 2.50),
 (12, "Formula: Enchant Bracer - Spellpower", 72, "Uncommon", "Enchanting", 2.00),
 (13, "Pattern: Bolt of Imbued Netherweave", 65, "Common", "Tailoring", 1.00);

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

insert ignore into ingredients(id, recipe_id, material_id, quantity) values
 (21, 8, 13, 1),
 (22, 8, 14, 1);

insert ignore into ingredients(id, recipe_id, material_id, quantity) values
 (23, 9, 15, 6),
 (24, 9, 16, 10),
 (25, 9, 17, 8),
 (26, 9, 18, 40);

insert ignore into ingredients(id, recipe_id, material_id, quantity) values
 (27, 10, 15, 1);

insert ignore into ingredients(id, recipe_id, material_id, quantity) values
 (28, 11, 16, 2),
 (29, 11, 17, 3),
 (30, 11, 18, 5);

insert ignore into ingredients(id, recipe_id, material_id, quantity) values
 (31, 12, 16, 6),
 (32, 12, 8, 6),
 (33, 12, 10, 6);

insert ignore into ingredients(id, recipe_id, material_id, quantity) values
 (34, 13, 19, 3),
 (35, 13, 18, 2);
