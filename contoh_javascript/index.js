const axios = require('axios');

class Item {
	constructor(id, name, price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
}

class User {
	constructor(id, username, password) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.cart = [];
	}
}

let item1 = new Item(1, 'HP Samsung', 10000000);
let item2 = new Item(1, 'HP Apple', 10000000);
let item3 = new Item(1, 'HP Vivo', 10000000);
let item4 = new Item(1, 'HP Oppo', 10000000);

let cart = [];

cart.push(item1);
cart.push(item2);
cart.push(item3);
cart.push(item4);

console.log(cart);

async function getData() {
	try {
		const response = await axios('https://api.spacexdata.com/v3/missions');
		console.log(response.data);
	} catch (error) {
		console.log(error);
	}
}

getData();
