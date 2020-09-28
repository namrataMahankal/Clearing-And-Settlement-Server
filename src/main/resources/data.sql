insert into clearing_member(clearingMemberId, amountToPay, clearingMemberFundBalance, clearingMemberName) values(1,0,1000,"Citi");
insert into clearing_member(clearingMemberId, amountToPay, clearingMemberFundBalance, clearingMemberName) values(2,0,1000,"JP Morgan Chase");
insert into clearing_member(clearingMemberId, amountToPay, clearingMemberFundBalance, clearingMemberName) values(3,0,1000,"Bank of New York Mellon");
insert into clearing_member(clearingMemberId, amountToPay, clearingMemberFundBalance, clearingMemberName) values(4,0,1000,"State Street Corporation");
insert into clearing_member(clearingMemberId, amountToPay, clearingMemberFundBalance, clearingMemberName) values(5,0,1000,"BNP Paribas Securities Services");
insert into clearing_member(clearingMemberId, amountToPay, clearingMemberFundBalance, clearingMemberName) values(6,0,1000,"HSBC Securities Services");
insert into clearing_member(clearingMemberId, amountToPay, clearingMemberFundBalance, clearingMemberName) values(7,0,1000,"Northern Trust Corporation");
insert into clearing_member(clearingMemberId, amountToPay, clearingMemberFundBalance, clearingMemberName) values(8,0,1000,"UBS AG");
insert into clearing_member(clearingMemberId, amountToPay, clearingMemberFundBalance, clearingMemberName) values(9,0,1000,"Wells Fargo");
insert into clearing_member(clearingMemberId, amountToPay, clearingMemberFundBalance, clearingMemberName) values(10,0,1000,"Credit Suisse");
insert into securities(securityId, interestRate, marketPrice, securityName) values(1,1+RAND(),RAND()*(300-10+1)+10,"Amazon");
insert into securities(securityId, interestRate, marketPrice, securityName) values(2,1+RAND(),RAND()*(300-10+1)+10,"Apple");
insert into securities(securityId, interestRate, marketPrice, securityName) values(3,1+RAND(),RAND()*(300-10+1)+10,"Microsoft");
insert into securities(securityId, interestRate, marketPrice, securityName) values(4,1+RAND(),RAND()*(300-10+1)+10,"UBER");
insert into securities(securityId, interestRate, marketPrice, securityName) values(5,1+RAND(),RAND()*(300-10+1)+10,"FORD Motor Company");
insert into securities(securityId, interestRate, marketPrice, securityName) values(6,1+RAND(),RAND()*(300-10+1)+10,"Tesla Inc.");
insert into securities(securityId, interestRate, marketPrice, securityName) values(7,1+RAND(),RAND()*(300-10+1)+10,"QUALCOMM Inc.");
insert into securities(securityId, interestRate, marketPrice, securityName) values(8,1+RAND(),RAND()*(300-10+1)+10,"AT&T inc");
insert into securities(securityId, interestRate, marketPrice, securityName) values(9,1+RAND(),RAND()*(300-10+1)+10,"Intercontinental Exchange");
insert into securities(securityId, interestRate, marketPrice, securityName) values(10,1+RAND(),RAND()*(300-10+1)+10,"Alphabet Inc.");
insert into securities(securityId, interestRate, marketPrice, securityName) values(11,1+RAND(),RAND()*(300-10+1)+10,"Anheuser Busch Inbev NV");
insert into securities(securityId, interestRate, marketPrice, securityName) values(12,1+RAND(),RAND()*(300-10+1)+10,"WALMART INC");
insert into securities(securityId, interestRate, marketPrice, securityName) values(13,1+RAND(),RAND()*(300-10+1)+10,"TEXAS INSTRUMENTS INC");
insert into securities(securityId, interestRate, marketPrice, securityName) values(14,1+RAND(),RAND()*(300-10+1)+10,"STARBUCKS CORP");
insert into securities(securityId, interestRate, marketPrice, securityName) values(15,1+RAND(),RAND()*(300-10+1)+10,"NVIDIA Corporation");

insert into corporate_action(corporateActionId,securityId,action,parameter) values(1,1+RAND(),"stock-split","5-for-1");
insert into corporate_action(corporateActionId,securityId,action,parameter) values(2,1+RAND(),"reverse-split","1-for-2");
insert into corporate_action(corporateActionId,securityId,action,parameter) values(3,1+RAND(),"stock-dividend","5");
insert into corporate_action(corporateActionId,securityId,action,parameter) values(4,1+RAND(),"stock-split","5-for-1");
insert into corporate_action(corporateActionId,securityId,action,parameter) values(5,1+RAND(),"reverse-split","1-for-4");
insert into corporate_action(corporateActionId,securityId,action,parameter) values(6,1+RAND(),"stock-dividend","8");
insert into equity_summary values (1,2,1600,0);
insert into equity_summary values (1,11,1200,0);
insert into equity_summary values (5,2,800,0);
insert into equity_summary values (1,4,900,0);
insert into equity_summary values (1,6,900,0);

