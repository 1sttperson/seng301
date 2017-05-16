## Design
I have decided to design the app around a "ScreenController" and a "DataStore".
the model.App start method initializes the DataStore and ScreenController, and the ScreenController
displays an initial screen (probably the login screen).

The idea is that the
ScreenController has methods to swap screens and in these methods it will hand a reference
to itself and the DataStore into the loaded screens controller. This means that the current
controller can add/retrieve data from the DataStore and when necessary, change the screen to
something else via the ScreenController reference.

- the Screens enum is so if any fxml urls change, that file is the only thing that needs
to be updated.
- All controllers inherit from an abstract controller superclass that acts as the controller
public interface. This means that the Screen controller can now have a generic
loadScreen function.

## Story assumtions
### Story 4
I am assuming 



Decided in driver not to over engineer by creating a licence class