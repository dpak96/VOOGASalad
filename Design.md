#Squirtle Squad Vooga Design

## Introduction

We are attempting to create an authoring environment, game engine and game player for 2-D platform games. The unique feature of 2-D platform games is that it is a genre that should be able to support a wide variety of gameplay modes, as very different and diverse games from *Donkey Kong, * to *Metroid*. But what unifies these diverse games is that they all contain at some level the goal of either reaching a final point or staying alive while traversing the pitfalls contained within the level. Our design should be very flexible in being able to create, store, load and play a wide variety of game styles, each with their own rules, physics and environment. 

It is our desire to achieve a game authoring environment that is integrated seamlessly with the game player, where the user can switch between the two within the same program. We are hoping to make our authoring environment open, in the sense that we can add and further develop tools with which the user can manipulate additional properties of a game being created. But our visual overlays should be fundamentally close in the fact that they are overlays that should be seamlessly placed on top of the visual rendering of the game. 

The diversity in platformers means that any game authoring environment and engine that we design should be quite powerful in its ability to support a huge variety of demands. It should be able to handle the different goals of either just staying alive or reaching a final point, whose location should be able specifiable. There should be variety of platforms and other obstacles,  and collision properties associated with these different types of platforms. Enemies are very much a large part of many platformers, and we should be able to support different enemies with their own properties and behaviour. These enemies may be able to kill or damage the player, and therefore death and damage conditions must be specified for these enemies. 

## Overview ![image alt text](image_0.jpg)

Our overall design is rather interesting.  Everything begins in our main which quickly calls graphicHandler.  Graphic handler holds two things: the startScreen and the Overarching controller that contains everything else.  This Overarching controller contains all the other controllers as well as our UI and backend.  The startScreen is used to choose editing or playing as well as the game/level.

Our design for the front-end involves a basic front end called UI-Basics. UI-Basics holds all that is generic to the front-end and common to both the authoring environment as well as the game player.  UI-Basics has its own controller that handles basics inputs like keypresses.  The authoring environment and game player are overlays that go over UI-Basics.  They are also what we are considering to be "modules", where they are essentially self contained and extremely easy to swap in/out.  They contain their own controller and backend so that they are plug and play.  This enables us to have the ability for live editing in the future, as the authoring environment and the game player are simply modules on “top” of the game engine.  The essentially are just added on top of UI Basics and are contained inside of it.  By adjusting certain settings in the game engine we can actually keep it running while editing.

The Game Engine deals with the processing of everything that happens and updates the model appropriately.  The UI then updates properly by having an Observable controller that listens to changes in the model and calls for updates in the UI.

Both the Authoring Environment and the Game Engine have a pointer to the Model Controller that they use to update the model.  Our model stores everything from saving/loading, the factories for our objects, as well as our collisions.  The model will also store the current mapping of the keys to their actions so that they can be changed easily by the authoring environment. Our goal is for both the game engine as well as the authoring environment to be as stateless as possible with their data stored in the model.  Both the game engine as well as the authoring environment and the game player will implement interfaces that will enable them all to be "plug and play".

As for the authoring environment itself it will have front-end classes, a controller class, and backend classes.  The backend will be what has a pointer to the model controller.  By designing our authoring environment this way, it allows it to be "added" to the program without really messing up any of the other code.  THe entire object is self contained in itself and only needs the pointer for the model controller.  By using the model controller we can then keep MVC in tact by then updating the Ui using the model.

The game player will also contain front-end classes, a controller class, and a backend class.  These classes will all be self contained as well to make it easy to add/remove.  

The core to our program is the game engine and the UI Basics.  These allow for movement around the game and for the UI to function.  With that said, even the Game Engine is still modular.  This means that the game engine could theoretically be swapped out with any game engine that implemented the interface.  The engine operates by taking in user input each update and determining how to change the model based on the input and the current model state.  This is why the game engine requires a pointer to the model and the model controller.

The way this all fits together isn’t too complicated.  Actions that occur trigger the proper controller which then calls for an action to be taken, which updates the model.  The updated model is then reflected when the interface updates.  In our design the core is the model, the UI Basics, and the Game Engine, without these the program will not function properly.  The game player and the authoring environments are simply an overlay on the core that add functionality.  They can easily be swapped or the program could even survive with neither. One of our other majors goals was to prevent redundancy by minimizing classes that contain instances of each other.  We attempted to accomplish this through injections and pointers.

## User Interface

Begin with the start screen that shows a list of games (Game 1, Game 2, etc.) along with an option to make a new game. Once you click on an option, there will be a new screen with two choices, edit and play. Once either is clicked, UI Basics is overlaid.  This is the "shared" graphical window between both the AE and GP.  This will display the visual elements of the game such as the players, level design, enemies, ie, anything that is a part of the game.  Additionally, it would also have certain buttons that are shared across AE and GP such as pause/play, load/save, quit, etc.  GP will display score and live data, and anything relevant to the current gameplay session.  It must additionally have a button to go to the AE mode.  The AE will have its host of editing tools, as well as a button to go back to the GP mode.

## Design Details

### Authoring Environment 

#### AE Module

