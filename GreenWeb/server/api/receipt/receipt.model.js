'use strict';

var mongoose = require('mongoose'),
    Schema = mongoose.Schema;

/*
 * Schema för det digitala kvittot
 */

var ReceiptSchema = new Schema({
  nameOfStore: String,
  products: [{
  	type: Schema.Types.ObjectId, ref:'Product'
  }],
  totalSum: Number
  //user: {type: Schema.Types.ObjectId, ref:'User'}
});

/*
var productSchema = new Schema({
	name: String,
	price: Number
});
*/

module.exports = mongoose.model('Receipt', ReceiptSchema);