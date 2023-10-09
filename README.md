# L12GR05 - BERZERK

## GAME DESCRIPTION
> 
> This project is based on the creation of a 2D Atari arcade game called `Berzerk`. The game consists of different enemies that have different types of movements and characteristics depending on their type and a player that carries a gun to kill the monsters so that he can proceed to the following levels.
>
> The player has a health bar attribute that decreases every time he takes a hit. When he loses all his hearts, the game ends.
> After each monster killed, the player's score increases and after the game is over he can enter a LeaderBoard.
> 
&nbsp;

### GROUP COMPOSITION:
> 
> **This project was developed by:**
> - > Mansur (up202102355@up.pt)
> - > Ian Beltrão (up202102360@up.pt)
> - > Rafael Teixeira (up202108831@up.pt)
> 
&nbsp;

## IMPLEMENTED FEATURES
> 
> - `MENU` - When the game is initialized, a menu containing the options Play, LeaderBoard, Instructions and Exit is displayed
> - `PAUSE` - It's possible to pause the game. When the game is paused, a menu containing the options Continue, New game, Exit and Exit to Menu is displayed
> - `ENEMIES` - There are 2 types of enemies in the game: Monster and King
> - `KING MOVIMENTATION` - King has an inteligent movementation (finds the shortest way to hero by dodging walls)
> - `MAP CREATION` - We are able to use custom made maps with the support of a wall and enemies tracking system
> - `EXTERNAL FONT` - We can use our own font in the game
> - `HEALTH BAR` - The player has an amount of health that decreases every time he has contact with an enemy or gets hit by a bullet
> - `GAME OVER` - When the player's energy gets to 0, a Game Over screen containing the options Menu, See LeaderBoard and Add name to leaderBoard is displayed
> - `CHARACTERS` - We designed the characters manually
> - `INSTRUCTIONS` - In the menu the player has the option to se an instructions screen
> - `BULLETS` - The player and enemies can shoot bullets
> - `SCORE` - The player's score increases depending on the type of enemy eliminated
> - `LEVELS` - The player has the option to return to the previous level or advance to the next one
> - `BULLET COLLISION` - When a bullet hits an element it disappears
> - `FRIENDLY FIRE` - Enemies can kill each other
> - `DODGE` - Enemies have a low chance of dodging player bullets
> - `A SOUND SYSTEM` - Implemented sounds for changing tabs, taking damage and eliminating enemies 
> - `BOSS` - We made a final boss consisting of 9 different PNG's 
> - `SHOOT BEHIND WALLS` - If the player is hidden behind walls, the enemies will not try to shoot through them
> - `PICK UP HEALTH` - On the final level, the player has the chance to restore health by picking hearts on the ground
> - `LEADERBOARD` - The player can check the current top 10 players. After dying/concluding the game, the player has the chance of entering the leaderboard by inserting their name
>
&nbsp;
                                                                                                                
## GAME ELEMENTS 

 <pre>                       HERO                      KING                 MONSTER               </pre>       

 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Elements/HERO.png)
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Elements/KING.png)
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Elements/MONSTER.png)

&nbsp;

 <pre>                    HEROBULLET               ENEMYBULLET               WALL               </pre>       

 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Elements/HeroBullet.png)
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Elements/EnemyBullet.png)
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Elements/Wall.png)

&nbsp;

 <pre>                                                BOSS                                           </pre>       

 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
We used 9 different PNG's to create the Boss, that combined looks like this:

 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Elements/Boss.png)

&nbsp;

# GAME
> <pre>                                                MENU                                                 </pre>      
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Menu.png)
> <pre>                                             PAUSE MENU                                              </pre>      
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/PauseMenu.png)
> <pre>                                            LEADERBOARD                                              </pre>      
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/LeaderBoard.png)
> <pre>                                            INSTRUCTIONS                                             </pre>      
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Instructions.png)
>
> <pre>                                             GAMEPLAY                                                </pre>      
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Gifs/Gameplay.gif)
>
> <pre>                                         ENEMY INTELIGENCE                                           </pre>      
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Gifs/Enemy%20Inteligence.gif)
>
> <pre>                                           TAKING DAMAGE                                             </pre>      
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Gifs/Taking%20Damage.gif)
>
> <pre>                                            BOSS LEVEL                                               </pre>      
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Gifs/Boss%20Level.gif)
>
&nbsp;

### SELF-EVALUATION
> 
> Mansur: 33.3%</br>
> Ian: 33.3%</br>
> Rafael: 33.3%</br>
> 