The authoring model is designed to attach to the model controller in the same way that the game engine attaches to the model controller. We felt like this was a good design because the game engine and the authoring environment should be using the same model controller API to modify the game. For example if the player is shooting a projectile vs. dragging a new object onto the screen, it should be calling the same model API of create new object. In this sense, the authoring environment and the game engine are providing "inputs" to the same source and make changes to the model in the same way. Once you adopt this point of view live editing seems to be easier to accomplish because the game engine can be running at the same time as authoring environment module. Thus the functionality of the authoring environment will be dependent on the functionality provided by the authoring environment. The AE module has also been designed to fulfill the requirements as required.

-Place: The authoring environment will have the same access to the model that the model controller does. Based on this, the authoring environment will use drag and drop to track the  location of the mouse cursor to evaluate where items will be placed or if items can be placed in those locations at all. 

-Advancement level: The authoring environment will also has a hierarchy. Where you can edit game and game levels. At the game level stage, the player will have the option of modifying the order of the games. In this sense, the model will be loaded from multiple files that contains not only the game information but also the level information.

-Setup graphical elements: Currently we want to have preloaded sprites for items so we have yet to discuss this feature

-Collisions: The model will have a collision manager that can be modified via the same way that everything else can be modified 

-Key Press: THere is some data structure in the model that will be mapped to key presses in the UI

-Set Instructions, Splash Screen: same way as usual

-Tweak settings: This can be modified in the same way as placing objects and setting collisions

-Load previous games: functionality is inside the model which is accessed by the authoring environment

### Game Engine

The game engine was designed to be a stateless component that regulates the objects in the game according to the rules. We decided to make it stateless because the role of the engine is to apply the rules, not store them. Additionally, this makes the saving and loading of games simpler, as they only have to save data from the Model instead of saving individual game engines as well. The game engine was connected to the model controller in order to access the rules and objects in the model that it will need to run the game. This preserves the MVC design. The game engine will also have to interact with the action controller in order to process information from the front end during game play. The action controller will pass the game engine an indication of user input through an Action object, and the game engine will perform the appropriate action based on information from the model. The game engine will have to parse through all the rules and apply them to the objects in the game every cycle. This will be done by calling the update function. Ideally, the rules will be part of a hierarchy, so the game engine will be able to handle a variety of different rules with ease. For example, a win/lose condition would be a specific type of rule compared to a point-collecting rule. The game engine should parse these in a similar manner, due to the two rules having the same super class. The game engine will also have to edit objects in the model for character movement or frame movement. In these cases, we will apply the rule and update the model as well through the model controller. We decided for now that the frame of view for our side scroller will have specific coordinates to define where the frame is. Rules will determine how the frame moves according to what happens in the game. We decided also that there will be a buffer zone around all objects that. If the buffer zone and the frame of view intersect, then the object will become active and will be updated. If they are not intersecting with the frame of view, the object will be inactive and not be updated whenever update is called. 

Model Controller

The purpose of the Model Controller is to give connected classes access to the model. We designed it to enable creating/deleting new rules and objects. It was designed with the purpose of editing the model, so it will contain any methods necessary for the authoring environment, game player, and game engine to get information or change information. It was also made to work with the hierarchy of rules and objects, so it should be flexible in handling a variety of cases. 

### Game Player

#### GP Module

The Game Player is designed to serve as the front-end component when a user is playing a game. Thus, it will sit atop the UI Basics and overlay menus, controls, the player sprite, score and health information, and anything else relevant to the game during play. Specifically, there will be buttons to save and load game, as well as to pause and exit the current game to switch to another game. 

#### UI Basics

The UI Basics is designed to reflect the shared elements of the "window" that represents our game environment.  Seeing as this “window” shows the same level and elements of the game, whether or not you are playing the game in GP or editing the game in AE, it makes sense to extract these shared elements into this module.  Thus, UI Basics will always have GP or AE overlaid over itself at any one time; by selecting which one is active, GP and AE - along with their associated functionalities - can be easily switched back-and-forth.  Thus, live editing *drops mic.*  It will also have “shared” buttons, as well as actually showing the running game.  Such shared buttons will include save, load, pause/play, etc.

#### Action Controller

The Action Controller is simply a controller class that takes in the engine and UI Basics as parameters to its constructors.  In our current design setup, it is supposed to simply relay an "empty" Action object (to adhere to the Open-Closed principle) for any front end action, such as pressing the “Q” key, or pressing the “Save” button.  It only exists to set up the Game Engine as an Observer for the UI Basics; after that, the notifyObservers() of UI Basics will take care of passing the needed List<Actions> to the Engine.  The Engine will interpret the Action object and perform the appropriate response to it.

#### Observer Controller

This controller establishes the relationship between the Model and the UIBasics. The UI Basics will 

### Game Data

#### Model

#### Loading and saving

#### Observer Controller

## Example games

### Super mario

