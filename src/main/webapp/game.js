function Map(tiles, width, height) {
	this.tiles = tiles;
	this.width = width;
	this.height = height;
	
	this.render = function render(context) {
		var tile_size = (width/tiles.length);

		for (var xx = 0; xx < tiles.length; ++xx) {
			for (var yy = 0; yy < tiles[0].length; ++yy) {
				if (tiles[yy][xx] == 0) {
					context.fillStyle = "#EEEEEE";
				} else {
					context.fillStyle = "#00FF00";
				}
				context.fillRect(xx*tile_size, yy*tile_size, tile_size, tile_size);
				context.strokeRect(xx*tile_size, yy*tile_size, tile_size, tile_size);
			}
		}
	}
}


function Player(x, y) {
	this.x = x;
	this.y = y;

	this.render = function render(context) {
		context.beginPath();
		context.arc(x, y, 40,0,2*Math.PI);
		context.stroke();
	}
}


function Game(width, height) {
	this.width = width;
	this.height = height;
	this.tiles = [[0,0,0,0],
	     	      [1,0,0,0],
                      [0,0,0,0],
                      [0,0,0,0]];

	this.map = new Map(this.tiles, this.width, this.height);
	this.player = new Player(0, 0);

	this.render = function render() {
		var c = document.getElementById("enigme");
		var ctx = c.getContext("2d");
		
		this.map.render(ctx);
		this.player.render(ctx);
	}
}


var game = new Game(200, 200);
game.render();




