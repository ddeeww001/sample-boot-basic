## Libary

- books
- members
- categories
- transactions

list all books : GET/books
list all book under categories GET/categories/{id}/books
get member GET/members/{id}
borrow/return POST/members/{id}/transactions

{
member_id:
book_id:
tybe: borrow/return
}

<!--book_id,member_id,...-->