Side scroller, player moves character in horizontal direction, and can jump. WIll be presented with enemies and platforms to navigate safely without dying, goal is to reach end of level. Camera will move as the character moves horizontally with some delay with camera movement. There will be different types of platforms and power ups in the game as well. There is also a checkpoint in the middle so if the player dies, he does not respawn at the beginning of the level. There are also power ups that change how the user acts (star makes you invincible, flower allows you to shoot fire, etc.). Can also get a 1-up mushroom to get extra lives. Coins are placed throughout the level and can also be found in boxes. Getting 100 coins will give you an extra life. Score is determined by number of enemies killed and number of coins collected. Extra points are added depending on how you clear the final checkpoint. There will also be pipes in the stages that will take you to different levels. Mario will be an example of a game with distinct levels that has a clear win condition. There will also be objects with predetermined placement. The authoring environment will have to design each of these stages before starting the game and defining a rule that establishes a win condition. The win condition will be checked by the Game Engine. 

### Spelunky

Megaman/Metroid/Contra/SANIC: side scroller shooting game, player moves character in horizontal direction, and has the ability to jump. Enemies will be presented and the goal of the game is to shoot/avoid the enemies/bullets and reach to the end of the level. There is also the option of including a boss/stronger enemy at the end that must be defeated to finish the level. Bonus items will randomly appear to enhance the shooting ability (example: scattered bullet) of the player. Boss characters will be coded into the hierarchy of objects as a distinct object that has different traits. Will also have certain rules that will prevent player from exiting the boss room. Authoring environment will have to create specific objects and rules for boss rooms. Also, need rules and objects for projectiles. 

### Doodle Jump

Vertical scroller, character constantly jumps and moves back and forth. Platforms will have different properties, and pickups that have different effects. Camera moves vertically as character rises. Platforms also have different properties based on direction (can pass up through a platform, but when you land on the platform you bounce off of it). There are also enemies that move with basic algorithms. Character can shoot or jump on enemies to get rid of them. Jumping on enemies behaves like a normal platform. There are also power ups like trampolines or rockets that gives user a temporary boost in their jump power. Platforms can be randomly generated

Flappy bird: Player moves right at a constant rate, and falls under the effect of gravity. Player rises a short amount for each user input, and must avoid obstacles.  Points are awarded for every obstacle passed or over time. Obstacles can be randomly generated.

These games are distinct because they have randomly generated objects and no clear win conditions. There is also only one stage that goes on infinitely. 

## Design Considerations 

### Authoring Environment

*does AE have access to model?*

One thing that was discussed was whether or not the AE should have access to the model. If the AE didn’t have access to the model than the AE would not be module. Furthermore it would have to get extra information. Thus we decided to give AE access to the model.

*Should authoring frontend and backend be separate?*

The authoring environment is slightly different from the game engine in that it also has a front end section. This means that it has	 to be treated slightly different. However we weren’t sure if authoring environment should be combined or to keep the frontend and the backend separate. The thought was that if the sections were separated we might get a better data path that followed MVC better but by keeping them together we would have more modularity. We found a way (the current design) to maximize both of the things we wanted.

### Game Engine

How to keep track of objects in the GE to apply rules?

* Pointer to model in the GE

* GE must iterate through all objects to check rules (ex. collision). 

Checking all the objects when updating?

Checking objects in a certain quadrant/section when updating?

Putting objects in map keyed to their coordinates, but would have to update keys every time they moved? 

Model controller:

How will authoring environment distinguish between different types of rules and objects when creating?

How will authoring environment identify which objects/rules to delete/edit? Will program have to search through every instance of rules/objects? 

### Game Player

*In which module will the significance of a button press be defined? *

Our debate surrounding the location of the translation of a button press to an action that modifies the model is composed of a couple of issues:

1. Should specific actions like jump, shoot, or run be defined in and of themselves, or should the action associated with a button being pressed merely remain named buttonPressA (or something of the sort)?

2. What type of information should be passed from the UIBasics to the ActionController then to the GameEngine? Currently we are passing a list of inputs/actions which are objects that are essentially hollow, with their significance being defined within the GameEngine.

3. If we were to place the burden of translating an ActionEvent of a keypress to an action on the ActionController, how would the map of keypresses to actions be sent to the ActionController?

4. Is the current observer/observable relationship between the GE and UIBasics the most efficient and closed way of allowing user input?

Currently UIBasics only sends objects implementing the IUserAction interface to the GE via the observer/observable relationship created in the ActionController. These objects are essentially empty, and serve to specify the type of modification the GE will enact on the Model. We believe this configuration is best because it prevents the need to contain functional information from the Model in the ActionController. 

*How should the relationship between Model and UIBasics be defined?*

At this moment, Model and UIBasics possess an observer/observable relationship created in the ObserverController. We have also been researching the various capabilities of Game Loops and have been trying to determine whether or not the observer/observable relationship is necessary. We could have a more direct relationship and constantly redraw the scene, as opposed to waiting for the signal from an observable to update the graphics. This would increase the ease of dealing with large quantities of objects that are being almost constantly updated. 

### Game Data

## Team Responsibilities

### Authoring Environment

Rob Martorano 

Kevin Wang

Jasper Hancock

### Game Engine

Brandon Ho

Wuming  Zhang

Daniel Pak

Calvin Chueh (Secondary: Game Data)

### Game Player

Alex Rice

Steven Katsohirakis

Matthew Battles
