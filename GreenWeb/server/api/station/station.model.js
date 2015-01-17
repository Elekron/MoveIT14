'use strict';

var mongoose = require('mongoose'),
    Schema = mongoose.Schema;

/*
 * Schema för miljöstationer
 */

var StationSchema = new Schema({
  location: String,
  _stationId: Schema.Types.ObjectId,
  name: String,
  categories: [{
  	name: String
  }]
});

module.exports = mongoose.model('Station', StationSchema);