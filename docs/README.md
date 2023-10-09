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
>
> <pre>                              HERO                           KING                           MONSTER                         </pre>       
>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Elements/HERO.png)
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Elements/KING.png)
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Elements/MONSTER.png)
>
&nbsp;

> <pre>                              HEROBULLET                  ENEMYBULLET                        WALL                          </pre>       
>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Elements/HeroBullet.png)
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Elements/EnemyBullet.png)
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Elements/Wall.png)
>
&nbsp;

> <pre>                                                          BOSS                                                          </pre>       
>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
We used 9 different PNG's to create the Boss, that combined looks like this:
>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Elements/Boss.png)
>
&nbsp;

## GAME 
<pre>                                                            MENU                                                            </pre>      
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Menu.png)

<pre>                                                          PAUSE MENU                                                        </pre>      
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/PauseMenu.png)

<pre>                                                          LEADERBOARD                                                        </pre>      
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/LeaderBoard.png)

<pre>                                                         INSTRUCTIONS                                                        </pre>      
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Instructions.png)

<pre>                                                            GAMEPLAY                                                           </pre>      
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Gifs/Gameplay.gif)

<pre>                                                        ENEMY INTELIGENCE                                                      </pre>       
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Gifs/Enemy%20Inteligence.gif)

<pre>                                                         TAKING DAMAGE                                                        </pre>      
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Gifs/Taking%20Damage.gif)
>

<pre>                                                         BOSS LEVEL                                                        </pre>      
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Gifs/Boss%20Level.gif)
>
&nbsp;

## DESIGN - UML
![](Screenshots/UML.png)</br>
&nbsp;

### BASIC CODE ORGANIZATION </br>
>
> ### Problem in Context
> > Without an appropriate structure, it would be very hard and confusing to change and develop the code </br>
> 
> ### Pattern 
> > We used the `Model-View-Controller (MVC) pattern`, allowing us to divide the application in three parts, separating the logical part from the displaying. That allows better code readability and easier bug fixing </br>
>
> ### Implementation
> > The following figure shows the implementation of this pattern: </br>
> >
> > ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Patterns/MVC.png) </br>
> 
> > Packages can be found in:
> >    - [`Controller`](https://github.com/FEUP-LDTS-2022/project-l12gr05/tree/master/src/main/java/com/l12gr05/projeto/controller)
> >    - [`Model`](https://github.com/FEUP-LDTS-2022/project-l12gr05/tree/master/src/main/java/com/l12gr05/projeto/model)
> >    - [`View`](https://github.com/FEUP-LDTS-2022/project-l12gr05/tree/master/src/main/java/com/l12gr05/projeto/viewer)
> 
> ### Consequences
> The use of the `MVC Pattern` in the current design allows the following benefits:
> > - The code is more readable and easier to work with
> > - It’s always the same process to add a new feature: create model, view and controller for that
>
&nbsp;


### CHANGING GAME STATE </br>
>
> ### Problem in Context
> > When creating different types of menus and trying to change between them and the game we realized that our application had various states and we needed to easily switch between them
> 
> ### Pattern 
> > The best solution to this problem is applying the `State Pattern`. With this pattern we can separate the states in individual classes and change its behavior depending on its internal state </br>
>
> ### Implementation
> > The following figure shows how we implemented this pattern: </br>
> >
> > ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Patterns/State.png) </br>
> 
> > Packages can be found in:
> >    - [`AddToLeaderboardState`](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/l12gr05/projeto/state/AddToLeaderboardState.java)
> >    - [`GameState`](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/l12gr05/projeto/state/GameState.java)
> >    - [`InstructionsState`](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/l12gr05/projeto/state/InstructionsState.java)
> >    - [`LeaderBoardState`](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/l12gr05/projeto/state/LeaderBoardState.java)
> >    - [`LoseState`](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/l12gr05/projeto/state/LoseState.java)
> >    - [`MenuState`](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/l12gr05/projeto/state/MenuState.java)
> >    - [`PauseState`](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/l12gr05/projeto/state/PauseState.java)   
> >    - [`State`](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/l12gr05/projeto/state/State.java)   
> 
> ### Consequences
> The use of the `State Pattern` in the current design allows the following benefits:
> > - Organizing the code in various explicit state classes allowing better readability
> > -  Much easier to introduce new states to the application, without having to change several state classes
>
&nbsp;


### CREATING AND MOVING ENEMIES </br> 
>
> ### Problem in Context
> > When we decided that we wanted more than one type of enemy and that they would have different attributes and movement, we realized that we needed an efficient way to create and move them. </br>
> 
> ### Patterns 
> > The solution we found to this problem was applying two different patterns combined: `Strategy pattern` and `Factory pattern`. The combination of the two patterns allows us to easily create different types of enemies with an initial moving strategy and then depending on game conditions change their move strategy. </br>
> 
> ### Implementation
> > The following figure shows how we implemented the patterns: </br>
> >
> > &nbsp;
> > `Factory Pattern` </br>
> >
> > ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Patterns/Factory.png) </br>
> > &nbsp;
> >
> > `Strategy Pattern` </br>
> >
> > ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Patterns/Strategy.png) </br> 
> >
>
> > Packages can be found in:
> >    - [`Move`](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/l12gr05/projeto/model/game/elements/Enemy/Move/MoveStrategy.java)
> >    - [`NotMovingStrategy`](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/l12gr05/projeto/model/game/elements/Enemy/Move/NotMovingStrategy.java)
> >    - [`MonsterMoveStrategy`](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/l12gr05/projeto/model/game/elements/Enemy/Move/MonsterMoveStrategy.java)
> >    - [`KingMoveStrategy`](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/l12gr05/projeto/model/game/elements/Enemy/Move/KingMoveStrategy.java)
> >    - [`King`](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/l12gr05/projeto/model/game/elements/Enemy/King.java)
> >    - [`Monster`](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/l12gr05/projeto/model/game/elements/Enemy/Monster.java)
> >    - [`Boss`](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/l12gr05/projeto/model/game/elements/Enemy/Boss.java)
> >    - [`Enemy`](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/l12gr05/projeto/model/game/elements/Enemy/Enemy.java)
> >    
> 
> ### Consequences
> The use of the `State` and `Factory` patterns in the current design allows the following benefits:
> > - It’s easy to create new types of enemies and different moving strategies without having to make changes to the main code
> > - We can change enemy moving strategy during the game
> > - The use of strategies is separated from its creation 
> > - Eliminates conditional statements
>
&nbsp;

