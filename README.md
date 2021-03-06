MoveIT14
========


```javascript
/* 
 * Schema för produkter
 */

var ProductSchema = new Schema({
	name: String,
	price: Number
});

/* 
 * Schema för kvitton
 */

var ReceiptSchema = new Schema({
  nameOfStore: String,
  products: [{
  	type: Schema.Types.ObjectId, ref:'Product'
  }],
  totalSum: Number
});

/* 
 * Schema för miljöstationer
 */


var StationSchema = new Schema({
  location: String,
  name: String,
  categories: [{
  	type: String
  }]
});


/* 
 * Schema för användare
 */

var UserSchema = new Schema({
  name: String,
  email: { type: String, lowercase: true },
  role: {
    type: String,
    default: 'user'
  },
  hashedPassword: String,
  provider: String,
  salt: String,
  facebook: {},
  twitter: {},
  github: {},
  score: Number,
  level: Number,
  receipts: [{type: Schema.Types.ObjectId, ref: 'Receipt'}],
  coupons: Number
});
```
Controllers

```javascript
/*
 * Visa kvitton med produkter
 */ 

exports.showReciepts = function(req, res) {
  Receipt.find().populate('products').exec(function(err, receipt) {
    if(err) { return handleError(res, err); }
    if(!receipt) { return res.send(404); }
    res.json(receipt);
  });
};
```







