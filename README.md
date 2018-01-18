# ATM Machine
This project is desined as an excercise and is not intended for production purposes.

# Excetcise Details
### Statement
In this assignment you are going to implement an ATM system from which users can manage their accounts. There are two types of users, Customers and Administrators. Both are presented with their own menus (after login of course). Customers can use the system to withdraw cash, transfer cash from one account to another, deposit cash and get their current balance. Administrators can create, delete, view and update accounts of different users. They must also be able to view certain reports about users and accounts. All data should be stored in a flat file system

### Content Requirements
When your program starts, console based, it should be displaying a login screen. User will be asked to enter a login and 5 digit pin code. The system verifies the login and pin and displays an error if it is incorrect. If the user types the pin code incorrectly three times consecutively then the system should disable that login until further notice (i.e. the Administrator changes the status of the user).

Note: The writing in green is entered by the user and input must be through command line. (You CANNOT use JOptionPane etc)

```sh
 Enter login: Adnan123
 Enter Pin code: 12345
```

### Customer Menue 
A customer is then taken to the customer option menu where he will select one of the following options; 

b) Normal Cash

In case of normal cash, the user should be asked the amount he wishes to withdraw. In this case there is no compulsion that the amount should be a multiple of 500. However, the amount must be valid.
```sh
Enter the withdrawal amount: 3650

Cash Successfully Withdrawn!
Do you wish to print a receipt (Y/N)? Y

Account #12
Date: 14/09/2005

Withdrawn: 3650
Balance: 154500
```
To make things a little more interesting, a single account holder cannot withdraw more then 20,000 in one day. (If customer withdraws 15,000 once and tries to withdraw 6,000, customer should not be allowed but customer can withdraw 4,000). Please NOTE that this applies to BOTH Fast Cash and Normal Cash. i.e. the joint withdrawal in both these modes should not exceed 20,000.

2----Cash Transfer

If the user selects transfer cash he is asked to specify the amount in multiples of five hundred that he wishes to transfer. Then he should be asked to enter the account number to which he wishes to transfer the money. The user must be asked to enter the account number twice to make sure he got the correct number. In addition the second time he enters the account number he should also be able to see the name of that account holder to make sure it is the right person.

For example,
```sh
Enter amount in multiples of 500: 3500
Enter the account number to which you want to transfer: 15

You wish to deposit Rs 3,500 in account held by Mr. Usman Ismail; If this information is correct please re-enter the account number: 15

Transaction confirmed.

Do you wish to print a receipt (Y/N)? Y

Account #12
Date: 14/09/2005

Amount Transferred: 3500
Balance: 154500
```
3----Deposit Cash

If the user selects deposit cash he is asked to specify the amount that he wishes to deposit into the account. Of course there is no max limit to how much money is deposited. E.g:
```sh
Enter the cash amount to deposit: 12562

Cash Deposited Successfully.
Do you wish to print a receipt (Y/N)? Y

Account #12
Date: 14/09/2005

Deposited: 12562
Balance: 154500
```
4----Display Balance

This obviously displays the balance on the screen. It is similar to receipt (i.e. it has date account number etc) but it does not have any transactions. 
For example:
```sh
Account #12
Date: 14/09/2005

Balance: 154,500
```

### Administrator Menu
If the user who logs in is an administrator he should be presented with the following menu,
```sh
1----Create New Account.
2----Delete Existing Account.
3----Update Account Information.
4----Search for Account.
5----View Reports
6----Exit
```

1----Create New Account