### USING THE SAME INSTANCE </br> 
>
> ### Problem in Context
> > When we wanted to add sounds to our game, we predicted that that several classes would need access to a class with a capability of controlling the sound system (SoundControl). So we ensured that this controller would have only one instance. </br>
> 
> ### Pattern 
> > The solution we found to this problem was implementing the `Singleton` pattern. This pattern gives us the ensurance that we instanciate only one object of a certain class, providing a global access point to it. </br>
> 
> ### Implementation
> > The following figure shows how we implemented the pattern: </br>
> > `Singleton` </br>
> > 
> > ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Patterns/Singleton.png) </br>
>
> > Packages can be found in:
> >    - [`Sound`](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/l12gr05/projeto/model/sounds/Sound.java)
> >    - [`SoundControl`](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/l12gr05/projeto/model/sounds/SoundControl.java)
> >    - [`SoundTrack`](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/l12gr05/projeto/model/sounds/SoundTrack.java)
> 
> ### Consequences
> The use of the `Singleton` pattern in the current design allows the following benefits:
> > - We are sure that a class has only one instance, gaining global access to that instance
> > - It becomes harder to test the code because several frameworks rely on inheritance when producing mock objects
> > - We can have an unique instance of the SoundControl object class instead of having to pass it as an atribute to all the classes that require its usability
>
&nbsp;

## REFACTORING LIST
> 
> Here´s a list of refactorings that we did throughout our project development:
> - `Extract Variable`
> - `Extract Method`
> - `Move Method`
> - `Rename Method`
> - `Add Parameter`
> - `Remove parameter`
> - `Decompose Conditional`
> - `Consolidate Duplicate Conditional Fragments`
> - `Inline Method`
> - `Extract Superclass`
> 
&nbsp;

## CODE SMELLS
> 
> Here´s a code smell that is currently present on our code:
> - `Large Class`
> - `Switch Statements`
> 
&nbsp;

### TESTING
![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/CodeCoverage.png) </br>
Como temos dois métodos que são executados no arranque do programa, não conseguimos implementar testes para estes e portanto não atingimos a percentagem de Code Coverage de 100% </br>
&nbsp;


### MUTATION TESTING
![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Pitest.png)
`PITEST LINK:` https://github.com/FEUP-LDTS-2022/project-l12gr05/tree/master/docs/PiTests </br>
&nbsp;


### BETTER CODE HUB
![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/BetterCodeHub.png) </br>
**Result of the analysis:** 7/10

**Failed guidelines:** </br>

`Automate Tests` - Failing the software can't calculate assert density while we are using Spock to make our tests </br>
`Keep Unit Interfaces Small` - We couldn't achieve this guideline because we use a method called `step()` that requires mandatorily 3 parameters. Since we implemented the Singleton Pattern for sound management, we need to insert the sound instance into many methods to test it making, it impossible to reduce the number of parameters
</br>
`Couple Architecture Components Loosely` - Failing because we use the MVC pattern (Organize the project in different folders) </br>
&nbsp;

### ERROR-PRONE WARNINGS
We have no error-prone warnings, we got rid of all of them </br>
&nbsp;


### SELF-EVALUATION
> 
> Mansur: 33.3%</br>
> Ian: 33.3%</br>
> Rafael: 33.3%</br>
> 
