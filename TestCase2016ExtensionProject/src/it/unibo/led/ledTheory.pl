%createPi4jLed( PinNum) :-
% 	actorobj( Actor ),
%  	Actor <- getOutputEnvView returns OutView ,	
%	class("it.unibo.devices.qa.DeviceLedPi4jQa") <- createLed( OutView, PinNum ) returns LED.
	
%turnTheLed( on ):-
%	class("it.unibo.devices.qa.DeviceLedPi4jQa") <- getTheLed  returns LED,
%	LED <- turnOn .
	
%turnTheLed( off ):-
%	class("it.unibo.devices.qa.DeviceLedPi4jQa") <- getTheLed  returns LED,
%	LED <- turnOff .

pinNum(26).

%turnTheLed(on):-
%	pinNum(X),
%	class("it.unibo.devices.qa.LedDevicesFactory") <- getTheLedCmd(X) returns LED,
%	LED <- turnOn.


%turnTheLed(off):-
%	pinNum(X),
%	class("it.unibo.devices.qa.LedDevicesFactory") <- getTheLedCmd(X) returns LED,
%	LED <- turnOff.

turnTheLed(on):-
	pinNum(X),
	class("it.unibo.devices.qa.LedDevicesFactory") <- getTheLedCmdInterpreter(X) returns LED,
	LED <- turnOn.


turnTheLed(off):-
	pinNum(X),
	class("it.unibo.devices.qa.LedDevicesFactory") <- getTheLedCmdInterpreter(X) returns LED,
	LED <- turnOff.

turnTheLed(offcompletely):-
	pinNum(X),
	class("it.unibo.devices.qa.LedDevicesFactory") <- getTheLedCmdInterpreter(X) returns LED,
	LED <- turnOffForever.

%initialize  :-   createPi4jLed(25).
initialize.

:- initialization(initialize).
