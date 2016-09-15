createPi4jLed( PinNum) :-
 	actorobj( Actor ),
  	Actor <- getOutputEnvView returns OutView ,	
	class("it.unibo.devices.qa.DeviceLedPi4jQa") <- createLed( OutView, PinNum ) returns LED.
	
turnTheLed( on ):-
	class("it.unibo.devices.qa.DeviceLedPi4jQa") <- getTheLed  returns LED,
	LED <- turnOn .
	
turnTheLed( off ):-
	class("it.unibo.devices.qa.DeviceLedPi4jQa") <- getTheLed  returns LED,
	LED <- turnOff .

%turnTheLed(on):-
%	class("it.unibo.sartiballanti.utils.Utils") <- executeShellCommand("sudo bash/gpioPinOn.sh 25").
	
%turnTheLed(off):-
%	class("it.unibo.sartiballanti.utils.Utils") <- executeShellCommand("sudo bash/gpioPinOff.sh 25").
/*
------------------------------------------------------------
%initialize
------------------------------------------------------------
*/
initialize  :-   createPi4jLed(25).
%initialize.
%initialization(X) :- X.

:- initialization(initialize).