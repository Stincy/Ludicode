var speed = 10;


function Map(game, tiles, width, height) {
	this.game = game;
	this.tiles = tiles;
	this.width = width;
	this.height = height;
	this.tile_size = (width/tiles.length);
	
	this.render = function render(context) {
		for (var xx = 0; xx < tiles.length; ++xx) {
			for (var yy = 0; yy < tiles[0].length; ++yy) {
				if (tiles[yy][xx] == 0) {
					context.fillStyle = "#EEEEEE";
				} else {
					context.fillStyle = "#00FF00";
				}
				context.fillRect(xx*this.tile_size, yy*this.tile_size, this.tile_size, this.tile_size);
				context.strokeRect(xx*this.tile_size, yy*this.tile_size, this.tile_size, this.tile_size);
			}
		}
	}

	this.update = function update(delta) {

	}
}

function Player(game, x, y) {
	this.x = x;
	this.y = y;
	this.game = game;

	var goToX = x;
	var goToY = y;

	this.render = function render(context) {
		context.beginPath();
		context.arc(this.x+this.game.map.tile_size/2, this.y+this.game.map.tile_size/2, this.game.map.tile_size/2 - 4,0 , 2*Math.PI);
		context.fillStyle = "#FF0000";
		context.fill();
	}

	this.update = function update(delta) {
		if (Math.abs(goToX - this.x) > 2) {
			var xsign = 1;
			if (goToX - this.x < 0) xsign = -1;

			this.x += 10 * delta * speed * xsign;
		} else {
			this.x = goToX;
		}
		
		if (Math.abs(goToY - this.y) > 2) {
			var ysign = 1;
			if (goToY - this.y < 0) ysign = -1;

			this.y += 10 * delta * speed * ysign;
		} else {
			this.y = goToY;
		}
	
	}

	this.moveTo = function moveTo(x, y) {
		goToX = x;
		goToY = y;
	}

	this.moveToTile = function moveToTile(x, y) {
		this.moveTo(x * this.game.map.tile_size, y * this.game.map.tile_size);
	}

	this.tileX = function tileX() {
		return Math.round(this.x/this.game.map.tile_size);
	}

	this.tileY = function tileY() {
		return Math.round(this.y/this.game.map.tile_size);
	}

	
}


function Game(width, height) {
	this.width = width;
	this.height = height;
	this.tiles = [[0,0,0,0],
	     	      [1,0,0,0],
                      [0,0,0,0],
                      [0,0,0,0]];


	this.map = new Map(this, this.tiles, this.width, this.height);
	this.player = new Player(this, 0, 0);

	this.render = function render() {
		var c = document.getElementById("enigme");
		var ctx = c.getContext("2d");
		
		this.map.render(ctx);
		this.player.render(ctx);
	}

	this.update = function update(delta) {
		this.map.update(delta);
		this.player.update(delta);
		this.render();
	}
}

var game = new Game(200, 200);

var time;
function mainLoop() {
	requestAnimationFrame(mainLoop);
	var now = new Date().getTime(),
	dt = (now - (time || now))/1000;

	time = now;
	game.update(dt);
}

function droite() game.player.moveToTile(game.player.tileX()+1, game.player.tileY());
function gauche() game.player.moveToTile(game.player.tileX()-1, game.player.tileY());

function executeAlgo() {
	eval($("#algo").val());
}

mainLoop();




