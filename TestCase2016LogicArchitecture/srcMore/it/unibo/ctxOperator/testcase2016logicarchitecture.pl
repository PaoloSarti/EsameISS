%====================================================================================
% Context ctxOperator  SYSTEM-configuration: file it.unibo.ctxOperator.testCase2016LogicArchitecture.pl 
%====================================================================================
context(ctxdriverobot, "192.168.1.69",  "TCP", "8010" ).  		 
context(ctxoperator, "192.168.1.2",  "TCP", "8015" ).  		 
context(ctxasc, "192.168.1.2",  "TCP", "8020" ).  		 
%%% -------------------------------------------
qactor( led , ctxdriverobot  ).
qactor( operator , ctxoperator  ).
qactor( asc , ctxasc  ).
%%% -------------------------------------------
qactor( driverobot , ctxdriverobot  ).

