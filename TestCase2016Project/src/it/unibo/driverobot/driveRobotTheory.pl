

%executeInput(move(mf,100,1000,0))

%savemove(CUR,LAST,LIST,NEWLAST,NEWLIST)

%lastmove è la prossima mossa da memorizzare, 
%di cui so il tempo iniziale, ma non posso ancora inserirla,
%perchè non so quando termina


endSavemove:-
	savemove(executeInput(move(h,100,1000))).

savemove(executeInput(CUR)):-
	moveList(L),
	savemove(CUR,lastMove(LASTMOVE,MVTIME),L,NEWLASTMOVE,NEWL),
	retract(lastMove(LASTMOVE,MVTIME),
	assert(NEWLASTMOVE),
	retract(moveList(L)),
	assert(moveList(NEWL)).

savemove(CUR,lastMove(none,0),[],lastMove(CUR,M),[]):-
	getCurrentMillis(M).

savemove(CUR,lastMove(move(MV,SPEED,0),FIRSTM),L,lastMove(CUR,M),[move(MV,SPEED,DIFF,0)|L]):-
	getCurrentMillis(M),
	DIFF is M - FIRSTM.

backToBase:-
	moveList(L),
	backToBase(L).

backToBase([]):-!.

backToBase([H,T]):-
	revMove(H,RH),
	executeInput(RH),
	backToBase(T).

revMove(move(mf,X,Y,Z),move(mb,X,Y,Z)).
revMove(move(mb,X,Y,Z),move(mf,X,Y,Z)).
revMove(move(mr,X,Y,Z),move(ml,X,Y,Z)).
revMove(move(ml,X,Y,Z),move(mr,X,Y,Z)).
revMove(move(h,X,Y,Z),move(h,X,Y,Z)).

initDriveRobotTheory  :-  
	actorobj(Actor),
	%assign(moveCounter,0),
	assert(moveList([])),
	assert(lastMove(none,0)),
	( Actor <- isSimpleActor returns R, R=true, !,
	  actorPrintln(" *** driveRobotTheory Loaded  ***  ");
	).

:- initialization(initDriveRobotTheory).
