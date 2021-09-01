INSERT INTO  customer  ( customer_id, name , email , mobile_number ,  pwd ,  role , create_dt )
 VALUES (1, 'Happy','happy@example.com','9876548337', '$2y$12$oRRbkNfwuR8ug4MlzH5FOeui.//1mkd.RsOAJMbykTSupVy.x/vb2', 'admin',CURRENT_DATE);
select * from customer;

select * from accounts;
 INSERT INTO  accounts  ( customer_id ,  account_number ,  account_type ,  branch_address ,  create_dt )
 VALUES (1, 186576453434, 'Savings', '123 Main Street, New York', CURRENT_DATE);
 

select * from account_transactions;
alter table account_transactions drop column transaction_summery;

 INSERT INTO  account_transactions  ( transaction_id ,  account_number ,  customer_id ,  transaction_dt ,  transaction_summary ,  transaction_type , transaction_amt , 
 closing_balance ,  create_dt )  VALUES ('001', 186576453434, 1, CURRENT_DATE-7, 'Coffee Shop', 'Withdrawal', 30,34500,CURRENT_DATE-7);

INSERT INTO  account_transactions  ( transaction_id ,  account_number ,  customer_id ,  transaction_dt ,  transaction_summary ,  transaction_type , transaction_amt , 
 closing_balance ,  create_dt )  VALUES ('002', 186576453434, 1, CURRENT_DATE-6, 'Uber', 'Withdrawal', 100,34400,CURRENT_DATE-6);

INSERT INTO  account_transactions  ( transaction_id ,  account_number ,  customer_id ,  transaction_dt ,  transaction_summary ,  transaction_type , transaction_amt , 
 closing_balance ,  create_dt )  VALUES ('003', 186576453434, 1, CURRENT_DATE-5, 'Self Deposit', 'Deposit', 500,34900,CURRENT_DATE-5);

INSERT INTO  account_transactions  ( transaction_id ,  account_number ,  customer_id ,  transaction_dt ,  transaction_summary ,  transaction_type , transaction_amt , 
 closing_balance ,  create_dt )  VALUES ('004', 186576453434, 1, CURRENT_DATE-4, 'Ebay', 'Withdrawal', 600,34300,CURRENT_DATE-4);

INSERT INTO  account_transactions  ( transaction_id ,  account_number ,  customer_id ,  transaction_dt ,  transaction_summary ,  transaction_type , transaction_amt , 
 closing_balance ,  create_dt )  VALUES ('005', 186576453434, 1, CURRENT_DATE-2, 'OnlineTransfer', 'Deposit', 700,35000,CURRENT_DATE-2);

INSERT INTO  account_transactions  ( transaction_id ,  account_number ,  customer_id ,  transaction_dt ,  transaction_summary ,  transaction_type , transaction_amt , 
 closing_balance ,  create_dt )  VALUES ('006', 186576453434, 1, CURRENT_DATE-1, 'Amazon.com', 'Withdrawal', 100,34900,CURRENT_DATE-1);


INSERT INTO  loans  (  loan_number, customer_id ,  start_dt ,  loan_type ,  total_loan ,  amount_paid ,  outstanding_amount ,  create_dt )
 VALUES ( 1, 1, '2020-10-13', 'Home', 200000, 50000, 150000, '2020-10-13');
 
INSERT INTO  loans  (  loan_number, customer_id ,  start_dt ,  loan_type ,  total_loan ,  amount_paid ,  outstanding_amount ,  create_dt )
 VALUES ( 2, 1, '2020-06-06', 'Vehicle', 40000, 10000, 30000, '2020-06-06');
 
INSERT INTO  loans  ( loan_number, customer_id ,  start_dt ,  loan_type ,  total_loan ,  amount_paid ,  outstanding_amount ,  create_dt )
 VALUES (3,  1, '2018-02-14', 'Home', 50000, 10000, 40000, '2018-02-14');

