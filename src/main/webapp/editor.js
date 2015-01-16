/*************************************
				MAP
**************************************/
function Map(tileWidth, tileHeight, width, height) {
	this.tiles = [];
	this.tileWidth = tileWidth;
	this.tileHeight = tileHeight;
	this.width = width;
	this.height = height;
	this.tile_size = (width/tileWidth);
	
	var overTileX = -1;
	var overTileY = -1;
	
	var canvas = document.getElementById("map");
	
	canvas.addEventListener("mousedown", doMouseDown, false);
	
	var tilesColors = ["#EEEEEE", "#222222", "#EEEEEE", "#FFFF00", "#55FF55"]
	var self = this;
	
	this.render = function render() {
		var context = canvas.getContext("2d");
		for (var xx = 0; xx < this.tileWidth; ++xx) {
			for (var yy = 0; yy < this.tileHeight; ++yy) {
				var id = this.tiles[yy]
				if (id == null) {
					id = 0;
				} else {
					id = this.tiles[yy][xx];
				}
				
				context.fillStyle = "#EEEEEE";
				if (id < tilesColors.length) {
					context.fillStyle = tilesColors[id];
				}
				
				context.fillRect(xx*this.tile_size, yy*this.tile_size, this.tile_size, this.tile_size);
				context.strokeRect(xx*this.tile_size, yy*this.tile_size, this.tile_size, this.tile_size);
				
				if (id == 2) {
					context.beginPath();
					context.arc(xx*this.tile_size+this.tile_size/2, yy*this.tile_size+this.tile_size/2, this.tile_size/2 - 4,0 , 2*Math.PI);
					context.fillStyle = "#FF0000";
					context.fill();
				}
			}
		}
	}
	
	this.toString = function toString() {
		var str = "";
		
		for (var yy = 0; yy < this.tileHeight; ++yy) {
			for (var xx = 0; xx < this.tileWidth; ++xx) {
				var id = this.tiles[yy]
				if (id == null) {
					id = 0;
				} else {
					id = this.tiles[yy][xx];
					if (id == null) {
						id = 0;
					}
				}
				
				str += id;
				if (xx < this.tileWidth-1) {
					str += ",";
				}
			}
			str += "|";
		}
		
		return str;
	}
	
	function getTileX(x) {
		return Math.floor(x/self.tile_size);
	}
	
	function getTileY(y) {
		return Math.floor(y/self.tile_size);
	}
	
	function doMouseDown(e) {
		// Parceque change selon les navigateurs
		var mouseX  = (e.offsetX || e.clientX - $(e.target).offset().left);
		var mouseY  = (e.offsetY || e.clientY - $(e.target).offset().top);
		
		overTileX = getTileX(mouseX);
	    overTileY = getTileY(mouseY);
		
		if (self.tiles[overTileY] == null) {
			self.tiles[overTileY] = [];
		}
		self.tiles[overTileY][overTileX] = parseInt($('input[name="tile"]:checked').val());
		self.render();
	}
}


var map = new Map(5, 5, 200, 200);
map.render();


function save() {
	alert(map.toString());
}