If the user selects this option then he is asked to enter account information. One piece of information at a time and the screen should be cleared after each entry. The system should check the validity of the data i.e. type can only be ‘Savings’ or ‘Current’.
```sh
Login: Usman123
Pin Code: 12345
Holders Name: Usman Ismail
Type (Savings,Current): Savings
Starting Balance: 6000
Status: Active
```
Obviously, an account number has to be assigned to this newly created account. For this purpose, you are required to check the last account number created and add one to it. So, if there exists an account number 18 in the file (and there is no Account # 19) , then 19 should be account number attributed to this account. The administrator must be informed of this after he finishes making the account i.e.
```sh
Account Successfully Created – the account number assigned is: 19
```

2---Delete Existing Account

If the user selects this option he is asked to enter an account number. He is then asked confirm that this account should be deleted.
```
Enter the account number to which you want to delete: 15

You wish to delete the account held by Mr Usman Ismail; If this information is correct please re-enter the account number: 15

Account Deleted Successfully
```
3---Update Account Information

The program should first ask the admin to enter the account number to be updated:
```sh
Enter the Account Number: 15
```
Then, a menu should be displayed which shows the admin all the old information followed by a step-by-step inquiry to change particular fields. If he leaves a field blank then the old information is propagated i.e. the previous information remains unchanged. (Again, the screen should be cleared after each entry.)
```sh
Account # 15 
Type: Savings
Holder: Mr Usman Ismail
Balance: 50,000
Status: Disabled

Please enter in the fields you wish to update (leave blank otherwise):

Login: Usman456
Pin Code: 45678
Holders Name:     (for example, I leave this blank and simply press enter)

Status: Active

Your account has been successfully been updated.
```
4---Search for Account

This will display a menu asking the admin to enter any search criteria for each field. If the user leaves a field blank then it should not be included in the search i.e. if user does not specify holder name then all accounts matching other criteria with any holder name should be displayed. 
```sh
SEARCH MENU:

Account ID:
User ID:
Holders Name:
Type (Savings Current): Savings
Balance: 80,000
Status: Active

==== SEARCH RESULTS ======

Account ID  User ID  Holders Name   Type    Balance  Status 

15          44045    Usman Ismail  Savings  80,000   Active
18          43075    M. Adnan      Savings  80,000   Active
```
Please note that this search is done by ‘AND’ing the search criterias i.e. an account’s information should be listed in the search results if an only if all the search criteria’s are met.

5---View Reports

If the user selects view reports then the he should be asked to specify one of two reports; For the first (by amount) the user will specify a minimum and maximum range for the balance of an account. All accounts with balance in between the range must be displayed in a similar fashion to the one shown above in search for accounts. In the second option the system shows all transactions made by a specified customer within a specified date range (inclusive). i.e. The user enters an account number and a minimum and maximum date. All transactions between the two dates need to be shown.
```sh
1---Accounts By Amount
2---Accounts By Date

For example, if the user enters 1:

Enter the minimum amount: 12500
Enter the maximum amount: 190112

==== SEARCH RESULTS ======

Account ID   User ID  Holders Name	  Type  Balance   Status 

11           44045    Bob Jack     Savings 12,500    Active
24           43075    Rahul Dravid Savings 190,111   Active
```

Or if the user enters 2:
Note: The format for the date must always be Day/Month/Year [DD/MM/YYYY] 
```sh
Enter the starting date: 12/12/2005 
Enter the ending date: 19/12/2005

==== SEARCH RESULTS ======

Transaction Type   User ID  Holders Name   Amount   Date 
Cash Withdrawal    44045    Bob Jack       2,500 17/12/2005    
```

### Design Cues and Requirements
*	Use flat file systems to store all data. The format of the files is given below but broadly you should have one file for login information (login, pin code and user type) another file for user information and a third for transaction data. 

*	You should also have four classes; Account Transaction, Interface and a super class encapsulation all other classes. 
*	Make sure you separate the implementation from the interface completely
*	All data entry points should have proper error checks and error messages.
*	All data entry is through command line interface.
*	There must be proper commenting through out your code and you have to generate Java Doc for your assignment.
*	We expect that your system should be very robust, so apply intelligent checks; in no case should your program crash or produce undesirable results.
*	Use Function and Variable names intelligently. The harder your code is to check, the higher are the chances of you getting lower marks. If your program crashes for some reason during checking, TA’s will be just scrolling through your code and give you marks on the quality of the code. So, it’s purely in your interest to use nice functions and variables names.

### File Names to Use
 (account.txt)
< User ID>;<Account ID>;< Holders Name>; <Type>;< Balance:>; <Status>

(login.txt)
<User ID>;<Login>;<Pin code>

You have to figure out on your own, the design of your transaction.txt file.

One more Functionality
However the login file must be encrypted when it is stored to disk and decrypted when it is needed. We are going to use a very simple encryption technique which is as follows. 

For alphabets we swap A with Z, B with Y and so on.
A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
Z Y X W V U T S R Q P O N M L K J I H G F E D C B A

For Number we have
0123456789
9876543210
