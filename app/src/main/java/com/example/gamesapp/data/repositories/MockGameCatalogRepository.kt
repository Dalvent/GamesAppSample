package com.example.gamesapp.data.repositories

import com.example.gamesapp.data.models.catalog.GameInCatalogModel
import com.example.gamesapp.data.models.game.DeveloperOfGameModel
import com.example.gamesapp.data.models.game.GameFullModel
import com.example.gamesapp.data.models.game.PublisherOfGameModel
import kotlinx.coroutines.delay

class MockGameCatalogRepository : GameCatalogRepository {
    companion object {
        private const val TAG_HORROR = "Horror"
        private const val TAG_SANDBOX = "SandBox"
        private const val TAG_MMO = "MMO"
        private const val TAG_SHOOTER = "Shooter"
        private const val TAG_RPG = "RPG"
        private const val TAG_STRATEGY = "Strategy"
        private const val TAG_SIMULATOR = "Simulator"
        private const val TAG_ACTION = "Action"
        private const val TAG_DARK_FANTASY = "DarkFantasy"
        private const val TAG_FANTASY = "Fantasy"
        private const val TAG_COOP = "Coop"
        private const val TAG_MULTIPLAYER = "Multiplayer"
        private const val TAG_ADVENTURE = "Adventure"
        private const val TAG_PLATFORMER = "Platformer"
        private const val TAG_2D = "Game2D"
        private const val TAG_3D = "Game3D"
        private const val TAG_INDIE = "Indie"
        private const val TAG_FIRST_PERSON = "FirstPerson"
        private const val TAG_THIRD_PERSON = "ThirdPerson"
        private const val TAG_COMEDY = "Comedy"
        private const val TAG_LOOTER_SHOOTER = "LooterShooter"
        private const val TAG_ROUGH_LIME = "RoughLike"
        
        private const val REQUEST_DELAY: Long = 500;
        private val games = listOf(
            GameFullModel(
                1,
                "Dark Souls",
                "https://s1.gaming-cdn.com/images/products/2364/271x377/game-steam-dark-souls-remastered-cover.jpg",
                10.0f,
                listOf(
                    TAG_MMO,
                    TAG_MULTIPLAYER,
                    TAG_ACTION,
                    TAG_ADVENTURE,
                    TAG_COOP,
                    TAG_DARK_FANTASY,
                    TAG_THIRD_PERSON,
                    TAG_3D,
                    TAG_FANTASY
                ),
                "Dark Souls[b] is a 2011 action role-playing game developed by FromSoftware and published by Namco Bandai Games. A spiritual successor to FromSoftware's Demon's Souls, the game is the second installment in the Souls series. Dark Souls takes place in the fictional kingdom of Lordran, where players assume the role of a cursed undead character who begins a pilgrimage to discover the fate of their kind. A port for Microsoft Windows was released in August 2012, which featured additional content not seen in the original PlayStation 3 and Xbox 360 versions. In October 2012, the new content was made downloadable for consoles under the subtitle Artorias of the Abyss.\n" +
                        "\n" +
                        "Dark Souls has been cited as one of the best video games of all time. Critics praised the depth of its combat, intricate level design, and use of flavour text. However, the game's difficulty received mixed reviews, with some criticizing it for being too unforgiving. The original Windows version of the game was less well-received, with criticism directed at several technical issues. By April 2013, the game had sold over two million copies worldwide. Two sequels were released in the mid-2010s, while a remastered version was released in 2018.",
                DeveloperOfGameModel(1, "FromSoftware"),
                PublisherOfGameModel(1, "Bandai Namco")
            ),
            GameFullModel(
                2,
                "Sonic DX",
                "https://s1.gaming-cdn.com/images/products/5712/orig/game-steam-sonic-adventure-dx-cover.jpg",
                8.0f,
                listOf(
                    TAG_ADVENTURE,
                    TAG_ACTION,
                    TAG_PLATFORMER
                ),
                "Sonic Adventure[a] is a 1998 platform game for Sega's Dreamcast and the first main Sonic the Hedgehog game to feature 3D gameplay. The story follows Sonic the Hedgehog, Miles \"Tails\" Prower, Knuckles the Echidna, Amy Rose, Big the Cat, and E-102 Gamma in their quests to collect the seven Chaos Emeralds and stop series antagonist Doctor Robotnik from unleashing Chaos, an ancient evil. Controlling one of the six characters—each with their own special abilities—players explore a series of themed levels to progress through the story. Sonic Adventure retains many elements from prior Sonic games, such as power-ups and the ring-based health system. Outside the main game, players can play minigames like racing and interact with Chao, a virtual pet.",
                DeveloperOfGameModel(2, "Sonic Team"),
                PublisherOfGameModel(2, "SEGA")
            ),
            GameFullModel(
                3,
                "Doom Eternal",
                "https://upload.wikimedia.org/wikipedia/ru/8/8c/Обложка_Doom_Eternal.jpg",
                9.0f,
                listOf(
                    TAG_ACTION,
                    TAG_PLATFORMER,
                    TAG_SHOOTER,
                    TAG_MULTIPLAYER,
                    TAG_3D
                ),
                "Doom Eternal is a first-person shooter game developed by id Software and published by Bethesda Softworks. The sequel to Doom (2016), and the fifth main game in the Doom series, it was released on March 20, 2020, for Windows, PlayStation 4, Stadia and Xbox One, with a version for Nintendo Switch being released on December 8, 2020 and versions for PlayStation 5 and Xbox Series X and Series S being released on June 29, 2021. Set some time after the events of the 2016 game, the story follows the Doomguy once again, on a mission to end Hell's consumption of Earth and foil the alien Maykr's plans to exterminate humanity.\n" +
                        "\n" +
                        "Along with the single-player campaign, a multiplayer mode titled \"Battlemode\" was introduced. In this mode, players can either play as the Doom Slayer or as a demon, and fight until either the Doom Slayer defeats the demons, or vice versa. Another mode, Horde mode, was implemented into the game on October 26, 2021. The Ancient Gods, a two-part standalone campaign DLC set after the events of the main game, was released between October 2020 and March 2021.\n" +
                        "\n" +
                        "Upon release, Doom Eternal received critical acclaim, with praise for its campaign, graphics, level design, soundtrack, and combat mechanics, though some disliked the increased focus on storytelling and its platforming sections. Doom Eternal received five nominations at The Game Awards for 2020, including Game of the Year and Best Action Game.",
                DeveloperOfGameModel(3, "Id Software"),
                PublisherOfGameModel(3, "Bethesda Softworks"),
            ),
            GameFullModel(
                4,
                "Warcraft 3: Reforged",
                "https://upload.wikimedia.org/wikipedia/ru/5/51/Warcraft_III_Reforged_-_cover.png",
                0.8f,
                listOf(
                    TAG_ACTION,
                    TAG_STRATEGY,
                    TAG_MULTIPLAYER,
                    TAG_3D
                ),
                "WarCraft III: Reforged is a remastered edition of the 2002 real-time strategy video game Warcraft III: Reign of Chaos and its expansion The Frozen Throne. Released on January 28, 2020, it adds revamped graphics, new campaign gameplay settings as well as modern online Battle.net features. The game received mixed reviews from critics and an overwhelmingly negative reception from players for its changes from the original, the lack of many features, and technical issues.",
                DeveloperOfGameModel(4, "Lemon Sky Studios"),
                PublisherOfGameModel(4, "Blizzard Entertainment"),
            ),
            GameFullModel(
                5,
                "CALL OF DUTY: VANGUARD",
                "https://img.g2a.com/323x433/1x1x0/call-of-duty-vanguard-ultimate-edition-pc-battlenet-key-united-states/59526c1e761a48de8c542671",
                3.9f,
                listOf(
                    TAG_ACTION,
                    TAG_SHOOTER,
                    TAG_MULTIPLAYER,
                    TAG_3D
                ),
                "Call of Duty: Vanguard is a 2021 first-person shooter game developed by Sledgehammer Games and published by Activision.[4][5] It was released on November 5 for Microsoft Windows, PlayStation 4, PlayStation 5, Xbox One, and Xbox Series X/S.[6] It serves as the 18th installment in the overall Call of Duty series and the sequel to Call of Duty: WWII. It establishes a storyline featuring the birth of the special forces to face an emerging threat at the end of the war during various theatres of World War II.[7][8][9]",
                DeveloperOfGameModel(5, "Sledgehammer Games"),
                PublisherOfGameModel(5, "Activision"),
            )
        )
    }

    override suspend fun getGames(): List<GameInCatalogModel> {
        delay(REQUEST_DELAY)
        return games.map { GameInCatalogModel(it.id, it.name, it.imageUrl, it.criticsScore, it.tags) }
    }

    override suspend fun getGameDetail(id: Int): GameFullModel {
        delay(REQUEST_DELAY)
        return games.first { gameFullModel ->
            gameFullModel.id == id
        }
    }
}