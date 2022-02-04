# Pictures

We have a franchise of shops of iligal paintings, that simulates it sells white necklaces, as the shop's name.
This franchise has several shops, each one with a name and a maxim capacity of paintings (or necklaces).

There are paintings that have author's name, others are anonimous, but all have name, price and entry date (the 
date of the moment the painting cames in the shop).

The client wants to implement an API with Spring with the followinf functionalities:

- POST/shops/: creates a shop, with name and capacity
- GET/shops/: lists shops, returns a list of shops with its name and capacity
- POST/shops{ID}/pictures: adds a painting, with the name of the painting and the author
- GET/shops/{ID}/pictures: list the shop's paintings
- DELETE/shops/{ID}/pictures: sets fire to the paintings, in case the police comes, all paintings can be eliminated
without trail.
