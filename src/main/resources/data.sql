insert into clearing_member(clearingMemberId, amountToPay, clearingMemberFundBalance, clearingMemberName,interestRate, netPayable, shortage, corporateActionChange) values(1001,0,FLOOR((RAND()*500000)+1000000),"Citi",1.25,0,0,0);
insert into clearing_member(clearingMemberId, amountToPay, clearingMemberFundBalance, clearingMemberName,interestRate, netPayable, shortage, corporateActionChange) values(1002,0,FLOOR((RAND()*500000)+1000000),"JP Morgan Chase",1.25,0,0,0);
insert into clearing_member(clearingMemberId, amountToPay, clearingMemberFundBalance, clearingMemberName,interestRate, netPayable, shortage, corporateActionChange) values(1003,0,FLOOR((RAND()*500000)+1000000),"Bank of New York Mellon",1.25,0,0,0);
insert into clearing_member(clearingMemberId, amountToPay, clearingMemberFundBalance, clearingMemberName,interestRate, netPayable, shortage, corporateActionChange) values(1004,0,FLOOR((RAND()*500000)+1000000),"State Street Corporation",1.25,0,0,0);
insert into clearing_member(clearingMemberId, amountToPay, clearingMemberFundBalance, clearingMemberName,interestRate, netPayable, shortage, corporateActionChange) values(1005,0,FLOOR((RAND()*500000)+1000000),"BNP Paribas Securities Services",1.25,0,0,0);
insert into clearing_member(clearingMemberId, amountToPay, clearingMemberFundBalance, clearingMemberName,interestRate, netPayable, shortage, corporateActionChange) values(1006,0,FLOOR((RAND()*500000)+1000000),"HSBC Securities Services",1.25,0,0,0);
insert into clearing_member(clearingMemberId, amountToPay, clearingMemberFundBalance, clearingMemberName,interestRate, netPayable, shortage, corporateActionChange) values(1007,0,FLOOR((RAND()*500000)+1000000),"Northern Trust Corporation",1.25,0,0,0);
insert into clearing_member(clearingMemberId, amountToPay, clearingMemberFundBalance, clearingMemberName,interestRate, netPayable, shortage, corporateActionChange) values(1008,0,FLOOR((RAND()*500000)+1000000),"UBS AG",1.25,0,0,0);
insert into clearing_member(clearingMemberId, amountToPay, clearingMemberFundBalance, clearingMemberName,interestRate, netPayable, shortage, corporateActionChange) values(1009,0,FLOOR((RAND()*500000)+1000000),"Wells Fargo",1.25,0,0,0);
insert into clearing_member(clearingMemberId, amountToPay, clearingMemberFundBalance, clearingMemberName,interestRate, netPayable, shortage, corporateActionChange) values(10010,0,FLOOR((RAND()*500000)+1000000),"Credit Suisse",1.25,0,0,0);
insert into securities(securityId, interestRate, marketPrice, securityName) values(1,FLOOR((RAND()*20)+1),RAND()*(300-10+1)+10,"Amazon");
insert into securities(securityId, interestRate, marketPrice, securityName) values(2,FLOOR((RAND()*20)+1),RAND()*(300-10+1)+10,"Apple");
insert into securities(securityId, interestRate, marketPrice, securityName) values(3,FLOOR((RAND()*20)+1),RAND()*(300-10+1)+10,"Microsoft");
insert into securities(securityId, interestRate, marketPrice, securityName) values(4,FLOOR((RAND()*20)+1),RAND()*(300-10+1)+10,"UBER");
insert into securities(securityId, interestRate, marketPrice, securityName) values(5,FLOOR((RAND()*20)+1),RAND()*(300-10+1)+10,"FORD Motor Company");
insert into securities(securityId, interestRate, marketPrice, securityName) values(6,FLOOR((RAND()*20)+1),RAND()*(300-10+1)+10,"Tesla Inc.");
insert into securities(securityId, interestRate, marketPrice, securityName) values(7,FLOOR((RAND()*20)+1),RAND()*(300-10+1)+10,"QUALCOMM Inc.");
insert into securities(securityId, interestRate, marketPrice, securityName) values(8,FLOOR((RAND()*20)+1),RAND()*(300-10+1)+10,"AT&T inc");
insert into securities(securityId, interestRate, marketPrice, securityName) values(9,FLOOR((RAND()*20)+1),RAND()*(300-10+1)+10,"Intercontinental Exchange");
insert into securities(securityId, interestRate, marketPrice, securityName) values(10,FLOOR((RAND()*20)+1),RAND()*(300-10+1)+10,"Alphabet Inc.");
insert into securities(securityId, interestRate, marketPrice, securityName) values(11,FLOOR((RAND()*20)+1),RAND()*(300-10+1)+10,"Anheuser Busch Inbev NV");
insert into securities(securityId, interestRate, marketPrice, securityName) values(12,FLOOR((RAND()*20)+1),RAND()*(300-10+1)+10,"WALMART INC");
insert into securities(securityId, interestRate, marketPrice, securityName) values(13,FLOOR((RAND()*20)+1),RAND()*(300-10+1)+10,"TEXAS INSTRUMENTS INC");
insert into securities(securityId, interestRate, marketPrice, securityName) values(14,FLOOR((RAND()*20)+1),RAND()*(300-10+1)+10,"STARBUCKS CORP");
insert into securities(securityId, interestRate, marketPrice, securityName) values(15,FLOOR((RAND()*20)+1),RAND()*(300-10+1)+10,"NVIDIA Corporation");

insert into corporate_action(corporateActionId,securityId,action,parameter) values(1,4,"stock-split","5-for-1");
insert into corporate_action(corporateActionId,securityId,action,parameter) values(2,2,"reverse-split","1-for-2");
insert into corporate_action(corporateActionId,securityId,action,parameter) values(3,5,"stock-dividend","5%");
insert into corporate_action(corporateActionId,securityId,action,parameter) values(4,7,"stock-split","5-for-1");
insert into corporate_action(corporateActionId,securityId,action,parameter) values(5,9,"reverse-split","1-for-4");
insert into corporate_action(corporateActionId,securityId,action,parameter) values(6,11,"cash-dividend","7$");
insert into corporate_action(corporateActionId,securityId,action,parameter) values(7,12,"cash-dividend","2$");
insert into corporate_action(corporateActionId,securityId,action,parameter) values(8,3,"stock-dividend","8%");
-- insert into equity_summary values (1,2,1600,0);
-- insert into equity_summary values (1,11,1200,0);
-- insert into equity_summary values (5,2,800,0);
-- insert into equity_summary values (1,4,900,0);
-- insert into equity_summary values (1,6,900,0);

