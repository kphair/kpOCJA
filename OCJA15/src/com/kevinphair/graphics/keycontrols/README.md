Key Controls Demo
(c) 2015 Kevin Phair

The purpose of this demo is to show how to set up a keyboard event listener and use it to control the movement of a player object.

Because I've designed it for use with a game, responsiveness is very important so I've used an old trick, setting a boolean flag on key-down events.
By doing this, the flag is set as soon as the key is pressed and remains set until the key-up handler unsets it.

The reason for this is that if the key-down handler is used to control the movement directly every time its called, this only happens once when the key-down event is triggered and on each key repeast.
This means there is a delay of about 1/4 second between the first press of the key and subsequent repeats which is not at all useful in a game.

By using an array of flags (in this case with 4 elements corresponding to the 4 direction controls), the flag is set right away and the game can respond to it every time the time event triggers an update.

The advantage of this is that it also allows 8-way movement because multiple flags can be set, whereas the key-down event only works on the last key pressed and will forget about any previous keys even if they're still held down.
