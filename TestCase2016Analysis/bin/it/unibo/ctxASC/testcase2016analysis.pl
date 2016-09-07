%====================================================================================
% Context ctxASC  SYSTEM-configuration: file it.unibo.ctxASC.testCase2016Analysis.pl 
%====================================================================================
context(ctxlocal, "localhost",  "TCP", "8005" ).  		 
context(ctxdriverobot, "localhost",  "TCP", "8010" ).  		 
context(ctxoperator, "localhost",  "TCP", "8015" ).  		 
context(ctxasc, "localhost",  "TCP", "8020" ).  		 
%%% -------------------------------------------
qactor( operator , ctxoperator  ).
qactor( asc , ctxasc  ).
%%% -------------------------------------------
qactor( driverobot , ctxdriverobot  ).

