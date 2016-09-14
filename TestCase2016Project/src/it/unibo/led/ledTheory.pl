
createPi4jLed( PinNum)  :-
 	actorobj( Actor ),
  	Actor <- getOutputEnvView returns OutView ,	
	class("it.unibo.devices.qa.DeviceLedPi4jQa") <- createLed( OutView, PinNum ) returns LED.
	
	
turnTheLed( on ):-
	class("it.unibo.devices.qa.DeviceLedPi4jQa") <- getTheLed  returns LED,
	LED <- turnOn .
	
turnTheLed( off ):-
	class("it.unibo.devices.qa.DeviceLedPi4jQa") <- getTheLed  returns LED,
	LED <- turnOff .
 
/*
------------------------------------------------------------
initialize
------------------------------------------------------------
*/
initialize  :-   createPi4jLed(25).
:- initialization(initialize).