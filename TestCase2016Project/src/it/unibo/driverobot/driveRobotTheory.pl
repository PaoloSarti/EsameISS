%drivecommand example
%executeInput(move(mf,100,1000,0))

%lastmove is the next move to save, 
%I can get the starting time, but I can't insert it into the moveList until it ends.

%The savemove/1 rule uses the knowledge base to store and update the information,
%but it uses savemove/5 to get the updated lastMove and moveList.
savemove(executeInput(CUR)):-
	moveList(L),
	savemove(CUR,lastMove(LASTMOVE,MVTIME),L,NEWLASTMOVE,NEWL),
	retract(lastMove(LASTMOVE,MVTIME)),
	assert(NEWLASTMOVE),
	retract(moveList(L)),
	assert(moveList(NEWL)).

%Here the savemove rule is implemented without assert and retract.
%savemove(CUR,LAST,LIST,NEWLAST,NEWLIST)
savemove(CUR,lastMove(none,0),[],lastMove(CUR,M),[]):-
	getCurrentMillis(M).

savemove(CUR,lastMove(move(MV,SPEED,0),FIRSTM),L,lastMove(CUR,M),[move(MV,SPEED,DIFF,0)|L]):-
	getCurrentMillis(M),
	DIFF is M - FIRSTM.

endSavemoves:-
	savemove(executeInput(move(h,100,1000))).

backToBase:-
	moveList(L),
	backToBase(L).

backToBase([]):-!.

backToBase([H,T]):-
	revMove(H,RH),
	executeInput(RH),
	backToBase(T).

getCurrentMillis(M):-
	class("it.unibo.sartiballanti.utils.Utils") <- getCurrentTimeMillis returns M.

revMove(move(mf,X,Y,Z),move(mb,X,Y,Z)).
revMove(move(mb,X,Y,Z),move(mf,X,Y,Z)).
revMove(move(mr,X,Y,Z),move(ml,X,Y,Z)).
revMove(move(ml,X,Y,Z),move(mr,X,Y,Z)).
revMove(move(h,X,Y,Z),move(h,X,Y,Z)).

initDriveRobotTheory  :-  
	actorobj(Actor),
	assert(moveList([])),
	assert(lastMove(none,0)),
	( Actor <- isSimpleActor returns R, R=true, !,
	  actorPrintln(" *** driveRobotTheory Loaded  ***  ");
	).

:- initialization(initDriveRobotTheory).