INSERT INTO  loans  (loan_number,  customer_id ,  start_dt ,  loan_type ,  total_loan ,  amount_paid ,  outstanding_amount ,  create_dt )
 VALUES ( 4, 1, '2018-02-14', 'Personal', 10000, 3500, 6500, '2018-02-14');
select * from loans;
 
 INSERT INTO  cards  ( card_id, card_number ,  customer_id ,  card_type ,  total_limit ,  amount_used ,  available_amount ,  create_dt )
 VALUES (1, '4565XXXX4656', 1, 'Credit', 10000, 500, 9500, CURRENT_DATE);

INSERT INTO  cards  (card_id,  card_number ,  customer_id ,  card_type ,  total_limit ,  amount_used ,  available_amount ,  create_dt )
 VALUES (2, '3455XXXX8673', 1, 'Credit', 7500, 600, 6900, CURRENT_DATE);
 
INSERT INTO  cards  (card_id, card_number ,  customer_id ,  card_type ,  total_limit ,  amount_used ,  available_amount ,  create_dt )
 VALUES (3, '2359XXXX9346', 1, 'Credit', 20000, 4000, 16000, CURRENT_DATE);

 
 INSERT INTO  notice_details  (  notice_id, notice_summary ,  notice_details ,  notic_beg_dt ,  notic_end_dt ,  create_dt ,  update_dt )
VALUES (1, 'Home Loan Interest rates reduced', 'Home loan interest rates are reduced as per the goverment guidelines. The updated rates will be effective immediately', 
'2020-10-14', '2020-11-30', CURRENT_DATE, null);

INSERT INTO  notice_details  ( notice_id,  notice_summary ,  notice_details ,  notic_beg_dt ,  notic_end_dt ,  create_dt ,  update_dt )
VALUES (2, 'Net Banking Offers', 'Customers who will opt for Internet banking while opening a saving account will get a $50 amazon voucher', 
'2020-10-14', '2020-12-05', CURRENT_DATE, null);

INSERT INTO  notice_details  ( notice_id,  notice_summary ,  notice_details ,  notic_beg_dt ,  notic_end_dt ,  create_dt ,  update_dt )
VALUES (3, 'Mobile App Downtime', 'The mobile application of the EazyBank will be down from 2AM-5AM on 12/05/2020 due to maintenance activities', 
'2020-10-14', '2020-12-01', CURRENT_DATE, null);

INSERT INTO  notice_details  ( notice_id,  notice_summary ,  notice_details ,  notic_beg_dt ,  notic_end_dt ,  create_dt ,  update_dt )
VALUES (4, 'E Auction notice', 'There will be a e-auction on 12/08/2020 on the Bank website for all the stubborn arrears.Interested parties can participate in the e-auction', 
'2020-10-14', '2020-12-08', CURRENT_DATE, null);
   
INSERT INTO  notice_details  (notice_id,   notice_summary ,  notice_details ,  notic_beg_dt ,  notic_end_dt ,  create_dt ,  update_dt )
VALUES (5, 'Launch of Millennia Cards', 'Millennia Credit Cards are launched for the premium customers of EazyBank. With these cards, you will get 5% cashback for each purchase', 
'2020-10-14', '2020-11-28', CURRENT_DATE, null);

INSERT INTO  notice_details  (notice_id,   notice_summary ,  notice_details ,  notic_beg_dt ,  notic_end_dt ,  create_dt ,  update_dt )
VALUES (6, 'COVID-19 Insurance', 'EazyBank launched an insurance policy which will cover COVID-19 expenses. Please reach out to the branch for more details', 
'2020-10-14', '2020-12-31', CURRENT_DATE, null);

INSERT INTO  authorities  (id, customer_id ,  name )
 VALUES (1, 1, 'READ');
 
INSERT INTO  authorities  ( id, customer_id ,  name )
 VALUES (2, 1, 'WRITE');
 
select * from authorities a;
UPDATE authorities SET name='ROLE_USER' WHERE id=1;
UPDATE authorities SET name='ROLE_ADMIN' WHERE id=2;