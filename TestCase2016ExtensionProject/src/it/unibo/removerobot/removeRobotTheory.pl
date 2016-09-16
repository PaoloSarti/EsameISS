%drivecommand example
%executeInput(move(mf,100,1000,0))

gotobag:-
	moveList(L),
	reverse(L,LR),
	gotobag(LR).

gotobag([]).

gotobag([H|T]):-
	executeInput(H),
	gotobag(T).

initRemoveRobotTheory.

:- initialization(initRemoveRobotTheory).
